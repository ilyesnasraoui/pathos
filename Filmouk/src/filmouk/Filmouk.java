/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmouk;

import entities.Candidature;
import entities.Offre;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.CandidatureService;
import services.OffreService;

/**
 *
 * @author nassim
 */
public class Filmouk extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
        Parent root;
        try {
          //  root = FXMLLoader.load(getClass().getResource("/gui/OffreUserInter.fxml"));
             root = FXMLLoader.load(getClass().getResource("/gui/CandidatureUserInter.fxml"));
            Scene scene = new Scene(root, 630, 500);
            primaryStage.setTitle("Test");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }



       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
       
       // TEST CRUD CANDIDATURE 
         Candidature candidature = new Candidature(1,10,100,new Date(),"second");
          CandidatureService cs = new CandidatureService();
          Offre offre = new Offre(new Date(),"zedfjhsjdfhsjdf");
          OffreService os = new OffreService();
         // os.ajouterOffre(offre);
  //       cs.ajouterCandidature(candidature);
     //  cs.supprimerCandidature(candidature.getId_candidature());
       // candidature.setDescription("Wrong");
       // cs.modifierCandidature(candidature);
       //  System.out.println(cs.afficherCandidature());
       
       //TEST OTHERS 
    //    System.out.println(cs.candoff(candidature.getId_user()));
        
       
       //TEST CRUD OFFRE 
         // Offre offre = new Offre(1,1,new Date(),"descoff");
         //OffreService os = new OffreService();
       // os.ajouterOffre(offre);
       //   offre.setDescription("offmodif");
       //  os.modifierOffre(offre);
       //    System.out.println(os.afficherOffre());  
        // os.supprimerOffre(offre.getId_offre());
        
       // TEST OTHERS
       
      //  System.out.println(os.offresDuJour(offre)); 
      //  System.out.println(os.offreUser(offre.getId_user()));
      
       
      
    }
    
}
