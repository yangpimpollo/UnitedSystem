/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - service del registro del cliente

*/
package unitedSys_service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unitedSys_database.DbAccess;
import unitedSys_dataobject.DO_02;


public class Service_02 {
    
    public boolean addCustomer(DO_02 arg){
        boolean result= false;
        try (Connection cn = DbAccess.getConnection()) {
            String sql = "EXEC addCustomer @_dat1=?,@_dat2=?,@_dat3=?,@_dat4=?,@_dat5=?,@_dat6=?,@_dat7=?,@_dat8=?";
            
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, arg.getDocId());
            stmt.setString(2, arg.getDoctype());
            stmt.setString(3, arg.getBussname());
            stmt.setString(4, arg.getFirstName());
            stmt.setString(5, arg.getLastName());
            stmt.setString(6, arg.getAddress());
            stmt.setString(7, arg.getEmail());
            stmt.setString(8, arg.getPhone());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cliente registrado correctamente.");
                result = true;
            } else {
                System.out.println("Error al registrar el cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
