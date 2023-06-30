/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]
https://github.com/yangpimpollo/UnitedSystem

    - user data object

*/


package unitedSys_dataobject;


public class DO_01 {

    private int employeeID;
    private String employeeName;
    private String user;
    private String pass;
    public DO_01(){};
    
    public int getId(){ return employeeID; };
    public String getName(){ return employeeName; };
    public String getUser(){ return user; };
    public String getPass(){ return pass; };
    public void setID(int arg){ this.employeeID= arg; };
    public void setName(String arg){ this.employeeName= arg; };
    public void setUser(String arg){ this.user= arg; };
    public void setPass(String arg){ this.pass= arg; };
    

}
