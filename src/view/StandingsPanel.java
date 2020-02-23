package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Championship;
import model.standings.Ranking;
import model.standings.SortingCriteria;
import model.standings.Standings;
import model.standings.pointmodel.ClassicPointModel;
import model.standings.pointmodel.PointModel;

public class StandingsPanel extends JPanel {

	private static final long serialVersionUID = -6893649172190929465L;

	private JPanel menu, body;
	private JPanel optionPanel, sortPanel, weekPanel;
	private JPanel tablePanel;
	private JComboBox<SortingCriteria> criteriaSelector;
	private JComboBox<String> sortSelector;
	private JComboBox<String> startWeekSelector, endWeekSelector;
	//private Championship champ;
	private int startWeek, endWeek;
	private ArrayList<Ranking> rankings;
	private PointModel pModel;

	public StandingsPanel(Championship champ) {

		// TODO rank all players

		pModel = new ClassicPointModel();

		this.setLayout(new BorderLayout());

		menu = new MenuPanel();
		this.add(menu, BorderLayout.NORTH);

		body = new JPanel();
		body.setLayout(new BorderLayout());

		//this.champ = champ;
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
		Standings stand = new Standings(champ,pModel, null, startWeek, endWeek);
		rankings = stand.generateRankings();

		optionPanel = new JPanel();
		optionPanel.setLayout(new BorderLayout());

		sortPanel = new JPanel();
		// scroller to select criteria
		SortingCriteria[] criteriaList = SortingCriteria.values();
		criteriaSelector = new JComboBox<SortingCriteria>(criteriaList);
		criteriaSelector.setSelectedItem(SortingCriteria.POINTS);
		criteriaSelector.addActionListener(e -> criteriaSelectorAction());;
		// scroller if ascending or descending
		String[] sortList = {"Ascending", "Descending"};
		sortSelector = new JComboBox<String>(sortList);
		sortSelector.setSelectedItem("Descending");
		// button to validate
		JButton confirmButton = new JButton("Sort");
		confirmButton.addActionListener(e -> confirmAction());
		
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
		startWeekSelector.addActionListener(e -> startSelectorAction());
		endWeekSelector = new JComboBox<String>(weeks);
		endWeekSelector.setSelectedItem("Week "+(endWeek+1));
		endWeekSelector.addActionListener(e -> endSelectorAction());
		weekPanel.add(new JLabel("Start week"));
		weekPanel.add(startWeekSelector);
		weekPanel.add(Box.createHorizontalStrut(10));
		weekPanel.add(new JLabel("End week"));
		weekPanel.add(endWeekSelector);
		optionPanel.add(weekPanel, BorderLayout.CENTER);

		body.add(optionPanel, BorderLayout.NORTH);

		tablePanel = createTable();
		// TODO table with all standings sorted by criteria then rank

		this.add(body, BorderLayout.CENTER);
	}

	private JPanel createTable() {
		// TODO table from selected criteria
		return null;
	}

	private void criteriaSelectorAction () {
		SortingCriteria sc = (SortingCriteria) criteriaSelector.getSelectedItem();
		if (SortingCriteria.isGAgainst(sc))
			sortSelector.setSelectedItem("Ascending");
		else
			sortSelector.setSelectedItem("Descending");
	}

	private void startSelectorAction() {
		String str = (String) startWeekSelector.getSelectedItem();
		// remove 1 because index starts at 0
		startWeek = Integer.parseInt(str.split(" ")[1]) + 1;
		if (startWeek > endWeek)
			endWeekSelector.setSelectedItem(str);			
	}
	private void endSelectorAction() {
		String str = (String) endWeekSelector.getSelectedItem();
		// remove 1 because index starts at 0
		endWeek = Integer.parseInt(str.split(" ")[1]) + 1;
		if (endWeek < startWeek)
			startWeekSelector.setSelectedItem(str);			
	}
	private void confirmAction() {
		// TODO
	}

}
