package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controller.ResultsController;
import model.Championship;
import model.Matchup;

public class ResultsPanel extends JPanel {

	private static final long serialVersionUID = 2767512105398842253L;

	public JComboBox<String> weekSelector;
	public JPanel menu, body, top, bottom;
	public Championship champ;
	private ResultsController controller;

	public ResultsPanel(Championship champ) {

		controller = new ResultsController(this);
		
		this.setLayout(new BorderLayout());
		
		menu = new MenuPanel();
		this.add(menu, BorderLayout.NORTH);
		
		body = new JPanel();
		body.setLayout(new BorderLayout());

		this.champ = champ;
		int length = champ.getLength();

		// show first week with missing result
		// show last week by default
		int currentWeek = length-1;
		for (int w=0; w<length; w++) {
			for (int i=0; i<champ.getSize()/2; i++) {
				if (!champ.getWeek(w).getMatchups(i).isPlayed()) {
					currentWeek = w;
					w = length; // break outside the w loop
					break;
				}
			}
		}

		top = new JPanel();

		String[] weeks = new String[length];
		for (int w=0; w<length; w++) {
			weeks[w] = "Week "+(w+1);
		}
		weekSelector = new JComboBox<String>(weeks);
		weekSelector.setSelectedItem("Week "+(currentWeek+1));
		weekSelector.addActionListener(e -> controller.selectWeekAction());

		top.add(weekSelector);
		body.add(top, BorderLayout.NORTH);

		bottom = displayWeek(champ, currentWeek);
		body.add(bottom, BorderLayout.CENTER);
		
		this.add(body, BorderLayout.CENTER);

	}

	public JPanel displayWeek (Championship champ, int week) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		for (int i=0; i<champ.getSize()/2; i++) {
			Matchup game = champ.getWeek(week).getMatchups(i);
			JPanel gamePanel = new JPanel();
			gamePanel = displayGame(game, gamePanel);
			panel.add(gamePanel);
		}
		return panel;		
	}

	public JPanel displayGame (Matchup game, JPanel gamePanel) {
		JLabel label = new JLabel(game.toString());
		JButton setResult = new JButton ("Set result");
		setResult.addActionListener(e -> controller.setResultAction(game, gamePanel));
		JButton cancelResult = new JButton ("Cancel result");
		cancelResult.addActionListener(e -> controller.cancelResultAction(game, gamePanel));
		gamePanel.add(label);
		gamePanel.add(setResult);
		gamePanel.add(cancelResult);
		return gamePanel;
	}

}
