/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;
import main.MyListener;
import Entités.Movie;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import Entités.CategoryFilm;
import Entités.Rate;
import javafx.scene.web.WebView;
import org.controlsfx.control.Rating;
import services.ServiceMovie;
import services.ServiceCategoryFilm;
import services.API;
import services.ServiceRate;

/**
 * FXML Controller class
 *
 * @author elyes
 */
public class UserMarketController implements Initializable {

    private List<Movie> movies = new ArrayList<>();
    private Image image;

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
    private Movie movie;
    @FXML
    private ImageView banner;
    @FXML
    private ImageView imageFilm;
    @FXML
    private Text title;
    @FXML
    private Text desc;
    @FXML
    private Button saveRate;
    @FXML
    private Rating ratee;
    @FXML
    private Tab tab2;
    @FXML
    private TabPane tabpane;
    @FXML
    private ScrollPane scroll1;
    @FXML
    private GridPane gridSimilarMovies;
    @FXML
    private Button trailer;
    @FXML
    private ScrollPane scrolltren;
    @FXML
    private GridPane gridtren;
    @FXML
    private WebView viewweb;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            myListener = new MyListener() {
                @Override
                public void onClickListener(Movie movie) {
                    setChosenMovie(movie);

                }
            };

            showMovies();
           // showTrenMovies();

        } catch (IOException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMovies() throws IOException {

        grid.getChildren().clear();
        movies.clear();
        ServiceMovie sm = new ServiceMovie();

        try {
            movies = sm.read();
        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int column = 0;
        int row = 1;
        //local movies
        int i = 0;
        try {
            for (i = 0; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);

                if (column == 7) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //imdb movies
        API api = null;
        try {
            api = new API("justice");
            movies.addAll(api.getMovie());
        } catch (InterruptedException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemIMDB.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);

                if (column == 7) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //end imdb movies loader
    }
    
    public void showTrenMovies() throws IOException {

        grid.getChildren().clear();
        movies.clear();
        ServiceMovie sm = new ServiceMovie();

        try {
            movies = sm.read();
        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int column = 0;
        int row = 1;
        //local movies
        
        //imdb movies
        List<Movie> trenMovies = new ArrayList<>();
    trenMovies=API.getTrendingMovies();
   //show movies
        gridtren.getChildren().clear();
        
       
        int i = 0;
        try {
            for (i = 0; i < trenMovies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(trenMovies.get(i), myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                gridtren.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridtren.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridtren.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridtren.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridtren.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridtren.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridtren.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //end imdb movies loader
    }

    private void setChosenMovie(Movie movie) {
        
        //filmPriceLabel.setText(movie.getLang());
        this.movie=movie;
        title.setText(movie.getNom());
        desc.setText(movie.getDesc());
        image = new Image(movie.getImgUrl());
        imageFilm.setImage(image);
tabpane.getSelectionModel().selectNext();

//https://api.themoviedb.org/3/movie/791373/similar?api_key=ba9007874ae1b197d4fa0574fabba170&language=fr&query=justice&page=1&include_adult=false&fbclid=IwAR1wn0SzcqYGtmcmrT5r-ZvQOqRhpGVDkRVOxyqVGujBuhEvX3eQtvDBio4
    List<Movie> similarMovies = new ArrayList<>();
    similarMovies=API.getSimilarMovies(movie.getIdFilm());
   //show movies
        gridSimilarMovies.getChildren().clear();
        
        int column = 0;
        int row = 1;
        int i = 0;
        try {
            for (i = 0; i < similarMovies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(similarMovies.get(i), myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                gridSimilarMovies.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridSimilarMovies.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridSimilarMovies.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridSimilarMovies.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridSimilarMovies.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridSimilarMovies.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridSimilarMovies.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveRate(ActionEvent event) {
        System.out.println(ratee.getRating());
        try { 
            int note=(int) ratee.getRating()*2;
            //id 1 this task depend on login to change id 
            Rate rateActuelMovie = new Rate(1, movie.getIdFilm(), note);
            ServiceRate sr = new ServiceRate();
            sr.add(rateActuelMovie);

        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openTrailer(ActionEvent event) throws IOException 
                       
    { 
        
        
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/gui/ytrailer.fxml")));
               
                WebView webview = fxmlLoader.load();
                
                
    WebEngine engine= webview.getEngine();
    
    engine.load("https://www.youtube.com/embed/gs-ODufnJ8Y");
                
                Stage stage= new Stage();
                
                stage.setScene(new Scene(webview));
                stage.show();
               
        
    /*    WebView webview = new WebView();
    WebEngine engine= webview.getEngine();
    
    engine.load("https://www.youtube.com/embed/gs-ODufnJ8Y");
    VBox root= new VBox();
    root.getChildren().addAll(webview);
    
  Scene scene= new Scene(root,800,500);
  stage.setScene(scene);
  stage.show(); */
        
    
}}
