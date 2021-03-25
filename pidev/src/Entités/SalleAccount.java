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
public class SalleAccount extends user {
    private int id_salle;

    public SalleAccount( int id_salle, int id, String username, String password, String email) {
        super(id, username, password, email);
      //  this.id_salleaccount = id_salleaccount;
        this.id_salle = id_salle;
    }

    @Override
    public String toString() {
        return "SalleAccount{" + "id_salleaccount=" + id + ", id_salle=" + id_salle + '}';
    }

    

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    
    public int getId_salle() {
        return id_salle;
    }
    
}
