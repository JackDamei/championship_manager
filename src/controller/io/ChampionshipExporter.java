package controller.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.Championship;

public class ChampionshipExporter {

	protected Championship champ;

	public ChampionshipExporter (Championship champ) {
		this.champ = champ;
	}

	public void makeExport (String filename) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(champ.getName()+"\n");
			bw.write(champ.getSize()+"\n");
			for (int i=0; i<champ.getSize(); i++)
				bw.write(champ.getTeam(i).getName()+"\n");
			if (champ.getLength() > champ.getSize()) {
				bw.write("Y\n");
			} else {
				bw.write("N\n");
			}
			for (int w=0; w<champ.getLength(); w++) {
				bw.write("Week "+(w+1)+"\n");
				for (int i=0; i<champ.getSize()/2; i++)
					bw.write(champ.getWeek(w).getMatchups(i).getScore()+"\n");
			}
			bw.write(champ.getTiebreaker().toString()+"\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
