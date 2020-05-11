/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mawhebti.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pi.esprit.entities.personnes;
import pi.esprit.services.PersonneCRUD;

/**
 * FXML Controller class
 *
 * @author Fakhri Argoubi
 */
public class InsertDataController implements Initializable {

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
    @FXML
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
    private Label photoLb;
    @FXML
    private Label loginLb;
    @FXML
    private Label pwdLb;
    @FXML
    private Button SaveBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void add(Stage s){
        SaveBtn.setOnAction(e->{
            personnes p =new personnes();
            if(!idTf.getText().equals(null)&&!firstNameTf.getText().equals(null)&&!lastNameTf.getText().equals(null)&&!adressTf.getText().equals(null)
                    &&!profileTf.getText().equals(null)&&!photoTf.getText().equals(null)&&!loginTf.getText().equals(null)&&!pwdTf.getText().equals(null))
            {
                p.setId_user(Integer.parseInt( idTf.getText()));
                p.setNom(lastNameTf.getText());
                p.setPrenom(firstNameTf.getText());
                p.setAdress(adressTf.getText());
                p.setProfil(profileTf.getText());
                p.setPhoto(photoTf.getText());
                p.setLogin(loginTf.getText());
                p.setPwd(pwdTf.getText());
            PersonneCRUD.ajouterPersonne3(p);
            clearTextFields();
            s.close();
            }
        });
        
    }
    
        public void update(Stage s,int id){
        SaveBtn.setOnAction(e->{
                personnes p = new personnes();
                p.setId_user(id);
                p.setNom(lastNameTf.getText());
                p.setPrenom(firstNameTf.getText());
                p.setAdress(adressTf.getText());
                p.setProfil(profileTf.getText());
                p.setPhoto(photoTf.getText());
                p.setLogin(loginTf.getText());
                p.setPwd(pwdTf.getText());
            PersonneCRUD.updatePersonne(p);
            clearTextFields();
            s.close();
        });
        
        
    }
        
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
