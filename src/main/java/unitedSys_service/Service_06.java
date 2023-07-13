/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - service para buscar ordenes

*/
package unitedSys_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import unitedSys_database.DbAccess;


public class Service_06 {
    public ArrayList<Object[]> searchObjects(String arg){
        ArrayList<Object[]> data = new ArrayList<>();
        
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "SELECT O.order_id, C.business_name "
                    + "FROM Orders as O, Customers as C "
                    + "WHERE O.Customers_customer_id=C.customer_id AND date=?";
            
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, arg);

            ResultSet resultSet = statement.executeQuery();

            int i=0;
            while (resultSet.next()) {
                String objectName = resultSet.getString("order_id");
                String price = resultSet.getString("business_name");
                
                data.add(new Object[]{objectName, price});
                i++;
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
