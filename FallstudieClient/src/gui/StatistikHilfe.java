package gui;
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
public class StatistikHilfe extends JFrame {
	private final JPanel contentPanel = new JPanel();

	public StatistikHilfe() {
		setTitle("Statistik - Hilfe");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(50, 50, 600, 350);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Hauptseite.class.getResource("/gui/images/LogoFinal.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnTodo = new JTextPane();
			txtpnTodo.setText("Mithilfe des Fensters „Statistik“ können Sie sich " +
					"Statistiken ausgeben lassen.\n\r" +
					"Wählen Sie dazu zunächst ein Jahr in dem entsprechenden" +
					" Dropdown-Menü aus. Anschließend können Sie unter „Kalenderwoche“" +
					" entweder eine bestimmte Woche oder „Alle“ auswählen." +
					" Entscheiden Sie sich für alle, wird eine Jahresstatistik " +
					"ausgegeben. Unter „Organisationseinheit“ können Sie eine Einheit " +
					"auswählen, falls Sie eine Einzelstatistik brauchen. Wählen Sie " +
					"„Gesamtstatistik“, tauchen alle Einheiten in der Statistik auf, " +
					"für die Sie berechtigt sind.\n\r" +
					"Mit  dem Button „Statistik“ können Sie anschließend die von " +
					"Ihnen ausgewählte Statistik in Form einer Tabelle abrufen. " +
					"Diese kann anschließend auch ausgedruckt werden.\n\r" +
					"Für eine bessere Übersicht können Sie alternativ auch die " +
					"Statistik in einem Balkendiagramm anzeigen lassen. Klicken Sie " +
					"hierfür auf den Button „Balkendiagramm“.");
			txtpnTodo.setEditable(false);
			txtpnTodo.setBackground(new Color(255, 250, 240));
			txtpnTodo.setBounds(6, 6, 588, 248);
			contentPanel.add(txtpnTodo);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(250, 281, 100, 30);
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