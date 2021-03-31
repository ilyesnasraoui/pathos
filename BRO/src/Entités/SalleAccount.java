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
    private String phone ;
     private String name ;
    private String governorate ;
    private String adress ;

    public SalleAccount(int id_salle, int id, String username, String password, String email, String role,String phone) {
        super(id, username, password, email, role);
        this.id_salle = id_salle;
        this.phone=phone;
    }

    public SalleAccount(int id_salle, String phone, String name, String governorate, String adress, int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
        this.id_salle = id_salle;
        this.phone = phone;
        this.name = name;
        this.governorate = governorate;
        this.adress = adress;
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
    

    
    public SalleAccount() {
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
       
            return "user{" + "id=" + id  + "id_salle=" + id_salle +", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role +'}';

    }

    public SalleAccount(int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
    }

    

    

    

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    
    public int getId_salle() {
        return id_salle;
    }
    
}
