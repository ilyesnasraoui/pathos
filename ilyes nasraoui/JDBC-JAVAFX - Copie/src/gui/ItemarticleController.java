/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Article;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import Entités.MyListener;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ilyes
 */
public class ItemarticleController implements Initializable {

    @FXML
    private Label titretitre;
    @FXML
    private TextArea contenucontenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Initializes the controller class.
     */
    
    private MyListener myListener;
    private Article article;
    
    
    
    
    
    
    public void setDataarticle(Article article, MyListener myListener) {
        this.article = article;
        this.myListener = myListener;
        titretitre.setText(article.getTitre());
        contenucontenu.setText(article.getContenu());
       
    
    }
    
    
    
}

