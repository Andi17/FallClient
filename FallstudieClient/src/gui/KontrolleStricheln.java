package gui;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class KontrolleStricheln extends JDialog{
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private final JPanel contentPanel = new JPanel();
	private JTable kontrolleTable;
	private String[][]kontrolleAusgabeListe;
	private int anzahl;
	JComboBox<String> dropKw = new JComboBox<String>();
	
	public KontrolleStricheln(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}
	public KontrolleStricheln(String[][] uebergabeArray, int menge, String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.kontrolleAusgabeListe=uebergabeArray;
		this.anzahl=menge;
		initialize();
	}
	private void initialize() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setBounds(100, 100, 800, 600);
		contentPanel.setLayout(null);
		String[] columnNames = {
				"Nummer", "Kategorie", "Anzahl", "Kalenderwoche"
			};	
		kontrolleTable = new JTable(kontrolleAusgabeListe, columnNames);
		
		JTableHeader header = kontrolleTable.getTableHeader();
		header.setBounds(60, 200, 434, 24);
		contentPanel.add(header);
		
		kontrolleTable.isEditing();
		kontrolleTable.setBounds(60, 224, 434, 172);
		contentPanel.add(kontrolleTable);
		
		JLabel pruefungsLabel = new JLabel("Bitte pr\u00FCfen Sie Ihre Angaben nochmals.");
		pruefungsLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pruefungsLabel.setBounds(242, 54, 350, 62);
		contentPanel.add(pruefungsLabel);
		
		JButton endAbschickenButton = new JButton("Abschicken");
		endAbschickenButton.setBackground(Color.ORANGE);
		endAbschickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Anzahl zeilen: " + kontrolleTable.getRowCount() );
				for (int j = 0; j < anzahl; j++) {
//					String auslese = kontrolleTable.getValueAt(j, 2).toString();
					  int Strichanzahl = (int) Float.parseFloat((String) kontrolleTable.getValueAt(j,2));
					  System.out.println("lalalalalalala" + kontrolleTable.getValueAt(j,2));
					  
					  String Strichart = kontrolleAusgabeListe[j][1];
					  boolean ausgewaehlteWoche = true;
					  if(kontrolleAusgabeListe[j][3].equals("aktuelle"))
					  {
						  ausgewaehlteWoche = true;
					  }
					  else
					  {
						  ausgewaehlteWoche = false;
					  }
					if ( port.stricheln(Benutzername, Passwort, Strichart, Strichanzahl, ausgewaehlteWoche))  
					{
					  
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
						}
						else{
			        		AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
			    			frmAnwendungAbbruch.setVisible(true); 
			    			dispose();
					}
				}
			}
		});
		endAbschickenButton.setBounds(30, 462, 115, 30);
		contentPanel.add(endAbschickenButton);
		
		JButton endAbbrechen = new JButton("Abbrechen");
		endAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		endAbbrechen.setBackground(Color.WHITE);
		endAbbrechen.setBounds(540, 462, 100, 30);
		contentPanel.add(endAbbrechen);
		
		// HilfeButton----------------------------------------------
		JButton hilfeButton = new JButton("");
		hilfeButton.setBackground(new Color (255,250,240));
		hilfeButton.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
		hilfeButton.setBorderPainted(false);
		hilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  KontrolleStrichelnHilfe KontrolleStrichelnHilfe = new KontrolleStrichelnHilfe();
				  KontrolleStrichelnHilfe.setVisible(true);
			}
		});
		hilfeButton.setBounds(10, 515, 48, 36);
		contentPanel.add(hilfeButton);
		// HilfeButton----------------------------------------------
	}
}