package statistik;

import java.util.ArrayList;
import java.util.List;

import Webservice.ComStatistik;

public class Balkendiagramm {

	@SuppressWarnings("rawtypes")
	public Balkendiagramm(List<ComStatistik> statBereich) {
		int orgaJetzt = 0, orgaAlt = 0;
		boolean ersteRunde = true;
		
		List<String> bezeichnungStricharten = new ArrayList<String>();
		List<String> bezeichnungOrgaEinheiten = new ArrayList<String>();
		List<List> orgaNummer = new ArrayList<List>();
		List<Integer> strichanzahl = new ArrayList<Integer>();

		for (ComStatistik s : statBereich) {
			orgaJetzt = s.getIdOrgaEinheit();
			// Kategorie und Anzahl

			if (orgaAlt == orgaJetzt && ersteRunde == false) {
				if(!bezeichnungStricharten.contains(s.getStrichBez()))bezeichnungStricharten.add(s.getStrichBez());
				strichanzahl.add(s.getStrichzahl());

			}
			// Erste Runde
			else if (orgaAlt != orgaJetzt && ersteRunde == true) {
				ersteRunde = false;
				bezeichnungOrgaEinheiten.add(s.getOrgaEinheitBez());
				bezeichnungStricharten.add(s.getStrichBez());
				strichanzahl = new ArrayList<Integer>();
				orgaNummer.add(strichanzahl);
				strichanzahl.add(s.getStrichzahl());
			}
			// Neue Orga
			else {
				bezeichnungOrgaEinheiten.add(s.getOrgaEinheitBez());
				if(!bezeichnungStricharten.contains(s.getStrichBez()))bezeichnungStricharten.add(s.getStrichBez());
				strichanzahl = new ArrayList<Integer>();
				orgaNummer.add(strichanzahl);
				strichanzahl.add(s.getStrichzahl());

			}

			orgaAlt = orgaJetzt;
		}
		
		String[] bezeichnungYAchse = new String[bezeichnungOrgaEinheiten.size()];
		for(int i=0; i<bezeichnungOrgaEinheiten.size(); i++){
			bezeichnungYAchse[i] = bezeichnungOrgaEinheiten.get(i);
		}
		String[] bezeichnungXAchse = new String[bezeichnungStricharten.size()];
		for(int i=0; i<bezeichnungStricharten.size(); i++){
			bezeichnungXAchse[i] = bezeichnungStricharten.get(i);
		}
		double[][] werteErstYDannX = new double[strichanzahl.size()][orgaNummer.size()];
		for(int i=0; i<orgaNummer.size(); i++){
			for(int x=0; x<strichanzahl.size(); x++){
				int wert = (Integer) orgaNummer.get(i).get(x);
				werteErstYDannX[x][i] = wert;
			}
		}
		StackedBarChart chart = new StackedBarChart("Balkendiagramm", bezeichnungXAchse, bezeichnungYAchse, werteErstYDannX);
		chart.setBounds(100, 100, 700, 500);
		chart.setVisible(true);
	}

}
