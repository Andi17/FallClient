package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import Optionen.Optionen;
import java.awt.Color;

@SuppressWarnings("serial")
public class Domaineingabe extends JFrame {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDomain;

	public Domaineingabe() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				initialize();
				
	}

	public void initialize() {
		setTitle("Domain festlegen");
		setResizable(false);
		setBounds(100, 100, 445, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Domain uebernehmen");
			okButton.setBackground(Color.ORANGE);
			okButton.setBounds(110, 60, 202, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Optionen().setDomain(txtDomain.getText());
					Fehlermeldung a = new Fehlermeldung("Aenderungen uebernommen", "Bitte starten Sie das Programm neu");
					a.setVisible(true);

					dispose();				
					
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBounds(325, 60, 104, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblNeueDomain = new JLabel("Neue Domain:");
			lblNeueDomain.setBounds(30, 20, 145, 16);
			contentPanel.add(lblNeueDomain);
		}
		{
			txtDomain = new JTextField();
			txtDomain.setBounds(175, 13, 250, 28);
			contentPanel.add(txtDomain);
			txtDomain.setColumns(10);
		}
	}	
}
