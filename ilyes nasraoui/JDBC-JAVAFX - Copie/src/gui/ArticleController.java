/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Article;
import Entités.Categorie_event;
import Entités.Evenement;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import Entités.MyListener;
import java.sql.PreparedStatement;
import javafx.scene.Node;
import javafx.scene.layout.HBox;






/**
 * FXML Controller class
 *
 * @author ilyes
 */
public class ArticleController implements Initializable {

    
    @FXML
    private TextField txfidarticle;
    @FXML
    private TextArea txfcontenu;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifer;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TableColumn<Article, String> colidtitre;
    @FXML
    private TableColumn<Article, String> colcontenu;
    @FXML
    private TableView<Article> tabviewb;
    @FXML
    private TextField txtitre;
    @FXML
    private Button fixrecherche;
    @FXML
    private TextField fixtextrecherche;
    @FXML
    private TextField fxdureee;
    @FXML
    private TextArea fxdesccc;
    @FXML
    private TextField fxidevenementtt;
    @FXML
    private TextField fxnomevenementt;
    @FXML
    private TableView<Evenement> tftabview2;
    @FXML
    private TableColumn<Evenement, String> nomevenementt;
    @FXML
    private TableColumn<Evenement, String> fxdateeventt;
    @FXML
    private TableColumn<Evenement, Integer> Dureevent;
    @FXML
    private TableColumn<Evenement, String> afiicheeventt;
    @FXML
    private TableColumn<Evenement, String> fxdescriptionnevent;
    @FXML
    private TableColumn<Evenement, Integer> validationnevent;
    @FXML
    private Button fxajouterevent;
    @FXML
    private Button fxmodiferevent;
    @FXML
    private Button fxsupprimerevent;
    @FXML
    private DatePicker fxdateeventtt;
    private TextField fxafficheventt;
    @FXML
    private TextField fxvalidatee;
    @FXML
    private TextField fxidcategorie1;
    @FXML
    private TextField fxnomcategorie1;
    @FXML
    private TextArea fxdescription1;
    @FXML
    private TableView<Categorie_event> tableview3;
    @FXML
    private TableColumn<Categorie_event, String> colnomcategorie1;
    @FXML
    private TableColumn<Categorie_event, String> coldescription1;
    @FXML
    private Button ajoutercategorie1;
    @FXML
    private Button modifiercategorie1;
    @FXML
    private Button supprimercategorie1;
    @FXML
    private Label lavelidarticle;
    @FXML
    private Label labelidevenement;
    @FXML
    private Label labeltitre;
    @FXML
    private Label labelcontenu;
    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox11;
    private Label labeltitrexx;
    private TextArea fxcontenuarticle;
    private Label fxidevenementarticle;
    @FXML
    private Button btnInsertImage;
    @FXML
    private ImageView filmImg;
    String urlInserted;
    @FXML
    private ComboBox<String> combox1;
    @FXML
    private ComboBox<String> comboxeventcat;
    @FXML
    private ComboBox<String> cobouser;
    @FXML
    private CheckBox boxarabi;
    @FXML
    private ScrollPane scroleilyes;
    @FXML
    private GridPane griddd;
    
    private List<Categorie_event> catevent = new ArrayList<>();
    
    private List<Evenement> lisevenet = new ArrayList<>();
    private List<Article> lisarticle = new ArrayList<>();
    private MyListener myListener;
    private MyListener myListenerr;
    @FXML
    private ScrollPane scrolleevent;
    @FXML
    private GridPane gridevent;
    @FXML
    private GridPane gridarticle;
    @FXML
    private ScrollPane scrollearticle;
    @FXML
    private Label ilyesilyes;
    @FXML
    private ScrollPane scrollpaneSite;
    @FXML
    private HBox hbox_site;
    /**
     * Initializes the controller class.
     */
 
   static int indiceSite = 0;
   private int taille_site = 0;
   
