/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_tubes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zahwa
 */
public class DataList {

    private ObservableList<Data> listData;
    
    
    int totalAPLUS = 0;
    int totalBPLUS = 0;
    int totalABPLUS = 0;
    int totalOPLUS = 0;
    int totalAMIN = 0;
    int totalBMIN = 0;
    int totalABMIN = 0;
    int totalOMIN = 0;

    public DataList() {
        listData = FXCollections.observableArrayList();
    }

    public ObservableList<Data> getData() {
        return this.listData;
    }

    public void setData(String username, String domisili, String goldar, String notelp) {
        listData.add(new Data(username, domisili, goldar, notelp));
    }


    public void dataChart() {
//            ArrayList<Data> dataPengguna = new ArrayList<>();
        TableViewController table =  new TableViewController();
        table.openTabel();
        

        for (int i = 0; i < table.dataPengguna.size(); i++) {

//            String goldar = listData.get(i).getGoldar();
            if (table.dataPengguna.contains("A+")) {
                totalAPLUS++;
            } else if (table.dataPengguna.contains("B+")) {
                totalBPLUS++;
            } else if (table.dataPengguna.contains("AB+")) {
                totalABPLUS++;
            } else if (table.dataPengguna.contains("A-")) {
                totalAMIN++;
            } else if (table.dataPengguna.contains("B-")) {
                totalBMIN++;
            } else if (table.dataPengguna.contains("AB-")) {
                totalABMIN++;
            } else if (table.dataPengguna.contains("O-")) {
                totalOMIN++;

            } else if (table.dataPengguna.contains("O+")) {
                totalOPLUS++;
            }
           
        }

    }

    public int getTotalAPLUS() {
        return totalAPLUS;
    }

    public void setTotalAPLUS(int totalAPLUS) {
        this.totalAPLUS = totalAPLUS;
    }

    public int getTotalBPLUS() {
        return totalBPLUS;
    }

    public void setTotalBPLUS(int totalBPLUS) {
        this.totalBPLUS = totalBPLUS;
    }

    public int getTotalABPLUS() {
        return totalABPLUS;
    }

    public void setTotalABPLUS(int totalABPLUS) {
        this.totalABPLUS = totalABPLUS;
    }

    public int getTotalOPLUS() {
        return totalOPLUS;
    }

    public void setTotalOPLUS(int totalOPLUS) {
        this.totalOPLUS = totalOPLUS;
    }

    public int getTotalAMIN() {
        return totalAMIN;
    }

    public void setTotalAMIN(int totalAMIN) {
        this.totalAMIN = totalAMIN;
    }

    public int getTotalBMIN() {
        return totalBMIN;
    }

    public void setTotalBMIN(int totalBMIN) {
        this.totalBMIN = totalBMIN;
    }

    public int getTotalABMIN() {
        return totalABMIN;
    }

    public void setTotalABMIN(int totalABMIN) {
        this.totalABMIN = totalABMIN;
    }

    public int getTotalOMIN() {
        return totalOMIN;
    }

    public void setTotalOMIN(int totalOMIN) {
        this.totalOMIN = totalOMIN;
    }

    @Override
    public String toString() {
        return "DataList{" + "totalAPLUS=" + totalAPLUS + ", totalBPLUS=" + totalBPLUS + ", totalABPLUS=" + totalABPLUS + ", totalOPLUS=" + totalOPLUS + ", totalAMIN=" + totalAMIN + ", totalBMIN=" + totalBMIN + ", totalABMIN=" + totalABMIN + ", totalOMIN=" + totalOMIN + '}';
    }
    
}
