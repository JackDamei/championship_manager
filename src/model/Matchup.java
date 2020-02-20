package model;

public class Matchup {
	
	protected int week;
	protected Team home_team;
	protected Team away_team;
	protected int home_score = 0;
	protected int away_score = 0;
	protected boolean played;

	public Matchup(int week, Team home_team, Team away_team) {
		this.week = week;
		this.home_team = home_team;
		this.away_team = away_team;
		played = false;
	}
	
	public int getWeek() {
		return week;
	}

	public Team getHome_team() {
		return home_team;
	}
	public Team getAway_team() {
		return away_team;
	}

	public boolean isPlayed() {
		return played;
	}

	public int getHome_score() {
		return home_score;
	}
	public int getAway_score() {
		return away_score;
	}

	public void playGame (int home_score, int away_score) {
		this.home_score = home_score;
		this.away_score = away_score;
		this.played = true;
	}
	
	public void cancelResult () {
		this.played = false;
	}

}
