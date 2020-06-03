/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;
import pi.esprit.services.PersonneCRUD;

/**
 * FXML Controller class
 *
 * @author Fakhri Argoubi
 */
public class OtherProfilesController implements Initializable {

    @FXML
    private GridPane gridpane;
    @FXML
    private Label lastNameLb;
    @FXML
    private Label firstNameLb;
    @FXML
    private Label adressLb;
    @FXML
    private Label profileLb;
    @FXML
    private Label loginLb;
    @FXML
    private Label emailLb;
    @FXML
    private Label sqlLastNameLb;
    @FXML
    private Label sqlFirstNameLb;
    @FXML
    private Label sqlEmailLB;
    @FXML
    private Label sqlLoginLb;
    @FXML
    private Label sqlProfileLb;
    @FXML
    private Label sqlAdressLb;
    @FXML
    private Button backBtn;
    @FXML
    private Label profileLabel;
    @FXML
    private Button sendFriendRequestBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         personnes lm = loggedmembre.getP();
        PersonneCRUD pc = new PersonneCRUD();
        personnes p = pc.selectUser(lm.getId_user());
        
        sqlLastNameLb.setText(p.getNom());
        sqlFirstNameLb.setText(p.getPrenom());
        sqlProfileLb.setText(p.getProfil());
        sqlEmailLB.setText(p.getEmail());
        sqlAdressLb.setText(p.getAdress());
        sqlLoginLb.setText(p.getLogin());
    }    

    @FXML
    private void back(ActionEvent event) {
        Stage stage = (Stage) profileLabel.getScene().getWindow();
         Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("ListOfUsers.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        Scene scene = new Scene(root);
        stage.setTitle("Hello Guys!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sendRequest(ActionEvent event) {
    }
    
}
