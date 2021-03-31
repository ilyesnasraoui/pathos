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
public class user {
        protected int id;
        protected String username ;
        protected String password ;
        protected String email ;
        protected String role ;

    public user(int id, String username, String password, String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    user(String name, String password, String email) {
        
        this.username = name;
        this.password = password;
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
        
     
        public int getId() {
        return id;
    }
        public String getUsername() {
        return username;
    }
        public String getPassword() {
        return password;
    }
        public String getEmail() {
        return email;
    }
           public void setId(int id) {
        this.id = id;
    }
              public void setUsername(String username) {
        this.username = username;
    }
                 public void setPassword(String password) {
        this.password = password;
    }
                    public void setemail(String email) {
        this.email = email;
    }
                    
      
                     public user()
                     {}

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + '}';
    }
                     

        

    
}
