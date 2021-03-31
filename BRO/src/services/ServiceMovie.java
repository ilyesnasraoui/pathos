 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Entités.Movie;
import java.sql.Connection;
import Intservice.IService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Database;


public class ServiceMovie implements IService<Movie>{
 Connection cnx ;
    public ServiceMovie() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    

     @Override
    public void add(Movie m) throws SQLException {

        //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
        String req = " INSERT INTO films (id_categorie, language, nom_film, duree_film, image, description,utube,date,rated) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
        PreparedStatement pt = cnx.prepareStatement(req);
        
        pt.setInt(1, m.getIdCat());
         pt.setString(2, m.getLang());
        pt.setString(3, m.getNom());
        pt.setInt(4, m.getDuree());
        pt.setString(5, m.getImgUrl());
        pt.setString(6, m.getDesc());
        pt.setString(7, m.getUtube());
        pt.setString(8, m.getDate());
        pt.setFloat(9,m.getRated());
        System.out.println(req);
        pt.executeUpdate();

    }


 @Override
    public List<Movie> read() throws SQLException{
    List<Movie> lss = new ArrayList<Movie>();
    Statement st = cnx.createStatement();
    String req = "select * from films";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idFilm = rs.getInt(1);
        int idCat = rs.getInt(2);
        String language = rs.getString(3);
        String nom = rs.getString(4);
        int duree = rs.getInt(5);
        String image = rs.getString(6);
        String desc = rs.getString(7);
        String utube =rs.getString(8);
        String date =rs.getString(10);
        float rated=rs.getFloat(9);
       
       //INSERT INTO `film` (`id_film`, `id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`) VALUES 
        Movie m = new Movie(idFilm, duree, idCat, nom, desc, image, desc,utube,date,rated);
        lss.add(m);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return lss;

    }
    
    


 @Override
    public void update(Movie m) throws SQLException {//`id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`
        PreparedStatement pt = cnx.prepareStatement("update films set id_categorie = ?,language = ? ,nom_film = ? ,duree_film = ? ,image = ? ,description = ? ,utube =?,date = ?, rated = ? where id_film= ?");
        
        pt.setInt(1, m.getIdCat());
         pt.setString(2, m.getLang());
        pt.setString(3, m.getNom());
        pt.setInt(4, m.getDuree());
        pt.setString(5, m.getImgUrl());
        pt.setString(6, m.getDesc());
        pt.setString(7, m.getUtube());
        
        pt.setString(8, m.getDate());
        
        pt.setFloat(9,m.getRated());
                pt.setInt(10, m.getIdFilm());

       
        pt.executeUpdate();


    }

 @Override
    public void delete(Movie m) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from films where id_film = ?");
        pt.setInt(1, m.getIdFilm());
        pt.executeUpdate();    }


    
    
    public List<Movie>searchMovie(String s) throws SQLException{
    List<Movie> lss = new ArrayList<Movie>();
    Statement st = cnx.createStatement();
    String req = "select * from films where nom_film like '"+s+"%'";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idFilm = rs.getInt(1);
        int idCat = rs.getInt(2);
        String language = rs.getString(3);
        String nom = rs.getString(4);
        int duree = rs.getInt(5);
        String image = rs.getString(6);
        String desc = rs.getString(7);
        String utube =rs.getString(8);
        String date =rs.getString(10);
        float rated=rs.getFloat(9);
       
       //INSERT INTO `film` (`id_film`, `id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`) VALUES 
       Movie m = new Movie(idFilm, duree, idCat, nom, desc, image, desc,utube,date,rated);
        lss.add(m);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return lss;

    }
    
    
    
}

