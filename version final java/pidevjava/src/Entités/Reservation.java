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
public class Reservation {
    int id_planning,id_user;

    public Reservation(int id_planning, int id_user) {
        this.id_planning = id_planning;
        this.id_user = id_user;
    }

    public int getId_planning() {
        return id_planning;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_planning(int id_planning) {
        this.id_planning = id_planning;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_planning=" + id_planning + ", id_user=" + id_user + '}';
    }
    
    
}
