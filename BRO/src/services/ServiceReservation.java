/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.Planning;
import Entités.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.Database;

/**
 *
 * @author Wissem
 */
public class ServiceReservation {
      Connection cnx ;
    public ServiceReservation() {
         cnx = Database.getInstance().getConn();
        
    } 
        public void add(Reservation r) throws SQLException{
        Statement st = cnx.createStatement();
        String req = "insert into `reservation` (`id_planning`,`id_user`) values ("+r.getId_planning()+ "," +r.getId_user()+")";

    st.executeUpdate(req);
    }
        
        
        public List<Planning> read(String username) throws SQLException{
    List<Planning> ls = new ArrayList<Planning>();
                 
    Statement st1 = cnx.createStatement();
    String req1 = "select id_user from users where username='"+username+"'";
    ResultSet rs1 = st1.executeQuery(req1);
    String req="";
    String req2="";
    while (rs1.next())
    {                  
      req2 = "select id_planning from reservation where id_user="+rs1.getInt("id_user");
    }
    Statement st2 = cnx.createStatement();
    ResultSet rs2 = st2.executeQuery(req2);
    while(rs2.next())
    {    
        req = "select * from planning where id_planning="+rs2.getInt("id_planning");
        Statement st = cnx.createStatement();
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
       Date date=rs.getDate("date");

       LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );
  
        Planning p = new Planning(localDate,id_planning,id_film,id_salle,places,day,month,year,projection_time);

        ls.add(p);

    }
    }
    
    return ls;

    }
    
    
}
