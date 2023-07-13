/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - subventana M1 para la cotización

*/
package unitedSys_view;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import unitedSys_service.Service_05;
 
public class ViewM1 extends JFrame implements ActionListener {

    private JTextField searchField;
    private JButton searchButton;
    private JLabel lb1;
    private JTable resultTable, resultTable2;
    private DefaultTableModel tableModel, tableModel2;
    Service_05 service = new Service_05();
    
    public ViewM1(){
        setLayout(null);
        //setDefaultCloseOperation(JFrame.);
        setUndecorated(false);
        setVisible(false);
        setResizable(false);
        setTitle("service quote");
        setSize(600,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color( 255, 255, 255));
        ImageIcon favicon = new ImageIcon("res/white.png");
        setIconImage(favicon.getImage());
        createComponents1();
    }
    
    private void createComponents1(){
        lb1 = new JLabel("S/. 0.00", SwingConstants.RIGHT);
        lb1.setBounds(300,20,250,20);
        lb1.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
        lb1.setForeground(new Color( 90, 90, 90));
        add(lb1);
        
        searchField = new JTextField();
        searchField.setBounds(10, 30, 200,20);
        add(searchField);
        
        searchButton = new JButton("search");
        searchButton.setBounds(212, 30, 80,20);
        searchButton.addActionListener(this);
        add(searchButton);
        createTable1();
        createTable2();  
        searchFieldEvent();
    }
    
    private void createTable1(){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("service");
        tableModel.addColumn("price");

        resultTable = new JTable(tableModel);
        
        
        // Agregar la tabla a un panel con scroll
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(10, 55, 280, 200);
        
        // Agregar el panel al marco
        add(scrollPane);
        
        // Agregar un ListSelectionListener al JTable
        resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Solo realizar la acción cuando la selección haya terminado
                    int selectedRow = resultTable.getSelectedRow();
                    int selectedColumn = resultTable.getSelectedColumn();
                    
                    if (selectedRow != -1 && selectedColumn != -1) {
                        Object selectedValue = resultTable.getValueAt(selectedRow, selectedColumn);
                        System.out.println("Elemento seleccionado: " + selectedValue);
                        Object name = resultTable.getValueAt(selectedRow, 0);
                        Object price = resultTable.getValueAt(selectedRow, 1);
                        
                        tableModel2.addRow(new Object[]{name,"1",price,"0.0",price,"X"});
                    }
                }
            }
        });
    }
    
    private void createTable2(){
        String[] columnNames = {"servicio", "cantidad", "precio unitario", "descuento", "precio"};
        
        tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("servicio");
        tableModel2.addColumn("cantidad");
        tableModel2.addColumn("precio unitario");
        tableModel2.addColumn("descuento");
        tableModel2.addColumn("precio");
        tableModel2.addColumn("borrar");

        resultTable2 = new JTable(tableModel2);
        
        // Agregar la tabla a un panel con scroll
        JScrollPane scrollPane2 = new JScrollPane(resultTable2);
        scrollPane2.setBounds(300, 55, 280, 200);
        
        // Agregar el panel al marco
        add(scrollPane2);
        
        // Agregar un ListSelectionListener al JTable
        resultTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Solo realizar la acción cuando la selección haya terminado
                    int selectedRow = resultTable2.getSelectedRow();
                    int selectedColumn = resultTable2.getSelectedColumn();
                    
                    if (selectedRow != -1 && selectedColumn == 5) {
                        //Object selectedValue = resultTable2.getValueAt(selectedRow, selectedColumn);
                        System.out.println("XXXX");
                        //Object name = resultTable.getValueAt(selectedRow, 0);
                        //Object price = resultTable.getValueAt(selectedRow, 1);
                        
                        tableModel2.removeRow(selectedRow);
                    }
                }
            }
        });
        
        tableModel2.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    addDelTable2();    
                }
                if (e.getType() == TableModelEvent.UPDATE) {
                    updateTable2();
                }
                
            }
        });
    }
    
    public void searchFieldEvent(){
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changeTable1(); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeTable1(); 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeTable1(); 
            }
        });
    }
    
    public void changeTable1(){
        tableModel.setRowCount(0);
        ArrayList<Object[]> data = service.searchObjects(searchField.getText());
            
        for (int i=0; i<data.size(); i++) {
            tableModel.addRow(data.get(i));
        }
    }
    
    public void addDelTable2(){
        double totalSum = 0.0;
        for (int row = 0; row < tableModel2.getRowCount(); row++) {
            
//            Object dato = tableModel2.getValueAt(row, 4);
//
//            if (dato instanceof Integer) {
//                System.out.println("El dato es de tipo Integer");
//            } else if (dato instanceof String) {
//                System.out.println("El dato es de tipo String");
//            } else if (dato instanceof Double) {
//                System.out.println("El dato es de tipo Double");
//            } else {
//                System.out.println("El tipo del dato es desconocido");
//            }
            
            int cantidad = Integer.parseInt((String) tableModel2.getValueAt(row, 1));
            double preciounitario = Double.parseDouble((String) tableModel2.getValueAt(row, 2));
            double descuento = Double.parseDouble((String) tableModel2.getValueAt(row, 3));
            double total = Double.parseDouble((String) tableModel2.getValueAt(row, 4));
            
            //double total = cantidad * preciounitario * (1 - descuento);


            totalSum += total;

        }
        String text = "S/. " + totalSum;
        lb1.setText(text);
    }
    
    public void updateTable2(){
        double totalSum = 0.0;
        for (int row = 0; row < tableModel2.getRowCount(); row++) {
            int cantidad = Integer.parseInt((String) tableModel2.getValueAt(row, 1));
            double preciounitario = Double.parseDouble((String) tableModel2.getValueAt(row, 2));
            double descuento = Double.parseDouble((String) tableModel2.getValueAt(row, 3));
            
            double total = cantidad * preciounitario * (1 - (descuento/100));
            String newTotal = String.valueOf(total);
            //tableModel2.setValueAt(newTotal, row, 4);
            totalSum += total;

        }
        String text = "S/. " + totalSum;
        lb1.setText(text);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton){
           //changeTable1(); 
           tableModel2.setValueAt("10000", 0, 4);
        }
    }
    
}
