package view;

import javax.swing.*;

import model.Championship;

public class WelcomeFrame extends JFrame {

	protected Championship champ;
	
	public WelcomeFrame() {
		
		champ = null;
		
		this.setTitle("Championship Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1000,1000);
		
		// Welcome panel
		JPanel pan = new WelcomePanel();
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
}
