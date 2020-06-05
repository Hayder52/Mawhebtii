/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author abassi
 */
public class GestionCompetitionController implements Initializable {

    @FXML
    private Button btn_selection;
    @FXML
    private DatePicker date_deb;
    @FXML
    private TextField tfNom_competition;
    @FXML
    private MenuButton btn_id_cat;
    @FXML
    private DatePicker date_fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selection(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("GestionCompetition.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
