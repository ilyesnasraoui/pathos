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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import Entités.MyListener;
import Entités.Categorie_event;

/**
 * FXML Controller class
 *
 * @author ilyes
 */
public class EchcatController implements Initializable {

    @FXML
    private Label nommcatt;
    @FXML
    private TextArea dessc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /*private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(categorie_event);
    }*/

    private Categorie_event categorie_event;
    private MyListener myListener;
   
    
    
    public void setData(Categorie_event categorie_event, MyListener myListener) {
        this.categorie_event = categorie_event;
        this.myListener = myListener;
        nommcatt.setText(categorie_event.getNom_categorie_ev());
        dessc.setText(categorie_event.getDescription());
       
    
    }
    
    
    
  
    
    
    
}
