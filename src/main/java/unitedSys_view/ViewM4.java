/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - subventana M4 para el inventariado 

*/
package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import unitedSys_tools.DateLabelFormatter;

import unitedSys_service.Service_06;
import unitedSys_service.service_07;

public class ViewM4 extends JFrame implements ActionListener {

    private JButton search, clear, save;
    private String orderName;
    private JLabel lb1, tl1, tl2, tl3;
    private JTextField tf1, tf2, tf3;
    private JDatePickerImpl datePicker;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    Service_06 service = new Service_06();
    service_07 service7 = new service_07();
    
    public ViewM4(){
        setLayout(null);
        //setDefaultCloseOperation(JFrame.);
        setUndecorated(false);
        setVisible(false);
        setResizable(false);
        setTitle("products inventory");
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255));
        ImageIcon favicon = new ImageIcon("res/white.png");
        setIconImage(favicon.getImage());
        createComponents1();
    }
    
    private void createComponents1(){
        tl1 = new JLabel("categoria:", SwingConstants.RIGHT);
        tl1.setBounds(30,200,80,20);
        tl1.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        tl1.setForeground(new Color( 90, 90, 90));
        add(tl1);
        tl2 = new JLabel("objeto:", SwingConstants.RIGHT);
        tl2.setBounds(30,230,80,20);
        tl2.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        tl2.setForeground(new Color( 90, 90, 90));
        add(tl2);
        tl3 = new JLabel("detalles:", SwingConstants.RIGHT);
        tl3.setBounds(30,260,80,20);
        tl3.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        tl3.setForeground(new Color( 90, 90, 90));
        add(tl3);
        
        tf1 = new JTextField();
        tf1.setBounds(120, 200, 240,23);
        add(tf1);
        tf2 = new JTextField();
        tf2.setBounds(120, 230, 240,23);
        add(tf2);
        tf3 = new JTextField();
        tf3.setBounds(120, 260, 240,23);
        add(tf3);
        
        
        clear = new JButton("clear");
        clear.setBackground(new Color(2, 101, 250));
        clear.setForeground(Color.WHITE);
        clear.setBorderPainted(false);
        clear.setBounds(400, 320, 80,25);
        clear.addActionListener(this);
        add(clear);
        save = new JButton("add Item");
        save.setBackground(new Color(2, 101, 250));
        save.setForeground(Color.WHITE);
        save.setBorderPainted(false);
        save.setBounds(485, 320, 90,25);
        save.addActionListener(this);
        add(save);
        
        lb1 = new JLabel("00000000");
        lb1.setBounds(20,140,250,20);
        lb1.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
        lb1.setForeground(new Color( 90, 90, 90));
        add(lb1);
        
        search = new JButton("search");
        search.setBackground(new Color(2, 101, 250));
        search.setForeground(Color.WHITE);
        search.setBorderPainted(false);
        search.setBounds(230, 20, 80,27);
        search.addActionListener(this);
        add(search);
        
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
        datePicker.setBounds(20, 20, 200, 27);
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
        createTable();
        //----------------------------------------------------------------
    }
    
    public void createTable(){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("order");
        tableModel.addColumn("customer");

        resultTable = new JTable(tableModel);
        
        
        // Agregar la tabla a un panel con scroll
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(20, 55, 560, 80);
        
        // Agregar el panel al marco
        add(scrollPane);
        
        //----------------------------------------------------------------
        resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Solo realizar la acción cuando la selección haya terminado
                    int selectedRow = resultTable.getSelectedRow();
                    int selectedColumn = resultTable.getSelectedColumn();
                    
                    if (selectedRow != -1 && selectedColumn != -1) {
                        Object selectedValue = resultTable.getValueAt(selectedRow, selectedColumn);
                        System.out.println("Elemento seleccionado: " + selectedValue);
                        
                        orderName = resultTable.getValueAt(selectedRow, 0).toString();
                        lb1.setText(orderName);
                    }
                }
            }
        });
    }
    
    private void clear(){
        tableModel.setRowCount(0);
        lb1.setText("00000000");
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            Date selectedDate = (Date) datePicker.getModel().getValue();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");    //"MM/dd/yyyy HH:mm:ss"
            System.out.println("date"+df.format(selectedDate) );
            
            tableModel.setRowCount(0);
            ArrayList<Object[]> data = service.searchObjects(df.format(selectedDate));
            
            for (int i=0; i<data.size(); i++) {
                tableModel.addRow(data.get(i));
            }
        }
        
        if(e.getSource() == clear){
            clear();
        }
        
        if(e.getSource() == save){
            
            if(service7.addItemService(orderName, tf1.getText(), tf2.getText(), tf3.getText())){
                JOptionPane.showMessageDialog(this, "successful!","add item", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "please try again!","add item error", JOptionPane.ERROR_MESSAGE);
            }
            
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }
    }
    
}
