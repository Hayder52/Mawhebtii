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

/**
 * FXML Controller class
 *
 * @author Fakhri Argoubi
 */
public class SetDataController implements Initializable {

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

    @FXML
    private void save(ActionEvent event) {
    }
    
}
