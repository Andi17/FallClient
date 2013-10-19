package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Webservice.ComStatistik;
import Webservice.Webservice;

public class Statistik extends JDialog {
	/**
	 * 
	 */

	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private static final long serialVersionUID = 1L;
	private List<ComStatistik> ausgabeKategorie;
	private List<ComStatistik> ausgabeBereich;
	private JButton btnDrucken;
	private JTextArea txtAusgabe;

	final static String TRENNER = "========================================================";
	final static String SEPARATOR = "________________________________________________________\n";

	public Statistik(int x, int y, String title,
			List<ComStatistik> statKategorie, List<ComStatistik> statBereich,
			boolean orgaEinheitgewaehlt, String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		// Deklarationen
		// setAlwaysOnTop(true);
		// TODO
		// datenZurAusgabe = port.getStrichartStatistik(Benutzername, Passwort,
		// kw, jahr);
		ausgabeKategorie = statKategorie;
		ausgabeBereich = statBereich;

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBackground(Color.WHITE);
		setBounds(x, y, 800, 600);

		JButton btnSchliessen = new JButton("Schlie\u00DFen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO
				// Hauptseite haupt = new Hauptseite(1, getX(), getY());// NEW
				dispose();
			}
		});
		btnSchliessen.setBounds(10, 522, 117, 29);
		getContentPane().add(btnSchliessen);

		btnDrucken = new JButton("Drucken");
		btnDrucken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintJob drucken = new PrintJob();
				drucken.drucken(txtAusgabe);
			}
		});
		btnDrucken.setBounds(657, 522, 117, 29);
		getContentPane().add(btnDrucken);

		txtAusgabe = new JTextArea();
		txtAusgabe.setEditable(false);
		txtAusgabe.setWrapStyleWord(true);
		txtAusgabe.setLineWrap(true);
		txtAusgabe.setBackground(Color.WHITE);
		txtAusgabe.setBounds(6, 67, 788, 446);
		// getContentPane().add(txtAusgabe);
		// txtAusgabe.setColumns(10);
		// TODO

		JScrollPane scrollPane = new JScrollPane(txtAusgabe);
		scrollPane.setBounds(6, 67, 788, 446);
		getContentPane().add(scrollPane);

		// txtAusgabe
		JLabel lblGruppenstatistik = new JLabel(title);
		lblGruppenstatistik.setHorizontalAlignment(SwingConstants.CENTER);
		lblGruppenstatistik.setBounds(345, 6, 110, 16);
		getContentPane().add(lblGruppenstatistik);

		if (title.equalsIgnoreCase("Gesamtstatistik")) {
			gebeBereichsStatistik(ausgabeBereich);
			gebeKategorieStatistik(ausgabeKategorie);
		}
		// else if (title.equalsIgnoreCase("Bereichsstatistik")) {
		// setBereichsStatistikText(ausgabeKategorie);
		// }
		// else if (title.equalsIgnoreCase("Gruppenstatistik")) {
		// setGruppenStatistikText(ausgabeKategorie);
		// } else { // error
		// throw new IllegalArgumentException("Wrong title...");
		// }
	}

	// private void setGruppenStatistikText(List<ComStatistik> data) {
	// for (ComStatistik s : data)
	// txtAusgabe.append(s + "n");
	// // TODO: implement
	// }
	//
	// private void setBereichsStatistikText(List<ComStatistik> data) {
	// for (ComStatistik s : data)
	// txtAusgabe.append(s + SEPARATOR + "\n");
	// // TODO: implement
	// }

	// Statistikausgabe Minimalstufe nach Bereich
	private void gebeBereichsStatistik(List<ComStatistik> data) {
		int orgaJetzt = 0, orgaAlt = 0;
		boolean ersteRunde = true;

		for (ComStatistik s : data) {
			orgaJetzt = s.getIdOrgaEinheit();
			// Kategorie und Anzahl

			if (orgaAlt == orgaJetzt && ersteRunde == false) {
				txtAusgabe.append("\t" + s.getStrichBez() + "\t"
						+ s.getStrichzahl() + "\n");

			}
			// Erste Runde
			else if (orgaAlt != orgaJetzt && ersteRunde == true) {
				ersteRunde = false;
				txtAusgabe.append(s.getOrgaEinheitTyp() + ": "
						+ s.getOrgaEinheitBez() + "\n");
				txtAusgabe.append("\t" + s.getStrichBez() + "\t"
						+ s.getStrichzahl() + "\n");

			}
			// Neue Kategorie
			else {
				txtAusgabe.append(SEPARATOR + "\n");
				txtAusgabe.append(s.getOrgaEinheitTyp() + ": "
						+ s.getOrgaEinheitBez() + "\n");
				txtAusgabe.append("\t" + s.getStrichBez() + "\t"
						+ s.getStrichzahl() + "\n");

			}

			orgaAlt = orgaJetzt;
		}
		// TODO: !!!!HIER SCHREIBEN
		txtAusgabe.append(TRENNER + "\n");
		txtAusgabe.append(TRENNER + "\n" + "\n");
	}

	// Statistikausgabe Minimalstufe nach Kategorie
	private void gebeKategorieStatistik(List<ComStatistik> data) {
		String kategorieJetzt = "", kategorieAlt = "";
		boolean ersteRunde = true;

		for (ComStatistik s : data) {
			kategorieJetzt = s.getStrichBez();
			// Kategorie und Anzahl
			if (kategorieAlt.equals(kategorieJetzt) && ersteRunde == false) {
				txtAusgabe.append("\t" + s.getOrgaEinheitTyp() + ": "
						+ s.getOrgaEinheitBez() + "\t" + s.getStrichzahl()
						+ "\n");
			}
			// Erste Runde
			else if (ersteRunde == true) {
				ersteRunde = false;
				txtAusgabe.append(s.getStrichBez() + "\n");
				txtAusgabe.append("\t" + s.getOrgaEinheitTyp() + ": "
						+ s.getOrgaEinheitBez() + "\t" + s.getStrichzahl()
						+ "\n");
			}
			// Neue Kategorie
			else {
				txtAusgabe.append(SEPARATOR + "\n");
				txtAusgabe.append(s.getStrichBez() + "\n");
				txtAusgabe.append("\t" + s.getOrgaEinheitTyp() + ": "
						+ s.getOrgaEinheitBez() + "\t" + s.getStrichzahl()
						+ "\n");
			}
			kategorieAlt = kategorieJetzt;
		}
		txtAusgabe.append(TRENNER + "\n");
		txtAusgabe.append(TRENNER + "\n" + "\n");
		// TODO: !!!!HIER SCHREIBEN
	}

}
