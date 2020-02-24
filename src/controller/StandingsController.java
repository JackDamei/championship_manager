package controller;

import model.standings.SortingCriteria;
import view.StandingsPanel;

public class StandingsController {
	
	private StandingsPanel view;

	public StandingsController(StandingsPanel view) {
		this.view = view;
	}
	
	public void criteriaSelectorAction () {
		SortingCriteria sc = (SortingCriteria) view.criteriaSelector.getSelectedItem();
		if (SortingCriteria.isGAgainst(sc))
			view.sortSelector.setSelectedItem("Ascending");
		else
			view.sortSelector.setSelectedItem("Descending");
	}

	public void startSelectorAction() {
		String str = (String) view.startWeekSelector.getSelectedItem();
		// remove 1 because index starts at 0
		view.startWeek = Integer.parseInt(str.split(" ")[1]) - 1;
		if (view.startWeek > view.endWeek)
			view.endWeekSelector.setSelectedItem(str);			
	}
	
	public void endSelectorAction() {
		String str = (String) view.endWeekSelector.getSelectedItem();
		// remove 1 because index starts at 0
		view.endWeek = Integer.parseInt(str.split(" ")[1]) - 1;
		if (view.endWeek < view.startWeek)
			view.startWeekSelector.setSelectedItem(str);			
	}
	
	public void confirmAction() {
		String str;
		view.body.remove(view.tablePanel);
		view.body.validate();

		// remove 1 because index starts at 0
		str = (String) view.startWeekSelector.getSelectedItem();
		view.startWeek = Integer.parseInt(str.split(" ")[1]) - 1;
		str = (String) view.endWeekSelector.getSelectedItem();
		view.endWeek = Integer.parseInt(str.split(" ")[1]) - 1;

		view.generateRankings();
		
		view.tablePanel = view.createTable();
		view.body.add(view.tablePanel);
		view.body.revalidate();
		view.body.repaint();
	}

	

}
