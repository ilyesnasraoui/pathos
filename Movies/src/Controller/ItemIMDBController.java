/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.MyListener;
import model.Movie;

/**
 * FXML Controller class
 *
 * @author elyes
 */
public class ItemIMDBController {
@FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;
    /**
     * Initializes the controller class.
     */
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
    }

}