   Evenement site = new Evenement();
//   ArticleController site = new ArticleController() ;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     showArticle(); 
     showevenement();
     showcategorieevent();
     
     
         try {
            /*-------------------*/
            // site
            taille_site = Affichertaille();
            System.out.println(taille_site);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }       
                Node[] nodes_site = new Node[taille_site];
         scrollpaneSite.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceSite = 0; indiceSite < taille_site; indiceSite++) {
            try {
                nodes_site[indiceSite] = FXMLLoader.load(getClass().getResource("/gui/Item_Site.fxml"));
                hbox_site.getChildren().add(nodes_site[indiceSite]);
            } catch (IOException e) {
            }}
     
     
     
     
     
        try {
            showddd();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
        try {
            showmmm();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     //
        try {     
            // Categorie_event sc = new Categorie_event();
            
            
            showcategorieeventt();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
       
        
        try {
            combox1.setItems(readOb());
        } catch (SQLException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            comboxeventcat.setItems(readObevent());
        } catch (SQLException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cobouser.setItems(readObeventuser());
        } catch (SQLException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
    } 
    public Connection getConnection(){
    Connection conn;
    try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmouk","root","");
    return conn;
    }catch(Exception ex){
        System.out.println("error"+ex.getMessage());
        return null;
    }
    
    }
    
    
    public int Affichertaille() throws SQLException {
        int i = 0;
        String requete = "SELECT * FROM evenement ";
        Connection conn =getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               
                i++;

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  // **************************************** Crud article *********************************//
    
    public ObservableList<String> readOb() throws SQLException{
    ObservableList<String> oss = FXCollections.observableArrayList();
    Connection conn =getConnection();
    Statement st = conn.createStatement();
    String req = "select CONCAT(id_evenement, '-', nom_evenement) ee from evenement";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){

        String nomCat = rs.getString(1);

        oss.add(nomCat);
      
    }
    
    return oss;

    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
   
    
    public void showddd() throws IOException {
        
        gridarticle.getChildren().clear();
        lisarticle.clear();
        //Categorie_event sm = new Categorie_event();
        lisarticle = getArticle();
        if (lisarticle.size() > 0) {
            //setChosenMovie(lisarticle.get(0));
            
        }
        int column = 1;
        int row = 1;
        try {
            for (int i = 0; i < lisarticle.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemarticle.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemarticleController itemarticleController = fxmlLoader.getController();
                
                itemarticleController.setDataarticle(lisarticle.get(i),myListener);
                
                if (column == 4) {
                    column = 1;
                    row++;
                  
                }
                
                gridarticle.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridarticle.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridarticle.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridarticle.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridarticle.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridarticle.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridarticle.setMaxHeight(Region.USE_PREF_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //////////////////////////////////////////////////////
    
    public ObservableList<Article> getArticle(){
        ObservableList<Article> articleList = FXCollections.observableArrayList();
        Connection conn =getConnection();
        String query ="SELECT * FROM Article ";
        Statement st;
        ResultSet rs ;
        
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
        Article article;
        while(rs.next()){
        
        article =new Article(rs.getInt("id_article"),rs.getInt("id_evenement"),rs.getString("titre"),rs.getString("contenu"));
        articleList.add(article);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }return articleList;
    }
    public void showArticle(){
    ObservableList<Article> List =getArticle();
   // colidarticle.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id_article"));
   // colidevent.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id_evenement"));
    colidtitre.setCellValueFactory(new PropertyValueFactory<Article,String>("titre"));
    colcontenu.setCellValueFactory(new PropertyValueFactory<Article,String>("contenu"));
    
    tabviewb.setItems(List);
    
    }
    
   /*    Connection conn =getConnection();
      String query = "SELECT nom_evenement FROM evenement "; 
      
      
        Statement st;
        ResultSet rs ;
        st=conn.createStatement();
        rs=st.executeQuery(query);
            
      while(rs.next())
      {
      combox1.getItems().add(rs.getString("test"));
      }
    
    } */
    
    private void ajouterRecord(){
    String valuecombo = combox1.getValue().split("-", 2)[0];
    
//String query ="INSERT INTO `article` (`id_article`, `id_evenement`, `titre`, `contenu`) VALUES ('8', '8', '666', '66');";
   String query = "INSERT INTO article (id_evenement,titre,contenu) VALUES(" +valuecombo+ " ,' " +txtitre.getText()+ "' , '"+txfcontenu.getText()+ "');";
    executeQuery(query);
    showArticle();
        try {
            showddd();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void modifierRecord(){
        String valuecombo = combox1.getValue().split("-", 2)[0];
    String query = "UPDATE article SET id_evenement = " +valuecombo + ",titre='"+txtitre.getText()+"',contenu = '"+txfcontenu.getText()+ "'WHERE id_article = "+txfidarticle.getText()+"";
    executeQuery(query);
    showArticle();
    try {
            showddd();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void deleteRecord(){
    String query = "DELETE FROM article WHERE id_article =" + txfidarticle.getText()+ "";
    executeQuery(query);
    showArticle();
    try {
            showddd();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    ////////////////////////////////////////////////////////////
    
    
    public void showmmm() throws IOException {
        
        gridevent.getChildren().clear();
        lisevenet.clear();
        //Categorie_event sm = new Categorie_event();
        lisevenet = getEvenement();
        if (lisevenet.size() > 0) {
           // setChosenMovie(catevent.get(0));
            
        }
        int column = 1;
        int row = 1;
        try {
            for (int i = 0; i < lisevenet.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/eventmentt.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                EventmenttController eventmenttController = fxmlLoader.getController();
                
                eventmenttController.setData(lisevenet.get(i),myListener);
                
                if (column == 4) {
                    column = 1;
                    row++;
                  
                }
                
                gridevent.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridevent.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridevent.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridevent.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridevent.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridevent.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridevent.setMaxHeight(Region.USE_PREF_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    
    


    private void executeQuery(String query) {
       Connection conn =getConnection();
       Statement st ;
       try{
           
            st= conn.createStatement();
            st.executeUpdate(query);
       }catch(Exception ex){
       ex.printStackTrace();
       }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnajouter ){
            ajouterRecord();
        }
        else if (event.getSource()== btnmodifer ){
        modifierRecord();
        }
        else if (event.getSource()== btnsupprimer ){
        deleteRecord();
        }
        
        }

    
    
    @FXML
    private void handleMouseaction(MouseEvent event) {
        
        Article article = tabviewb.getSelectionModel().getSelectedItem();
        txtitre.setText(article.getTitre());
        combox1.setValue(""+article.getId_evenement());
        txfcontenu.setText(article.getContenu());
        txfidarticle.setText(""+article.getId_article());
        
        labeltitrexx.setText(article.getTitre());
        fxcontenuarticle.setText(article.getContenu());
        fxidevenementarticle.setText(""+article.getId_evenement());
        
    }

    
    
    
    
    
    
    
    
    
    
   
    //  **************************************** fin CRUD Article ***********************************************

  

    
    
    
    
    // *************************** CRUD EVENEMENT ***************************************
   
    
    public ObservableList<String> readObevent() throws SQLException{
    ObservableList<String> oss = FXCollections.observableArrayList();
    Connection conn =getConnection();
    Statement st = conn.createStatement();
    String req = "select CONCAT(id_cat_event, '-', nom_categorie_ev) ee from categorie_event ";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){

        String nomCat = rs.getString(1);

        oss.add(nomCat);
      
    }
    
    return oss;

    }
    
    public ObservableList<String> readObeventuser() throws SQLException{
    ObservableList<String> oss = FXCollections.observableArrayList();
    Connection conn =getConnection();
    Statement st = conn.createStatement();
    String req = "select CONCAT(id_user, '-', username) ee from users ";
    ResultSet rs = st.executeQuery(req);
     
    while(rs.next()){

        String nomCat = rs.getString(1);

        oss.add(nomCat);
      
    }
    
    return oss;

    }
    
    
    
    
    
    //////////////////////////////////////////////////////////////
    
    public Evenement getevent(int i) {
        Evenement event = null;
        int nombre = 0;
        String requete = "SELECT * FROM evenement";
        Connection conn =getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (i == nombre) {
                    event =new Evenement(rs.getInt("id_evenement"),rs.getInt("id_cat_evenement"),rs.getInt("id_user"),rs.getInt("validate"),rs.getString("nom_evenement"),rs.getString("date_evenement"),rs.getInt("duree_evenement"),rs.getString("image_evnement"),rs.getString("description"));

                   
                }
                nombre++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return event;

    }
    
    
    
    
    /////////////////////////////////////////////////////////////////
    
    
    public ObservableList<Evenement> getEvenement(){
        ObservableList<Evenement> evenementList = FXCollections.observableArrayList();
        Connection conn =getConnection();
        String query ="SELECT * FROM Evenement ";
        Statement st;
        ResultSet rs ;
        
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
        Evenement evenement;
        while(rs.next()){
        
        evenement =new Evenement(rs.getInt("id_evenement"),rs.getInt("id_cat_evenement"),rs.getInt("id_user"),rs.getInt("validate"),rs.getString("nom_evenement"),rs.getString("date_evenement"),rs.getInt("duree_evenement"),rs.getString("image_evnement"),rs.getString("description"));
        evenementList.add(evenement);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }return evenementList;
    }
    public void showevenement(){
    ObservableList<Evenement> List =getEvenement();
  //  idevenementtt.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id_evenement"));
   // iddcategorievent.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id_cat_evenement"));
    //fxiduserevent.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id_user"));
    validationnevent.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("validate"));
    Dureevent.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("duree_evenement"));
    fxdateeventt.setCellValueFactory(new PropertyValueFactory<Evenement,String>("date_evenement"));
    nomevenementt.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom_evenement"));
    fxdescriptionnevent.setCellValueFactory(new PropertyValueFactory<Evenement,String>("description"));
    afiicheeventt.setCellValueFactory(new PropertyValueFactory<Evenement,String>("image_evnement"));
    
    
    tftabview2.setItems(List);
    
    }
    
    
    private void ajouterevenementRecord(){
        String valuecomboo = comboxeventcat.getValue().split("-", 2)[0];
        String combouser = cobouser.getValue().split("-", 2)[0];
    String query = "INSERT INTO Evenement(id_cat_evenement,id_user, nom_evenement, date_evenement, duree_evenement, image_evnement, description, validate) VALUES("+valuecomboo+ " , " +combouser+" , '" +fxnomevenementt.getText()+"' , '" +fxdateeventtt.getValue()+"' , " +fxdureee.getText()+ " , '" +urlInserted+ "' , '" +fxdesccc.getText()+"',"+fxvalidatee.getText()+");";
    //String query = " INSERT INTO `evenement` (`id_cat_evenement`, `id_user`, `nom_evenement`, `date_evenement`, `id_evenement`, `duree_evenement`, `image_evnement`, `description`, `validate`) VALUES ('2', '2', '2222222', '22', '2', '2', '2', '2', '2')";
    executeQuery(query);
    showevenement();
    
        try {
            showmmm();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void modifierevenementRecord(){
    String query = "UPDATE evenement SET nom_evenement='"+fxnomevenementt.getText()+"',date_evenement = '"+fxdateeventtt.getValue()+ "'WHERE id_evenement = "+fxidevenementtt.getText()+"";
    executeQuery(query);
    showevenement();
    try {
            showmmm();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void deleteevenementRecord(){
    String query = "DELETE FROM evenement WHERE id_evenement =" + fxidevenementtt.getText()+ "";
    executeQuery(query);
    showevenement();
    try {
            showmmm();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    


    @FXML
    
    private void handleButtonActionn(ActionEvent event) {
        
        if (event.getSource()== fxajouterevent ){
            ajouterevenementRecord();
        }
        else if (event.getSource()== fxsupprimerevent ){
            deleteevenementRecord();
        }
        else if (event.getSource()== fxmodiferevent ){
            modifierevenementRecord();
        }
    }
    
    
    
   // ************************************************** crude categorie ************************************ 
    
    public ObservableList<Categorie_event> getCategorie(){
        ObservableList<Categorie_event> categorieList = FXCollections.observableArrayList();
        Connection conn =getConnection();
        String query ="SELECT * FROM categorie_event ";
        Statement st;
        ResultSet rs ;
        
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
        Categorie_event categorie_event;
        while(rs.next()){
        
        categorie_event =new Categorie_event(rs.getInt("id_cat_event"),rs.getString("nom_categorie_ev"),rs.getString("description"));
        categorieList.add(categorie_event);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }return categorieList;
    }
    public void showcategorieevent(){
    ObservableList<Categorie_event> List =getCategorie();
    //colidcategorie1.setCellValueFactory(new PropertyValueFactory<Categorie_event,Integer>("id_cat_event"));
    colnomcategorie1.setCellValueFactory(new PropertyValueFactory<Categorie_event,String>("nom_categorie_ev"));
    coldescription1.setCellValueFactory(new PropertyValueFactory<Categorie_event,String>("description"));
    
    
    tableview3.setItems(List);
    
    }

    private void ajoutercategorieRecord(){
    //String query ="INSERT INTO `article` (`id_article`, `id_evenement`, `titre`, `contenu`) VALUES ('8', '8', '666', '66');";
String query = "INSERT INTO Categorie_event (nom_categorie_ev,description)VALUES(' " +fxnomcategorie1.getText()+ "' , '"+fxdescription1.getText()+ "');";
    executeQuery(query);
    showcategorieevent();
        try {
            showcategorieeventt();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void modifiercategorieRecord(){
    String query = "UPDATE categorie_event SET  nom_categorie_ev='"+fxnomcategorie1.getText()+"',description = '"+fxdescription1.getText()+ "'WHERE id_cat_event = "+fxidcategorie1.getText()+"";
    executeQuery(query);
    showcategorieevent();
        try {
            showcategorieeventt();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void deletecategorieRecord(){
    String query = "DELETE FROM Categorie_event WHERE id_cat_event =" + fxidcategorie1.getText()+ "";
    executeQuery(query);
    showcategorieevent();
        try {
            showcategorieeventt();
        } catch (IOException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleButtonActionnn(ActionEvent event) {
        if (event.getSource( )== ajoutercategorie1 ){
            ajoutercategorieRecord();
        }
        else if (event.getSource( )== modifiercategorie1 ){
            modifiercategorieRecord();
        }
        else if (event.getSource( )== supprimercategorie1 ){
            deletecategorieRecord();
        }
    }

    @FXML
    private void handleMouseactionn(MouseEvent event) {
        
        Evenement evenement = tftabview2.getSelectionModel().getSelectedItem();
        fxdateeventtt.setAccessibleHelp(evenement.getDate_evenement());
        fxidevenementtt.setText(""+evenement.getId_evenement());
        fxdureee.setText(""+evenement.getDuree_evenement());
        comboxeventcat.setValue(""+evenement.getId_cat_evenement());
        cobouser.setValue(""+evenement.getId_user());
        fxvalidatee.setText(""+evenement.getValidate());
        fxdesccc.setText(evenement.getDescription());
        fxnomevenementt.setText(evenement.getNom_evenement());
        fxafficheventt.setText(evenement.getImage_evnement());

        
    }

    @FXML
    private void handleMouseactionnn(MouseEvent event) {
        Categorie_event categorie_event = tableview3.getSelectionModel().getSelectedItem();
        fxidcategorie1.setText(""+categorie_event.getId_cat_event());
        fxdescription1.setText(categorie_event.getDescription());
        fxnomcategorie1.setText(categorie_event.getNom_categorie_ev());
        
    }

    @FXML
    private void checkboxxx(ActionEvent event) {
        if (event.getSource( )== checkbox1 ){
              
              lavelidarticle.setText("Article");
              labelidevenement.setText("ID Event");
              labeltitre.setText("Title");
              labelcontenu.setText("Content");
              btnajouter.setText("Add");
              btnsupprimer.setText("Delete");
              btnmodifer.setText("Update");
              fixrecherche.setText("Research");
              
        }
    }

    @FXML
    private void checkboxxxx(ActionEvent event) {
        if (event.getSource( )== checkbox11 ){
              
              lavelidarticle.setText("Article");
              labelidevenement.setText("ID Evenement");
              labeltitre.setText("Titre");
              labelcontenu.setText("Contenu");
              btnajouter.setText("Ajouter");
              btnsupprimer.setText("Supprimer");
              btnmodifer.setText("Modifier");
              fixrecherche.setText("Recherche");
              
        }
    }

    
    
    
    
   
    
    ///////////////////////////////////////////
    
    
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
           String a="";
            for (int i=0;i<urlInserted.length();i++){
                
                
                a=a+urlInserted.charAt(i);
                if (urlInserted.charAt(i) =='\\'){
                    
                     a=a+"\\" ;
                }
            
            
            }
            
            urlInserted=a;
            
            ilyesilyes.setText(a);
            btnInsertImage.setText(selectedFile.getAbsolutePath());
            //String bt =btnInsertImage.getText();
            Image image = new Image(ilyesilyes.getText() );
            
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
    
    
    
    
    ///////////////////
    
    
    
    public ObservableList<Article> getfiltrage(String x )throws SQLException{
        ObservableList<Article> L = FXCollections.observableArrayList();
        Connection conn =getConnection();
        String query ="SELECT * FROM article where (id_article like '%"+x+"%') or (id_evenement like '%"+x+"%') or (titre like '%"+x+"%')or (contenu like '%"+x+"%')";
        
        Statement st;
        ResultSet rs ;
        
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
        Article article;
        while(rs.next()){
        
        article =new Article(rs.getInt("id_article"),rs.getInt("id_evenement"),rs.getString("titre"),rs.getString("contenu"));
        L.add(article);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }return L;
    }
    @FXML
    private void filtragee(KeyEvent event) throws SQLException {
        
        gridarticle.getChildren().clear();
        lisarticle.clear();
        //ServiceMovie sm = new ServiceMovie();
        try {
            lisarticle = getfiltrage(fixtextrecherche.getText());
        } catch (SQLException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lisarticle.size() > 0) {
            //setChosenMovie(movies.get(0));
            
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < lisarticle.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemarticle.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemarticleController itemarticlecontroller = fxmlLoader.getController();
                itemarticlecontroller.setDataarticle(lisarticle.get(i), myListener);
                
                if (column == 3) {
                    column = 0;
                    row++;
                }
                
                gridarticle.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridarticle.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridarticle.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridarticle.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridarticle.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridarticle.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridarticle.setMaxHeight(Region.USE_PREF_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    @FXML
    private void chockboxarab(ActionEvent event) {
        
        if (event.getSource( )== boxarabi ){
              
              lavelidarticle.setText("العنصر");
              labelidevenement.setText("نعريف الحدث");
              labeltitre.setText("العنوان");
              labelcontenu.setText("المحتوى");
              btnajouter.setText("إضافة");
              btnsupprimer.setText("حذف");
              btnmodifer.setText("تعديل");
              fixrecherche.setText("ابحث");
              
        }
        
    }

    
    
    
    //
    
   /* private void setChosenMovie(Categorie_event categorie_event) {
       fxidcategorie1.setText(""+categorie_event.getId_cat_event());
       
        
        
    }*/
    
    public void showcategorieeventt() throws IOException {
        
        griddd.getChildren().clear();
        catevent.clear();
        //Categorie_event sm = new Categorie_event();
        catevent = getCategorie();
        if (catevent.size() > 0) {
            //setChosenMovie(catevent.get(0));
            
        }
        int column = 1;
        int row = 1;
        try {
            for (int i = 0; i < catevent.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/echcat.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                EchcatController echcatController = fxmlLoader.getController();
                
                echcatController.setData(catevent.get(i),myListener);
                
                if (column == 4) {
                    column = 1;
                    row++;
                  
                }
                
                griddd.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                griddd.setMinWidth(Region.USE_COMPUTED_SIZE);
                griddd.setPrefWidth(Region.USE_COMPUTED_SIZE);
                griddd.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                griddd.setMinHeight(Region.USE_COMPUTED_SIZE);
                griddd.setPrefHeight(Region.USE_COMPUTED_SIZE);
                griddd.setMaxHeight(Region.USE_PREF_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    
    
    
    
    
    
    
    
}


