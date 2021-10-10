package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Dashboard;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.sql.ResultSet;

import Connexion.Requettes;
import Model.Entreprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PanelEntreprise extends JPanel implements  ActionListener {
	private JTextField text_Matricule;
	private JTextField text_NomEntreprise;
	private JTextField text_Description;
	private JTextField text_Banque;
	private JTextField text_Agence;
	private JTextField text_Rib;
	private JTextField text_NumRue;
	private JTextField text_Libelle;
	private JTextField text_CodePostale;
	private JTextField text_NomVille;
	private JTextField text_NumFixe;
	private JTextField text_NumMobile;
	private JTextField text_EtatFiscale;
	private JTextField text_Gouvernorat;
	private JLabel lblBanque;
	private JLabel lblAgence;
	private JLabel lblRib;
	private JLabel lblNumroRue;
	private JLabel lblLibell;
	private JLabel lblNomDeVille;
	private JLabel lblCodePostale;
	private JLabel lblGouvernorat;
	private JLabel lblPays;
	private JTextField text_Pays;
	private JPanel panel;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JTextField text_Faxe;
	private JTextField text_Email;
	private JTextField text_Site;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;


	/**
	 * Create the panel.
	 */
	public PanelEntreprise() {
		setBackground(new Color(211, 211, 211));
		setSize(1256, 774);
		setLayout(null);
		
		JLabel lblMatricule = new JLabel("Matricule Fiscale:");
		lblMatricule.setForeground(new Color(0, 128, 128));
		lblMatricule.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMatricule.setBounds(73, 44, 161, 25);
		add(lblMatricule);
		
		text_Matricule = new JTextField();
		text_Matricule.setBounds(267, 45, 212, 25);
		add(text_Matricule);
		text_Matricule.setColumns(10);
		
		JLabel lblNomEntreprise = new JLabel("Nom Etreprise:");
		lblNomEntreprise.setForeground(new Color(0, 128, 128));
		lblNomEntreprise.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNomEntreprise.setBounds(73, 102, 161, 25);
		add(lblNomEntreprise);
		
		text_NomEntreprise = new JTextField();
		text_NomEntreprise.setColumns(10);
		text_NomEntreprise.setBounds(267, 103, 212, 25);
		add(text_NomEntreprise);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(new Color(0, 128, 128));
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblType.setBounds(567, 44, 107, 25);
		add(lblType);
		
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setModel(new DefaultComboBoxModel(new String[] {"","physique", "morale"}));
		comboBox_Type.setBounds(729, 47, 131, 20);
		add(comboBox_Type);
		
		JLabel lblDescriptionActivit = new JLabel("Description Activit\u00E9:");
		lblDescriptionActivit.setForeground(new Color(0, 128, 128));
		lblDescriptionActivit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDescriptionActivit.setBounds(567, 102, 161, 25);
		add(lblDescriptionActivit);
		
		text_Description = new JTextField();
		text_Description.setColumns(10);
		text_Description.setBounds(732, 103, 212, 25);
		add(text_Description);
		
		JLabel lblCompteBancaire = new JLabel("Compte Bancaire:");
		lblCompteBancaire.setForeground(new Color(0, 128, 128));
		lblCompteBancaire.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCompteBancaire.setBounds(73, 225, 131, 25);
		add(lblCompteBancaire);
		
		text_Banque = new JTextField();
		text_Banque.setBounds(291, 226, 123, 25);
		add(text_Banque);
		text_Banque.setColumns(10);
		
		text_Agence = new JTextField();
		text_Agence.setColumns(10);
		text_Agence.setBounds(291, 261, 123, 25);
		add(text_Agence);
		
		text_Rib = new JTextField();
		text_Rib.setColumns(10);
		text_Rib.setBounds(291, 299, 212, 25);
		add(text_Rib);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setForeground(new Color(0, 128, 128));
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAdresse.setBounds(493, 225, 69, 25);
		add(lblAdresse);
		
		text_NumRue = new JTextField();
		text_NumRue.setColumns(10);
		text_NumRue.setBounds(746, 226, 198, 25);
		add(text_NumRue);
		
		text_Libelle = new JTextField();
		text_Libelle.setColumns(10);
		text_Libelle.setBounds(746, 261, 198, 25);
		add(text_Libelle);
		
		text_CodePostale = new JTextField();
		text_CodePostale.setColumns(10);
		text_CodePostale.setBounds(746, 337, 198, 25);
		add(text_CodePostale);
		
		text_NomVille = new JTextField();
		text_NomVille.setColumns(10);
		text_NomVille.setBounds(746, 299, 198, 25);
		add(text_NomVille);
		
		JLabel lblNumTlFixe = new JLabel("Num t\u00E9l fixe:");
		lblNumTlFixe.setForeground(new Color(0, 128, 128));
		lblNumTlFixe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumTlFixe.setBounds(73, 484, 131, 25);
		add(lblNumTlFixe);
		
		JLabel lblNumTlMobile = new JLabel("Num t\u00E9l mobile:");
		lblNumTlMobile.setForeground(new Color(0, 128, 128));
		lblNumTlMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumTlMobile.setBounds(73, 543, 131, 25);
		add(lblNumTlMobile);
		
		text_NumFixe = new JTextField();
		text_NumFixe.setColumns(10);
		text_NumFixe.setBounds(267, 485, 212, 25);
		add(text_NumFixe);
		
		text_NumMobile = new JTextField();
		text_NumMobile.setColumns(10);
		text_NumMobile.setBounds(267, 544, 212, 25);
		add(text_NumMobile);
		
		JLabel lblEtatFiscale = new JLabel("Etat Fiscale:");
		lblEtatFiscale.setForeground(new Color(0, 128, 128));
		lblEtatFiscale.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEtatFiscale.setBounds(504, 601, 131, 25);
		add(lblEtatFiscale);
		
		text_EtatFiscale = new JTextField();
		text_EtatFiscale.setColumns(10);
		text_EtatFiscale.setBounds(596, 602, 212, 25);
		add(text_EtatFiscale);
		
		text_Gouvernorat = new JTextField();
		text_Gouvernorat.setColumns(10);
		text_Gouvernorat.setBounds(746, 370, 198, 25);
		add(text_Gouvernorat);
		
		lblBanque = new JLabel("Banque:");
		lblBanque.setForeground(new Color(0, 51, 51));
		lblBanque.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBanque.setBounds(216, 230, 60, 16);
		add(lblBanque);
		
		lblAgence = new JLabel("Agence:");
		lblAgence.setForeground(new Color(0, 51, 51));
		lblAgence.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAgence.setBounds(216, 268, 60, 16);
		add(lblAgence);
		
		lblRib = new JLabel("RIB:");
		lblRib.setForeground(new Color(0, 51, 51));
		lblRib.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRib.setBounds(216, 303, 41, 16);
		add(lblRib);
		
		lblNumroRue = new JLabel("Rue:");
		lblNumroRue.setForeground(new Color(0, 51, 51));
		lblNumroRue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumroRue.setBounds(614, 230, 96, 16);
		add(lblNumroRue);
		
		lblLibell = new JLabel("Libell\u00E9:");
		lblLibell.setForeground(new Color(0, 51, 51));
		lblLibell.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLibell.setBounds(614, 265, 60, 16);
		add(lblLibell);
		
		lblNomDeVille = new JLabel("Nom de Ville:");
		lblNomDeVille.setForeground(new Color(0, 51, 51));
		lblNomDeVille.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNomDeVille.setBounds(614, 303, 96, 16);
		add(lblNomDeVille);
		
		lblCodePostale = new JLabel("Code Postale:");
		lblCodePostale.setForeground(new Color(0, 51, 51));
		lblCodePostale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCodePostale.setBounds(614, 341, 96, 16);
		add(lblCodePostale);
		
		lblGouvernorat = new JLabel("Gouvernorat:");
		lblGouvernorat.setForeground(new Color(0, 51, 51));
		lblGouvernorat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGouvernorat.setBounds(614, 374, 96, 16);
		add(lblGouvernorat);
		
		lblPays = new JLabel("Pays:");
		lblPays.setForeground(new Color(0, 51, 51));
		lblPays.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPays.setBounds(614, 412, 96, 16);
		add(lblPays);
		
		text_Pays = new JTextField();
		text_Pays.setColumns(10);
		text_Pays.setBounds(746, 408, 198, 25);
		add(text_Pays);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(884, 589, 168, 85);
		add(panel);
		
		btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		 if (text_Matricule.getText().trim().isEmpty()||
	                      text_NomEntreprise.getText().trim().isEmpty()||text_Description.getText().trim().isEmpty()||
	                      text_NumFixe.getText().trim().isEmpty()||text_NumMobile.getText().trim().isEmpty()||
	                      text_Faxe.getText().trim().isEmpty()||text_Email.getText().trim().isEmpty()||
	                     text_Site.getText().trim().isEmpty()||text_EtatFiscale.getText().trim().isEmpty()){
	                 JOptionPane.showMessageDialog(null,"veillez remplir les champs vides");
	             }
	             else {
	     		try {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			
	    			String url = "jdbc:mysql://localhost:3306/entreprise";
	    			Connection c = DriverManager.getConnection(url,"root","");

	    			Statement stmt = c.createStatement();
	    			
	    			String adresse = text_NumRue.getText()+"/"+text_Libelle.getText()
	    			+"/"+text_NomVille.getText()+"/"+Integer.parseInt( text_CodePostale.getText())+"/"+
	    					text_Gouvernorat.getText()+"/"+text_Pays.getText();
	    			
	    			String banc = text_Banque.getText()+'/'+text_Agence.getText()+'/'+Integer.parseInt(text_Rib.getText());
	    			String type = (String) comboBox_Type.getSelectedItem();
	    			Entreprise ent = new Entreprise(text_Matricule.getText().toString(),text_NomEntreprise.getText().toString(),
	    					type,
	    				text_Description.getText().toString(),banc,adresse,
	    					Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
	    					Integer.parseInt(text_Faxe.getText().toString()),text_Email.getText().toString(),text_Site.getText().toString(),text_EtatFiscale.getText().toString());
	    			
	    			
	    			
	    			
	    			String req= Requettes.ajouter_entreprise(ent);
	    			System.out.println(req);
	    			
	    			int nb=stmt.executeUpdate(req);
	    			if(nb==0)
	    				JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_entreprise" , JOptionPane.OK_OPTION);
	    			else
	    				JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_entreprise" , JOptionPane.OK_OPTION);
	    			
	    			text_Matricule.setText(null);
            		text_NomEntreprise.setText(null);
            		text_Description.setText(null);
            		text_Banque.setText(null);
            		text_Agence.setText(null);
            		text_Rib.setText(null);
            		text_NumRue.setText(null);
            		text_Libelle.setText(null);
            		text_NomVille.setText(null);
            		text_CodePostale.setText(null);
            		text_Gouvernorat.setText(null);
            		text_Pays.setText(null);
            		text_NumFixe.setText(null);
            		text_NumMobile.setText(null);
            		text_Faxe.setText(null);
            		text_Email.setText(null);
            		text_Site.setText(null);
            		text_EtatFiscale.setText(null);
	    		}
	    		
	     		catch (Exception event) {
					JOptionPane.showMessageDialog(null, "helooo");
	    		}
	    	
	    	}
	     	}
		});

	
		btnAjouter.setIcon(new ImageIcon(PanelEntreprise.class.getResource("/image/add.png")));
		btnAjouter.setBounds(12, 13, 65, 65);
		panel.add(btnAjouter);
		
		JButton recuper = new JButton("Recuperer");
		recuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT * FROM entreprise";
				System.out.println(sql);
	       		try {

		       			Class.forName("com.mysql.jdbc.Driver");
		    			String url = "jdbc:mysql://localhost:3306/entreprise";
		    			Connection c = DriverManager.getConnection(url,"root","");
		    			Statement stmt = c.createStatement();
                        pst = c.prepareStatement(sql);
                        rs = pst.executeQuery();

	                	while (rs.next()) {
	                		
	                		String tab[];
	                		String cba = rs.getString("compte_bancaire").toString();
	                		tab = cba.split("/");
	                		String banque = tab[0];
	                		String agence = tab[1];
	                		String rib = tab[2];
	                		
	                		String tab1[];
	                		String ad = rs.getString("adresse").toString();
	                		tab1 = ad.split("/");
	                		String Num = tab1[0];
	                		String Libelle = tab1[1];
	                		String NomVille = tab1[2];
	                		String codepostal = tab1[3];
	                		String Gouvernorat = tab1[4];
	                		String Pays = tab1[5];
	
	                	
	                		text_Matricule.setText(rs.getString("matricule_fiscale").toString());
	                		text_NomEntreprise.setText(rs.getString("raison_sociale").toString());
	                		comboBox_Type.getModel().setSelectedItem(rs.getString("type").toString());
	                		text_Description.setText(rs.getString("description_activite").toString());
	                		text_Banque.setText(banque);
	                		text_Agence.setText(agence);
	                		text_Rib.setText(rib);
	                		text_NumRue.setText(Num);
	                		text_Libelle.setText(Libelle);
	                		text_NomVille.setText(NomVille);
	                		text_CodePostale.setText(codepostal);
	                		text_Gouvernorat.setText(Gouvernorat);
	                		text_Pays.setText(Pays);
	                		text_NumFixe.setText(rs.getString("num_tel_fixe").toString());
	                		text_NumMobile.setText(rs.getString("num_tel_mobile").toString());
	                		text_Faxe.setText(rs.getString("fax").toString());
	                		text_Email.setText(rs.getString("email").toString());
	                		text_Site.setText(rs.getString("site_web").toString());
	                		text_EtatFiscale.setText(rs.getString("etat_fiscale").toString());
	                		
	                	
	                		
	                	}
			}
	       	 catch(Exception e1){
	      			System.out.println("info entreprise n'est pas Ajouter");
	      		}
        	}
			
		});
        
        recuper.setBounds(903, 545, 123, 23);
        add(recuper);
		
		btnModifier = new JButton("");
		btnModifier.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		try {
	     			Class.forName("com.mysql.jdbc.Driver");
					
					String url = "jdbc:mysql://localhost:3306/entreprise";
					Connection c = DriverManager.getConnection(url,"root","");

					Statement stmt = c.createStatement();
					
					String adresse = text_NumRue.getText()+"/"+text_Libelle.getText()
	    			+"/"+text_NomVille.getText()+"/"+Integer.parseInt( text_CodePostale.getText())+"/"+
	    					text_Gouvernorat.getText()+"/"+text_Pays.getText();
	    			
	    			String banc = text_Banque.getText()+'/'+text_Agence.getText()+'/'+Integer.parseInt(text_Rib.getText());
	    			String type = (String) comboBox_Type.getSelectedItem();
	    			Entreprise entUp = new Entreprise(text_Matricule.getText().toString(),text_NomEntreprise.getText().toString(),
	    					type,
	    				text_Description.getText().toString(),banc,adresse,
	    					Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
	    					Integer.parseInt(text_Faxe.getText().toString()),text_Email.getText().toString(),text_Site.getText().toString(),text_EtatFiscale.getText().toString());
					
	    			String req= Requettes.modifier_entreprise(entUp);
	    			
	    			
	    			Class.forName("com.mysql.jdbc.Driver");
	      			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entreprise","root","");
	      			PreparedStatement pst = conn.prepareStatement(req);
	    			pst.execute();
			     	JOptionPane.showMessageDialog(null, "Mise à jour Entreprise avec succés");
			     	pst.close();	
					
				}
				
				catch (Exception event) {
					JOptionPane.showMessageDialog(null, "Entprise n'est pas modifier");
				}
					
			
			
			
		}
	});
		btnModifier.setIcon(new ImageIcon(PanelEntreprise.class.getResource("/image/modifier.png")));
		btnModifier.setBounds(89, 13, 65, 65);
		panel.add(btnModifier);
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setForeground(new Color(0, 128, 128));
		lblFax.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFax.setBounds(73, 601, 51, 25);
		add(lblFax);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 128, 128));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(504, 484, 51, 25);
		add(lblEmail);
		
		JLabel lblSiteWeb = new JLabel("Site web:");
		lblSiteWeb.setForeground(new Color(0, 128, 128));
		lblSiteWeb.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSiteWeb.setBounds(504, 543, 69, 25);
		add(lblSiteWeb);
		
		text_Faxe = new JTextField();
		text_Faxe.setColumns(10);
		text_Faxe.setBounds(267, 602, 212, 25);
		add(text_Faxe);
		
		text_Email = new JTextField();
		text_Email.setColumns(10);
		text_Email.setBounds(596, 485, 212, 25);
		add(text_Email);
		
		text_Site = new JTextField();
		text_Site.setColumns(10);
		text_Site.setBounds(598, 544, 212, 25);
		add(text_Site);
		setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
	}
}
