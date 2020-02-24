package model.standings.tiebreaker;

import java.util.ArrayList;

import model.standings.Ranking;

public interface Tiebreaker {
	public void sort(ArrayList<Ranking> rankings);
	public String toString();
}
