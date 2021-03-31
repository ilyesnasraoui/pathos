/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author elyes
 */
public class ytrailer implements Initializable 
{

    @FXML
    private WebView viewweb;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       WebView webview = new WebView();
    WebEngine engine= webview.getEngine();
    
    engine.load("https://www.youtube.com/embed/gs-ODufnJ8Y");
    VBox root= new VBox();
    root.getChildren().addAll(webview);
    
 
  
    }    
    
    
     
    //WebView webview = new WebView();
   // WebEngine engine= webview.getEngine();
    
  /*  engine.load("https://www.youtube.com/embed/gs-ODufnJ8Y");
    VBox root= new VBox();
    root.getChildren().addAll(webview);
    
  Scene scene= new Scene(root,800,500);
  */
  }    
    

