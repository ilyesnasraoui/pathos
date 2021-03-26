/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Offre;
import interfaces.IOffre;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.DataSource;

/**
 *
 * @author nassim
 */
public class OffreService implements IOffre<Offre>{

    @Override
    public void ajouterOffre(Offre t) {
        try {
            System.out.println("Offre Service" +t);
            String req = "INSERT INTO `offre`(`id_user`, `date`, `description`) VALUES (?,?,?)";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(req) ;
             st.setInt(1, t.getId_user());
             st.setDate(2, new Date(t.getDate().getTime()));
             System.out.println(new Date(t.getDate().getTime()));
             st.setString(3, t.getDescription());
         
             st.executeUpdate();            
            System.out.println("ajout avec succes Offre");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }

    @Override
    public void modifierOffre(Offre t) {
        
        try {
            String requete = "UPDATE Offre SET date=?,description=? WHERE id_offre=?";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
        
            st.setDate(1,new Date(t.getDate().getTime()));
            st.setString(2, t.getDescription());
            st.setInt(3,t.getId_offre());
            
            st.executeUpdate();
            System.out.println("Offre modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   }

    @Override
    public void supprimerOffre(int t) {
           try {
            String requete = "DELETE FROM offre where id_offre=?";
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(requete) ;
            pst.setInt(1,t);
            pst.executeUpdate();
            System.out.println("offre supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public List<Offre> afficherOffre() {
        
        List<Offre> offreList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM offre";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                Offre of = new Offre();
                of.setId_offre(rs.getInt("id_offre"));
                of.setId_user(rs.getInt("id_user"));
                of.setDate(rs.getDate("date"));
                of.setDescription(rs.getString("description"));
                offreList.add(of);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return offreList;

    }

    @Override
    public List<Offre> offresDuJour(Offre t) {
        List<Offre> offreJourList = new ArrayList<>();
          try {
     String requete = "SELECT * FROM offre where Date="+t+";";
           
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
             ResultSet rst =  st.executeQuery(requete);
           //  java.sql.Date sqlDate = new java.sql.Date(date.getTime());
           java.sql.Date sqlDate;
            // sqlDate = java.sql.Date.valueOf(t.getDate());
             st.setDate(1,new Date(t.getDate().getTime()));
             while(rst.next()){
                 Offre ofr=new Offre();
                 ofr.setId_offre(rst.getInt("id_offre"));
                 ofr.setId_user(rst.getInt("id_user"));
                 ofr.setDescription(rst.getString("description"));
             }
                   } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
    
        return offreJourList;
    }

    @Override
    public List<Offre> offreUser(int t) {
        
        List<Offre> offreUserList = new ArrayList<>();
        try {
            String requete = "Select * FROM offre where id_user= "+t+"; ";
            PreparedStatement st = DataSource.getInstance().getConnection().prepareStatement(requete) ;
              
            ResultSet rslt =  st.executeQuery(requete);
        
            while(rslt.next()){
                Offre ofru = new Offre();
                ofru.setId_offre(rslt.getInt("id_offre"));
                ofru.setId_user(rslt.getInt("id_user"));
                ofru.setDate(rslt.getDate("date"));
                ofru.setDescription(rslt.getString("description"));
                offreUserList.add(ofru);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return offreUserList;

    }
    
    public static ObservableList<Offre> getAll(){
        ObservableList<Offre> list = FXCollections.observableArrayList();
        try {
            String requete= "SELECT * FROM `offre` WHERE 1";
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(requete);
            ResultSet res = pst.executeQuery(requete);
            Offre offre = null;
            while (res.next()) {
                offre = new Offre(res.getInt(1),res.getInt(2),res.getDate(3), res.getString(4));
                list.add(offre);

            }
        } catch (Exception e) {
        }
        return list;
    }
    public  ObservableList<Offre> chercherOffre(java.util.Date date){
        ObservableList<Offre> list = FXCollections.observableArrayList();
        Date d = new Date(date.getTime());
        System.out.println(new Date(date.getTime()));
        String str = ""+d ;
        System.out.println(str);
        String str1 =str.substring(0, 4);
        String str2 =str.substring(5, 7);
        String str3 =str.substring(8, 10);
        System.out.println(str1+"Aaaaa" + str2 +"Aaaaa"+ str3);
        
        try {
            String requete= "SELECT * FROM offre WHERE date = '"+str+"'";
           // System.out.println(requete);
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(requete);
            ResultSet res = pst.executeQuery(requete);
            Offre offre = null;
            while (res.next()) {
                offre = new Offre(res.getInt(1),res.getInt(2),res.getDate(3), res.getString(4));
                //System.out.println(offre);
                list.add(offre);

            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
}
