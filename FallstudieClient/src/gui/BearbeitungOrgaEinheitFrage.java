package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class BearbeitungOrgaEinheitFrage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			BearbeitungOrgaEinheitFrage dialog = new BearbeitungOrgaEinheitFrage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BearbeitungOrgaEinheitFrage() {
		setTitle("Organisationseinheit - Deaktivieren");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblOrgaeinheit = new JLabel("Wollen Sie diese Organisationseinheit \u00E4ndern?");
			lblOrgaeinheit.setBackground(new Color(255, 250, 240));
			lblOrgaeinheit.setBounds(87, 43, 284, 16);
			contentPanel.add(lblOrgaeinheit);
		}
		{
			JTextPane txtpnWollenSieDie = new JTextPane();
			txtpnWollenSieDie.setEditable(false);
			txtpnWollenSieDie.setBackground(new Color(255, 250, 240));
			txtpnWollenSieDie.setText("Zu \u00E4ndernde Organisationseinheit: <dynamic>");
			txtpnWollenSieDie.setBounds(10, 11, 324, 21);
			contentPanel.add(txtpnWollenSieDie);
		}
		{
			JButton btnJa = new JButton("Ja");
			btnJa.setBackground(Color.ORANGE);
			btnJa.setBounds(99, 94, 100, 30);
			contentPanel.add(btnJa);
			{
				JButton okButton = new JButton("Nein");
				okButton.setBackground(Color.WHITE);
				okButton.setBounds(250, 94, 100, 30);
				contentPanel.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			btnJa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					//TODO Exception Abfrage durch RŸckgabewert der DB
					
					boolean neueOrgaEinheitgeaendert = true;
					boolean neueOrgaEinheitLeitergeaendert = true;
					boolean ueberOrgaEinheitgeaendert = true;
					boolean rechteLeitergeaendert = true;
					boolean rechteMitarbeitergeaendert = true;
					
					
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
					
				}
			});
		}
	}

}
