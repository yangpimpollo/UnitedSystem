/*   

UNIVERSIDAD NACIONAL DE INGENIERÍA
INGENIERÍA ESTADÍSTICA

@author yangpimpollo [LIN CHIU CHEN YANG - 20200403F]

    - customer data object

*/
package unitedSys_dataobject;



public class DO_02 {
    private String doctype;
    private String docid;
    private String bussname;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    
    public DO_02(){};
    
    public String getDoctype(){ return doctype; };
    public String getDocId(){ return docid; };
    public String getBussname(){ return bussname; };
    public String getFirstName(){ return firstname; };
    public String getLastName(){ return lastname; };
    public String getAddress(){ return address; };
    public String getEmail(){ return email; };
    public String getPhone(){ return phone; };
    
    
    public void setDoctype(String arg){ this.doctype= arg; };
    public void setDocId(String arg){ this.docid= arg; };
    public void setBussname(String arg){ this.bussname= arg; };
    public void setFirstName(String arg){ this.firstname= arg; };
    public void setLastName(String arg){ this.lastname= arg; };
    public void setAddress(String arg){ this.address= arg; };
    public void setEmail(String arg){ this.email= arg; };
    public void setPhone(String arg){ this.phone= arg; };
}
