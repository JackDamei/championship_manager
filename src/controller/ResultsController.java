package controller;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.io.InputController;
import model.Matchup;
import view.ResultsPanel;

public class ResultsController {

	private ResultsPanel view;
	
	public ResultsController (ResultsPanel view) {
		this.view = view;
	}
	
	public void selectWeekAction() {
		String s = (String) view.weekSelector.getSelectedItem();
		int week = Integer.parseInt(s.split(" ")[1]);
		week--; // remove 1 because index starts at 0 instead of 1 in display
		view.body.remove(view.bottom);
		view.validate();
		view.bottom = view.displayWeek(view.champ, week);
		view.body.add(view.bottom, BorderLayout.CENTER);
		view.revalidate();
		view.repaint();
	}

	public void setResultAction(Matchup game, JPanel panel) {
		JTextField homeField, awayField;
		JPanel fieldPanel;
		boolean validated = false;

		// create box
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

			int result = JOptionPane.showConfirmDialog(view, fieldPanel, message, JOptionPane.OK_CANCEL_OPTION);
			if (result != JOptionPane.OK_OPTION) {
				return;
			}
			validated = InputController.areValid(homeField, awayField);
			if (!validated)
				JOptionPane.showMessageDialog(view.bottom, "Invalid values, try again.");
		} while (!validated);
		// validation of values

		// update db
		int homeScore = Integer.parseInt(homeField.getText());
		int awayScore = Integer.parseInt(awayField.getText());
		game.playGame(homeScore, awayScore);
		// update display
		panel.removeAll();
		panel.validate();
		panel = view.displayGame(game, panel);
		panel.revalidate();
		panel.repaint();
	}

	public void cancelResultAction(Matchup game, JPanel panel) {		
		// cancel result in db
		game.cancelResult();
		// update display
		panel.removeAll();
		panel.validate();
		panel = view.displayGame(game, panel);
		panel.revalidate();
		panel.repaint();
	}

	
}
