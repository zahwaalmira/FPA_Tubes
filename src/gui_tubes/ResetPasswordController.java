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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class ResetPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfEmail;
    
     @FXML
    private void handleButtonKirimTautan(ActionEvent event)throws IOException {
         if (tfEmail.getText().isEmpty()) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Perhatian");
             alert.setHeaderText("Anda belum mengisi alamat email");
             alert.setContentText("Silahkan isi terlebih dahulu");
             alert.showAndWait();
         } else {

             Parent scene2 = FXMLLoader.load(getClass().getResource("Login.fxml"));

             Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

             Scene scene = new Scene(scene2);

             stage.setScene(scene);
             stage.setTitle("Login");
             stage.show();
             System.out.println("Berhasil klik kirim tautan");
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
