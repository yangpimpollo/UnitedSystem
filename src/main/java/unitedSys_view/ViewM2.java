/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - subventana M2 de registro de cliente

*/
package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import unitedSys_controller.Controller_02;

public class ViewM2 extends JFrame implements ActionListener {
    
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;
    private JComboBox cb1;
    private JTextField tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    private JButton clear, save;
    private Controller_02 contro02 = new Controller_02();
    
    public void setTF2_ID(String arg){ tf2.setText(arg); };
    
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
        save = new JButton("save");
        save.setBounds(490, 320, 80,25);
        save.addActionListener(this);
        add(save);
    }
    
    private boolean dataValidate(){
        boolean validate=false;
        int doclength = tf2.getText().length();
        
        if(doclength == 0){
            JOptionPane.showMessageDialog(this, "doc ID es obligatorio","error", JOptionPane.ERROR_MESSAGE);
        }else if(tf3.getText().length()== 0){
            JOptionPane.showMessageDialog(this, "business name es obligatorio","error", JOptionPane.ERROR_MESSAGE);
        }else if(tf8.getText().length()== 0){
            JOptionPane.showMessageDialog(this, "phone es obligatorio","error", JOptionPane.ERROR_MESSAGE);
        }else{
            switch(cb1.getSelectedIndex()){
            case 0:{
                if(doclength==11){
                    validate=true;
                }else{
                    JOptionPane.showMessageDialog(this, "RUC incorrecto","RUC error", JOptionPane.ERROR_MESSAGE);
                }
            }break;
            case 1:{
                if(doclength==8){
                    validate=true;
                }else{
                    JOptionPane.showMessageDialog(this, "DNI incorrecto","DNI error", JOptionPane.ERROR_MESSAGE);
                }
            }break;
            case 2, 3:{
                if(doclength==12){
                    validate=true;
                }else{
                    JOptionPane.showMessageDialog(this, "DOC incorrecto","DNI error", JOptionPane.ERROR_MESSAGE);
                }
            }break;
            }
        }
        
        
        return validate;
    } 
    
    private void clear(){
        cb1.setSelectedIndex(0);
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        tf8.setText("");
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            String[] arg = {
                cb1.getSelectedItem().toString(),
                tf2.getText(),
                tf3.getText(),
                tf4.getText(),
                tf5.getText(),
                tf6.getText(),
                tf7.getText(),
                tf8.getText()
            };
                    
            if(dataValidate()){
//                for (int i = 0; i < arg.length; i++) {
//                    System.out.println(arg[i]);
//                }
                if(contro02.newCustomer(arg)){
                    
                    JOptionPane.showMessageDialog(this, "successful!","add customer", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    dispose();  
                }else{
                    JOptionPane.showMessageDialog(this, "please try again!","add customer error", JOptionPane.ERROR_MESSAGE);
                }             
            }
        }
        if(e.getSource() == clear){
            clear();
        }
    }
}
