package model;

import java.util.ArrayList;

import model.tiebreakers.Tiebreaker;

public class Standings {

	protected int size;
	protected ArrayList<Tiebreaker> tiebreakers;
	
	public Standings (int size) {
		this.size = size;
	}
}
