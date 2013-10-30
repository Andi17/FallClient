package guiOrgaEinheitVerwaltung;

import gui.ErfolgEingabe;
import gui.Fehlermeldung;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class BearbeitungOrgaEinheitFrage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public BearbeitungOrgaEinheitFrage(final String Benutzer, final String Passwort,
			final Webservice port, final BearbeitungOrgaEinheit fenster,
			final String OrgaEinheitBez, final String neueBez, final String neuerLeiter,
			final String neueUeberOrga, final boolean neuerZustand, final boolean zustandGeaendert) {
		setTitle("Organisationseinheit - Ändern");
		setResizable(false);
		setBackground(Color.WHITE);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnWollenSieDie = new JTextPane();
			txtpnWollenSieDie.setEditable(false);
			txtpnWollenSieDie.setBackground(new Color(255, 250, 240));
			txtpnWollenSieDie.setText("Zu \u00E4ndernde Organisationseinheit: "
					+ OrgaEinheitBez);
			txtpnWollenSieDie.setBounds(10, 11, 324, 21);
			contentPanel.add(txtpnWollenSieDie);
		}
		int anzahlAenderungen = 1;
		{
			if (neueBez != null) {
				JTextPane txtpnWollenSieDie = new JTextPane();
				txtpnWollenSieDie.setEditable(false);
				txtpnWollenSieDie.setBackground(new Color(255, 250, 240));
				txtpnWollenSieDie.setText("Neue Bezeichnung: " + neueBez);
				txtpnWollenSieDie.setBounds(10, 11 + 21 * anzahlAenderungen,
						324, 21);
				contentPanel.add(txtpnWollenSieDie);
				anzahlAenderungen++;
			}

		}
		{
			if (neuerLeiter != null) {
				JTextPane txtpnWollenSieDie = new JTextPane();
				txtpnWollenSieDie.setEditable(false);
				txtpnWollenSieDie.setBackground(new Color(255, 250, 240));
				txtpnWollenSieDie.setText("Neuer Leiter: " + neuerLeiter);
				txtpnWollenSieDie.setBounds(10, 11 + 21 * anzahlAenderungen,
						324, 21);
				contentPanel.add(txtpnWollenSieDie);
				anzahlAenderungen++;
			}
		}
		{
			if (neueUeberOrga != null) {
				JTextPane txtpnWollenSieDie = new JTextPane();
				txtpnWollenSieDie.setEditable(false);
				txtpnWollenSieDie.setBackground(new Color(255, 250, 240));
				txtpnWollenSieDie.setText("Neue übergeordnete Einheit: "
						+ neueUeberOrga);
				txtpnWollenSieDie.setBounds(10, 11 + 21 * anzahlAenderungen,
						324, 21);
				contentPanel.add(txtpnWollenSieDie);
				anzahlAenderungen++;
			}
		}
		{
			if(zustandGeaendert){
				String neuerZustandString;
				if (neuerZustand)
					neuerZustandString = "aktiv";
				else
					neuerZustandString = "inaktiv";
				JTextPane txtpnWollenSieDie = new JTextPane();
				txtpnWollenSieDie.setEditable(false);
				txtpnWollenSieDie.setBackground(new Color(255, 250, 240));
				txtpnWollenSieDie.setText("Neuer Zustand: " + neuerZustandString);
				txtpnWollenSieDie.setBounds(10, 11 + 21 * anzahlAenderungen, 324,
						21);
				contentPanel.add(txtpnWollenSieDie);
				anzahlAenderungen++;
			}
		}
		{
			JLabel lblOrgaeinheit = new JLabel(
					"Wollen Sie diese Organisationseinheit \u00E4ndern?");
			lblOrgaeinheit.setBackground(new Color(255, 250, 240));
			lblOrgaeinheit.setBounds(87, 43 + 21 * anzahlAenderungen, 284, 16);
			contentPanel.add(lblOrgaeinheit);
		}
		{
			JButton buttonNein = new JButton("Nein");
			buttonNein.setBackground(Color.WHITE);
			buttonNein.setBounds(250, 94 + 21 * anzahlAenderungen, 100, 30);
			contentPanel.add(buttonNein);
			buttonNein.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonNein.setActionCommand("OK");
		}
		{
			JButton buttonJa = new JButton("Ja");
			buttonJa.setBackground(Color.ORANGE);
			buttonJa.setBounds(99, 94 + 21 * anzahlAenderungen, 100, 30);
			contentPanel.add(buttonJa);
			buttonJa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Aktion
					// TODO Exception Abfrage durch RŸckgabewert der DB

					boolean bezeichnungGeaendert = true;
					boolean leiterGeaendert = true;
					boolean ueberOrgaEinheitGeaendert = true;
					boolean zustandErfolgreichGeaendert = true;
					if(zustandGeaendert)
						zustandErfolgreichGeaendert = port.orgaEinheitZustandAendern(Benutzer, Passwort, OrgaEinheitBez, neuerZustand);
					if(neueBez!=null)
						bezeichnungGeaendert = port.orgaEinheitBezeichnungAendern(Benutzer, Passwort, OrgaEinheitBez, neueBez);
					if(neuerLeiter!=null)
						leiterGeaendert = port.orgaEinheitLeiterAendern(Benutzer, Passwort, OrgaEinheitBez, neuerLeiter);
					if(neueUeberOrga!=null)
						ueberOrgaEinheitGeaendert = port.orgaEinheitUeberOrgaEinheitAendern(Benutzer, Passwort, OrgaEinheitBez, neueUeberOrga);
					if(bezeichnungGeaendert && leiterGeaendert && ueberOrgaEinheitGeaendert && zustandErfolgreichGeaendert){
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						fenster.dispose();
						dispose();
					}else{
						Fehlermeldung fehler = new Fehlermeldung("Fehler!", "Ein unerwarteter Fehler ist aufgetreten.");
						fehler.setVisible(true);
					}
					

				}
			});
			getRootPane().setDefaultButton(buttonJa);
		}
		setBounds(100, 100, 460, 180 + 21 * anzahlAenderungen);
	}

}
