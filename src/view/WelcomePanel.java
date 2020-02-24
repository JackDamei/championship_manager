package view;

import java.awt.*;
import javax.swing.*;

import controller.WelcomeController;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = -1043373303350905699L;

	private WelcomeController controller;
	
	public WelcomePanel () {
		
		controller = new WelcomeController(this);
		
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();		
		JPanel buttons = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JButton create = new JButton("Create championship");
		create.addActionListener(e -> controller.createAction());
		buttons.add(create, gbc);
		
		JButton load = new JButton("Load an existing championship");
		load.addActionListener(e -> controller.loadAction());
		buttons.add(load, gbc);
		
		gbc.weighty = 1;
		this.add(buttons, gbc);		
	}
				
}
