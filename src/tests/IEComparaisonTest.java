package tests;

import controller.files.ChampionshipExporter;
import controller.files.ChampionshipImporter;
import model.Championship;

public class IEComparaisonTest {

	public static String import_filename = "test_files/ie_test_in.champ";
	public static String export_filename = "test_files/ie_test_out.champ";
	
	public static void main (String [] args) {

		// import
		ChampionshipImporter ci = new ChampionshipImporter();
		Championship champ = ci.makeImport(import_filename);
		// export
		ChampionshipExporter ce = new ChampionshipExporter(champ);
		ce.makeExport(export_filename);
		// new import
		Championship copy = ci.makeImport(export_filename);
		System.out.println(champ.equals(copy));
	}

}
