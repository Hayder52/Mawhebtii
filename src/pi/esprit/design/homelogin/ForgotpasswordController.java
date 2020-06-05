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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;
import pi.esprit.services.MailService;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class ForgotpasswordController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Button btn_validate;
    @FXML
    private Button btn_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    personnes pt=loggedmembre.getP();
    @FXML
    private void validate(ActionEvent event) throws MessagingException, Exception {
       //  JavaMailutil.sendmail("hamza.esprit5@esprit.tn");
        MailService ms=new MailService();
       ms.sendVerifMail("hamza.argoubi@esprit.tn", pt.getId_user());
    }

    @FXML
    private void back(ActionEvent event) {
         btn_back.getScene().getWindow().hide();
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
    
}
