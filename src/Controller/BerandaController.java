/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


public class BerandaController implements Initializable {
    XYChart.Series<String, Integer> stokDarah = new XYChart.Series<>();
    
    @FXML
    private BarChart bcStok;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO\
        stokDarah.getData().add(new XYChart.Data("A+", 16611));
        stokDarah.getData().add(new XYChart.Data("B+", 27891));
        stokDarah.getData().add(new XYChart.Data("AB+", 10139));
        stokDarah.getData().add(new XYChart.Data("O+", 33575));
        
         bcStok.getData().addAll(stokDarah);
    }    
    
}
