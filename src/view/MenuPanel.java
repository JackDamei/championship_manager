package view;

import java.io.File;

import javax.swing.*;

import controller.MenuController;
import controller.io.ChampionshipExporter;
import model.Championship;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -3478859524085262735L;
	private MenuController controller;
	
	public MenuPanel () {
	
		// create menu buttons
		JButton toDashboard = new JButton("Dashboard");
		toDashboard.addActionListener(e -> controller.toDashboardAction());
		JButton toResults = new JButton("Scores");
		toResults.addActionListener(e -> controller.toResultsAction());
		JButton toStandings = new JButton("Standings");
		toStandings.addActionListener(e -> controller.toStandingsAction());
		JButton toExport = new JButton("Export into a file");
		toExport.addActionListener(e -> controller.toExportAction());
		JButton toSettings = new JButton("Settings");
		toSettings.addActionListener(e -> controller.toSettingsAction());

		this.add(toDashboard);
		this.add(toResults);
		this.add(toStandings);
		this.add(toExport);
		this.add(toSettings);
		
	}
		
}
