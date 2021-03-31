/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author elyes
 */
public class CategoryFilm {

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public CategoryFilm(int idCat, String nomCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
    }
    
    int idCat;
    String nomCat;
    
}
