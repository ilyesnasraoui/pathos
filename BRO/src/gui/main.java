/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import static Entités.sendMail.sendMail;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class main extends Application {
public static void main(String[] args) {
    Application.launch(main.class, args);
}
    static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        
       
    main.stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLauthentification.fxml"));
        stage.setTitle("Filmouk");
        stage.setScene(new Scene(root));
        stage.show();
    }
}