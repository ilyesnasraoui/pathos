/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Facebook;
import static Entités.sendMail.sendMail;
import Entités.user;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceFacebook;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Wissem
 */
public class FXMLauthentificationController implements Initializable {

    @FXML
    private AnchorPane LoginPane;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private Button Loginbtn;
    @FXML
    private Label Signupbtn;
    @FXML
    private Label err;
    @FXML
    private Button fblogin;
    ServiceFacebook s = new ServiceFacebook();
    public static String LoginStatic ;
    @FXML
    private Button sendmail;
        
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
      
    }    

    @FXML
    private void identification(ActionEvent event) throws SQLException, IOException {
               ServiceUser su = new ServiceUser();
               String auth=su.authentification(Username.getText(),Password.getText());
               System.out.println(auth);
                      user u= new user(0,Username.getText(),"","","");
               
               {}
               if(("client".equals(auth) || "admin".equals(auth) || "salle".equals(auth)) && (Username.getText()!="") && Password.getText()!="")
               { if((su.status(u)==1))
               {
                 err.setText("this account has been blocked!");

               }
               else{
               try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLapp.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            
                        FXMLappController pc = fxmlLoader.getController();
                                    pc.setUsername(Username.getText());
                                    pc.setU(Username.getText());
                               //     pc.setinvisible();


            Stage stage = new Stage();
                    stage.setTitle("Filmouk");
            stage.setScene(new Scene(root));  
            stage.show();
            main.stg.close();
    } catch(Exception e) {
       e.printStackTrace();
      }
               }   
               }
               else
               {
                   err.setText("username/email and password doesn't match any account");
               }

    }

    @FXML
    private void gotosignup(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLregistration.fxml"));
             Parent root = (Parent) fxmlLoader.load();
            main.stg.setScene(new Scene(root));  
            main.stg.show();
    }

    @FXML
    private void fblog(ActionEvent event) throws IOException {
        Facebook Fb = new Facebook();
      user u= Fb.authentificationfb();
      System.err.println();
      
      
        
      if (s.InscriptionFB(u)) {
            LoginStatic = u.getUsername();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLapp.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            
                        FXMLappController pc = fxmlLoader.getController();
                                    pc.setUsername(LoginStatic);
                                    pc.setU(LoginStatic);
                                     Stage stage = new Stage();
                    stage.setTitle("Filmouk");
            stage.setScene(new Scene(root));  
            stage.show();
            main.stg.close();
 

             
        }

    }

    @FXML
    private void sendmail(ActionEvent event) {
        sendMail("wissem22111@gmail.com");
        System.out.println("test");
    }
    }
    

