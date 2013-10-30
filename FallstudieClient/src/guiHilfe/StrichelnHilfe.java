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
			txtpnTodo.setText("Mithilfe des Fensters �Stricheln� k�nnen Sie ihre Striche" +
					" f�r bearbeitete Vorg�nge eintragen.\n\r" +
					"Das Suchen-Feld erm�glicht es Ihnen nach Kategorien zu Suchen. " +
					"Geben Sie hierzu die Bezeichnung oder auch nur einen Teil davon " +
					"in das Textfeld ein und dr�cken Sie auf den Button �Suche� um diese" +
					" zu starten. Die Suchergebnisse werden dann ganz oben in der " +
					"Auflistung der Kategorien angezeigt.\n\r" +
					"Stricheln k�nnen Sie, indem Sie die Anzahl der neuen" +
					" Striche in die Eingabefelder neben der passenden Kategorie " +
					"eintragen. Ob die Striche f�r die aktuelle oder vorherige" +
					" Kalenderwoche z�hlen sollen, k�nnen Sie mithilfe des" +
					" Dropdown-Men�s daneben ausw�hlen. Um die eingegeben " +
					"Striche zu �bernehmen best�tigen Sie Ihre Eingabe mit dem " +
					"Button �Abschicken�.\n\r" +
					"Ist Ihre Kategorie nicht aufgef�hrt wenden Sie sich bitte" +
					" an einen Systemadministrator oder erkundigen Sie sich bei" +
					" Ihrem Vorgesetzten, ob die gesuchte Kategorie einer anderen" +
					" zugeordnet werden kann.\n\r" +
					"M�chten Sie Ihre Angaben verwerfen und die Reihenfolge der " +
					"Strichkategorien zur�cksetzen k�nnen Sie hierzu den " +
					"�Reset�-Button verwenden.");
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