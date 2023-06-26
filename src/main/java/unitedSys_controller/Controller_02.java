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
    
    public boolean newCustomer(String[] arg){
        
        customer = new DO_02();
                
        customer.setDoctype(arg[0]);
        customer.setDocId(arg[1]);
        customer.setBussname(arg[2]);
        customer.setFirstName(arg[3]);
        customer.setLastName(arg[4]);
        customer.setAddress(arg[5]);
        customer.setEmail(arg[6]);
        customer.setPhone(arg[7]);
        
        
        Service_02 service = new Service_02();

        return service.addCustomer(customer);
    }
}
