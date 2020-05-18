/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import pi.esprit.entities.videos;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class StatistiqueController implements Initializable {

   @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> videos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // Get an array with the English month names.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        // Convert it to a list and add it to our ObservableList of months.
        videos.addAll(Arrays.asList(months));
        
        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(videos);
    }

   
    public void setVideoData(List<video> videos) {
    	
        int[] monthCounter = new int[12];
        for (videos v : video) {
            String type= v.getType();
           
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
        	series.getData().add(new XYChart.Data<>(videos.get(i), monthCounter[i]));
        }
        
        barChart.getData().add(series);
    }
    }    
    

