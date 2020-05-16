/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.omg.CORBA.BooleanSeqHelper.id;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;
import pi.esprit.entities.reacts;
import pi.esprit.utils.MyConnection;

 
public class VideolistController implements Initializable {
ObservableList list=FXCollections.observableArrayList();
 private MediaPlayer mediaplayer;
   private Media media;
    private MediaView mediaview;
     String video;
    @FXML
    private MediaView mdv;
    @FXML
    private MediaView mdv1;
    @FXML
    private MediaView mdv2;
    @FXML
    private MediaView mdv3;
    @FXML
    private Button btn_like;
    @FXML
    private Button btn_comment;
    @FXML
    private TextField txt_desc;
    @FXML
    private TextField txt_vid;
    ResultSet rs=null;
    @FXML
    private Button btn_back;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void loaddata(){
           String path=new File("C:\\wamp\\www\\mawhebti\\videos\\").getAbsolutePath();
     media=new Media(new File(path).toURI().toString());
      media=new Media(new File(path).toURI().toString());
     mediaplayer=new MediaPlayer(media);
     mdv.setMediaPlayer(mediaplayer);
     mediaplayer.setAutoPlay(true);
     
     
    
   
    }
    
    personnes s=loggedmembre.getP();

    @FXML
    private void like(ActionEvent event) {
        int like=0;
        Connection cnx=MyConnection.getInstance().getCnx();
    try {
        reacts r=new reacts();
        String requete2="Update reacts SET like=? where id_user=? ";
        PreparedStatement pst2 = cnx.prepareStatement(requete2);
        pst2.setInt(1,s.getId_user());
        pst2.setInt(2,r.getLike());
        int rowsupdated = pst2.executeUpdate();
        if(rowsupdated>0)  
            System.out.println("row updated");
        like++;
        System.out.println("number of like"+like);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());    }
    }

    @FXML
    private void comment(ActionEvent event) {
       Connection  cnx = MyConnection.getInstance().getCnx();
         String requete = "INSERT INTO commentaires(descr,id_vid,id_user)" + " VALUES (?,?,?) ";
         
           try {
               
            PreparedStatement pst =cnx.prepareStatement(requete);
            pst.setString(1,txt_desc.getText());
            pst.setInt(2,s.getId_user());
            pst.setString(3,txt_vid.getText());
            
            pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"comment added !!!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @FXML
    private void back(ActionEvent event) {
         btn_back.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("vid.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
     
        
    }

  

    

