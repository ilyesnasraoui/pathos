/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Person;
import Entités.Planning;
import Entités.Salle;
import Entités.SalleAccount;
import Entités.user;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import services.ServicePerson;
import services.ServicePlanning;
import services.ServiceSalle;
import services.ServiceSalleAccount;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Wissem
 */
public class FXMLappController implements Initializable {

    @FXML
    private TextField rech;
    @FXML
    private Button btnrech;
    @FXML
    private TableView<Person> persontab;
    @FXML
    private TableColumn<Person, String> cfname;
    @FXML
    private TableColumn<Person, String> clname;
    @FXML
    private TableColumn<Person, String> cidcard;
    @FXML
    private TableColumn<Person, String> cusername;
    @FXML
    private TableColumn<Person, String> cemail;
    @FXML
    private TableColumn<Person, String> cphone;
    @FXML
    private TableColumn<Person, String> crole;
    @FXML
    private Button test;
    @FXML
    private Label vfname;
    @FXML
    private Label vlname;
    @FXML
     Label vusername;
    @FXML
    private Label vemail;
    @FXML
    private Label vphone;
    @FXML
    private Label vrole;
    private Button delete;
    private Button setadmin;
    @FXML
    private Button block;
    private Button unblock;
    @FXML
    private Label username;
    @FXML
    private Button tt;
    @FXML
    private ScrollPane scrollusers;
    @FXML
    private GridPane gridusers;
    private MyListener myListener;
        private List<Person> persons = new ArrayList<>();
                private List<Planning> planning = new ArrayList<>();

        private List<SalleAccount> salles = new ArrayList<>();
    
    @FXML
   
    private TableView<SalleAccount> salletab;
    @FXML
    private TableColumn<SalleAccount, String> Susername;
    @FXML
    private TableColumn<SalleAccount, String> Sname;
    @FXML
    private TableColumn<SalleAccount, String> Semail;
    @FXML
    private TableColumn<SalleAccount, String> Sadresse;
    @FXML
    private TableColumn<SalleAccount, String> Sgovernorate;
    @FXML
    private TableColumn<SalleAccount, String> Sphone;
    @FXML
    private Label Svusername;
    @FXML
    private Label svroomname;
    @FXML
    private Label Svemail;
    @FXML
    private Label Svadresse;
    @FXML
    private Label Svgovernorate;
    @FXML
    private Label Svphone;
    @FXML
    private TextField Srech;
    @FXML
    private ScrollPane scrollsalle;
    @FXML
    private GridPane gridsalle;
    @FXML
    private Tab usertab;
    @FXML
    private Tab roomtab;
    @FXML
    private Button btnrech1;
    @FXML
    private Label vfname1;
    @FXML
    private Label vlname1;
    @FXML
    private Label vusername1;
    @FXML
    private Label vemail1;
    @FXML
    private Label vphone1;
    @FXML
    private Label vrole1;
    @FXML
    private Button delete1;
    @FXML
    private Button block1;
    @FXML
    private Button unblock1;
    @FXML
    private Label username1;
    @FXML
    private TextField rechsalle;
    @FXML
    private TabPane tabpane;
    @FXML
    private Button btnrech2;
    @FXML
    private DatePicker date;
    @FXML
    private TextField fname;
    @FXML
    private TextField nbplace;
    @FXML
    private TextField projectiontime;
    @FXML
    private ScrollPane scrollplanning;
    @FXML
    private GridPane gridplanning;
    private TextField searchOwnPlanning;
    @FXML
    private TextField searchp;
        private String u ;
    @FXML
    private Button update;
    @FXML
    private Button changepwd;
    @FXML
    private TextField fnamefield;
    @FXML
    private TextField lnamefield;
    @FXML
    private TextField emailfield;
    @FXML
    private HBox phonefield;
    @FXML
    private TextField firstnamefield111;
        private void setChosenProfile(Person person) {
        vfname.setText(person.getFname());
        vlname.setText(person.getLname());
        vemail.setText(person.getEmail());

        
        
       
    }
public void setinvisible()
{
    this.tabpane.getTabs().remove(roomtab);
}
 public void setUsername(String nom) {
        this.username.setText(nom);
    }
 public String getUsername()
 {
     return this.username.getText();
 }
 public void setU(String nom) {
        this.u=nom;
    }
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     //          tabpane.getTabs().remove(roomtab);
           // setUsername(username.getText());


        
            myListener = new MyListener() {
                @Override
                public void onClickListener(Person person) {
                   // setChosenProfile(person);
                }
         
            };
        try {
            //  showPerson();
            showusers();
            //            showSalle();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLappController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLappController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
               

       
                


        
        
        
        
        
    }    

public void setfname(String nom) {
        this.fname.setText(nom);
    }
    
