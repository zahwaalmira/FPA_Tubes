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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class KonfirmasiPermintaanController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfUsernameTujuan;
    
    @FXML
    private TextField tfDomilisi;
    
    @FXML
    private TextField tfNoTelp;
    
    @FXML
    private ChoiceBox cbUrgensi;
    
    @FXML
    private void handleButtonIzin(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonTolak(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
