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
					.setText("Mithilfe des Fensters �Administration� k�nnen Sie Benutzer, "
							+ "Organisationseinheiten und Strichkategorien verwalten.\n\r"
							+ "�ber den Button �Benutzer anlegen� unter der Benutzerverwaltung k�nnen Sie einen "
							+ "neuen Benutzer anlegen. "
							+ "Dabei ist es wichtig, dass der Name des Benutzers einmalig ist. "
							+ "Mit dem Button �Benutzer bearbeiten� k�nnen Mitarbeiterdaten und "
							+ "Passw�rter ge�ndert werden. Mit �Benutzer l�schen� k�nnen Sie "
							+ "Benutzerkonten endg�ltig l�schen.\n\r"
							+ "Unter der �berschrift Organisationseinheitenverwaltung k�nnen "
							+ "Sie die Strukturen im Unternehmen anpassen. Sie k�nnen "
							+ "Organisationseinheiten mithilfe des Buttons �Organisationseinheit"
							+ " anlegen� hinzuf�gen. Auch hier ist es wichtig, dass die Bezeichnung"
							+ " einmalig ist. Sollten sich die Bezeichnung, Leiter oder sogar die �bergeordnete Einheit"
							+ " �ndern, kann dies mithilfe des Buttons �Organisationseinheit �ndern�"
							+ " durchgef�hrt werden. Hier kann man auch den Zustand auf inaktiv oder aktiv setzen, da"
							+ " Organisationseinheiten nicht gel�scht werden k�nnen.\n\r"
							+ "Die Systemverwaltung erm�glicht Ihnen neue Strichkategorien "
							+ "hinzuzuf�gen. Dies geschieht mit dem Button �Strichkategorie "
							+ "anlegen�. Wollen Sie die Bezeichnung oder den Zustand einer Strichkategorie "
							+ "ver�ndern, kann dies mithilfe des �Stichkategorie �ndern�-Buttons erledigt "
							+ "werden. Strichkategorien k�nnen ebenso wie Organisationseinheiten nicht gel�scht werden.");
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