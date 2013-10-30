package gui;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import javax.swing.JButton;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class KontrolleStricheln extends JFrame {

	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private final JPanel contentPanel = new JPanel();
	private JTable kontrolleTable;
	private String[][] kontrolleAusgabeListe;
	private int anzahl;
	JComboBox<String> dropKw = new JComboBox<String>();

	public KontrolleStricheln(String[][] uebergabeArray, int menge,
			String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.kontrolleAusgabeListe = uebergabeArray;
		this.anzahl = menge;
		initialize();
	}

	private void initialize() {
		this.setTitle("Stricheln");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
//		setModal(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//Erstellung der Tabelle
		String[] columnNames = { "Kategorie", "Anzahl",
				"Kalenderwoche" };
		kontrolleTable = new JTable(kontrolleAusgabeListe, columnNames);

		JTableHeader header = kontrolleTable.getTableHeader();
		contentPanel.add(header);

		kontrolleTable.setBackground(new Color(255, 250, 240));
		kontrolleTable.setEnabled(false);
		JScrollPane scroll = new JScrollPane(kontrolleTable);
		scroll.setBackground(new Color(255, 250, 240));
		scroll.setBorder(null);
		contentPanel.add(scroll);

		JLabel pruefungsLabel = new JLabel(
				"Bitte pr\u00FCfen Sie Ihre Angaben.");
//		pruefungsLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pruefungsLabel.setBounds(10, 20, 350, 25);
		contentPanel.add(pruefungsLabel);

		JButton endAbschickenButton = new JButton("Abschicken");
		endAbschickenButton.setBackground(Color.ORANGE);
		endAbschickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean erfolg = true;
				//Übergabe der Stricharten an den Server für jede Strichart ein eigener Serveraufruf.
				for (int j = 0; j < anzahl; j++) {
					int Strichanzahl = (int) Float
							.parseFloat(kontrolleAusgabeListe[j][1]);

					String Strichart = kontrolleAusgabeListe[j][0];
					boolean ausgewaehlteWoche = true;
					if (kontrolleAusgabeListe[j][2].equals("aktuelle")) {
						ausgewaehlteWoche = true;
					} else {
						ausgewaehlteWoche = false;
					}
					if (!port.stricheln(Benutzername, Passwort, Strichart,
							Strichanzahl, ausgewaehlteWoche)) {
						erfolg = false;
					}
				}
				if(erfolg){
					ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
					ErfolgEingabe.setVisible(true);
					dispose();
				}
				else {
					Fehlermeldung fehler = new Fehlermeldung(
							"Fehler!",
							"Ein unerwarteter Fehler ist aufgetreten.");
					fehler.setVisible(true);
					dispose();
				}
			}
		});
		contentPanel.add(endAbschickenButton);
		getRootPane().setDefaultButton(endAbschickenButton);

		JButton endAbbrechen = new JButton("Abbrechen");
		endAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		endAbbrechen.setBackground(Color.WHITE);
		contentPanel.add(endAbbrechen);

		JButton hilfeButton = new JButton("");
		hilfeButton.setBackground(new Color(255, 250, 240));
		hilfeButton
				.setIcon(new ImageIcon(
						Login.class
								.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		hilfeButton.setBorderPainted(false);
		hilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KontrolleStrichelnHilfe KontrolleStrichelnHilfe = new KontrolleStrichelnHilfe();
				KontrolleStrichelnHilfe.setVisible(true);
			}
		});
		contentPanel.add(hilfeButton);
		

		setBounds(100, 100, 435, 300);
		scroll.setBounds(10, 50, 400, 150);
		endAbschickenButton.setBounds(10, 210, 115, 30);
		endAbbrechen.setBounds(309, 210, 100, 30);
		hilfeButton.setBounds(368, 10, 48, 36);

	}
}