/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pi.esprit.entities.InputValidation;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;
import pi.esprit.entities.reacts;
import pi.esprit.utils.MyConnection;



public class VidController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_pause;
    @FXML
    private Button btn_stop;
    @FXML
    private Slider volume;

 
   private MediaPlayer mediaplayer;
   private Media media;
   private FileChooser filechooser;
   private ExtensionFilter filter;
    private Button btn_dislike;
    Connection cnx;
    ResultSet rs=null;
    PreparedStatement pst;
    private TextField txt_desc;
    private TextField txt_user;
    @FXML
    private TextField txt_vid;
    @FXML
    private MenuItem btn_open;
    @FXML
    private MenuItem btn_close;
    @FXML
    private Menu btn_help;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_catet;
    @FXML
    private Button btn_best;
    @FXML
    private Button btn_compe;
    @FXML
    private Button btn_uplo;
    String video;
    Image image;
    @FXML
    private Button btn_list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String path=new File("src/vid/avion.mp4").getAbsolutePath();
     media=new Media(new File(path).toURI().toString());
     mediaplayer=new MediaPlayer(media);
     mediaView.setMediaPlayer(mediaplayer);
     mediaplayer.setAutoPlay(true);
     volume.setValue(mediaplayer.getVolume()*100);
     volume.valueProperty().addListener((Observable observable) -> {
         mediaplayer.setVolume(volume.getValue()/100);
         });
    }   
    personnes pp=loggedmembre.getP();

    @FXML
    private void playvideo(ActionEvent event) {
       mediaplayer.play();
        
    }

    @FXML
    private void pausevideo(ActionEvent event) {
   
         mediaplayer.pause();
    }

    @FXML
    private void stopvideo(ActionEvent event) {
             mediaplayer.seek(mediaplayer.getStopTime());
             mediaplayer.stop();
    }

    private void dislike(ActionEvent event) {
        btn_dislike.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null,"dislike added !!!");
            }
        });
    }
 
    private void like(ActionEvent event) {
        try {
        
            reacts r=new reacts();
            String requete2="Update reacts SET like=? where id_user=? and id_vid=? ";
            PreparedStatement pst2 = cnx.prepareStatement(requete2);
             pst2.setInt(1,r.getLike());
            pst2.setInt(2,pp.getId_user());
            pst2.setInt(3, r.getId_vid());
             int rowsupdated = pst2.executeUpdate();
             if(rowsupdated>0)                
                 System.out.println("row updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
            }
    private void comment(ActionEvent event) {
        
        cnx = MyConnection.getInstance().getCnx();
         String requete = "INSERT INTO commentaires(descr,id_vid,id_user)" + " VALUES (?,?,?) ";
           try {
            PreparedStatement pst =cnx.prepareStatement(requete);
            pst.setString(1,txt_desc.getText());
            pst.setString(2,txt_user.getText());
            pst.setString(3,txt_vid.getText());
            
            pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"comment added !!!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 

    private void delete(ActionEvent event) {
        String requete="DELETE FROM commentaires WHERE id_comm=? ";     
        Statement st;
        try {
            st = (Statement) cnx.createStatement(); 
            st.executeUpdate(requete);
      System.out.println("comm supprimé");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @FXML
    private void open(ActionEvent event) throws MalformedURLException {
        filechooser=new FileChooser();
        filter=new ExtensionFilter("choisir un video","*.mp4");
        filechooser.setSelectedExtensionFilter(filter);
        File file=filechooser.showOpenDialog(null);
        if(file!=null){
            mediaplayer.stop();
            media=new Media(file.toURI().toURL().toExternalForm());
            mediaplayer=new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaplayer);
        }
    
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void help(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
        btn_back.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void categoriepage(ActionEvent event) {
        btn_catet.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("categories.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void bestof(ActionEvent event) {
        
    }

    @FXML
    private void competitionpage(ActionEvent event) {
        btn_compe.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("competition.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    public void uploa(ActionEvent event) throws MalformedURLException, IOException {
         FileChooser fileChooser = new FileChooser();
        final Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            video = UUID.randomUUID().toString().replaceAll("-", "") + ".mp4";
            image = new Image(file.getAbsoluteFile().toURI().toString(), mediaView.getFitWidth(), mediaView.getFitHeight(), true, true);

            txt_vid.setText(video);
            InputValidation u = new InputValidation();
            String video1;
            video1 = "C:\\wamp\\www\\mawhebti\\videos\\" + video;
            System.out.println(video);
            
             mediaplayer.stop();
            media=new Media(file.toURI().toURL().toExternalForm());
            mediaplayer=new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaplayer);
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
    private void list(ActionEvent event) {
        
         btn_list.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("videolist.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
    


}