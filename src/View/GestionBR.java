package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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

import com.toedter.calendar.JDateChooser;

import Connexion.Requettes;
import Connexion.connexion;
import Model.Bon_reception;
import Model.Ligne_BL;
import Model.Ligne_BR;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;

public class GestionBR extends JPanel {
	private JTextField text_Num;
	private JTextField text_MtTva;
	private JTextField text_M_hors_Tva;
	private JDateChooser txt_dateBon;
	DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable();
    private JTextField text_Recherche;
    private JTextField text_Adresse;
    private JTextField text_Ttc;
    private boolean emptyTable = false;
    private JComboBox combobox = new JComboBox();
    public Vector<Ligne_BR> Vcp;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField text_Code;

	/**
	 * Create the panel.
	 */
	public GestionBR(Vector<Ligne_BR> Vcp) {
		this.Vcp=Vcp;
		updateTable();
		setBackground(new Color(211, 211, 211));
		setSize(1234, 673);
		setLayout(null);
		
		JPanel panel_BL = new JPanel();
		panel_BL.setLayout(null);
		panel_BL.setOpaque(false);
		panel_BL.setBorder(new TitledBorder(UIManager

						.getBorder("TitledBorder.border"), "Bon Réception",

						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_BL.setBackground(Color.WHITE);
		panel_BL.setBounds(12, 13, 272, 660);
		add(panel_BL);
		
		JComboBox text_Fournisseur = new JComboBox();
		text_Fournisseur.setBounds(149, 76, 111, 22);
		panel_BL.add(text_Fournisseur);
		String sql = "select code_fournisseur from ligne_br";
		try{
            pst= conn.prepareStatement(sql);      
            rs=pst.executeQuery();
            while (rs.next()){
                int c=rs.getInt("code_fournisseur");
                text_Fournisseur.addItem(String.valueOf(c));
              
            }           
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
	
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setForeground(new Color(0, 128, 128));
		lblCode.setBackground(new Color(255, 255, 255));
		lblCode.setBounds(12, 47, 93, 18);
		panel_BL.add(lblCode);
		
		text_Code = new JTextField();
		text_Code.setOpaque(false);
		text_Code.setEditable(false);
		text_Code.setColumns(10);
		text_Code.setBounds(149, 43, 111, 20);
		panel_BL.add(text_Code);
		
		JLabel lblDateBon = new JLabel("Date du bon :");
		lblDateBon.setForeground(new Color(0, 128, 128));
		lblDateBon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateBon.setBounds(12, 109, 111, 18);
		panel_BL.add(lblDateBon);
		
		txt_dateBon = new JDateChooser();
		txt_dateBon.setDateFormatString("yyyy-MM-dd");
		txt_dateBon.setBounds(149, 107, 111, 20);
		panel_BL.add(txt_dateBon);
		
		JLabel lblDateDeReception = new JLabel("Date de r\u00E9ception :");
		lblDateDeReception.setForeground(new Color(0, 128, 128));
		lblDateDeReception.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateDeReception.setBounds(12, 144, 111, 18);
		panel_BL.add(lblDateDeReception);
		
		JDateChooser txt_dateReception = new JDateChooser();
		txt_dateReception.setDateFormatString("yyyy-MM-dd");
		txt_dateReception.setBounds(149, 140, 111, 20);
		panel_BL.add(txt_dateReception);
		
		JLabel lblNum = new JLabel("num comande de vente:");
		lblNum.setForeground(new Color(0, 128, 128));
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNum.setBounds(12, 222, 141, 18);
		panel_BL.add(lblNum);
		
		text_Num = new JTextField();
		text_Num.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sql = "SELECT MAX(num_cmd_achat) as nbre FROM bon_reception";
				try {
					pst = conn.prepareStatement(sql);
	            	rs = pst.executeQuery();
	            	while(rs.next()) {
	            		int nb= rs.getInt("nbre");
		            	int a = nb+1;
		            	text_Num.setText(String.valueOf(a));
	            	}
				
			}
				catch (Exception event) {
					JOptionPane.showMessageDialog(null, event);
				}
				
		}});
		text_Num.setColumns(10);
		text_Num.setBounds(149, 221, 111, 20);
		panel_BL.add(text_Num);
		
		JLabel lblMttva = new JLabel("montant totale TVA:");
		lblMttva.setForeground(new Color(0, 128, 128));
		lblMttva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMttva.setBounds(12, 272, 124, 18);
		panel_BL.add(lblMttva);
		
		JLabel lblM_hors_Tva = new JLabel("Montant T hors TVA:");
		lblM_hors_Tva.setForeground(new Color(0, 128, 128));
		lblM_hors_Tva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblM_hors_Tva.setBounds(12, 313, 141, 18);
		panel_BL.add(lblM_hors_Tva);
		
		JLabel lblTtc = new JLabel("TTC:");
		lblTtc.setForeground(new Color(0, 128, 128));
		lblTtc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtc.setBounds(12, 355, 111, 18);
		panel_BL.add(lblTtc);
		
		text_MtTva = new JTextField();
		text_MtTva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sql1="select sum(TVA) as tva from Ligne_br where code_fournisseur=?";
			       try{
			            pst= conn.prepareStatement(sql1);      
			            pst.setString(1,(String) text_Fournisseur.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                //String T=rs.getString("tva")+ "%";
			                String T=rs.getString("tva");
			                text_MtTva.setText(T);
			                rs.close();
			                pst.close();
			            }
			            
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		text_MtTva.setColumns(10);
		text_MtTva.setBounds(149, 271, 111, 20);
		panel_BL.add(text_MtTva);
		
		text_M_hors_Tva = new JTextField();
		text_M_hors_Tva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String sql2="select sum(P_total_horsTVA)as prix from ligne_br where code_fournisseur=?";
			       try{
			            pst= conn.prepareStatement(sql2);      
			            pst.setString(1,(String) text_Fournisseur.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                String t1=rs.getString("prix");
			                Float t11 = Float.parseFloat(t1);
			                text_M_hors_Tva.setText(String.valueOf(t11));
			                rs.close();
			                pst.close();
			            }           
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		text_M_hors_Tva.setColumns(10);
		text_M_hors_Tva.setBounds(149, 313, 111, 20);
		panel_BL.add(text_M_hors_Tva);
		
		text_Ttc = new JTextField();
		text_Ttc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float mthtva = Float.parseFloat(text_M_hors_Tva.getText().toString());
				float mttva = Float.parseFloat(text_MtTva.getText().toString());
				text_Ttc.setText(String.valueOf(mthtva+((mttva*mthtva)/100)));
			}
		});
		text_Ttc.setColumns(10);
		text_Ttc.setBounds(149, 355, 111, 20);
		panel_BL.add(text_Ttc);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(77, 562, 85, 85);
		panel_BL.add(panel_1);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		int fournisseur = Integer.parseInt(text_Fournisseur.getSelectedItem().toString()); 
				String sql = "select * from ligne_br where code_fournisseur="+fournisseur; 
				//System.out.println(sql);
	     		try {
	     			pst = conn.prepareStatement(sql);
	            	rs = pst.executeQuery();
	            	
	            	Vector<Ligne_BR> vector = new Vector<Ligne_BR>();
	      
	            	while (rs.next()) {
	            		int a = rs.getInt("ref");
	            		int b = rs.getInt("code_fournisseur");
	            		String c = rs.getString("designation");
	            		String d = rs.getString("unite_mesure");
	            		int ee = rs.getInt("qte_receptionnee");
	            		float f = rs.getFloat("PU_hors_TVA");
	            		float j = rs.getFloat("TVA");
	            		float h = rs.getFloat("P_total_horsTVA");
	            		
	            		
	            		Ligne_BR ligne_br = new Ligne_BR(a,b,c,d,ee,f,j,h);
	            		//System.out.println(ligne_br);
	            		vector.add(ligne_br);
	            		System.out.println(vector);
	            		
	            		
	            		
	            		 
	            	}
	            
	     			
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/entreprise";
					Connection c = DriverManager.getConnection(url,"root","");
                     
					Statement stmt = c.createStatement();
					
					
					String date1 = ((JTextField) txt_dateBon.getDateEditor()
							.getUiComponent()).getText();
				
					String date2 = ((JTextField) txt_dateReception.getDateEditor()
							.getUiComponent()).getText();
					
				
					System.out.println(date2);

					
					
					Bon_reception Bon_reception = new Bon_reception(0,
							Integer.parseInt(text_Fournisseur.getSelectedItem().toString()),date1,date2,text_Adresse.getText(),
							Integer.parseInt(text_Num.getText()),vector,Float.parseFloat(text_MtTva.getText().toString()),
							Float.parseFloat(text_M_hors_Tva.getText().toString()),
							Float.parseFloat(text_Ttc.getText().toString()));
					
					System.out.println(Bon_reception.toString());
					
				
					
					String req= Requettes.ajouter_bon_reception(Bon_reception);
					System.out.println(req);
					int nb=stmt.executeUpdate(req);
					if(nb==0)
						JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_BonReception" , JOptionPane.OK_OPTION);
					else
						JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_BonReception" , JOptionPane.OK_OPTION);
					
					
     					//vector.get(1)
					
					table.setModel(model);
           			DefaultTableModel model = (DefaultTableModel) table.getModel();
           			for (int index = 0; index < vector.size(); index++) {
           				
           			model.addRow(new Object[] {

           					text_Code.getText(),
           					text_Fournisseur.getSelectedItem(),
           					((JTextField) txt_dateBon.getDateEditor().getUiComponent()).getText(),
           					((JTextField) txt_dateReception.getDateEditor().getUiComponent()).getText(),
           					text_Adresse.getText(),
           					text_Num.getText(),
           					vector.get(index),
           					text_MtTva.getText(),
           					text_M_hors_Tva.getText(),
           					text_Ttc.getText(),
           					
           					});
      						      			
	     		
           			text_Code.setText(null);
           			text_Fournisseur.setSelectedItem(null);
   					((JTextField) txt_dateBon.getDateEditor().getUiComponent()).setText(null);
   					((JTextField) txt_dateReception.getDateEditor().getUiComponent()).setText(null);
   					text_Adresse.setText(null);
   					text_Num.setText(null);
   					text_MtTva.setText(null);
   					text_M_hors_Tva.setText(null);
   					text_Ttc.setText(null);
				}}
				
