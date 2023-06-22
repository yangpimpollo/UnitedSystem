/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - service del login

*/
package unitedSys_service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unitedSys_database.DbAccess;
import unitedSys_dataobject.DO_01;

public class Service_01 {
     public DO_01 accessValidation(String user_arg, String pass_arg){
         DO_01 userDO = null;
          try {
            Connection cn = DbAccess.getConnection();System.out.println("conec");
            
            String sql = "EXEC singinAccount @_user_name = '" + user_arg + "', @_pass = '" + pass_arg + "'";
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                System.out.println("esec");
                userDO = new DO_01();
                userDO.setUser(resultSet.getString("user_name"));
                userDO.setPass(resultSet.getString("pass"));
            }
            
            
            cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
          return userDO;
     }
}
