/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - service para guardar objetos en el inventario

*/
package unitedSys_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import unitedSys_database.DbAccess;


public class service_07 {
    
    public boolean addItemService(String arg0, String arg1, String arg2, String arg3){
        boolean result= false;
        
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "SELECT * FROM Orders WHERE order_id = ?";
            
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, arg0);
            
            ResultSet orderResult = stmt.executeQuery();

            if (orderResult.next()) {
                String insertQuery = "EXEC addItem @_dat0 = ?,  @_dat1 = ?, @_dat2 = ?, @_dat3 = ?";
                PreparedStatement insertStatement = cn.prepareStatement(insertQuery);
                insertStatement.setString(1, arg0);
                insertStatement.setString(2, arg1);
                insertStatement.setString(3, arg2);
                insertStatement.setString(4, arg3);
                
                int rowsAffected = insertStatement.executeUpdate();
                if (rowsAffected > 0) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
