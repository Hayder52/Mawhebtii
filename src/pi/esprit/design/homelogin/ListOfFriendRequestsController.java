/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fakhri Argoubi
 */
public class ListOfFriendRequestsController implements Initializable {

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    @FXML
    private TableColumn<?, ?> lastNameColumn;
    @FXML
    private Button reportBtn;
    @FXML
    private Label label;
    @FXML
    private Button backBtn;
    @FXML
    private TextField searchTf;
    @FXML
    private Button viewProfileBtn;
    @FXML
    private Button acceptInvitationBtn;
    @FXML
    private Button declineInviteBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void report(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }


    @FXML
    private void viewProfile(ActionEvent event) {
    }

    @FXML
    private void acceptInvite(ActionEvent event) {
    }

    @FXML
    private void declineInvite(ActionEvent event) {
    }
    
}
