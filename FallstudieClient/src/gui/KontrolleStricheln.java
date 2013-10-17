package gui;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import Webservice.ComStrichart;
import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class KontrolleStricheln  {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;

	JFrame frame;
	private JTable kontrolleTable;
	private String[][]kontrolleAusgabeListe;
	private int anzahl;
	//private int vorherigeKw= objektKw.getKalenderwoche()-1;
	JComboBox<String> dropKw = new JComboBox<String>();
	

	public KontrolleStricheln(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	public KontrolleStricheln(String[][] uebergabeArray, int anzahl, String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.kontrolleAusgabeListe=uebergabeArray;
		this.anzahl=anzahl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color (255,250,240));
		frame.getContentPane().setLayout(null);
		String[] columnNames = {
				"Nummer", "Kategorie", "Anzahl", "Kalenderwoche"
			};
		
		
		kontrolleTable = new JTable(kontrolleAusgabeListe, columnNames);
		
		JTableHeader header = kontrolleTable.getTableHeader();
		header.setBounds(60, 200, 434, 24);
		frame.getContentPane().add(header);
		
		//ComboBox
//		TableColumn sportColumn = kontrolleTable.getColumnModel().getColumn(3);
//		
//		dropKw.addItem("" + kontrolleAusgabeListe.get(0).getKalenderwoche());
//		dropKw.addItem("" + vorherigeKw);
//		sportColumn.setCellEditor(new DefaultCellEditor(dropKw));
//		dropKw.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String stringAuswahl= (String) dropKw.getSelectedItem();
//				int auswahl = Integer.parseInt(stringAuswahl);
//				int zeile =dropKw.getSelectedIndex()-1;
//			
//				
//			}
//		
//		});
		kontrolleTable.isEditing();
		kontrolleTable.setBounds(60, 224, 434, 172);
		frame.getContentPane().add(kontrolleTable);
		
		JLabel pruefungsLabel = new JLabel("Bitte pr\u00FCfen Sie Ihre Angaben nochmals.");
		pruefungsLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pruefungsLabel.setBounds(242, 54, 350, 62);
		frame.getContentPane().add(pruefungsLabel);
		
		JButton endAbschickenButton = new JButton("Abschicken");
		endAbschickenButton.setBackground(Color.ORANGE);
		endAbschickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int j = 0; j < anzahl; j++) {
					String auslese = kontrolleTable.getValueAt(j, 2).toString();
					  kontrolleAusgabeListe[j][2]=auslese;
					  
				}
				 
				  
				
				
			}
		});
		endAbschickenButton.setBounds(30, 462, 115, 30);
		frame.getContentPane().add(endAbschickenButton);
		
		JButton endAbbrechen = new JButton("Abbrechen");
		endAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stricheln fensterwechselStricheln = new Stricheln(Benutzername, Passwort, port);
				frame.dispose();
			}
		});
		endAbbrechen.setBackground(Color.WHITE);
		endAbbrechen.setBounds(540, 462, 100, 30);
		frame.getContentPane().add(endAbbrechen);
		frame.setSize( 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		frame.getContentPane().add(hilfeButton);
		// HilfeButton----------------------------------------------
	}
}
