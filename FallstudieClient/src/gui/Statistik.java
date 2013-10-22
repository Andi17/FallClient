package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Webservice.ComStatistik;
import Webservice.Webservice;

public class Statistik extends JDialog {

	@SuppressWarnings("unused")
	private String Benutzername;
	@SuppressWarnings("unused")
	private String Passwort;
	@SuppressWarnings("unused")
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
		ausgabeKategorie = statKategorie;
		ausgabeBereich = statBereich;

		getContentPane().setBackground(new Color(255, 250, 240));
		getContentPane().setLayout(null);
		setBackground(new Color(255, 250, 240));
		setBounds(x, y, 816, 600);

		JButton btnSchliessen = new JButton("Schlie\u00DFen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSchliessen.setBounds(10, 522, 117, 29);
		btnSchliessen.setBackground(Color.WHITE);
		getContentPane().add(btnSchliessen);

		btnDrucken = new JButton("Drucken");
		btnDrucken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintJob drucken = new PrintJob();
				drucken.drucken(txtAusgabe);
			}
		});
		btnDrucken.setBounds(657, 522, 117, 29);
		btnDrucken.setBackground(Color.WHITE);
		getContentPane().add(btnDrucken);

		txtAusgabe = new JTextArea();
		txtAusgabe.setEditable(false);
		txtAusgabe.setWrapStyleWord(true);
		txtAusgabe.setLineWrap(true);
		txtAusgabe.setBackground(Color.WHITE);
		txtAusgabe.setBounds(6, 67, 788, 446);

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
	}

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
			// Neue Orga
			else {
				txtAusgabe.append(SEPARATOR + "\n");
				txtAusgabe.append(s.getOrgaEinheitTyp() + ": "
						+ s.getOrgaEinheitBez() + "\n");
				txtAusgabe.append("\t" + s.getStrichBez() + "\t"
						+ s.getStrichzahl() + "\n");

			}

			orgaAlt = orgaJetzt;
		}
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
	}
}
