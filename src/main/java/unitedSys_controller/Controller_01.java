/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - controller del login

*/

package unitedSys_controller;

import unitedSys_service.Service_01;
import unitedSys_dataobject.DO_01;
        
        
public class Controller_01 {
    
    private DO_01 userDO;
    public DO_01 getUser(){ return userDO;}
    
    public Controller_01(){
    }

    
    public void accessAccount(String user_arg, String pass_arg){
        
        Service_01 service = new Service_01();
        userDO = service.accessValidation(user_arg, pass_arg);
        //if(userDO==null){ throw  new RuntimeException("Datos incorrectos."); }
    }
    
}
