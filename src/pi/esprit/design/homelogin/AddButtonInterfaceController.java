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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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
    private TextField firstNameTf;
    @FXML
    private TextField adressTf;
    @FXML
    private TextField profileTf;
    @FXML
    private TextField loginTf;
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
    private Button SaveBtn;
    @FXML
    private PasswordField pwdPF;
    @FXML
    private Button backBtn;
    @FXML
    private Label addLb;
    @FXML
    private Button uploadBtn;
    @FXML
    private ImageView imgViewer;
    @FXML
    private Label emailLb;
    @FXML
    private Label pwdLb1;
    @FXML
    private TextField emailtf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
        final personnes p= new personnes(0, lastNameTf.getText(), firstNameTf.getText(), emailtf.getText()
                , profileTf.getText(),null , loginTf.getText(), pwdPF.getText(),
                adressTf.getText());
                    
            PersonneCRUD pc = new PersonneCRUD();
            pc.ajouterPersonne3(p);
            
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION); 
            a.setContentText("User successfully added");
            if (a.getResult() == ButtonType.OK){
               
            }
            a.show();
    }

    @FXML
    private void back(ActionEvent event) {
        Stage stage = (Stage) lastNameLb.getScene().getWindow();
         Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminAccountManagement.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        Scene scene = new Scene(root);
        stage.setTitle("Hello Guys!");
        stage.setScene(scene);
        stage.show();
    }
    
}
