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

	public boolean isHere (Team t) {
		return (t == home_team) || (t == away_team);
	}
	public boolean isHome (Team t) {
		return t == home_team;
	}
	public Result getResult (boolean home) {
		if (!played)
			return Result.NOT_PLAYED;
		if (home_score == away_score)
			return Result.TIE;
		if (home) {
			if (home_score > away_score)
				return Result.WIN;
			return Result.LOSS;
		}
		if (away_score > home_score)
			return Result.WIN;
		return Result.LOSS;
	}
	public int getGoalsFor (boolean home) {
		if (home)
			return home_score;
		return away_score;
	}

	public String getScore() {
		if (!played) {
			return "-1";
		}
		return home_score+" "+away_score;
	}

	public boolean equals (Matchup other) {
		if (!this.home_team.getName().equals(other.home_team.getName()))
			return false;
		if (!this.away_team.getName().equals(other.away_team.getName()))
			return false;
		if (!played)
			return true;
		return (this.home_score==other.home_score && this.away_score==other.away_score);
	}
	
	public String toString() {
		String s = "";
		s += home_team.getName() + "   ";
		if (isPlayed())
			s += home_score +" - "+ away_score;
		else
			s += "VS";
		s += "   " + away_team.getName();
		return s;
	}
	
}
