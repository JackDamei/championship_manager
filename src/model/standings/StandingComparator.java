package model.standings;

import java.util.Comparator;

public class StandingComparator implements Comparator<Ranking> {

	private SortingCriteria sc;
	
	public StandingComparator (SortingCriteria sc) {
		this.sc = sc;
	}
	
	@Override
	public int compare(Ranking r1, Ranking r2) {
		// TODO Auto-generated method stub
		int res = 0;
		switch (sc) {
		case GAMES_PLAYED:
			res = r1.getGames_played() - r2.getGames_played();
			break;
		case POINTS:
			res = r1.getPoints() - r2.getPoints();
			break;
		case WINS:
			res = r1.getWins() - r2.getWins();
			break;
		case TIES:
			res = r1.getTies() - r2.getTies();
			break;
		case LOSSES:
			res = r1.getLosses() - r2.getLosses();
			break;
		case G_FOR:
			res = r1.getGoals_for() - r2.getGoals_for();
			break;
		case G_AGAINST:
			res = r1.getGoals_against() - r2.getGoals_against();
			break;
		case G_DIFF:
			res = (r1.getGoals_for()-r1.getGoals_against()) - (r2.getGoals_for()-r2.getGoals_against());
			break;
		case H_GAMES_PLAYED:
			res = r1.getH_games_played() - r2.getH_games_played();
			break;
		case H_POINTS:
			res = r1.getH_points() - r2.getH_points();
			break;
		case H_G_FOR:
			res = r1.getH_goals_for() - r2.getH_goals_for();
			break;
		case H_G_AGAINST:
			res = r1.getH_goals_against() - r2.getH_goals_against();
			break;
		case H_G_DIFF:
			res = (r1.getH_goals_for()-r1.getH_goals_against()) - (r2.getH_goals_for()-r2.getH_goals_against());
			break;
		case H_WINS:
			res = r1.getH_wins() - r2.getH_wins();
			break;
		case H_TIES:
			res = r1.getH_ties() - r2.getH_ties();
			break;
		case H_LOSSES:
			res = r1.getH_losses() - r2.getH_losses();
			break;
		case A_GAMES_PLAYED:
			res = r1.getA_games_played() - r2.getA_games_played();
			break;
		case A_POINTS:
			res = r1.getA_points() - r2.getA_points();
			break;
		case A_G_FOR:
			res = r1.getA_goals_for() - r2.getA_goals_for();
			break;
		case A_G_AGAINST:
			res = r1.getA_goals_against() - r2.getA_goals_against();
			break;
		case A_G_DIFF:
			res = (r1.getA_goals_for()-r1.getA_goals_against()) - (r2.getA_goals_for()-r2.getA_goals_against());
			break;
		case A_WINS:
			res = r1.getA_wins() - r2.getA_wins();
			break;
		case A_TIES:
			res = r1.getA_ties() - r2.getA_ties();
			break;
		case A_LOSSES:
			res = r1.getA_losses() - r2.getA_losses();
			break;
		default:
			break;
		}
		if (res == 0)
			res = r2.getRank()-r1.getRank();
		
		return res;
	}

}
