/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


    import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class VideoPlayer extends Application {    
  public static void main(String[] args) { launch(args); }

  @Override public void start(Stage stage) throws Exception {
    WebView webview = new WebView();
    WebEngine engine= webview.getEngine();
    
    engine.load("https://www.youtube.com/embed/gs-ODufnJ8Y");
    VBox root= new VBox();
    root.getChildren().addAll(webview);
    
  Scene scene= new Scene(root,800,500);
  stage.setScene(scene);
  stage.show();
  }    
}
