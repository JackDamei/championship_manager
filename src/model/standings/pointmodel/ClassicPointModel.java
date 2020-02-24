package model.standings.pointmodel;

import model.Matchup;
import model.Result;
import model.Team;

public class ClassicPointModel implements PointModel {

	protected int vPoints = 3;
	protected int tPoints = 1;
	protected int lPoints = 0;

	public int getVPoints() {
		return vPoints;
	}

	public int getTPoints() {
		return tPoints;
	}

	public int getLPoints() {
		return lPoints;
	}

	// useful if bonus system like in rugby, will be used in later version
	public int getPointsFromMatchup (Matchup matchup, Team team) {
		boolean home = matchup.isHome(team);
		Result result = matchup.getResult(home);
		switch (result) {
		case WIN:
			return vPoints;
		case TIE:
			return tPoints;
		case LOSS:
			return lPoints;
		case NOT_PLAYED:
			return 0;
		}
		return 0;
	}

}
