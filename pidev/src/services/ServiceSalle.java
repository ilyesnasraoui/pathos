/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Entités.Salle;
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
public class ServiceSalle implements IService<Salle> {
       Connection cnx ;
    public ServiceSalle() {
         cnx = Database.getInstance().getConn();
        
    }
         @Override
    public void add(Salle s) throws SQLException{
        Statement st = cnx.createStatement();
        String req = "insert into `salle` (`name`, `governorate` , `adress`) values ('"+s.getName()+ " ' , '" +s.getGovernorate()+"' , '" +s.getAdress() +"' )";

    st.executeUpdate(req);
    }
@Override
    public List<Salle> read() throws SQLException{
    List<Salle> ls = new ArrayList<Salle>();
    Statement st = cnx.createStatement();
    String req = "select * from salle";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt("id_salle");
        String name = rs.getString(2);
        String governorate = rs.getString(3);
        String adress = rs.getString(4);

        
        Salle s = new Salle(id, name,governorate, adress);
        ls.add(s);
     
    }
    
    return ls;

    }
     @Override
    public void update(Salle s) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update salle set name = ? where id_salle = ? ");
        pt.setString(1, s.getName());
        pt.setInt(2, s.getId_salle());
        pt.executeUpdate(); 


    }
        @Override
    public void delete(Salle s) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from salle where id_salle = ?");
        pt.setInt(1, s.getId_salle());
        pt.executeUpdate();    }
}
