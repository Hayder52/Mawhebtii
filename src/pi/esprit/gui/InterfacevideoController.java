/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class InterfacevideoController implements Initializable {

    @FXML
    private MediaView mediaview;
   private MediaPlayer mediaplayer;
   private Media media;
    @FXML
    private Button btnplay;
    @FXML
    private Button btnpause;
    @FXML
    private Button btnstop;
    @FXML
    private Slider volume;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem exit;
    private FileChooser filechooser;
    private ExtensionFilter filter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String path=new File("src/video/avion.mp4").getAbsolutePath();
     media=new Media(new File(path).toURI().toString());
     mediaplayer=new MediaPlayer(media);
     mediaview.setMediaPlayer(mediaplayer);
     mediaplayer.setAutoPlay(true);
     volume.setValue(mediaplayer.getVolume()*100);
     volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaplayer.setVolume(volume.getValue()/100);
            }
        });
    }    

    @FXML
    private void play(ActionEvent event) {
        mediaplayer.play();
    }

    @FXML
    private void pause(ActionEvent event) {
        mediaplayer.pause();
    }

    @FXML
    private void stop(ActionEvent event) {
        mediaplayer.seek(mediaplayer.getStopTime());
        mediaplayer.stop();
        
    }

    @FXML
    private void openfile(ActionEvent event) throws MalformedURLException {
        filechooser=new FileChooser();
        filter=new ExtensionFilter("choise your video:","*.mp4");
        filechooser.setSelectedExtensionFilter(filter);
        File file=filechooser.showOpenDialog(null);
        if(file!=null){
            mediaplayer.stop();}
            media=new Media(file.toURI().toURL().toExternalForm());
            mediaplayer=new MediaPlayer(media);
            mediaview.setMediaPlayer(mediaplayer);
            
        
    }

    @FXML
    private void exitfile(ActionEvent event) {
        System.exit(0);
        
    }

   
}
    
       
    

