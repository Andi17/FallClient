package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Webservice.ComStatistik;
import Webservice.Webservice;

public class Statistik extends JFrame {

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
	private JTabbedPane tabpane;
	private JTable tableStatistikBereich;
	private JTable tableStatistikKategorie;

	public Statistik(int x, int y, final String title,
			List<ComStatistik> statKategorie, List<ComStatistik> statBereich,
			boolean orgaEinheitgewaehlt, String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		ausgabeKategorie = statKategorie;
		ausgabeBereich = statBereich;

		// Einstellungen JFrame
		setTitle("Statistik in Zahlen");
		getContentPane().setBackground(new Color(255, 250, 240));
		getContentPane().setLayout(null);
		setBackground(new Color(255, 250, 240));
		setBounds(x, y, 816, 600);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));

		// Schließen Button wird hinzugefügt.
		JButton btnSchliessen = new JButton("Schlie\u00DFen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSchliessen.setBounds(10, 522, 117, 29);
		btnSchliessen.setBackground(Color.WHITE);
		getContentPane().add(btnSchliessen);

		// Drucken Button wird hinzugefügt.
		btnDrucken = new JButton("Drucken");
		btnDrucken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabpane.getSelectedIndex() == 0) {
					new PrintJob(tableStatistikBereich,
							title);
				}
				if (tabpane.getSelectedIndex() == 1) {
					new PrintJob(tableStatistikKategorie,
							title);
				}
			}
		});
		btnDrucken.setBounds(657, 522, 117, 29);
		btnDrucken.setBackground(Color.WHITE);
		getContentPane().add(btnDrucken);

		// Tabbed Pane wird erstellt
		tabpane = new JTabbedPane(JTabbedPane.TOP);
		tabpane.setBounds(x, y, 700, 400);

		// Titel der Statistik wird gesetzt.
		JLabel lblGruppenstatistik = new JLabel(title);
		lblGruppenstatistik.setHorizontalAlignment(SwingConstants.CENTER);
		lblGruppenstatistik.setBounds(345, 6, 110, 16);
		getContentPane().add(lblGruppenstatistik);

		if (title.equalsIgnoreCase("Gesamtstatistik")) {
			gebeBereichsStatistik(ausgabeBereich);
			gebeKategorieStatistik(ausgabeKategorie);
			tabpane.setVisible(true);
			getContentPane().add(tabpane);
		}
	}

	// Statistikausgabe Minimalstufe nach Bereich
	private void gebeBereichsStatistik(List<ComStatistik> data) {

		// TableModel wird erzeugt.
		final DefaultTableModel model = new DefaultTableModel();

		// Spaltennamen werden im TableModel deklariert.
		model.setColumnIdentifiers(new Object[] { "Organisationseinheitsart",
				"Organisationseinheit", "Kategorie", "Anzahl" });

		// Dieser String speichert den letzten Organisationseinheitstyp um
		// doppelte Einträge zu vermeiden.
		String aktuellerOrgaEinheitTyp = "";
		String aktuelleOrgaEinheitBez = "";

		// Zeilen werden geschrieben.
		for (ComStatistik s : data) {
			// Test, ob der Organisationseinheitstyp des neuen Eintrags mit dem
			// aktuellen
			// Organisationsheinheitstyp übereinstimmt.
			if (aktuellerOrgaEinheitTyp.equals(s.getOrgaEinheitTyp())) {
				// Test, ob die Organisationseinheitsbezeichnung des neuen
				// Eintrags mit der aktuellen
				// Organisationsheinheitsbezeichnung übereinstimmt.
				if (aktuelleOrgaEinheitBez.equals(s.getOrgaEinheitBez())) {
					Object[] row = new Object[] { " ", " ", s.getStrichBez(),
							s.getStrichzahl() };
					model.addRow(row);
				} else {
					Object[] row = new Object[] { " ", s.getOrgaEinheitBez(),
							s.getStrichBez(), s.getStrichzahl() };
					model.addRow(row);
				}

			} else {
				Object[] row = new Object[] { s.getOrgaEinheitTyp(),
						s.getOrgaEinheitBez(), s.getStrichBez(),
						s.getStrichzahl() };
				model.addRow(row);
			}
			aktuellerOrgaEinheitTyp = s.getOrgaEinheitTyp();
			aktuelleOrgaEinheitBez = s.getOrgaEinheitBez();
		}

		// JTable wird erzeugt. TableModel wird in die Table übernommen.
		// Scrollbar wird hinzugefügt.
		tableStatistikBereich = new JTable(model);
		JScrollPane scroll = new JScrollPane(tableStatistikBereich);
		tableStatistikBereich.setRowHeight(18);
		tableStatistikBereich.setVisible(true);
		tableStatistikBereich.setEnabled(false);

		// Tabelle inkl. Scrollbar wird dem Tabpane hinzugefügt.
		tabpane.addTab("Nach Organisationseinheit sortiert", scroll);
	}

	// Statistikausgabe Minimalstufe nach Kategorie
	private void gebeKategorieStatistik(List<ComStatistik> data) {

		// TableModel wird erzeugt.
		final DefaultTableModel model = new DefaultTableModel();

		// Spaltennamen werden im TableModel deklariert.
		model.setColumnIdentifiers(new Object[] { "Kategorie",
				"Organisationseinheitsart", "Organisationseinheit", "Anzahl" });

		// Dieser String speichert die letzte Kategorie um doppelte Einträge zu
		// vermeiden.
		String aktuelleKategorie = "";
		String aktuellerOrgaEinheitTyp = "";

		// Zeilen werden geschrieben.
		for (ComStatistik s : data) {
			// Test, ob die Kategorie des neuen Eintrags mit der aktuellen
			// Kategorie übereinstimmt.
			if (aktuelleKategorie.equals(s.getStrichBez())) {
				// Test, ob der Organisationseinheitstyp des neuen Eintrags mit
				// dem aktuellen Organisationseinheitstyp übereinstimmt.
				if (aktuellerOrgaEinheitTyp.equals(s.getOrgaEinheitTyp())) {
					Object[] row = new Object[] { " ", " ",
							s.getOrgaEinheitBez(), s.getStrichzahl() };
					model.addRow(row);
				} else {
					Object[] row = new Object[] { " ", s.getOrgaEinheitTyp(),
							s.getOrgaEinheitBez(), s.getStrichzahl() };
					model.addRow(row);
				}

			} else {
				Object[] row = new Object[] { s.getStrichBez(),
						s.getOrgaEinheitTyp(), s.getOrgaEinheitBez(),
						s.getStrichzahl() };
				model.addRow(row);
			}
			aktuelleKategorie = s.getStrichBez();
			aktuellerOrgaEinheitTyp = s.getOrgaEinheitTyp();
		}

		// JTable wird erzeugt. TableModel wird in die Table übernommen.
		// Scrollbar wird hinzugefügt.
		tableStatistikKategorie = new JTable(model);
		JScrollPane scroll = new JScrollPane(tableStatistikKategorie);
		tableStatistikKategorie.setRowHeight(18);
		tableStatistikKategorie.setVisible(true);
		tableStatistikKategorie.setEnabled(false);

		// Tabelle inkl. Scrollbar wird dem Tabpane hinzugefügt.
		tabpane.addTab("Nach Kategorie sortiert", scroll);
	}
}
