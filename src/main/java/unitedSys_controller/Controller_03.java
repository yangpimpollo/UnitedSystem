/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - controller de busqueda del cliente

*/
package unitedSys_controller;

import unitedSys_service.Service_03;



public class Controller_03 {
    
    public Controller_03(){}
    
    public String searchCustomer(String id_arg){
        Service_03 service = new Service_03();
        return service.searchCustomerService(id_arg);
    }
}
