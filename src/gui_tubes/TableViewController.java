/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui_tubes;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author zahwa
 */
public class TableViewController implements Initializable {
     XStream xstream = new XStream(new StaxDriver());
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
    
    void SaveAndCreate(){
        FileOutputStream outputDoc;
        String xml = xstream.toXML(dataPengguna);
        File f = new File("berkas.xml");
        try{
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("berkas.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("Berhasil tambah/edit/hapus data");
        }catch(Exception error){
            System.err.println("An error occur: " + error.getMessage());
        }
        
    }
    
    DataList data;
   
    ArrayList<Data> dataPengguna = new ArrayList<>();
    ObservableList pengguna = observableArrayList();
    
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
    private TextField tfUsername;
    
    @FXML
    private TextField tfDomisili;
    
    @FXML
    private ChoiceBox cbGoldar;
    
    @FXML
    private TextField tfNoTelp;
    
    
    @FXML
    private void handleButtonTambah(ActionEvent event) {
//        data = new DataList();
        File f = new File("berkas.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("File ada");
            openTabel();
        }
        String username = tfUsername.getText();
        String domisili = tfDomisili.getText();
        String goldar = cbGoldar.getValue().toString();
        String noTelp = tfNoTelp.getText();
        data.setData(username, domisili, goldar, noTelp);
        System.out.println("Penambahan berhasil");
        
        
        dataPengguna.add(new Data(username, domisili, goldar, noTelp));
                tvData.setItems(pengguna);

        tfUsername.setText("");
        tfDomisili.setText("");
        cbGoldar.getSelectionModel().clearSelection();
        tfNoTelp.setText("");
        
        SaveAndCreate();
    }
    
    @FXML
    private void handleButtonHapus(ActionEvent event) {
        File f = new File("berkas.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("File ada");
            openTabel();
        }
//        int selectedIndex = tvData.getSelectionModel().getSelectedIndex();
//        data.getData().remove(selectedIndex);
        SaveAndCreate();
    }
    
    @FXML
    private void handleButtonEdit(ActionEvent event) {
        File f = new File("berkas.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("File ada");
            openTabel();
        }
        tvData.setEditable(true);
        tcUsername.setCellFactory(TextFieldTableCell.forTableColumn());
        tcDomisili.setCellFactory(TextFieldTableCell.forTableColumn());
        tcGoldar.setCellFactory(TextFieldTableCell.forTableColumn());
        tcNoTelp.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tcUsername.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setUsername(event.getNewValue());
            }
                
        });
        
        tcDomisili.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setDomisili(event.getNewValue());
            }
                
        });
        
        tcGoldar.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setGoldar(event.getNewValue());
            }
                
        });
        
        tcNoTelp.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setNotelp(event.getNewValue());
            }
                
        });
        SaveAndCreate();
            
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbGoldar.setValue("Golongan Darah");
        cbGoldar.getItems().addAll("A+","B+","O+","AB+","A-", "B-", "O-", "AB-");
        
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcDomisili.setCellValueFactory(new PropertyValueFactory<>("domisili"));
        tcGoldar.setCellValueFactory(new PropertyValueFactory<>("goldar"));
        tcNoTelp.setCellValueFactory(new PropertyValueFactory<>("notelp"));
        
        data = new DataList();
        data.setDummy();
//        tvData.setItems(data.getData());
        openTabel();
        for (int i = 0; i < dataPengguna.size(); i++) {
            pengguna.add(dataPengguna.get(i));

        }
        for (int i = 0; i < data.getData().size(); i++) {
            pengguna.add(data.getData());
            
        }
        tvData.setItems(pengguna);
        tvData.setItems(data.getData());
    }    
    
}
