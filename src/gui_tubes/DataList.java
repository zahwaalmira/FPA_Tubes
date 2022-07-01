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

    public void setDummy() {
        listData.add(new Data("zahwaalmira", "Bekasi", "AB+", "081234445678"));
        listData.add(new Data("alfatihberlian", "Jogja", "O-", "081823982349"));
        listData.add(new Data("andikaraka", "Solo", "B+", "081232344123"));
        listData.add(new Data("raflimuhammad", "Sampit", "A+", "081234434789"));
        listData.add(new Data("syifaaliya", "Bali", "AB-", "081232345987"));
        listData.add(new Data("marettaendah", "Kudus", "O+", "081276545544"));
        listData.add(new Data("javierjinan", "Aceh", "A-", "0812323443322"));
        listData.add(new Data("gunturmaulana", "Cilacap", "B-", "081234447766"));
        listData.add(new Data("harrismahendra", "Medan", "AB+", "081235668899"));
        listData.add(new Data("fahnimaharani", "Lombok", "A+", "081237776677"));
        listData.add(new Data("latifmuhammad", "Klaten", "B+", "081236664455"));
        listData.add(new Data("dzikrimuhammad", "Bekasi", "A-", "081237779231"));
        listData.add(new Data("jamaludinhaikal", "Surabaya", "O+", "08123999112"));
        listData.add(new Data("fadhilahcitra", "Cilacap", "AB-", "081245557890"));
        listData.add(new Data("aisyaputri", "Sulawesi", "B-", "081233333456"));
        listData.add(new Data("wildanmuhammad", "Jogja", "O+", "081232222789"));
        listData.add(new Data("patandyawisnu", "Semarang", "B+", "081232223456"));
        listData.add(new Data("rasyidahmad", "Jakarta", "A+", "081234448866"));
    }

    public void dataChart() {
        
        for (int i = 0; i < listData.size(); i++) {
            System.out.println(listData.size());

            String goldar = listData.get(i).getGoldar();
            if (goldar.equals("A+")) {
                totalAPLUS++;
            } else if (goldar.equals("B+")) {
                totalBPLUS++;
            } else if (goldar.equals("AB+")) {
                totalABPLUS++;
            } else if (goldar.equals("A-")) {
                totalAMIN++;
            } else if (goldar.equals("B-")) {
                totalBMIN++;
            } else if (goldar.equals("AB-")) {
                totalABMIN++;
            } else if (goldar.equals("O-")) {
                totalOMIN++;

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
