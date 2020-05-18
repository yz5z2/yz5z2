/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yz5z2
 * order detail
 */
public class Detail implements Serializable {
        private StringProperty did;
        private StringProperty oid;
    	private StringProperty fid;
        private StringProperty name;
        private DoubleProperty price;
	private IntegerProperty quantity;
        private ObjectProperty<LocalDateTime> createDate;
        private ObjectProperty<LocalDateTime> updateDate;

    public String getDid() {
        return did.get();
    }

    public void setDid(String did) {
        this.did.set(did);
    }

    public String getOid() {
        return oid.get();
    }

    public void setOid(String oid) {
        this.oid.set(oid);
    }

    public String getFid() {
        return fid.get();
    }

    public void setFid(String fid) {
        this.fid.set(fid);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public void setQuantity(Integer quantity) {
        this.quantity.set(quantity);
    }

    public LocalDateTime getCreateDate() {
        return createDate.get();
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate.set(createDate);
    }

    public LocalDateTime getUpdateDate() {
        return updateDate.get();
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate.set(updateDate);
    }
 

    public Detail() {
    }

    
    public Detail(String did, String oid, String fid, String name, Double price, Integer quantity) {
        this.did = new SimpleStringProperty(did);
        this.oid = new SimpleStringProperty(oid);
        this.fid = new SimpleStringProperty(fid);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }
        
     public Detail( String fid, String name, Double price, Integer quantity) {
        this.fid = new SimpleStringProperty(fid);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }
        
    
    
}
