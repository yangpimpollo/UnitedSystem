/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

clase administradora de todas las pruebas unitarias del proyecto

*/

package unitedSys_service;

import unitedSys_service.Test_connection;


public class TestManager {
    
    // funcion que realiza la prueba
    public static void test(boolean arg, String name){
        String text = (arg)? " test: ok." : " test: failed.";
        System.out.println(name + text);
    }
    
    public static void main(String[] args) {
        
        // lista de las pruebas a realizar
        test(new Test_connection().initTest(), "connection");
    }
}
