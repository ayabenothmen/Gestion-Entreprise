package View;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Model.Ligne_BL;
import Model.Ligne_devis;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import View.Dashboard;
import View.GestionClient;
import View.GestionProduit;
import View.GestionFacture;
import View.GestionDevis;
import View.GestionBL;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.CardLayout;

public class PanelVente extends JPanel {
	
	private JPanel panel;
	private GestionClient card1;
	private GestionProduit card2;
	private GestionFacture card3;
	private GestionDevis card4;
	private PanelLigneDevis card5;
	private GestionBL card6;
	private PanelLigneBL card7;
	private GestionClient Gestionclient;
	private GestionProduit Gestionproduit;
	
	private String[] listContent = { "CARD_1", "CARD_2", "CARD_3", "CARD_4" ,"CARD_5","CARD_6","CARD_7" };
	private CardLayout myCard;
	public Vector<Ligne_BL> Vcp;
	public Vector<Ligne_devis> Vc;

	/**
	 * Create the panel.
	 */
	public PanelVente() {
		setBackground(new Color(211, 211, 211));
		setSize(1256, 774);
		setLayout(null);
		setVisible(true);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setOpaque(false);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 0, 1256, 75);
		add(panel_5);
		
	
		
		//JPanel GestionClient = new JPanel();
		JButton btnGestionClient = new JButton("CLIENT");
		btnGestionClient.setIcon(new ImageIcon(PanelVente.class.getResource("/image/business-man.png")));
		btnGestionClient.setOpaque(false);
		btnGestionClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard.show(panel, listContent[0]);
				
			}
		});
		btnGestionClient.setForeground(new Color(0, 128, 128));
		btnGestionClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionClient.setBounds(0, 0, 180, 73);
		panel_5.add(btnGestionClient);
		
		//JPanel GestionProduit = new JPanel();
		JButton btnGestionProduit = new JButton("PRODUIT");
		btnGestionProduit.setIcon(new ImageIcon(PanelVente.class.getResource("/image/produit.png")));
		btnGestionProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard.show(panel, listContent[1]);
			}
		});
		btnGestionProduit.setOpaque(false);
		btnGestionProduit.setForeground(new Color(0, 128, 128));
		btnGestionProduit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionProduit.setBounds(179, 0, 180, 73);
		panel_5.add(btnGestionProduit);
	
		
		JButton btnGestionFacture = new JButton("FACTURE");
		btnGestionFacture.setIcon(new ImageIcon(PanelVente.class.getResource("/image/bill (1).png")));
		btnGestionFacture.setOpaque(false);
		btnGestionFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard.show(panel, listContent[2]);
				
			}
		});
		btnGestionFacture.setForeground(new Color(0, 128, 128));
		btnGestionFacture.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionFacture.setBounds(357, 0, 180, 73);
		panel_5.add(btnGestionFacture);
		
	
		
		JButton btnGestionDevis = new JButton("DEVIS");
		btnGestionDevis.setIcon(new ImageIcon(PanelVente.class.getResource("/image/writing.png")));
		btnGestionDevis.setOpaque(false);
		btnGestionDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard.show(panel, listContent[3]);
				
			}
		});
		btnGestionDevis.setForeground(new Color(0, 128, 128));
		btnGestionDevis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionDevis.setBounds(536, 0, 180, 73);
		panel_5.add(btnGestionDevis);
		
		JButton btnLigneDevis = new JButton("LIGNE DEVIS");
		btnLigneDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myCard.show(panel, listContent[4]);
			}
		});
		btnLigneDevis.setIcon(new ImageIcon(PanelVente.class.getResource("/image/writing.png")));
		btnLigneDevis.setOpaque(false);
		btnLigneDevis.setForeground(new Color(0, 128, 128));
		btnLigneDevis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLigneDevis.setBounds(715, 0, 181, 73);
		panel_5.add(btnLigneDevis);
		
		
		
		JButton btnGestionBL = new JButton("BON LIVRAISON");
		btnGestionBL.setIcon(new ImageIcon(PanelVente.class.getResource("/image/livraison.png")));
		btnGestionBL.setOpaque(false);
		btnGestionBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard.show(panel, listContent[5]);
				
			}
		});
		btnGestionBL.setForeground(new Color(0, 128, 128));
		btnGestionBL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionBL.setBounds(897, 0, 197, 73);
		panel_5.add(btnGestionBL);
		
		JButton btnPanelLigneBL = new JButton("LIGNE BL");
		btnPanelLigneBL.setIcon(new ImageIcon(PanelVente.class.getResource("/image/add_32.png")));
		btnPanelLigneBL.setOpaque(false);
		btnPanelLigneBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard.show(panel, listContent[6]);
				
			}
		});
		btnPanelLigneBL.setForeground(new Color(0, 128, 128));
		btnPanelLigneBL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPanelLigneBL.setBounds(1093, 0, 163, 73);
		panel_5.add(btnPanelLigneBL);
		
		
		
		
		
		panel = new JPanel();
		panel.setBounds(10, 88, 1234, 673);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		myCard = new CardLayout(0, 0);
		panel.setLayout(myCard);
	
		
		card1 = new GestionClient();
		card1.setOpaque(false);
		card1.setBackground(Color.WHITE);
		card1.setBorder(null);
		card2 = new GestionProduit();
		card2.setOpaque(false);
		card3 = new GestionFacture();
		card3.setOpaque(false);
		card4 = new GestionDevis(Vc);
		card4.setOpaque(false);
		card5 = new PanelLigneDevis();
		card5.setOpaque(false);
		card6 = new GestionBL(Vcp);
		card6.setOpaque(false);
		card7 = new PanelLigneBL();
		card7.setOpaque(false);
		
		panel.add(card1, listContent[0]);
		panel.add(card2, listContent[1]);
		panel.add(card3, listContent[2]);
		panel.add(card4, listContent[3]);
		panel.add(card5, listContent[4]);
		panel.add(card6, listContent[5]);
		panel.add(card7, listContent[6]);

	}
}
