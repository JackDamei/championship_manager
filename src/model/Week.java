package model;

public class Week {
	
	protected Championship champ;
	protected int week;
	protected Matchup[] matchups;

	public Week(Championship champ, int week) {
		this.champ = champ;
		this.week = week;
		this.matchups = new Matchup[champ.size/2];
	}

	public Championship getChamp () {
		return champ;
	}
	
	public Matchup getMatchups(int i) {
		return matchups[i];
	}
	public void setMatchup(int i, Matchup matchup) {
		matchups[i] = matchup;
	}

	public int getWeek() {
		return week;
	}
	
	
	

	
}
