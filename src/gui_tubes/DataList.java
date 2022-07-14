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
    
    public DataList() {
        listData = FXCollections.observableArrayList();
    }

    public ObservableList<Data> getData() {
        return this.listData;
    }

    public void setData(String username, String domisili, String goldar, String notelp) {
        listData.add(new Data(username, domisili, goldar, notelp));
    }

   
    
}
