/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.avis;
import services.serviceAvis;

/**
 * FXML Controller class
 *
 * @author starinfo
 */
public class AVISController implements Initializable {

     @FXML
    private TextField txtid_service;
    @FXML
    private TitledPane titlepane2;
    @FXML
    private TableView<avis> avis;
    @FXML
    private TableColumn<avis, Integer> colida;
    @FXML
    private TableColumn<avis, Integer> colids;
    @FXML
    private TableColumn<avis, String> colavis;
    private int idproduit=0;
    private int idavis=0;
    @FXML
    private Button chart;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             afficherAvis();
        PrintWriter outputstream = null;
        
        titlepane2.setExpanded(false);
        // TODO
    }    
     public void afficherAvis() {
        serviceAvis se = new serviceAvis();
        ObservableList<avis> list  = se.getEventsList1();
        colida.setCellValueFactory(new PropertyValueFactory<avis,Integer>("id_avis"));
        colids.setCellValueFactory(new PropertyValueFactory<avis,Integer>("id_produit"));
        colavis.setCellValueFactory(new PropertyValueFactory<avis,String>("type_avis"));
        
        avis.setItems(list);
    }
    

    @FXML
    private void handleMouseButton1(MouseEvent event) {
         avis s = avis.getSelectionModel().getSelectedItem();
        String id = Integer.toString(s.getId_avis());
        idavis=s.getId_avis();
    }


    @FXML
    private void ajouterRating(MouseEvent event) {
    }

    @FXML
    private void charger(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxapplication13/Statestique.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    
}
