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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class LandingPageController implements Initializable {
    @FXML
    private void handleButtonLandingPage(ActionEvent event) throws IOException{
        Parent scene2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(scene2);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.show();
        System.out.println("Berhasil klik mulai sekarang");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
