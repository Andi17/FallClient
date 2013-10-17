package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Webservice.ComStrichart;
import Webservice.Webservice;


public class Stricheln extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
    List <ComStrichart> MeineListe;
    List <ComStrichart> suchListe =  new ArrayList<ComStrichart>();
    
	JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JButton resetButton;
	private JButton abschickenButton;
	private String[][] rowData;
	private String[][] rowData_1;
	
	
	
	JComboBox<String> dropKw;
	//private int vorherigeKw= objektKw.getKalenderwoche()-1;
	
	private int anzahl = 0;
	private String[][]uebergabeArray;
	String[] abschickListe;
	
	
	public Stricheln(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		
		initialize();
	}
	
	//intialize methode
	private void initialize() {
		MeineListe=port.getStrichelArten(Benutzername, Passwort,true);
		anzahl = MeineListe.size();
		uebergabeArray= new String[anzahl][4];
		abschickListe = new String [anzahl];
		
		suchListe =  new ArrayList<ComStrichart>();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.getContentPane().setLayout(null);
		
		rowData = new String[anzahl][2]; 
		rowData_1 = new String[anzahl][2];
		rowmachen();
		
		String[] columnNames = {
		        "Nummer", "Kategorie"

		};
		String[] columnNames_1 = {
				"Anzahl", "Kalenderwoche"

		};



		table = new JTable(rowData, columnNames);
		table.setBackground(new Color(255, 250, 240));
		table.setBorder(new EmptyBorder(1, 2, 1, 1));
		JTableHeader header = table.getTableHeader();
		header.setBounds(60, 200, 217, 24);
		frame.getContentPane().add(header);
		table.setBounds(60, 224, 217, 172);
		frame.getContentPane().add(table);
		table.setEnabled(false);
		
		table_1 = new JTable(rowData_1, columnNames_1);
		table_1.setBackground(new Color(255, 250, 240));
		table_1.setBorder(new EmptyBorder(1, 0, 1, 1));
		JTableHeader header_1 = table_1.getTableHeader();
		header_1.setBounds(278, 200, 217, 24);
		frame.getContentPane().add(header_1);
		table_1.setBounds(278, 224, 217, 172);
		frame.getContentPane().add(table_1);
		
		// Show both horizontal and vertical grid lines (the default) and set color of table
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table_1.setShowGrid(true);
		table_1.setGridColor(Color.BLACK);
		
		
		Calendar calendar = new GregorianCalendar();	    
		System.out.println("Kalenderwoche:" + 
						calendar.get(Calendar.WEEK_OF_YEAR));
		int aktuelleKw = calendar.get(Calendar.WEEK_OF_YEAR);
		int vorherigeKw = aktuelleKw-1;
		
		//Combo Box
		TableColumn sportColumn = table_1.getColumnModel().getColumn(1);
		dropKw = new JComboBox<String>();
		dropKw.addItem("" + aktuelleKw);
		dropKw.addItem("" + vorherigeKw);
		dropKw.addItem("");
		sportColumn.setCellEditor(new DefaultCellEditor(dropKw));
		dropKw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringAuswahl= (String) dropKw.getSelectedItem();
				int auswahl = Integer.parseInt(stringAuswahl);
				int zeile =dropKw.getSelectedIndex();
			}
		
		});
		
		
		// Suche Button 
		JButton sucheButton = new JButton("Suche");
		sucheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sucheInhalt = textField.getText();
				
				suchListe =  new ArrayList<ComStrichart>();
				
				
				for ( ComStrichart s : MeineListe){
					try{
					if ((s.getStrichBez().contains(sucheInhalt)) || (s.getIdStrichart()==((Integer.parseInt(sucheInhalt)))))
					{
						suchListe.add(s);
					}
					}
					catch (NumberFormatException e){
						
					}
				}
				int suchzaehler = 0;

				for (ComStrichart s : suchListe){
					
					rowData[suchzaehler][0]=""+s.getIdStrichart();
					rowData[suchzaehler][1]=""+s.getStrichBez();
					rowData_1[suchzaehler][0]="";
					rowData_1[suchzaehler][1]="";
					suchzaehler++;
					
					
				}
				for (int i = suchListe.size(); i < MeineListe.size(); i++){
					rowData[i][0]="";
					rowData[i][1]="";
					rowData_1[i][0]="";
					rowData_1[i][1]="";
					
				}
				
				table.updateUI();
				table.repaint();
				table_1.updateUI();
				table_1.repaint();
					
				
			}
		});
		sucheButton.setBackground(Color.ORANGE);
		sucheButton.setBounds(543, 119, 99, 41);
		frame.getContentPane().add(sucheButton);
		
		//Reset Button ---------------------------------------------------------------------------
		resetButton = new JButton("Reset");
		resetButton.setBackground(Color.WHITE);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				rowmachen();
				table.updateUI();
				table.repaint();
				table_1.updateUI();
				table_1.repaint();
			}
		});
		resetButton.setBounds(390, 426, 104, 41);
		frame.getContentPane().add(resetButton);
		//Reset Button ---------------------------------------------------------------------------
		
		
		//Abschicken Button
		abschickenButton = new JButton("Abschicken");
		abschickenButton.setBackground(Color.ORANGE);
		abschickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 for (int i = 0; i < anzahl; i++) {
					  
					  
					  String auslese = table_1.getValueAt(i, 0).toString();
					  uebergabeArray[i][0]="";
					  uebergabeArray[i][1]="";
					  uebergabeArray[i][2]="";
					  uebergabeArray[i][3]="";
					  
					  
					  
					  System.out.println(auslese);
//					  //rowData[i][2]=auslese;

					  try{int a = Integer.parseInt(auslese);
					  	System.out.println(auslese+"hallo");
						if (a>0 || false == rowData[i][2].isEmpty() ){
						uebergabeArray[i][0]=rowData[i][0];
						uebergabeArray[i][1]=rowData[i][1];
						uebergabeArray[i][2]=auslese;
						uebergabeArray[i][3]=rowData_1[i][1];	
						
				  }							
						else{
						
					}
					}
						
					catch ( NumberFormatException e ){
						
					}
					  

				  }
  
				  KontrolleStricheln fensterwechselKontrolle = new KontrolleStricheln(uebergabeArray, anzahl, Benutzername, Passwort, port);
				  fensterwechselKontrolle.frame.setVisible(true); 
				   

			}
		});
		abschickenButton.setBounds(60, 426, 147, 41);
		frame.getContentPane().add(abschickenButton);
		
		// HilfeButton -----------------------------------------
		JButton hilfeButton = new JButton("?");
		hilfeButton.setBackground(new Color(255, 250, 240));
		hilfeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StrichelnHilfe fensterwechselHilfe = new StrichelnHilfe();
				  fensterwechselHilfe.setVisible(true);
				  //frame.setVisible(false);
				
			}
		});
		hilfeButton.setBounds(10, 515, 48, 36);
		frame.getContentPane().add(hilfeButton);
		// HilfeButton -----------------------------------------
		
		// Textfield 
		textField = new JTextField();
		textField.setBounds(60, 119, 434, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//Fenstergrˆﬂe- F¸r Juli!
		frame.setSize ( 800, 600);

	}
	
	// Dynamische Erstellung von Table
		private void rowmachen(){
			
			int zaehler=0;
			for (ComStrichart s : MeineListe){
				rowData[zaehler][0]=""+s.getIdStrichart();
				rowData[zaehler][1]=""+s.getStrichBez();
				rowData_1[zaehler][0]="";
				rowData_1[zaehler][1]="";
				
				uebergabeArray[zaehler][0]="";
				uebergabeArray[zaehler][1]="";
				uebergabeArray[zaehler][2]="";
				uebergabeArray[zaehler][3]="";
				zaehler++;
			}

		}

}
