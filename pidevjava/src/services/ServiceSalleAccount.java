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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    public int getIdSalleByUsername(String username) throws SQLException
         {       Statement st = cnx.createStatement();

             String req = "select id_salle from users where username='"+username+"'";
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             {
                 return(rs.getInt("id_salle"));
             }
             return -1;
         }
    
     public void add(SalleAccount sa) throws SQLException{
       
        Statement st = cnx.createStatement();
        System.out.println(sa.getId_salle());
              String req1 = "insert into `users` (`username`,`id_salle`, `password` , `email`,`role`,`phone`) values ('"+sa.getUsername()+ "', "  +sa.getId_salle()+"  , '"+sa.getPassword()+"' , '" +sa.getEmail() +"','salle'"+",'"+sa.getPhone()+"' )";         
              st.executeUpdate(req1);
 
    }
     
 public ObservableList<SalleAccount>  read() throws SQLException{
            ObservableList<SalleAccount> lsa = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from salle";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        Statement stt = cnx.createStatement();
    String req1 = "select id_user,id_salle,username,email,phone from users where id_salle=12";
    ResultSet rs1 = stt.executeQuery(req1);
   
        int id = rs.getInt("id_salle");

        String name = rs.getString(2);

        String governorate = rs.getString(3);
        String adress = rs.getString(4);
        String username="";
        String email="";
        String phone="";
        int idu=0;
        SalleAccount Sa= new SalleAccount();
        while(rs1.next())
        { 
          username=rs1.getString("username");
          email=rs1.getString("email");

          phone=rs1.getString("phone");
          idu=rs1.getInt("id_user");
         // SalleAccount sa= new SalleAccount(idu,0,username,"",email,"salle",phone);
        //  SalleAccount Sa= new SalleAccount(id,phone,name,governorate,adress,0,username,"",email,"salle");
          Sa.setId(id); 
          Sa.setEmail(email);
          Sa.setGovernorate(governorate);
          Sa.setAdress(adress);
          Sa.setUsername(username);
          Sa.setName(name);
          Sa.setId_salle(0);
          Sa.setPhone(phone);
          Sa.setUsername(username);
          Sa.setRole("salle");
          
        }
lsa.add(Sa);
        
  
    }
  
       return (lsa);

    }
 public List<SalleAccount>  readls() throws SQLException{
         List<SalleAccount> lsa = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from salle";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        Statement stt = cnx.createStatement();
    String req1 = "select id_user,id_salle,username,email,phone from users where id_salle="+rs.getInt("id_salle");
    ResultSet rs1 = stt.executeQuery(req1);
   
        int id = rs.getInt("id_salle");

        String name = rs.getString(2);

        String governorate = rs.getString(3);
        String adress = rs.getString(4);
        String username="";
        String email="";
        String phone="";
        int idu=0;
        SalleAccount Sa= new SalleAccount();
        while(rs1.next())
        { 
          username=rs1.getString("username");
          email=rs1.getString("email");

          phone=rs1.getString("phone");
          idu=rs1.getInt("id_user");
         // SalleAccount sa= new SalleAccount(idu,0,username,"",email,"salle",phone);
        //  SalleAccount Sa= new SalleAccount(id,phone,name,governorate,adress,0,username,"",email,"salle");
          Sa.setId(id); 
          Sa.setEmail(email);
          Sa.setGovernorate(governorate);
          Sa.setAdress(adress);
          Sa.setUsername(username);
          Sa.setName(name);
          Sa.setId_salle(0);
          Sa.setPhone(phone);
          Sa.setUsername(username);
          Sa.setRole("salle");
          
        }
lsa.add(Sa);
        
  
    }
  System.out.print(lsa);
       return (lsa);

    }
      
      public void delete(SalleAccount sa) throws SQLException {
                  Statement stt = cnx.createStatement();

          String req1 = "select id_salle from users where username="+sa.getId_salle();
    ResultSet rs1 = stt.executeQuery(req1);
          PreparedStatement pt1 = cnx.prepareStatement("delete from users where username = ?");
          PreparedStatement pt2 = cnx.prepareStatement("delete from salle where id_salle = ?");
          while(rs1.next())
          pt2.setInt(1, rs1.getInt("id_salle"));
        pt1.setString(1, sa.getUsername());
        pt1.executeUpdate();  
          pt2.executeUpdate();  
    }
      
      public List<SalleAccount> sort(String filter,String type) throws SQLException{
    List<SalleAccount> ls = new ArrayList<SalleAccount>();
    Statement st = cnx.createStatement();
    String req = "select id_user,username,password,email,id_salle,role,phone from users where role='salle' order by "+filter+" "+ type;
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String password = rs.getString(3);
        String email = rs.getString(4);
        int id_salle = rs.getInt(5);
        String role = rs.getString(6);
        String phone = rs.getString(7);

       


        
        SalleAccount sa = new SalleAccount(id_salle,id,username,password,email,role,phone);
        ls.add(sa);
    }
    
    return ls;

    }
      
    
}
