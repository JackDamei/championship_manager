package model.standings;

import java.util.ArrayList;

import model.Championship;
import model.Matchup;
import model.Result;
import model.Team;
import model.standings.pointmodel.PointModel;

public class Standings {

	protected ArrayList<Tiebreaker> tiebreakers;
	protected PointModel pModel;
	protected Championship champ;
	protected final int start, end;

	public Standings (Championship champ, PointModel pModel, ArrayList<Tiebreaker> tiebreakers, int start, int end) {
		this.champ = champ;
		this.tiebreakers = tiebreakers;
		this.pModel = pModel;
		// validity of starting week
		if (start < 0)
			this.start = 0;
		else if (start > champ.getLength()-1)
			this.start = champ.getLength()-1;
		else
			this.start = start;
		// validity of ending week
		if (end < this.start)
			this.end = this.start;
		else if (end < 0) // not possible but safety
			this.end = 0;
		else if (end > champ.getLength()-1)
			this.end = champ.getLength()-1;
		else
			this.end = end;
	}

	public ArrayList<Ranking> generateRankings () {
		int size = champ.getSize();
		ArrayList<Ranking> ranking = new ArrayList<Ranking>(size);

		// TODO calculate scores for each team
		for (int t=0; t<champ.getSize(); t++) {

			Team team = champ.getTeam(t);
			Ranking r = new Ranking(champ, team);

			for (int i=start; i<end+1; i++) {
				Matchup m = team.getCalendar()[i];
				if (!m.isPlayed())
					continue;

				Result result; 
				if (!m.isHere(team))
					System.out.println("There is a problem with "+team.getName()+" with week "+(i+1));
				boolean home = m.isHome(team);
				result = m.getResult(home);

				int goals_for = m.getGoalsFor(home);
				int goals_against = m.getGoalsFor(!home);
				int points = pModel.getPointsFromMatchup(m, team);

				r.addGames_played(1);
				r.addGoals_for(goals_for);
				r.addGoals_against(goals_against);
				r.addPoints(points);
				if (home) {
					r.addH_games_played(1);
					r.addH_goals_for(goals_for);
					r.addH_goals_against(goals_against);
					r.addH_points(points);
				} else {
					r.addA_games_played(1);
					r.addA_goals_for(goals_for);
					r.addA_goals_against(goals_against);
					r.addA_points(points);
				}

				switch (result) {
				case WIN:
					r.addWins(1);
					if (home)
						r.addH_wins(1);
					r.addA_wins(1);
					break;
				case TIE:
					r.addTies(1);
					if (home)
						r.addH_ties(1);
					r.addA_ties(1);
					break;
				case LOSS:
					r.addLosses(1);
					if (home)
						r.addH_losses(1);
					r.addA_losses(1);
					break;
				default:
					System.out.println("We shouldn't be here");
				}
			} // calendar loop
			ranking.add(r);
		} // team loop


		// TODO sorting the rankings

		return ranking;
	}

}
