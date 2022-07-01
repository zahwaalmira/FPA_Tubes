/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_tubes;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author zahwa
 */
public class OpenScene {
     private Pane halaman;
    
    public Pane getPane(String namaFile){
        try{
            URL fileHalaman = GUI_Tubes.class.getResource("/gui_tubes/"+namaFile+".fxml");
            
            if(fileHalaman == null){
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }
            
            halaman = FXMLLoader.load(fileHalaman);
        }catch(Exception e){
            System.out.println("Tidak ditemukan halaman tersebut");
        }
        return halaman;
    }
}
