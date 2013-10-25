package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import tools.SonderzeichenTest;
import Webservice.ComStrichart;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungStrichart extends JFrame {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxStrichBez;
	private JTextField txtNeueStrichartBez;
	private JComboBox<String> comboBoxZustand;
	private JButton okButton;
	private boolean zustandGeaendert = false;

	public BearbeitungStrichart(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() {
		setTitle("Strichart - Bearbeiten");
		setBackground(new Color(255, 250, 240));
		setResizable(false);
		setBounds(100, 100, 465, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStrichart = new JLabel("Strichart:");
			lblStrichart.setBounds(30, 20, 150, 30);
			contentPanel.add(lblStrichart);
		}
		{
			JLabel lblBenutzername = new JLabel("Neue Bezeichnung:");
			lblBenutzername.setBounds(30, 50, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblBenutzername = new JLabel("Zustand:");
			lblBenutzername.setBounds(30, 80, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			comboBoxStrichBez = new JComboBox<String>();
			comboBoxStrichBez.setBounds(200, 20, 250, 26);
			contentPanel.add(comboBoxStrichBez);
			// txtBenutzername.setColumns(1);
			List<String> alleStricharten = new ArrayList<String>();
			List<ComStrichart> alleStrichelArten = port.getStrichelArten(Benutzername,
					Passwort, false);
			alleStricharten.add("Bitte auswählen");
			for (ComStrichart strichart : alleStrichelArten) {
				alleStricharten.add(strichart.getStrichBez());
			}
			comboBoxStrichBez.setModel(new ListComboBoxModel<String>(alleStricharten));
			AutoCompleteDecorator.decorate(comboBoxStrichBez);
			comboBoxStrichBez.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String strichart = (String) comboBoxStrichBez
							.getSelectedItem();
					if(!strichart.equals("Bitte auswählen")){
						ComStrichart zuBearbeitendeStrichart = port.getStrichelArt(Benutzername, Passwort, strichart); 
						if(zuBearbeitendeStrichart.isZustand())comboBoxZustand.setSelectedItem("aktiv");
						else comboBoxZustand.setSelectedItem("inaktiv");
						txtNeueStrichartBez.setEditable(true);
						zustandGeaendert = false;
						getRootPane().setDefaultButton(okButton);
					}
					
				}
			});
		}
		{
			txtNeueStrichartBez = new JTextField();
			txtNeueStrichartBez.setBounds(200, 50, 250, 26);
			contentPanel.add(txtNeueStrichartBez);
			txtNeueStrichartBez.setColumns(10);
			txtNeueStrichartBez.setEditable(false);
		}
		{
			okButton = new JButton("\u00C4ndern");
			okButton.setBounds(240, 125, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			final BearbeitungStrichart fenster = this;
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SonderzeichenTest sonderzeichen = new SonderzeichenTest();
					if (sonderzeichen.test(txtNeueStrichartBez.getText())==false)
					{
						String StrichBez = (String) comboBoxStrichBez
								.getSelectedItem();
						if(StrichBez.equals("Bitte auswählen")){
							Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Wählen Sie eine Strichart zum Ändern aus.");
							fehler.setVisible(true);
						}
						else {
							String NeueStrichBez = txtNeueStrichartBez.getText();
							if(!zustandGeaendert && NeueStrichBez.equals("")){
								Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Sie haben keine Werte eingegeben.");
								fehler.setVisible(true);
							}
							else if(port.gibtEsStrichelBezeichnungSchon(Benutzername, Passwort, NeueStrichBez)){
								Fehlermeldung fehlermeldung = new Fehlermeldung(
										"Fehler!",
										"Die gewünschte Strichbezeichnung ist schon vergeben.");
								fehlermeldung.setVisible(true);
							}
							else {
								boolean zustand = true;
								if(comboBoxZustand.getSelectedItem().equals("inaktiv"))zustand=false;
								
								BearbeitungStrichartFrage BearbeitungStrichartFrage = new BearbeitungStrichartFrage(
										Benutzername, Passwort, port, fenster, StrichBez,
										NeueStrichBez, zustand, zustandGeaendert);
								BearbeitungStrichartFrage.setVisible(true);
							}
						}
					}
					else
					{
						Fehlermeldung fehler = new Fehlermeldung(
								"Fehler!",
								"Die Strichartbezeichnung darf nur aus Buchstaben und Zahlen bestehen.");
						fehler.setVisible(true);
					}
				}
			});
			okButton.setActionCommand("OK");
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(new Color(255, 255, 255));
			cancelButton.setBounds(350, 125, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}

		String[] zustand = {"aktiv", "inaktiv"};
		comboBoxZustand = new JComboBox<String>(zustand);
		comboBoxZustand.setBounds(200, 80, 250, 26);
		comboBoxZustand.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				zustandGeaendert = true;
			}
		});
		contentPanel.add(comboBoxZustand);
	}
}