/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CategoryFilm;
import model.Movie;
import services.ServiceCategoryFilm;
import services.ServiceMovie;

/**
 * FXML Controller class
 *
 * @author elyes
 */
public class CategoryController implements Initializable {

    @FXML
    private TableView<CategoryFilm> tabcat;
    @FXML
    private TableColumn<CategoryFilm, Integer> colId;
    @FXML
    private TableColumn<CategoryFilm, String> colNom;
    @FXML
    private TextField txtIdCat;
    @FXML
    private TextField txtNomCat;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showCategory();
            tabcat.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                txtIdCat.setText(String.valueOf(newSelection.getIdCat()));
                txtNomCat.setText(newSelection.getNomCat());
               
                });
            // TODO
        } catch (IOException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void showCategory() throws IOException, SQLException{
        
         ServiceCategoryFilm sc = new ServiceCategoryFilm();
        ObservableList<CategoryFilm> list;
        list = sc.readobb();
        colId.setCellValueFactory(new PropertyValueFactory<CategoryFilm,Integer>("idCat"));
        colNom.setCellValueFactory(new PropertyValueFactory<CategoryFilm,String>("nomCat"));
        
        tabcat.setItems(list);
    
}
    @FXML
    private void addCategoryFilm(ActionEvent event) throws IOException {
        try {
           CategoryFilm cf = new CategoryFilm(Integer.parseInt(txtIdCat.getText()), txtNomCat.getText());
            
            ServiceCategoryFilm sm = new ServiceCategoryFilm();
            
            sm.add(cf);
            showCategory();
                    
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void UpdateCategory(ActionEvent event) throws SQLException, IOException {
        CategoryFilm cf = new CategoryFilm(Integer.parseInt(txtIdCat.getText()), txtNomCat.getText());
            ServiceCategoryFilm sm = new ServiceCategoryFilm();
            
            sm.update(cf);
            showCategory();
    }

    @FXML
    private void deleteCategory(ActionEvent event) throws SQLException, IOException {
        CategoryFilm cf = new CategoryFilm(Integer.parseInt(txtIdCat.getText()), txtNomCat.getText());
            ServiceCategoryFilm sm = new ServiceCategoryFilm();
            sm.delete(cf);
            showCategory();
    }
    
}
