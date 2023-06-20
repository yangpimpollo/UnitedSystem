/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

clase para main del proyecto

*/

package unitedSys_main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import unitedSys_database.DbAccess;


public class MainClass {
        public static void main(String[] args) {
        System.out.println("Hello World!");
        
        try {
            Connection cn = DbAccess.getConnection();
            System.out.println("Conexion ok.");
            //---------------------------------------------------------
            
            String sql = "SELECT employee_name FROM Employee WHERE employee_id = 800;";
            Statement statement = cn.createStatement();
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery(sql);
            
            // Procesar los resultados
            if (resultSet.next()) {
                String nombreCliente = resultSet.getString("employee_name");
                System.out.println("Nombre del cliente: " + nombreCliente);
            } else {
                System.out.println("No se encontró el cliente con ID = 800");
            }
            //-------------------------------------------------------------
            cn.close(); // Cierra la conexion
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
