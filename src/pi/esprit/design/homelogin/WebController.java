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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class WebController implements Initializable {

    @FXML
    private WebView vieww;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    final WebEngine web=vieww.getEngine();
    String urlweb="http://google.com";
    web.load(urlweb);
    }    

    @FXML
    private void fb(ActionEvent event) {
         final WebEngine web=vieww.getEngine();
    String urlweb="https://web.facebook.com/";
    web.load(urlweb);
    }

    @FXML
    private void wh(ActionEvent event) {
         final WebEngine web=vieww.getEngine();
    String urlweb="http://web.whatsapp.com/";
    web.load(urlweb);
    }

    @FXML
    private void yt(ActionEvent event) {
         final WebEngine web=vieww.getEngine();
    String urlweb="https://www.youtube.com/";
    web.load(urlweb);
    }

}
