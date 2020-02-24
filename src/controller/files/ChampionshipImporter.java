package controller.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Championship;
import model.MatchupMaker;
import model.standings.tiebreaker.DefaultTiebreaker;

public class ChampionshipImporter {

	protected Championship champ;

	public ChampionshipImporter () {
	}

	public Championship makeImport (String filename) {
		try {
			FileInputStream file = new FileInputStream(filename);
			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			// champ name
			String name = in.readLine();
			
			// champ size
			int size = Integer.parseInt(in.readLine());
			
			// team names
			String[] teams = new String[size];
			for (int i=0; i<size; i++) {
				teams[i] = in.readLine();
			}

			// creating champ
			champ = new Championship(name, size, teams);
			// setting calendar
			boolean homeaway = in.readLine().equalsIgnoreCase("Y");
			MatchupMaker.make(champ, homeaway);
			
			// setting every results
			for (int w=0; w<champ.getLength(); w++) {
				in.readLine(); // Only "Week n" is written here
				for (int i=0; i<size/2; i++) {
					String data[] = in.readLine().split(" ");
					if (data[0].equals("-1"))
						continue;
					int s1 = Integer.parseInt(data[0]);
					int s2 = Integer.parseInt(data[1]);
					champ.getWeek(w).getMatchups(i).playGame(s1, s2);
				}
			}

			String tiebreakerStr = in.readLine();
			switch (tiebreakerStr) {
			case "defaultTiebreaker":
				champ.setTiebreaker(new DefaultTiebreaker()); // redundant but it's for example, other TB will be implemented
				break;
			default:
				champ.setTiebreaker(new DefaultTiebreaker());
			}
			
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return champ;
	}


}
