package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.CreationController;

public class CreationPanel extends JPanel {

	private final int min=2, max=20, default_size=2;
	public int size;
	public ArrayList<JTextField> list;
	public JSpinner sizeSelector;
	private CreationController controller;
	
	private static final long serialVersionUID = 1988976048609683456L;
	
	public CreationPanel () {
		this.controller = new CreationController(this);
		
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
		sizeSelector.addChangeListener(e -> controller.sizeSelectorAction(mid));
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
		validation.addActionListener(e -> controller.validationAction());
		bottom.add(validation);
		this.add(bottom, BorderLayout.SOUTH);
		
	}
	
	public JPanel teamForm(int i) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Team "+(i+1)+" : ");
		JTextField field = new JTextField(25);
		panel.add(label);
		panel.add(field);
		list.add(field);
		return panel;
	}
	
}
