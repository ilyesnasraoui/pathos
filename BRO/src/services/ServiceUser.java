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
        String req = "insert into `users` (`username`, `password` , `email`,`role`) values ('"+u.getUsername()+ " ' , '" +u.getPassword()+"' , '" +u.getEmail()+"' , '" +u.getRole() +"' )";

    st.executeUpdate(req);
    }
    public String getRoleByUsername(String username) throws SQLException
    {            Statement st = cnx.createStatement();
         String req = "select role from users where (username='"+username+"')";
    ResultSet rs = st.executeQuery(req);
    while(rs.next())

            return rs.getString(1);
    return "";
    
    }
    public int getIdByUsername(String username) throws SQLException
    {            Statement st = cnx.createStatement();
         String req = "select id_user from users where (username='"+username+"')";
    ResultSet rs = st.executeQuery(req);
    while(rs.next())

            return rs.getInt(1);
    return -1;
    
    }
    public int checkexistance(String username) throws SQLException
    {
           Statement st = cnx.createStatement();
         String req = "select username from users where (username='"+username+"')";
    ResultSet rs = st.executeQuery(req);
    while(rs.next())

            return 1;
    return 0;
    }
      

    public void block(user p) throws SQLException{
        PreparedStatement pt1 = cnx.prepareStatement("UPDATE `users` SET `blocked` = 1 WHERE `users`.`username` =?");
        pt1.setString(1, p.getUsername());
        pt1.executeUpdate(); 
    }
     public void unblock(user p) throws SQLException{
        PreparedStatement pt1 = cnx.prepareStatement("UPDATE `users` SET `blocked` = 0 WHERE `users`.`username` =?");
        pt1.setString(1, p.getUsername());
        pt1.executeUpdate(); 
    }
     
     public int status(user p) throws SQLException{
         Statement st = cnx.createStatement();
    String req = "select blocked from users where (username='"+p.getUsername()+"') or (email='"+p.getUsername()+"' )";
    ResultSet rs = st.executeQuery(req);
    while(rs.next())
    {
        if(rs.getInt(1)==0)
            return 0;
        return 1 ;
    }
        return -1 ; 
     }
    @Override
    public List<user> read() throws SQLException{
    List<user> ls = new ArrayList<user>();
    Statement st = cnx.createStatement();
    String req = "select id_user,username,password,email,role from users";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt("id_user");
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        String role = rs.getString("role");

        
        user u = new user(id, username,password, email,role);
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
    
    public String authentification(String ue,String password) throws SQLException
    {
        
       PreparedStatement pt1 = cnx.prepareStatement("select count(*) from users where((password = ?) and (email= ? or username=?))");
       pt1.setString(1, password);
       pt1.setString(2, ue);
       pt1.setString(3, ue);
       ResultSet rs1=pt1.executeQuery();
       while(rs1.next())
       {
           
           
            if (rs1.getInt("count(*)")>0)
            {
                PreparedStatement pt2 = cnx.prepareStatement("select role from users where (email= ? or username=?)");
                    pt2.setString(1, ue);
                    pt2.setString(2, ue);              
                ResultSet rs2=pt2.executeQuery();
            
         
                while(rs2.next())
                { if ("salle".equals(rs2.getString("role")))
                    
                    {
                    
                System.out.println("you logged as salle ");
                 return("salle");
                    }
                else
                {
                    if ("admin".equals(rs2.getString("role")))
                    
                    {
                    System.out.println("you logged as an admin ");
                    return("admin");
                    }
                else{
                        System.out.println("you logged as a client ");
                        return("client");
                    }
                }
                }
                }
            
                 else  { 
                               
                                System.out.println("username/email and password doesn't match any account");
                                return("failed");
                                
            }
        }
       
    return("error");
    }
   
    
}
