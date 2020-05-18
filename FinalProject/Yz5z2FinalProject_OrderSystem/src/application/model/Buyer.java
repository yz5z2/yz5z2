/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yz5z2
 * the buyer infomation, buyer order food
 */
public class Buyer implements Serializable{
    
    private StringProperty bno;
    private StringProperty name;
    private StringProperty password;
    private StringProperty phone;
    private StringProperty address;
    private ObjectProperty<LocalDateTime> regDate;

    public String getBno() {
        return bno.get();
    }

    public void setSno(String bno) {
        this.bno.set(bno);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public LocalDateTime getRegDate() {
        return regDate.get();
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate.set(regDate);
    }

    public Buyer(String bno, String name, String password, String phone, String address) {
        this.bno = new SimpleStringProperty(bno);
        this.name = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(password);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
    }
    public Buyer(String bno, String name, String phone, String address) {
        this.bno = new SimpleStringProperty(bno);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
    }

    
    
    
}
