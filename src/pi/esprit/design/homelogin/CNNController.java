/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import pi.esprit.entities.Feed;
import pi.esprit.entities.FeedMessage;
import static pi.esprit.services.RssFeed.readrss;
import pi.esprit.services.RssFeedParser;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class CNNController implements Initializable {

    @FXML
    private Button click;
    @FXML
    private Button btn_back;
    @FXML
    private TextArea textarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println(readrss("http://rss.cnn.com/rss/edition.rss"));
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }    

    @FXML
    private void RssFeed(ActionEvent event) {
         RssFeedParser parser = new RssFeedParser(
                "http://rss.cnn.com/rss/edition.rss");
        Feed feed = parser.readFeed();
     
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
           textarea.setText(message.getDescription());;

        }
    }

    @FXML
    private void back(ActionEvent event) {
         btn_back.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("Menuprincipale.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
    
}
