/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Entités.Person;
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
public class ServicePerson  {
    
       Connection cnx ;
    public ServicePerson() {
         cnx = Database.getInstance().getConn();
        
}
         
    public void add(Person p) throws SQLException{
       int m=0;
        Statement st = cnx.createStatement();
              String req1 = "insert into `users` (`username`, `password` , `email`) values ('"+p.getUsername()+ " ' , '" +p.getPassword()+"' , '" +p.getEmail() +"' )";
              
   st.executeUpdate(req1);
                String req2="SELECT MAX(id_user) as max FROM `users`" ;
ResultSet rs = st.executeQuery(req2);
while(rs.next()){
m=rs.getInt("max");
}
  String req = "insert into `person` (`fname`,`lname`,`idcard`,`phone`,`role`,`id_person`) "
                        + "values ('"+p.getFname()+ " ' , '" +p.getLname()+"' , '"+p.getIdcard()+"' , '"+p.getPhone()+"' , "+p.getRole()+" , "+m+")";
   
    st.executeUpdate(req);
    }
    
    
     
    public List<Person> read() throws SQLException{
    List<Person> ls = new ArrayList<Person>();
    Statement st = cnx.createStatement();
    String req = "select * from users , person where id_user=id_person";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
                String fname = rs.getString(5);
        String lname = rs.getString(6);
        String idcard = rs.getString(7);
        String phone = rs.getString(8);
        int role = rs.getInt(9);


        
        Person p = new Person(fname,lname,idcard,role,id,username,password, email,phone);
        ls.add(p);
    }
    
    return ls;

    }
    
    public void delete(Person p) throws SQLException {
                PreparedStatement pt = cnx.prepareStatement("delete from person where id_person = ?");
        PreparedStatement pt1 = cnx.prepareStatement("delete from users where id_user = ?");
        pt.setInt(1, p.getId());
        pt1.setInt(1, p.getId());
        pt1.executeUpdate();  
        pt.executeUpdate(); 
    }
    
}
