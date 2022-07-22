/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


public class StatistikController implements Initializable {
    XStream xstream = new XStream(new StaxDriver());
    private ArrayList<Data> dataPengguna = new ArrayList<>();
    private Data data;
    private XYChart.Series<String, Integer> dataGoldar = new XYChart.Series<>();
    private int totalAPLUS = 0;
    private int totalBPLUS = 0;
    private int totalABPLUS = 0;
    private int totalOPLUS = 0;
    private int totalAMIN = 0;
    private int totalBMIN = 0;
    private int totalABMIN = 0;
    private int totalOMIN = 0;
    
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

        for(int i = 0; i < dataPengguna.size(); i++){ //ambil objek dari arraylistlist untuk dimasukin ke dalam objek data
            //biar bisa manggil method get set
           data = (Data) dataPengguna.get(i);
           //nyocokin goldar pengguna 
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
        //isi data goldar dan jumlah ke objek XYChart.Series
            dataGoldar.getData().add(new XYChart.Data("A+", totalAPLUS));
            dataGoldar.getData().add(new XYChart.Data("B+", totalBPLUS));
            dataGoldar.getData().add(new XYChart.Data("O+", totalOPLUS));
            dataGoldar.getData().add(new XYChart.Data("AB+", totalABPLUS));
            dataGoldar.getData().add(new XYChart.Data("A-", totalAMIN));
            dataGoldar.getData().add(new XYChart.Data("B-", totalBMIN));
            dataGoldar.getData().add(new XYChart.Data("O-", totalOMIN));
            dataGoldar.getData().add(new XYChart.Data("AB-", totalABMIN));
 
        //menambahkan objek XYChart.series di objek bar chart     
        bcGoldar.getData().addAll(dataGoldar); //agar tampil di bar chart
    }    
    
}
