/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - service para registrar ordenes

*/
package unitedSys_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unitedSys_database.DbAccess;

public class Service_04 {
    
    public boolean newOrder(String arg0, String arg1, String arg2){
        boolean result= false;
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "INSERT INTO Orders (Employee_employee_id, Customers_customer_id, date) VALUES (?, ?, ?);";
            
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, arg0);
            stmt.setString(2, arg1);
            stmt.setString(3, arg2);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Order registrado correctamente.");
                result = true;
            } else {
                System.out.println("Error al registrar la orden.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
