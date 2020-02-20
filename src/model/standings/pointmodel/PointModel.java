package model.standings.pointmodel;

import model.Matchup;
import model.Team;

public interface PointModel {
	
	public int getVPoints();
	public int getTPoints();
	public int getLPoints();
	public int getPointsFromMatchup(Matchup match, Team team);
	
}
