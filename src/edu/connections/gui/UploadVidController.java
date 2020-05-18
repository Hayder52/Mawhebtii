/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.gui;

import edu.connections.entities.InputValidation;
import edu.connections.utils.MyConnection;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;



/**
 * FXML Controller class
 *
 * @author MAHHOUTTA
 */
public class UploadVidController implements Initializable {
 @FXML  private MediaView mv;
 private MediaPlayer mp;
 private String filepath ;
 @FXML
 private TextField tf_nomv;
 @FXML
 private TextArea txt_vid;
 @FXML
 private Button upvid;
 
 private String name;

private String video;
Connection cnx;
ResultSet rs=null;
PreparedStatement pst;
  @FXML
 private Button savebt;
 Image image;
 private Media media;
final ObservableList<String> otions =FXCollections.observableArrayList("Music","Dance","Sports","Fashion","Art and design","Camera and Techniques");
    @FXML
    private HBox hb;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private Button playbt;
    @FXML
    private Button stopbt;
    @FXML
    private Button slowerbt;
    @FXML
    private Button slowbt;
    @FXML
    private Button fastbt;
    @FXML
    private Button fasterbt;
    @FXML
    private Button exitbt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      combobox.setItems(otions);
     
    }    
         
              
    @FXML
    public void Openfile(ActionEvent event) throws MalformedURLException, IOException{
    FileChooser filechooser = new FileChooser();
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file *.mp3,*.mp4,*.vlc","*mp4");
    filechooser.getExtensionFilters().add(filter);
    File file= filechooser.showOpenDialog(null);
   filepath=file.toURI().toString();
    if (filepath!=null){
        //AnchorPane ap = new AnchorPane();
        Media me = new Media(filepath);
           mp= new MediaPlayer(me);
           mp.setAutoPlay(true);
           mv.setMediaPlayer(mp);
           
   /*DoubleProperty width =mv.fitWidthProperty();
    DoubleProperty height =mv.fitHeightProperty();
    width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
    height.bind(Bindings.selectDouble(mv.sceneProperty(),"Heigt"));*/  
    media=new Media(file.toURI().toURL().toExternalForm());
     mp=new MediaPlayer(media);
     mv.setMediaPlayer(mp);
     mp.play();
       name=tf_nomv.getText();
 video = UUID.randomUUID().toString().replaceAll("-", "") + ".mp4";
     image = new Image(file.getAbsoluteFile().toURI().toString());
     txt_vid.setText(video);
     InputValidation u = new InputValidation();
     String video1;
     video1 = "C:\\xampp\\htdocs\\VideoUpload\\Uploads\\" + video;
     System.out.println(video);
             
     
     Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
     alert1.setTitle("Saving video");
     alert1.setHeaderText("Information");
     alert1.setContentText("do you want save this video?");
     Optional<ButtonType> action = alert1.showAndWait();
     if (action.get() == ButtonType.OK) {
            u.CopyImage(video1, file.toPath().toString());
    
    }
}
}
    @FXML
  private void play(ActionEvent event){
    mp.play();
    mp.setRate(1);
    }  
  @FXML
     private  void pause(ActionEvent event){
    mp.pause();}
       @FXML
     private void fast(ActionEvent event){
    mp.setRate(1.5);//2 is double spped then normal
    }    
       @FXML
       private void faster(ActionEvent event){
    mp.setRate(2);//slower the the normal by half
    }   
         @FXML
      private void slow(ActionEvent event){
    mp.setRate(.75);//2 is double spped then normal
    }    
        @FXML
       private void slower(ActionEvent event){
    mp.setRate(.5);//slower the the normal by half
    }  
         @FXML
      private  void exit(ActionEvent event){
    System.exit(0);
        }      
     
        
        
    @FXML
     public void add(ActionEvent event) throws SQLException{
            cnx = MyConnection.getInstance().getCnx();
            //  comboBox = new ComboBox(otions);
            String requete="insert into videos(nom_vid,desc_vid,cat_vid,path_vid) values(?,?,?,?)";
            pst=cnx.prepareStatement(requete);
            pst.setString(1,tf_nomv.getText());
              pst.setString(2,txt_vid.getText());
              pst.setString(3, combobox.getValue());
              pst.setString(4, filepath);
             pst.execute();
            JOptionPane.showMessageDialog(null,"saved");
      
     }

     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
