/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao;

/**
 *
 * @author Yz5z2
 */
public interface SellerDAO {
    //seller login
    public String sellerLogin(String sno,String pwd) throws Exception;    
}
