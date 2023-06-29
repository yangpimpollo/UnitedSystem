/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - subventana M3 para la resserva de Servicio

*/
package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.*;
import java.util.Calendar;
import java.util.Date;
import org.jdatepicker.*;
import org.jdatepicker.graphics.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import unitedSys_tools.DateLabelFormatter;
import unitedSys_view.ViewWindow;

import unitedSys_controller.Controller_03;
import unitedSys_controller.Controller_04;

public class ViewM3 extends JFrame implements ActionListener {

    private int seccionID;
    private JLabel lb1, lb2, lb3, lb4;
    private JTextField tf2, tf3, tf4;
    private JButton search, newC, clear, save;
    private ViewWindow viewWin;
    private JDatePickerImpl datePicker;
    private Controller_03 contro03 = new Controller_03();
    private Controller_04 contro04 = new Controller_04();
    
    public void setSeccion(int arg0, String arg1){ 
        this.seccionID = arg0;
        tf4.setText(arg1);
    }
             
    public ViewM3(ViewWindow arg) {
        this.viewWin = arg;
        setLayout(null);
        //setDefaultCloseOperation(JFrame.);
        setUndecorated(false);
        setVisible(false);
        setResizable(false);
        setTitle("service reservation");
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255));
        ImageIcon favicon = new ImageIcon("res/white.png");
        setIconImage(favicon.getImage());
        createComponents1();
    }
    
    private void createComponents1(){
        lb1 = new JLabel("date:", SwingConstants.RIGHT);
        lb1.setBounds(30,60,150,20);
        lb1.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb1.setForeground(new Color( 90, 90, 90));
        add(lb1);
        lb2 = new JLabel("customer ID:", SwingConstants.RIGHT);
        lb2.setBounds(30,100,150,20);
        lb2.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb2.setForeground(new Color( 90, 90, 90));
        add(lb2);
        lb3 = new JLabel("customer name:", SwingConstants.RIGHT);
        lb3.setBounds(30,140,150,20);
        lb3.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb3.setForeground(new Color( 90, 90, 90));
        add(lb3);
        lb4 = new JLabel("employee:", SwingConstants.RIGHT);
        lb4.setBounds(30,200,150,20);
        lb4.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        lb4.setForeground(new Color( 90, 90, 90));
        add(lb4);
        
        tf2 = new JTextField("");
        tf2.setBounds(200, 100, 200,25);
        add(tf2);
        tf3 = new JTextField();
        tf3.setBounds(200, 140, 200,25);
        tf3.setEditable(false);
        add(tf3);
        tf4 = new JTextField();
        tf4.setText(viewWin.getSeccionNamet());
        tf4.setEditable(false);
        tf4.setBounds(200, 200, 200,25);
        add(tf4);
        
        
        //----------------------------------------------------------------------------------
        UtilDateModel model = new UtilDateModel();
        //model.setDate(20,04,2014);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // Don't know about the formatter, but there it is...
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(200, 60, 200, 27);
        add(datePicker);
        //----------------------------------------------------------------
        
        Calendar calendar = Calendar.getInstance();
            //calendar.set(2023, Calendar.JULY, 1);
            datePicker.getModel().setDate(calendar.get(java.util.Calendar.YEAR),
                               calendar.get(Calendar.MONTH),
                               calendar.get(Calendar.DAY_OF_MONTH));

            // Update the view to reflect the new date
            datePicker.getModel().setSelected(true);
        
        //----------------------------------------------------------------
        
        search = new JButton("search");
        search.setBounds(410, 100, 80,25);
        search.addActionListener(this);
        add(search);
        newC = new JButton("new");
        newC.setBounds(410, 140, 80,25);
        newC.addActionListener(this);
        add(newC);
        clear = new JButton("clear");
        clear.setBounds(400, 320, 80,25);
        clear.addActionListener(this);
        add(clear);
        save = new JButton("save");
        save.setBounds(490, 320, 80,25);
        save.addActionListener(this);
        add(save);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            if(tf2.getText().length()>7){
                if(contro03.searchCustomer(tf2.getText())!=null){
                    tf3.setText(contro03.searchCustomer(tf2.getText()));
                }else{
                    tf3.setText("not found");
                }
                
            }else{
                System.out.println("******7777" );
                JOptionPane.showMessageDialog(this, "enter customer id!","error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        if(e.getSource() == newC){
            viewWin.setVisibleM2();
            viewWin.getVM2().setTF2_ID(tf2.getText());
        }
        
        if(e.getSource() == clear){
            tf2.setText("");
            tf3.setText("");
            Calendar calendar = Calendar.getInstance();
            //calendar.set(2023, Calendar.JULY, 1);
            datePicker.getModel().setDate(calendar.get(java.util.Calendar.YEAR),
                               calendar.get(Calendar.MONTH),
                               calendar.get(Calendar.DAY_OF_MONTH));

            // Update the view to reflect the new date
            datePicker.getModel().setSelected(true);
        }
        
        if(e.getSource() == save){
            Date selectedDate = (Date) datePicker.getModel().getValue();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");    //"MM/dd/yyyy HH:mm:ss"
            System.out.println("date"+df.format(selectedDate) );
            
            if(contro04.newOrder(Integer.toString(seccionID),tf2.getText(),df.format(selectedDate))){                  
                JOptionPane.showMessageDialog(this, "successful!","add Order", JOptionPane.INFORMATION_MESSAGE);
                //clear();
                dispose();  
            }else{
                JOptionPane.showMessageDialog(this, "please try again!","add Order error", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }
    
}
