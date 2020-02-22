package view;

import java.awt.*;

import javax.swing.*;

import model.Championship;
import model.MatchupMaker;

public class SettingsPanel extends JPanel {

	private static final long serialVersionUID = 5482857352984389517L;

	//private boolean isCreated;
	private JRadioButton yesButton, noButton;

	public SettingsPanel(boolean isCreated) {

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
		if (isCreated) {
			// TODO if created, button back to dashboard
			JButton toDashboard = new JButton("Back to dashboard");
			toDashboard.addActionListener(e -> toDashboardAction());
			// TODO if created, button save changes
			JButton saveChanges = new JButton("Save changes");
			saveChanges.addActionListener(e -> saveAction());

			bottom.add(toDashboard);
			bottom.add(saveChanges);
		} else {
			// TODO if not created, button back to team names
			JButton toTeamNames = new JButton("Back to team names");
			toTeamNames.addActionListener(e -> toTeamAction());
			// TODO if not created, button let's go
			JButton toCreation = new JButton("Let's go!");
			toCreation.addActionListener(e -> toCreationAction());

			bottom.add(toTeamNames);
			bottom.add(toCreation);
		}
		this.add(bottom, BorderLayout.SOUTH);
	}


	private void toCreationAction() {
		WelcomeFrame frame = ((WelcomeFrame) SwingUtilities.getWindowAncestor(this));
		Championship champ = frame.getChamp();
		boolean homeaway = yesButton.isSelected();
		MatchupMaker.make(champ, homeaway);
		// TODO add tiebrakers in later versions
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();		
	}
	private void toTeamAction() {
		JPanel next = new CreationPanel();
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	private void saveAction() {
		// TODO Auto-generated method stub
		WelcomeFrame frame = ((WelcomeFrame) SwingUtilities.getWindowAncestor(this));
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();		
	}
	private void toDashboardAction() {
		// TODO Auto-generated method stub
		WelcomeFrame frame = ((WelcomeFrame) SwingUtilities.getWindowAncestor(this));
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();		
	}


}
