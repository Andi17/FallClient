package guiHilfe;
import gui.Hauptseite;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class StrichelnHilfe extends JFrame {
	private final JPanel contentPanel = new JPanel();

	public StrichelnHilfe() {
		setTitle("Stricheln - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(50, 50, 600, 387);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			txtpnTodo.setText("Mithilfe des Fensters „Stricheln“ können Sie ihre Striche" +
					" für bearbeitete Vorgänge eintragen.\n\r" +
					"Das Suchen-Feld ermöglicht es Ihnen nach Kategorien zu Suchen. " +
					"Geben Sie hierzu die Bezeichnung oder auch nur einen Teil davon " +
					"in das Textfeld ein und drücken Sie auf den Button „Suche“ um diese" +
					" zu starten. Die Suchergebnisse werden dann ganz oben in der " +
					"Auflistung der Kategorien angezeigt.\n\r" +
					"Stricheln können Sie, indem Sie die Anzahl der neuen" +
					" Striche in die Eingabefelder neben der passenden Kategorie " +
					"eintragen. Ob die Striche für die aktuelle oder vorherige" +
					" Kalenderwoche zählen sollen, können Sie mithilfe des" +
					" Dropdown-Menüs daneben auswählen. Um die eingegeben " +
					"Striche zu übernehmen bestätigen Sie Ihre Eingabe mit dem " +
					"Button „Abschicken“.\n\r" +
					"Ist Ihre Kategorie nicht aufgeführt wenden Sie sich bitte" +
					" an einen Systemadministrator oder erkundigen Sie sich bei" +
					" Ihrem Vorgesetzten, ob die gesuchte Kategorie einer anderen" +
					" zugeordnet werden kann.\n\r" +
					"Möchten Sie Ihre Angaben verwerfen und die Reihenfolge der " +
					"Strichkategorien zurücksetzen können Sie hierzu den " +
					"„Reset“-Button verwenden.");
			txtpnTodo.setEditable(false);
			txtpnTodo.setBackground(new Color(255, 250, 240));
			txtpnTodo.setBounds(10, 11, 574, 296);
			contentPanel.add(txtpnTodo);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(250, 318, 100, 30);
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