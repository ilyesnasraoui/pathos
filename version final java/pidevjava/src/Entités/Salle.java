/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author Wissem
 */
public class Salle {
    private int id_salle;
    private String name ;
    private String governorate ;
    private String adress ;

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public Salle(int id_salle, String name, String governorate, String adress) {
        this.id_salle = id_salle;
        this.name = name;
        this.governorate = governorate;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Salle{" + "id_salle=" + id_salle + ", name=" + name + ", governorate=" + governorate + ", adress=" + adress + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getGovernorate() {
        return governorate;
    }

    public String getAdress() {
        return adress;
    }
       
}
