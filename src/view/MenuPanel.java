package view;

import java.io.File;

import javax.swing.*;

import controller.files.ChampionshipExporter;
import model.Championship;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -3478859524085262735L;

	public MenuPanel () {
	
		// create menu buttons
		JButton toDashboard = new JButton("Dashboard");
		toDashboard.addActionListener(e -> toDashboardAction());
		JButton toResults = new JButton("Scores");
		toResults.addActionListener(e -> toResultsAction());
		JButton toStandings = new JButton("Standings");
		toStandings.addActionListener(e -> toStandingsAction());
		JButton toExport = new JButton("Export into a file");
		toExport.addActionListener(e -> toExportAction());
		JButton toSettings = new JButton("Settings");
		toSettings.addActionListener(e -> toSettingsAction());

		// TODO add display
		this.add(toDashboard);
		this.add(toResults);
		this.add(toStandings);
		this.add(toExport);
		this.add(toSettings);
		
	}
	
	// TODO make all listeners	
	
	public void toDashboardAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
		JPanel next = new DashboardPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void toResultsAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
		JPanel next = new ResultsPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void toStandingsAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
		JPanel next = new StandingsPanel();
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void toExportAction () {
		JFileChooser fc = new JFileChooser("test_files");
		fc.setDialogTitle("Save as");
		fc.setApproveButtonText("Save");
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
			Championship champ = frame.getChamp();
			ChampionshipExporter ce = new ChampionshipExporter(champ);
			String filename = file.getAbsolutePath();
			if (!filename.toLowerCase().endsWith(".champ"))
				filename += ".champ";
			ce.makeExport(filename);
		}
	}
	
	public void toSettingsAction () {
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
		JPanel next = new SettingsPanel(true);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
}
