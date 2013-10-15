package Oberflaeche;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

import Webservice.Webservice;
import Webservice.WebserviceService;

public class LoginFenster implements ActionListener{

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPasswort;
    private JButton btnLogin;
    private Webservice port;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFenster window = new LoginFenster();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFenster() {
		initialize();
        WebserviceService service = new WebserviceService();
      	port = service.getWebservicePort();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(193, 11, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Name");
		lblPasswort.setBounds(110, 14, 46, 14);
		frame.getContentPane().add(lblPasswort);
		
		JLabel lblPasswort_1 = new JLabel("Passwort");
		lblPasswort_1.setBounds(110, 54, 46, 14);
		frame.getContentPane().add(lblPasswort_1);
		
		txtPasswort = new JTextField();
		txtPasswort.setBounds(193, 51, 86, 20);
		frame.getContentPane().add(txtPasswort);
		txtPasswort.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(193, 114, 89, 23);
		btnLogin.addActionListener(this);
		frame.getContentPane().add(btnLogin);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin){
            System.out.println("Button geklickt!");


            if(port.login(txtName.getText(), txtPasswort.getText())){
            	System.out.println("eingeloggt :D");
            }
            else{
            	System.out.println("ging wohl nicht");
            }
        } 
	} 
	
}
