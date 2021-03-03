/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Personne;
import Entités.user;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import services.ServicePersonne;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author JAIDI
 */
public class FXMLPersonneController implements Initializable {

    private TextField txfid;
    private TextField txfnom;
    private TextField txfprenom;
    @FXML
    private Button btnajouter;
    @FXML
    private Button adduser;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button updateuser;
    @FXML
    private Button deleteuser;
    @FXML
    private TableColumn<?, ?> colidarticle1;
    @FXML
    private TableColumn<?, ?> colidevent1;
    @FXML
    private TableColumn<?, ?> colidtitre1;
    @FXML
    private TableColumn<?, ?> colcontenu1;
    @FXML
    private TextField txfidarticle;
    @FXML
    private TextField txfnomarticle;
    @FXML
    private TextField txftitre;
    @FXML
    private TextField txfcontenu;
    @FXML
    private Button btnmodifer;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TableColumn<?, ?> colidarticle;
    @FXML
    private TableColumn<?, ?> colidevent;
    @FXML
    private TableColumn<?, ?> colidtitre;
    @FXML
    private TableColumn<?, ?> colcontenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
   
    @FXML
    private void adduser(ActionEvent event) {
        try{
        user p = new user(0,username.getText(), password.getText(), email.getText()); 
        ServiceUser sp = new ServiceUser();
            
            sp.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLPersonneController.class.getName()).log(Level.SEVERE, null, ex);
        
          
            
     }
    }

    @FXML
    private void updateuser(ActionEvent event) {
         try {
            user u=new user(15,username.getText(),password.getText(),email.getText());
            ServiceUser su = new ServiceUser();
            su.update(u);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLPersonneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouterpersonne(ActionEvent event) {
    }
    
}
