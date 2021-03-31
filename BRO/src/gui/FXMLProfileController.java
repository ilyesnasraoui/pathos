/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Person;
import Entités.SalleAccount;
import Entités.user;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.ServicePerson;
import gui.MyListener ;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import services.ServiceSalle;
import services.ServiceSalleAccount;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Wissem
 */
public class FXMLProfileController {

    @FXML
    private Label lusername;
    @FXML
    private Label lname;
    @FXML
    private Label lemail;
    @FXML
    private Label lrole;
    private Person person ; 
    @FXML
    private ImageView img;
        
    private MyListener MyListener;
    @FXML
    public Button delete;
    @FXML
    private Button block;
    @FXML
    private Button setadin;
    private SalleAccount salle;
    @FXML
    private Label governorate;
    @FXML
    private Label lgovernorate;
    @FXML
    private Label adress;
    @FXML
    private Label ladress;

    /**
     * Initializes the controller class.
     */
        public void initialize(URL url, ResourceBundle rb) {
        }

   

    public void setData(Person person, MyListener myListener) throws SQLException {
        this.person = person;
        this.MyListener = myListener;
        lusername.setText(person.getUsername());
        lname.setText(person.getFname());
        lemail.setText(person.getEmail());
        lrole.setText(person.getRole());
        ladress.setVisible(false);
        lgovernorate.setVisible(false);
        governorate.setVisible(false);
        adress.setVisible(false);
        user u= new user(0,person.getUsername(),"","","");
        ServiceUser su= new ServiceUser();
        if (su.status(u)==0)
        {
                      block.setText("block");  

        }
        else
        {
                      block.setText("unblock");  

        }
 
    }
    
     public void setData(SalleAccount salle, MyListener myListener) throws SQLException {
        this.salle = salle;
        this.MyListener = myListener;
        lusername.setText(salle.getUsername());
        setadin.setVisible(false);
        lname.setText(salle.getName());
        lemail.setText(salle.getEmail());
        lrole.setText("salle");
        lgovernorate.setText(salle.getGovernorate());
        ladress.setText(salle.getAdress());
        user u= new user(0,salle.getUsername(),"","","");
        ServiceUser su= new ServiceUser();
        if (su.status(u)==0)
        {
                      block.setText("block");  

        }
        else
        {
                      block.setText("unblock");  

        }
      
 
    }

    @FXML
    private void clicked(MouseEvent event) throws IOException {
               // MyListener.onClickListener(person);
                   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLapp.fxml"));
            
                        FXMLappController pc = fxmlLoader.getController();
                       // pc.setUsername("aa");

                      lusername.setText("aa");
                           System.out.print(lusername.getText());
                                


    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        ServicePerson sp= new ServicePerson();
        if (lrole.getText()=="salle")
        { SalleAccount sa= new SalleAccount(0,lusername.getText(),"","","");
          ServiceSalleAccount ssa= new ServiceSalleAccount();
          ssa.delete(sa);
        }
        
       Person p = new Person("","","","",0,lusername.getText(),"","","");
       sp.delete(p);
    

    }

    @FXML
    private void block(ActionEvent event) throws SQLException {
        if(block.getText()=="block")
        {
        ServiceUser sp= new ServiceUser();
       Person p = new Person("","","","",0,lusername.getText(),"","","");
       user u= new user(0,p.getUsername(),"","","");
       sp.block(u);
          block.setText("unblock");  
        }
        else
        {
        ServiceUser sp= new ServiceUser();
       Person p = new Person("","","","",0,lusername.getText(),"","","");
       user u= new user(0,p.getUsername(),"","","");
       sp.unblock(u);
          block.setText("block");  
        }
        
    }

    @FXML
    private void setadmin(ActionEvent event) throws SQLException {
                ServicePerson sp= new ServicePerson();
       Person p = new Person("","","","",0,lusername.getText(),"","","");
       sp.setadmin(p);
               lrole.setText("admin");

    }
    
}
