package model.standings.tiebreaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.standings.Ranking;

public class DefaultTiebreaker implements Tiebreaker {

	// criterias in order : points, goal difference, goals for, tie
	
	@Override
	public void sort(ArrayList<Ranking> rankings) {
		DTComparator comp = new DTComparator();
		rankings.sort(comp);
		// oops wrong side -> reverse
		Collections.reverse(rankings);
		int i=1, rank=1;
		Ranking prev = null;
		// problem with istied : f.e. if 1&2 tied and 3&4 tied
		for (Ranking r : rankings) {
			if (!r.isTied() || comp.compare(prev, r)!=0)
				rank = i;
			r.setRank(rank);
			i++;
			prev = r;
		}
	}
	
	private class DTComparator implements Comparator<Ranking> {
		@Override
		public int compare(Ranking r1, Ranking r2) {
			if (r1 == null)
				return 1; // anything but 0 to eliminate problem with multiple ties
			int test;
			// test points
			test = r1.getPoints() - r2.getPoints();
			if (test != 0)
				return test;
			// test goal difference
			test = (r1.getGoals_for()-r1.getGoals_against()) - (r2.getGoals_for()-r2.getGoals_against());
			if (test != 0)
				return test;
			// test goals for
			test = r1.getGoals_for() - r2.getGoals_for();
			if (test != 0)
				return test;
			r1.setTied(true);
			r2.setTied(true);
			return 0;
		}
		
	}

}
