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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private TableColumn<Article, Integer> colidarticle;
    @FXML
    private TableColumn<Article, Integer> colidevent;
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
    private TableColumn<Evenement, Integer> idevenementtt;
    @FXML
    private TableColumn<Evenement, Integer> iddcategorievent;
    @FXML
    private TableColumn<Evenement, Integer> fxiduserevent;
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
    private TableColumn<Categorie_event, Integer> colidcategorie1;
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
    @FXML
    private Label labeltitrexx;
    @FXML
    private TextArea fxcontenuarticle;
    @FXML
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
    

    /**
     * Initializes the controller class.
     */
 
   
   
   
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      showArticle(); 
     showevenement();
     showcategorieevent();
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
    }
    
    private void modifierRecord(){
        String valuecombo = combox1.getValue().split("-", 2)[0];
    String query = "UPDATE article SET id_evenement = " +valuecombo + ",titre='"+txtitre.getText()+"',contenu = '"+txfcontenu.getText()+ "'WHERE id_article = "+txfidarticle.getText()+"";
    executeQuery(query);
    showArticle();
    }
    
    private void deleteRecord(){
    String query = "DELETE FROM article WHERE id_article =" + txfidarticle.getText()+ "";
    executeQuery(query);
    showArticle();
    }
    
    
    


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

    
    /*public List<Article> FiltrerarticleByid() throws SQLException{
       Connection conn =getConnection();
        String query = "SELECT * FROM article WHERE id_article =" + fixtextrecherche.getText()+ "";
        
        Statement st;
        ResultSet rs ;
        st=conn.createStatement();
        rs=st.executeQuery(query);
        
        ObservableList<Article> articleList = FXCollections.observableArrayList();
            while (rs.next()) {
           Article article = new Article (rs.getInt("id_article"),rs.getInt("id_evenement"),rs.getString("titre"),rs.getString("contenu"));
            article.setId_article(rs.getInt("id_article"));
            article.setContenu(rs.getString("contenu"));
             article.setId_evenement(rs.getInt("id_evenement"));
             article.setTitre(rs.getString("titre"));
            articleList.add(article);
            
            colidarticle.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id_article"));
    colidevent.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id_evenement"));
    colidtitre.setCellValueFactory(new PropertyValueFactory<Article,String>("titre"));
    colcontenu.setCellValueFactory(new PropertyValueFactory<Article,String>("contenu"));
       }
           return articleList;

 
   
      } */
    
    
    
    
    
    
    
    
    /*private void handleButtonAction(MouseEvent event) throws SQLException {
        if(event.getSource() == fixrecherche ){
            FiltrerarticleByid();
             
        }
    }*/

 
    
    
  /*  @FXML
    private void keyPressed(KeyEvent event) {
        
      
    }
*/
    //  **************************************** fin CRUD Article ***********************************************

   /* @FXML
    private void keyPressed(KeyEvent event) {
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }*/

    
    
    
    
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
    }
    
    private void modifierevenementRecord(){
    String query = "UPDATE evenement SET nom_evenement='"+fxnomevenementt.getText()+"',date_evenement = '"+fxdateeventtt.getValue()+ "'WHERE id_evenement = "+fxidevenementtt.getText()+"";
    executeQuery(query);
    showevenement();
    }
    
    private void deleteevenementRecord(){
    String query = "DELETE FROM evenement WHERE id_evenement =" + fxidevenementtt.getText()+ "";
    executeQuery(query);
    showevenement();
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
    }
    
    private void modifiercategorieRecord(){
    String query = "UPDATE categorie_event SET  nom_categorie_ev='"+fxnomcategorie1.getText()+"',description = '"+fxdescription1.getText()+ "'WHERE id_cat_event = "+fxidcategorie1.getText()+"";
    executeQuery(query);
    showcategorieevent();
    }
    
    private void deletecategorieRecord(){
    String query = "DELETE FROM Categorie_event WHERE id_cat_event =" + fxidcategorie1.getText()+ "";
    executeQuery(query);
    showcategorieevent();
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
            btnInsertImage.setText(selectedFile.getAbsolutePath());
            Image image = new Image(urlInserted);
            
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
        
    ObservableList<Article> List =getfiltrage(fixtextrecherche.getText());
    //colidarticle.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id_article"));
    //colidevent.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id_evenement"));
    colidtitre.setCellValueFactory(new PropertyValueFactory<Article,String>("titre"));
    colcontenu.setCellValueFactory(new PropertyValueFactory<Article,String>("contenu"));
    
    tabviewb.setItems(List);
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

    
    
    
    
    
    
    
    
    
    
}


