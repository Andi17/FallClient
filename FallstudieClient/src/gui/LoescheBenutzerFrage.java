	package gui;
	import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import Webservice.Webservice;
import java.awt.Color;
	@SuppressWarnings("serial")
	public class LoescheBenutzerFrage extends JDialog {
		private String Benutzername;
		private String Passwort;
		private Webservice port;
		private String loescheBenutzer;
		private final JPanel contentPanel = new JPanel();
	
		public LoescheBenutzerFrage(String Benutzername, String Passwort,
				Webservice port, String loescheBenutzer) {
			this.Benutzername = Benutzername;
			this.Passwort = Passwort;
			this.port = port;
			this.loescheBenutzer = loescheBenutzer;
			initialize();
		}
		private void initialize(){
			setResizable(false);
			setBackground(new Color(255, 250, 240));
			setBounds(100, 100, 460, 180);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBackground(new Color(255, 250, 240));
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JTextPane txtpnWollenSieDen = new JTextPane();
				txtpnWollenSieDen.setBackground(new Color(255, 250, 240));
				txtpnWollenSieDen.setEditable(false);
				txtpnWollenSieDen.setText("Wollen Sie den folgenden Benutzer wirklich l\u00F6schen?");
				txtpnWollenSieDen.setBounds(70, 20, 340, 22);
				contentPanel.add(txtpnWollenSieDen);
			}
			{
				JLabel lblBenutzername = new JLabel(loescheBenutzer);
				lblBenutzername.setBackground(new Color(255, 250, 240));
				lblBenutzername.setBounds(190, 69, 75, 16);
				contentPanel.add(lblBenutzername);
			}
			{
				JButton okButton = new JButton("Ja");
				okButton.setBackground(Color.ORANGE);
				okButton.setBounds(100, 108, 100, 30);
				contentPanel.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						
						if (port.benutzerLoeschen(Benutzername, Passwort, loescheBenutzer)){
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Erfolg",
									"Der Benutzer wurde erfolgreich gelöscht.");
							fehlermeldung.setVisible(true);
						}
						else{
							Fehlermeldung fehlermeldung = new Fehlermeldung(
									"Fehler!",
									"Ein unerwarteter Fehler ist aufgetreten.");
							fehlermeldung.setVisible(true);
						}
							
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Nein");
				cancelButton.setBounds(250, 108, 100, 30);
				contentPanel.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
		}
	}