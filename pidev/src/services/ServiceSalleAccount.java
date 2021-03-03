/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Entités.SalleAccount;
import Intservice.IService; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Database;
/**
 *
 * @author Wissem
 */
public class ServiceSalleAccount {
    Connection cnx ;
    public ServiceSalleAccount() {
         cnx = Database.getInstance().getConn();
        
}
     public void add(SalleAccount sa) throws SQLException{
       int m=0;
        Statement st = cnx.createStatement();
              String req1 = "insert into `users` (`username`, `password` , `email`) values ('"+sa.getUsername()+ " ' , '" +sa.getPassword()+"' , '" +sa.getEmail() +"' )";
              
   st.executeUpdate(req1);
                String req2="SELECT MAX(id_user) as max FROM `users`" ;
ResultSet rs = st.executeQuery(req2);
while(rs.next()){
m=rs.getInt("max");

}
  String req = "insert into `salle_account` (id_sa,id_salle) "
                        + "values ("+m+ "  , " +sa.getId()+")";
   
    st.executeUpdate(req);
    }
     
      public List<SalleAccount> read() throws SQLException{
    List<SalleAccount> ls = new ArrayList<SalleAccount>();
    Statement st = cnx.createStatement();
    String req = "select * from users , salle_account where id_user=id_sa";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        int id_salle = rs.getInt(6);
       


        
        SalleAccount sa = new SalleAccount(id,id_salle,username,password,email);
        ls.add(sa);
    }
    
    return ls;

    }
      
      public void delete(SalleAccount sa) throws SQLException {
                PreparedStatement pt = cnx.prepareStatement("delete from Salle_account where id_sa = ?");
        PreparedStatement pt1 = cnx.prepareStatement("delete from users where id_user = ?");
        pt.setInt(1, sa.getId());
        pt1.setInt(1, sa.getId());
        pt1.executeUpdate();  
        pt.executeUpdate(); 
    }
    
}
