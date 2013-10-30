package gui;

import guiHilfe.LoginHilfe;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.ImageIcon;

import tools.SonderzeichenTest;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	/*
	 * Loginmaske
	 */

	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBenutzername;
	private JPasswordField pwdPasswort;
	private int zaehler = 0;

	public Login(Webservice port) {
		this.port = port;
		initialize();
	}
/*
 * aufbau des Fensters
 */
	private void initialize() {
		setResizable(false);
		setTitle("Login - Elastico");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtBenutzername = new JTextField();
			txtBenutzername
					.setToolTipText("Geben Sie Ihren Benutzernamen ein.");
			txtBenutzername.setBounds(145, 36, 134, 25);
			contentPanel.add(txtBenutzername);
			txtBenutzername.setColumns(10);
		}
		{
			JButton btnPasswortVergessen = new JButton("Passwort vergessen?");
			btnPasswortVergessen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * Erstellung eines Popups
					 */
					Fehlermeldung frmPasswortVergessen = new Fehlermeldung(
							"Passwort vergessen",
							"Falls Sie Ihr Passwort vergessen haben, wenden Sie sich bitte an den Systemadministrator.");
					frmPasswortVergessen.setVisible(true);
				}
			});
			btnPasswortVergessen.setBounds(30, 169, 160, 30);
			btnPasswortVergessen.setBackground(Color.WHITE);
			contentPanel.add(btnPasswortVergessen);
		}
		{
			pwdPasswort = new JPasswordField();
			pwdPasswort.setBounds(145, 66, 134, 25);
			contentPanel.add(pwdPasswort);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(30, 42, 103, 16);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblPasswort = new JLabel("Passwort:");
			lblPasswort.setBounds(30, 72, 61, 16);
			contentPanel.add(lblPasswort);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel
					.setIcon(new ImageIcon(
							Login.class
									.getResource("/gui/images/LogoFinalTransparentFertig.png")));
			lblNewLabel.setBounds(323, 0, 130, 130);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(
					Login.class
							.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
			button.setBorderPainted(false);
			button.setBounds(400, 169, 30, 30);
			button.setBackground(new Color(255, 250, 240));
			contentPanel.add(button);
			JButton anmeldenButton = new JButton("Anmelden");
			anmeldenButton.setBounds(30, 119, 100, 30);
			anmeldenButton.setBackground(Color.ORANGE);
			contentPanel.add(anmeldenButton);
			anmeldenButton.addActionListener(new ActionListener() {

				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					/*
					 * "Anmelden" wird ausgeführt.
					 * 
					 * zunächst prüfung auf plausible Eingabe:
					 * Sonderzeichenztest
					 * Benutzer Existent
					 * 
					 */
					SonderzeichenTest sonderzeichen = new SonderzeichenTest();
					Benutzername = txtBenutzername.getText();
					if (sonderzeichen.test(Benutzername) == true) {
						Fehlermeldung fehler = new Fehlermeldung("Fehler!",
								"Der Benutzername darf nur aus Buchstaben und Zahlen bestehen.");
						fehler.setVisible(true);
					} else {
						Passwort = pwdPasswort.getText();
						int status = port.login(Benutzername, Passwort);
						if (status == 1) {
							/*
							 * Hauptseite wird erstellt
							 */
							Hauptseite frmElasticoElektronische = new Hauptseite(
									Benutzername, Passwort, port);
							frmElasticoElektronische.frmElasticoElektronische
									.setVisible(true);
							dispose();
						} else if (status == 2) {
							Fehlermeldung fehler = new Fehlermeldung(
									"Falsche Eingabe!",
									"Den Benutzernamen gibt es nicht.");
							fehler.setVisible(true);
						} else if (status == 3) {
							Fehlermeldung fehler = new Fehlermeldung(
									"Falsche Eingabe!",
									"Ihr Benutzer ist gesperrt.");
							fehler.setVisible(true);
							zaehler = 0;
						} else {
							if (zaehler < 3) {
								Fehlermeldung fehler = new Fehlermeldung(
										"Falsche Eingabe!",
										"Das Passwort stimmt nicht. Sie dürfen noch "
												+ (2 - zaehler)
												+ " Mal ihr Passwort falsch eingeben.");
								fehler.setVisible(true);
							} else {
								port.passwortSperren(Benutzername);
								Fehlermeldung fehler = new Fehlermeldung(
										"Gesperrt!",
										"Ihr Benutzer ist nun gesperrt.");
								fehler.setVisible(true);
							}
							zaehler++;
						}
					}
				}
			});
			anmeldenButton.setActionCommand("Anmelden");
			getRootPane().setDefaultButton(anmeldenButton);
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.setBounds(145, 119, 100, 30);
				cancelButton.setBackground(Color.WHITE);
				contentPanel.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
						frmAnwendungAbbruch.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginHilfe frmLoginHilfe = new LoginHilfe();
					frmLoginHilfe.setVisible(true);
				}
			});
		}
	}
}
