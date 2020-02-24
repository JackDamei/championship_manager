package controller;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Championship;
import model.MatchupMaker;
import model.standings.tiebreaker.DefaultTiebreaker;
import model.standings.tiebreaker.Tiebreaker;
import view.CreationPanel;
import view.DashboardPanel;
import view.SettingsPanel;
import view.WelcomeFrame;

public class SettingsController {

	private SettingsPanel view;

	public SettingsController(SettingsPanel view) {
		this.view = view;
	}
	
	public void toCreationAction() {
		WelcomeFrame frame = ((WelcomeFrame) SwingUtilities.getWindowAncestor(view));
		Championship champ = frame.getChamp();
		boolean homeaway = view.yesButton.isSelected();
		MatchupMaker.make(champ, homeaway);
		// TODO add tiebrakers in later versions
		Tiebreaker tiebreaker = new DefaultTiebreaker();
		champ.setTiebreaker(tiebreaker);
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();		
	}
	public void toTeamAction() {
		JPanel next = new CreationPanel();
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	public void saveAction() {
		WelcomeFrame frame = ((WelcomeFrame) SwingUtilities.getWindowAncestor(view));
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();		
	}
	public void toDashboardAction() {
		WelcomeFrame frame = ((WelcomeFrame) SwingUtilities.getWindowAncestor(view));
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();		
	}

	
	
}
