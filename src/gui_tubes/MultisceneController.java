/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui_tubes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class MultisceneController implements Initializable {
    OpenScene bukaScene = new OpenScene();
    
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private BorderPane mainPane1;
    
    
     @FXML
    private void handleButtonHalamanDaftarPengguna(ActionEvent event) {
        Pane halaman = bukaScene.getPane("DaftarPengguna");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman Data Calon Pendonor is clicked!");
    }
    
    
    @FXML
    private void handleButtonHalamanStatistik(ActionEvent event) {
        Pane halaman = bukaScene.getPane("Statistik");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman Statistik is clicked!");
    }
    
    @FXML
    private void handleButtonHalamanKelolaData(ActionEvent event) {
        Pane halaman = bukaScene.getPane("TableView");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman Kelola Data is clicked!");
    }
    
    @FXML
    private void handleButtonHalamanCariData(ActionEvent event) {
        Pane halaman = bukaScene.getPane("CariData");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman Cari Data is clicked!");
    }
    
    @FXML
    private void handleButtonHalamanKonfirmasi(ActionEvent event) {
        Pane halaman;
        halaman = bukaScene.getPane("KonfirmasiPermintaan");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman Konfirmasi permintaan is clicked!");
    }
    
    @FXML
    private void handleButtonBeranda(ActionEvent event) {
        Pane halaman;
        halaman = bukaScene.getPane("Beranda");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman beranda is clicked!");
    }
    
    @FXML
    private void handleButtonAkun(ActionEvent event) {
        Pane halaman;
        halaman = bukaScene.getPane("InformasiAkun");
        mainPane.setCenter(halaman);
        System.out.println("Button halaman informasi akun is clicked!");
    }
    
    @FXML
    private void handleButtonHalamanLogOut(ActionEvent event)throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(scene2);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Landing page");
        stage.show();
        System.out.println("Berhasil klik log out");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Pane halaman;
        halaman = bukaScene.getPane("Beranda");
        mainPane.setCenter(halaman);
        
    }    
    
}
