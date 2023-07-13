/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - service para buscar generar excel del inventario

*/
package unitedSys_service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import unitedSys_database.DbAccess;


public class Service_08 {
    
    
    public boolean generateReport(String arg) throws FileNotFoundException, IOException{
        boolean result= false;
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "SELECT * FROM Inventory WHERE Orders_order_id =?";
            
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, arg);

            ResultSet resultSet = statement.executeQuery();
            // Crear el archivo de Excel y la hoja de cálculo
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Resultado");

            // Crear la fila para los encabezados de las columnas
            Row headerRow = sheet.createRow(0);
            
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Cell cell = headerRow.createCell(i - 1);
                cell.setCellValue(columnName);
            }

            // Llenar los datos del ResultSet en las filas
            int rowNum = 1;
            while (resultSet.next()) {
                Row dataRow = sheet.createRow(rowNum);

                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    Cell cell = dataRow.createCell(i - 1);
                    cell.setCellValue(String.valueOf(value));
                }

                rowNum++;
            }
            
            // Guardar el archivo de Excel
            try (FileOutputStream outputStream = new FileOutputStream("report_" + arg + ".xlsx")) {
                workbook.write(outputStream);
            }
            System.out.println("El archivo de Excel se ha creado correctamente.");
            result= true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
