package gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import statistik.StackedBarChart;

import Webservice.ComStatistik;

public class Balkendiagramm {

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
		chart.setPreferredSize(new Dimension(500,bezeichnungYAchse.length*100));
		chart.setMinimumSize(chart.getPreferredSize());
		chart.setMaximumSize(chart.getPreferredSize());
		chart.setVisible(true);
	}

//	// Statistikausgabe Minimalstufe nach Kategorie
//	private void gebeKategorieStatistik(List<ComStatistik> data) {
//		String kategorieJetzt = "", kategorieAlt = "";
//		boolean ersteRunde = true;
//
//		for (ComStatistik s : data) {
//			kategorieJetzt = s.getStrichBez();
//			// Kategorie und Anzahl
//			if (kategorieAlt.equals(kategorieJetzt) && ersteRunde == false) {
//				txtAusgabe.append("\t" + s.getOrgaEinheitTyp() + ": "
//						+ s.getOrgaEinheitBez() + "\t" + s.getStrichzahl()
//						+ "\n");
//			}
//			// Erste Runde
//			else if (ersteRunde == true) {
//				ersteRunde = false;
//				txtAusgabe.append(s.getStrichBez() + "\n");
//				txtAusgabe.append("\t" + s.getOrgaEinheitTyp() + ": "
//						+ s.getOrgaEinheitBez() + "\t" + s.getStrichzahl()
//						+ "\n");
//			}
//			// Neue Kategorie
//			else {
//				txtAusgabe.append(SEPARATOR + "\n");
//				txtAusgabe.append(s.getStrichBez() + "\n");
//				txtAusgabe.append("\t" + s.getOrgaEinheitTyp() + ": "
//						+ s.getOrgaEinheitBez() + "\t" + s.getStrichzahl()
//						+ "\n");
//			}
//			kategorieAlt = kategorieJetzt;
//		}
//		txtAusgabe.append(TRENNER + "\n");
//		txtAusgabe.append(TRENNER + "\n" + "\n");
//		// TODO: !!!!HIER SCHREIBEN
//	}

}
