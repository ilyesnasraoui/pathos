/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Entités.Movie;
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
import Entités.CategoryFilm;
import utils.Database;

/**
 *
 * @author elyes
 */
public class ServiceCategoryFilm implements IService<CategoryFilm> {
     Connection cnx ;
     public ServiceCategoryFilm() {
         cnx = Database.getInstance().getConn();
        
    }

    @Override
    public void add(CategoryFilm t) throws SQLException {
 Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" INSERT INTO categorie_film (id_categorie, nom_categorie) VALUES (" +t.getIdCat()+ ", '"+t.getNomCat()+"' )"; 
    st.executeUpdate(req);    }

 
    public ObservableList<String> readOb() throws SQLException{
    ObservableList<String> oss = FXCollections.observableArrayList();
    Statement st = cnx.createStatement();
    String req = "select CONCAT(id_categorie, '-', nom_categorie) ee from categorie_film";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){

        String nomCat = rs.getString(1);
       
        
        //CategoryFilm cf = new CategoryFilm(idCat,nomCat);
        oss.add(nomCat);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return oss;

    }

    @Override
    public void update(CategoryFilm t) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update categorie_film set nom_categorie = ? where id_categorie= ? ");
        
         pt.setInt(2, t.getIdCat());
        pt.setString(1, t.getNomCat());
        
        pt.executeUpdate(); 


    }

    @Override
    public void delete(CategoryFilm t) throws SQLException {
PreparedStatement pt = cnx.prepareStatement("delete from categorie_film where id_categorie = ?");
        pt.setInt(1, t.getIdCat());
        pt.executeUpdate();        }

    
 
    public ObservableList<CategoryFilm> readobb() throws SQLException{
    ObservableList<CategoryFilm> lss = FXCollections.observableArrayList();
    Statement st = cnx.createStatement();
    String req = "select * from categorie_film";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idCat = rs.getInt("id_categorie");
        String nomCat= rs.getString(2);
       
        
        CategoryFilm cf= new CategoryFilm(idCat,nomCat);
        lss.add(cf);
    
    }
    
    return lss;

    }

    @Override
    public ObservableList<CategoryFilm> read() throws SQLException{
    ObservableList<CategoryFilm> lss = FXCollections.observableArrayList();
    Statement st = cnx.createStatement();
    String req = "select * from categorie_film";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int idCat = rs.getInt("id");
        String nomCat = rs.getString(2);
       
        
        CategoryFilm cf = new CategoryFilm(idCat,nomCat);
        lss.add(cf);
}
    
    return lss;

    }
}