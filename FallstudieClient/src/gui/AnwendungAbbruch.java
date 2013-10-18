package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class AnwendungAbbruch extends JDialog {
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			AnwendungAbbruch dialog = new AnwendungAbbruch();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AnwendungAbbruch() {
		setTitle("Elastico - Beenden");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		setBounds(100, 100, 460, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblWollenSieDie = new JLabel("M\u00F6chten Sie Elastico wirklich beenden?");
			lblWollenSieDie.setBounds(120, 25, 245, 16);
			contentPanel.add(lblWollenSieDie);
		}
		{
			JButton okButton = new JButton("Ja");
			okButton.setBounds(120, 68, 100, 30);
			okButton.setBackground(Color.ORANGE);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			okButton.setActionCommand("Ja");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.setBounds(245, 68, 100, 30);
			cancelButton.setBackground(Color.WHITE);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Nein");
		}
	}
}