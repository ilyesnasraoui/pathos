/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntService;
import model.Movie;
import model.avis;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author USER
 */
public interface IserviceAvis {
public List<Movie> afficherService()throws SQLException;
public void ajouterAvis(avis a);
public void supprimerAvis(avis a);
public List<avis> afficherAvis()throws SQLException;
public void modifierAvis(avis a);

    
}
