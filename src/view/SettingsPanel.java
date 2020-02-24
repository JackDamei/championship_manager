package view;

import java.awt.*;

import javax.swing.*;

import controller.SettingsController;

public class SettingsPanel extends JPanel {

	private static final long serialVersionUID = 5482857352984389517L;

	//private boolean isCreated;
	public JRadioButton yesButton, noButton;
	private SettingsController controller;

	public SettingsPanel(boolean isCreated) {

		controller = new SettingsController(this);
		//this.isCreated = isCreated;

		this.setLayout(new BorderLayout());

		// TODO if not created, show home and away option
		if (!isCreated) {
			JPanel top = new JPanel();
			JLabel homeAndAwayLabel = new JLabel("Double round-robin : ");
			yesButton = new JRadioButton("Yes");
			noButton = new JRadioButton("No");
			noButton.setSelected(true);
			ButtonGroup group = new ButtonGroup();
			group.add(yesButton);
			group.add(noButton);
			top.add(homeAndAwayLabel);
			top.add(yesButton);
			top.add(noButton);
			this.add(top, BorderLayout.NORTH);
		}

		// TODO tie breakers selection in later version
		// TODO if created, load saved disposition
		JPanel mid = new JPanel();
		JLabel advert = new JLabel("Tiebreakers selection will be available in later version.");
		mid.add(advert);
		this.add(mid, BorderLayout.CENTER);

		JPanel bottom = new JPanel();
		// if created, button back to dashboard
		// if created, button save changes
		// if not created, button back to team names
		// if not created, button let's go
		if (isCreated) {
			JButton toDashboard = new JButton("Back to dashboard");
			toDashboard.addActionListener(e -> controller.toDashboardAction());
			JButton saveChanges = new JButton("Save changes");
			saveChanges.addActionListener(e -> controller.saveAction());

			bottom.add(toDashboard);
			bottom.add(saveChanges);
		} else {
			JButton toTeamNames = new JButton("Back to team names");
			toTeamNames.addActionListener(e -> controller.toTeamAction());
			JButton toCreation = new JButton("Let's go!");
			toCreation.addActionListener(e -> controller.toCreationAction());

			bottom.add(toTeamNames);
			bottom.add(toCreation);
		}
		this.add(bottom, BorderLayout.SOUTH);
	}

}
