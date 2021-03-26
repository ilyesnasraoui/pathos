/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Candidature;
import entities.Offre;
import java.net.URL;
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
import javax.swing.JOptionPane;
import services.CandidatureService;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import java.net.URL;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author nassim
 */
public class CandidatureUserInterController implements Initializable {

    @FXML
    private TextArea taDescription;
    @FXML
    private DatePicker dpDate;
    @FXML
    private Button addoff;
    @FXML
    private Button modifoff;
    @FXML
    private Button deleteoff;
    @FXML
    private TableView<Candidature> tableCandidature;
    @FXML
    private TableColumn<Candidature, String> colDate;
    @FXML
    private TableColumn<Candidature, String> colDesc;
    private CandidatureService cs = new CandidatureService() ;
    private ObservableList<Candidature> listCandidatures;
    private Candidature candidature = new Candidature();
    @FXML
    private DatePicker dpChercher;
    @FXML
    private Button bchercher;
private Stage primaryStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable();
        tableCandidature.setOnMouseClicked((MouseEvent event) -> {
    if (event.getClickCount() > 1) {
        onEdit();
    }
        });        
    }  
    private void onEdit() {
            // check the table's selected item and get selected item
         if (tableCandidature.getSelectionModel().getSelectedItem() != null) {
        Candidature selectedRec = tableCandidature.getSelectionModel().getSelectedItem();
        dpDate.setValue(LocalDate.parse(selectedRec.getDate().toString()));
        taDescription.setText(selectedRec.getDescription());
        candidature = selectedRec ;
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
    private void ajouterCandidature(ActionEvent event) {
        LocalDate localDate = dpDate.getValue() ;
        Date d = conversion(localDate);
        String descript= taDescription.getText();
        Candidature candidature = new Candidature(1,10,100,d,descript);
        cs.ajouterCandidature(candidature);
        updateTable();
        JOptionPane.showMessageDialog(null,"Candidature ajoutée");
    }

    @FXML
    private void modifierCaandidature(ActionEvent event) {
        LocalDate localDate = dpDate.getValue() ;
        Date d = conversion(localDate);
        String descript= taDescription.getText();
        candidature.setDate(d);
        candidature.setDescription(descript);
        cs.modifierCandidature(candidature);
        updateTable();
        JOptionPane.showMessageDialog(null,"Candidature à jours");
    }

    @FXML
    private void supprimerCandidature(ActionEvent event) {
        cs.supprimerCandidature(candidature.getId_candidature());
        updateTable();       
        JOptionPane.showMessageDialog(null,"Candidature Supprimée");
    }
    
    public void updateTable(){
        
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        listCandidatures = cs.getAll();
                 
        tableCandidature.setItems(listCandidatures);
        //System.out.println(listOffres);
        }

    @FXML
    private void chercher(ActionEvent event) {
        try{
            LocalDate localDate = dpChercher.getValue() ;
        Date d = conversion(localDate);
        //System.out.println(d);
       listCandidatures = cs.chercherCandidature(d);
       tableCandidature.setItems(listCandidatures);
        }catch(Exception e){
            updateTable();
        }
        
    }

    @FXML
    private void BPDF(ActionEvent event) {
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
               Window primaryStage = null;
           job.showPrintDialog(this.primaryStage); 
            
               Node root = this.tableCandidature;
           job.printPage(root);
           job.endJob();
            
    }
    }
    
}
