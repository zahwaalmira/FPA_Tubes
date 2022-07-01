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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUsername;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private CheckBox cbPassword;
    
    @FXML
    private TextField tfPassword;
    
     @FXML
    private void handleButtonLoginUser(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Perhatian");
            alert.setHeaderText("Goldarium saat ini hanya tersedia untuk admin");
            alert.setContentText("Silahkan pilih ulang");
            alert.showAndWait();
    }
    
    @FXML
    private void handleButtonLoginAdmin(ActionEvent event) throws IOException{
        String username, password;
        
        username = tfUsername.getText();
        password = pfPassword.getText();
        
        if(username.isEmpty()|| password.isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Perhatian");
            alert.setHeaderText("Informasi login belum lengkap");
            alert.setContentText("Silahkan lengkapi username dan password");
            alert.showAndWait();
        }else{
            Parent scene2 = FXMLLoader.load(getClass().getResource("Multiscene.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(scene2);
        
        stage.setScene(scene);
        stage.setTitle("Kelola Data Calon Pendonor");
        stage.show();
        System.out.println("Berhasil Masuk");
        }
    }
    
    @FXML
    private void handleButtonSceneRegister(ActionEvent event) throws IOException{
        Parent scene2 = FXMLLoader.load(getClass().getResource("PilihanRegistrasi.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(scene2);
        
        stage.setScene(scene);
        stage.setTitle("Pilihan registrasi");
        stage.show();
        System.out.println("Berhasil klik register");
    }
    
    @FXML
    private void handleButtonSceneResetPW(ActionEvent event) throws IOException{
        Parent scene2 = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(scene2);
        
        stage.setScene(scene);
        stage.setTitle("Reset Password");
        stage.show();
        System.out.println("Berhasil klik reset password");
    }
    
    @FXML
    void changeVisibility(ActionEvent event){
        if(cbPassword.isSelected()){
            tfPassword.setText(pfPassword.getText());
            tfPassword.setVisible(true);
            pfPassword.setVisible(false);
            return;
        }
        pfPassword.setText(tfPassword.getText());
        pfPassword.setVisible(true);
        tfPassword.setVisible(false);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
