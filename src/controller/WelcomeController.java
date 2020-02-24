package controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.io.ChampionshipImporter;
import model.Championship;
import view.CreationPanel;
import view.DashboardPanel;
import view.WelcomeFrame;
import view.WelcomePanel;

public class WelcomeController {

	private WelcomePanel view;

	public WelcomeController (WelcomePanel view) {
		this.view = view;
	}

	public void createAction() {
		JPanel next = new CreationPanel();
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}

	public void loadAction() {
		JFileChooser fc = new JFileChooser("test_files");
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ChampionshipImporter ci = new ChampionshipImporter();
			// TODO add try
			Championship champ = ci.makeImport(file.getAbsolutePath());

			WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
			JPanel next = new DashboardPanel();
			frame.setChamp(champ);
			frame.setContentPane(next);
			frame.repaint();
			frame.revalidate();
		}
	}

}
