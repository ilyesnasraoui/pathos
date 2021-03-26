/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Person;
import Entités.Salle;
import Entités.SalleAccount;
import Entités.user;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServicePerson;
import services.ServiceSalle;
import services.ServiceSalleAccount;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Wissem
 */
public class FXMLregistrationController implements Initializable {

    @FXML
    private AnchorPane LoginPane;
    @FXML
    private TextField Username;
    @FXML
    private Button registerbtn;
    @FXML
    private PasswordField Password;
    @FXML
    private Label err;
    @FXML
    private TextField Email;
    @FXML
    private ComboBox<String> type;
    @FXML
    private Label Signupbtn;
    private TextField test;
    @FXML
    private TextField roomname;
    @FXML
    private Label roomnamelb;
    @FXML
    private TextField governorate;
    @FXML
    private Label governoratelb;
    @FXML
    private Label adresslb;
    @FXML
    private TextField adress;
    @FXML
    private Label phonelb;
    @FXML
    private TextField phone;
    @FXML
    private Label fnamelb;
    @FXML
    private Label lnamelb;
    @FXML
    private Label idcardlb;
    @FXML
    private TextField fname;
    @FXML
    private Label phonelb1;
    @FXML
    private TextField phone1;
    @FXML
    private TextField lname;
    @FXML
    private TextField idcard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.getItems().removeAll(type.getItems());
    type.getItems().addAll("client", "salle");
    roomname.setVisible(false);
        roomnamelb.setVisible(false);
        governorate.setVisible(false);
        governoratelb.setVisible(false);
        adress.setVisible(false);
        adresslb.setVisible(false);
        phone.setVisible(false);
        phonelb.setVisible(false);
        //
        phone1.setVisible(false);
        phonelb1.setVisible(false);
        lname.setVisible(false);
        fname.setVisible(false);
        idcardlb.setVisible(false);
        idcard.setVisible(false);
        lnamelb.setVisible(false);
        fnamelb.setVisible(false);
        
    
    }    
    

    @FXML
    private void adduser(ActionEvent event) throws SQLException {
        //lahne bech nzid verification username , email used w password weak ect ..
       /* ServiceUser su = new ServiceUser();
        user u = new user(0,Username.getText(),Password.getText(),Email.getText(),type.getValue());
        System.out.println(u);
        su.add(u);*/
        
        if("salle".equals(type.getValue()))
        {
            ServiceSalleAccount ssa= new ServiceSalleAccount();
            ServiceSalle ss= new ServiceSalle();
            Salle s= new Salle(0,roomname.getText(),governorate.getText(),adress.getText());
            ss.add(s);
            int m=ss.maxId();
            SalleAccount sa=new SalleAccount(m,0,Username.getText(),Password.getText(),Email.getText(),"salle",phone.getText());
            
            ssa.add(sa);

        }
        else
        {
            ServicePerson sp= new ServicePerson();
            Person p = new Person(fname.getText(),lname.getText(),idcard.getText(),phone1.getText(),0,Username.getText(),Password.getText(),Email.getText(),"client");
            sp.add(p);
        }
    }

    @FXML
    private void rest(Event event) {
        if("client".equals(type.getValue()))
        {
        roomname.setVisible(false);
        roomnamelb.setVisible(false);
        governorate.setVisible(false);
        governoratelb.setVisible(false);
        adress.setVisible(false);
        adresslb.setVisible(false);
        phone.setVisible(false);
        phonelb.setVisible(false);
        //
        phone1.setVisible(true);
        phonelb1.setVisible(true);
        lname.setVisible(true);
        fname.setVisible(true);
        idcardlb.setVisible(true);
        idcard.setVisible(true);
        lnamelb.setVisible(true);
        fnamelb.setVisible(true);
        }
        else if ("salle".equals(type.getValue()))
                { roomname.setVisible(true);
        roomnamelb.setVisible(true);
        governorate.setVisible(true);
        governoratelb.setVisible(true);
        adress.setVisible(true);
        adresslb.setVisible(true);
        phone.setVisible(true);
        phonelb.setVisible(true);
        //
        phone1.setVisible(false);
        phonelb1.setVisible(false);
        lname.setVisible(false);
        fname.setVisible(false);
        idcardlb.setVisible(false);
        idcard.setVisible(false);
        lnamelb.setVisible(false);
        fnamelb.setVisible(false);
        }
    }

    @FXML
    private void gotosignin(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLauthentification.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            main.stg.setScene(new Scene(root));  
            main.stg.show();
           // main.stg.close();
            
            
    }



    
    
}
