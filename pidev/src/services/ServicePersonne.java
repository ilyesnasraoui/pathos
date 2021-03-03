/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.Personne;
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
 * @author JAIDI
 */
public class ServicePersonne implements IService<Personne>{
 Connection cnx ;
    public ServicePersonne() {
         cnx = Database.getInstance().getConn();
        
    }

    
    
    
    @Override
    public void add(Personne p) throws SQLException{
        
        Statement st = cnx.createStatement();
    //    String req = "insert into personne values ("+p.getId()+" , " +p.getNom()+ ", " +p.getPrenom() +")";
          String req =" insert into personne (id, nom , prenom) values (" +p.getId()+ ", '"+p.getNom()+" ' , '"+p.getPrenom() +"' )"; 
    st.executeUpdate(req);



    }

    @Override
    public List<Personne> read() throws SQLException{
    List<Personne> ls = new ArrayList<Personne>();
    Statement st = cnx.createStatement();
    String req = "select * from personne";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){
        int id = rs.getInt("id");
        String nom = rs.getString(2);
        String prenom = rs.getString(3);
        
        Personne p = new Personne(id, nom, prenom);
        ls.add(p);
      //  System.out.println( id + ", " + nom + ", " + prenom);
    }
    
    return ls;

    }

    @Override
    public void update(Personne p) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("update personne set nom = ? where id = ? ");
        pt.setString(1, "Axel");
        pt.setInt(2, p.getId());
        pt.executeUpdate(); 


    }

    @Override
    public void delete(Personne p) throws SQLException {
        PreparedStatement pt = cnx.prepareStatement("delete from personne where id = ?");
        pt.setInt(1, p.getId());
        pt.executeUpdate();    }
    
}
