/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.mysql.jdbc.PreparedStatement;
import edu.connections.entities.InputValidation;
import edu.connections.entities.videos;
import edu.connections.services.VideoCrud;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAHHOUTTA
 */
public class GererVideoController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private ListView<videos> listvideo;
    private MediaPlayer mediaplayer;
    private Media media;
    String video;
    Image image;
    @FXML
    private Pane PaneVideo;
          
    Connection cnx;
    PreparedStatement pst;
    ResultSet st;
    @FXML
    private Button btplay;
    @FXML
    private Button btpause;
    @FXML
    private Button btslower;
    @FXML
    private Button btslow;
    @FXML
    private Button fasterbt;
    @FXML
    private Button faster;
    @FXML
    private Button btexit;
private String pathfile;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VideoCrud vc = new VideoCrud();

        // ObservableList<videos> list = FXCollections.observableArrayList(vc.displayAll());
        // listvideo.setItems(list);
        ObservableList<videos> list = FXCollections.observableArrayList(vc.displayAll());
        listvideo.setCellFactory((ListView<videos> arg0) -> {
            ListCell<videos> cell = new ListCell<videos>() {
                @Override
                protected void updateItem(videos e, boolean btl) {
                    super.updateItem(e, btl);
                    if (e != null) {

                        TextField id = new TextField(String.valueOf(e.getId_vid()));
                        id.setVisible(true);
                        setId(String.valueOf(e.getId_vid()));
                        listvideo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                                    videos M = listvideo.getItems().get(listvideo.getSelectionModel().getSelectedIndex());
                                    String path = "C:\\xampp\\htdocs\\VideoUpload\\Uploads\\" + e.getPath_vid();
                                    File file = new File(path);
                                    System.out.println(file);

                                    try {
                                        media = new Media(file.toURI().toURL().toExternalForm());
                                    } catch (MalformedURLException ex) {
                                        ex.printStackTrace();
                                    }
                                    mediaplayer = new MediaPlayer(media);

                                    mediaView.setMediaPlayer(mediaplayer);

                                }

                            }
                        }
                        );
                        if (e.getId_vid()
                                != 0) {
                            setText("Video  : " + e.getNom_vid() + "\n" + "Category " + e.getCat_vid()
                                    + "\n" + "Description :  \n " + e.getDesc_vid()
                            );
pathfile=e.getPath_vid();
                        }
                    }
                }
            };
               cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    System.out.println("You clicked on " + cell.getItem());
                                             
                    media = new Media(pathfile);
                    mediaplayer = new MediaPlayer(media);
                    mediaView.setMediaPlayer(mediaplayer);
                     mediaplayer.play();
                    
                    e.consume();
                }
            });
            return cell;
        }
        );
          
        listvideo.setItems(list);

        }
       @FXML  
  private void play(ActionEvent event){
    mediaplayer.play();
    mediaplayer.setRate(1);
    }  
 @FXML  
     private  void pause(ActionEvent event){
       mediaplayer.pause();
  }    
     @FXML
        private  void stop(ActionEvent event){
       mediaplayer.seek(   mediaplayer.getTotalDuration());
       mediaplayer.stop();
    }
     
      @FXML
      private void fast(ActionEvent event){
       mediaplayer.setRate(1.5);//2 is double spped then normal
    }    
       @FXML
       private void faster(ActionEvent event){
       mediaplayer.setRate(2);//slower the the normal by half
    }   
       @FXML
      private void slow(ActionEvent event){
       mediaplayer.setRate(.75);//2 is double spped then normal
    }    
       @FXML
       private void slower(ActionEvent event){
       mediaplayer.setRate(.5);//slower the the normal by half
    }  
       @FXML
      private  void exit(ActionEvent event){
    System.exit(0);
        }      
    }


  /*  @FXML

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
            video1 = "C:\\xampp\\htdocs\\VideoUpload\\Uploads\\" + video;
            System.out.println(video);

            mediaplayer.stop();
            media = new Media(file.toURI().toURL().toExternalForm());
            mediaplayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaplayer);
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Saving video");
            alert1.setHeaderText("Information");
            alert1.setContentText("do you want save this video?");
            Optional<ButtonType> action = alert1.showAndWait();
            if (action.get() == ButtonType.OK) {
                u.CopyImage(video1, file.toPath().toString());
                VideoCrud rc = new VideoCrud();
                rc.ajouterVideo();
            }
        }

    0}*/

    /*@FXML
    private void back(ActionEvent event)
     {
        btnbk.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("vid.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Stage mainstage = new Stage();
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
    *}

    @FXML
    private void next(ActionEvent event
    ) {
        btnnext.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("clips.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Stage mainstage = new Stage();
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
    }

    @FXML
    private void playvideo(MouseEvent event) {
        mediaplayer.play();

    }

    @FXML
    private void pausevideo(MouseEvent event) {

        mediaplayer.pause();
    }

    @FXML
    private void stopvideo(MouseEvent event) {
        mediaplayer.seek(mediaplayer.getStopTime());
        mediaplayer.stop();
    }

    @FXML
    private void open(ActionEvent event) throws MalformedURLException {
        filechooser = new FileChooser();
        filter = new FileChooser.ExtensionFilter("choisir un video", "*.mp4");
        filechooser.setSelectedExtensionFilter(filter);
        File file = filechooser.showOpenDialog(null);
        if (file != null) {
            mediaplayer.stop();
            media = new Media(file.toURI().toURL().toExternalForm());
            mediaplayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaplayer);
        }

    }

    @FXML
    private void close(ActionEvent event) {
    }

    @FXML
    private void help(ActionEvent event) {
    }

        // TODO
    }    */

