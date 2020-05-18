/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yz5z2
 */
public class CartFood {
        private StringProperty fid;
	private StringProperty name;
	private StringProperty category;
        private DoubleProperty price;
	private IntegerProperty amount;
        @SuppressWarnings("unused")
	private DoubleProperty total;
	private NumberBinding totalBind;

    public String getFid() {
        return fid.get();
    }

    public void setFid(String fid) {
        this.fid.set(fid);
    }
    public final StringProperty nameProperty() {
                    return this.name;
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

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public Integer getAmount() {
        return amount.get();
    }

    public void setAmount(Integer amount) {
        this.amount.set(amount);
    }

    public final DoubleProperty totalProperty() {
		return new SimpleDoubleProperty(totalBind.doubleValue());
	}

	public final double getTotal() {
		return this.totalBind.doubleValue();
	}

	public final void setTotal(final double total) {
		this.totalProperty().set(totalBind.doubleValue());
	}

    public CartFood(String fid, String name, String category, Double price, Integer amount) {
        this.fid = new SimpleStringProperty(fid);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.amount = new SimpleIntegerProperty(amount);
        this.totalBind = this.amount.multiply(this.price);

    }
        
        
}
