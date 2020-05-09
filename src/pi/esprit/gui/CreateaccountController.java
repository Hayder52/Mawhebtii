/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import edu.connections.entities.personnes;
import edu.connections.services.PersonneCRUD;
import java.awt.FileDialog;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JFrame;
import pi.esprit.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class CreateaccountController implements Initializable {

    @FXML
    private Button btnlogin;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private ImageView image;
    @FXML
    private Label lbllogin;
    @FXML
    private AnchorPane anchropane;
    @FXML
    private TextField tadress;
    @FXML
    private TextField tlastname;
    @FXML
    private TextField tfirstname;
    @FXML
    private TextField tphoto;
    @FXML
    private Button btnphoto;
    @FXML
    private TextField tage;
    @FXML
    private Button txtconfirmation;
    @FXML
    private Label message1;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
    }    

    @FXML
    private void openloginscene(MouseEvent event){
        try {
            Parent root=FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene accountScene=lbllogin.getScene();
            root.translateYProperty().set(accountScene.getHeight());
            //get an instance of stackpane from the parent
            StackPane rootpane=(StackPane) accountScene.getRoot();
            rootpane.getChildren().add(root);
            Timeline timeline=new Timeline();
            KeyValue keyValue=new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame keyFrame=new KeyFrame(Duration.seconds(2),keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            timeline.setOnFinished((ActionEvent event1) -> {
                rootpane.getChildren().remove(anchropane);
            });
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }

    @FXML
    private void create(ActionEvent event) {
       message1.setVisible(false);
		message.setVisible(false);
			if(tlastname.getText().isEmpty() || tfirstname.getText().isEmpty() || tphoto.getText().isEmpty() ||tage.getText().isEmpty()|| tfpassword.getText().isEmpty()) {
				                        System.out.println("data is not available");
				return;
			}
			
			else {
                            
                        }
				
       
 

    }
   
       
     public String GenMotPass() {
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(8);
	    for (int i = 0; i < 8; i++) {
	        int randomLimitedInt = 97 + (int) 
	          (random.nextFloat() * (122 - 97 + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String mot_pass = buffer.toString();
	    return mot_pass;
	
	}   

    @FXML
    private void uploadphoto(ActionEvent event) {
    }
        
    
        
    }
    

