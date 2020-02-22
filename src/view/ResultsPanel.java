package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controller.ResultsController;
import model.Championship;
import model.Matchup;

public class ResultsPanel extends JPanel {

	private static final long serialVersionUID = 2767512105398842253L;

	private JComboBox<String> weekSelector;
	private JPanel menu, body, top, bottom;
	private Championship champ;

	// TODO add menu above -> and new JPanel for bottom
		
	public ResultsPanel(Championship champ) {

		this.setLayout(new BorderLayout());
		
		menu = new MenuPanel();
		this.add(menu, BorderLayout.NORTH);
		
		body = new JPanel();
		body.setLayout(new BorderLayout());

		this.champ = champ;
		int length = champ.getLength();

		int currentWeek = length-1; // show last week by default
		for (int w=0; w<length; w++) {
			for (int i=0; i<champ.getSize()/2; i++) {
				if (!champ.getWeek(w).getMatchups(i).isPlayed()) {
					currentWeek = w;
					w = length; // break outside the w loop
					break;
				}
			}
		}

		// TODO add scroller for week selection with correct default value

		top = new JPanel();

		String[] weeks = new String[length];
		for (int w=0; w<length; w++) {
			weeks[w] = "Week "+(w+1);
		}
		weekSelector = new JComboBox<String>(weeks);
		weekSelector.setSelectedItem("Week "+(currentWeek+1));

		JButton selectWeek = new JButton("Select");
		selectWeek.addActionListener(e -> selectWeekAction(weekSelector, this));

		top.add(weekSelector);
		top.add(selectWeek);
		body.add(top, BorderLayout.NORTH);

		// TODO displays first week with missing scores, otherwise the last week
		// TODO for each game, add option for editing score
		bottom = displayWeek(champ, currentWeek);
		body.add(bottom, BorderLayout.CENTER);
		
		this.add(body, BorderLayout.CENTER);

	}

	private JPanel displayWeek (Championship champ, int week) {
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

	private JPanel displayGame (Matchup game, JPanel gamePanel) {
		JLabel label = new JLabel(game.toString());
		JButton setResult = new JButton ("Set result");
		setResult.addActionListener(e -> setResultAction(game, gamePanel));
		JButton cancelResult = new JButton ("Cancel result");
		cancelResult.addActionListener(e -> cancelResultAction(game, gamePanel));
		gamePanel.add(label);
		gamePanel.add(setResult);
		gamePanel.add(cancelResult);
		return gamePanel;
	}

	private void selectWeekAction(JComboBox<String> cb, JPanel panel) {
		String s = (String) cb.getSelectedItem();
		int week = Integer.parseInt(s.split(" ")[1]);
		week--; // remove 1 because index starts at 0 instead of 1 in display
		panel.remove(bottom);
		panel.validate();
		bottom = displayWeek(champ, week);
		panel.add(bottom, BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
	}

	private void setResultAction(Matchup game, JPanel panel) {
		// TODO
		// create box
		JTextField homeField, awayField;
		JPanel fieldPanel;
		boolean validated = false;

		do {
			fieldPanel = new JPanel();
			homeField = new JTextField(3);
			awayField = new JTextField(3);
			fieldPanel.add(new JLabel(game.getHome_team().getName()));
			fieldPanel.add(homeField);
			fieldPanel.add(Box.createHorizontalStrut(10));
			fieldPanel.add(new JLabel(game.getAway_team().getName()));
			fieldPanel.add(awayField);
			String message = "Enter score for both teams.";

			int result = JOptionPane.showConfirmDialog(bottom, fieldPanel, message, JOptionPane.OK_CANCEL_OPTION);
			if (result != JOptionPane.OK_OPTION) {
				return;
			}
			validated = ResultsController.isValid(homeField, awayField);
			if (!validated)
				JOptionPane.showConfirmDialog(bottom, "Invalid values, try again.");
		} while (!validated);
		// validation of values

		// update db
		int homeScore = Integer.parseInt(homeField.getText());
		int awayScore = Integer.parseInt(awayField.getText());
		game.playGame(homeScore, awayScore);
		// update display
		panel.removeAll();
		panel.validate();
		panel = displayGame(game, panel);
		panel.revalidate();
		panel.repaint();
	}

	private void cancelResultAction(Matchup game, JPanel panel) {		
		// cancel result in db
		game.cancelResult();
		// update display
		panel.removeAll();
		panel.validate();
		panel = displayGame(game, panel);
		panel.revalidate();
		panel.repaint();
	}

}
