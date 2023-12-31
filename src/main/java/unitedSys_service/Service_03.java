/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - service de busqueda del cliente

*/
package unitedSys_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unitedSys_database.DbAccess;


public class Service_03 {
    
    public String searchCustomerService(String id_arg){
        
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "SELECT * FROM Customers WHERE customer_id=?";
            //Statement statement = cn.createStatement();
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, id_arg);

            ResultSet resultSet = statement.executeQuery();
            

            if(resultSet.next()){
                return resultSet.getString("business_name");                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
