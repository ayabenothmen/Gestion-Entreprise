package View;

import java.awt.Color;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


import Connexion.Requettes;
import Connexion.connexion;
import Model.Produit;
import net.proteanit.sql.DbUtils;

public class GestionProduit extends JPanel {
	private JTextField text_Fournisseur;
	private JTextField text_Reference;
	private JTextField text_CodeFam;
	private JTextField text_DesignationPro;
	private JTextField text_Designation;
	DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable();
    private JTextField text_Recherche;
    private JTextField text_Tva;
    private JTextField text_PUT;
    private JTextField text_Code;
    private boolean emptyTable = false;
    
    private JComboBox combobox = new JComboBox();
    private JComboBox text_Unite = new JComboBox();
    private JSpinner text_Stock = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
    private JSpinner text_StockMin = new JSpinner(new SpinnerNumberModel(5, 5, 50,1));

    Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Create the panel.
	 */
	public GestionProduit() {
		updateTable();
		setBackground(new Color(211, 211, 211));
		setSize(1234, 673);
		setLayout(null);
		setVisible(true);
		
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(null);
		panelProduit.setOpaque(false);
		panelProduit.setBorder(new TitledBorder(UIManager

						.getBorder("TitledBorder.border"), "Produit",

						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelProduit.setBackground(Color.WHITE);
		panelProduit.setBounds(12, 13, 272, 647);
		add(panelProduit);
		
		JComboBox text_Fournisseur = new JComboBox();
		 String sql2 = "select raison_sociale from fournisseur";
       try{
           pst= conn.prepareStatement(sql2);     
           rs=pst.executeQuery();
           while (rs.next()){
               String r=rs.getString("raison_sociale");
               text_Fournisseur.addItem(r);
            
           }          
       }catch(Exception e1){
           JOptionPane.showMessageDialog(null,e1);
       }
   
		text_Fournisseur.setBounds(149, 199, 111, 22);
		panelProduit.add(text_Fournisseur);
		
		JLabel lblFournisseur = new JLabel("Fournisseur");
		lblFournisseur.setForeground(new Color(0, 128, 128));
		lblFournisseur.setBackground(new Color(255, 255, 255));
		lblFournisseur.setBounds(12, 201, 93, 18);
		panelProduit.add(lblFournisseur);
		
		JLabel lbl_Code = new JLabel("Code");
		lbl_Code.setForeground(new Color(0, 128, 128));
		lbl_Code.setBounds(12, 34, 93, 18);
		panelProduit.add(lbl_Code);
		
		JLabel lblTva = new JLabel("TVA:");
		lblTva.setForeground(new Color(0, 128, 128));
		lblTva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTva.setBounds(12, 450, 111, 18);
		panelProduit.add(lblTva);
		
		JLabel lblReference = new JLabel("R\u00E9f\u00E9rence:");
		lblReference.setForeground(new Color(0, 128, 128));
		lblReference.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReference.setBounds(12, 67, 111, 18);
		panelProduit.add(lblReference);
		
		JLabel lblDesignation = new JLabel("D\u00E9signation:");
		lblDesignation.setForeground(new Color(0, 128, 128));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesignation.setBounds(12, 108, 111, 18);
		panelProduit.add(lblDesignation);
		
		text_Reference = new JTextField();
		text_Reference.setColumns(10);
		text_Reference.setBounds(149, 66, 111, 20);
		panelProduit.add(text_Reference);
		
		JLabel lblUnite = new JLabel("Unit\u00E9 de mesure:");
		lblUnite.setForeground(new Color(0, 128, 128));
		lblUnite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUnite.setBounds(12, 153, 120, 18);
		panelProduit.add(lblUnite);
		
		text_Unite.setModel(new DefaultComboBoxModel(new String[] {"Piece", "Kg", "L"}));
		text_Unite.setForeground(Color.black);
		text_Unite.setBackground(new Color(255, 255, 255));
		text_Unite.setBounds(149, 153, 111, 22);
		panelProduit.add(text_Unite);
		
		JLabel lblCode = new JLabel("Code famille produit");
		lblCode.setForeground(new Color(0, 128, 128));
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCode.setBounds(12, 256, 132, 18);
		panelProduit.add(lblCode);
		
		text_CodeFam = new JTextField();
		text_CodeFam.setColumns(10);
		text_CodeFam.setBounds(149, 255, 111, 20);
		panelProduit.add(text_CodeFam);
		
		text_DesignationPro = new JTextField();
		text_DesignationPro.setColumns(10);
		text_DesignationPro.setBounds(149, 297, 111, 20);
		panelProduit.add(text_DesignationPro);
		
		JLabel lblDésignation = new JLabel("D\u00E9signation produit:");
		lblDésignation.setForeground(new Color(0, 128, 128));
		lblDésignation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDésignation.setBounds(12, 299, 125, 18);
		panelProduit.add(lblDésignation);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setForeground(new Color(0, 128, 128));
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStock.setBounds(12, 330, 93, 18);
		panelProduit.add(lblStock);
		
	
		text_Stock.setBounds(149, 330, 111, 22);
		panelProduit.add(text_Stock);
		
		
		JLabel lblStokMin = new JLabel("Stock min:");
		lblStokMin.setForeground(new Color(0, 128, 128));
		lblStokMin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStokMin.setBounds(12, 368, 111, 18);
		panelProduit.add(lblStokMin);
		

		text_StockMin.setBounds(149, 367, 111, 20);
		panelProduit.add(text_StockMin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(77, 502, 85, 85);
		panelProduit.add(panel_1);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		 if (text_Code.getText().trim().isEmpty()||
		     				text_Reference.getText().trim().isEmpty()||
		     				text_Designation.getText().trim().isEmpty()||
		     				text_PUT.getText().trim().isEmpty()||text_Tva.getText().trim().isEmpty()){
		                 JOptionPane.showMessageDialog(null,"veillez remplir les champs vides");
		             }
		             else {
		     		
		     		try {
						Class.forName("com.mysql.jdbc.Driver");
						
						String url = "jdbc:mysql://localhost:3306/entreprise";
						Connection c = DriverManager.getConnection(url,"root","");

						Statement stmt = c.createStatement();						
						String famille_produit = Integer.parseInt(text_CodeFam.getText())+"/"+text_DesignationPro.getText();
				
						Produit produit = new Produit(Integer.parseInt(text_Code.getText().toString()),
								text_Reference.getText().toString(),text_Designation.getText().toString(),
								text_Unite.getSelectedItem().toString(),text_Fournisseur.getSelectedItem().toString(),
								famille_produit,Integer.parseInt(text_Stock.getValue().toString()),
								Integer.parseInt(text_StockMin.getValue().toString()),
								Integer.parseInt(text_PUT.getText().toString()),
								Integer.parseInt(text_Tva.getText().toString()));
						
						String req= Requettes.ajouter_produit(produit);
						//System.out.println(req);
						
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_produit_vente" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_produit_vente" , JOptionPane.OK_OPTION);
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_Code.getText(),
	           					text_Reference.getText(),
	           					text_Designation.getText(),
	           					text_Unite.getSelectedItem(),
	           					text_Fournisseur.getSelectedItem(),
	           					text_CodeFam.getText(),
	           					text_DesignationPro.getText(),
	           					text_Stock.getValue(),
	           					text_StockMin.getValue(),
	           					text_PUT.getText(),
	           					text_Tva.getText()
	           					
	           					});
	      				
		     		
	   					text_Code.setText(null);
	   					text_Reference.setText(null);
    					text_Designation.setText(null);
    					text_Unite.setSelectedItem(null);
    					text_Fournisseur.setSelectedItem(null);
    					text_CodeFam.setText(null);
    					text_DesignationPro.setText(null);
    					text_Stock.setValue(1);
    					text_StockMin.setValue(1);
    					text_PUT.setText(null);
    					text_Tva.setText(null);
	      				
					}
					
					catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Produit n'est pas Ajouter");
					}
				
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
					
					
					String famille_produit = Integer.parseInt(text_CodeFam.getText())+"/"+text_DesignationPro.getText();
					
					
					Produit produit = new Produit(Integer.parseInt(text_Code.getText().toString()),
							text_Reference.getText().toString(),text_Designation.getText().toString(),
							text_Unite.getSelectedItem().toString(),text_Fournisseur.getSelectedItem().toString(),
							famille_produit,Integer.parseInt(text_Stock.getValue().toString()),
							Integer.parseInt(text_StockMin.getValue().toString()),
							Integer.parseInt(text_PUT.getText().toString()),
							Integer.parseInt(text_Tva.getText().toString()));
					
					String req= Requettes.modifier_produit(produit);
					PreparedStatement pst = conn.prepareStatement(req);
					pst.execute();
                	JOptionPane.showMessageDialog(null, "Mise à jour de produit avec succés");
                	pst.close();
                	
                	text_Code.setText(null);
   					text_Reference.setText(null);
					text_Designation.setText(null);
					text_Unite.setSelectedItem(null);
					text_Fournisseur.setSelectedItem(null);
					text_CodeFam.setText(null);
					text_DesignationPro.setText(null);
					text_Stock.setValue(1);
					text_StockMin.setValue(1);
					text_PUT.setText(null);
					text_Tva.setText(null);
      				
      				
   					updateTable("1=1 ");
   					
   					//updateTable();
	     		}
	     		catch (Exception event) {
					JOptionPane.showMessageDialog(null, "Produit n'est pas ajouter");
				}
					
	     }});
		btnModifier.setIcon(new ImageIcon(GestionClient.class.getResource("/image/edit.png")));
		btnModifier.setBounds(44, 6, 32, 32);
		panel_1.add(btnModifier);
		
		JButton btnImprimer = new JButton("");
		btnImprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {

	        MessageFormat Header = new MessageFormat("les Produits");

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
	           		String sql = "DELETE FROM `produit` WHERE code=" +value; 
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
	    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion des produits", JOptionPane.OK_OPTION);
	    					}
	    					else {
	    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des produits", JOptionPane.OK_OPTION);
	    					}
	    				}}

	     	}
	     });
		btnSupprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/trash.png")));
		btnSupprimer.setBounds(44, 44, 32, 32);
		panel_1.add(btnSupprimer);
		
		text_Designation = new JTextField();
		text_Designation.setColumns(10);
		text_Designation.setBounds(149, 107, 111, 20);
		panelProduit.add(text_Designation);
		
		text_Tva = new JTextField();
		text_Tva.setColumns(10);
		text_Tva.setBounds(149, 449, 111, 20);
		panelProduit.add(text_Tva);
		
		JLabel lblPuHorsTaxe = new JLabel("PU hors Taxe:");
		lblPuHorsTaxe.setForeground(new Color(0, 128, 128));
		lblPuHorsTaxe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuHorsTaxe.setBounds(12, 409, 111, 18);
		panelProduit.add(lblPuHorsTaxe);
		
		text_PUT = new JTextField();
		text_PUT.setColumns(10);
		text_PUT.setBounds(149, 407, 111, 20);
		panelProduit.add(text_PUT);
		
		text_Code = new JTextField();
		text_Code.setColumns(10);
		text_Code.setBounds(149, 32, 111, 20);
		panelProduit.add(text_Code);
		
		
		
		JPanel panelListeProduit = new JPanel();
		panelListeProduit.setLayout(null);
		panelListeProduit.setOpaque(false);
		panelListeProduit.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des Produit",


								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelListeProduit.setBackground(Color.WHITE);
		panelListeProduit.setBounds(296, 13, 926, 647);
		add(panelListeProduit);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 916, 216);
        panelListeProduit.add(scrollPane);
        
        combobox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Ref", "Designation","Unite_mesure",
				 "Fournisseur","CodeFP","DesignationFP","Stock","Stock_min","PU_hors_taxe","TVA"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(312, 559, 142, 29);
			panelListeProduit.add(combobox);
    
			 Object col []= {"Code", "Ref", "Designation","Unite_mesure","Fournisseur","CodeFP","DesignationFP","Stock","Stock_min","PU_hors_taxe","TVA"};
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
				           		String sql = "SELECT * FROM `produit` WHERE code=" +code; 
				         
				           		pst = c.prepareStatement(sql);
				    			rs = pst.executeQuery();
				           		while (rs.next()) {
			                		String tab[];
			                		String lp = rs.getString("famille_produit").toString();
			                		tab = lp.split("/");
			                		String CodeFam = tab[0];
			                		String DesignationPro = tab[1];
			                		
			                		
			                		
			                		text_Code.setText(rs.getString("code").toString());
			                		text_Reference.setText(rs.getString("ref").toString());
			                		text_Designation.setText(rs.getString("designation").toString());
			                		text_Unite.setSelectedItem(rs.getString("unite_mesure").toString());
			                		text_Fournisseur.setSelectedItem(rs.getString("fournisseur").toString());
			                		text_CodeFam.setText(CodeFam);
			                		text_DesignationPro.setText(DesignationPro);
			                		text_Stock.setValue(rs.getInt("stock"));
			                		text_StockMin.setValue(rs.getInt("stock_min"));
			                		text_PUT.setText(rs.getString("PU_hors_taxe").toString());
			                		text_Tva.setText(rs.getString("TVA").toString());
			                		
			                		
			                	}
								
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne valide");
							}
					}
					
				});
				table.setModel(model);
				table.getColumnModel().getColumn(0).setPreferredWidth(89);
				scrollPane.setViewportView(table);
        
       
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GestionClient.class.getResource("/image/search.png")));
        lblNewLabel.setBounds(251, 542, 59, 61);
        panelListeProduit.add(lblNewLabel);
        
        text_Recherche = new JTextField();
        text_Recherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String selection = (String)combobox.getSelectedItem();
					String sql = "select * from produit where "+selection+"=?"; 
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
        text_Recherche.setBounds(467, 559, 224, 29);
        panelListeProduit.add(text_Recherche);
        text_Recherche.setColumns(10);
        setVisible(true);

	}

	public void updateTable() {
		conn = connexion.Connecter();	
		if(conn != null)
			{
			String sql = "SELECT * FROM `produit`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "Ref", "Designation","Unite_mesure","Fournisseur","CodeFP","DesignationFP","Stock","Stock_min","PU_hors_taxe","TVA"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[11];
      
            	while (rs.next()) {
            		String tab[];
            		String lp = rs.getString("famille_produit").toString();
            		tab = lp.split("/");
            		String CodeFam = tab[0];
            		String DesignationPro = tab[1];
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("ref");
            		columnData[2] = rs.getString("designation");
            		columnData[3] = rs.getString("unite_mesure");
            		columnData[4] = rs.getString("fournisseur");
            		columnData[5] = CodeFam;
            		columnData[6] = DesignationPro;
            		columnData[7] = rs.getInt("stock");
            		columnData[8] = rs.getInt("stock_min");
            		columnData[9] = rs.getInt("PU_hors_taxe");
            		columnData[10] = rs.getInt("TVA");
            		
            		
            		 
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
				String sql1 = "select * from produit"; 
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
