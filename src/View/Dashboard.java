package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import View.PanelEntreprise;
import View.PanelVente;
import View.PanelAchat;
import View.Authentification;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private PanelEntreprise panelEntreprise;
	private PanelVente panelVente;
	private PanelAchat panelAchat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Authentification.class.getResource("/image/employee (1).png")));
	    setBackground(SystemColor.activeCaptionBorder);
	    setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1600, 800);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(47, 79, 79));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panelEntreprise = new PanelEntreprise();
        panelEntreprise.setBounds(0, 0, 1256, 774);
        panelVente = new PanelVente();
        panelVente.setBounds(0, 0, 1256, 774);
        panelAchat = new PanelAchat();
        panelAchat.setBounds(0, 0, 1256, 774);
        
        
        JPanel panMenu = new JPanel();
        panMenu.setBounds(0, 13, 320, 774);
        panMenu.setBackground(new Color(0, 139, 139));
        contentPane.add(panMenu);
        panMenu.setLayout(null);
        
        JLabel lblcon = new JLabel("");
        lblcon.setIcon(new ImageIcon(Dashboard.class.getResource("/image/bank.png")));
        lblcon.setBounds(88, 51, 142, 134);
        panMenu.add(lblcon);
        
        JPanel paneEntrep = new JPanel();
        paneEntrep.addMouseListener(new PanelButtonMouseAdapter(paneEntrep) {
        	   @Override
               public void mouseClicked(MouseEvent e) {
                   menuClicked(paneEntrep);
                   panelEntreprise.setVisible(true);
               }
              
           });
        paneEntrep.setBackground(new Color(0, 128, 128));
        paneEntrep.setBounds(0, 292, 320, 65);
        panMenu.add(paneEntrep);
        paneEntrep.setLayout(null);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setBounds(55, 15, 0, 0);
        paneEntrep.add(lblNewLabel_1_1);
        
        JLabel lblGestionEntreprise = new JLabel("GESTION ENTREPRISE");
        lblGestionEntreprise.setBounds(97, 15, 211, 32);
        lblGestionEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
        lblGestionEntreprise.setForeground(Color.WHITE);
        lblGestionEntreprise.setFont(new Font("Dialog", Font.BOLD, 16));
        paneEntrep.add(lblGestionEntreprise);
        
        JLabel llblGestionEn = new JLabel("");
        llblGestionEn.setIcon(new ImageIcon(Dashboard.class.getResource("/image/office.png")));
        llblGestionEn.setBounds(46, 0, 57, 65);
        paneEntrep.add(llblGestionEn);
        
        JPanel paneVente = new JPanel();
        paneVente.addMouseListener(new PanelButtonMouseAdapter(paneVente) {
     	   @Override
           public void mouseClicked(MouseEvent e) {
               menuClicked(paneVente);
               panelVente.setVisible(true);
           }
          
       });
        paneVente.setBackground(new Color(0, 128, 128));
        paneVente.setBounds(0, 360, 320, 65);
        panMenu.add(paneVente);
        paneVente.setLayout(null);
        
        JLabel lblGestionVente = new JLabel("GESTION VENTE");
        lblGestionVente.setBounds(97, 13, 182, 32);
        lblGestionVente.setHorizontalAlignment(SwingConstants.CENTER);
        lblGestionVente.setForeground(Color.WHITE);
        lblGestionVente.setFont(new Font("Dialog", Font.BOLD, 16));
        paneVente.add(lblGestionVente);
        
        JLabel lblGestionVe = new JLabel("");
        lblGestionVe.setIcon(new ImageIcon(Dashboard.class.getResource("/image/vente.png")));
        lblGestionVe.setBounds(41, 0, 65, 65);
        paneVente.add(lblGestionVe);
        
        JPanel paneAchat = new JPanel();
        paneAchat.addMouseListener(new PanelButtonMouseAdapter(paneAchat) {
     	   @Override
           public void mouseClicked(MouseEvent e) {
               menuClicked(paneAchat);
               panelAchat.setVisible(true);
           }
          
       });
        paneAchat.setBackground(new Color(0, 128, 128));
        paneAchat.setBounds(0, 427, 320, 65);
        panMenu.add(paneAchat);
        paneAchat.setLayout(null);
        
        JLabel lblGestionAchet = new JLabel("GESTION ACHAT");
        lblGestionAchet.setBounds(97, 13, 190, 32);
        lblGestionAchet.setHorizontalAlignment(SwingConstants.CENTER);
        lblGestionAchet.setForeground(Color.WHITE);
        lblGestionAchet.setFont(new Font("Dialog", Font.BOLD, 16));
        paneAchat.add(lblGestionAchet);
        
        JLabel lblGestionAch = new JLabel("");
        lblGestionAch.setIcon(new ImageIcon(Dashboard.class.getResource("/image/achat.png")));
        lblGestionAch.setBounds(48, 0, 65, 65);
        paneAchat.add(lblGestionAch);
        
        JPanel paneSignout = new JPanel();
        paneSignout.addMouseListener(new PanelButtonMouseAdapter(paneSignout) {
     	   @Override
           public void mouseClicked(MouseEvent e) {
     		   if(JOptionPane.showConfirmDialog(null, "vous voulez vraiment quiter ?") ==0) {
     			   Dashboard.this.dispose();
     			   Authentification login = new Authentification();
     			   login.setVisible(true);
     			   
     			   
     		   }
           }
          
       });
        paneSignout.setBackground(new Color(0, 128, 128));
        paneSignout.setBounds(0, 494, 320, 65);
        panMenu.add(paneSignout);
        paneSignout.setLayout(null);
        
        JLabel lblSignOut = new JLabel("SIGN OUT");
        lblSignOut.setBounds(138, 13, 126, 32);
        lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
        lblSignOut.setForeground(Color.WHITE);
        lblSignOut.setFont(new Font("Dialog", Font.BOLD, 16));
        paneSignout.add(lblSignOut);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/image/logout.png")));
        lblNewLabel_3.setBounds(49, 0, 65, 65);
        paneSignout.add(lblNewLabel_3);
        
        JLabel lblExit = new JLabel("X");
        lblExit.setHorizontalAlignment(SwingConstants.CENTER);
        lblExit.setForeground(Color.WHITE);
        lblExit.setFont(new Font("Comic Sans MS", Font.BOLD,14));
        lblExit.setBounds(1580, 0, 20, 20);
        lblExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment fermer cette application? ","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
                	Dashboard.this.dispose();
                }
            }
            @Override
            public void mouseEntered(MouseEvent arg0) {
                lblExit.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent arg0) {
                lblExit.setForeground(Color.WHITE);
            }
        });
        contentPane.add(lblExit);
        
        JPanel panelMain = new JPanel();
        panelMain.setBounds(332, 13, 1256, 774);
        contentPane.add(panelMain);
        
        panelMain.setLayout(null);
        
        panelMain.add(panelEntreprise);
        panelMain.add(panelVente);
        panelMain.add(panelAchat);
        
        panelEntreprise.setVisible(true);
	}
	
	public void menuClicked(JPanel panel) {
		
		panelEntreprise.setVisible(false);
	    panelVente.setVisible(false);
		panelAchat.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
        JPanel panel;
        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color (112,128,144));
           
        }
        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color (47,79,79));
        }
        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color (60,179,113));
           
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color (112,128,144));
           
        }
    }
}
