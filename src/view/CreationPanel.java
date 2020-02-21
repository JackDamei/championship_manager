package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.CreationController;
import model.Championship;

public class CreationPanel extends JPanel {

	private final int min=2, max=20, default_size=2;
	private int size;
	private ArrayList<JTextField> list;
	private JSpinner sizeSelector;
	
	private static final long serialVersionUID = 1988976048609683456L;
	
	public CreationPanel () {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		list = new ArrayList<JTextField>();
		size = default_size;

		JPanel top = new JPanel();
		JPanel mid = new JPanel ();
		JPanel bottom = new JPanel ();
		
		// TODO load if the fields were already filled
		
		// TODO add a textarea for champ name
		
		// selection of size
		
		JLabel sizeSelectorLabel = new JLabel("Number of teams : ");
		SpinnerModel model = new SpinnerNumberModel(default_size,min,max,1);
		sizeSelector = new JSpinner(model);
		sizeSelector.addChangeListener(e -> sizeSelectorAction(mid));
		((JSpinner.DefaultEditor)sizeSelector.getEditor()).getTextField().setEditable(false);
		top.add(sizeSelectorLabel);
		top.add(sizeSelector);
		this.add(top, BorderLayout.NORTH);

		mid.setLayout(new GridLayout(0,2));
		for (int i=0; i<min; i++) {
			JPanel form = teamForm(i);
			mid.add(form);
		}
		this.add(mid, BorderLayout.CENTER);

		// TODO validation button
		JButton validation = new JButton("Go to settings");
		validation.addActionListener(e -> validationAction());
		bottom.add(validation);
		this.add(bottom, BorderLayout.SOUTH);
		
	}
	
	private JPanel teamForm(int i) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Team "+(i+1)+" : ");
		JTextField field = new JTextField(25);
		panel.add(label);
		panel.add(field);
		list.add(field);
		return panel;
	}
	
	private void sizeSelectorAction (JPanel panel) {
		// TODO not removing filled fields when changing
		
		list.clear();
		panel.removeAll();
		panel.validate();
		panel.setLayout(new GridLayout(0,2));
		SpinnerModel model = sizeSelector.getModel();
		size = ((SpinnerNumberModel)model).getNumber().intValue();
		System.out.println(size);
		for (int i=0; i<size; i++) {
			panel.add(teamForm(i));
		}
		panel.revalidate();
		panel.repaint();
	}
	
	private void validationAction() {
		if (!CreationController.control(list)) {
			JOptionPane.showMessageDialog(this, "Please fill all fields.");
			return;
		}
		if (!CreationController.areDifferent(list))
			JOptionPane.showMessageDialog(this, "Team names must be different.");

		// TODO create list and go to settings
		String[] teamnames = new String[size];
		for (int i=0; i<size; i++)
			teamnames[i] = list.get(i).getText();

		// TODO get champ_name from area
		String champ_name = "mychamp";
		
		WelcomeFrame frame = (WelcomeFrame) SwingUtilities.getWindowAncestor(this);

		frame.champ = new Championship(champ_name, size, teamnames);

		JPanel next = new SettingsPanel(false);
		frame.setContentPane(next);
		frame.repaint();
		frame.revalidate();
		
	}

	
}
