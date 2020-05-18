/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao;

import application.model.Buyer;
import application.model.Order;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public interface BuyerDAO {
    //buyer register
    public boolean buyerRegister(Buyer buyer) throws Exception;
    //buyer login
    public String buyerLogin(String bno,String pwd) throws Exception;
    //buyer update password
    public boolean buyerUpdatePwd(String bno,String newPwd) throws Exception;
    //buyer information
    public Buyer findBuyer(String bno)  throws Exception;
    
 
    
    
}
