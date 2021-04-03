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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Database;
/**
 *
 * @author Wissem
 */
public class ServicePerson 
{
    
       Connection cnx ;
    public ServicePerson() {
         cnx = Database.getInstance().getConn();
        
}
    public int status(Person p) throws SQLException{
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
         
    public void add(Person p) throws SQLException{
     
        Statement st = cnx.createStatement();
        System.out.println(p.getFname());
              String req1 = "insert into `users` (`username`, `password` , `email`,`fname`,`lname`,`idcard`,`phone`,`role`)"
                      + " values ('"+p.getUsername()+ "' , '" +p.getPassword()+"' , '" +p.getEmail() +"' , '"+p.getFname()+ "' , '" +p.getLname()+"' , '"+p.getIdcard()+"' , '"+p.getPhone()+"' , 'client')";
              
   st.executeUpdate(req1);

 
    }
    
    public ObservableList<Person> read() throws SQLException{
            ObservableList<Person> L = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from users where ((role='admin') or (role='client'))";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        String fname = rs.getString(6);
        String lname = rs.getString(7);
        String idcard = rs.getString(8);
        String phone = rs.getString(9);
        String role = rs.getString(10);


        Person p= new Person(fname,lname,idcard,phone,id,username,password,email,role);
       
        L.add(p);
    }
    
    return L;

    }  
    public List<Person> readls() throws SQLException{
            List<Person> L = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from users where ((role='admin') or (role='client'))";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        String fname = rs.getString(6);
        String lname = rs.getString(7);
        String idcard = rs.getString(8);
        String phone = rs.getString(9);
        String role = rs.getString(10);


        Person p= new Person(fname,lname,idcard,phone,id,username,password,email,role);
       
        L.add(p);
    }
    
    return L;

    } 
   
    public ObservableList<Person> search(String x) throws SQLException{
            ObservableList<Person> L = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from users where (((role='admin') or (role='client')) and ((username like '%"+x+"%') or (lname like '%"+x+"%') or (fname like '%"+x+"%')or(idcard like '%"+x+"%') or (role like '%"+x+"%')or(email like '%"+x+"%')or (phone like '%"+x+"%')))";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        String fname = rs.getString(6);
        String lname = rs.getString(7);
        String idcard = rs.getString(8);
        String phone = rs.getString(9);
        String role = rs.getString(10);


        Person p= new Person(fname,lname,idcard,phone,id,username,password,email,role);
       
        L.add(p);
    }
    
    return L;

    }
    public Person getInstance(String username) throws SQLException
    {     Statement st = cnx.createStatement();
         String password = null,email = null,fname = null,lname = null,idcard = null,phone = null,role = null;
         int id = 0;
            String req = "select role,password,email,fname,lname,idcard,phone,id_user from users where (username = '"+username+"')";
                ResultSet rs = st.executeQuery(req);
          while(rs.next()){
               password = rs.getString(2);
         email = rs.getString(3);
        fname = rs.getString(4);
         lname = rs.getString(5);
        idcard = rs.getString(6);
         phone = rs.getString(7);
         role = rs.getString(1);
         id=rs.getInt(8);
        

          }
                Person p=new Person(fname,lname,idcard,phone,id,username,password,email,role);

        return  p ;
    }
    
    public void setadmin(Person p) throws SQLException{
        PreparedStatement pt1 = cnx.prepareStatement("UPDATE `users` SET `role` = 'admin' WHERE `users`.`username` = ?");
        pt1.setString(1, p.getUsername());
        pt1.executeUpdate(); 
    }
     
    
    public void delete(Person p) throws SQLException {
        System.out.print(p.getUsername());
        PreparedStatement pt1 = cnx.prepareStatement("delete from users where username = ?");
        pt1.setString(1, p.getUsername());
        pt1.executeUpdate();  
    }
    
    public List<Person> sort(String filter) throws SQLException{
    List<Person> ls = new ArrayList<Person>();
    Statement st = cnx.createStatement();
    String req = "select * from users where ((role='admin') or (role='client')) sort by "+filter;
    ResultSet rs = st.executeQuery(req);
     
     while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        String fname = rs.getString(6);
        String lname = rs.getString(7);
        String idcard = rs.getString(8);
        String phone = rs.getString(9);
        String role = rs.getString(10);


        Person p= new Person(fname,lname,idcard,phone,id,username,password,email,role);
        ls.add(p);
    }
    
    return ls;

    }
     public List<Person> searchls(String x) throws SQLException{
            List<Person> L = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from users where (((role='admin') or (role='client')) and ((username like '%"+x+"%') or (lname like '%"+x+"%') or (fname like '%"+x+"%')or(idcard like '%"+x+"%') or (role like '%"+x+"%')or(email like '%"+x+"%')or (phone like '%"+x+"%')))";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        String fname = rs.getString(6);
        String lname = rs.getString(7);
        String idcard = rs.getString(8);
        String phone = rs.getString(9);
        String role = rs.getString(10);


        Person p= new Person(fname,lname,idcard,phone,id,username,password,email,role);
       
        L.add(p);
    }
    
    return L;

    } 
  
    
}
