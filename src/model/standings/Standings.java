package model.standings;

import java.util.ArrayList;

import model.Championship;
import model.standings.pointmodel.PointModel;

public class Standings {

	protected ArrayList<Tiebreaker> tiebreakers;
	protected PointModel pModel;
	protected Championship champ;
	protected int start, end;
	
	public Standings (Championship champ, PointModel pModel, ArrayList<Tiebreaker> tiebreakers, int start, int end) {
		this.champ = champ;
		this.tiebreakers = tiebreakers;
		this.start = start;
		this.end = end;
		this.pModel = pModel;
	}
}
