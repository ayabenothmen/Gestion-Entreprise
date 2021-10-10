package View;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class GestionFacture extends JPanel {
	
	
	private JPanel panel_facture;
	private PanelFactureClient card1;
	private PanelFactureAvoir card2;
	private String[] listContent = { "CARD_1", "CARD_2" };
	private CardLayout cl_panel_facture;

	/**
	 * Create the panel.
	 */
	public GestionFacture() {
		setBackground(new Color(211, 211, 211));
		setSize(1234, 673);
		setLayout(null);
		setVisible(true);
		
		JPanel panel_client = new JPanel();
		panel_client.setLayout(null);
		panel_client.setOpaque(false);
		panel_client.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_client.setBackground(Color.WHITE);
		panel_client.setBounds(387, 0, 502, 75);
		add(panel_client);
		
		JButton btnFactureClient = new JButton("Facture Client");
		btnFactureClient.setIcon(new ImageIcon(GestionFacture.class.getResource("/image/add_32.png")));
		btnFactureClient.setOpaque(false);
		btnFactureClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_panel_facture.show(panel_facture, listContent[0]);
				
			}
		});
		btnFactureClient.setForeground(new Color(0, 128, 128));
		btnFactureClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFactureClient.setBounds(0, 0, 252, 73);
		panel_client.add(btnFactureClient);
		
		JButton btnFactureAvoir = new JButton("Facture Avoir");
		btnFactureAvoir.setIcon(new ImageIcon(GestionFacture.class.getResource("/image/add_32.png")));
		btnFactureAvoir.setOpaque(false);
		btnFactureAvoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_panel_facture.show(panel_facture, listContent[1]);
				
			}
		});
		btnFactureAvoir.setForeground(new Color(0, 128, 128));
		btnFactureAvoir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFactureAvoir.setBounds(252, 0, 250, 73);
		panel_client.add(btnFactureAvoir);
		
		panel_facture = new JPanel();
		panel_facture.setBounds(10, 88, 1234, 673);
		add(panel_facture);
		panel_facture.setLayout(new CardLayout(0, 0));
		
		cl_panel_facture = new CardLayout(0, 0);
		panel_facture.setLayout(cl_panel_facture);
	
		
		card1 = new PanelFactureClient();
		card1.setOpaque(false);
		card1.setBackground(Color.WHITE);
		card1.setBorder(null);
		card2 = new PanelFactureAvoir();
		card2.setOpaque(false);
		
		panel_facture.add(card1, listContent[0]);
		panel_facture.add(card2, listContent[1]);



	}
}
