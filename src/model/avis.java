/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class avis {
    private int id_avis;
    private String type_avis;
    private int id_produit;

    public avis() {
    }

    public avis(int id_avis, String type_avis, int id_commentaire) {
        this.id_avis = id_avis;
        this.type_avis = type_avis;
        
    }

    public avis(String type_avis) {
        this.type_avis = type_avis;
        
    }

    /**
     * @return the id_avis
     */
    public int getId_avis() {
        return id_avis;
    }

    /**
     * @return the type_avis
     */
    public String getType_avis() {
        return type_avis;
    }

    /**
     * @param type_avis the type_avis to set
     */
    public void setType_avis(String type_avis) {
        this.type_avis = type_avis;
    }

  

    /**
     * @return the id_produit
     */
    public int getId_produit() {
        return id_produit;
    }

    /**
     * @param id_produit the id_produit to set
     */
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    
    
    
    
}
