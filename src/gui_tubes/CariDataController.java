/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui_tubes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class CariDataController implements Initializable {
    
     DataList data;
    
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
    
//    FilteredLisr<Data> filteredData = new FilteredList<>(listData)
    
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
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcDomisili.setCellValueFactory(new PropertyValueFactory<>("domisili"));
        tcGoldar.setCellValueFactory(new PropertyValueFactory<>("goldar"));
        tcNoTelp.setCellValueFactory(new PropertyValueFactory<>("notelp"));
        
        data = new DataList();
        data.setDummy();
        
        FilteredList<Data> filteredData = new FilteredList<>(data.getData(), b -> true);
        tfPencarian.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(pengguna -> {
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
        
        SortedList<Data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvData.comparatorProperty());
        
//        data = new DataList();
//        data.setDummy();
        tvData.setItems(sortedData);
        
       
    }    
 
    
}
