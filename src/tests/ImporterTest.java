package tests;

import controller.files.ChampionshipImporter;

public class ImporterTest {

	public static String filename = "test_files/import_test.champ";

	public static void main (String [] args) {

		ChampionshipImporter ci = new ChampionshipImporter();
		ci.makeImport(filename);

	}

}
