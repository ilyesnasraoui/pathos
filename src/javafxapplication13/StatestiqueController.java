/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication13;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author starinfo
 */
public class StatestiqueController implements Initializable {

     @FXML
    private PieChart stat;
    
    
     
    ObservableList<PieChart.Data> piechartdata;
 
  
    Connection cnx;
    ResultSet rs;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            loadDataPie();
        } catch (SQLException ex) {
            Logger.getLogger(StatestiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stat.setData(piechartdata);
       
    }    
    public void loadDataPie() throws SQLException{
        int i=0;
        int j=0;
        piechartdata = FXCollections.observableArrayList();
        String dbUsername = "root";
        String dbPassword = "";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/filmouk";
        
  
        
        cnx = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        PreparedStatement pst = cnx.prepareStatement("SELECT * from avis");
        rs=pst.executeQuery();
        
        while(rs.next()){
            if(rs.getString("type_avis").equals("like"))
            {
                i++;
                
            }
           if(rs.getString("type_avis").equals("dislike"))
            {
                j++;
                
            }
                            
        } 
        piechartdata.add(new PieChart.Data("like",i));
        piechartdata.add(new PieChart.Data("dislike",j));
    }
 


    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/JavaFXApplication13/AVIS.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    
}
