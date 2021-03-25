package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafxapplication13.Main;
import javafxapplication13.MyListener;
import model.Movie;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.serviceAvis;
import model.avis;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;
    @FXML
    private Button dislike;
    @FXML
    private Button like;
    @FXML
    private ImageView likeicon;
    @FXML
    private ImageView dislikeicon;
    private int idproduit=0;
    private int idavis=0;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(movie);
    }

    private Movie movie;
    private MyListener myListener;

    public void setData(Movie movie, MyListener myListener) {
        this.movie = movie;
        this.myListener = myListener;
        nameLabel.setText(movie.getNom());
        priceLable.setText(movie.getLang());
        Image image = new Image(movie.getImgUrl());
        img.setImage(image);
    }//////////////////
    
    
   

    @FXML
    private void ajouterAvisLike(ActionEvent event) {
    //like.setGraphic(new ImageView("img/like.png"));
      serviceAvis se = new serviceAvis();
        avis ev = new avis();
        
          ev.setType_avis("like");
          ev.setId_produit(idproduit);
         if (idavis == 0) { se.ajouterAvis(ev); 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Succes d ajout");
         alert.setHeaderText(null);
         alert.setContentText("avis ajoute avec succes!");

        alert.showAndWait();}
         
         else {ev.setId_avis(idavis);
             se.modifierAvis(ev);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Succes de modification");
         alert.setHeaderText(null);
         alert.setContentText("avis modifié avec succes!");

         alert.showAndWait();} 
         
    

    
    }

    @FXML
    private void ajouterAvisDislike(ActionEvent event) {
    //dislike.setGraphic(new ImageView("img/dislike.png"));
    serviceAvis se = new serviceAvis();
        avis ev = new avis();
        
          ev.setType_avis("dislike");
          ev.setId_produit(idproduit);
         if (idavis == 0) { se.ajouterAvis(ev); 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Succes d ajout");
         alert.setHeaderText(null);
         alert.setContentText("avis ajoute avec succes!");

        alert.showAndWait();}
         
         else {ev.setId_avis(idavis);
             se.modifierAvis(ev);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Succes de modification");
         alert.setHeaderText(null);
         alert.setContentText("avis modifié avec succes!");

         alert.showAndWait();} 
         
        
         
    }
}
