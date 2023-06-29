/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - ventana del login

*/

package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import unitedSys_view.ViewWindow;
import unitedSys_controller.Controller_01;

public class ViewLogin extends JFrame implements ActionListener, KeyListener{
    
    private JLabel logo_lbl, test_lbl, user_lbl, pass_lbl;
    private JTextField user_field;
    private JPasswordField pass_field;
    private JButton signin_btn;
    private ViewWindow window = new ViewWindow();
    private Controller_01 contro01 = new Controller_01();
    
    public ViewLogin(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setVisible(false);
        setTitle("UnitedVanLines");
        setSize(440,560);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255)); 
        
        ImageIcon favicon = new ImageIcon("res/icon.png");
        setIconImage(favicon.getImage());
        
        ImageIcon imagen = new ImageIcon("res/logo_big.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(240, 126, 1));
        logo_lbl = new JLabel(icono);
        logo_lbl.setBounds(100,50,240,126);
        add(logo_lbl);
        
        test_lbl = new JLabel("Sign in to your move portal");
        test_lbl.setBounds(40,200,360,40);
        test_lbl.setFont(new Font("Arial Black", Font.BOLD, 23));
        test_lbl.setForeground(new Color( 0, 90, 171));
        add(test_lbl);
        
        user_lbl = new JLabel("username:");
        user_lbl.setBounds(60,270,360,40);
        user_lbl.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 12));
        user_lbl.setForeground(new Color( 90, 90, 90));
        add(user_lbl);
        
        pass_lbl = new JLabel("password:");
        pass_lbl.setBounds(60,330,360,40);
        pass_lbl.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 12));
        pass_lbl.setForeground(new Color( 90, 90, 90));
        pass_lbl.addKeyListener(this);
        add(pass_lbl);
        
        user_field = new JTextField();
        user_field.setBounds(40, 300, 360,40);
        add(user_field);
        
        pass_field = new JPasswordField();
        pass_field.setBounds(40, 360, 360,40);
        add(pass_field);
        
        signin_btn = new JButton("SIGN IN");
        signin_btn.setBounds(40, 420, 360,40);
        signin_btn.addActionListener(this);
        add(signin_btn);
        
        addKeyListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signin_btn){
            System.out.println("aaa" + pass_field.getText());
            contro01.accessAccount(user_field.getText(), pass_field.getText());
            
            if(contro01.getUser()!=null){
                window.setVisible(true);
                window.setSeccion(contro01.getUser().getId(),contro01.getUser().getName());
                System.out.println("---" +contro01.getUser().getId() );
                System.out.println("---" +contro01.getUser().getName() );
                dispose();
            }else{
               JOptionPane.showMessageDialog(this, "please try again!","sing in error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

    @Override public void keyTyped(KeyEvent e) {  }
    @Override public void keyPressed(KeyEvent e) { }
    @Override 
    public void keyReleased(KeyEvent e) {
    
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Acción al presionar Enter
            System.out.println("enter" );
            //signin_btn.doClick();
        }
    }
}
