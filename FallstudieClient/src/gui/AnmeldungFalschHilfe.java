package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

@SuppressWarnings("serial")
public class AnmeldungFalschHilfe extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			AnmeldungFalschHilfe dialog = new AnmeldungFalschHilfe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AnmeldungFalschHilfe() {
		setTitle("Login - Fehlgeschlagen - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnDerGrundFr = new JTextPane();
			txtpnDerGrundFr.setEditable(false);
			txtpnDerGrundFr.setBackground(new Color(255, 250, 240));
			txtpnDerGrundFr.setText("Der Grund f\u00FCr eine fehlerhafte Anmeldung kann sein, dass es Ihren Benutzernamen nicht gibt, oder dass das Passwort nicht zu Ihrem Benutzernamen passt. Achten Sie bei einer erneuten Eingabe auch auf Gro\u00DF- und Kleinschreibung.");
			txtpnDerGrundFr.setBounds(29, 21, 425, 77);
			contentPanel.add(txtpnDerGrundFr);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(192, 100, 100, 30);
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