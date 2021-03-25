/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author JAIDI
 */
public class FXMLResultatController implements Initializable {

    @FXML
    private Label lbid;
    @FXML
    private Label lbnom;
    @FXML
    private Label lbprenom;

    public void setLbid(String id) {
        this.lbid.setText(id);
    }

    public void setLbnom(String nom) {
        this.lbnom.setText(nom);
    }

    public void setLbprenom(String prenom) {
        this.lbprenom .setText(prenom);
    }

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
