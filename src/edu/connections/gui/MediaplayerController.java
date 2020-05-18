/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.gui;

import edu.connections.utils.uploadhhtp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MAHHOUTTA
 */
public class MediaplayerController implements Initializable {

  @FXML  private MediaView mv;
 @FXML 
 private MediaPlayer mp;

 private String filepath ;
  String charset = "UTF-8";
    @FXML
    private Button openfilebt;
    @FXML
    private Button playbt;
    @FXML
    private Button pausebt;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /*  String path =new File("src/Media/videotest.mp4").getAbsolutePath();
        
        me= new Media(new File(path).toURI().toString());
        mp= new MediaPlayer(me);
        mv.setMediaPlayer(mp);
       // mp.setAutoPlay(true);
   DoubleProperty width =mv.fitWidthProperty();
   DoubleProperty height =mv.fitHeightProperty();
   width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
   height.bind(Bindings.selectDouble(mv.sceneProperty(),"Heigt"));

    }  */}
    @FXML
    public void Openfile(ActionEvent event){
    FileChooser filechooser = new FileChooser();
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file *.mp3,*.mp4,*.vlc","*mp4");
    filechooser.getExtensionFilters().add(filter);
    File file= filechooser.showOpenDialog(null);
   filepath=file.toURI().toString();
    
      Path filepath1 = file.toPath();
     if (filepath!=null){
        
         Media me = new Media(filepath);
         mp= new MediaPlayer(me);
         mv.setMediaPlayer(mp);
    DoubleProperty width =mv.fitWidthProperty();
   DoubleProperty height =mv.fitHeightProperty();
    width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
   height.bind(Bindings.selectDouble(mv.sceneProperty(),"Heigt"));      
          mp.play();
     
    } }   
  @FXML  
  private void uploaddFile(ActionEvent event) throws FileNotFoundException, IOException{
      
   String url="http://localhost:8080/VideoUpload/Uploads";
         InputStream inputStream = new FileInputStream("C:\\test\\ma.mp4");//upload l'image
        System.out.println("Start uploading second file");

        OutputStream output = new FileOutputStream(url);
        byte[] bytesIn = new byte[4096];
        int read = 1;
        while ((read = inputStream.read(bytesIn)) != -1) {//copier l'image au serveur
            output.write(bytesIn, 0, read);
        }
        System.out.println("uploaded");
        output.close();
        inputStream.close();
    }
   /*   File uploadFile= new File("C:\\test\\ma.mp4");
         String fileName = uploadFile.getName();
   String requestURL = "http://localhost:8080/VideoUpload/Uploads";
    try {
         uploadhhtp multipart = new uploadhhtp(requestURL, charset);
           
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Cool Pictures");
            multipart.addFormField("keywords", "Java,upload,Spring");
             
            multipart.addFilePart("fileUpload", uploadFile);
          
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex+"Main prob is here");
        }
     */
    
    
   @FXML  
  private void play(ActionEvent event){
    mp.play();
    mp.setRate(1);
    }  
 @FXML  
     private  void pause(ActionEvent event){
    mp.pause();
  }    
     @FXML
        private  void stop(ActionEvent event){
    mp.seek(mp.getTotalDuration());
    mp.stop();
    }
     
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
      
            }
