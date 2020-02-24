package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.TableColumn;

import controller.StandingsController;
import model.Championship;
import model.standings.Ranking;
import model.standings.SortingCriteria;
import model.standings.StandingComparator;
import model.standings.Standings;

public class StandingsPanel extends JPanel {

	private static final long serialVersionUID = -6893649172190929465L;

	public JPanel menu, body;
	private JPanel optionPanel, sortPanel, weekPanel;
	public JPanel tablePanel;
	public JComboBox<SortingCriteria> criteriaSelector;
	public JComboBox<String> sortSelector;
	public JComboBox<String> startWeekSelector, endWeekSelector;
	public Championship champ;
	public int startWeek, endWeek;
	public ArrayList<Ranking> rankings;
	private StandingsController controller;

	public StandingsPanel(Championship champ) {
		
		controller = new StandingsController(this);
		
		this.setLayout(new BorderLayout());

		menu = new MenuPanel();
		this.add(menu, BorderLayout.NORTH);

		body = new JPanel();
		body.setLayout(new BorderLayout());

		this.champ = champ;
		int length = champ.getLength();

		// by default : from week 1 to last week with played game (def week 1)
		startWeek = 0;
		endWeek = 0;
		for (int w=length-1; w>=0; w--) {
			for (int i=0; i<champ.getSize()/2; i++) {
				if (champ.getWeek(w).getMatchups(i).isPlayed()) {
					endWeek = w;
					w = -1; // break outside the w loop
					break;
				}
			}
		}

		// generate rankings
		this.generateRankings();

		optionPanel = new JPanel();
		optionPanel.setLayout(new BorderLayout());

		sortPanel = new JPanel();
		// scroller to select criteria
		SortingCriteria[] criteriaList = SortingCriteria.values();
		criteriaSelector = new JComboBox<SortingCriteria>(criteriaList);
		criteriaSelector.setSelectedItem(SortingCriteria.POINTS);
		criteriaSelector.addActionListener(e -> controller.criteriaSelectorAction());;
		// scroller if ascending or descending
		String[] sortList = {"Ascending", "Descending"};
		sortSelector = new JComboBox<String>(sortList);
		sortSelector.setSelectedItem("Descending");
		// button to validate
		JButton confirmButton = new JButton("Sort");
		confirmButton.addActionListener(e -> controller.confirmAction());
		
		sortPanel.add(new JLabel("Sort by"));
		sortPanel.add(criteriaSelector);
		sortPanel.add(sortSelector);
		sortPanel.add(Box.createHorizontalStrut(30));
		sortPanel.add(confirmButton);
		optionPanel.add(sortPanel, BorderLayout.NORTH);

		// TODO scrollers from week n to week n
		weekPanel = new JPanel();
		String[] weeks = new String[length];
		for (int w=0; w<length; w++) {
			weeks[w] = "Week "+(w+1);
		}
		startWeekSelector = new JComboBox<String>(weeks);
		startWeekSelector.setSelectedItem("Week 1");
		startWeekSelector.addActionListener(e -> controller.startSelectorAction());
		endWeekSelector = new JComboBox<String>(weeks);
		endWeekSelector.setSelectedItem("Week "+(endWeek+1));
		endWeekSelector.addActionListener(e -> controller.endSelectorAction());
		weekPanel.add(new JLabel("Start week"));
		weekPanel.add(startWeekSelector);
		weekPanel.add(Box.createHorizontalStrut(10));
		weekPanel.add(new JLabel("End week"));
		weekPanel.add(endWeekSelector);
		optionPanel.add(weekPanel, BorderLayout.CENTER);

		body.add(optionPanel, BorderLayout.NORTH);

		tablePanel = createTable();
		body.add(tablePanel);

		this.add(body, BorderLayout.CENTER);
	}

	
	public void generateRankings() {
		Standings stand = new Standings(champ, startWeek, endWeek);
		rankings = stand.generateRankings();
		champ.getTiebreaker().sort(rankings);
	}

	public JPanel createTable() {

		// get selected criteria (initialized before)
		SortingCriteria sc = (SortingCriteria) criteriaSelector.getSelectedItem();
		rankings.sort(new StandingComparator(sc));
		if (sortSelector.getSelectedItem().equals("Descending"))
			Collections.reverse(rankings);

		JPanel panel = new JPanel();
		// nb of columns : rank + name + all criterias
		String[] columnNames = new String[SortingCriteria.values().length + 2];
		columnNames[0] = "Rank";
		columnNames[1] = "Team";
		// TODO ranking to table
		SortingCriteria[] scTab = SortingCriteria.values();
		for (int i=0; i<scTab.length; i++)
			columnNames[i+2] = scTab[i].getAbreviated();
		Object[][] data = new Object[champ.getSize()][columnNames.length];
		for (int i=0; i<rankings.size(); i++)
			data[i] = rankings.get(i).toTable();
		JTable table = new JTable(data, columnNames);
		TableColumn column = null;
		for (int i=0; i<columnNames.length; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 1)
				column.setPreferredWidth(120);
			else
				column.setPreferredWidth(40);
		}
		panel.add(table);
		
		return panel;
	}

}
