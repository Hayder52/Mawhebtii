/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.gui;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class VideoController implements Initializable {

    @FXML
    private javafx.scene.control.Button btn_play;
    @FXML
    private javafx.scene.control.Button btn_stop;
    @FXML
    private javafx.scene.control.Button btnlike;
    @FXML
    private javafx.scene.control.Button btndislike;
    @FXML
    private javafx.scene.control.Button btncomment;
    @FXML
    private MediaView mv;
    MediaPlayer mediaplayer;

 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String VUrl="file:/Desktop/tabarka.mp4";
        Media media = new Media(VUrl);
        MediaPlayer mediaplayer=new MediaPlayer(media);
        mv.setFitHeight(400);
        mv.setFitWidth(600);
        mv.setMediaPlayer(mediaplayer);
        
    }    

    @FXML
    private void on_click_btn_play(MouseEvent event) {
        if(mediaplayer.getStatus()==PLAYING){
            mediaplayer.stop();
            mediaplayer.play();
        }else{
            mediaplayer.play(); 
        }
       
    }

    @FXML
    private void on_click_btn_stop(MouseEvent event) {
        mediaplayer.stop();
    }

    @FXML
    private void like(ActionEvent event) {
        btnlike.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("you like this video");
            }
        });
    }

    @FXML
    private void dislike(ActionEvent event) {
    }

    @FXML
    private void clickcommnt(ActionEvent event) {
    }
  
}
