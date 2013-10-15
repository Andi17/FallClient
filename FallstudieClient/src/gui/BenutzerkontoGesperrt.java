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
public class BenutzerkontoGesperrt extends JDialog {
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BenutzerkontoGesperrt dialog = new BenutzerkontoGesperrt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public BenutzerkontoGesperrt() {
		setTitle("Benutzerkonto gesperrt");
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 460, 180);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setResizable(false); 
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(180, 90, 100, 30);
			okButton.setBackground(Color.WHITE);
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
		txtpnIhrBenutzerkonteWurde.setBackground(new Color(255, 250, 240));
		txtpnIhrBenutzerkonteWurde.setText("Ihr Benutzerkonto wurde vor\u00FCbergehend deaktiviert. Setzen Sie sich mit Ihrem Systemadministrator in Verbindung.");
		txtpnIhrBenutzerkonteWurde.setBounds(70, 24, 331, 53);
		txtpnIhrBenutzerkonteWurde.setEditable(false);
		contentPanel.add(txtpnIhrBenutzerkonteWurde);
	}
}