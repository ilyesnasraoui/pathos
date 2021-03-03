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
public class Person extends user {
    private String fname,lname,idcard,phone;
    private int role,id_person;

    public Person(String fname, String lname, String idcard, int role,  int id, String username, String password, String email,String phone) {
        super(id, username, password, email);
        this.fname = fname;
        this.lname = lname;
        this.idcard = idcard;
        this.role = role;
        this.phone = phone;
       
    }
    @Override
    public String toString() {
        return "Person{fname=" + fname + ", lname=" + lname+ ", username=" + username+ ", email=" + email + ", idcard=" + idcard + ", phone=" + phone + ", role=" + role  + '}';
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getPhone() {
        return phone;
    }

    public int getRole() {
        return role;
    }

    public int getId_person() {
        return id_person;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }
    
}
