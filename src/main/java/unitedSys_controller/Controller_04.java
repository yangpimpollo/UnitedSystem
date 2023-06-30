/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - controller para registrar ordenes

*/
package unitedSys_controller;

import unitedSys_service.Service_04;

public class Controller_04 {
    
    public Controller_04(){}
    
    public boolean newOrder(String arg0, String arg1, String arg2){
        
        Service_04 service = new Service_04();

        return service.newOrder(arg0, arg1, arg2);
    }
}
