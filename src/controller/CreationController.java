package controller;

import java.util.ArrayList;

import javax.swing.JTextField;

public class CreationController {

	public static boolean control (JTextField field) {
		String str = field.getText();
		return !str.isBlank();
	}
	public static boolean control (ArrayList<JTextField> fields) {
		for (JTextField field : fields) {
			if (!control(field))
				return false;
		}		
		return true;
	}

	public static boolean areDifferent (ArrayList<JTextField> fields) {
		// TODO test if all team names are different
		return true;
	}
}
