/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class KonfirmasiPermintaanController implements Initializable {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
   
    @FXML
    private Button btn1;
    
    @FXML
    private void handleButtonBroadcast1(ActionEvent event) {
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Apakah anda yakin ingin menyebarkan pesan siaran di bawah ini kepada seluruh pengguna bergolongan darah B+?");
        alert.setContentText("[DIBUTUHKAN SEGERA DONOR DARAH B+]\n"
                + "Nama: Muhammad Rafli Fauzi\n"
                + "Golongan darah: B+\n"
                + "Domisili: Palangka Raya\n"
                + "Jumlah pendonor: 3\n"
                + "Rumah Sakit: RS SILOAM\n"
                + "Kontak: 081262626262");
        Optional<ButtonType> result = alert.showAndWait(); 
        if(result.get() == ButtonType.OK){ //supaya kalo button "ok" dipencet button broadcastnya kedisable 
            btn1.setDisable(true);
        }

    }
        @FXML
    private void handleButtonBroadcast2(ActionEvent event) {
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Apakah anda yakin ingin menyebarkan pesan siaran di bawah ini kepada seluruh pengguna bergolongan darah A-?");
        alert.setContentText("[DIBUTUHKAN SEGERA DONOR DARAH A-]\n"
                + "Nama: Andika Raka Wicaksono\n"
                + "Golongan darah: A-\n"
                + "Domisili: Jogja\n"
                + "Jumlah pendonor: 1\n"
                + "Rumah Sakit: RS Sardjito\n"
                + "Kontak: 081262343625");

                alert.showAndWait();
    }
        @FXML
    private void handleButtonBroadcast3(ActionEvent event) {
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Apakah anda yakin ingin menyebarkan pesan siaran di bawah ini kepada seluruh pengguna bergolongan darah AB+?");
        alert.setContentText("[DIBUTUHKAN SEGERA DONOR DARAH AB+]\n"
                + "Nama: Zahwa Almira Kayla\n"
                + "Golongan darah: AB+\n"
                + "Domisili: Bekasi\n"
                + "Jumlah pendonor: 2\n"
                + "Rumah Sakit: RS Mitra Timur\n"
                + "Kontak: 0813555355");
        alert.showAndWait();
    }
        @FXML
    private void handleButtonBroadcast4(ActionEvent event) {
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Apakah anda yakin ingin menyebarkan pesan siaran di bawah ini kepada seluruh pengguna bergolongan darah O+?");
        alert.setContentText("[DIBUTUHKAN DONOR DARAH O+]\n"
                + "Nama: Alfatih Berlian Palsa\n"
                + "Golongan darah: O+\n"
                + "Domisili: Bantul\n"
                + "Jumlah pendonor: 1\n"
                + "Rumah Sakit: RS Elizabeth\n"
                + "Kontak: 081263293761");
        alert.showAndWait();
    }
        @FXML
    private void handleButtonBroadcast5(ActionEvent event) {
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Apakah anda yakin ingin menyebarkan pesan siaran di bawah ini kepada seluruh pengguna bergolongan darah B-?");
        alert.setContentText("[DIBUTUHKAN SEGERA DONOR DARAH B-]\n"
                + "Nama: Atta Petir\n"
                + "Golongan darah: B-\n"
                + "Domisili: Padang\n"
                + "Jumlah pendonor: 5\n"
                + "Rumah Sakit: RS Mitra\n"
                + "Kontak: 08121111125");
        alert.showAndWait();
    }
        @FXML
    private void handleButtonBroadcast6(ActionEvent event) {
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Apakah anda yakin ingin menyebarkan pesan siaran di bawah ini kepada seluruh pengguna bergolongan darah A?");
        alert.setContentText("[DIBUTUHKAN SEGERA DONOR DARAH A+]\n"
                + "Nama: Kani Riyana Adina\n"
                + "Golongan darah: A+\n"
                + "Domisili: Banten\n"
                + "Jumlah pendonor: 2\n"
                + "Rumah Sakit: RSUD Banten\n"
                + "Kontak: 08144433335");
        alert.showAndWait();
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
