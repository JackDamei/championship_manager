package model.standings;

public enum SortingCriteria {
	POINTS ("Points"),
	G_FOR ("Goals for"),
	G_AGAINST ("Goals against"),
	G_DIFF ("Goal difference"),
	H_POINTS ("Home points"),
	H_G_FOR ("Home goals for"),
	H_G_AGAINST ("Home goals against"),
	H_G_DIFF ("Home goal difference"),
	A_POINTS ("Away points"),
	A_G_FOR ("Away goals for"),
	A_G_AGAINST ("Away goals against"),
	A_G_DIFF ("Away goal difference");

	private final String str;

	SortingCriteria(String str) {
		this.str = str;
	}

	public String toString() {
		return str;
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
