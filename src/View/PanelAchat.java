package View;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Model.Ligne_BL;
import Model.Ligne_BR;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import View.Dashboard;
import javax.swing.ImageIcon;

public class PanelAchat extends JPanel {
	private JPanel panel_1;
	private GestionFournisseur card6;
	private ProduitAchat card7;
	private FactureAchat card8;
	private GestionBR card9;
	private PanelLigneBR card10;
	public Vector<Ligne_BR> Vcp;

	
	private String[] listContent = { "CARD_1", "CARD_2", "CARD_3", "CARD_4", "CARD_5" };
	private CardLayout myCard_1;


	/**
	 * Create the panel.
	 */
	public PanelAchat() {
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
		
	
		
	
		JButton btnGestionFournisseur = new JButton("FOURNISSEUR");
		btnGestionFournisseur.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/bussiness-man.png")));
		btnGestionFournisseur.setOpaque(false);
		btnGestionFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard_1.show(panel_1, listContent[0]);
				
			}
		});
		btnGestionFournisseur.setForeground(new Color(0, 128, 128));
		btnGestionFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionFournisseur.setBounds(0, 0, 250, 73);
		panel_5.add(btnGestionFournisseur);
		

		JButton btnProduitAchat = new JButton("PRODUIT");
		btnProduitAchat.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/produit.png")));
		btnProduitAchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard_1.show(panel_1, listContent[1]);
			}
		});
		btnProduitAchat.setOpaque(false);
		btnProduitAchat.setForeground(new Color(0, 128, 128));
		btnProduitAchat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProduitAchat.setBounds(250, 0, 250, 73);
		panel_5.add(btnProduitAchat);
	
		
		JButton btnFactureAchat = new JButton("FACTURE");
		btnFactureAchat.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/bill (1).png")));
		btnFactureAchat.setOpaque(false);
		btnFactureAchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard_1.show(panel_1, listContent[2]);
				
			}
		});
		btnFactureAchat.setForeground(new Color(0, 128, 128));
		btnFactureAchat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFactureAchat.setBounds(500, 0, 250, 73);
		panel_5.add(btnFactureAchat);
		
		
		
		JButton btnGestionBR = new JButton("BON RECEPTION");
		btnGestionBR.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/livraison.png")));
		btnGestionBR.setOpaque(false);
		btnGestionBR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard_1.show(panel_1, listContent[3]);
				
			}
		});
		btnGestionBR.setForeground(new Color(0, 128, 128));
		btnGestionBR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionBR.setBounds(751, 0, 250, 73);
		panel_5.add(btnGestionBR);
		
		JButton btnPanelLigneBR = new JButton("LIGNE BR");
		btnPanelLigneBR.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/add_32.png")));
		btnPanelLigneBR.setOpaque(false);
		btnPanelLigneBR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCard_1.show(panel_1, listContent[4]);
				
			}
		});
		btnPanelLigneBR.setForeground(new Color(0, 128, 128));
		btnPanelLigneBR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPanelLigneBR.setBounds(1001, 0, 255, 73);
		panel_5.add(btnPanelLigneBR);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(322, 13, 56, 16);
		panel_5.add(lblNewLabel);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 1234, 673);
		add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		myCard_1 = new CardLayout(0, 0);
		panel_1.setLayout(myCard_1);
	
		
		card6 = new GestionFournisseur();
		card6.setOpaque(false);
		card6.setBackground(Color.WHITE);
		card6.setBorder(null);
		card7 = new ProduitAchat();
		card7.setOpaque(false);
		card8 = new FactureAchat();
		card8.setOpaque(false);
		card9 = new GestionBR(Vcp);
		card9.setOpaque(false);
		card10 = new PanelLigneBR();
		card10.setOpaque(false);
		
		panel_1.add(card6, listContent[0]);
		panel_1.add(card7, listContent[1]);
		panel_1.add(card8, listContent[2]);
		panel_1.add(card9, listContent[3]);
		panel_1.add(card10, listContent[4]);

	}
}
