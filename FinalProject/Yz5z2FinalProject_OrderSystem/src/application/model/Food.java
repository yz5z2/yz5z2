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
 */
public class Food  implements Serializable{
    	private StringProperty fid;
	private StringProperty name;
	private StringProperty category;
        private DoubleProperty price;
	private IntegerProperty amount;
        private IntegerProperty status; // Is it for sale,1 yes; 0 no
        private ObjectProperty<LocalDateTime> createDate;
        private ObjectProperty<LocalDateTime> updateDate;


        
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

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public Integer getAmount() {
        return amount.getValue();
    }

    public void setAmount(Integer amount) {
        this.amount.set(amount);
    }

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.get();
    }


    public Integer getStatus() {
        return status.get();
    }

    public void setStatus(Integer status) {
        this.status.set(status);
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
    
    public final StringProperty fidProperty() {
		return this.fid;
	}
    public final StringProperty nameProperty() {
		return this.name;
	}
    public final StringProperty categoryProperty() {
                    return this.category;
            }
        
    public Food(String fid,String name, String category, Double price,Integer amount,  Integer status) {
        this.fid = new SimpleStringProperty(fid);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.amount = new SimpleIntegerProperty(amount);
        this.status =new SimpleIntegerProperty(status);
    }
        

}
