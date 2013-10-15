package gui;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
@SuppressWarnings("serial")
public class AnmeldungFalsch extends JDialog {
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AnmeldungFalsch dialog = new AnmeldungFalsch();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public AnmeldungFalsch() {
		setTitle("Login - Fehlgeschlagen");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnDieAnmeldungWar = new JTextPane();
			txtpnDieAnmeldungWar.setEditable(false);
			txtpnDieAnmeldungWar.setBackground(new Color(255, 250, 240));
			txtpnDieAnmeldungWar.setBounds(60, 10, 378, 75);
			//TODO Inhalt
			txtpnDieAnmeldungWar.setText("\n    Die Anmeldung war fehlerhaft. Versuchen Sie es erneut\n    oder wenden Sie sich an Ihren Systemadministrator.");
			contentPanel.add(txtpnDieAnmeldungWar);
		}
		JButton okButton = new JButton("OK");
		okButton.setBounds(180, 90, 100, 30);
		okButton.setBackground(Color.WHITE);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		{
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(Login.class.getResource("/gui/images/IconFragezeichenTransparentFertig3030.png")));
			button.setBorderPainted(false);
			button.setBounds(415, 115, 30, 30);
			button.setBackground(new Color(255, 250, 240));
			contentPanel.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AnmeldungFalschHilfe frmAnmeldungFalschHilfe = new AnmeldungFalschHilfe();
		        	frmAnmeldungFalschHilfe.setVisible(true); 
				}
			});
		}
	}
}