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

    public Person(String fname, String lname, String idcard, String phone, int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
        this.fname = fname;
        this.lname = lname;
        this.idcard = idcard;
        this.phone = phone;
    }

    public Person(int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
    }
    
   

    

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "fname=" + fname + ", lname=" + lname + ", idcard=" + idcard + ", phone=" + phone + ", role=" + role  + '}';
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

   
    
}
