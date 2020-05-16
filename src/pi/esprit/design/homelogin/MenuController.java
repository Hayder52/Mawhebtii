/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import edu.connections.interfaces.GestionDesCompteInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class MenuController implements Initializable {

    @FXML
    private BorderPane top;
    @FXML
    private Button btn_home;
    @FXML
    private Button btn_account;
    @FXML
    private Button btn_videos;
    @FXML
    private Button btn_comp;
    @FXML
    private Button btn_nrws;
    @FXML
    private Button btn_abbout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home(ActionEvent event) {
          btn_home.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void account(ActionEvent event) {
        GestionDesCompteInterface.showAdminInterface();
    }

    @FXML
    private void pagevideos(ActionEvent event) {
          btn_videos.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("vid.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void page_competions(ActionEvent event) {
    }

    @FXML
    private void pagenews(ActionEvent event) {
          btn_nrws.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("news.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void pageabbout(ActionEvent event) {
          btn_abbout.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("about.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
    
}
