/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
 *
 * @author zahwa
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField tfNama;
    
    @FXML
    private TextField tfDomisili;
    
    @FXML
    private TextField tfNoTelp;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfUsername;
    
    @FXML
    private TextField tfPassword;
    
    
    @FXML
    private void handleButtonRegister(ActionEvent event) throws IOException{
        String nama = tfUsername.getText();
        String domisili = tfDomisili.getText();
        String notelp = tfNoTelp.getText();
        String email = tfEmail.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        
        if(nama.isEmpty()|| domisili.isEmpty()|| notelp.isEmpty()|| email.isEmpty()
                || username.isEmpty()|| password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Perhatian");
            alert.setHeaderText("Informasi registrasi belum lengkap");
            alert.setContentText("Silahkan lengkapi data yang masih kosong");
            alert.showAndWait();
        }else{
            Parent scene2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(scene2);
              
          stage.setScene(scene);
        stage.setTitle("Halaman utama");
        stage.show();
        System.out.println("Berhasil terdaftar");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
