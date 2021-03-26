/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Planning;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ServicePlanning;

/**
 * FXML Controller class
 *
 * @author Wissem
 */
public class FXMLPlanningController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label filmname;
    @FXML
    private Label filmcategory;
    @FXML
    private Label filmduration;
    @FXML
    private Label projectiondate;
    @FXML
    private Label governorate;
    @FXML
    private Label projectiontime;
    @FXML
    private Label adress;
    @FXML
    private Label places;
    @FXML
    private Button deleteplanning;
    private Planning planning;
    private MyListener MyListener;
    @FXML
    private AnchorPane anchorpaneplanning;
    @FXML
    private Label id;
    public String u ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setVisible(false);
    }

public void setData(Planning p, MyListener myListener) throws SQLException {
        this.planning = p;
        ServicePlanning sp= new ServicePlanning();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.MyListener = myListener;
        filmname.setText(sp.getNameFilmById(p.getId_film()));
        filmcategory.setText(sp.getNameCategoryById(sp.getIdCategoryByIdFilm(p.getId_film())));
        filmduration.setText(sp.getDurationByIdFilm(p.getId_film()));
        projectiondate.setText((p.getDate()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        projectiontime.setText(p.getProjection_time());
        id.setText(String.valueOf(p.getId_planning()));
        places.setText(String.valueOf(p.getPlaces()));

 
    }

    @FXML
    private void fill(MouseEvent event) {
       
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        ServicePlanning sp = new ServicePlanning();
        Planning p= new Planning(Integer.parseInt(id.getText()));
        sp.delete(p);
    }
        
    
}
