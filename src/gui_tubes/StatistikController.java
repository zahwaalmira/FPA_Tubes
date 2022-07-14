/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui_tubes;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
     XStream xstream = new XStream(new StaxDriver());
    ArrayList<Data> dataPengguna = new ArrayList<>();
    Data data;
    XYChart.Series<String, Integer> dataGoldar = new XYChart.Series<>();
         int totalAPLUS = 0;
    int totalBPLUS = 0;
    int totalABPLUS = 0;
    int totalOPLUS = 0;
    int totalAMIN = 0;
    int totalBMIN = 0;
    int totalABMIN = 0;
    int totalOMIN = 0;
    
    @FXML
    private BarChart bcGoldar;
    
    void openTabel() {
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("berkas.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            dataPengguna = (ArrayList<Data>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        openTabel();

        for(int i = 0; i < dataPengguna.size(); i++){
           data = (Data) dataPengguna.get(i);
           if(data.getGoldar().equals("A+")){
               totalAPLUS++;
           }else if(data.getGoldar().equals("B+")){
               totalBPLUS++;
           }else if(data.getGoldar().equals("AB+")){
               totalABPLUS++;
           }else if(data.getGoldar().equals("O+")){
               totalOPLUS++;
           }else if(data.getGoldar().equals("A-")){
               totalAMIN++;
           }else if(data.getGoldar().equals("B-")){
               totalBMIN++;
           }else if(data.getGoldar().equals("AB-")){
               totalABMIN++;
           }else if(data.getGoldar().equals("O-")){
               totalOMIN++;
           }
            
        }
        dataGoldar.getData().add(new XYChart.Data("A+", totalAPLUS++));
            dataGoldar.getData().add(new XYChart.Data("B+", totalBPLUS));
            dataGoldar.getData().add(new XYChart.Data("O+", totalOPLUS));
            dataGoldar.getData().add(new XYChart.Data("AB+", totalABPLUS));
            dataGoldar.getData().add(new XYChart.Data("A-", totalAMIN));
            dataGoldar.getData().add(new XYChart.Data("B-", totalBMIN));
            dataGoldar.getData().add(new XYChart.Data("O-", totalOMIN));
            dataGoldar.getData().add(new XYChart.Data("AB-", totalABMIN));
   
        
        
             
        bcGoldar.getData().addAll(dataGoldar);
    }    
    
}
