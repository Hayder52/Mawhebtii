/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class VideoController implements Initializable {

    @FXML
    private Button btnplay;
    @FXML
    private Button btnpause;
    @FXML
    private Button btnstop;
    @FXML
    private Slider volume;
@FXML
    private MediaView mediaview;
   private MediaPlayer mediaplayer;
   private Media media;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     String path=new File("src/video/alpha.mp4").getAbsolutePath();
     media=new Media(new File(path).toURI().toString());
     mediaplayer=new MediaPlayer(media);
     mediaview.setMediaPlayer(mediaplayer);
     mediaplayer.setAutoPlay(true);
    }    

    @FXML
    private void playvideo(ActionEvent event) {
        btnplay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
   
                if(mediaplayer.getStatus() == MediaPlayer.Status.valueOf("PLAYING")){
               
                    mediaplayer.play();
                }
            }
        });
    }

    @FXML
    private void pausevideo(ActionEvent event) {
      
    btnpause.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
if(mediaplayer.getStatus() == MediaPlayer.Status.valueOf("PLAYING")){//pause
               
                    mediaplayer.pause();
                   
                }
            }             
         });
    }

    @FXML
    private void stopvideo(ActionEvent event) {
         
    btnstop.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
if(mediaplayer.getStatus() == MediaPlayer.Status.valueOf("PLAYING")){
               
                    mediaplayer.stop();
                   
                }
            }             
         });
    }

   
    
}
