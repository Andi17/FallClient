package gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Administrationshilfe extends JFrame {
	private final JPanel contentPanel = new JPanel();

	public Administrationshilfe() {
		setTitle("Administration - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 600, 410);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			txtpnTodo
					.setText("Der Tab \u201EAdministration\u201C gibt Ihnen die M\u00F6glichkeiten Benutzer, Organisationseinheiten(OE) und das System zu verwalten.\n\rBei der Benutzerverwaltung k\u00F6nnen Sie einen neuen Benutzer anlegen. Hierzu ben\u00F6tigen Sie die Daten des Mitarbeiters. Wichtig ist, dass der Name einmalig ist. Sollte bereits ein Mitarbeiter mit demselben Namen bereits existieren, behelfen Sie sich bitte mit der Abk\u00FCrzung des Zweitnamens.\n\rMit dem Button \u201EBenutzer bearbeiten\u201C k\u00F6nnen Mitarbeiterdaten und Passwort ge\u00E4ndert werden. \r\u201EBenutzer l\u00F6schen\u201C f\u00FChrt dazu, dass Sie einen Benutzer, welche aus dem Unternehmen ausscheiden, aus dem System entfernen.\rUnter der \u00DCberschrift Organisationseinheitenverwaltung k\u00F6nnen Sie die Struktur im Unternehmen anpassen.  Sie k\u00F6nnen Organisationseinheiten mithilfe des Buttons \u201EOrganisationseinheit anlegen\u201C hinzuf\u00FCgen. Sollte sich der Name einer OE \u00E4ndern kann dies mithilfe des Buttons \u201EOrganisationseinheit \u00E4ndern\u201C durchgef\u00FChrt werden.\n\rDie Systemverwaltung erm\u00F6glicht Ihnen neue Strichkategorien hinzuzuf\u00FCgen. Dies geschieht mit dem Button \u201EStrichkategorie anlegen\u201C . Sollte sich bei der Kategorie der Name ver\u00E4ndern kann dies mithilfe des \u201EStichkategorie \u00E4ndern\u201C-Buttons erledigt werden.\r");
			txtpnTodo.setEditable(false);
			txtpnTodo.setBackground(new Color(255, 250, 240));
			txtpnTodo.setBounds(6, 6, 588, 321);
			contentPanel.add(txtpnTodo);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(260, 330, 100, 30);
			okButton.setBackground(Color.WHITE);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
}