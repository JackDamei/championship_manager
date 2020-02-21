package view;

import java.awt.*;

import javax.swing.*;

public class DashboardPanel extends JPanel {

	private static final long serialVersionUID = -603170724879245053L;

	public DashboardPanel () {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		// TODO add menu
		JPanel menu = new MenuPanel();
		this.add(menu, BorderLayout.NORTH);
		
		JPanel content = new JPanel();
		this.add(content, BorderLayout.CENTER);
		
		// TODO display teams
		
	}
	
}
