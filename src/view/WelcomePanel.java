package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class WelcomePanel extends JPanel {

	public WelcomePanel () {
		this.setBackground(Color.WHITE);
		JButton create = new JButton("Create championship");
		JButton load = new JButton("Load an existing championship");
		this.add(create);
		this.add(load);
		
		create.addActionListener(new CreateListener());
		load.addActionListener(new LoadListener());
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
			// TODO file loading and go to Championship DashBoard

		}
	}
	
}
