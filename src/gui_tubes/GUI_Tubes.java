/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package gui_tubes;


import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GUI_Tubes extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Selamat Datang di Goldarium!");
        stage.getIcons().add(new Image("img/blood-drop.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    //Andika Raka Wicaksono 21523146
    //Muhamad Rafli Fauzi 21523042
    //Al-Fatih Berlian Palsa 21523095
    //Zahwa Almira Kayla 21523224

    //username bebas, password bebas tapi harus 8 digit
    }
    
}
