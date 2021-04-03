/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Entités.Salle;
import Entités.SalleAccount;
import Entités.user;
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
public class ServiceSalle  {
       Connection cnx ;
    public ServiceSalle() {
         cnx = Database.getInstance().getConn();
        
    }
        
    public void add(Salle s) throws SQLException{
        Statement st = cnx.createStatement();
        String req = "insert into `salle` (`name`, `governorate` , `adress`) values ('"+s.getName()+ "' , '" +s.getGovernorate()+"' , '" +s.getAdress() +"' )";

    st.executeUpdate(req);
    }

    public ObservableList<SalleAccount>  read() throws SQLException{
            ObservableList<SalleAccount> lsa = FXCollections.observableArrayList();

    Statement st = cnx.createStatement();
    String req = "select * from salle";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        Statement stt = cnx.createStatement();
    String req1 = "select id_user,,id_salle,username,email,phone from users where id_user="+rs.getInt("id_salle");
    ResultSet rs1 = stt.executeQuery(req1);
        int id = rs.getInt("id_salle");
        String name = rs.getString(2);
        String governorate = rs.getString(3);
        String adress = rs.getString(4);
        String username="";
        String email="";
        String phone="";
        int idu=0;
        while(rs1.next())
        { 
          username=rs1.getString("username");
          email=rs1.getString(email);
          phone=rs1.getString(phone);
          idu=rs1.getInt("id_user");
         // SalleAccount sa= new SalleAccount(idu,0,username,"",email,"salle",phone);
          SalleAccount Sa= new SalleAccount(id,phone,name,governorate,adress,0,username,"",email,"salle");
          lsa.add(Sa);
        }

        
  
    }
    
       return (lsa);

    }
    public void update(Salle s) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update salle set name = ? where id_salle = ? ");
        pt.setString(1, s.getName());
        pt.setInt(2, s.getId_salle());
        pt.executeUpdate(); 


    }
       
    public void delete(Salle s) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from salle where id_salle = ?");
        pt.setInt(1, s.getId_salle());
        pt.executeUpdate();    }
    
    public int maxId() throws SQLException
    {
                    Statement st = cnx.createStatement();
                    String req = "select max(id_salle) as max from salle";
                    ResultSet rs = st.executeQuery(req);
                    while(rs.next())
                    {
                        return(rs.getInt("max"));
                    }
                

     return 0 ;   
    }
}