    @FXML
     public void showPerson() throws SQLException {
         ServicePerson sp= new ServicePerson();

            ObservableList<Person> List = sp.read();
            cfname.setCellValueFactory(new PropertyValueFactory<>("fname"));
            clname.setCellValueFactory(new PropertyValueFactory<>("lname"));
            cidcard.setCellValueFactory(new PropertyValueFactory<>("idcard"));
            cusername.setCellValueFactory(new PropertyValueFactory<>("username"));
            cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            crole.setCellValueFactory(new PropertyValueFactory<>("role"));
            
            persontab.setItems(List);

    
    }
     public void showSalle() throws SQLException {
         ServiceSalleAccount ss= new ServiceSalleAccount();
                          ObservableList<SalleAccount> ls = ss.read();

            Susername.setCellValueFactory(new PropertyValueFactory<>("username"));
            Sname.setCellValueFactory(new PropertyValueFactory<>("name"));
            Semail.setCellValueFactory(new PropertyValueFactory<>("email"));
            Sadresse.setCellValueFactory(new PropertyValueFactory<>("adress"));
            Sgovernorate.setCellValueFactory(new PropertyValueFactory<>("governorate"));
            Sphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            crole.setCellValueFactory(new PropertyValueFactory<>("role"));
            
            salletab.setItems(ls);

    
    }

    @FXML
    private void fillform(MouseEvent event) throws SQLException {
         Person p = persontab.getSelectionModel().getSelectedItem();
        ServicePerson sp= new ServicePerson();
        vfname.setText(""+p.getFname());
        vlname.setText(""+p.getLname());
        vusername.setText(""+p.getUsername());
        vemail.setText(""+p.getEmail());
        vphone.setText(""+p.getPhone());
        vrole.setText(""+p.getRole());
        Person pp=sp.getInstance(username.getText());
        if("admin".equals(pp.getRole()))
        {if(sp.status(p)==1)
        {block.setVisible(false);
        unblock.setVisible(true);
        setadmin.setVisible(true);
                    delete.setVisible(true);
        }
        else
        { 
            block.setVisible(true);  
          unblock.setVisible(false);
          setadmin.setVisible(true);
                    delete.setVisible(true);
        }
        }
        
    }
    @FXML
    private void searchperson(KeyEvent event) throws SQLException {
        ServicePerson sp= new ServicePerson();
                
            ObservableList<Person> List = sp.search(rech.getText());
            cfname.setCellValueFactory(new PropertyValueFactory<>("fname"));
            clname.setCellValueFactory(new PropertyValueFactory<>("lname"));
            cidcard.setCellValueFactory(new PropertyValueFactory<>("idcard"));
            cusername.setCellValueFactory(new PropertyValueFactory<>("username"));
            cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            crole.setCellValueFactory(new PropertyValueFactory<>("role"));
            
            persontab.setItems(List);
    }

    @FXML
    private void deleteperson(ActionEvent event) throws SQLException {
        ServicePerson sp= new ServicePerson();
       Person p = persontab.getSelectionModel().getSelectedItem();
       sp.delete(p);
                   showPerson();
                   vfname.setText("");
        vlname.setText("");
        vusername.setText("");
        vemail.setText("");
        vphone.setText("");
        vrole.setText("");

       
      
    }

    private void setadmin(ActionEvent event) throws SQLException {
        ServicePerson sp= new ServicePerson();
       Person p = persontab.getSelectionModel().getSelectedItem();
       sp.setadmin(p);
         showPerson();
         vrole.setText(""+p.getRole());
    }

    @FXML
    private void block(ActionEvent event) throws SQLException {
        ServiceUser sp= new ServiceUser();
       Person p = persontab.getSelectionModel().getSelectedItem();
       user u= new user(0,p.getUsername(),"","","");
       sp.block(u);
          block.setVisible(false);  
          unblock.setVisible(true);
    }

    @FXML
    private void unblock(ActionEvent event) throws SQLException {
        ServiceUser sp= new ServiceUser();
       Person p = persontab.getSelectionModel().getSelectedItem();
       user u= new user(0,p.getUsername(),"","","");
       sp.unblock(u);
          block.setVisible(true);  
          unblock.setVisible(false);
    }

    @FXML
    private void getinstance(ActionEvent event) throws SQLException {
        ServicePerson sp= new ServicePerson();
        Person p=sp.getInstance(username.getText());
    }
    
    
    @FXML
    public void showplanning() throws SQLException, IOException{

        gridplanning.getChildren().clear();
        planning.clear();
        ServicePlanning sp = new ServicePlanning();
        System.out.print(username.getText());
        planning= sp.read(username.getText());
                

         int column = 0;
        int row = 1;
        for (int i = 0; i < planning.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLPlanning.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                FXMLPlanningController PlanningController = fxmlLoader.getController();
            MyListener myListener = null;
                PlanningController.setData(planning.get(i), myListener);
                if (planning.size() > 0) {
           // setChosenProfile(persons.get(0));
            
        }
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridplanning.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridplanning.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridplanning.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridplanning.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridplanning.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridplanning.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridplanning.setMaxHeight(Region.USE_PREF_SIZE);
                
            }
        
        
    }

