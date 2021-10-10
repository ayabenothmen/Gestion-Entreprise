package View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;

 
import Connexion.Requettes;
import Connexion.connexion;

 

public class StockAlert extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

 

    /**
     * Create the dialog.
     */
    public StockAlert() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        		StockAlert.class.getResource("/image/lib.png")));
        setAlwaysOnTop(true);
        setTitle("Stock epuisee");
        this.setSize(528, 336);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    close();
                }
            });
            okButton.setIcon(new ImageIcon(StockAlert.class
                    .getResource("/image/ok.png")));
            okButton.setBounds(218, 253, 82, 23);
            contentPanel.add(okButton);
            okButton.setActionCommand("OK");
            getRootPane().setDefaultButton(okButton);
        }

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(10, 62, 488, 191);
        contentPanel.add(panel);
        panel.setLayout(null);
        panel.setLayout(new BorderLayout());
        
         
        
                JLabel label = new JLabel("");
                panel.add(label, BorderLayout.WEST);
                label.setIcon(new ImageIcon(StockAlert.class
                        .getResource("/image/alert.png")));
                
                JLabel lblVousDevezAjouter = new JLabel("       Vous devez ajouter des produits ");
                lblVousDevezAjouter.setForeground(Color.BLACK);
                lblVousDevezAjouter.setFont(new Font("Calibri", Font.BOLD, 18));
                panel.add(lblVousDevezAjouter, BorderLayout.CENTER);

 

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(StockAlert.class
                .getResource("/image/bg-body.jpg")));
        lblNewLabel_1.setBounds(0, 0, 510, 298);
        contentPanel.add(lblNewLabel_1);
    }
    
    /*public void updateTable(String sql) {
        
        ResultSet rs = ConnectionDB.find_rs(Requettes.stock_select(sql));
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }*/

 

    // update table
    /*public void updateTable() {
        ResultSet rs =Reque ; 
                //Requettes.find_rs(Requettes.stock_select(sql));
        table.setModel((DbUtils.resultSetToTableModel(rs)));*/
    
    public void close() {
        this.setVisible(false);
    }
}
