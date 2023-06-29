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

import unitedSys_view.ViewM1;
import unitedSys_view.ViewM2;
import unitedSys_view.ViewM3;
import unitedSys_view.ViewM4;
import unitedSys_view.ViewM5;
import unitedSys_view.ViewM6;


public class ViewWindow  extends JFrame implements ActionListener,  MouseListener {
    
    private int seccionID;
    private String seccionNamet;
    public String getSeccionNamet() { return seccionNamet; };
    public void setSeccion(int arg0, String arg1){ 
        this.seccionID=arg0;
        this.seccionNamet=arg1; 
        seccionName.setText(seccionNamet);
        vm3.setSeccion(arg0, arg1);
    };
    
    private JMenuBar mb;
    private JMenu m1,m2,m3,m4,m5,m6;
    private JMenuItem mm2;
    private JLabel seccionName;
    private ViewM1 vm1 = new ViewM1();
    private ViewM2 vm2 = new ViewM2();
    private ViewM3 vm3 = new ViewM3(this);
    private ViewM4 vm4 = new ViewM4();
    private ViewM5 vm5 = new ViewM5();
    private ViewM6 vm6 = new ViewM6();
    
    public void setVisibleM2(){ vm2.setVisible(true); };
    public ViewM2 getVM2(){ return vm2; };
    
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
        
        m1 = new JMenu("estimar");
        m1.addMouseListener(this);
        mb.add(m1);
        
        m2 = new JMenu("registro");
        m2.addMouseListener(this);
        mb.add(m2);
        
        m3 = new JMenu("reserva");
        m3.addMouseListener(this);
        mb.add(m3);
        
        m4 = new JMenu("inventario");
        m4.addMouseListener(this);
        mb.add(m4);
        
        m5 = new JMenu("guia");
        m5.addMouseListener(this);
        mb.add(m5);
        
        m6 = new JMenu("factura");
        m6.addMouseListener(this);
        mb.add(m6);
        
        //mb.addActionListener(this);
        setJMenuBar(mb);
        
        seccionName = new JLabel();
        seccionName.setText(seccionNamet);
        seccionName.setBounds(700,10,360,40);
        seccionName.setFont(new Font("Arial Black", Font.BOLD, 23));
        seccionName.setForeground(new Color( 0, 90, 171));
        add(seccionName);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mm2){
             System.out.println("registro" );
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == m1){ vm1.setVisible(true); }
        if(e.getSource() == m2){ vm2.setVisible(true); }
        if(e.getSource() == m3){ vm3.setVisible(true); }
        if(e.getSource() == m4){ vm4.setVisible(true); }
        if(e.getSource() == m5){ vm5.setVisible(true); }
        if(e.getSource() == m6){ vm6.setVisible(true); }
    }

    @Override  public void mousePressed(MouseEvent e) { }
    @Override public void mouseReleased(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e) { }
}
