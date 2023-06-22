/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - ventana general

*/
package unitedSys_view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import unitedSys_view.ViewM2;


public class ViewWindow  extends JFrame implements ActionListener,  MouseListener {
    
    private JMenuBar mb;
    private JMenu m1,m2,m3,m4,m5,m6;
    private JMenuItem mm2;
    private ViewM2 vm2 = new ViewM2();
    
    public ViewWindow(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setVisible(false);
        setResizable(false);
        setTitle("UnitedVanLines");
        setSize(900,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255)); 
        
        ImageIcon favicon = new ImageIcon("res/icon.png");
        setIconImage(favicon.getImage());
        
        mb = new JMenuBar();
        //mb.add(Box.createHorizontalGlue());
        
        m1 = new JMenu("estimar");
        m1.addMouseListener(this);
        mb.add(m1);
        
        m2 = new JMenu("registro");
        m2.addMouseListener(this);
//        mm2 = new JMenuItem("MenuItem2");
//        mm2.addActionListener(this);
//        m2.add(mm2);
        mb.add(m2);
        
        m3 = new JMenu("reserva");mb.add(m3);
        m4 = new JMenu("inventario");mb.add(m4);
        m5 = new JMenu("guia");mb.add(m5);
        m6 = new JMenu("factura");mb.add(m6);
        
        //mb.addActionListener(this);
        setJMenuBar(mb);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mm2){
             System.out.println("registro" );
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == m2){
            vm2.setVisible(true);
        }
    }

    @Override  public void mousePressed(MouseEvent e) { }
    @Override public void mouseReleased(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e) { }
}
