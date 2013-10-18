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
public class ErfolgEingabe extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ErfolgEingabe dialog = new ErfolgEingabe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ErfolgEingabe() {
		setTitle("Erfolgreiche Eingabe");
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
		txtpnIhreEingabeWurde.setText("Ihre Eingabe wurde erfolgreich \u00FCbernommen.");
		txtpnIhreEingabeWurde.setBounds(100, 26, 294, 29);
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