package model;

public class MatchupMaker {

	public static void make (Championship champ, boolean homeaway) {

		int size = champ.getSize();
		if (size % 2 == 1) {
			size++;
		}
		
		// INITIALIZING CALENDARS
		createCalendar(champ, homeaway);

		// RIBBON METHOD

		int[] position = new int[size];
		boolean[] home = new boolean[size]; // only fist half is used

		//init
		for (int i=0; i<size; i++) {
			position[i] = i;
			home[i] = i%2 == 0;
		}

		for (int week=0; week<size-1; week++) {

			// SETTING MATCHUPS
			
			Week w1, w2;
			w1 = new Week(champ, week);
			// w2 initialized but not used if home and away
			w2 = new Week(champ, week+size-1);

			int offset = 0;
			for (int i=0; i<size/2; i++) {
				
				int t1 = position[i];
				int t2 = position[size-i-1];
				Matchup m = createMatchup (champ, week, t1, t2, home[i]);
				// createMatchup returns null if one of the teams is the "bye"

				if (m == null) {
					offset = 1;
				} else {
					
					w1.setMatchup(i-offset, m);
					champ.getTeam(t1).setMatchup(week, m);
					champ.getTeam(t2).setMatchup(week, m);
					champ.calendar[week] = w1;
					
					if (homeaway) {
						m = createMatchup (champ, week+size-1, t2, t1, home[i]);
						w2.setMatchup(i-offset, m);		
						champ.getTeam(t1).setMatchup(week+size-1, m);
						champ.getTeam(t2).setMatchup(week+size-1, m);
						champ.calendar[week+size-1] = w2;
					}
				}
			}
			
			// SWITCHING POSITIONS
			// nb: the first position deosn't move in ribbon method
			int tmp = position[1];
			for (int i=1; i<size-1; i++) {
				position[i] = position[i+1];
			}
			position[size-1] = tmp;
			// team at first position alternates home and away games
			home[0] = !home[0];
		}

	}

	public static void createCalendar(Championship champ, boolean home_and_away) {
		int size = champ.size;
		if (size%2 == 0)
			size--;
		if (home_and_away)
			size *= 2;
		champ.length = size;
		champ.calendar = new Week[champ.length];
		for (int i=0; i<champ.size; i++)
			champ.getTeam(i).setCalendar(champ.length);
	}
	
	private static Matchup createMatchup (Championship champ, int week, int team1, int team2, boolean home) {
		if (team1 == champ.size)
			return null;
		if (team2 == champ.size)
			return null;
		if (home)
			return new Matchup (week, champ.getTeam(team1), champ.getTeam(team2));
		return new Matchup (week, champ.getTeam(team2), champ.getTeam(team1));
	}

}
