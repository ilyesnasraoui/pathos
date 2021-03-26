/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author nassim
 */
public interface ICandidature <T>{
    public void ajouterCandidature(T t);
    public void modifierCandidature(T t);
    public void supprimerCandidature(int t);
    public List<T> afficherCandidature();    
    
    public List<T> candoff(int t);
}
