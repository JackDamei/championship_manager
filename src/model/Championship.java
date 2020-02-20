package model;

public class Championship {

	protected String name;
	protected int size;
	protected Team[] teams;
	protected Week[] calendar;
	protected Standings standings;
	
	public Championship (String name, int size, String[] team_names) {
		this.name = name;
		this.size = size;
		teams = new Team[size];
		for (int i=0; i<size; i++) {
			teams[i] = new Team(team_names[i]);
		}
		standings = new Standings(size);
	}

	public Week getWeek(int i) {
		return calendar[i];
	}

	public void createCalendar(boolean home_and_away) {
		int size = this.size;
		if (size%2 == 0)
			size--;
		if (home_and_away)
			size *= 2;
		this.calendar = new Week[size];
		for (int i=0; i<this.size; i++)
			teams[i].setCalendar(size);
	}
	public void addWeek(int i, Week week) {
		calendar[i] = week;
	}

	public String getName() {
		return name;
	}
	int getSize() {
		return size;
	}

	public Team getTeam(int i) {
		return teams[i];
	}

	public Standings getStandings() {
		return standings;
	}	
	
}
