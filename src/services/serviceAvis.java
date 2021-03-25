
package services;
import IntService.IserviceAvis;
import model.Movie;
import model.avis;
import utils.Database;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class serviceAvis implements IserviceAvis {
   Connection cnx;

    public serviceAvis() {
        cnx = Database.getInstance().getConn();
    }
    
     @Override
    public List<Movie> afficherService() throws SQLException {
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
    
     public ObservableList<Movie> getEventsList()
   {
       ObservableList<Movie> list = FXCollections.observableArrayList();
       String query = "SELECT * from produit";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
         
           
       
           while (rst.next())
            {
          int idFilm = rst.getInt(1);
        int idCat = rst.getInt(2);
        String language = rst.getString(3);
        String nom = rst.getString(4);
        int duree = rst.getInt(5);
        String image = rst.getString(6);
        String desc = rst.getString(7);
       
       //INSERT INTO `film` (`id_film`, `id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`) VALUES 
        Movie m = new Movie(idFilm, duree, idCat, nom, desc, image, desc);
        list.add(m);
           
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return list;
       
   }
     
     
     
     
     //aviiiiiiiis
     
    @Override
    public void ajouterAvis(avis a) {
        try {
               
              
            Statement stm = cnx.createStatement();
            String query = "INSERT INTO `avis`(`type_avis`, `id_produit`) VALUES ('"+a.getType_avis()+"',"+a.getId_produit()+")";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerAvis(avis a) {
        try {
            Statement stm = cnx.createStatement();
            String query = "DELETE FROM `avis` WHERE id_avis="+a.getId_avis()+"";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<avis> afficherAvis() throws SQLException {
         Statement stm = cnx.createStatement();
            String query = "SELECT * FROM `avis`";
            ResultSet rst = stm.executeQuery(query);
            List<avis> avis;
            avis = new ArrayList<>();
            while (rst.next())
            {
                avis av = new avis();
                av.setId_avis(rst.getInt("id_avis"));
                av.setType_avis(rst.getString("type_avis"));
                av.setId_produit(rst.getInt("id_produit"));
                avis.add(av);
            }
        return avis;
    }
    
    public ObservableList<avis> getEventsList1()
   {
       ObservableList<avis> list = FXCollections.observableArrayList();
       String query = "SELECT * from avis";
       Statement stm ;
       ResultSet rst;
       try{
           stm = cnx.createStatement();
           rst = stm.executeQuery(query);
           serviceAvis services;
           
       
           while (rst.next())
            {
                avis av = new avis();
                av.setId_avis(rst.getInt("id_avis"));
                av.setType_avis(rst.getString("type_avis"));
                av.setId_produit(rst.getInt("id_produit"));
                list.add(av);
            
       }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
        return list;
       
   }

    @Override
    public void modifierAvis(avis a) {
        
       try {
           Statement stm = cnx.createStatement();
           String query = "UPDATE  avis  set type_avis = '"+a.getType_avis()+"' WHERE id_avis = "+a.getId_avis()+" ;";
           stm.executeUpdate(query);
       } catch (SQLException ex) {
           Logger.getLogger(serviceAvis.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       
    }

    
    
   

    
}
