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
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import Connexion.Requettes;
import Connexion.connexion;
import Model.Facture_Client_BL;
import Model.Facture_avoir;
import Model.Ligne_BR;
import Model.Produit;
import Model.Bon_livraison;
import net.proteanit.sql.DbUtils;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class PanelFactureAvoir extends JPanel {
	private JTextField text_Code;
	private JTextField text_Qte;
	private JTextField text_Mtp;
	private JTextField text_Mr;
	private JTextField text_Mar;
	private JTextField text_Designation;
	private JDateChooser txt_date;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox combobox_Recherche = new JComboBox();
    static JTable table = new JTable();
    private JTextField textField;
    private boolean emptyTable = false;
    
    Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField text_Recherche;

	/**
	 * Create the panel.
	 */
	public PanelFactureAvoir() {
		updateTable();
		setBackground(new Color(211, 211, 211));
		setSize(1234, 580);
		setLayout(null);
		setVisible(true);
		
		JPanel panelDevis = new JPanel();
		panelDevis.setLayout(null);
		panelDevis.setOpaque(false);
		panelDevis.setBorder(new TitledBorder(UIManager

						.getBorder("TitledBorder.border"), "Facture Avoir",

						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelDevis.setBackground(Color.WHITE);
		panelDevis.setBounds(12, 0, 277, 567);
		add(panelDevis);
		
		text_Code = new JTextField();
		text_Code.setColumns(10);
		text_Code.setBounds(149, 52, 111, 20);
		panelDevis.add(text_Code);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setForeground(new Color(0, 128, 128));
		lblCode.setBackground(new Color(255, 255, 255));
		lblCode.setBounds(12, 53, 93, 18);
		panelDevis.add(lblCode);
		
		JComboBox combobox_Client = new JComboBox();
		combobox_Client.setBounds(149, 102, 111, 22);
		panelDevis.add(combobox_Client);
		String sql = "SELECT code_client FROM `bon_livraison` "; 
		try{
       		pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
       		while (rs.next()) {
       			int tf=rs.getInt("code_client");
                //System.out.println(tf);
       			combobox_Client.addItem(String.valueOf(tf));
              
            }           
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
		
		combobox_Client.setBounds(149, 85, 111, 20);
		panelDevis.add(combobox_Client);
		
		JLabel lblDate = new JLabel("Date facture:");
		lblDate.setForeground(new Color(0, 128, 128));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(12, 118, 111, 18);
		panelDevis.add(lblDate);
		
		txt_date = new JDateChooser();
		txt_date.setDateFormatString("yyyy-MM-dd");
		txt_date.setBounds(149, 118, 111, 20);
		panelDevis.add(txt_date);
		
		JLabel lblQantiteR = new JLabel("Quantit\u00E9 retour:");
		lblQantiteR.setForeground(new Color(0, 128, 128));
		lblQantiteR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQantiteR.setBounds(12, 212, 111, 18);
		panelDevis.add(lblQantiteR);
		
		JLabel lblDesignation = new JLabel("D\u00E9signation:");
		lblDesignation.setForeground(new Color(0, 128, 128));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesignation.setBounds(12, 243, 111, 18);
		panelDevis.add(lblDesignation);
		
		text_Designation = new JTextField();
		text_Designation.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     	        try {
	     	        	
	     	        	String sql="SELECT designation FROM ligne_bl where code_client="+combobox_Client.getSelectedItem();
	     	        	
	     	        	pst= conn.prepareStatement(sql);
	     	        	rs=pst.executeQuery();
	     	        	  while(rs.next()) {
	     	        	        String a=rs.getString("designation");
	     	        	        text_Designation.setText(a);
	     	        	   }
	     	        }
	     	       
	     	         catch(Exception e1){
	     	            JOptionPane.showMessageDialog(null,e1);
	     	            } 
	     	    
	     	}
	     });
		text_Designation.setColumns(10);
		text_Designation.setBounds(149, 242, 111, 20);
		panelDevis.add(text_Designation);
		
		JLabel lblClient = new JLabel("Code client:");
		lblClient.setForeground(new Color(0, 128, 128));
		lblClient.setBackground(Color.WHITE);
		lblClient.setBounds(12, 86, 93, 18);
		panelDevis.add(lblClient);
		
		JLabel lblModeDePayement = new JLabel("Mode de payement");
		lblModeDePayement.setForeground(new Color(0, 128, 128));
		lblModeDePayement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModeDePayement.setBounds(12, 149, 120, 18);
		panelDevis.add(lblModeDePayement);
		
		JComboBox combobox_Pay = new JComboBox(new String[] {"espece", "cheque", "virement"});
		combobox_Pay.setBounds(149, 147, 111, 20);
		panelDevis.add(combobox_Pay);
		
		JLabel lblInfoFacture = new JLabel("Code Facture  client:");
		lblInfoFacture.setForeground(new Color(0, 128, 128));
		lblInfoFacture.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfoFacture.setBounds(12, 181, 132, 18);
		panelDevis.add(lblInfoFacture);
		
		JComboBox combobox_CodeF = new JComboBox();
		String sql1 = "SELECT code FROM `facture_client_bl` "; 
		try{
		
			//Statement stmt = c.createStatement();
			
    		pst = conn.prepareStatement(sql1);
			rs = pst.executeQuery();
    		while (rs.next()) {
    			int tf=rs.getInt("code");
    			combobox_CodeF.addItem(String.valueOf(tf));
              
            }           
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
     
		combobox_CodeF.setBounds(149, 178, 111, 20);
		panelDevis.add(combobox_CodeF);
		
		text_Qte = new JTextField();
		text_Qte.setColumns(10);
		text_Qte.setBounds(149, 211, 111, 20);
		panelDevis.add(text_Qte);
		
		JLabel lblMtp = new JLabel("Montant total \u00E0 payer:");
		lblMtp.setForeground(new Color(0, 128, 128));
		lblMtp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMtp.setBounds(12, 274, 132, 18);
		panelDevis.add(lblMtp);
		
		text_Mtp = new JTextField();
		text_Mtp.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     	        try {
	     	        	
	     	        	String sql="SELECT m_total_Payer FROM facture_client_bl where code_client="+combobox_Client.getSelectedItem();
	     	        	
	     	        	pst= conn.prepareStatement(sql);
	     	        	rs=pst.executeQuery();
	     	        	  while(rs.next()) {
	     	        	        Float a=rs.getFloat("m_total_Payer");
	     	        	        text_Mtp.setText(String.valueOf(a));
	     	        	   }
	     	        }
	     	       
	     	         catch(Exception e1){
	     	            JOptionPane.showMessageDialog(null,e1);
	     	            } 
	     	    
	     	}
	     });
		text_Mtp.setColumns(10);
		text_Mtp.setBounds(149, 273, 111, 20);
		panelDevis.add(text_Mtp);
		
		JLabel lblMr = new JLabel("Montant de retour:");
		lblMr.setForeground(new Color(0, 128, 128));
		lblMr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMr.setBounds(12, 305, 132, 18);
		panelDevis.add(lblMr);
		
		text_Mr = new JTextField();
		text_Mr.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     	        try {
		     	        	
		     	        	String sql="SELECT PU_hors_TVA,TVA FROM ligne_bl where code_client="+combobox_Client.getSelectedItem();
		     	        	
		     	        	pst= conn.prepareStatement(sql);
		     	        	rs=pst.executeQuery();
		     	        	  while(rs.next()) {
		     	        	        Float a=rs.getFloat("PU_hors_TVA");
		     	        	        Float b=rs.getFloat("TVA");
		     	        	        Float M = (a * (Integer.parseInt(text_Qte.getText())))+((b*a)/100);
		     	        	       text_Mr.setText(String.valueOf(M));
		     	        	   }
		     	        }
		     	       
		     	         catch(Exception e1){
		     	            JOptionPane.showMessageDialog(null,e1);
		     	            } 
		     	    
		     	}
		     });
		text_Mr.setColumns(10);
		text_Mr.setBounds(149, 306, 111, 20);
		panelDevis.add(text_Mr);
		
		text_Mar = new JTextField();
		text_Mar.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     	        
		     	        	float mtp = Float.parseFloat(text_Mtp.getText());
		     	        	float mr = Float.parseFloat(text_Mr.getText());
		     	        	text_Mar.setText(String.valueOf(mtp-mr));
		     	        	  
		     	        }
		     	     
		     });
		text_Mar.setColumns(10);
		text_Mar.setBounds(149, 335, 111, 20);
		panelDevis.add(text_Mar);
		
		JLabel lblMar = new JLabel(" Mantant \u00E0 rendre:");
		lblMar.setForeground(new Color(0, 128, 128));
		lblMar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMar.setBounds(12, 336, 111, 18);
		panelDevis.add(lblMar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(88, 463, 85, 85);
		panelDevis.add(panel_1);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setIcon(new ImageIcon(GestionClient.class.getResource("/image/plus.png")));
		btnAjouter.setBounds(6, 6, 32, 32);
		btnAjouter.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		
		     		try {
		     			Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
						
	                     
						Statement stmt = c.createStatement();
						String date1 = ((JTextField) txt_date.getDateEditor()
								.getUiComponent()).getText();
					
						
						Facture_avoir factureAvoir = new Facture_avoir(Integer.parseInt(text_Code.getText().toString()),
							Integer.parseInt(combobox_Client.getSelectedItem().toString()),date1,
							combobox_Pay.getSelectedItem().toString(),Integer.parseInt(combobox_CodeF.getSelectedItem().toString()),Integer.parseInt(text_Qte.getText().toString()),
							text_Designation.getText(),Float.parseFloat(text_Mtp.getText().toString()),Float.parseFloat(text_Mr.getText().toString()),
							Float.parseFloat(text_Mar.getText().toString()));
						
						String req= Requettes.ajouter_facture_avoir(factureAvoir);
						
						
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_FactureAvoir" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_FactureAvoir" , JOptionPane.OK_OPTION);
						
						String sql4 = "Update produit set stock = stock+'"+text_Qte.getText()+"'  where  designation='"+text_Designation.getText()+"'" ;
                        PreparedStatement pst4 = conn.prepareStatement(sql4);
                        pst4.execute();
                        pst4.close();
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_Code.getText(),
	           					combobox_Client.getSelectedItem(), 					
	           					((JTextField) txt_date.getDateEditor().getUiComponent()).getText(),
	           					combobox_Pay.getSelectedItem(),
	           					combobox_CodeF.getSelectedItem(),
	           					text_Qte.getText(),
	           					text_Designation.getText(),
	           					text_Mtp.getText(),
	           					text_Mr.getText(),
	           					text_Mar.getText(),
	           					
	           					});
	      				
	   					text_Code.setText(null);
	   					combobox_Client.setSelectedItem(null); 					
	   					combobox_Pay.setSelectedItem(null);
	   					combobox_CodeF.setSelectedItem(null);
    					text_Qte.setText(null);
    					text_Designation.setText(null);
    					text_Mtp.setText(null);
    					text_Mr.setText(null);
    					text_Mar.setText(null);
    					
    					
	      				
    					updateTable("1=1");
					}
					
					catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Facture n'est pas ajouter");
					}
				
		     	}
		     });
		panel_1.add(btnAjouter);
		
		JButton btnModifier = new JButton("");
		 btnModifier.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		     			Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
	                     
						Statement stmt = c.createStatement();

						String date1 = ((JTextField) txt_date.getDateEditor()
								.getUiComponent()).getText();
					
						
						Facture_avoir factureAvoir = new Facture_avoir(Integer.parseInt(text_Code.getText().toString()),
							Integer.parseInt(combobox_Client.getSelectedItem().toString()),date1,
							combobox_Pay.getSelectedItem().toString(),Integer.parseInt(combobox_CodeF.getSelectedItem().toString()),Integer.parseInt(text_Qte.getText().toString()),
							text_Designation.getText(),Float.parseFloat(text_Mtp.getText().toString()),Float.parseFloat(text_Mr.getText().toString()),
							Float.parseFloat(text_Mar.getText().toString()));
						
						
						String req= Requettes.modifier_facture_avoir(factureAvoir);
						
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de facture Avoir avec succés");
	                	pst.close();
	    
	      				
	                	text_Code.setText(null);
	   					combobox_Client.setSelectedItem(null); 					
	   					combobox_Pay.setSelectedItem(null);
	   					combobox_CodeF.setSelectedItem(null);
    					text_Qte.setText(null);
    					text_Designation.setText(null);
    					text_Mtp.setText(null);
    					text_Mr.setText(null);
    					text_Mar.setText(null);
    					
    					
	   					
	   					updateTable("1=1");
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null,"Facture n'est pas modifier");
					}
						
		     }});
		btnModifier.setIcon(new ImageIcon(GestionClient.class.getResource("/image/edit.png")));
		btnModifier.setBounds(44, 6, 32, 32);
		panel_1.add(btnModifier);
		
		JButton btnImprimer = new JButton("");
		btnImprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {

	        MessageFormat Header = new MessageFormat("les Factures Avoir");

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
	           		String sql = "DELETE FROM `facture_avoir` WHERE code=" +value; 
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
		
	
		
		JPanel panelListeDevis = new JPanel();
		panelListeDevis.setLayout(null);
		panelListeDevis.setOpaque(false);
		panelListeDevis.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des Facture Avoir",


								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelListeDevis.setBackground(Color.WHITE);
		panelListeDevis.setBounds(296, 0, 938, 567);
		add(panelListeDevis);
		
		 JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(10, 45, 916, 216);
         panelListeDevis.add(scrollPane);
     
         Object col []= {"code", "code_client", "date_facture","mode_payement","code_facture_client","qte_retour","desig_prod","MTPayer",
	    		 "MRetour","MAR"};
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
			           		String sql = "select * from facture_avoir WHERE code=" +code; 
			         
			           		pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			           		while (rs.next()) {
			           			
		                		text_Code.setText(rs.getString("code").toString());
		                		combobox_Client.setSelectedItem(rs.getString("code_client").toString());
		                		Date d = rs.getDate("date_facture");
		                		txt_date.setDate(d);
		                		combobox_Pay.setSelectedItem(rs.getString("mode_payement").toString());
		                		combobox_CodeF.setSelectedItem(rs.getString("code_facture_client").toString());
		                		text_Qte.setText(rs.getString("qte_retour").toString());
		                		text_Designation.setText(rs.getString("desig_prod").toString());
		                		text_Mtp.setText(rs.getString("MTPayer").toString());
		                		text_Mr.setText(rs.getString("MRetour").toString());
		                		text_Mar.setText(rs.getString("MAR").toString());
		                		
		                	
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
         lblNewLabel.setBounds(247, 441, 67, 64);
         panelListeDevis.add(lblNewLabel);
         
         
         combobox_Recherche.setModel(new DefaultComboBoxModel(new String[] {"code", "code_client", "date_facture","mode_payement","code_facture_client","qte_retour","desig_prod","MTPayer",
	    		 "MRetour","MAR"}));
         combobox_Recherche.setForeground(Color.BLACK);
         combobox_Recherche.setBackground(Color.WHITE);
         combobox_Recherche.setBounds(308, 458, 153, 29);
         panelListeDevis.add(combobox_Recherche);
         
         text_Recherche = new JTextField();
        /* text_Recherche.addKeyListener(new KeyAdapter() {
         	@Override
         	public void keyReleased(KeyEvent arg0) {
         		
         		try {
					String selection = (String)text_Recherche.getSelectedItem();
					String sql = "select * from facture_avoir where "+selection+"=?";
					
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,text_Recherche.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			
         	}
         });*/
        
         text_Recherche.setColumns(10);
         text_Recherche.setBounds(473, 458, 216, 29);
         panelListeDevis.add(text_Recherche);
         
         setVisible(true);

	}
	
	public void updateTable() {
		conn = connexion.Connecter();	
		
		if(conn != null)
			{
			String sql = "select * from facture_avoir";
         try {
         	pst = conn.prepareStatement(sql);
         	rs = pst.executeQuery();
         	Object col []= {"code", "code_client", "date_facture","mode_payement","code_facture_client","qte_retour","desig_prod","MTPayer",
   	    		 "MRetour","MAR"};
 			model.setColumnIdentifiers(col);
 			table.setModel(model);
         	Object[] columnData = new Object[10];
         	
         
         	while (rs.next()) {
         		
         		columnData[0] = rs.getInt("code");
         		columnData[1] = rs.getInt("code_client");
         		columnData[2] = rs.getDate("date_facture");
         		columnData[3] = rs.getString("mode_payement");
         		columnData[4] = rs.getInt("code_facture_client");
         		columnData[5] = rs.getInt("qte_retour");
         		columnData[6] = rs.getString("desig_prod");
         		columnData[7] = rs.getFloat("MTPayer");
         		columnData[8] = rs.getFloat("MRetour");
         		columnData[9] = rs.getFloat("MAR");
         		
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
				String sql1 = "select * from facture_avoir"; 
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
