/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entités.user;
import Intservice.IFacebook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database;

/**
 *
 * @author Wissem
 */
public class ServiceFacebook implements IFacebook{
    Connection cnx;
    public ServiceFacebook() {
         cnx = Database.getInstance().getConn();
       
    }
    
    Statement ste;
    PreparedStatement prepste;

    @Override
    public boolean InscriptionFB(user u) {
        ServiceUser su= new ServiceUser();
        try {
            if (su.checkexistance(u.getUsername())==0)
            {
                String ps="INSERT INTO `users` ( `username`, `password`, `email`, `id_salle`, `fname`, `lname`, `idcard`, `phone`, `role`, `blocked`)"
                        + " VALUES ('"+u.getUsername()+"', 'test','"+u.getEmail()+"', NULL, NULL, NULL, NULL, NULL, 'client', '0');";
                System.out.println("dkhal");
                
                
                
                
                prepste = cnx.prepareStatement(ps);
                
                
                prepste.executeUpdate(ps);
            }
           
        

            return true;
      
} catch (SQLException ex) {
            Logger.getLogger(ServiceFacebook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;

    }
    
}
