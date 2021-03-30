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
import model.Movie;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.CategoryFilm;
import services.ServiceMovie;
import services.ServiceCategoryFilm;
import services.API;

public class MarketController implements Initializable {

    @FXML
    private VBox chosenFilmCard;
    
    @FXML
    private Label filmNameLable;

    //@FXML
    
    @FXML
    private ImageView filmImg;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private GridPane grid;
    
    private List<Movie> movies = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private TextField tfIdFilm;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfLang;
    @FXML
    private TextField tfDesc;
    @FXML
    private TextField tfRuntime;
    @FXML
    private ComboBox<String> tfCat;
    
    ObservableList<String> list;
    @FXML
    private Button btnInsertImage;
    String urlInserted;
    @FXML
    private TextField rech;
    @FXML
    private Button btnrech;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tflink;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfrated;
    
    
    private void setChosenMovie(Movie movie) {
        filmNameLable.setText(movie.getNom());
        //filmPriceLabel.setText(movie.getLang());
        
        tfIdFilm.setText(String.valueOf(movie.getIdFilm()));
        tfName.setText(movie.getNom());
        tfLang.setText(movie.getLang());
        image = new Image(movie.getImgUrl());
        System.out.println(movie.getImgUrl());
        urlInserted=movie.getImgUrl();
        tfDesc.setText(movie.getDesc());
        tfLang.setText(movie.getLang());
        tfRuntime.setText(String.valueOf(movie.getDuree())); //Integer.parseInt(movie.getDuree())
        tflink.setText(movie.getUtube());
        tfdate.setText(String.valueOf(movie.getDate()));
        tfrated.setText(String.valueOf(movie.getRated()));
        System.out.println(movie.getRated());
        
        filmImg.setImage(image);
        
//        chosenFilmCard.setStyle("-fx-background-color: #d64161 ;\n"
           //     + "    -fx-background-radius: 30;");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            myListener = new MyListener() {
                @Override
                public void onClickListener(Movie movie) {                   
                    setChosenMovie(movie);
                }
            };
            ServiceCategoryFilm sc = new ServiceCategoryFilm();
            
            tfCat.setItems(sc.readOb());
            showMovies();
            
        } catch (IOException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
        if (movies.size() > 0) {
            setChosenMovie(movies.get(0));
            
        }
        int column = 0;
        int row = 1;
        //local movies
        int i=0;
        try {
            for (i = 0; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);
                
                if (column == 3) {
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
                fxmlLoader.setLocation(getClass().getResource("/views/itemIMDB.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);
                
                if (column == 3) {
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
    
    @FXML
    private void addMovie(ActionEvent event) throws IOException {
        try {  //(int idFilm, int duree, int idCat, String nom, String lang, String imgUrl, String desc) 
            
            String arrOfStr = tfCat.getValue().split("-", 2)[0];            
            Movie m = new Movie(Integer.parseInt(tfIdFilm.getText()), Integer.parseInt(tfRuntime.getText()), Integer.parseInt(arrOfStr), tfName.getText(), tfLang.getText(), urlInserted, tfDesc.getText());
            
            ServiceMovie sm = new ServiceMovie();
            
            sm.add(m);
            showMovies();
            
        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//(int idFilm, int duree, int idCat, String nom, String lang, String imgUrl, String desc) 

    @FXML
    private void updateMovie(ActionEvent event) throws SQLException, IOException {
        String arrOfStr = tfCat.getValue().split("-", 2)[0];        
        Movie m = new Movie(Integer.parseInt(tfIdFilm.getText()), Integer.parseInt(tfRuntime.getText()), Integer.parseInt(arrOfStr), tfName.getText(), tfLang.getText(), urlInserted, tfDesc.getText());
        ServiceMovie sm = new ServiceMovie();
        filmNameLable.setText(m.getNom());
        // filmPriceLabel.setText(m.getLang());
        sm.update(m);
        showMovies();
    }
    
    @FXML
    private void deleteMovie(ActionEvent event) throws SQLException, IOException {
        String arrOfStr = tfCat.getValue().split("-", 2)[0];        
        Movie m = new Movie(Integer.parseInt(tfIdFilm.getText()), Integer.parseInt(tfRuntime.getText()), Integer.parseInt(arrOfStr), tfName.getText(), tfLang.getText(), "/img/sepencer.jpg", tfDesc.getText());
        ServiceMovie sm = new ServiceMovie();
        sm.delete(m);
        showMovies();
        
    }
    
    @FXML
    public void uploadImage(ActionEvent event) throws IOException, URISyntaxException {
        FileChooser fc = new FileChooser();
        //fc.setInitialDirectory(" ");
        fc.getExtensionFilters().addAll(new ExtensionFilter("Image files", "*.jpg", "*.png"));
        //--for single file
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            //listView.getItems().add(selectedFile.getAbsolutePath());
            urlInserted = "file:///" + selectedFile.getAbsolutePath();
            btnInsertImage.setText(selectedFile.getAbsolutePath());
            image = new Image(urlInserted);
            
            filmImg.setImage(image);

            //imageView1.setText(selectedFile.getName());
            /*
            Image image1 = new Image(selectedFile.toURI().toString());
            imageView1.setImage(image1);
             */
        } else {
            System.out.println("Not valid file");
        }
        
    }
    

    private void filterMovie(MouseEvent event) {
        grid.getChildren().clear();
        movies.clear();
        ServiceMovie sm = new ServiceMovie();
        try {
            movies = sm.searchMovie(rech.getText());
        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (movies.size() > 0) {
            setChosenMovie(movies.get(0));
            
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);
                
                if (column == 3) {
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
    }

    @FXML
    private void searchMovies(ActionEvent event) {
        System.out.println("clicked");
        grid.getChildren().clear();
        movies.clear();
        ServiceMovie sm = new ServiceMovie();
        try {
            movies = sm.searchMovie(rech.getText());
        } catch (SQLException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (movies.size() > 0) {
            setChosenMovie(movies.get(0));
            
        }
        int column = 0;
        int row = 1;
        int i=0;
        try {
            for (i=0; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);
                
                if (column == 3) {
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
            api = new API(rech.getText());
            movies.addAll(api.getMovie());
        } catch (InterruptedException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
                try {
            for (; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/itemIMDB.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(movies.get(i), myListener);
                
                if (column == 3) {
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

    

}