				catch (Exception event) {
					JOptionPane.showMessageDialog(null, "Bon Reception n'est pas Ajouter");
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
							
							String date1 = ((JTextField) txt_dateBon.getDateEditor()
									.getUiComponent()).getText();
							
							String date2 = ((JTextField) txt_dateReception.getDateEditor()
									.getUiComponent()).getText();
							
							Bon_reception bonreceptionUp = new Bon_reception(Integer.parseInt(text_Code.getText().toString()),
									Integer.parseInt(text_Fournisseur.getSelectedItem().toString()),date1,date2,text_Adresse.getText(),
									Integer.parseInt(text_Num.getText()),Float.parseFloat(text_MtTva.getText().toString()),
									Float.parseFloat(text_M_hors_Tva.getText().toString()),
									Float.parseFloat(text_Ttc.getText().toString()));
							
						String req= Requettes.modifier_bon_reception(bonreceptionUp);
								System.out.println(req);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de bon reception avec succés");
	                	pst.close();
	                	
			      			
		     		
	           			text_Code.setText(null);
	           			text_Fournisseur.setSelectedItem(null);
	   					((JTextField) txt_dateBon.getDateEditor().getUiComponent()).setText(null);
	   					((JTextField) txt_dateReception.getDateEditor().getUiComponent()).setText(null);
	   					text_Adresse.setText(null);
	   					text_Num.setText(null);
	   					text_MtTva.setText(null);
	   					text_M_hors_Tva.setText(null);
	   					text_Ttc.setText(null);
	   					
	   					updateTable("1=1");
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Bon Reception n'est pas Modifier");
					}
						
		     }});
		btnModifier.setIcon(new ImageIcon(GestionClient.class.getResource("/image/edit.png")));
		btnModifier.setBounds(44, 6, 32, 32);
		panel_1.add(btnModifier);
		
		JButton btnImprimer = new JButton("");
		
		btnImprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/printer.png")));
		btnImprimer.setBounds(6, 44, 32, 32);
		panel_1.add(btnImprimer);
		
		JButton btnSupprimer = new JButton("");
		 btnSupprimer.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		           		int row = table.getSelectedRow();
		           		String value =  table.getModel().getValueAt(row, 0).toString();
		           		String sql = "DELETE FROM `bon_reception` WHERE code=" +value; 
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
		    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion des bon reception", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des bon reception", JOptionPane.OK_OPTION);
		    					}
		    				}}

		     	}
		     });
		btnSupprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/trash.png")));
		btnSupprimer.setBounds(44, 44, 32, 32);
		panel_1.add(btnSupprimer);
		
		JLabel lblFournisseur = new JLabel("code fournisseur:");
		lblFournisseur.setForeground(new Color(0, 128, 128));
		lblFournisseur.setBackground(Color.WHITE);
		lblFournisseur.setBounds(12, 78, 111, 18);
		panel_BL.add(lblFournisseur);
		
		
		
		JLabel lblAdresseReception = new JLabel("Adresse r\u00E9ception:");
		lblAdresseReception.setForeground(new Color(0, 128, 128));
		lblAdresseReception.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresseReception.setBounds(12, 175, 111, 18);
		panel_BL.add(lblAdresseReception);
		
		text_Adresse = new JTextField();
		text_Adresse.setColumns(10);
		text_Adresse.setBounds(149, 173, 111, 20);
		panel_BL.add(text_Adresse);
		
		
		
		JPanel panelListe_BL = new JPanel();
		panelListe_BL.setLayout(null);
		panelListe_BL.setOpaque(false);
		panelListe_BL.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des Bon Reception",


								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelListe_BL.setBackground(Color.WHITE);
		panelListe_BL.setBounds(296, 13, 938, 647);
		add(panelListe_BL);
		
		combobox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Fournisseur", "Date_bon","Date_reception","Adresse_reception",
 	    		 "num_cmd_achat","ligne_br","m_total_TVA","m_total_hors_TVA","m_total_Payer"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(301, 555, 153, 29);
			panelListe_BL.add(combobox);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 916, 216);
        panelListe_BL.add(scrollPane);
        
	     
			 Object tab []= {"Code", "Fournisseur", "Date_bon","Date_reception","Adresse_reception",
	   	    		 "num_cmd_achat","ligne_br","m_total_TVA","m_total_hors_TVA","m_total_Payer"};
				model.setColumnIdentifiers(tab);
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
				           		String sql = "SELECT * FROM `bon_reception` WHERE code=" +code; 
				         
				           		pst = c.prepareStatement(sql);
				    			rs = pst.executeQuery();
				           		while (rs.next()) {
			                	
			                		text_Code.setText(rs.getString("code").toString());
			                		text_Fournisseur.setSelectedItem(rs.getString("code_fournisseur").toString());
			                		Date d = rs.getDate("date_bon");
			                		txt_dateBon.setDate(d);
			                		Date d1 = rs.getDate("date_reception");
			                		txt_dateReception.setDate(d1);
			                		text_Adresse.setText(rs.getString("adresse_reception").toString());
			                		text_Num.setText(rs.getString("num_cmd_achat").toString());
			                		rs.getBlob("ligne_br");
			                		text_MtTva.setText(rs.getString("m_total_TVA").toString());
			                		text_M_hors_Tva.setText(rs.getString("m_total_hors_TVA").toString());
			                		text_Ttc.setText(rs.getString("m_total_Payer").toString());
			                		
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
        lblNewLabel.setIcon(new ImageIcon(GestionFournisseur.class.getResource("/image/search.png")));
        lblNewLabel.setBounds(251, 539, 48, 64);
        panelListe_BL.add(lblNewLabel);
        
        text_Recherche = new JTextField();
        text_Recherche.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		try {
					String selection = (String)combobox.getSelectedItem();
					String sql = "select * from bon_reception where "+selection+"=?"; 
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
      
        text_Recherche.setBounds(466, 555, 216, 29);
        panelListe_BL.add(text_Recherche);
        text_Recherche.setColumns(10);
        setVisible(true);

	}
	public void updateTable() {
		conn = connexion.Connecter();	
		
		if(conn != null)
			{
			String sql = "SELECT * FROM `bon_reception`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "code_Fournisseur", "Date_bon","Date_reception","Adresse_reception",
          	    		 "Num_cmd_achat","ligne_br","m_total_TVA","m_total_hors_TVA","m_total_Payer"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[10];
            	
            
            	while (rs.next()) {
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("code_fournisseur");
            		columnData[2] = rs.getDate("date_bon");
            		columnData[3] = rs.getDate("date_reception");
            		columnData[4] = rs.getString("adresse_reception");
            		columnData[5] = rs.getString("num_cmd_achat");
            		columnData[6] = rs.getBlob("ligne_br");
            		columnData[7] = rs.getFloat("m_total_TVA");
            		columnData[8] = rs.getFloat("m_total_hors_TVA");
            		columnData[9] = rs.getFloat("m_total_Payer");
            		
            		 
            		
            		
            		
            	
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
				String sql1 = "select * from bon_reception"; 
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
