package Connexion;

import java.sql.*;

import javax.swing.JOptionPane;


public class connexion {
	public static Connection Connecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
  			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entreprise","root","");
  			//JOptionPane.showMessageDialog(null,"Database Connected");
  			return conn;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "base nn connectee");
			return null;
			
		}
		}
	
	}



