package tests;

import model.Championship;
import model.Matchup;
import model.MatchupMaker;
import model.Week;

public class RibbonAlgoTest {
	
	static String [] names = {"1", "2", "3", "4"};
	
	public static void main (String [] args) {
		
		// create fake championship
		Championship champ = new Championship("test", 4, names);
		MatchupMaker.make(champ, true);
		
		// display every week matchups
		for (int i=0; i<champ.getLength(); i++) {
			Week w = champ.getWeek(i);
			System.out.println("Week "+(i+1));
			for (int j=0; j<champ.getSize()/2; j++) {
				Matchup m = w.getMatchups(j);
				System.out.println(m.getHome_team().getName()+" vs "+m.getAway_team().getName());
			}
			System.out.println();
		}
	}

}
