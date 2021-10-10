package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.Dashboard;
import javax.swing.border.EmptyBorder;

import javax.swing.border.EtchedBorder;



public class Authentification extends JFrame implements  ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPanel panel;
	private JLabel lblGestion;
	private JButton btnLogin = new JButton("CONNECTER");
	private JLabel lblcon;
	private JLabel lblbesnes;
	private JLabel lblpass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Authentification.class.getResource("/image/employee (1).png")));
		setTitle("Home");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(805, 591);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblcon = new JLabel("");
		lblcon.setForeground(new Color(0, 128, 128));
		lblcon.setIcon(new ImageIcon(Authentification.class.getResource("/image/bank.png")));
		lblcon.setBounds(308, 112, 147, 143);
		contentPane.add(lblcon);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(100, 295, 68, 31);
		contentPane.add(lblLogin);
		lblLogin.setForeground(new Color(0, 128, 128));
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 13));

		txt_username = new JTextField();
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_username.setBounds(248, 287, 262, 39);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		lblbesnes = new JLabel("");
		lblbesnes.setIcon(new ImageIcon(Authentification.class.getResource("/image/businessman.png")));
		lblbesnes.setBounds(201, 285, 45, 46);
		contentPane.add(lblbesnes);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(100, 358, 89, 31);
		contentPane.add(lblPassword);
		lblPassword.setForeground(new Color(0, 128, 128));
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 13));

		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_password.setBounds(248, 350, 262, 39);
		contentPane.add(txt_password);
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 18));

		btnLogin.setBounds(248, 416, 262, 46);
		btnLogin.addActionListener(this);
		
		lblpass = new JLabel("");
		lblpass.setIcon(new ImageIcon(Authentification.class.getResource("/image/login1.png")));
		lblpass.setBounds(201, 346, 38, 46);
		contentPane.add(lblpass);
		contentPane.add(btnLogin);
		btnLogin.setIcon(new ImageIcon(Authentification.class.getResource("/image/key.png")));

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 105, 898, 2);
		contentPane.add(panel);

		lblGestion = new JLabel("Gestion Entreprise");
		lblGestion.setForeground(new Color(0, 128, 128));
		lblGestion.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 35));
		lblGestion.setBounds(220, 0, 381, 107);
		contentPane.add(lblGestion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 139, 139));
		lblNewLabel.setIcon(new ImageIcon(Authentification.class
				.getResource("/image/bg-body.jpg")));
		lblNewLabel.setBounds(0, 0, 787, 544);
	        contentPane.add(lblNewLabel);
		
	}
	public void close() {
		WindowEvent theEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(theEvent);
	}
	@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()== btnLogin) {
               String lblLogin = txt_username.getText();
               String lblPassword = txt_password.getText();
              
               if(lblPassword.contains("admin") && lblLogin.contains("admin")) {
                   JOptionPane.showMessageDialog(contentPane,"vous êtes connecté avec succès");
                   txt_password.setText(null);
                   txt_username.setText(null);
                   this.dispose();
                   
                   close();
   	       		   JFrame home = new Dashboard();
   	       		   home.setVisible(true);
                   
               }
               else {
                   JOptionPane.showMessageDialog(contentPane, "Informations de connexion invalide","Erreur d'identification",JOptionPane.ERROR_MESSAGE);
                   txt_password.setText(null);
                   txt_username.setText(null);
               }
                
	        }
        
       
    }
}

