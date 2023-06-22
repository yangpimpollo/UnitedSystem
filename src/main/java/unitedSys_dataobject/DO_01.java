/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - user data object

*/


package unitedSys_dataobject;


public class DO_01 {
    private String user;
    private String pass;
    public DO_01(){};
    public String getUser(){ return user; };
    public String getPass(){ return pass; };
    public void setUser(String arg){ this.user= arg; };
    public void setPass(String arg){ this.pass= arg; };
}
