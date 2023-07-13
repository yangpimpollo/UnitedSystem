/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

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
        welcom1.setText("Hello " + seccionNamet);
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
    
    private JLabel welcom1, welcom2, welcom3;
    
    private JLabel imageLabel;
    private Timer timer;
    private int currentIndex;
    private String[] imagePaths = {
            "res/image1.png",
            "res/image2.png",
            "res/image3.png",
            "res/image4.png"
    };
    
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
        //add(seccionName);
        
        //--------------------------------------------------------
        welcom1 = new JLabel();
        welcom1.setText("Hello " + seccionNamet);
        welcom1.setBounds(80,70,400,40);
        welcom1.setFont(new Font("Arial Black", Font.BOLD, 23));
        welcom1.setForeground(new Color( 0, 90, 171));
        add(welcom1);
        
        welcom2 = new JLabel();
        welcom2.setText("que hay de nuevo ?");
        welcom2.setBounds(50,120,550,45);
        welcom2.setFont(new Font("Arial Black", Font.BOLD, 38));
        welcom2.setForeground(new Color( 4, 4, 61));
        add(welcom2);
        
        welcom3 = new JLabel();
        welcom3.setText("que tenga una buena jornada !");
        welcom3.setBounds(80,160,400,40);
        welcom3.setFont(new Font("Arial Black", Font.BOLD, 15));
        welcom3.setForeground(new Color( 80, 80, 110));
        add(welcom3);
        //---------------------------------------------------------
        
        imageLabel = new JLabel();
        imageLabel.setBounds(40, 250, 800, 250);
        //imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel);//, BorderLayout.CENTER);

        currentIndex = 0;
        showImage();

        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % imagePaths.length;
                showImage();
            }
        });
        timer.start();
    }
    
    private void showImage() {
        ImageIcon imageIcon = new ImageIcon(imagePaths[currentIndex]);
        Image image = imageIcon.getImage().getScaledInstance(800, 250, Image.SCALE_DEFAULT);
        imageLabel.setIcon(new ImageIcon(image));
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
