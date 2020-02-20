package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import controller.files.ChampionshipImporter;
import model.Championship;

public class WelcomePanel extends JPanel {

	public WelcomePanel () {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();		
		JPanel buttons = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JButton create = new JButton("Create championship");
		create.addActionListener(new CreateListener());
		buttons.add(create, gbc);
		
		JButton load = new JButton("Load an existing championship");
		load.addActionListener(new LoadListener());
		buttons.add(load, gbc);
		
		gbc.weighty = 1;
		this.add(buttons, gbc);		
	}
		
	private class CreateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			createAction();
		}
	}
	private class LoadListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			loadAction();
		}
	}
	
	private void createAction() {
		// TODO go to formulary panel
	}
	
	public void loadAction() {
		JFileChooser fc = new JFileChooser("test_files");
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ChampionshipImporter ci = new ChampionshipImporter();
			Championship champ = ci.makeImport(file.getAbsolutePath());
			
			JPanel next = new DashboardPanel(champ);
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.setContentPane(next);
			frame.repaint();
			frame.revalidate();
		}
	}
	
}
