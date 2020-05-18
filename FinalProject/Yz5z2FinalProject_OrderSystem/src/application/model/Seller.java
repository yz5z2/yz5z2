/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.io.Serializable;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yz5z2
 * the seller infomation, seller can edit food
 */
public class Seller implements Serializable{
    
    private StringProperty sno;
    private StringProperty name;
    private StringProperty password;

    public String getSno() {
        return sno.get();
    }

    public void setSno(String sno) {
        this.sno.set(sno);
    }

    public StringProperty getName() {
        return name;
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
    
    
    
    
    
}
