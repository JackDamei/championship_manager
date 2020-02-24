package model;

import model.standings.tiebreaker.Tiebreaker;

public class Championship {

	protected String name;
	protected int size;
	protected int length;
	protected Team[] teams;
	protected Week[] calendar;
	protected Tiebreaker tiebreaker;
	
	public Championship (String name, int size, String[] team_names) {
		this.name = name;
		this.size = size;
		teams = new Team[size];
		for (int i=0; i<size; i++) {
			teams[i] = new Team(team_names[i]);
		}
	}

	public Tiebreaker getTiebreaker() {
		return tiebreaker;
	}
	public void setTiebreaker(Tiebreaker tiebreaker) {
		this.tiebreaker = tiebreaker;
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
	
	public boolean equals (Championship other) {
		// TODO tiebreaking comparaisons
		if (!this.name.equals(other.name))
			return false;
		if (this.size!=other.size || this.length!=other.length)
			return false;
		for (int i=0; i<this.size; i++)
			if (!this.teams[i].getName().equals(other.teams[i].getName()))
				return false;
		for (int w=0; w<this.length; w++)
			for (int i=0; i<this.size/2; i++)
				if (!this.getWeek(w).getMatchups(i).equals(other.getWeek(w).getMatchups(i)))
					return false;
		return true;
	}
	
}
