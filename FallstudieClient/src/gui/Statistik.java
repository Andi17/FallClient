package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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

		// Einstellungen JDialog
		getContentPane().setBackground(new Color(255, 250, 240));
		getContentPane().setLayout(null);
		setBackground(new Color(255, 250, 240));
		setBounds(x, y, 816, 600);

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
					PrintJob drucken = new PrintJob(tableStatistikBereich,
							title);
				}
				if (tabpane.getSelectedIndex() == 1) {
					PrintJob drucken = new PrintJob(tableStatistikKategorie,
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
		model.setColumnIdentifiers(new Object[] { "Bereich", "Kategorie",
				"Anzahl" });

		// Zeilen werden geschrieben.
		for (ComStatistik s : data) {
			Object[] row = new Object[] { s.getOrgaEinheitBez(),
					s.getStrichBez(), s.getStrichzahl() };
			model.addRow(row);
		}

		// JTable wird erzeugt. TableModel wird in die Table übernommen.
		tableStatistikBereich = new JTable(model);
		// JScrollPane scrollPane = new JScrollPane(tableStatistikBereich);
		// getContentPane().add(scrollPane);
		tableStatistikBereich.setVisible(true);

		tabpane.addTab("Bereich Statistik", tableStatistikBereich);
	}

	// Statistikausgabe Minimalstufe nach Kategorie
	private void gebeKategorieStatistik(List<ComStatistik> data) {

		// TableModel wird erzeugt.
		final DefaultTableModel model = new DefaultTableModel();

		// Spaltennamen werden im TableModel deklariert.
		model.setColumnIdentifiers(new Object[] { "Kategorie", "Bereich",
				"Anzahl" });

		// Erste Zeile wird geschrieben.
		Object[] rowOne = new Object[] { "Bereich", "Kategorie", "Anzahl" };
		model.addRow(rowOne);

		// Zeilen werden geschrieben.
		for (ComStatistik s : data) {
			Object[] row = new Object[] { s.getStrichBez(),
					s.getOrgaEinheitBez(), s.getStrichzahl() };
			model.addRow(row);
		}

		// JTable wird erzeugt. TableModel wird in die Table übernommen.
		tableStatistikBereich = new JTable(model);
		// JScrollPane scrollPane = new JScrollPane(tableStatistikBereich);
		// scrollPane.setBounds(6, 67, 788, 446);
		// getContentPane().add(scrollPane);
		tableStatistikBereich.setVisible(true);

		tabpane.addTab("Kategorie Statistik", tableStatistikBereich);
	}
}
