package model.standings;

import model.Championship;
import model.Team;

public class Ranking {
	
	protected Championship champ;
	protected int rank;
	protected boolean tied;
	protected Team team;
	protected int games_played;
	protected int points;
	protected int wins;
	protected int ties;
	protected int losses;
	protected int goals_for;
	protected int goals_against;
	protected int h_games_played;
	protected int h_points;
	protected int h_wins;
	protected int h_ties;
	protected int h_losses;
	protected int h_goals_for;
	protected int h_goals_against;
	protected int a_games_played;
	protected int a_points;
	protected int a_wins;
	protected int a_ties;
	protected int a_losses;
	protected int a_goals_for;
	protected int a_goals_against;
	
	public Ranking(Championship champ, Team team) {
		this.champ = champ;
		this.team = team;
		games_played = 0;
		points = 0;
		wins = 0;
		ties = 0;
		losses = 0;
		goals_for = 0;
		goals_against = 0;
		h_games_played = 0;
		h_points = 0;
		h_wins = 0;
		h_ties = 0;
		h_losses = 0;
		h_goals_for = 0;
		h_goals_against = 0;
		a_games_played = 0;
		a_points = 0;
		a_wins = 0;
		a_ties = 0;
		a_losses = 0;
		a_goals_for = 0;
		a_goals_against = 0;
		rank = -1;
		tied = false;
	}	
		
	public Object[] toTable () {
		Object[] res = new Object[SortingCriteria.values().length + 2];
		String str;
		int gd;
		str = "";
		if (tied)
			str = "T";
		str += rank;
		res[0] = str;
		res[1] = team.getName();
		res[2] = games_played;
		res[3] = points;
		res[4] = wins;
		res[5] = ties;
		res[6] = losses;
		res[7] = goals_for;
		res[8] = goals_against;
		str = "";
		gd = goals_for - goals_against;
		if (gd > 0)
			str = "+";
		str += gd;
		res[9] = str;
		res[10] = h_games_played;
		res[11] = h_points;
		res[12] = h_wins;
		res[13] = h_ties;
		res[14] = h_losses;
		res[15] = h_goals_for;
		res[16] = h_goals_against;
		str = "";
		gd = h_goals_for - h_goals_against;
		if (gd > 0)
			str = "+";
		str += gd;
		res[17] = str;
		res[18] = a_games_played;
		res[19] = a_points;
		res[20] = a_wins;
		res[21] = a_ties;
		res[22] = a_losses;
		res[23] = a_goals_for;
		res[24] = a_goals_against;
		str = "";
		gd = a_goals_for - a_goals_against;
		if (gd > 0)
			str = "+";
		str += gd;
		res[25] = str;
		return res;
	}

	
	
	public Championship getChamp() {
		return champ;
	}
	public void setChamp(Championship champ) {
		this.champ = champ;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public boolean isTied() {
		return tied;
	}
	public void setTied(boolean tied) {
		this.tied = tied;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getGames_played() {
		return games_played;
	}
	public void addGames_played(int n) {
		this.games_played += n;
	}
	public int getPoints() {
		return points;
	}
	public void addPoints(int n) {
		this.points += n;
	}
	public int getWins() {
		return wins;
	}
	public void addWins(int n) {
		this.wins += n;
	}
	public int getTies() {
		return ties;
	}
	public void addTies(int n) {
		this.ties += n;
	}
	public int getLosses() {
		return losses;
	}
	public void addLosses(int losses) {
		this.losses += losses;
	}
	public int getGoals_for() {
		return goals_for;
	}
	public void addGoals_for(int goals_for) {
		this.goals_for += goals_for;
	}
	public int getGoals_against() {
		return goals_against;
	}
	public void addGoals_against(int goals_against) {
		this.goals_against += goals_against;
	}
	public int getH_games_played() {
		return h_games_played;
	}
	public void addH_games_played(int h_games_played) {
		this.h_games_played += h_games_played;
	}
	public int getH_points() {
		return h_points;
	}
	public void addH_points(int h_points) {
		this.h_points += h_points;
	}
	public int getH_wins() {
		return h_wins;
	}
	public void addH_wins(int h_wins) {
		this.h_wins += h_wins;
	}
	public int getH_ties() {
		return h_ties;
	}
	public void addH_ties(int h_ties) {
		this.h_ties += h_ties;
	}
	public int getH_losses() {
		return h_losses;
	}
	public void addH_losses(int h_losses) {
		this.h_losses += h_losses;
	}
	public int getH_goals_for() {
		return h_goals_for;
	}
	public void addH_goals_for(int h_goals_for) {
		this.h_goals_for += h_goals_for;
	}
	public int getH_goals_against() {
		return h_goals_against;
	}
	public void addH_goals_against(int h_goals_against) {
		this.h_goals_against += h_goals_against;
	}
	public int getA_games_played() {
		return a_games_played;
	}
	public void addA_games_played(int a_games_played) {
		this.a_games_played += a_games_played;
	}
	public int getA_points() {
		return a_points;
	}
	public void addA_points(int a_points) {
		this.a_points += a_points;
	}
	public int getA_wins() {
		return a_wins;
	}
	public void addA_wins(int a_wins) {
		this.a_wins += a_wins;
	}
	public int getA_ties() {
		return a_ties;
	}
	public void addA_ties(int a_ties) {
		this.a_ties += a_ties;
	}
	public int getA_losses() {
		return a_losses;
	}
	public void addA_losses(int a_losses) {
		this.a_losses += a_losses;
	}
	public int getA_goals_for() {
		return a_goals_for;
	}
	public void addA_goals_for(int a_goals_for) {
		this.a_goals_for += a_goals_for;
	}
	public int getA_goals_against() {
		return a_goals_against;
	}
	public void addA_goals_against(int a_goals_against) {
		this.a_goals_against += a_goals_against;
	}	
	
}
