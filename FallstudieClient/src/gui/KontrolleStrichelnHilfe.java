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
public class KontrolleStrichelnHilfe extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			KontrolleStrichelnHilfe dialog = new KontrolleStrichelnHilfe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public KontrolleStrichelnHilfe() {
		setTitle("KontrolleStricheln - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 600, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			//TODO Inhalt
			txtpnTodo.setText("In der angezeigten Tabelle finden Sie Ihre getätigten Eingaben vor. Um diese Eingabe zu bestätigen klicken Sie den Abschicken-Button. Sollten sich Fehler vorfinden klicken Sie auf den Abbrechen-Button und Sie kehren zurück ins Stricheln-Menü.");
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
