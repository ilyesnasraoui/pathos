/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.user;
import Intservice.IService; //maybe nbadalha
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
public class ServiceUser implements IService<user>{
    
    Connection cnx ;
    public ServiceUser() {
         cnx = Database.getInstance().getConn();
        
    }
     @Override
    public void add(user u) throws SQLException{
        Statement st = cnx.createStatement();
        String req = "insert into `users` (`username`, `password` , `email`) values ('"+u.getUsername()+ " ' , '" +u.getPassword()+"' , '" +u.getEmail() +"' )";

    st.executeUpdate(req);
    }

    @Override
    public List<user> read() throws SQLException{
    List<user> ls = new ArrayList<user>();
    Statement st = cnx.createStatement();
    String req = "select * from users";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt("id_user");
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);

        
        user u = new user(id, username,password, email);
        ls.add(u);
    }
    
    return ls;

    }

    @Override
    public void update(user u) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update users set username = ? where id_user = ? ");
        pt.setString(1, u.getUsername());
        pt.setInt(2, u.getId());
        pt.executeUpdate(); 


    }

    @Override
    public void delete(user u) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from users where id_user = ?");
        pt.setInt(1, u.getId());
        pt.executeUpdate();    }
    
    public void authentification(String ue,String password) throws SQLException
    {
        
        PreparedStatement pt1 = cnx.prepareStatement("select count(*) from users where((password = ?) and (email= ? or username=?))");
       pt1.setString(1, password);
       pt1.setString(2, ue);
       pt1.setString(3, ue);
       ResultSet rs1=pt1.executeQuery();
       while(rs1.next()){
           
           
            if (rs1.getInt("count(*)")>0){
                PreparedStatement pt2 = cnx.prepareStatement("select count(*) from users,salle_account where((id_user=id_sa)and (email= ? or username=?))");
                    pt2.setString(1, ue);
                    pt2.setString(2, ue);              
                ResultSet rs2=pt2.executeQuery();
            
         
                while(rs2.next())
                { if (rs2.getInt("count(*)")>0){
                    System.out.println(rs2.getInt("count(*)"));
                System.out.println("you logged as salle ");}
                 else
                {System.out.println("you logged as a person ");}
                }
                }
            
                 else  { 
                               
                                System.out.println("username/email and password doesn't match any account");
                                
            }
        }
       
    
    }
   
    
}
