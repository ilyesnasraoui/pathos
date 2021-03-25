/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import model.Movie;
import IntService.IService;
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


public class ServiceMovie implements IService<Movie>{
 Connection cnx ;
    public ServiceMovie() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    

     @Override
    public void add(Movie m) throws SQLException {

        //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
        String req = " INSERT INTO produit (id_produit, id_categorie, couleur, nom_produit, prix, image, description) VALUES (?, ? , ? , ? , ? , ? , ? )";
        PreparedStatement pt = cnx.prepareStatement(req);
        pt.setInt(1, m.getIdFilm());
        pt.setInt(2, m.getIdCat());
         pt.setString(3, m.getLang());
        pt.setString(4, m.getNom());
        pt.setInt(5, m.getDuree());
        pt.setString(6, m.getImgUrl());
        pt.setString(7, m.getDesc());
        System.out.println(req);
        pt.executeUpdate();

    }


 @Override
    public List<Movie> read() throws SQLException{
    List<Movie> lss = new ArrayList<Movie>();
    Statement st = cnx.createStatement();
    String req = "select * from produit";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idFilm = rs.getInt(1);
        int idCat = rs.getInt(2);
        String language = rs.getString(3);
        String nom = rs.getString(4);
        int duree = rs.getInt(5);
        String image = rs.getString(6);
        String desc = rs.getString(7);
       
       //INSERT INTO `film` (`id_film`, `id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`) VALUES 
        Movie m = new Movie(idFilm, duree, idCat, nom, desc, image, desc);
        lss.add(m);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return lss;

    }
    
    


 @Override
    public void update(Movie m) throws SQLException {//`id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`
        PreparedStatement pt = cnx.prepareStatement("update produit set id_categorie = ?,couleur = ? ,nom_produit = ? ,prix = ? ,image = ? ,description = ? where id_produit= ? ");
         pt.setInt(7, m.getIdFilm());
         pt.setInt(1, m.getIdCat());
        pt.setString(2, m.getLang());
        pt.setString(3, m.getNom());
         pt.setInt(4, m.getDuree());
         pt.setString(5, m.getImgUrl());
         pt.setString(6, m.getDesc());
        
        pt.executeUpdate(); 


    }

 @Override
    public void delete(Movie m) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from produit where id_produit = ?");
        pt.setInt(1, m.getIdFilm());
        pt.executeUpdate();    }


    
    
    public List<Movie>searchMovie(String s) throws SQLException{
    List<Movie> lss = new ArrayList<Movie>();
    Statement st = cnx.createStatement();
    String req = "select * from produit where nom_produit like '"+s+"%'";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idFilm = rs.getInt(1);
        int idCat = rs.getInt(2);
        String language = rs.getString(3);
        String nom = rs.getString(4);
        int duree = rs.getInt(5);
        String image = rs.getString(6);
        String desc = rs.getString(7);
       
       //INSERT INTO `film` (`id_film`, `id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`) VALUES 
        Movie m = new Movie(idFilm, duree, idCat, nom, desc, image, desc);
        lss.add(m);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return lss;

    }
    
}

