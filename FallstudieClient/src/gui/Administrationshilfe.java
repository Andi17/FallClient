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
		setBounds(50, 50, 600, 410);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			txtpnTodo
					.setText("Mithilfe des Fensters „Administration“ können Sie Benutzer, "
							+ "Organisationseinheiten und Strichkategorien verwalten.\n\r"
							+ "Über den Button „Benutzer anlegen“ unter der Benutzerverwaltung können Sie einen "
							+ "neuen Benutzer anlegen. "
							+ "Dabei ist es wichtig, dass der Name des Benutzers einmalig ist. "
							+ "Mit dem Button „Benutzer bearbeiten“ können Mitarbeiterdaten und "
							+ "Passwörter geändert werden. Mit „Benutzer löschen“ können Sie "
							+ "Benutzerkonten endgültig löschen.\n\r"
							+ "Unter der Überschrift Organisationseinheitenverwaltung können "
							+ "Sie die Strukturen im Unternehmen anpassen. Sie können "
							+ "Organisationseinheiten mithilfe des Buttons „Organisationseinheit"
							+ " anlegen“ hinzufügen. Auch hier ist es wichtig, dass die Bezeichnung"
							+ " einmalig ist. Sollten sich die Bezeichnung, Leiter oder sogar die übergeordnete Einheit"
							+ " ändern, kann dies mithilfe des Buttons „Organisationseinheit ändern“"
							+ " durchgeführt werden. Hier kann man auch den Zustand auf inaktiv oder aktiv setzen, da"
							+ " Organisationseinheiten nicht gelöscht werden können.\n\r"
							+ "Die Systemverwaltung ermöglicht Ihnen neue Strichkategorien "
							+ "hinzuzufügen. Dies geschieht mit dem Button „Strichkategorie "
							+ "anlegen“. Wollen Sie die Bezeichnung oder den Zustand einer Strichkategorie "
							+ "verändern, kann dies mithilfe des „Stichkategorie ändern“-Buttons erledigt "
							+ "werden. Strichkategorien können ebenso wie Organisationseinheiten nicht gelöscht werden.");
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