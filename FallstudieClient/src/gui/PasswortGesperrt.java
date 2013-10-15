package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PasswortGesperrt extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PasswortGesperrt dialog = new PasswortGesperrt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PasswortGesperrt() {
		setTitle("Benutzerkonto gesperrt");
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(379, 123, 75, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JTextPane txtpnIhrBenutzerkonteWurde = new JTextPane();
		txtpnIhrBenutzerkonteWurde.setText("Ihr Benutzerkonto wurde vor\u00FCbergehend deaktiviert. Setzen Sie sich mit Ihrem Systemadministrator in Verbindung.");
		txtpnIhrBenutzerkonteWurde.setBounds(12, 55, 448, 42);
		contentPanel.add(txtpnIhrBenutzerkonteWurde);
	}

}
