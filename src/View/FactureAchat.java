package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;

import Connexion.Requettes;
import Connexion.connexion;
import Model.Facture_Fournisseur_BL;
import Model.Ligne_BR;
import Model.Produit;
import Model.Bon_reception;
import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class FactureAchat extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField text_Code;
	private JDateChooser txt_datefac;
	DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable();
    DefaultTableModel model2 = new DefaultTableModel();
    static JTable table1 = new JTable();
    private JTextField text_BonR;
    private JTextField text_Mtp;
    private JTextField text_Mp;
    private JTextField text_Mr;
    private JComboBox Combobox_fournisseur = new JComboBox();
    private boolean emptyTable = false;
    private JComboBox combobox = new JComboBox();
    
	Connection conn = null;
   	PreparedStatement pst = null;
   	ResultSet rs = null;
   	private JTextField textRecherche;
   	
   	
	/**
	 * Create the panel.
	 */
	public FactureAchat() {
		updateTable();
		setBackground(new Color(211, 211, 211));
		setSize(1234, 673);
		setLayout(null);
		setVisible(true);
		
		JPanel panel_FactureClient = new JPanel();
		panel_FactureClient.setLayout(null);
		panel_FactureClient.setOpaque(false);
		panel_FactureClient.setBorder(new TitledBorder(UIManager

						.getBorder("TitledBorder.border"), "Facture Fournisseur",

						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_FactureClient.setBackground(Color.WHITE);
		panel_FactureClient.setBounds(12, 13, 272, 636);
		add(panel_FactureClient);
		
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setForeground(new Color(0, 128, 128));
		lblCode.setBackground(new Color(255, 255, 255));
		lblCode.setBounds(12, 59, 93, 18);
		panel_FactureClient.add(lblCode);
		
		text_Code = new JTextField();
		text_Code.setColumns(10);
		text_Code.setBounds(149, 58, 111, 20);
		panel_FactureClient.add(text_Code);
		
		JLabel lblClient = new JLabel("Fournisseur:");
		lblClient.setForeground(new Color(0, 128, 128));
		lblClient.setBackground(Color.WHITE);
		lblClient.setBounds(12, 104, 93, 18);
		panel_FactureClient.add(lblClient);
		
		JComboBox combobox_fournisseur = new JComboBox();
		combobox_fournisseur.setBounds(149, 102, 111, 22);
		panel_FactureClient.add(combobox_fournisseur);
		String sql = "select code_fournisseur from bon_reception"; 
		try{
       		pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
       		while (rs.next()) {
       			int tf=rs.getInt("code_fournisseur");
       			combobox_fournisseur.addItem(String.valueOf(tf));
              
            }           
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
		
		
		JLabel lblDatefac = new JLabel("Date de facture:");
		lblDatefac.setForeground(new Color(0, 128, 128));
		lblDatefac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatefac.setBounds(12, 147, 111, 18);
		panel_FactureClient.add(lblDatefac);
		
		txt_datefac = new JDateChooser();
		txt_datefac.setDateFormatString("yyyy-MM-dd");
		txt_datefac.setBounds(149, 147, 111, 20);
		panel_FactureClient.add(txt_datefac);
		
		JLabel lblModeDePayement = new JLabel("Mode de payement:");
		lblModeDePayement.setForeground(new Color(0, 128, 128));
		lblModeDePayement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModeDePayement.setBounds(12, 189, 145, 18);
		panel_FactureClient.add(lblModeDePayement);
		
		JComboBox comboBox_pay = new JComboBox(new String[] {"espece", "cheque", "virement"});
		comboBox_pay.setBounds(149, 187, 111, 22);
		panel_FactureClient.add(comboBox_pay);
		
		JLabel lblTypeDeFacture = new JLabel("Type de facture:");
		lblTypeDeFacture.setForeground(new Color(0, 128, 128));
		lblTypeDeFacture.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTypeDeFacture.setBounds(12, 237, 118, 18);
		panel_FactureClient.add(lblTypeDeFacture);
		
		JComboBox comboBox_type = new JComboBox(new String[] {"F.F.BL", "F.F.Libre"});
		comboBox_type.setBounds(149, 235, 111, 22);
		panel_FactureClient.add(comboBox_type);
		
		text_BonR = new JTextField();
		text_BonR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				       String sql = "select code from bon_reception where code_fournisseur=?";
					    try{
			    			
			            pst= conn.prepareStatement(sql);
			            pst.setString(1,(String)combobox_fournisseur.getSelectedItem());
			            rs=pst.executeQuery();
			            while (rs.next()){
			                int t1=rs.getInt("code");
			      
			                text_BonR.setText(String.valueOf(t1));
			              
			            }           
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		
		text_BonR.setColumns(10);
		text_BonR.setBounds(149, 287, 111, 20);
		panel_FactureClient.add(text_BonR);
		
		text_Mtp = new JTextField();
		text_Mtp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
			    	
	    			 String sql = "select m_total_Payer from bon_reception where code_fournisseur=?";
	            pst= conn.prepareStatement(sql);
	            pst.setString(1,(String)combobox_fournisseur.getSelectedItem());
	            rs=pst.executeQuery();
	            while (rs.next()){
	                Float mt=rs.getFloat("m_total_Payer");
	                text_Mtp.setText(String.valueOf(mt));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
			}
		});
		text_Mtp.setColumns(10);
		text_Mtp.setBounds(149, 339, 111, 20);
		panel_FactureClient.add(text_Mtp);
		
		text_Mp = new JTextField();
		text_Mp.setColumns(10);
		text_Mp.setBounds(149, 382, 111, 20);
		panel_FactureClient.add(text_Mp);
		
		text_Mr = new JTextField();
		text_Mr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float TTC = Float.parseFloat(text_Mtp.getText().toString());
				float MPayer = Float.parseFloat(text_Mp.getText().toString());
				text_Mr.setText(String.valueOf(TTC-MPayer));
	     	}
		});
		text_Mr.setColumns(10);
		text_Mr.setBounds(149, 425, 111, 20);
		panel_FactureClient.add(text_Mr);
		
		
		JLabel lblMontantPayer = new JLabel("montant payer:");
		lblMontantPayer.setForeground(new Color(0, 128, 128));
		lblMontantPayer.setBackground(Color.WHITE);
		lblMontantPayer.setBounds(12, 384, 93, 18);
		panel_FactureClient.add(lblMontantPayer);
		
		JLabel lblMontantRestant = new JLabel("montant restant:");
		lblMontantRestant.setForeground(new Color(0, 128, 128));
		lblMontantRestant.setBackground(Color.WHITE);
		lblMontantRestant.setBounds(12, 427, 111, 18);
		panel_FactureClient.add(lblMontantRestant);
		
		
	
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(96, 520, 85, 85);
		panel_FactureClient.add(panel_1);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/entreprise";
					Connection c = DriverManager.getConnection(url,"root","");
					
                     
					Statement stmt = c.createStatement();
					

					String date1 = ((JTextField) txt_datefac.getDateEditor()
							.getUiComponent()).getText();
				
					
					Facture_Fournisseur_BL factureBL = new Facture_Fournisseur_BL(Integer.parseInt(text_Code.getText().toString()),
						Integer.parseInt(combobox_fournisseur.getSelectedItem().toString()),date1,
						comboBox_pay.getSelectedItem().toString(),comboBox_type.getSelectedItem().toString(),Integer.parseInt(text_BonR.getText().toString()),
						Float.parseFloat(text_Mtp.getText().toString()),Float.parseFloat(text_Mp.getText().toString()),Float.parseFloat(text_Mr.getText().toString()));
					
					String req= Requettes.ajouter_facture_fournisseur_BL(factureBL);
					
					
					int nb=stmt.executeUpdate(req);
					if(nb==0)
						JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_FactureBL" , JOptionPane.OK_OPTION);
					else
						JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_FactureBL" , JOptionPane.OK_OPTION);
					
					table.setModel(model);
           			DefaultTableModel model = (DefaultTableModel) table.getModel();
           			model.addRow(new Object[] {
           					text_Code.getText(),
           					combobox_fournisseur.getSelectedItem(), 					
           					((JTextField) txt_datefac.getDateEditor().getUiComponent()).getText(),
           					comboBox_pay.getSelectedItem(),
           					comboBox_type.getSelectedItem(),
           					text_BonR.getText(),
           					text_Mtp.getText(),
           					text_Mp.getText(),
           					text_Mr.getText()
           					});
           			
           			/*textArea.setText("");
   					textArea.append("                     Fiche Facture BL\n"
   					+"       ******************************************************** \n"
   					+"Code_Facture :\t"+text_code.getText()
   					+"\nCode_Fournisseur :\t "+Combobox_Fournisseur.getSelectedItem()
   					+"\nMode_Payement :\t "+comboBoxmodepayment.getSelectedItem()
   					+"\nType_Facture :\t "+comboBox.getSelectedItem()
   					+"\nDate_Facture :\t "+((JTextField) txt_date.getDateEditor().getUiComponent()).getText()
   					+"\nCode_BonRecep :\t "+text_codeBon.getText()
   					+"\nTTC :\t "+text_TTC.getText()
   					+"\nMontant_Payer : "+text_mPayer.getText()
   					+"\nMontant_Restant : "+text_MReste.getText()+"\n");*/
   					
      				
   					text_Code.setText(null);
   					combobox_fournisseur.setSelectedItem(null); 					
   					comboBox_pay.setSelectedItem(null);
   					comboBox_type.setSelectedItem(null);
   					text_BonR.setText(null);
   					text_Mtp.setText(null);
   					text_Mp.setText(null);
   					text_Mr.setText(null);
      				
   					updateTable("1=1");
				}
				
				catch (Exception event) {
					JOptionPane.showMessageDialog(null, event);
				}
		
			}
		});
		btnAjouter.setIcon(new ImageIcon(GestionClient.class.getResource("/image/plus.png")));
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
					String date1 = ((JTextField) txt_datefac.getDateEditor()
							.getUiComponent()).getText();
					
					Facture_Fournisseur_BL factureBL = new Facture_Fournisseur_BL(Integer.parseInt(text_Code.getText().toString()),
						Integer.parseInt(combobox_fournisseur.getSelectedItem().toString()),date1,
						comboBox_pay.getSelectedItem().toString(),comboBox_type.getSelectedItem().toString(),Integer.parseInt(text_BonR.getText().toString()),
						Float.parseFloat(text_Mtp.getText().toString()),Float.parseFloat(text_Mp.getText().toString()),Float.parseFloat(text_Mr.getText().toString()));
					
					String req= Requettes.modifier_facture_fournisseur_BL(factureBL);
					//System.out.println(req);
					PreparedStatement pst = conn.prepareStatement(req);
					pst.execute();
                	JOptionPane.showMessageDialog(null, "Mise à jour de factureBL avec succés");
                	pst.close();
                	
                
		     
                	text_Code.setText(null);
                	combobox_fournisseur.setSelectedItem(null); 					
                	comboBox_pay.setSelectedItem(null);
                	comboBox_type.setSelectedItem(null);
                	text_BonR.setText(null);
                	text_Mtp.setText(null);
                	text_Mp.setText(null);
                	text_Mr.setText(null);
   					
   					
   					updateTable("1=1");
	     		}
	     		catch (Exception event) {
					JOptionPane.showMessageDialog(null,event);
			}
			}
		});
		btnModifier.setIcon(new ImageIcon(GestionClient.class.getResource("/image/edit.png")));
		btnModifier.setBounds(44, 6, 32, 32);
		panel_1.add(btnModifier);
		
		JButton btnImprimer = new JButton("");
		btnImprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {

	        MessageFormat Header = new MessageFormat("les factures achats");

	        MessageFormat footer = new MessageFormat("page{0,number,integer}");
	        try {

	        	table.print(JTable.PrintMode.FIT_WIDTH, Header, footer);

	        } catch (java.awt.print.PrinterException ex) {
	            System.err.format("ereur dimpression", ex.getMessage());
	        }
	     		}
	     	});
		btnImprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/printer.png")));
		btnImprimer.setBounds(6, 44, 32, 32);
		panel_1.add(btnImprimer);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		try {
	           		int row = table.getSelectedRow();
	           		String value =  table.getModel().getValueAt(row, 0).toString();
	           		String sql = "DELETE FROM `facture_fournisseur_bl` WHERE code=" +value; 
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
	    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion des facturesBL", JOptionPane.OK_OPTION);
	    					}
	    					else {
	    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des facturesBL", JOptionPane.OK_OPTION);
	    					}
	    				}}

	     	}
	     });
		btnSupprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/trash.png")));
		btnSupprimer.setBounds(44, 44, 32, 32);
		panel_1.add(btnSupprimer);
		
		JLabel lblCodeBonReception = new JLabel("code bon Reception:");
		lblCodeBonReception.setForeground(new Color(0, 128, 128));
		lblCodeBonReception.setBackground(Color.WHITE);
		lblCodeBonReception.setBounds(12, 288, 125, 18);
		panel_FactureClient.add(lblCodeBonReception);
		
		JLabel lblMontantTotal = new JLabel("montant total \u00E0 Payer:");
		lblMontantTotal.setForeground(new Color(0, 128, 128));
		lblMontantTotal.setBackground(Color.WHITE);
		lblMontantTotal.setBounds(12, 340, 145, 18);
		panel_FactureClient.add(lblMontantTotal);
		
		
		

		JPanel panel_ListeFacture = new JPanel();
		panel_ListeFacture.setLayout(null);
		panel_ListeFacture.setOpaque(false);
		panel_ListeFacture.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des factures Fournisseur BL",
								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_ListeFacture.setBackground(Color.WHITE);
		panel_ListeFacture.setBounds(296, 13, 926, 310);
		add(panel_ListeFacture);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 29, 916, 185);
        panel_ListeFacture.add(scrollPane);
    
        Object col []= {"Code", "Fournisseur", "DateFacture","ModePayement","type_facture","code_bonRecep","m_total_payer","M_deja_Payer","M_Restant"};
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
		           		String sql = "select * from facture_fournisseur_bl WHERE code=" +code; 
		         
		           		pst = c.prepareStatement(sql);
		    			rs = pst.executeQuery();
		           		while (rs.next()) {
		           			
	                		text_Code.setText(rs.getString("code").toString());
	                		combobox_fournisseur.setSelectedItem(rs.getString("code_fournisseur").toString());
	                		Date d = rs.getDate("date_facture");
	                		txt_datefac.setDate(d);
	                		comboBox_pay.setSelectedItem(rs.getString("mode_payement").toString());
	                		comboBox_type.setSelectedItem(rs.getString("type_facture").toString());
	                		text_BonR.setText(rs.getString("code_bon_recep").toString());
	                		text_Mtp.setText(rs.getString("m_total_Payer").toString());
	                		text_Mp.setText(rs.getString("m_Payer").toString());
	                		text_Mr.setText(rs.getString("m_Reste").toString());
	                		
	                	}
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
					}
			}
			
		});
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(89);
        scrollPane.setViewportView(table);
        
       
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GestionClient.class.getResource("/image/search.png")));
        lblNewLabel.setBounds(287, 227, 48, 64);
        panel_ListeFacture.add(lblNewLabel);
        
        combobox .setModel(new DefaultComboBoxModel(new String[] {"code", "code_fournisseur", "date_facture",
				"mode_payement","type_facture",
				"code_bon_recep","m_total_Payer","m_Payer","m_Reste"}));
        combobox.setForeground(Color.BLACK);
        combobox.setBackground(Color.WHITE);
        combobox.setBounds(347, 248, 153, 29);
        panel_ListeFacture.add(combobox);
        
        textRecherche = new JTextField();
        textRecherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String selection = (String)combobox.getSelectedItem();
					String sql = "select * from facture_fournisseur_bl where "+selection+"=?"; 
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,textRecherche.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
		});
        textRecherche.setColumns(10);
        textRecherche.setBounds(520, 248, 216, 29);
        panel_ListeFacture.add(textRecherche);
        
       
        
        JPanel panel_FactureLibre = new JPanel();
        panel_FactureLibre.setLayout(null);
        panel_FactureLibre.setOpaque(false);
        panel_FactureLibre.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des factures Fournisseur Libre",
								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel_FactureLibre.setBackground(Color.WHITE);
        panel_FactureLibre.setBounds(296, 325, 926, 324);
		add(panel_FactureLibre);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 26, 916, 185);
        panel_FactureLibre.add(scrollPane1);
        
     
       
        
        JLabel lblNewLabel1 = new JLabel("");
        lblNewLabel1.setBounds(360, 247, 67, 64);
        panel_FactureLibre.add(lblNewLabel1);
        lblNewLabel1.setIcon(new ImageIcon(GestionClient.class.getResource("/image/search.png")));
    
        Object col1 []= {"Id", "Code","Client", "Date_facture", "Mode_de_payement","Type_facture","Ref","Designation","Unité_mesure","Qte_réceptionnée","PU_hors_TVA","TVA_appliquée","P_total_horsTVA"};
        model2.setColumnIdentifiers(col1);
        table1.setModel(model2);
        table1.getColumnModel().getColumn(0).setPreferredWidth(89);
        scrollPane1.setViewportView(table1);
        
        setVisible(true);

	}
	

	public void updateTable() {
		conn = connexion.Connecter();	
		
		if(conn != null)
			{
			String sql = "select * from facture_fournisseur_bl";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "Fournisseur", "DateFacture","ModePayement","type_facture","code_bonRecep","m_total_payer","M_deja_Payer","M_Restant"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[9];
            	
            
            	while (rs.next()) {
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("code_fournisseur");
            		columnData[2] = rs.getDate("date_facture");
            		columnData[3] = rs.getString("mode_payement");
            		columnData[4] = rs.getString("type_facture");
            		columnData[5] = rs.getInt("code_bon_recep");
            		columnData[6] = rs.getFloat("m_total_Payer");
            		columnData[7] = rs.getFloat("m_Payer");
            		columnData[8] = rs.getFloat("m_Reste");
            		
            		model.addRow(columnData);
            	}
            
            }
            catch(Exception e ) {
            	JOptionPane.showMessageDialog(null, e);
            	
            }
			}
}
	// update table
		public void updateTable(String sql) {

			try {
				String sql1 = "select * from facture_fournisseur_bl"; 
				PreparedStatement pst = conn.prepareStatement(sql1);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
        		
				if (!rs.first())
					emptyTable = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


