/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao;

import application.model.Order;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public interface OrderDAO {
    //create order
    public boolean createOrder(Order order) throws Exception;
    //query order
   public List<Order> findOrderStatistics() throws Exception;
      //order List bu buyer
    public List<Order> findOwnOrderList(String bno) throws Exception;
    
    
    
}
