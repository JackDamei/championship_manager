package model;

public class Team {
	
	protected String name;
	protected Matchup[] calendar = null;
	protected int rank = 0;

	public Team (String name) {
		this.name = name;
	}

	public Matchup[] getCalendar() {
		return calendar;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setCalendar (int size) {
		calendar = new Matchup[size];
	}
	public void setMatchup (int week, Matchup matchup) {
		calendar[week] = matchup;
	}
}
