/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author ilyes
 */
public class Categorie_event {
    private int id_cat_event;
    private String nom_categorie_ev, description;

    public Categorie_event(int id_cat_event, String nom_categorie_ev, String description) {
        this.id_cat_event = id_cat_event;
        this.nom_categorie_ev = nom_categorie_ev;
        this.description = description;
    }

    public Categorie_event() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Categorie_event(String nom_categorie_ev, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_cat_event() {
        return id_cat_event;
    }

    public String getNom_categorie_ev() {
        return nom_categorie_ev;
    }

    public String getDescription() {
        return description;
    }

    public void setId_cat_event(int id_cat_event) {
        this.id_cat_event = id_cat_event;
    }

    public void setNom_categorie_ev(String nom_categorie_ev) {
        this.nom_categorie_ev = nom_categorie_ev;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
   
}
