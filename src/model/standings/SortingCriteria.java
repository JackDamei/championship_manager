package model.standings;

public enum SortingCriteria {
	GAMES_PLAYED ("Games played", "GP"),
	POINTS ("Points", "P"),
	WINS ("Wins", "W"),
	TIES ("Ties", "T"),
	LOSSES ("Losses", "L"),
	G_FOR ("Goals for", "GF"),
	G_AGAINST ("Goals against", "GA"),
	G_DIFF ("Goal difference", "GD"),
	H_GAMES_PLAYED ("Home games played", "HGP"),
	H_POINTS ("Home points", "P"),
	H_WINS ("Home wins", "W"),
	H_TIES ("Home ties", "T"),
	H_LOSSES ("Home_losses", "L"),
	H_G_FOR ("Home goals for", "GF"),
	H_G_AGAINST ("Home goals against", "GA"),
	H_G_DIFF ("Home goal difference", "GD"),
	A_GAMES_PLAYED ("Away games played", "AGP"),
	A_WINS ("Away wins", "W"),
	A_TIES ("Away ties", "T"),
	A_LOSSES ("Away losses", "L"),
	A_POINTS ("Away points", "P"),
	A_G_FOR ("Away goals for", "GF"),
	A_G_AGAINST ("Away goals against", "GA"),
	A_G_DIFF ("Away goal difference", "GD");

	private final String str;
	private final String abr;

	SortingCriteria(String str, String abr) {
		this.str = str;
		this.abr = abr;
	}

	public String toString() {
		return str;
	}
	public String getAbreviated() {
		return abr;
	}

	public static boolean isGAgainst (SortingCriteria sc) {
		if (       (sc == G_AGAINST) 
				|| (sc == H_G_AGAINST)
				|| (sc == A_G_AGAINST)
				)
			return true;
		return false;
	}

}
