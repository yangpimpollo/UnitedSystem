/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - ventana general

*/
package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ViewWindow  extends JFrame implements ActionListener{
    
    private JMenuBar mb;
    private JMenu m1,m2,m3,m4,m5,m6;
    
    public ViewWindow(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setVisible(false);
        setVisible(false);
        setTitle("UnitedVanLines");
        setSize(900,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255)); 
        
        ImageIcon favicon = new ImageIcon("res/icon.png");
        setIconImage(favicon.getImage());
        
        mb = new JMenuBar();
        //mb.add(Box.createHorizontalGlue());
        
        m1 = new JMenu("estimar");mb.add(m1);
        m2 = new JMenu("registro");mb.add(m2);
        m3 = new JMenu("reserva");mb.add(m3);
        m4 = new JMenu("inventario");mb.add(m4);
        m5 = new JMenu("guia");mb.add(m5);
        m6 = new JMenu("factura");mb.add(m6);
        
        setJMenuBar(mb);
    }
    
    public void actionPerformed(ActionEvent e) {
    }
}
