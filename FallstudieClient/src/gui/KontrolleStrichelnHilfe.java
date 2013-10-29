package gui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
@SuppressWarnings("serial")
public class KontrolleStrichelnHilfe extends JFrame {
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			KontrolleStrichelnHilfe dialog = new KontrolleStrichelnHilfe();
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public KontrolleStrichelnHilfe() {
		setTitle("KontrolleStricheln - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 416, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			//TODO Inhalt
			txtpnTodo.setText("In der angezeigten Tabelle finden Sie Ihre get\u00E4tigten Eingaben vor. Um diese Eingabe zu best\u00E4tigen klicken Sie den Abschicken-Button. \r\n\r\nSollten sich Fehler vorfinden klicken Sie auf den Abbrechen-Button und Sie kehren zur\u00FCck ins Stricheln-Men\u00FC.");
			txtpnTodo.setEditable(false);
			txtpnTodo.setBackground(new Color(255, 250, 240));
			txtpnTodo.setBounds(6, 6, 400, 85);
			contentPanel.add(txtpnTodo);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(160, 102, 100, 30);
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
