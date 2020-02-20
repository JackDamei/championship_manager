package model;

import model.standings.Standings;

public class Championship {

	protected String name;
	protected int size;
	protected int length;
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

	public void addWeek(int i, Week week) {
		calendar[i] = week;
	}

	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	
	public int getLength() {
		return length;
	}

	public Team getTeam(int i) {
		return teams[i];
	}

	public Standings getStandings() {
		return standings;
	}	
	
}
