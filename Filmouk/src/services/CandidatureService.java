/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ICandidature;
import entities.Candidature;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.DataSource;

/**
 *
 * @author nassim
 */
public class CandidatureService implements ICandidature<Candidature>{

    @Override
    public void ajouterCandidature(Candidature t) {
        
        try {
            String req = "INSERT INTO  `candidature`(`id_user`, `id_offre`,`date`,`description` )VALUES (?,?,?,?)";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(req) ;
             st.setInt(1, t.getId_user());
             st.setInt(2, t.getId_offre());
             st.setDate(3, new Date(t.getDate().getTime()));
             st.setString(4, t.getDescription());
         
             st.executeUpdate();            
            System.out.println("ajout avec succes Candidature");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public void modifierCandidature(Candidature t) {
   
          try {
            String requete = "UPDATE Candidature SET date=?,description=? WHERE id_candidature=?";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
        
            st.setDate(1,new Date(t.getDate().getTime()));
            st.setString(2, t.getDescription());
            st.setInt(3,t.getId_candidature());
            
            st.executeUpdate();
            System.out.println("Candidature modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void supprimerCandidature(int t) {
    try {
            String requete = "DELETE FROM candidature where id_candidature=?";
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(requete) ;
            pst.setInt(1,t);
            pst.executeUpdate();
            System.out.println("Candidature supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Candidature> afficherCandidature() {
       List<Candidature> candidatureList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM candidature";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                Candidature ca = new Candidature();
                ca.setId_candidature(rs.getInt("id_candidature"));
                ca.setId_user(rs.getInt("id_user"));
                ca.setId_offre(rs.getInt("id_offre"));
                ca.setDate(rs.getDate("date"));
                ca.setDescription(rs.getString("description"));
                candidatureList.add(ca);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return candidatureList;
    }

    @Override
    public List<Candidature> candoff(int t) {
        List<Candidature> candoffList = new ArrayList<>();
        try {
            String requete = "Select * FROM candidature where id_user="+t+";";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
              
            ResultSet rslt =  st.executeQuery(requete);
        
            while(rslt.next()){
                Candidature cand = new Candidature();
                cand.setId_offre(rslt.getInt("id_offre"));
                cand.setId_user(rslt.getInt("id_user"));
                cand.setDate(rslt.getDate("date"));
                cand.setDescription(rslt.getString("description"));
                candoffList.add(cand);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return candoffList;}
    public static ObservableList<Candidature> getAll(){
        ObservableList<Candidature> list = FXCollections.observableArrayList();
        try {
            String requete= "SELECT * FROM `candidature` WHERE 1";
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(requete);
            ResultSet res = pst.executeQuery(requete);
            Candidature candidature = null;
            while (res.next()) {
                candidature = new Candidature(res.getInt(1),res.getInt(2),res.getInt(3),res.getDate(4), res.getString(5));
                list.add(candidature);

            }
        } catch (Exception e) {
        }
        return list;
    }
     public  ObservableList<Candidature> chercherCandidature(java.util.Date date){
        ObservableList<Candidature> list = FXCollections.observableArrayList();
        Date d = new Date(date.getTime());
        System.out.println(new Date(date.getTime()));
        String str = ""+d ;
        System.out.println(str);
        String str1 =str.substring(0, 4);
        String str2 =str.substring(5, 7);
        String str3 =str.substring(8, 10);
        System.out.println(str1+"Aaaaa" + str2 +"Aaaaa"+ str3);
        
        try {
            String requete= "SELECT * FROM candidature WHERE date = '"+str+"'";
           // System.out.println(requete);
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(requete);
            ResultSet res = pst.executeQuery(requete);
            Candidature candidature = null;
            while (res.next()) {
                candidature = new Candidature(res.getInt(1),res.getInt(2),res.getInt(3),res.getDate(4), res.getString(5));
                //System.out.println(offre);
                list.add(candidature);

            }
        } catch (Exception e) {
        }
        return list;
    }
    
     
}

  