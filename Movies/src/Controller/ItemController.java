package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import model.Movie;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

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
        //System.out.println(movie.getImgUrl());
        img.setImage(image);
    }
}
