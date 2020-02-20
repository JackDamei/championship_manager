package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -3478859524085262735L;

	public MenuPanel () {
	
		// TODO add display
		
		// create menu buttons
		JButton toDashboard = new JButton("Dashboard");
		toDashboard.addActionListener(new toDashboardListener());
		JButton toResults = new JButton("Scores");
		toResults.addActionListener(new toResultsListener());
		JButton toStandings = new JButton("Standings");
		toStandings.addActionListener(new toStandingsListener());
		JButton toExport = new JButton("Export into a file");
		toExport.addActionListener(new toExportListener());
		JButton toSettings = new JButton("Settings");
		toSettings.addActionListener(new toSettingsListener());
		
	}
	
	// TODO make all listeners	
	private class toDashboardListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			toDashboardAction();
		}
	}
	private class toResultsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
toResultsAction();
		}
	}
	private class toStandingsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			toStandingsAction();
		}
	}
	private class toExportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			toExportAction();
		}
	}
	private class toSettingsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			toSettingsAction();
		}
	}

	public void toDashboardAction () {
		
	}
	
	public void toResultsAction () {
		
	}
	
	public void toStandingsAction () {
		
	}
	
	public void toExportAction () {
		
	}
	
	public void toSettingsAction () {
		
	}
	
}
