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
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CariDataController implements Initializable {
    XStream xstream = new XStream(new StaxDriver());

    private ArrayList<Data> dataPengguna = new ArrayList<>();
    private ObservableList pengguna = observableArrayList();
    
    @FXML
    private TableView<Data> tvData;
    
    @FXML
    private TableColumn<Data, String> tcUsername;
    
    @FXML
    private TableColumn<Data, String> tcDomisili;
    
    @FXML
    private TableColumn<Data, String> tcGoldar;
    
    @FXML
    private TableColumn<Data, String> tcNoTelp;
    
    @FXML
    private TextField tfPencarian;
    
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
    
    @FXML
    private void handleButtonCari(ActionEvent event) {
        
    }
    
      @FXML
    private void handleButtonRefresh(ActionEvent event) {
        tfPencarian.setText("");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        openTabel();
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcDomisili.setCellValueFactory(new PropertyValueFactory<>("domisili"));
        tcGoldar.setCellValueFactory(new PropertyValueFactory<>("goldar"));
        tcNoTelp.setCellValueFactory(new PropertyValueFactory<>("notelp"));
        
        for (int i = 0; i < dataPengguna.size(); i++) {
            pengguna.add(dataPengguna.get(i));
        }

        tvData.setItems(pengguna);
        
        //Bungkus objek tableview dalam FilteredList (awalnya menampilkan semua data)
        FilteredList<Data> filteredData = new FilteredList<>(tvData.getItems(), b -> true);
        //Atur Predikat filter setiap kali filter berubah.
        tfPencarian.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(pengguna -> {
                // Jika teks filter kosong, tampilkan semua orang.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(pengguna.getDomisili().toLowerCase().indexOf(lowerCaseFilter)!= -1){
                    return true;
                }else if(pengguna.getGoldar().toLowerCase().indexOf(lowerCaseFilter)!= -1){
                    return true;
                }else{
                    return false;
                }
            });
        });
        // Bungkus FilteredList dalam SortedList.
        SortedList<Data> sortedData = new SortedList<>(filteredData);
        // ikat komparator SortedList ke komparator TableView.
        // Jika tidak, pengurutan TableView tidak akan berpengaruh.
        sortedData.comparatorProperty().bind(tvData.comparatorProperty());
        
        //Tambahkan data yang sudah diurutkan (dan difilter) ke tabel.
        tvData.setItems(sortedData);
        
       
    }    
 
    
}
