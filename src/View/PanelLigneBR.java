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
import Model.Ligne_BR;
import net.proteanit.sql.DbUtils;

public class PanelLigneBR extends JPanel {
		private JTextField text_Reference;
		private JTextField text_Desig;
		private JTextField text_Unite;
		private JTextField text_Qte;
		private JTextField text_HorsTva;
		private JTextField text_Tva;
		private JDateChooser txt_dateRecep;
		DefaultTableModel model = new DefaultTableModel();
	    static JTable table = new JTable();
	    private JTextField text_Recherche;
	    private JTextField text_PT;
	    private boolean emptyTable = false;
	    private JComboBox combobox_recherche = new JComboBox();
		
		
	   	Connection conn = null;
	   	PreparedStatement pst = null;
	   	ResultSet rs = null;


		/**
		 * Create the panel.
		 */
	   	public PanelLigneBR() {
	   		updateTable();
			setBackground(new Color(211, 211, 211));
			setSize(1234, 673);
			setLayout(null);
			setVisible(true);
			
			JPanel panel_BR = new JPanel();
			panel_BR.setLayout(null);
			panel_BR.setOpaque(false);
			panel_BR.setBorder(new TitledBorder(UIManager

							.getBorder("TitledBorder.border"), "Ligne Bon R�ception",

							TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_BR.setBackground(Color.WHITE);
			panel_BR.setBounds(12, 13, 272, 647);
			add(panel_BR);
			
			JComboBox text_Code = new JComboBox();
			String sql = "select code from fournisseur";
			try{
	            pst= conn.prepareStatement(sql);      
	            rs=pst.executeQuery();
	            while (rs.next()){
	                int t1=rs.getInt("code");
	                System.out.println(t1);
	                text_Code.addItem(String.valueOf(t1));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
			text_Code.setBounds(149, 93, 111, 22);
			panel_BR.add(text_Code);
			
			JLabel lblCode = new JLabel("Code fournisseur:");
			lblCode.setForeground(new Color(0, 128, 128));
			lblCode.setBackground(new Color(255, 255, 255));
			lblCode.setBounds(12, 95, 111, 18);
			panel_BR.add(lblCode);
			
			JLabel lblReference = new JLabel("R\u00E9f\u00E9rence:");
			lblReference.setForeground(new Color(0, 128, 128));
			lblReference.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblReference.setBounds(12, 55, 111, 18);
			panel_BR.add(lblReference);
			
			JLabel lblDesignation = new JLabel("D\u00E9signation:");
			lblDesignation.setForeground(new Color(0, 128, 128));
			lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDesignation.setBounds(12, 139, 111, 18);
			panel_BR.add(lblDesignation);
			
			text_Reference = new JTextField();
			text_Reference.setColumns(10);
			text_Reference.setBounds(149, 54, 111, 20);
			panel_BR.add(text_Reference);
			
			JLabel lblUnite = new JLabel("Unit\u00E9 de mesure:");
			lblUnite.setForeground(new Color(0, 128, 128));
			lblUnite.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUnite.setBounds(12, 189, 120, 18);
			panel_BR.add(lblUnite);
			
			JComboBox text_Desig = new JComboBox();
			 String sql1 = "select designation from produit";
	            try{
	                pst= conn.prepareStatement(sql1);     
	                rs=pst.executeQuery();
	                while (rs.next()){
	                    String d=rs.getString("designation");
	                    text_Desig.addItem(d);
	                 
	                }          
	            }catch(Exception e1){
	                JOptionPane.showMessageDialog(null,e1);
	            }
			text_Desig.setBounds(149, 139, 111, 22);
			panel_BR.add(text_Desig);
			
			JLabel lblQuantiteL = new JLabel("Quantit\u00E9 r\u00E9ceptionn\u00E9e:");
			lblQuantiteL.setForeground(new Color(0, 128, 128));
			lblQuantiteL.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblQuantiteL.setBounds(12, 234, 138, 18);
			panel_BR.add(lblQuantiteL);
			
			JComboBox text_Unite = new JComboBox();
			String sql2 = "select unite_mesure from produit";
           try{
               pst= conn.prepareStatement(sql2);     
               rs=pst.executeQuery();
               while (rs.next()){
                   String um=rs.getString("unite_mesure");
                   text_Unite.addItem(um);
                
               }          
           }catch(Exception e1){
               JOptionPane.showMessageDialog(null,e1);
           }
			text_Unite.setBounds(149, 187, 111, 22);
			panel_BR.add(text_Unite);
			
			text_Qte = new JTextField();
			text_Qte.setColumns(10);
			text_Qte.setBounds(149, 233, 111, 20);
			panel_BR.add(text_Qte);
			
			JLabel lblPU = new JLabel("PU hors Tva:");
			lblPU.setForeground(new Color(0, 128, 128));
			lblPU.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPU.setBounds(12, 277, 111, 18);
			panel_BR.add(lblPU);
			
			JLabel lblTva = new JLabel("TVA Appliqu\u00E9e:");
			lblTva.setForeground(new Color(0, 128, 128));
			lblTva.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTva.setBounds(12, 329, 93, 18);
			panel_BR.add(lblTva);
			
			JLabel lblPT = new JLabel("PT hors Tva");
			lblPT.setForeground(new Color(0, 128, 128));
			lblPT.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPT.setBounds(12, 372, 111, 18);
			panel_BR.add(lblPT);
			
			text_HorsTva = new JTextField();
			text_HorsTva.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                 String sql2="select PU_hors_taxe from produit where designation=?";
	                   try{
	                        pst= conn.prepareStatement(sql2);     
	                        pst.setString(1,(String) text_Desig.getSelectedItem());
	                        rs=pst.executeQuery();
	                        if (rs.next()){
	                            String t1=rs.getString("PU_hors_taxe");
	                            Float t11 = Float.parseFloat(t1);
	                            text_HorsTva.setText(String.valueOf(t11));
	                            rs.close();
	                            pst.close();
	                        }          
	                    }catch(Exception e1){
	                        JOptionPane.showMessageDialog(null,e1);
	                    }
	            }
	        });
			text_HorsTva.setColumns(10);
			text_HorsTva.setBounds(149, 277, 111, 20);
			panel_BR.add(text_HorsTva);
			
			text_Tva = new JTextField();
			text_Tva.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                 String sql2="select TVA from produit where designation=?";
	                   try{
	                        pst= conn.prepareStatement(sql2);     
	                        pst.setString(1,(String) text_Desig.getSelectedItem());
	                        rs=pst.executeQuery();
	                        if (rs.next()){
	                            String t1=rs.getString("TVA");
	                            Float t11 = Float.parseFloat(t1);
	                            text_Tva.setText(String.valueOf(t11));
	                            rs.close();
	                            pst.close();
	                        }          
	                    }catch(Exception e1){
	                        JOptionPane.showMessageDialog(null,e1);
	                    }
	            }
	        });
			text_Tva.setColumns(10);
			text_Tva.setBounds(149, 328, 111, 20);
			panel_BR.add(text_Tva);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setOpaque(false);
			panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_1.setBounds(78, 495, 85, 85);
			panel_BR.add(panel_1);
			
			JButton btnAjouter = new JButton("");
			btnAjouter.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		     			
		     			Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
	                     
						Statement stmt = c.createStatement();
						
				
						Ligne_BR ligne_BR = new Ligne_BR(Integer.parseInt(text_Reference.getText()),
								Integer.parseInt(text_Code.getSelectedItem().toString()),text_Desig.getSelectedItem().toString(),text_Unite.getSelectedItem().toString(),
								Integer.parseInt(text_Qte.getText().toString()),Float.parseFloat(text_HorsTva.getText().toString()),Float.parseFloat(text_Tva.getText().toString()),
								Float.parseFloat(text_PT.getText().toString()));
						
						
						String req= Requettes.ajouter_ligne_BR(ligne_BR);
						//System.out.println(req);
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_LigneBR" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succ�s!","Ajout_LigneBR" , JOptionPane.OK_OPTION);
						
						String sql4 = "Update produit set stock = stock+'"+text_Qte.getText()+"'  where  designation='"+text_Desig.getSelectedItem()+"'" ;
                        PreparedStatement pst4 = conn.prepareStatement(sql4);
                        pst4.execute();
                        pst4.close();

						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_Reference.getText(),
	           					text_Code.getSelectedItem(),
	           					text_Desig.getSelectedItem(),
	           					text_Unite.getSelectedItem(),
	           					text_Qte.getText(),
	           					text_HorsTva.getText(),
	           					text_Tva.getText(),
	           					text_PT.getText()
	           					});
	      			
					}
					
					catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Ligne BR n'est pas ajouter");
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
					
						Ligne_BR ligne_BRUp = new Ligne_BR(Integer.parseInt(text_Reference.getText()),
								Integer.parseInt(text_Code.getSelectedItem().toString()),text_Desig.getSelectedItem().toString(),text_Unite.getSelectedItem().toString(),
								Integer.parseInt(text_Qte.getText().toString()),Float.parseFloat(text_HorsTva.getText().toString()),Float.parseFloat(text_Tva.getText().toString()),
								Float.parseFloat(text_PT.getText().toString()));
						
						
						String req= Requettes.modifier_ligneBR(ligne_BRUp);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise � jour de ligne bon reception avec succ�s");
	                	pst.close();
			      				
	   					text_Reference.setText(null);
	           			text_Code.setSelectedItem(null);
	           			text_Desig.setSelectedItem(null);
	   					text_Unite.setSelectedItem(null);
	   					text_Qte.setText(null);
	   					text_HorsTva.setText(null);
	   					text_Tva.setText(null);
	   					text_PT.setText(null);
	   					updateTable("1=1 ");
	   					
	   					
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null, "Ligne BR n'est pas modifier");
					}
						
		     }});
			btnModifier.setIcon(new ImageIcon(GestionClient.class.getResource("/image/edit.png")));
			btnModifier.setBounds(44, 6, 32, 32);
			panel_1.add(btnModifier);
			
			JButton btnImprimer = new JButton("");
			btnImprimer.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {

		        MessageFormat Header = new MessageFormat("les Lignes Bon Reception");

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
			           		String sql = "DELETE FROM `ligne_br` WHERE ref=" +value; 
			           		pst = conn.prepareStatement(sql);
			            	pst.execute();
			            	JOptionPane.showMessageDialog(null, "Donn�es supprim�s");
			            	pst.close();
			            	DefaultTableModel model = (DefaultTableModel) table.getModel();
			            	model.removeRow(table.getSelectedRow());}
			           		
			           		catch(Exception ex) {
			           			JOptionPane.showMessageDialog(null, ex);
			           			if(table.getSelectedRow() == -1) {
			    					if(table.getRowCount() == 0) {
			    						JOptionPane.showMessageDialog(null, "Aucune donn�e pour supprimer" , "ligne BR", JOptionPane.OK_OPTION);
			    					}
			    					else {
			    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "ligne BR", JOptionPane.OK_OPTION);
			    					}
			    				}}

			     	}
			     });
			btnSupprimer.setIcon(new ImageIcon(GestionClient.class.getResource("/image/trash.png")));
			btnSupprimer.setBounds(44, 44, 32, 32);
			panel_1.add(btnSupprimer);
			
			text_PT = new JTextField();
			text_PT.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int qte = Integer.parseInt(text_Qte.getText().toString());
					float puhorstva = Float.parseFloat(text_HorsTva.getText().toString());
					text_PT.setText(String.valueOf(qte*puhorstva));
				}
			});
			text_PT.setColumns(10);
			text_PT.setBounds(149, 372, 111, 20);
			panel_BR.add(text_PT);
			
			
			
			
			
			JPanel panelListe_BR = new JPanel();
			panelListe_BR.setLayout(null);
			panelListe_BR.setOpaque(false);
			panelListe_BR.setBorder(new TitledBorder(UIManager


									.getBorder("TitledBorder.border"), "Liste des Lignes Bon R�ception",


									TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panelListe_BR.setBackground(Color.WHITE);
			panelListe_BR.setBounds(296, 13, 938, 647);
			add(panelListe_BR);
			
			combobox_recherche.setModel(new DefaultComboBoxModel(new String[] {"Ref", "Code_Fournisseur",
		    		 "Designation","Unite_mesure",
		    		 "Qte_recep","PU_hors_TVA","TVA","PTotalHorsTVA"}));
				combobox_recherche.setForeground(Color.black);
				combobox_recherche.setBackground(new Color(255, 255, 255));
				combobox_recherche.setBounds(326, 559, 133, 29);
				panelListe_BR.add(combobox_recherche);
			
			JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(10, 45, 916, 216);
	        panelListe_BR.add(scrollPane);
	        
	        Object tab []= {"Ref", "Code_Fournisseur","Designation","Unite_mesure",
		    		 "Qte_recep","PU_hors_TVA","TVA","PTotalHorsTVA"};
				model.setColumnIdentifiers(tab);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (!emptyTable) {
							try {
								Class.forName("com.mysql.jdbc.Driver");
				    			String url = "jdbc:mysql://localhost:3306/entreprise";
				    			Connection c = DriverManager.getConnection(url,"root","");
				    			Statement stmt = c.createStatement();
								int row = table.getSelectedRow();
								int code = Integer.parseInt((table.getModel().getValueAt(row, 0))
										.toString());
				           		String sql = "SELECT * FROM `ligne_br` WHERE ref=" +code; 
				         
				           		pst = c.prepareStatement(sql);
				    			rs = pst.executeQuery();
				           		while (rs.next()) {
				           			
			                		text_Reference.setText(rs.getString("ref").toString());
			                		text_Code.setSelectedItem(rs.getString("code_fournisseur").toString());
			                		text_Desig.setSelectedItem(rs.getString("designation").toString());
			                		text_Unite.setSelectedItem(rs.getString("unite_mesure").toString());
			                		text_Qte.setText(rs.getString("qte_receptionnee").toString());
			                		text_HorsTva.setText(rs.getString("PU_hors_TVA").toString());
			                		text_Tva.setText(rs.getString("TVA").toString());
			                		text_PT.setText(rs.getString("P_total_horsTVA").toString());

			                	}
								
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Veuillez s�lectionner une ligne valide");
							}
					}}
					
				});
				table.setModel(model);
				table.getColumnModel().getColumn(0).setPreferredWidth(89);
				scrollPane.setViewportView(table);
	       
	        
	        JLabel lblNewLabel = new JLabel("");
	        lblNewLabel.setIcon(new ImageIcon(GestionClient.class.getResource("/image/search.png")));
	        lblNewLabel.setBounds(274, 540, 51, 64);
	        panelListe_BR.add(lblNewLabel);
	        
	        text_Recherche = new JTextField();
	        text_Recherche.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						String selection = (String)combobox_recherche.getSelectedItem();
						String sql = "select * from ligne_br where "+selection+"=?"; 
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
	        text_Recherche.setBounds(466, 559, 222, 29);
	        panelListe_BR.add(text_Recherche);
	        text_Recherche.setColumns(10);

	        setVisible(true);
			

		}
	   	public void updateTable() {
	   		conn = connexion.Connecter();	
			if(conn != null)
				{
				String sql = "SELECT * FROM `ligne_br`";
	            try {
	            	pst = conn.prepareStatement(sql);
	            	rs = pst.executeQuery();
	            	Object col []= {"Ref", "Code_Fournisseur","Designation","Unite_mesure",
	       	    		 "Qte_recep","PU_hors_TVA","TVA","PTotalHorsTVA"};
	    			model.setColumnIdentifiers(col);
	    			table.setModel(model);
	            	Object[] columnData = new Object[13];
	      
	            	while (rs.next()) {
	            		
	            		columnData[0] = rs.getInt("ref");
	            		columnData[1] = rs.getInt("code_fournisseur");
	            		columnData[2] = rs.getString("designation");
	            		columnData[3] = rs.getString("unite_mesure");
	            		columnData[4] = rs.getString("qte_receptionnee");
	            		columnData[5] = rs.getFloat("PU_hors_TVA");
	            		columnData[6] = rs.getFloat("TVA");
	            		columnData[7] = rs.getFloat("P_total_horsTVA");
	            		
	            		 
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
					String sql1 = "select * from ligne_br"; 
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


