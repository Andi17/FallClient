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
public class StrichelnHilfe extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			StrichelnHilfe dialog = new StrichelnHilfe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StrichelnHilfe() {
		setTitle("Stricheln - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 600, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			txtpnTodo.setText("Der Tab Stricheln erm\u00F6glicht Ihnen ihre Striche f\u00FCr bearbeitete Vorg\u00E4nge eintragen.\r\n\r\nDas Suchen-Feld erm\u00F6glicht Ihnen Kategorien zu Suchen. Geben Sie hierzu den Suchbegriff, der entweder die Kategorie oder die zugeh\u00F6rigen Nummer sein kann, in das Textfeld ein und dr\u00FCcken Sie auf den Button \u201ESuche\u201C um diese zu starten. Bitte achten Sie hierbei auf Gro\u00DF- und Kleinschreibung, sowie Rechtschreibfehler.\r\n\r\nDas Stricheln f\u00FChren Sie mit der Eingabe der Anzahl der Striche zu der passenden Kategorie und der Kalenderwoche durch. Die Kalenderwoche k\u00F6nnen Sie mithilfe eines Dropdown-Men\u00FCs ausw\u00E4hlen. Um die eingegeben Striche zu \u00FCbernehmen best\u00E4tigen Sie Ihre Eingabe mit der Enter-Taste.\r\n\r\nIst Ihre Kategorie nicht aufgef\u00FChrt wenden Sie sich bitte an einen Systemadministrator oder erkundigen Sie sich bei Ihrem Vorgesetzten ob die gesuchte Kategorie einer anderen zugeordnet werden kann.\r\n\r\nDer Button \u201EAbschicken\u201C  bringt Sie zu einer \u00DCbersicht mit welcher Sie Ihre Eingabe \u00FCberpr\u00FCfen k\u00F6nnen  und gegebenenfalls \u00FCber den \u201EAbbrechen\u201C-Button bei der \u00DCbersicht zu dem aktuellen Fenster \u201EStricheln\u201C  mit Ihren Eingaben zur\u00FCckkehren.\r\n\r\nM\u00F6chten Sie Ihre Angaben auf die Standardwerte zur\u00FCcksetzten k\u00F6nnen Sie hierzu den \u201EReset\u201C-Button verwenden.");
			txtpnTodo.setEditable(false);
			txtpnTodo.setBackground(new Color(255, 250, 240));
			txtpnTodo.setBounds(10, 11, 574, 346);
			contentPanel.add(txtpnTodo);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(250, 368, 100, 30);
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