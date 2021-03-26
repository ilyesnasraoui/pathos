/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author nassim
 */
public class Offre {

  
     private int id_offre;
     private int id_user;
     private  Date date;
     private String description;

    public Offre() {
    }

    public Offre(Date date, String description) {
        this.date = date;
        this.description = description;
    }
    

    public Offre(int id_offre, int id_user, Date date, String description) {
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.date = date;
        this.description = description;
    }



    public int getId_offre() {
        return id_offre;
    }
    
    public int getId_user() {
        return id_user;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", id_user=" + id_user + ", date=" + date + ", description=" + description + '}';
    }
    
}
