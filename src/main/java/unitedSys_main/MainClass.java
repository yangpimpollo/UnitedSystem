/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - clase main del proyecto

*/

package unitedSys_main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import unitedSys_database.DbAccess;
import unitedSys_view.ViewPreload;


public class MainClass {
    
    public static void main(String[] args) {
        System.out.println("init UnitedVanLines System");
        new ViewPreload();
    }
}
