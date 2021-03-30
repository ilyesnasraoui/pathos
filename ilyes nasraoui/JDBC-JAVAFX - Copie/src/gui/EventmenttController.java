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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import Entités.MyListener;
import Entités.Evenement;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author ilyes
 */
public class EventmenttController implements Initializable {

    @FXML
    private ImageView imgev;
    @FXML
    private Label nameev;
    @FXML
    private Label dateev;
    @FXML
    private Label dureeev;
    @FXML
    private TextArea descev;
    @FXML
    private Button fasakh;
    @FXML
    private Label ididid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Evenement evenement;
    private MyListener myListener;
    
    
   /* private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(evenement);
    }*/
    
    public void setData(Evenement evenement, MyListener myListenerr) {
        this.evenement = evenement;
        this.myListener = myListenerr;
        nameev.setText(evenement.getNom_evenement());
        dateev.setText(evenement.getDate_evenement());
        descev.setText(evenement.getDescription());
        dureeev.setText(""+evenement.getDuree_evenement());
        Image image = new Image(evenement.getImage_evnement());
        imgev.setImage(image);
       
    
    }

    

    

    
    
    
}
