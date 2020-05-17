/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class StatController implements Initializable {

    @FXML
    private PieChart pc;
    @FXML
    private Button btn_load;
    @FXML
    private Label lb;
    @FXML
    private Button btn_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void load_pc(ActionEvent event) {
          ObservableList<Data> details= FXCollections.observableArrayList();
           details.addAll(new PieChart.Data("sports", 20),
            new PieChart.Data("arts",31),
            new PieChart.Data("musique",10),
            new PieChart.Data("danse",20),
            new PieChart.Data("sports",21)
            );
           pc.setData(details);
            pc.setTitle("statistiques des videos");
        pc.setLegendSide(Side.BOTTOM);
        pc.setLabelsVisible(true);
        for(final PieChart.Data data :pc.getData()){
            
            data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lb.setText(String.valueOf((data.getPieValue()/102)*100+"%"));
                }
                
            });
        }
    }

    @FXML
    private void back(ActionEvent event) {
         btn_back.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
    
}
