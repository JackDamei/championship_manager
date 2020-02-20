package view;

import javax.swing.*;

import model.Championship;

public class WelcomeFrame extends JFrame {

	private static final long serialVersionUID = -7943527182790877227L;

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
	
	public Championship getChamp () {
		return champ;
	}
	public void setChamp (Championship champ) {
		this.champ = champ;
	}
	
}
