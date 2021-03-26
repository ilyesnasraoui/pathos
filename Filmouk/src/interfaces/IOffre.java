/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import interfaces.IOffre;
import entities.Offre;
import java.util.Date;

/**
 *
 * @author nassim
 */
public interface IOffre<T> {  
    public void ajouterOffre(T t);
    public void modifierOffre(T t);
    public void supprimerOffre(int t);
    public List<T> afficherOffre();   
    
    public List<T> offresDuJour(T t);
      public List<T> offreUser(int t);
    
}
