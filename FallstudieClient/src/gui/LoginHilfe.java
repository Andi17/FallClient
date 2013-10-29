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
public class LoginHilfe extends JFrame {

	private final JPanel contentPanel = new JPanel();
	
	public LoginHilfe() {
		setTitle("Login - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 480, 340);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			txtpnTodo.setText("In dem Feld Benutzername geben Sie bitte ihre Personalnummer und im Passwortfeld ihr zugeh\u00F6riges Passwort ein.\n\r\u00DCber den Button Anmelden greifen Sie bei richtiger Eingabe auf die Anwendung  \u201EELASTICO \u2013 Elektronische Arbeitsstatistik \u2013 Information Controll Observation\u201C . \n\nSollte ihr Passwort falsch sein erhalten Sie eine Meldung. Ihr Passwort d\u00FCrfen Sie insgesamt dreimal falsch eingeben bevor Ihr Zugang gesperrt wird.\n\rDer Abbrechen-Button beendet die Anwendung.\n\rFalls Sie ihr Passwort vergessen haben erhalten Sie \u00FCber den Link \u201EPasswort vergessen?\u201C weitere Informationen, wie Sie ihr Passwort zur\u00FCcksetzten k\u00F6nnen.\r");
			txtpnTodo.setEditable(false);
			txtpnTodo.setBackground(new Color(255, 250, 240));
			txtpnTodo.setBounds(12, 16, 468, 244);
			contentPanel.add(txtpnTodo);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(200, 260, 100, 30);
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