package controller;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import model.Championship;
import view.CreationPanel;
import view.SettingsPanel;
import view.WelcomeFrame;

public class CreationController {

	private CreationPanel view;
	
	public CreationController (CreationPanel view) {
		this.view = view;
	}
	
	public void sizeSelectorAction (JPanel panel) {
		// TODO not removing filled fields when changing
		
		view.list.clear();
		panel.removeAll();
		panel.validate();
		panel.setLayout(new GridLayout(0,2));
		SpinnerModel model = view.sizeSelector.getModel();
		view.size = ((SpinnerNumberModel)model).getNumber().intValue();
		for (int i=0; i<view.size; i++) {
			panel.add(view.teamForm(i));
		}
		panel.revalidate();
		panel.repaint();
	}

	public void validationAction() {
		if (control(view.list)) {
			JOptionPane.showMessageDialog(view, "Please fill all fields.");
			return;
		}
		if (areDifferent(view.list)) {
			JOptionPane.showMessageDialog(view, "Team names must be different.");
			return;
		}
			
		// TODO create list and go to settings
		String[] teamnames = new String[view.size];
		for (int i=0; i<view.size; i++)
			teamnames[i] = view.list.get(i).getText();

		// TODO get champ_name from area
		String champ_name = "mychamp";
		
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(view);

		frame.setChamp(new Championship(champ_name, view.size, teamnames));

		JPanel next = new SettingsPanel(false);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
		
	}

	
	
	
	
	
	public boolean control (JTextField field) {
		String str = field.getText();
		return !str.isBlank();
	}
	public boolean control (ArrayList<JTextField> fields) {
		for (JTextField field : fields) {
			if (!control(field))
				return false;
		}		
		return true;
	}
	public boolean areDifferent (ArrayList<JTextField> fields) {
		// TODO test if all team names are different
		return true;
	}
}
