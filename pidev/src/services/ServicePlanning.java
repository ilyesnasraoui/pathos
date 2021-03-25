/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Entités.Planning;
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
public class ServicePlanning {
     Connection cnx ;
    public ServicePlanning() {
         cnx = Database.getInstance().getConn();
        
    }  
         public void add(Planning p) throws SQLException{
        Statement st = cnx.createStatement();
        String req = "insert into `planning` (`day`,`month`,`year`,`places`, `id_film` , `id_salle`,`projection_time`) "
                + "                   values ('"+p.getDay()+ " ' , '" +p.getMonth()+"' , '" +p.getYear()+"' , "+p.getPlaces()+" , " +p.getId_film()+" , " +p.getId_salle()+" , '" +p.getProjection_time() +"' )";

    st.executeUpdate(req);
    }
         
          public void delete(Planning p) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from planning where id_planning = ?");
        pt.setInt(1, p.getId_salle());
        pt.executeUpdate();    }


public List<Planning> read() throws SQLException{
    List<Planning> ls = new ArrayList<Planning>();
    Statement st = cnx.createStatement();
    String req = "select * from planning";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id_planning = rs.getInt(1);
        int id_film = rs.getInt(2);
        int id_salle = rs.getInt(3);
        int day = rs.getInt(4);
        int month = rs.getInt(5);
        int year = rs.getInt(6);
        String projection_time = rs.getString(7);
        int places = rs.getInt(8);

        Planning p = new Planning(id_planning,id_film,id_salle,places,day,month,year,projection_time);
        ls.add(p);
     
    }
    
    return ls;

    }

public void update(Planning u) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update planning set places = ? where id_planning = ? ");
        pt.setInt(1, u.getPlaces());
        pt.setInt(2, u.getId_planning());
        pt.executeUpdate(); 


    }
    
}
