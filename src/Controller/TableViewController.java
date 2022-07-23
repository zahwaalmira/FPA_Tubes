/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.*;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class TableViewController implements Initializable {
    XStream xstream = new XStream(new StaxDriver());
   
    private ArrayList<Data> dataPengguna = new ArrayList<>();
    
    private ObservableList pengguna = observableArrayList();
    
    Alert alert = new Alert(Alert.AlertType.WARNING);
    
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
    

     
    void openTabel() { //baca data //dari xml ke objek list
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("berkas.xml");//menerima data dari pembacaan file berformat xml bernama berkas.
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) { //Data byte dibaca dan dikonversi satu persatu ke char hingga ditemukan end of file.
                c = (char) isi; //konversi dari byte ke char
                s = s + c; //Kumpulan char disatukan dalam objek s bertipe String.
            }
            dataPengguna = (ArrayList<Data>) xstream.fromXML(s); //objek s dikonversi ke objek arraylist
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    void SaveAndCreate(){ //simpan data //dari objek list ke xml
        FileOutputStream outputDoc;
        String xml = xstream.toXML(dataPengguna);//Konversi objek dataPengguna ke format XML
        File f = new File("berkas.xml");
        try{
            byte[] data = xml.getBytes("UTF-8");
            outputDoc = new FileOutputStream("berkas.xml"); //menuliskan data tersebut ke file,dibutuhkan objek dari class FileOutputStream.
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("Berhasil tambah/edit/hapus data");
        }catch(Exception error){
            System.err.println("An error occur: " + error.getMessage());
        }
        
    }
            

    @FXML
    private void handleButtonTambah(ActionEvent event) {
         

        String username = tfUsername.getText();
        String domisili = tfDomisili.getText();
        String goldar = cbGoldar.getValue().toString();
        String noTelp = tfNoTelp.getText();
      
        if (username.isEmpty() || domisili.isEmpty() || goldar.isEmpty() 
                || noTelp.isEmpty()) {
            alert.setTitle("Perhatian");
            alert.setHeaderText("Informasi data belum lengkap");
            alert.setContentText("Silahkan lengkapi data yang masih kosong");
            alert.showAndWait();
        }else if (!noTelp.matches("[0-9]+")) {
            alert.setTitle("Perhatian");
            alert.setHeaderText("Nomor telepon harus berupa angka");
            alert.setContentText("Silahkan periksa kembali");
            alert.showAndWait();
            tfNoTelp.setText(" ");
        } else if (noTelp.length() != 12) {
            alert.setTitle("Perhatian");
            alert.setHeaderText("Jumlah digit nomor telepon harus 12");
            alert.setContentText("Silahkan periksa kembali");
            alert.showAndWait();
        } else {
            System.out.println("Penambahan berhasil");
            openTabel();
            dataPengguna.add(new Data(username, domisili, goldar, noTelp)); //nambahin atribut2 dari kelas data ke array list

            tfUsername.setText("");
            tfDomisili.setText("");
            cbGoldar.getSelectionModel().clearSelection();
            tfNoTelp.setText("");
            
            pengguna.add(dataPengguna.get(dataPengguna.size()-1)); //index data pengguna yang terakhir dimasukkin ke observable list
            tvData.setItems(pengguna);
            SaveAndCreate();
        }

    }
    
    
    @FXML
    public void handleButtonHapus(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel = tvData.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE); //menspesifikkan baris mana yang ingin di hapus
        int i = selectionModel.getSelectedIndex();
        if (selectionModel.isEmpty()) {
            alert.setTitle("Perhatian");
            alert.setHeaderText("Anda belum memilih data yang ingin dihapus");
            alert.setContentText("Silahkan pilih terlebih dahulu");
            alert.showAndWait();

        } else {
            openTabel();
            dataPengguna.remove(i);
            pengguna.remove(i);

            SaveAndCreate();
        }
      
    }
    
    @FXML
    private void handleButtonEdit(ActionEvent event) {
            openTabel();
        
        tvData.setEditable(true); //buat table supaya bisa diedit
        //textfieldtablecell untuk membuat textfield di dalam table column 
        //dan memungkinkan untuk diedit ketike cellnya di double click
        //set cell factory = memberikan data yang terkandung dalam tiap cell
        tcUsername.setCellFactory(TextFieldTableCell.forTableColumn()); 
        tcDomisili.setCellFactory(TextFieldTableCell.forTableColumn());
        tcGoldar.setCellFactory(TextFieldTableCell.forTableColumn());
        tcNoTelp.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //CellEditEvent = Peristiwa yang dipicu saat pengguna melakukan pengeditan pada sel tabel.
        //supaya kalo abis diedit ga balik seperti semula
        tcUsername.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){ //memproses pengeditan dan memberikan nilai yang diperbarui ke sel tabel yang sesuai.
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue(); //ambil objek kelas data untuk baris yang sedang diedit
                data.setUsername(event.getNewValue()); //set dengan nilai yang baru dienter melalui textfield tadi 
                SaveAndCreate();
            }
                
        });
        
        tcDomisili.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setDomisili(event.getNewValue());
                SaveAndCreate();
            }
                
        });
        
        tcGoldar.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setGoldar(event.getNewValue());
                SaveAndCreate();
            }
                
        });
        
        tcNoTelp.setOnEditCommit(new EventHandler<CellEditEvent<Data, String>>(){
            
            @Override
            public void handle(CellEditEvent<Data, String> event){
                Data data = event.getRowValue();
                data.setNotelp(event.getNewValue());
                SaveAndCreate();
            }
                
        });
        //absen isi arraylist yang baru, masukkan ke observablelist, set ke tabel
        for (int i = 0; i < dataPengguna.size(); i++){
            pengguna.add(dataPengguna.get(i));
        }
        tvData.setItems(pengguna);
        
    }
    


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        openTabel();
        cbGoldar.setValue("Golongan Darah");
        cbGoldar.getItems().addAll("A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-");
        
        //Set cell value factory = digunakan untuk "memilih" bagian tertentu dari item TableView, yang harus ditampilkan dalam kolom tertentu.
        //Inisialisasi kolom tabel sesuai dengan atribut dari objek kelas Data.
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcDomisili.setCellValueFactory(new PropertyValueFactory<>("domisili"));
        tcGoldar.setCellValueFactory(new PropertyValueFactory<>("goldar"));
        tcNoTelp.setCellValueFactory(new PropertyValueFactory<>("notelp"));
        
        //nampilin data dari arraylist ke table pake bantuan observablelist
        //supaya pas diklik halamannya tabelnya sudah berisi data
        for (int i = 0; i < dataPengguna.size(); i++) {
            pengguna.add(dataPengguna.get(i));

        }

        tvData.setItems(pengguna);

        

    }

}


