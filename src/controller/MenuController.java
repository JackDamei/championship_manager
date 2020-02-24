package controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.io.ChampionshipExporter;
import model.Championship;
import view.DashboardPanel;
import view.MenuPanel;
import view.ResultsPanel;
import view.SettingsPanel;
import view.StandingsPanel;
import view.WelcomeFrame;

public class MenuController {

	private MenuPanel view;
	
	public MenuController(MenuPanel view) {
		this.view = view;
	}
	
	public void toDashboardAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void toResultsAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
		Championship champ = frame.getChamp();
		JPanel next = new ResultsPanel(champ);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void toStandingsAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
		JPanel next = new StandingsPanel(frame.getChamp());
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void toExportAction () {
		JFileChooser fc = new JFileChooser("test_files");
		fc.setDialogTitle("Save as");
		fc.setApproveButtonText("Save");
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
			Championship champ = frame.getChamp();
			ChampionshipExporter ce = new ChampionshipExporter(champ);
			String filename = file.getAbsolutePath();
			if (!filename.toLowerCase().endsWith(".champ"))
				filename += ".champ";
			ce.makeExport(filename);
		}
	}
	
	public void toSettingsAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);
		JPanel next = new SettingsPanel(true);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}

	
}
