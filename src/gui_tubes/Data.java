/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_tubes;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author zahwa
 */
public class Data {
    private SimpleStringProperty username;
    private SimpleStringProperty domisili;
    private SimpleStringProperty goldar;
    private SimpleStringProperty notelp;

    public Data(){
        this("","","","");
    }
    
    public Data(String username, String domisili, String goldar, String notelp){
        this.username = new SimpleStringProperty(username);
        this.domisili = new SimpleStringProperty(domisili);
        this.goldar =   new SimpleStringProperty(goldar);
        this.notelp =   new SimpleStringProperty(notelp);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getDomisili() {
        return domisili.get();
    }

    public void setDomisili(String domisili) {
        this.domisili.set(domisili); 
    }

    public String getGoldar() {
        return goldar.get();
    }

    public void setGoldar(String goldar) {
        this.goldar.set(goldar);
    }

    public String getNotelp() {
        return notelp.get();
    }

    @Override
    public String toString() {
        return "Data{" + "username=" + username + ", domisili=" + domisili + ", goldar=" + goldar + ", notelp=" + notelp + '}';
    }

    public void setNotelp(String notelp) {
        this.notelp.set(notelp);
    }
    
    
    
    
}