    @FXML
    public void showusers() throws SQLException, IOException{
        gridusers.getChildren().clear();
        persons.clear();
        ServicePerson sp = new ServicePerson();
        persons= sp.readls();
        ServiceUser su= new ServiceUser();
        
         int column = 0;
        int row = 1;
        for (int i = 0; i < persons.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLProfile.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                FXMLProfileController ProfileController = fxmlLoader.getController();
            MyListener myListener = null;
                ProfileController.setData(persons.get(i), myListener);
                
                if (persons.size() > 0) {
           // setChosenProfile(persons.get(0));
            
        }
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridusers.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridusers.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridusers.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridusers.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridusers.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridusers.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridusers.setMaxHeight(Region.USE_PREF_SIZE);
                
            }
        
        
    }
    
    @FXML
    public void showsalles() throws SQLException, IOException{
        gridusers.getChildren().clear();
        salles.clear();
        ServiceSalleAccount sp = new ServiceSalleAccount();
        salles= sp.readls();
    //    System.out.print(salles);
         int column = 0;
        int row = 1;
        for (int i = 0; i < salles.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLProfile.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                FXMLProfileController ProfileController = fxmlLoader.getController();
            MyListener myListener = null;
                ProfileController.setData(salles.get(i), myListener);
                if (salles.size() > 0) {
           // setChosenProfile(persons.get(0));
            
        }
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridsalle.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridsalle.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridsalle.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridsalle.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridsalle.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridsalle.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridsalle.setMaxHeight(Region.USE_PREF_SIZE);
                
            }
        
        
    }
    
    
    
    @FXML
    public void shearchusers() throws SQLException, IOException{
        gridusers.getChildren().clear();
        persons.clear();
        ServicePerson sp = new ServicePerson();
        persons= sp.searchls(rech.getText());
        
         int column = 0;
        int row = 1;
        for (int i = 0; i < persons.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLProfile.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                FXMLProfileController ProfileController = fxmlLoader.getController();
            MyListener myListener = null;
                ProfileController.setData(persons.get(i), myListener);
                if (persons.size() > 0) {
           // setChosenProfile(persons.get(0));
            
        }
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridusers.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridusers.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridusers.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridusers.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridusers.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridusers.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridusers.setMaxHeight(Region.USE_PREF_SIZE);
                
            }
        
        
    }

    private void test(ActionEvent event) {
    LocalDate a;
    a=date.getValue();
 
        System.out.print(a);
    }

    @FXML
    private void addplanning(ActionEvent event) throws SQLException {
        ServicePlanning sp= new ServicePlanning();
        ServiceSalleAccount ssa= new ServiceSalleAccount();
   //System.out.print(ssa.getIdSalleByUsername(username.getText()));
     Planning p= new Planning(date.getValue(),0,sp.getIdFilmByName(fname.getText()),ssa.getIdSalleByUsername(username.getText()),Integer.parseInt(nbplace.getText()),0,0,0,projectiontime.getText());
           
           sp.add(p);
               
    }

    private void searchOwnPlanning(ActionEvent event) throws SQLException, IOException {
         
        System.out.println(searchOwnPlanning.getText());
        /*gridplanning.getChildren().clear();
        planning.clear();
        ServicePlanning sp = new ServicePlanning();
        planning= sp.searchsingle(searchOwnPlanning.getText());
                

         int column = 0;
        int row = 1;
        for (int i = 0; i < planning.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLPlanning.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                FXMLPlanningController PlanningController = fxmlLoader.getController();
            MyListener myListener = null;
                PlanningController.setData(planning.get(i), myListener);
                if (planning.size() > 0) {
           // setChosenProfile(persons.get(0));
            
        }
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridplanning.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridplanning.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridplanning.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridplanning.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridplanning.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridplanning.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridplanning.setMaxHeight(Region.USE_PREF_SIZE);
                
            }*/
    }

    @FXML
    private void test(KeyEvent event) throws SQLException, IOException {
        gridplanning.getChildren().clear();
        planning.clear();
        ServicePlanning sp = new ServicePlanning();
        planning= sp.searchsingle(searchp.getText());
                

         int column = 0;
        int row = 1;
        for (int i = 0; i < planning.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLPlanning.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                FXMLPlanningController PlanningController = fxmlLoader.getController();
            MyListener myListener = null;
                PlanningController.setData(planning.get(i), myListener);
                if (planning.size() > 0) {
           // setChosenProfile(persons.get(0));
            
        }
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridplanning.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridplanning.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridplanning.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridplanning.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridplanning.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridplanning.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridplanning.setMaxHeight(Region.USE_PREF_SIZE);
                
            }
    }

    @FXML
    private void tajriba(ActionEvent event) {
        vfname.setText(username.getText());
    }

    @FXML
    private void tajriba(MouseEvent event) {
    }

    @FXML
    private void cahngepwd(ActionEvent event) {
        tabpane.getSelectionModel().select(roomtab);
    }

    @FXML
    private void update(ActionEvent event) {
    }
    
}
