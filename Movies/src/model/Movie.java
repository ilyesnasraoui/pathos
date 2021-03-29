/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Movie {
    private int idFilm,duree,idCat;
    private String nom, lang,imgUrl,desc;

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Movie(int idFilm, int duree, int idCat, String nom, String lang, String imgUrl, String desc) {
        this.idFilm = idFilm;
        this.duree = duree;
        this.idCat = idCat;
        this.nom = nom;
        this.lang = lang;
        this.imgUrl = imgUrl;
        this.desc = desc;
    }
    

    

    public Movie() {
    }

    public Movie(int id, String nom, String lang,String url) {
        this.idFilm = id;
        this.nom = nom;
        this.lang = lang;
        this.imgUrl=url;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + idFilm + ", nom=" + nom + ", lang=" + lang + ", desc=" + desc +", imgurl=" + imgUrl +'}';
    }
    
    

}
