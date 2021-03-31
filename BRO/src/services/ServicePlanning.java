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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.Database;
/**
 *
 * @author Wissem
 */
public class ServicePlanning implements IService<Planning> {
     Connection cnx ;
    public ServicePlanning() {
         cnx = Database.getInstance().getConn();
        
    }  
    @Override
         public void add(Planning p) throws SQLException{
        Statement st = cnx.createStatement();
        String req = "insert into `planning` (`day`,`month`,`date`,`year`,`places`, `id_film` , `id_salle`,`projection_time`) "
                + "                   values ('"+p.getDay()+ "' , '" +p.getMonth()+"' ,'"+p.getDate()+"','" +p.getYear()+"' , "+p.getPlaces()+" , " +p.getId_film()+" , " +p.getId_salle()+" , '" +p.getProjection_time() +"' )";

    st.executeUpdate(req);
    }
         public int getIdFilmByName(String name) throws SQLException
         {       Statement st = cnx.createStatement();

             String req = "select id_film from film where nom_film='"+name+"'";
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             
                 return(rs.getInt("id_film"));
             
             return -1;
         }
              public String getNameFilmById(int id) throws SQLException
         {       Statement st = cnx.createStatement();

             String req = "select nom_film from film where id_film="+id;
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             
                 return(rs.getString("nom_film"));
             
             return "";
         }
              
                  public String getNameCategoryById(int id) throws SQLException
         {       Statement st = cnx.createStatement();

             String req = "select nom_categorie from categorie_film where id_categorie="+id;
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             
                 return(rs.getString("nom_categorie"));
             
             return "";
         }
                          public int getIdCategoryByIdFilm(int id) throws SQLException
         {       Statement st = cnx.createStatement();

             String req = "select id_categorie from film where id_film="+id;
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             
                 return(rs.getInt("id_categorie"));
             
             return -1;
         }
         public String getDurationByIdFilm(int id) throws SQLException
         {       Statement st = cnx.createStatement();

             String req = "select duree_film from film where id_film="+id;
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             
                 return(rs.getString("duree_film"));
             
             return "";
         }
         
         @Override
          public void delete(Planning p) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from planning where id_planning = ?");
        pt.setInt(1, p.getId_planning());
        pt.executeUpdate();    }

public List<Planning> searchsingle(String x) throws SQLException{
    List<Planning> ls = new ArrayList<Planning>();
    Statement st = cnx.createStatement();
    int id= getIdFilmByName(x);
    String req = "select * from planning  where  (date like '%"+x+"%') or (projection_time like '%"+x+"%') or (id_film="+id+") ";

    ResultSet rs = st.executeQuery(req);
                 System.out.print("test fff");


    while(rs.next()){
        int id_planning = rs.getInt(1);
                              //   System.out.println("1"+id_planning);

        int id_film = rs.getInt(2);
        int id_salle = rs.getInt(3);
        int day = rs.getInt(4);
        int month = rs.getInt(5);
        int year = rs.getInt(6);
        String projection_time = rs.getString(7);
        int places = rs.getInt(8);
       Date date=rs.getDate("date");

       LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );

    //     LocalDate date = LocalDate.now();  
        Planning p = new Planning(localDate,id_planning,id_film,id_salle,places,day,month,year,projection_time);

        ls.add(p);
                                                       System.out.println(p);

     
    }
    
    return ls;

    }

public List<Planning> read(String username) throws SQLException{
    List<Planning> ls = new ArrayList<Planning>();
                 
System.out.print(username);
    Statement st1 = cnx.createStatement();
    
    String req1 = "select id_salle,role from users where username='"+username+"'";

    ResultSet rs1 = st1.executeQuery(req1);
    String req="";

    while (rs1.next())
    {  System.out.print("dkhalt lahne if");
        if(!"salle".equals(rs1.getString(2)))
    
        {  System.out.print("dkhalt lahne if");
            req = "select * from planning";
        }
        else{
                     System.out.print("dkhalt lahne else");

                req = "select * from planning where id_salle="+rs1.getString(1);
        }
    }
        Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);



    while(rs.next()){
        int id_planning = rs.getInt(1);
                              //   System.out.println("1"+id_planning);

        int id_film = rs.getInt(2);
        int id_salle = rs.getInt(3);
        int day = rs.getInt(4);
        int month = rs.getInt(5);
        int year = rs.getInt(6);
        String projection_time = rs.getString(7);
        int places = rs.getInt(8);
       Date date=rs.getDate("date");

       LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );

    //     LocalDate date = LocalDate.now();  
        Planning p = new Planning(localDate,id_planning,id_film,id_salle,places,day,month,year,projection_time);

        ls.add(p);
                                                       System.out.println(p);

     
    }
    
    return ls;

    }
@Override

public List<Planning> read() throws SQLException{
    List<Planning> ls = new ArrayList<Planning>();
    Statement st = cnx.createStatement();
    String req = "select * from planning";

    ResultSet rs = st.executeQuery(req);
                 System.out.print("test fff");


    while(rs.next()){
        int id_planning = rs.getInt(1);
                              //   System.out.println("1"+id_planning);

        int id_film = rs.getInt(2);
        int id_salle = rs.getInt(3);
        int day = rs.getInt(4);
        int month = rs.getInt(5);
        int year = rs.getInt(6);
        String projection_time = rs.getString(7);
        int places = rs.getInt(8);
       Date date=rs.getDate("date");

       LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );

    //     LocalDate date = LocalDate.now();  
        Planning p = new Planning(localDate,id_planning,id_film,id_salle,places,day,month,year,projection_time);

        ls.add(p);
                                                       System.out.println(p);

     
    }
    
    return ls;

    }
@Override
public void update(Planning u) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update planning set places = ? where id_planning = ? ");
        pt.setInt(1, u.getPlaces());
        pt.setInt(2, u.getId_planning());
        pt.executeUpdate(); 


    }
    
}
