package model.standings.pointmodel;

import model.Matchup;
import model.Team;

public class ClassicPointModel implements PointModel {

	protected int vPoints = 3;
	protected int tPoints = 1;
	protected int lPoints = 0;

	public int getVPoints() {
		return vPoints;
	}

	public int getTPoints() {
		return vPoints;
	}

	public int getLPoints() {
		return lPoints;
	}

	// useful is bonus system like in rugby, will be used in later version
	public int getPointsFromMatchup (Matchup matchup, Team team) {
		// TODO
		return 0;
	}

}
