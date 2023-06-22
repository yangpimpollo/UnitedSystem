
package unitedSys_view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements MouseListener  {
    
  private Color T1 = new Color(245,0,0);
  private Color T2 = new Color(0,0,245);
  private Color TN = T1;
  
  Random rnd = new Random();
  @Override/*from   ww w. java 2 s . co m*/
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    Graphics2D g2d = (Graphics2D) g;
    g2d.setBackground(Color.WHITE);
    g2d.clearRect(0, 0, getParent().getWidth(), getParent().getHeight());
    // antialising
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    RoundRectangle2D roundRect = new RoundRectangle2D.Float(50, 50, 100, 70, 20, 20); 
    //g2d.setPaint(Color.BLACK);
    //g2d.draw(roundRect);
    g2d.setColor(TN);
    g2d.fill(roundRect);
    
    
  }
  ////////////////////////////////////////////////////////////////
    @Override
    public void mouseEntered(MouseEvent e) {
       TN=T2; repaint();
System.out.println("entro al area");
    }
    @Override
    public void mouseExited(MouseEvent e) {
System.out.println("salio del area");
      TN=T1;repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//se llama cuando has dejado de presionar el boton del mouse.
    } 
    @Override
    public void mousePressed(MouseEvent e) {
//se llama cuando se mantiene presionado el boton.
    }
    @Override
    public void mouseClicked(MouseEvent e) {
  //se invoca cuando presionas y dejas de presionar el boton sin mover el cursor.
    }

  public static void main(String[] args) {
    // create frame for Main
    JFrame frame = new JFrame("java2s.com");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Main Main = new Main();
    frame.add(Main);
    frame.setSize(300, 210);
    frame.setVisible(true);
  }
}