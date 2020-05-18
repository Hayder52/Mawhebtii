package edu.connections.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAHHOUTTA
 */
public class CategorieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Button btnMusique;

    private Button btnDanse;

    private Button btn_Timetable;
    @FXML
    private AnchorPane fashionbt;
    @FXML
    private Button Musicbt;
    @FXML
    private Button dancebt;
    @FXML
    private Button artbt;
    @FXML
    private Button camerabt;
    @FXML
    private ImageView sportbt;


    //my bad - the freaking mouse event
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnMusique) {
            loadStage("/home/fxml/Musique.fxml");
        } else if (mouseEvent.getSource() == btnDanse) {
            loadStage("/home/fxml/Dance.fxml");
        } else if (mouseEvent.getSource() == fashionbt) {
            loadStage("/home/fxml/Art.fxml");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("Media/icon.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}