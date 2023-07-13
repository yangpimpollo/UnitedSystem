/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - service para buscar servicios

*/
package unitedSys_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import unitedSys_database.DbAccess;


public class Service_05 {
    
    public ArrayList<Object[]> searchObjects(String arg){
        ArrayList<Object[]> data = new ArrayList<>();
        
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "SELECT * FROM AllServices WHERE service_name  LIKE ?";
            
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, "%" + arg + "%");

            ResultSet resultSet = statement.executeQuery();

            int i=0;
            while (resultSet.next()) {
                String objectName = resultSet.getString("service_name");
                String price = resultSet.getString("unit_price");
                
                data.add(new Object[]{objectName, price});
                i++;
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
