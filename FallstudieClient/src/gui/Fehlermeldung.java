package gui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
@SuppressWarnings("serial")
public class Fehlermeldung extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public Fehlermeldung(String title, String inhalt) {
		setTitle(title);
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 460, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnIhreEingabeWurde = new JTextPane();
		txtpnIhreEingabeWurde.setBackground(new Color(255, 250, 240));
		txtpnIhreEingabeWurde.setEditable(false);
		txtpnIhreEingabeWurde.setText(inhalt);
		txtpnIhreEingabeWurde.setBounds(100, 26, 294, 50);
		contentPanel.add(txtpnIhreEingabeWurde);
		{
			JButton okButton = new JButton("OK");
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(180, 78, 100, 30);
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