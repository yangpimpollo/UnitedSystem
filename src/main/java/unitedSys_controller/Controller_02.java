/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - controller del registro del cliente

*/
package unitedSys_controller;

import unitedSys_service.Service_02;
import unitedSys_dataobject.DO_02;

public class Controller_02 {
    
    private DO_02 customer;
    public DO_02 getUser(){ return customer;}
    
    public Controller_02(){
    }
    
    public void newCustomer(String user_arg, String pass_arg){
        
        Service_02 service = new Service_02();
        customer = service.accessValidation(user_arg, pass_arg);
        //if(userDO==null){ throw  new RuntimeException("Datos incorrectos."); }
    }
}
