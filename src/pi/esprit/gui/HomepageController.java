/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import pi.esprit.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class HomepageController implements Initializable {

    @FXML
    private TabPane tabepanelogin;
    @FXML
    private Tab tabuser;
    @FXML
    private Label lblcreateaccount;
    @FXML
    private Pane sliderpane;
    @FXML
    private Label lbadmin;
    @FXML
    private Label lbuser;
    @FXML
    private Label lbstatus;
    @FXML
    private Tab tabadmin;
    @FXML
    private TextField tftext;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Button btnlogin;
    @FXML
    private ImageView image;
    @FXML
    private StackPane rootpane;
    @FXML
    private AnchorPane anchropane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void openadmintable(MouseEvent event) {
        TranslateTransition toLefttTransition=new TranslateTransition(new Duration(500),lbstatus);
        toLefttTransition.setToX(sliderpane.getTranslateX());
        toLefttTransition.play();
        toLefttTransition.setOnFinished((ActionEvent event1) -> {
            lbstatus.setText("ADMINISTRATEUR");
        });
            tabepanelogin.getSelectionModel().select(tabadmin);
    }

    @FXML
    private void openusertable(MouseEvent event) {
        TranslateTransition toRightAnimation=new TranslateTransition(new Duration(500),lbstatus);
        toRightAnimation.setToX(sliderpane.getTranslateX()+(sliderpane.getPrefWidth()-lbstatus.getPrefWidth()));
        toRightAnimation.play();
        toRightAnimation.setOnFinished((ActionEvent event1) -> {
            lbstatus.setText("USER");
        });
        tabepanelogin.getSelectionModel().select(tabuser);
    }

    @FXML
    private void opencreateaccountscene(MouseEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Createaccount.fxml"));
        Scene loginscene=lbadmin.getScene();
        root.translateYProperty().set(loginscene.getHeight());
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
ResultSet rs=null;
PreparedStatement pst=null;
    @FXML
    private void login(ActionEvent event) throws IOException  {
        try {
            Connection cnx;
            cnx = MyConnection.getInstance().getCnx();
            
            
            
            String sql="select * from personnes where nom=? and pwd=?";
            pst=cnx.prepareStatement(sql);
            pst.setString(1,tftext.getText());
            pst.setString(2,tfpassword.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Useername and password are correct");
                Gestioncompte gs=new Gestioncompte();
                
            }else{
                JOptionPane.showMessageDialog(null,"you don't have account ! let's create it"); 
            }
       
    FXMLLoader loader=new FXMLLoader(getClass().getResource("gestioncompte.fxml"));
    Parent root=loader.load();
    GestioncompteController dpc=loader.getController();
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
             } 
    
    }
    

