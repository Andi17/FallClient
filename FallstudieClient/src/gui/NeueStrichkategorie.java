package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Webservice.Webservice;
import java.awt.Color;

@SuppressWarnings("serial")
public class NeueStrichkategorie extends JDialog {

	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStrichkategorie;

	/**
	 * Launch the application.
	 */
	public NeueStrichkategorie(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {
		setTitle("Strichkategorie - Anlegen");
		//TODO Inhalt
		setResizable(false);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Strichkategorie hinzuf\u00FCgen");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(127, 112, 202, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergabe von "strichkategorie" an "NeueStrichkategorieFrage"
					String neueStrichkategorie = txtStrichkategorie.getText();
					try{
						if (port.gibtEsStrichelBezeichnungSchon(Benutzername, Passwort, neueStrichkategorie)){
							txtStrichkategorie.setText("");
							
						}
						else{
										
						NeueStrichkategorieFrage NeueStrichkategorieFrage = new NeueStrichkategorieFrage(Benutzername, Passwort, port, txtStrichkategorie.getText());
						NeueStrichkategorieFrage.setVisible(true);
						dispose();
						}
					}
					catch (NumberFormatException a){
						txtStrichkategorie.setText("");
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBounds(340, 112, 104, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblNeueStrichkategorie = new JLabel("Neue Strichkategorie:");
			lblNeueStrichkategorie.setBounds(55, 57, 142, 16);
			contentPanel.add(lblNeueStrichkategorie);
		}
		{
			txtStrichkategorie = new JTextField();
			txtStrichkategorie.setBounds(209, 51, 202, 28);
			contentPanel.add(txtStrichkategorie);
			txtStrichkategorie.setColumns(10);
		}
	}

	

}
