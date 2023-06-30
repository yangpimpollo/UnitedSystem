/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

clase para el testeo de la 
   - coneccion con la base de datos
   - consulta a la base de datos

*/

package unitedSys_service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import unitedSys_database.DbAccess;

public class Test_connection{
    public boolean initTest(){
        try{
            Connection connection = DbAccess.getConnection(); connection.close();
            return true;
        }catch(Exception e){ return false; }
    }    
}
