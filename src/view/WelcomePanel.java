package view;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import controller.io.ChampionshipImporter;
import model.Championship;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = -1043373303350905699L;

	public WelcomePanel () {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();		
		JPanel buttons = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JButton create = new JButton("Create championship");
		create.addActionListener(e -> createAction());
		buttons.add(create, gbc);
		
		JButton load = new JButton("Load an existing championship");
		load.addActionListener(e -> loadAction());
		buttons.add(load, gbc);
		
		gbc.weighty = 1;
		this.add(buttons, gbc);		
	}
			
	private void createAction() {
		JPanel next = new CreationPanel();
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
	}
	
	public void loadAction() {
		JFileChooser fc = new JFileChooser("test_files");
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ChampionshipImporter ci = new ChampionshipImporter();
			Championship champ = ci.makeImport(file.getAbsolutePath());
			
			WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);
			JPanel next = new DashboardPanel();
			frame.setChamp(champ);
			frame.setContentPane(next);
			frame.repaint();
			frame.revalidate();
		}
	}
	
}
