package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import Model.Fournisseur;
import net.proteanit.sql.DbUtils;
import Connexion.connexion;
import Connexion.Requettes;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GestionFournisseur extends JPanel implements  ActionListener {
	
	private JTextField text_Code;
	private JTextField text_Matricule;
	private JTextField text_Nom;
	private JTextField text_Description;
	private JTextField text_Banque;
	private JTextField text_Agence;
	private JTextField text_Rib;
	private JTextField text_Rue;
	private JTextField text_Libelle;
	private JTextField text_Ville;
	private JTextField text_Codepstale;
	private JTextField text_Pays;
	private JTextField text_NumFixe;
	private JTextField text_NumMobile;
	private JTextField text_Fax;
	private JTextField text_Email;
	private JTextField text_Web;
	private JTextField text_Etat;
	private JTextField text_Recherche;
	private JLabel lblBanque;
	private JLabel lblAgence;
	private JLabel lblRib;
	private JLabel lblNum;
	private JLabel lblLibell;
	private JLabel lblNomDeVille;
	private JLabel lblCodePostale;
	private JLabel lblGouvernorat;
	private JLabel lblPays;
	DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable();
    
    private boolean emptyTable = false;
	private JComboBox comboboxRecherche = new JComboBox();
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField text_Gouvernorat;
  

	/**
	 * Create the panel.
	 */
	public GestionFournisseur() {
		updateTable();
		setBackground(new Color(211, 211, 211));
		setSize(1234, 673);
		setLayout(null);
		setVisible(true);
		
		JPanel panelFournisseur = new JPanel();
		panelFournisseur.setLayout(null);
		panelFournisseur.setOpaque(false);
		panelFournisseur.setBorder(new TitledBorder(UIManager

						.getBorder("TitledBorder.border"), "Fournisseur",

						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelFournisseur.setBackground(Color.WHITE);
		panelFournisseur.setBounds(5, 3, 266, 670);
		add(panelFournisseur);
		
		text_Code = new JTextField();
		text_Code.setColumns(10);
		text_Code.setBounds(149, 13, 111, 20);
		panelFournisseur.add(text_Code);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setForeground(new Color(0, 128, 128));
		lblCode.setBackground(new Color(255, 255, 255));
		lblCode.setBounds(12, 14, 93, 18);
		panelFournisseur.add(lblCode);
		
		JLabel lblMatricule = new JLabel("Matricule Fiscale:");
		lblMatricule.setForeground(new Color(0, 128, 128));
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatricule.setBounds(12, 45, 111, 18);
		panelFournisseur.add(lblMatricule);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setForeground(new Color(0, 128, 128));
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(12, 73, 111, 18);
		panelFournisseur.add(lblNom);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(new Color(0, 128, 128));
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblType.setBounds(12, 104, 111, 18);
		panelFournisseur.add(lblType);
		
		text_Matricule = new JTextField();
		text_Matricule.setColumns(10);
		text_Matricule.setBounds(149, 44, 111, 20);
		panelFournisseur.add(text_Matricule);
		
		text_Nom = new JTextField();
		text_Nom.setColumns(10);
		text_Nom.setBounds(149, 71, 111, 20);
		panelFournisseur.add(text_Nom);
		
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setModel(new DefaultComboBoxModel(new String[] {"","physique", "morale"}));
		comboBox_Type.setBounds(149, 102, 111, 16);
		panelFournisseur.add(comboBox_Type);
		
		JLabel lblDscriptionActivit = new JLabel("D\u00E9scription activit\u00E9:");
		lblDscriptionActivit.setForeground(new Color(0, 128, 128));
		lblDscriptionActivit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDscriptionActivit.setBounds(12, 130, 120, 18);
		panelFournisseur.add(lblDscriptionActivit);
		
		text_Description = new JTextField();
		text_Description.setColumns(10);
		text_Description.setBounds(149, 128, 111, 20);
		panelFournisseur.add(text_Description);
		
		JLabel lblCompteBancaire = new JLabel("Compte Bancaire:");
		lblCompteBancaire.setForeground(new Color(0, 128, 128));
		lblCompteBancaire.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCompteBancaire.setBounds(12, 158, 111, 18);
		panelFournisseur.add(lblCompteBancaire);
		
		JLabel lblBanque = new JLabel("Banque:");
		lblBanque.setForeground(new Color(0, 51, 51));
		lblBanque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBanque.setBounds(22, 179, 60, 16);
		panelFournisseur.add(lblBanque);
		
		JLabel lblAgence = new JLabel("Agence:");
		lblAgence.setForeground(new Color(0, 51, 51));
		lblAgence.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAgence.setBounds(22, 202, 60, 16);
		panelFournisseur.add(lblAgence);
		
		JLabel lblRib = new JLabel("RIB:");
		lblRib.setForeground(new Color(0, 51, 51));
		lblRib.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRib.setBounds(22, 224, 60, 16);
		panelFournisseur.add(lblRib);
		
		text_Banque = new JTextField();
		text_Banque.setColumns(10);
		text_Banque.setBounds(149, 177, 111, 20);
		panelFournisseur.add(text_Banque);
		
		text_Agence = new JTextField();
		text_Agence.setColumns(10);
		text_Agence.setBounds(149, 199, 111, 20);
		panelFournisseur.add(text_Agence);
		
		text_Rib = new JTextField();
		text_Rib.setColumns(10);
		text_Rib.setBounds(149, 221, 111, 20);
		panelFournisseur.add(text_Rib);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setForeground(new Color(0, 128, 128));
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresse.setBounds(12, 245, 72, 18);
		panelFournisseur.add(lblAdresse);
		
		JLabel lblRue = new JLabel("Rue:");
		lblRue.setForeground(new Color(0, 51, 51));
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRue.setBounds(12, 270, 60, 16);
		panelFournisseur.add(lblRue);
		
		JLabel lblLibell = new JLabel("Libell\u00E9:");
		lblLibell.setForeground(new Color(0, 51, 51));
		lblLibell.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLibell.setBounds(12, 293, 60, 16);
		panelFournisseur.add(lblLibell);
		
		JLabel lblNomDeVille = new JLabel("Nom de ville:");
		lblNomDeVille.setForeground(new Color(0, 51, 51));
		lblNomDeVille.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomDeVille.setBounds(12, 314, 79, 16);
		panelFournisseur.add(lblNomDeVille);
		
		JLabel lblCodePostale = new JLabel("Code postale:");
		lblCodePostale.setForeground(new Color(0, 51, 51));
		lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodePostale.setBounds(12, 335, 79, 16);
		panelFournisseur.add(lblCodePostale);
		
		JLabel lblPays = new JLabel("Pays:");
		lblPays.setForeground(new Color(0, 51, 51));
		lblPays.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPays.setBounds(12, 382, 79, 16);
		panelFournisseur.add(lblPays);
		
		text_Rue = new JTextField();
		text_Rue.setColumns(10);
		text_Rue.setBounds(149, 267, 111, 20);
		panelFournisseur.add(text_Rue);
		
		text_Libelle = new JTextField();
		text_Libelle.setColumns(10);
		text_Libelle.setBounds(149, 290, 111, 20);
		panelFournisseur.add(text_Libelle);
		
		text_Ville = new JTextField();
		text_Ville.setColumns(10);
		text_Ville.setBounds(149, 312, 111, 20);
		panelFournisseur.add(text_Ville);
		
		text_Codepstale = new JTextField();
		text_Codepstale.setColumns(10);
		text_Codepstale.setBounds(149, 335, 111, 20);
		panelFournisseur.add(text_Codepstale);
		
		text_Pays = new JTextField();
		text_Pays.setColumns(10);
		text_Pays.setBounds(149, 382, 111, 20);
		panelFournisseur.add(text_Pays);
		
		JLabel lblNumTlFixe = new JLabel("Num t\u00E9l fixe:");
		lblNumTlFixe.setForeground(new Color(0, 128, 128));
		lblNumTlFixe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTlFixe.setBounds(12, 411, 93, 18);
		panelFournisseur.add(lblNumTlFixe);
		
		JLabel lblNumTlMobile = new JLabel("Num t\u00E9l mobile:");
		lblNumTlMobile.setForeground(new Color(0, 128, 128));
		lblNumTlMobile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTlMobile.setBounds(12, 434, 93, 18);
		panelFournisseur.add(lblNumTlMobile);
		
		text_NumFixe = new JTextField();
		text_NumFixe.setColumns(10);
		text_NumFixe.setBounds(149, 410, 111, 20);
		panelFournisseur.add(text_NumFixe);
		
		text_NumMobile = new JTextField();
		text_NumMobile.setColumns(10);
		text_NumMobile.setBounds(149, 438, 111, 20);
		panelFournisseur.add(text_NumMobile);
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setForeground(new Color(0, 128, 128));
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFax.setBounds(12, 459, 60, 18);
		panelFournisseur.add(lblFax);
		
		text_Fax = new JTextField();
		text_Fax.setColumns(10);
		text_Fax.setBounds(149, 465, 111, 20);
		panelFournisseur.add(text_Fax);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 128, 128));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(12, 481, 60, 18);
		panelFournisseur.add(lblEmail);
		
		JLabel lblSiteWeb = new JLabel("Site web:");
		lblSiteWeb.setForeground(new Color(0, 128, 128));
		lblSiteWeb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSiteWeb.setBounds(12, 508, 60, 18);
		panelFournisseur.add(lblSiteWeb);
		
		text_Email = new JTextField();
		text_Email.setColumns(10);
		text_Email.setBounds(149, 491, 111, 20);
		panelFournisseur.add(text_Email);
		
		text_Web = new JTextField();
		text_Web.setColumns(10);
		text_Web.setBounds(149, 517, 111, 20);
		panelFournisseur.add(text_Web);
		
		JLabel lblEtatFiscale = new JLabel("Etat fiscale:");
		lblEtatFiscale.setForeground(new Color(0, 128, 128));
		lblEtatFiscale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEtatFiscale.setBounds(12, 539, 70, 18);
		panelFournisseur.add(lblEtatFiscale);
		
		text_Etat = new JTextField();
		text_Etat.setColumns(10);
		text_Etat.setBounds(149, 550, 111, 20);
		panelFournisseur.add(text_Etat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(76, 572, 85, 85);
		panelFournisseur.add(panel_1);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setIcon(new ImageIcon(GestionFournisseur.class.getResource("/image/plus.png")));
		btnAjouter.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		if (text_Code.getText().trim().isEmpty()||
	     				text_Matricule.getText().trim().isEmpty()||text_Nom.getText().trim().isEmpty()||
	     				text_Description.getText().trim().isEmpty()||text_NumFixe.getText().trim().isEmpty()||
	     				text_NumMobile.getText().trim().isEmpty()||text_Fax.getText().trim().isEmpty()||
	     				text_Email.getText().trim().isEmpty()||text_Web.getText().trim().isEmpty()||text_Etat.getText().trim().isEmpty()){
	                 JOptionPane.showMessageDialog(null,"veillez remplir les champs vides");
	             }
	             else {
	     		try {
	     			
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/entreprise";
					Connection c = DriverManager.getConnection(url,"root","");
                     
					Statement stmt = c.createStatement();
					
					String adresse1 = text_Rue.getText()+"/"+text_Libelle.getText()
					+"/"+text_Ville.getText()+"/"+Integer.parseInt( text_Codepstale.getText())+"/"+text_Gouvernorat.getText()+"/"+text_Pays.getText();
					
					String cb = text_Banque.getText()+"/"+text_Agence.getText()+"/"+Integer.parseInt(text_Rib.getText());

					String type = (String) comboBox_Type.getSelectedItem();
					Fournisseur fournisseur = new Fournisseur(Integer.parseInt(text_Code.getText()),text_Matricule.getText().toString(),text_Nom.getText().toString(),
							type,
						text_Description.getText().toString(),cb,adresse1,
							Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
							Integer.parseInt(text_Fax.getText().toString()),text_Email.getText().toString(),text_Web.getText().toString(),text_Etat.getText().toString());
					
					String req= Requettes.ajouter_fournisseur(fournisseur);
					//System.out.println(req);
					int nb=stmt.executeUpdate(req);
					if(nb==0)
						JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_fournisseur" , JOptionPane.OK_OPTION);
					else
						JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_fournisseur" , JOptionPane.OK_OPTION);
					
				
					table.setModel(model);
           			DefaultTableModel model = (DefaultTableModel) table.getModel();
           			model.addRow(new Object[] {
           					text_Code.getText(),
           					text_Matricule.getText(),
           					text_Nom.getText(),
           					(String) comboBox_Type.getSelectedItem(),
           					text_Description.getText(),
           					text_Banque.getText(),
           					text_Agence.getText(),
           					text_Rib.getText(),
           					text_Rue.getText(),
           					text_Libelle.getText(),
           					text_Ville.getText(),
           					text_Codepstale.getText(),
           					text_Gouvernorat.getText(),
							text_Pays.getText(),
           					text_NumFixe.getText(),
           					text_NumMobile.getText(),
           					text_Fax.getText(),
           					text_Email.getText(),
           					text_Web.getText(),
           					text_Etat.getText()
 					
           					});
	     		
   					text_Code.setText(null);
   					text_Matricule.setText(null);
   					text_Nom.setText(null);
   					comboBox_Type.setSelectedItem(null);
   					text_Description.setText(null);
   					text_Banque.setText(null);
   					text_Agence.setText(null);
   					text_Rib.setText(null);
   					text_Rue.setText(null);
   					text_Libelle.setText(null);
   					text_Ville.setText(null);
   					text_Codepstale.setText(null);
   					text_Gouvernorat.setText(null);
   					text_Pays.setText(null);
   					text_NumFixe.setText(null);
   					text_NumMobile.setText(null);
   					text_Fax.setText(null);
   					text_Email.setText(null);
   					text_Web.setText(null);
   					text_Etat.setText(null);
      				
				}
				
				catch (Exception event) {
					JOptionPane.showMessageDialog(null, "Fournisseur n'est pas Ajouter");
				}
	             }
			
	     	}
	     	
	     });
		btnAjouter.setBounds(6, 6, 32, 32);
		panel_1.add(btnAjouter);
		
		JButton btnModifier = new JButton("");
		
		 btnModifier.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		     			Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
	                     
						Statement stmt = c.createStatement();
						
						String adresse1 = text_Rue.getText()+"/"+text_Libelle.getText()
						+"/"+text_Ville.getText()+"/"+Integer.parseInt( text_Codepstale.getText())+"/"+
								text_Gouvernorat.getText()+"/"+text_Pays.getText();
						
					
						String cb = text_Banque.getText()+"/"+text_Agence.getText()+"/"+Integer.parseInt(text_Rib.getText());
						String type = (String) comboBox_Type.getSelectedItem();
						Fournisseur fournisseur = new Fournisseur(Integer.parseInt(text_Code.getText()),text_Matricule.getText().toString(),text_Nom.getText().toString(),
								type,
							text_Description.getText().toString(),cb,adresse1,
								Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
								Integer.parseInt(text_Fax.getText().toString()),text_Email.getText().toString(),text_Web.getText().toString(),text_Etat.getText().toString());
						
						
						String req= Requettes.modifier_fournisseur(fournisseur);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
			     	   JOptionPane.showMessageDialog(null, "Mise à jour de fournisseur avec succés");
			     	    pst.close();
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_Code.getText(),
	           					text_Matricule.getText(),
	           					text_Nom.getText(),
	           					(String) comboBox_Type.getSelectedItem(),
	           					text_Description.getText(),
	           					text_Banque.getText(),
	           					text_Agence.getText(),
	           					text_Rib.getText(),
	           					text_Rue.getText(),
	           					text_Libelle.getText(),
	           					text_Ville.getText(),
	           					text_Codepstale.getText(),
								text_Gouvernorat.getText(),
								text_Pays.getText(),
	           					text_NumFixe.getText(),
	           					text_NumMobile.getText(),
	           					text_Fax.getText(),
	           					text_Email.getText(),
	           					text_Web.getText(),
	           					text_Etat.getText()
	           					
	           					});
	      							      			
		     		
	   					text_Code.setText(null);
	   					text_Matricule.setText(null);
	   					text_Nom.setText(null);
	   					text_Description.setText(null);
	   					text_Banque.setText(null);
	   					text_Agence.setText(null);
	   					text_Rib.setText(null);
	   					text_Rue.setText(null);
	   					text_Libelle.setText(null);
	   					text_Ville.setText(null);
	   					text_Codepstale.setText(null);
	   					text_Gouvernorat.setText(null);
	   					text_Pays.setText(null);
	   					text_NumFixe.setText(null);
	   					text_NumMobile.setText(null);
	   					text_Fax.setText(null);
	   					text_Email.setText(null);
	   					text_Web.setText(null);
	   					text_Etat.setText(null);
						
	   					updateTable("1=1");
			     	
			     	
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Fournisseur n'est pas Modifier");
					}
						
		     }});
		btnModifier.setIcon(new ImageIcon(GestionFournisseur.class.getResource("/image/edit.png")));
		btnModifier.setBounds(44, 6, 32, 32);
		panel_1.add(btnModifier);
		
		JButton btnImprimer = new JButton("");
		btnImprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {

	        MessageFormat Header = new MessageFormat("les Fournisseurs");

	        MessageFormat footer = new MessageFormat("page{0,number,integer}");
	        try {

	        	table.print(JTable.PrintMode.FIT_WIDTH, Header, footer);

	        } catch (java.awt.print.PrinterException ex) {
	            System.err.format("ereur dimpression", ex.getMessage());
	        }
	     		}
	     	});
		btnImprimer.setIcon(new ImageIcon(GestionFournisseur.class.getResource("/image/printer.png")));
		btnImprimer.setBounds(6, 44, 32, 32);
		panel_1.add(btnImprimer);
		
		JButton btnSupprimer = new JButton("");
		
		btnSupprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		try {
	           		int row = table.getSelectedRow();
	           		String value =  table.getModel().getValueAt(row, 0).toString();
	           		String sql = "DELETE FROM `fournisseur` WHERE code=" +value; 
	           		pst = conn.prepareStatement(sql);
	            	pst.execute();
	            	JOptionPane.showMessageDialog(null, "Données supprimés");
	            	pst.close();
	            	DefaultTableModel model = (DefaultTableModel) table.getModel();
	            	model.removeRow(table.getSelectedRow());}
	           		
	           		catch(Exception ex) {
	           			JOptionPane.showMessageDialog(null, ex);
	           			if(table.getSelectedRow() == -1) {
	    					if(table.getRowCount() == 0) {
	    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion Fournisseur", JOptionPane.OK_OPTION);
	    					}
	    					else {
	    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion Fournisseur", JOptionPane.OK_OPTION);
	    					}
	    				}}

	     	}
	     });
		btnSupprimer.setIcon(new ImageIcon(GestionFournisseur.class.getResource("/image/trash.png")));
		btnSupprimer.setBounds(44, 44, 32, 32);
		panel_1.add(btnSupprimer);
		
		JLabel lblGouvernorat_1 = new JLabel("Gouvernorat");
		lblGouvernorat_1.setForeground(new Color(0, 51, 51));
		lblGouvernorat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGouvernorat_1.setBounds(12, 364, 79, 16);
		panelFournisseur.add(lblGouvernorat_1);
		
		text_Gouvernorat = new JTextField();
		text_Gouvernorat.setColumns(10);
		text_Gouvernorat.setBounds(149, 361, 111, 20);
		panelFournisseur.add(text_Gouvernorat);
		
		JPanel panelListeFournisseur = new JPanel();
		panelListeFournisseur.setLayout(null);
		panelListeFournisseur.setOpaque(false);
		panelListeFournisseur.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des Fournisseurs",


								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelListeFournisseur.setBackground(Color.WHITE);
		panelListeFournisseur.setBounds(272, 13, 962, 648);
		add(panelListeFournisseur);
		panelListeFournisseur.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 45, 953, 183);
        panelListeFournisseur.add(scrollPane);
    
        Object col []= {"Code", "MatFisc", "raison_sociale","type","description",
      			 "Banque","Agence","Rib",
  	    		 "Rue","Libelle","NomVille","codepostal","Gouvernorat","Pays",
  	    		 "NumTlfFix","NumTlfMobile"," Fax","Email","Site_web","etat_fiscale"};
			model.setColumnIdentifiers(col);
			table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!emptyTable)
					try {
	
						Class.forName("com.mysql.jdbc.Driver");
		    			String url = "jdbc:mysql://localhost:3306/entreprise";
		    			Connection c = DriverManager.getConnection(url,"root","");
		    			Statement stmt = c.createStatement();
		    	
						int row = table.getSelectedRow();
						int code = Integer.parseInt((table.getModel().getValueAt(row, 0))
								.toString());
		           		String sql = "SELECT * FROM `fournisseur` WHERE code=" +code; 
		           		pst = c.prepareStatement(sql);
		    			rs = pst.executeQuery();
		           		while (rs.next()) {
		           			String tab[];
	                		String cb = rs.getString("compte_bancaire").toString();
	                		tab = cb.split("/");
	                		String banque = tab[0];
	                		String agence = tab[1];
	                		String rib = tab[2];
	                		
	                		String tab1[];
	                		String ad = rs.getString("adresse").toString();
	                		tab1 = ad.split("/");
	                		
	                		String rue = tab1[0];
	                		String Libelle = tab1[1];
	                		String NomVille = tab1[2];
	                		String codepostal = tab1[3];
	                		String Gouvernorat = tab1[4];
	                		String Pays = tab1[5];
	                		
	                		text_Code.setText(rs.getString("code").toString());
	                		text_Matricule.setText(rs.getString("matricule_fiscale").toString());
	                		text_Nom.setText(rs.getString("raison_sociale").toString());
	                		comboBox_Type.getModel().setSelectedItem(rs.getString("type").toString());
	                		text_Description.setText(rs.getString("description").toString());
	                		text_Banque.setText(banque);
	                		text_Agence.setText(agence);
	                		text_Rib.setText(rib);
	                		text_Rue.setText(rue);
	                		text_Libelle.setText(Libelle);
	                		text_Ville.setText(NomVille);
	                		text_Codepstale.setText(codepostal);
	                		text_Gouvernorat.setText(Gouvernorat);
	                		text_Pays.setText(Pays);
	                		text_NumFixe.setText(rs.getString("num_tlf_fixe").toString());
	                		text_NumMobile.setText(rs.getString("num_tlf_mobile").toString());
	                		text_Fax.setText(rs.getString("fax").toString());
	                		text_Email.setText(rs.getString("email").toString());
	                		text_Web.setText(rs.getString("site_web").toString());
	                		text_Etat.setText(rs.getString("etat_fiscale").toString());
	                		
	                	}
						
					} catch (Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne valide");
					}
			}
			});
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(89);
        scrollPane.setViewportView(table);
        
        comboboxRecherche.setModel(new DefaultComboBoxModel(new String[] {"Code", "MatFisc", "raison_sociale","type","description",
     			 "Banque","Agence","Rib",
 	    		 "Rue","Libelle","NomVille","codepostal","Gouvernorat","Pays",
 	    		 "NumTlfFix","NumTlfMobile"," Fax","Email","Site_web","etat_fiscale"}));
			comboboxRecherche.setForeground(Color.black);
			comboboxRecherche.setBackground(new Color(255, 255, 255));
			comboboxRecherche.setBounds(292, 573, 141, 28);
			panelListeFournisseur.add(comboboxRecherche);
        
        text_Recherche = new JTextField();
        text_Recherche.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        		try {
					String selection = (String)comboboxRecherche.getSelectedItem();
					String sql = "select * from fournisseur where "+selection+"=?"; 
					PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1,text_Recherche.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
					
					
				} catch(Exception ex) {
					ex.printStackTrace();
		
				}
        	}
        });
        /*text_Recherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String selection = (String)combobox.getSelectedItem();
					String sql = "select * from client where "+selection+"=?"; 
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
					
				} catch(Exception ex) {
					ex.printStackTrace();
		
				}
			}
			
		});*/
        text_Recherche.setColumns(10);
        text_Recherche.setBounds(445, 573, 225, 28);
        panelListeFournisseur.add(text_Recherche);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GestionClient.class.getResource("/image/search.png")));
        lblNewLabel.setBounds(230, 557, 60, 52);
        panelListeFournisseur.add(lblNewLabel);
        
		

        setVisible(true);
	}
	public void updateTable() {
		conn = connexion.Connecter();	
		if(conn != null)
			{
			String sql = "SELECT * FROM fournisseur ";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	 Object col []= {"Code", "MatFisc", "raison_sociale","type","description",
              			 "Banque","Agence","Rib",
          	    		 "Rue","Libelle","NomVille","codepostal","Gouvernorat","Pays",
          	    		 "NumTlfFix","NumTlfMobile"," Fax","Email","Site_web","etat_fiscale"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[20];
      
            	while (rs.next()) {
            	
            		String tab[];
            		String cb = rs.getString("compte_bancaire").toString();
            		tab = cb.split("/");
            		String banque = tab[0];
            		String agence = tab[1];
            		String rib = tab[2];
            		
            		String tab1[];
            		String ad = rs.getString("adresse").toString();
            		tab1 = ad.split("/");
            		String rue = tab1[0];
            		String Libelle = tab1[1];
            		String NomVille = tab1[2];
            		String codepostal = tab1[3];
            		String Gouvernorat = tab1[4];
            		String Pays = tab1[5];
            	
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("matricule_fiscale");
            		columnData[2] = rs.getString("raison_sociale");
            		columnData[3] = rs.getString("type");
            		columnData[4] = rs.getString("description");
            		columnData[5] = banque;
            		columnData[6] = agence;
            		columnData[7] = rib;
            		columnData[8] = rue;
            		columnData[9] = Libelle;
            		columnData[10] = NomVille;
            		columnData[11] = codepostal;
            		columnData[12] = Gouvernorat;
            		columnData[13] = Pays;
            		columnData[14] = rs.getInt("num_tlf_fixe");
            		columnData[15] = rs.getInt("num_tlf_mobile");
            		columnData[16] = rs.getInt("fax");
            		columnData[17] = rs.getString("email");
            		columnData[18] = rs.getString("site_web");
            		columnData[19] = rs.getString("etat_fiscale");
            		
            		 
            		model.addRow(columnData);
            	
            	}
            	
            
            }
            catch(Exception e ) {
            	JOptionPane.showMessageDialog(null, "erreur affichage");
            	
            	
            }
			}
}
	// update table
		public void updateTable(String sql) {

			try {
				String sql1 = "select * from fournisseur"; 
				PreparedStatement pst = conn.prepareStatement(sql1);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
        		
			
				if (!rs.first())
					emptyTable = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
