/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui_tubes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class StatistikController implements Initializable {
    DataList data;
    XYChart.Series<String, Integer> dataGoldar = new XYChart.Series<>();
    
    @FXML
    private BarChart bcGoldar;
    
    @FXML
    private ChoiceBox cbGoldar;
    
    @FXML
    private TextField tfJumlah;
    

    
    @FXML
    private void handleTambahAction(ActionEvent event) {
        System.out.println("TambahButton is clicked");
        String goldar = cbGoldar.getValue().toString();
        int jumlah = Integer.valueOf(tfJumlah.getText());
        
        for(int i = 0; i < dataGoldar.getData().size(); i++){
            int nilaiAwal = Integer.valueOf(dataGoldar.getData().get(i).YValueProperty().get());
            if(dataGoldar.getData().get(i).XValueProperty().get().equals(goldar)){
                dataGoldar.getData().get(i).YValueProperty().set(nilaiAwal + jumlah);
            }
        }
        
        cbGoldar.getSelectionModel().clearSelection();
        tfJumlah.setText("");
    }
    
    @FXML
    private void handleKurangAction(ActionEvent event) {
        System.out.println("KurangButton is clicked");
        String goldar = cbGoldar.getValue().toString();
        int jumlah = Integer.valueOf(tfJumlah.getText());
        
        for(int i = 0; i < dataGoldar.getData().size(); i++){
            int nilaiAwal = Integer.valueOf(dataGoldar.getData().get(i).YValueProperty().get());
            if(dataGoldar.getData().get(i).XValueProperty().get().equals(goldar)){
                dataGoldar.getData().get(i).YValueProperty().set(nilaiAwal - jumlah);
            }
        }
        
        cbGoldar.getSelectionModel().clearSelection();
        tfJumlah.setText("");
  
    }
    
    @FXML
    private void handlecoba(ActionEvent event) {
        System.out.println(data.totalABMIN);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = new DataList();
        cbGoldar.setValue("Golongan Darah");
        cbGoldar.getItems().addAll("A+","B+","O+","AB+","A-", "B-", "O-", "AB-");
        
  
//        dataGoldar.getData().add(new XYChart.Data("A+", 770));
//        dataGoldar.getData().add(new XYChart.Data("B+", 900));
//        dataGoldar.getData().add(new XYChart.Data("O+", 1200));
//        dataGoldar.getData().add(new XYChart.Data("AB+", 500));
//        dataGoldar.getData().add(new XYChart.Data("A-", 400));
//        dataGoldar.getData().add(new XYChart.Data("B-", 550));
//        dataGoldar.getData().add(new XYChart.Data("O-", 670));
//        dataGoldar.getData().add(new XYChart.Data("AB-", 200));
////    
        data.setDummy();
        data.dataChart();
        System.out.println(data.toString());
        
        dataGoldar.getData().add(new XYChart.Data("A+", data.totalAPLUS));
        dataGoldar.getData().add(new XYChart.Data("B+", data.totalBPLUS));
        dataGoldar.getData().add(new XYChart.Data("O+", data.totalOPLUS));
        dataGoldar.getData().add(new XYChart.Data("AB+", data.totalABPLUS));
        dataGoldar.getData().add(new XYChart.Data("A-", data.totalAMIN));
        dataGoldar.getData().add(new XYChart.Data("B-", data.totalBMIN));
        dataGoldar.getData().add(new XYChart.Data("O-", data.totalOMIN));
        dataGoldar.getData().add(new XYChart.Data("AB-", data.totalABMIN));
        
        
             
        bcGoldar.getData().addAll(dataGoldar);
    }    
    
}
