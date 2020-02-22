package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Matchup;

public class ScoreDialog extends JDialog {

	private static final long serialVersionUID = 806334319866168661L;

	private JTextField homeScoreField, awayScoreField;
	private JOptionPane optionPane;
	
	public ScoreDialog (Matchup game) {		
		String homeName = game.getHome_team().getName();
		String awayName = game.getAway_team().getName();
		homeScoreField = new JTextField(5);
		awayScoreField = new JTextField(5);
		Object[] array = {homeName, homeScoreField, awayName, awayScoreField};
		Object[] options = {"Enter","Cancel"};
		optionPane = new JOptionPane(array, JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, options, options[0]);
		setContentPane(optionPane);
		this.setSize(200,200);
	}
	
}
