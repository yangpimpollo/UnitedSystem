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
    }
    
    public void actionPerformed(ActionEvent e) {
         
    }
}
