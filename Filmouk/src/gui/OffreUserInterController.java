/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Offre;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.OffreService;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import java.net.URL;

/**
 *
 * @author nassim
 */
public class OffreUserInterController implements Initializable {

    @FXML
    private TextArea description;
    @FXML
    private DatePicker datee;
    @FXML
    private Button addoff;
    @FXML
    private Button modifoff;
    @FXML
    private Button deleteoff;
    @FXML
    private TableView<Offre> tableoffer;
    @FXML
    private TableColumn<Offre, String> odate;
    @FXML
    private TableColumn<Offre, String> odesc;
    OffreService os = new OffreService();
    private ObservableList<entities.Offre> listOffres;
    private Offre offre ;
    @FXML
    private DatePicker dpChercher;
    @FXML
    private Button tfChercher;
    
    private Stage primaryStage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable();
        tableoffer.setOnMouseClicked((MouseEvent event) -> {
    if (event.getClickCount() > 1) {
        onEdit();
    }
});
    }  
    private void onEdit() {
            // check the table's selected item and get selected item
         if (tableoffer.getSelectionModel().getSelectedItem() != null) {
        Offre selectedRec = tableoffer.getSelectionModel().getSelectedItem();
        datee.setValue(LocalDate.parse(selectedRec.getDate().toString()));
        description.setText(selectedRec.getDescription());
        offre = selectedRec ;
        /*Date A=new Date();
        A=selectedRec.getDate();
             LocalDate convertToLocalDateViaInstant = convertToLocalDateViaInstant(A);
        date.setValue(convertToLocalDateViaInstant);*/
        
    }
    }
    
    public Date conversion (LocalDate ld){
   //default time zone
	       ZoneId defaultZoneId = ZoneId.systemDefault();         
        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(ld.atStartOfDay(defaultZoneId).toInstant());
        return date ;
   
   }

    @FXML
    private void ajouterOffre(ActionEvent event) {
        LocalDate localDate = datee.getValue() ;
        //System.out.println(localDate);
        Date d = conversion(localDate);
        //System.out.println(d);
        String descript= description.getText();
        //System.out.println(descript);
        Offre offre = new Offre(d,descript);
        //System.out.println(offre);
        os.ajouterOffre(offre);        
        updateTable();
        JOptionPane.showMessageDialog(null,"Offre ajoutée");
    }
    @FXML
    private void modifierOffre(ActionEvent event) {
        LocalDate localDate = datee.getValue() ;
        Date d = conversion(localDate);
        String descript= description.getText();
        offre.setDate(d);
        offre.setDescription(descript);
        System.out.println(offre);
        os.modifierOffre(offre);        
        updateTable();
        JOptionPane.showMessageDialog(null,"Votre offre est à jour !");
    }

    @FXML
    private void SupprimerOffre(ActionEvent event) {
        os.supprimerOffre(offre.getId_offre());
        updateTable();
    }
    public void updateTable(){
        
        odate.setCellValueFactory(new PropertyValueFactory<>("date"));
        odesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        listOffres = os.getAll();
                 
        tableoffer.setItems(listOffres);
        //System.out.println(listOffres);
        }

    @FXML
    private void chercher(ActionEvent event) {
        try{
            LocalDate localDate = dpChercher.getValue() ;
        Date d = conversion(localDate);
        //System.out.println(d);
       listOffres = os.chercherOffre(d);
       tableoffer.setItems(listOffres);
        }catch(Exception e){
            updateTable();
        }
        
        
    }
    
    private void but(ActionEvent event) {
           
  }

    @FXML
    private void BPDF(ActionEvent event) {
         System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
               Window primaryStage = null;
           job.showPrintDialog(this.primaryStage); 
            
               Node root = this.tableoffer;
           job.printPage(root);
           job.endJob();
            
    }
    }

    
    
}
