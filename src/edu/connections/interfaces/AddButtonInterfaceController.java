/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pi.esprit.entities.PersonForTab;
import pi.esprit.entities.personnes;
import pi.esprit.services.PersonneCRUD;

/**
 * FXML Controller class
 *
 * @author Fakhri Argoubi
 */
public class AddButtonInterfaceController implements Initializable {

    @FXML
    private GridPane gridpane;
    @FXML
    private TextField lastNameTf;
    @FXML
    private TextField idTf;
    @FXML
    private TextField firstNameTf;
    @FXML
    private TextField adressTf;
    @FXML
    private TextField profileTf;
    @FXML
    private TextField loginTf;
    private TextField photoTf;
    @FXML
    private TextField pwdTf;
    @FXML
    private Label idLb;
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
    private Label pwdLb;
    @FXML
    private Button SaveBtn;
    @FXML
    private Label addUserLabel;
    @FXML
    private TextField emailTf;
    @FXML
    private Label emailLb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
         
            if(!idTf.getText().equals(null)&&!firstNameTf.getText().equals(null)&&!lastNameTf.getText().equals(null)&&!adressTf.getText().equals(null)
                    &&!profileTf.getText().equals(null)&&!photoTf.getText().equals(null)&&!loginTf.getText().equals(null)&&!pwdTf.getText().equals(null))
            {
            PersonForTab p = new PersonForTab(idTf.getText(), lastNameTf.getText(), 
                    firstNameTf.getText(), emailTf.getText(), profileTf.getText(), 
                    "gre", loginTf.getText(), pwdTf.getText(), adressTf.getText()) ;   
            PersonneCRUD.ajouterPersonne3(p);
            clearTextFields();
            Node  source = (Node)  event.getSource(); 
            Stage stage  = (Stage) source.getScene().getWindow();
    stage.close();
    }}
     public void clearTextFields(){
    lastNameTf.clear();
    idTf.clear();
    firstNameTf.clear();
    adressTf.clear();
    profileTf.clear();
    loginTf.clear();
    photoTf.clear();
    pwdTf.clear();
        
    }
    
}
