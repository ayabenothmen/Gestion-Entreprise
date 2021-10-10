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
import java.text.MessageFormat;
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
import Model.Devis;
import Model.Ligne_devis;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;

public class GestionDevis extends JPanel {
	private JTextField text_Code;
	private JTextField text_MtTva;
	private JTextField text_M_hors_Tva;
	DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable();
    private JTextField text_Recherche;
    private JTextField text_Ttc;
    private boolean emptyTable = false;
    private JComboBox combobox = new JComboBox();
    public Vector<Ligne_devis> Vcp;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Create the panel.
	 */
	public GestionDevis(Vector<Ligne_devis> Vcp) {
		this.Vcp=Vcp;
		updateTable();
		setBackground(new Color(211, 211, 211));
		setSize(1234, 673);
		setLayout(null);
		
		JPanel panel_BL = new JPanel();
		panel_BL.setLayout(null);
		panel_BL.setOpaque(false);
		panel_BL.setBorder(new TitledBorder(UIManager

						.getBorder("TitledBorder.border"), "Devis",

						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_BL.setBackground(Color.WHITE);
		panel_BL.setBounds(12, 13, 272, 660);
		add(panel_BL);
		
		text_Code = new JTextField();
		text_Code.setColumns(10);
		text_Code.setBounds(149, 66, 111, 20);
		text_Code.setOpaque(false);
		text_Code.setEditable(false);
		panel_BL.add(text_Code);
		
		JDateChooser txt_date = new JDateChooser();
		txt_date.setDateFormatString("yyyy-MM-dd");
		txt_date.setBounds(149, 128, 111, 20);
		panel_BL.add(txt_date);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setForeground(new Color(0, 128, 128));
		lblCode.setBackground(new Color(255, 255, 255));
		lblCode.setBounds(12, 68, 93, 18);
		panel_BL.add(lblCode);
		
		JComboBox text_Client = new JComboBox();
		text_Client.setBounds(149, 93, 111, 22);
		panel_BL.add(text_Client);
		String sql = "select code_client from ligne_devis";
		try{
            pst= conn.prepareStatement(sql);      
            rs=pst.executeQuery();
            while (rs.next()){
                int nb=rs.getInt("code_client");
                text_Client.addItem(String.valueOf(nb));
              
            }           
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
	
		
		JLabel lblDateBon = new JLabel("Date :");
		lblDateBon.setForeground(new Color(0, 128, 128));
		lblDateBon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateBon.setBounds(12, 130, 111, 18);
		panel_BL.add(lblDateBon);
		
		
		JLabel lblMttva = new JLabel("Montant totale TVA:");
		lblMttva.setForeground(new Color(0, 128, 128));
		lblMttva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMttva.setBounds(12, 161, 124, 18);
		panel_BL.add(lblMttva);
		
		JLabel lblM_hors_Tva = new JLabel("Montant T hors TVA:");
		lblM_hors_Tva.setForeground(new Color(0, 128, 128));
		lblM_hors_Tva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblM_hors_Tva.setBounds(12, 192, 141, 18);
		panel_BL.add(lblM_hors_Tva);
		
		JLabel lblTtc = new JLabel("Montant T \u00E0 Payer:");
		lblTtc.setForeground(new Color(0, 128, 128));
		lblTtc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtc.setBounds(12, 223, 111, 18);
		panel_BL.add(lblTtc);
		
		text_MtTva = new JTextField();
		text_MtTva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sql1="select sum(TVA_appliquee) as tva_appliquee from Ligne_devis where code_client=?";
			       try{
			            pst= conn.prepareStatement(sql1);      
			            pst.setString(1,(String) text_Client.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                //String T=rs.getString("tva")+ "%";
			                String T=rs.getString("tva_appliquee");
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
		text_MtTva.setBounds(149, 161, 111, 20);
		panel_BL.add(text_MtTva);
		
		text_M_hors_Tva = new JTextField();
		text_M_hors_Tva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String sql2="select sum(P_total_horsTVA)as prix from ligne_devis where code_client=?";
			       try{
			            pst= conn.prepareStatement(sql2);      
			            pst.setString(1,(String) text_Client.getSelectedItem());
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
		text_M_hors_Tva.setBounds(149, 194, 111, 20);
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
		text_Ttc.setBounds(149, 223, 111, 20);
		panel_BL.add(text_Ttc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(78, 485, 85, 85);
		panel_BL.add(panel_1);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		int client = Integer.parseInt(text_Client.getSelectedItem().toString()); 
				String sql = "select * from ligne_devis where code_client="+client; 
	     		try {
	     			pst = conn.prepareStatement(sql);
	            	rs = pst.executeQuery();
	            	
	            	Vector<Ligne_devis> vector = new Vector<Ligne_devis>();
	      
	            	while (rs.next()) {
	            		int a = rs.getInt("ref");
	            		int b = rs.getInt("code_client");
	            		String c = rs.getString("designation");
	            		String d = rs.getString("unite_mesure");
	            		int ee = rs.getInt("qte_receptionnee");
	            		float f = rs.getFloat("PU_hors_TVA");
	            		float j = rs.getFloat("TVA_appliquee");
	            		float h = rs.getFloat("P_total_horsTVA");
	            		
	            		
	            		Ligne_devis ligne_devis = new Ligne_devis(a,b,c,d,ee,f,j,h);
	            		//System.out.println(ligne_bl);
	            		vector.add(ligne_devis);
            		 
	            	}
	            
	     			
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/entreprise";
					Connection c = DriverManager.getConnection(url,"root","");
                     
					Statement stmt = c.createStatement();
					
					String date1 = ((JTextField) txt_date.getDateEditor()
							.getUiComponent()).getText();

					Devis devis = new Devis(0,
							date1,Integer.parseInt(text_Client.getSelectedItem().toString()),vector,Float.parseFloat(text_MtTva.getText().toString()),
							Float.parseFloat(text_M_hors_Tva.getText().toString()),
							Float.parseFloat(text_Ttc.getText().toString()));

					
					String req= Requettes.ajouter_devis(devis);
					//System.out.println(req);
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
           					text_Client.getSelectedItem(),
           					((JTextField) txt_date.getDateEditor().getUiComponent()).getText(),
           					vector.get(index),
           					text_MtTva.getText(),
           					text_M_hors_Tva.getText(),
           					text_Ttc.getText(),
           					
           					});
	     		
           			text_Code.setText(null);
           			text_Client.setToolTipText(null);
   					((JTextField) txt_date.getDateEditor().getUiComponent()).setText(null);
   					text_MtTva.setText(null);
   					text_M_hors_Tva.setText(null);
   					text_Ttc.setText(null);
   					updateTable("1=1");
				}}
				
				catch (Exception event) {
					JOptionPane.showMessageDialog(null, "Devis n'est pas Ajouter");
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
							
							String date1 = ((JTextField) txt_date.getDateEditor()
									.getUiComponent()).getText();
							
							Devis devisUp = new Devis(Integer.parseInt(text_Code.getText().toString()),date1,
									Integer.parseInt(text_Client.getSelectedItem().toString()),
									Float.parseFloat(text_MtTva.getText().toString()),
									Float.parseFloat(text_M_hors_Tva.getText().toString()),
									Float.parseFloat(text_Ttc.getText().toString()));
							
						String req= Requettes.modifier_devis(devisUp);
						System.out.println(req);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de bon reception avec succés");
	                	pst.close();
	                		     		
	           			text_Code.setText(null);
	           			text_Client.setToolTipText(null);
	   					((JTextField) txt_date.getDateEditor().getUiComponent()).setText(null);
	   					text_MtTva.setText(null);
	   					text_M_hors_Tva.setText(null);
	   					text_Ttc.setText(null);
	   					
	   					updateTable("1=1");
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Devis n'est pas Modifier");
					}
						
		     }});
		btnModifier.setIcon(new ImageIcon(GestionClient.class.getResource("/image/edit.png")));
		btnModifier.setBounds(44, 6, 32, 32);
		panel_1.add(btnModifier);
		
		JButton btnImprimer = new JButton("");
		btnImprimer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {

	        MessageFormat Header = new MessageFormat("les Devis");

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
		           		String sql = "DELETE FROM `devis` WHERE code=" +value; 
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
		    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Devis", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Devis", JOptionPane.OK_OPTION);
		    					}
		    				}}

		     	}
		     });
		btnSupprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/trash.png")));
		btnSupprimer.setBounds(44, 44, 32, 32);
		panel_1.add(btnSupprimer);
		
		JLabel lblClient = new JLabel("Client:");
		lblClient.setForeground(new Color(0, 128, 128));
		lblClient.setBackground(Color.WHITE);
		lblClient.setBounds(12, 99, 93, 18);
		panel_BL.add(lblClient);
		
	
		JPanel panelListe_BL = new JPanel();
		panelListe_BL.setLayout(null);
		panelListe_BL.setOpaque(false);
		panelListe_BL.setBorder(new TitledBorder(UIManager


								.getBorder("TitledBorder.border"), "Liste des Devis",


								TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelListe_BL.setBackground(Color.WHITE);
		panelListe_BL.setBounds(296, 13, 938, 647);
		add(panelListe_BL);
		
		combobox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Code_client", "Date","ligne_devis","m_total_TVA","m_total_hors_TVA","m_total_Payer"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(301, 555, 153, 29);
			panelListe_BL.add(combobox);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 916, 216);
        panelListe_BL.add(scrollPane);
        
	     
			 Object tab []= {"Code", "Code_client", "Date","ligne_devis","m_total_TVA","m_total_hors_TVA","m_total_Payer"};
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
				           		String sql = "SELECT * FROM `devis` WHERE code=" +code; 
				         
				           		pst = c.prepareStatement(sql);
				    			rs = pst.executeQuery();
				           		while (rs.next()) {
			                	
			                		text_Code.setText(rs.getString("code").toString());
			                		text_Client.setSelectedItem(rs.getString("code_client").toString());
			                		Date d = rs.getDate("date_bon");
			                		txt_date.setDate(d);
			                		rs.getBlob("ligne_devis");
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
        lblNewLabel.setIcon(new ImageIcon(GestionClient.class.getResource("/image/search.png")));
        lblNewLabel.setBounds(251, 539, 48, 64);
        panelListe_BL.add(lblNewLabel);
        
        text_Recherche = new JTextField();
        text_Recherche.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        		try {
					String selection = (String)combobox.getSelectedItem();
					String sql = "select * from devis where "+selection+"=?"; 
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1,text_Recherche.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
					
				} catch (Exception event) {
                    JOptionPane.showMessageDialog(null,event);
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
			String sql = "SELECT * FROM `devis`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "Code_client", "Date","ligne_devis","m_total_TVA","m_total_hors_TVA","m_total_Payer"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[10];
            	
            
            	while (rs.next()) {
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("code_client");
            		columnData[2] = rs.getDate("date");
            		columnData[3] = rs.getBlob("ligne_devis");
            		columnData[4] = rs.getFloat("m_total_TVA");
            		columnData[5] = rs.getFloat("m_total_hors_TVA");
            		columnData[6] = rs.getFloat("m_total_Payer");
            		
            		 
            		
            		
            		
            	
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
				String sql1 = "select * from devis"; 
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
