/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Wissem
 */
public class FXMLPersonneController implements Initializable {

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
    private TableColumn<?, ?> colidevent1;
    @FXML
    private TableColumn<?, ?> colidtitre1;
    @FXML
    private TableColumn<?, ?> colcontenu1;
    @FXML
    private Button btnajouter;
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
    }

    @FXML
    private void updateuser(ActionEvent event) {
    }

    @FXML
    private void ajouterpersonne(ActionEvent event) {
    }
    
}
