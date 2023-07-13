/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - subventana M5 para la descarga de las guias

*/


package unitedSys_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import unitedSys_service.Service_08;
import unitedSys_service.Service_06;
import unitedSys_tools.DateLabelFormatter;

public class ViewM5 extends JFrame implements ActionListener {

    private JButton search, clear, save;
    private JLabel lb1;
    private String orderName;
    private JDatePickerImpl datePicker;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    Service_08 service8 = new Service_08();
    Service_06 service = new Service_06();
    
    public ViewM5(){
        setLayout(null);
        //setDefaultCloseOperation(JFrame.);
        setUndecorated(false);
        setVisible(false);
        setResizable(false);
        setTitle("guide of movements");
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255));
        ImageIcon favicon = new ImageIcon("res/white.png");
        setIconImage(favicon.getImage());
        createComponents1();
    }
    
    private void createComponents1(){
        clear = new JButton("clear");
        clear.setBounds(400, 320, 80,25);
        clear.addActionListener(this);
        add(clear);
        save = new JButton("download");
        save.setBounds(485, 320, 90,25);
        save.addActionListener(this);
        add(save);
        
        lb1 = new JLabel("00000000");
        lb1.setBounds(20,140,250,20);
        lb1.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
        lb1.setForeground(new Color( 90, 90, 90));
        add(lb1);
        
        search = new JButton("search");
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
            tableModel.setRowCount(0);
            lb1.setText("00000000");
        }
        
        if(e.getSource() == save){
            try {
                if(service8.generateReport(orderName)){
                    
                    JOptionPane.showMessageDialog(this, "successful!","download report", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    openfile();
                }else{
                    JOptionPane.showMessageDialog(this, "please try again!","download report error", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ViewM5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void createTable() {
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
    
    private void openfile() throws IOException{
        String excelFilePath = "report_" + orderName + ".xlsx";
        
        Desktop desktop = Desktop.getDesktop();
        File excelFile = new File(excelFilePath);
        
        desktop.open(excelFile);
    }
    
}
