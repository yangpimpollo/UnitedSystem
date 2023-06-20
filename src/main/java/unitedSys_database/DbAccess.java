/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

clase para crear la conección con la base de datos
retornando el objeto Connection

*/
package unitedSys_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbAccess {
    private DbAccess() {}
    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String server = "sql.bsite.net\\MSSQL2016";
        String database = "unitedvanlines_SampleDB";
        String user = "unitedvanlines_SampleDB";
        String pass = "12345678";
        
        String urlDB = "jdbc:sqlserver://" + server + 
                ";databaseName=" + database + 
                ";user=" + user + 
                ";password=" + pass + 
                ";encrypt=true;TrustServerCertificate=True;";
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(urlDB);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found.");
        } catch (Exception e) {
            throw new SQLException("Error establishing database connection.");
        }
        return connection;
    }
}
