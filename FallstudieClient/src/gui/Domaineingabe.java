package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import main.Start;
import Optionen.Optionen;
import Webservice.Webservice;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("serial")
public class Domaineingabe extends JFrame {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStrichkategorie;

	/**
	 * Launch the application.
	 */
	public Domaineingabe() {
		
				initialize();
				
			

	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {
		setTitle("Domain festlegen");
		//TODO Inhalt
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
					//TODO Aktion
					// †bergabe von "strichkategorie" an "NeueStrichkategorieFrage"
					String neueStrichkategorie = txtStrichkategorie.getText();


					new Optionen().setDomain(txtStrichkategorie.getText());
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
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblNeueStrichkategorie = new JLabel("Neue Domain:");
			lblNeueStrichkategorie.setBounds(30, 20, 145, 16);
			contentPanel.add(lblNeueStrichkategorie);
		}
		{
			txtStrichkategorie = new JTextField();
			txtStrichkategorie.setBounds(175, 13, 250, 28);
			contentPanel.add(txtStrichkategorie);
			txtStrichkategorie.setColumns(10);
		}
	}

	

}
