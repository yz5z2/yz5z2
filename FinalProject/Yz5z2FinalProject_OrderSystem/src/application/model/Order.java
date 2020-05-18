/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yz5z2
 * order master
 */
public class Order implements Serializable{
    	private StringProperty oid;
	private StringProperty bno;
        private StringProperty name;
        private StringProperty phone;
        private StringProperty address;
        private DoubleProperty orderAmount;
        private IntegerProperty status;
        private List<Detail>  detailList;
        private StringProperty createDate;
        private StringProperty updateDate;
    public String getOid() {
        return oid.get();
    }

    public void setOid(String oid) {
        this.oid.set(oid);
    }

    public String getBno() {
        return bno.get();
    }

    public void setBno(String bno) {
        this.bno.set(bno);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
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

    public Double getOrderAmount() {
        return orderAmount.get();
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount.set(orderAmount);
    }

    public Integer getStatus() {
        return status.get();
    }

    public void setStatus(Integer status) {
        this.status.set(status);
    }

       public String getCreateDate() {
        return createDate.get();
    }

    public void setCreateDate(String createDate) {
        this.createDate.set(createDate);
    }

    public String getUpdateDate() {
        return updateDate.get();
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate.set(updateDate);
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
    public StringProperty getOidProperty() {
        return oid;
    }

    public void setOidProperty(StringProperty oid) {
        this.oid = oid;
    }

    public StringProperty getBnoProperty() {
        return bno;
    }

    public void setBnoProperty(StringProperty bno) {
        this.bno = bno;
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setNameProperty(StringProperty name) {
        this.name = name;
    }

    public StringProperty getPhoneProperty() {
        return phone;
    }

    public void setPhoneProperty(StringProperty phone) {
        this.phone = phone;
    }

    public StringProperty getAddressProperty() {
        return address;
    }

    public void setAddressProperty(StringProperty address) {
        this.address = address;
    }

    public DoubleProperty getOrderAmountProperty() {
        return orderAmount;
    }

    public void setOrderAmounPropertyt(DoubleProperty orderAmount) {
        this.orderAmount = orderAmount;
    }

    public IntegerProperty getStatusProperty() {
        return status;
    }

    public void setStatusProperty(IntegerProperty status) {
        this.status = status;
    }

    public StringProperty getCreateDateProperty() {
        return createDate;
    }

    public void setCreateDateProperty(StringProperty createDate) {
        this.createDate = createDate;
    }

    public StringProperty getUpdateDateProperty() {
        return updateDate;
    }

    public void setUpdateDateProperty(StringProperty updateDate) {
        this.updateDate = updateDate;
    }



    public Order() {
    }
    
    
    public Order(String oid, String bno, String name, String phone, String address, Double orderAmount, Integer  status) {
        this.oid = new SimpleStringProperty(oid);
        this.bno = new SimpleStringProperty(bno);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.orderAmount = new SimpleDoubleProperty(orderAmount);
        this.status = new SimpleIntegerProperty(status);
    }

    public Order(String oid, String bno, Double orderAmount,String createDate ) {
        this.oid = new SimpleStringProperty(oid);
        this.bno = new SimpleStringProperty(bno);
        this.orderAmount = new SimpleDoubleProperty(orderAmount);
           	this.createDate = new SimpleStringProperty(createDate);
    }

    public Order(String oid, String bno, String name, String phone, String address, Double orderAmount, String createDate) {
        this.oid = new SimpleStringProperty(oid);
        this.bno = new SimpleStringProperty(bno);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.orderAmount = new SimpleDoubleProperty(orderAmount);
     	this.createDate = new SimpleStringProperty(createDate);
    }
    
    
}
