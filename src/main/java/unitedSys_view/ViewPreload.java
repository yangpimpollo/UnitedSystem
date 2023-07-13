/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

clase de precarga del sistema

*/
package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import unitedSys_view.ViewLogin;

public class ViewPreload extends JFrame implements Runnable{
    
    int x = 0;
    int y = 0;
    int m = 0;
    
    private Image dbImage;
    private Graphics dbg0;
    private ViewLogin login = new ViewLogin();
    
    public ViewPreload(){
        create();
        Thread hilo1 = new Thread(this);
        hilo1.start();
    }
    
    public void create(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        setTitle("UnitedVanLines");
        setSize(500,300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255)); 
        
        ImageIcon favicon = new ImageIcon("res/icon.png");
        setIconImage(favicon.getImage());
    }
    private void update(){
        if(x<=500){
            x+=500;        // x=100;
            y=x/5;
            repaint();

            m = (y<=45)? 20 : 255;
            pausa(20);
        }else{
            pausa(3);   // 3000
            x = -50;
            System.out.println("de nuevo");
            login.setVisible(true);
            dispose();
        }
    }
    /////////////////////////////////////////////////////////////
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg0 = dbImage.getGraphics();
        paintComponent(dbg0);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g){
        super.paint(g);
        Graphics2D midibujo = (Graphics2D) g;
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage ("res/back.png");
        midibujo.drawImage(imagen, 0, 0, 500, 300, this);

        midibujo.setColor(new Color(55, 72, 184));
        midibujo.setFont(new Font("Andale Mono", 3, 10));
        midibujo.drawString("let { b>=(1/n)Σ(n;i=1) xi; I+=b; }", 345, 20);
        
        midibujo.setColor(new Color(55, 72, 184));
        midibujo.fillRect(0, 285, x, 3);

        midibujo.setColor(new Color(55, 72, 184));
        midibujo.setFont(new Font("Andale Mono", 3, 10));
        midibujo.drawString("Loading... "+y+"%", 10, 280);

    }
    
    @Override
    public void run(){ while(x>=0){ update(); } }
    
    public void pausa(int mlseg){
        try { Thread.sleep(mlseg);
        } catch (Exception e) { }
    }
}
