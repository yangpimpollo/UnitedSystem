/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - subventana M2 de registro de cliente

*/
package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewM2 extends JFrame implements ActionListener {
    
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;
    private JComboBox cb1;
    private JTextField tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    private JButton clear, save;
    
    public ViewM2(){
        setLayout(null);
        //setDefaultCloseOperation(JFrame.);
        setUndecorated(false);
        setVisible(false);
        setResizable(false);
        setTitle("register new customer");
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255));
        ImageIcon favicon = new ImageIcon("res/white.png");
        setIconImage(favicon.getImage());
        createComponents1();
        createComponents2();
    }
    
    private void createComponents1(){
        lb1 = new JLabel("document type:", SwingConstants.RIGHT);
        lb1.setBounds(50,50,150,20);
        lb1.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb1.setForeground(new Color( 90, 90, 90));
        add(lb1);
        lb2 = new JLabel("document ID:", SwingConstants.RIGHT);
        lb2.setBounds(50,80,150,20);
        lb2.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb2.setForeground(new Color( 90, 90, 90));
        add(lb2);
        lb3 = new JLabel("business name:", SwingConstants.RIGHT);
        lb3.setBounds(50,110,150,20);
        lb3.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb3.setForeground(new Color( 90, 90, 90));
        add(lb3);
        lb4 = new JLabel("first name:", SwingConstants.RIGHT);
        lb4.setBounds(50,140,150,20);
        lb4.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb4.setForeground(new Color( 90, 90, 90));
        add(lb4);
        
        lb5 = new JLabel("last name:", SwingConstants.RIGHT);
        lb5.setBounds(50,170,150,20);
        lb5.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb5.setForeground(new Color( 90, 90, 90));
        add(lb5);
        lb6 = new JLabel("address:", SwingConstants.RIGHT);
        lb6.setBounds(50,200,150,20);
        lb6.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb6.setForeground(new Color( 90, 90, 90));
        add(lb6);
        lb7 = new JLabel("email:", SwingConstants.RIGHT);
        lb7.setBounds(50,230,150,20);
        lb7.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb7.setForeground(new Color( 90, 90, 90));
        add(lb7);
        lb8 = new JLabel("phone:", SwingConstants.RIGHT);
        lb8.setBounds(50,260,150,20);
        lb8.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb8.setForeground(new Color( 90, 90, 90));
        add(lb8);
    }
    
    private void createComponents2(){
        cb1 = new JComboBox(new String[]{ "RUC", "DNI", "CE", "passport"});
        cb1.setBounds(220, 50, 240,20);
        add(cb1);
        
        tf2 = new JTextField();
        tf2.setBounds(220, 80, 240,20);
        add(tf2);
        tf3 = new JTextField();
        tf3.setBounds(220, 110, 240,20);
        add(tf3);
        tf4 = new JTextField();
        tf4.setBounds(220, 140, 240,20);
        add(tf4);
        tf5 = new JTextField();
        tf5.setBounds(220, 170, 240,20);
        add(tf5);
        tf6 = new JTextField();
        tf6.setBounds(220, 200, 240,20);
        add(tf6);
        tf7 = new JTextField();
        tf7.setBounds(220, 230, 240,20);
        add(tf7);
        tf8 = new JTextField();
        tf8.setBounds(220, 260, 240,20);
        add(tf8);
        
        clear = new JButton("clear");
        clear.setBounds(400, 320, 80,25);
        clear.addActionListener(this);
        add(clear);
        save = new JButton("clear");
        save.setBounds(490, 320, 80,25);
        save.addActionListener(this);
        add(save);
    }
    
    public void actionPerformed(ActionEvent e) {
         
    }
}
