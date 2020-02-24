package tests;

import controller.io.ChampionshipExporter;
import model.Championship;
import model.MatchupMaker;

public class ExporterTest {

	public static String filename = "test_files/export_test.champ";
	
	static String [] names = {"1", "2", "3", "4"};
	
	public static void main (String [] args) {
		
		// create fake championship
		Championship champ = new Championship("test", 4, names);
		MatchupMaker.make(champ, false);
		
		ChampionshipExporter ce = new ChampionshipExporter(champ);
		ce.makeExport(filename);
	
	}

	
}
