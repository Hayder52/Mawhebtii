/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import java.awt.FileDialog;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private TextField tbirthday;
    @FXML
    private TextField tlastname;
    @FXML
    private TextField tfirstname;
    @FXML
    private TextField tphoto;
    @FXML
    private Button btnphoto;

   
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
   
 
    }    

    @FXML
    private void openloginscene(MouseEvent event) throws IOException {
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
    }

    @FXML
    private void create(ActionEvent event) {
        try {
            Connection cnx;
            
            
            cnx = MyConnection.getInstance().getCnx();
            
            
            String requete2 = "INSERT INTO personnes(nom,prenom,adress,profil,photo,login,pwd)"  
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst;
     
            pst = cnx.prepareStatement(requete2);
            
            
             
            
            
  
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
        
    }

    @FXML
    private void uploadphoto(ActionEvent event) {
        
        btnphoto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
            }
        });
        
        
    }
        
    }
    

