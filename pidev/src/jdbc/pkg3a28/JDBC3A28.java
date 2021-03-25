/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.pkg3a28;

import Entités.Person;
import Entités.Personne;
import Entités.Planning;
import Entités.Salle;
import Entités.SalleAccount;
import Entités.user;
import java.beans.PersistenceDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServicePerson;
import services.ServicePersonne;
import services.ServicePlanning;
import services.ServiceSalle;
import services.ServiceSalleAccount;
import services.ServiceUser;

/**
 *
 * @author JAIDI
 */
public class JDBC3A28 {

    /**
     * @param args the command line arguments
     */   
    
  /*  private static String url ="jdbc:mysql://localhost:3306/mydb";
    private static String user ="user1";
    private static String pwd ="user1";
    //start test users
*/
    public static void main(String[] args) {
        
        try {
            /*user u= new user(4,"add","add","add");
            user u1= new user(23,"updated","updated","updated");
            user u2 = new user(11,"todelete","todelete","todelete");
            // System.out.println(u);
            
            ServiceUser su= new ServiceUser();
            
            try {
            
            su.add(u);
            System.out.println(" ***** affichage ************");
            List<user> l = new ArrayList<user>();
            l = su.read();
            for( user uu : l){
            System.out.println(uu.toString());
            
            }
            
            System.out.println(" ***** modification ************");
            su.update(u1);
            l=su.read();
            for( user uu : l){
            System.out.println(uu.toString());
            
            }
            
            
            System.out.println(" ***** supp ************");
            su.delete(u1);
            l=su.read();
            for( user uu : l){
            System.out.println(uu.toString());
            
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(JDBC3A28.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
//end bloc test users
        
// start test salle
/*
ServiceSalle ss= new ServiceSalle();
Salle s= new Salle(4,"add","add","add");
Salle s1=new Salle(5,"updated","updated","updated");


try {

ss.add(s);
System.out.println(" ***** affichage ************");
List<Salle> l = new ArrayList<Salle>();
l = ss.read();
for( Salle uu : l){
System.out.println(uu.toString());

}

System.out.println(" ***** modification ************");
ss.update(s1);

l=ss.read();
for( Salle uu : l){
System.out.println(uu.toString());

}


System.out.println(" ***** supp ************");
ss.delete(s1);
l=ss.read();
for( Salle uu : l){
System.out.println(uu.toString());

}

} catch (SQLException ex) {
Logger.getLogger(JDBC3A28.class.getName()).log(Level.SEVERE, null, ex);
}
*/
//end test salle
/*try{
Person u= new Person("aaa","add","add",2,32,"aaa","aaa","aaa","aa");
ServicePerson sp= new ServicePerson();
sp.add(u);
List<Person> l = new ArrayList<Person>();
l = sp.read();
for( user uu : l){
System.out.println(uu.toString());

}
sp.delete(u);
} catch (SQLException ex) {
Logger.getLogger(JDBC3A28.class.getName()).log(Level.SEVERE, null, ex);
}*/
SalleAccount s= new SalleAccount(4,4,"baba","baba","baba");
ServiceSalleAccount ssa= new ServiceSalleAccount();
Planning p= new Planning(3,3,3,3,3,3,3,"2h30");
ServicePlanning sp= new ServicePlanning();
sp.update(p);
List<Planning> l = new ArrayList<Planning>();
l = sp.read();
for( Planning pp : l){
System.out.println(pp.toString());
}
//ssa.add(s);
   


ServiceUser u= new ServiceUser();
u.authentification("baba","baba");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC3A28.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
