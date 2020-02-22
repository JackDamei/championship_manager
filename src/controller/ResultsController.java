package controller;

import javax.swing.JTextField;

public class ResultsController {

	public static boolean isValid (JTextField homeField, JTextField awayField) {
		if (!isValid(homeField))
			return false;
		if (!isValid(awayField))
			return false;
		return true;
	}
	
	public static boolean isValid (JTextField field) {
		String text = field.getText();
		try {
			int i = Integer.parseInt(text);
			if (i >= 0)
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
