/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service;


import application.model.Buyer;
import application.model.CartFood;
import application.model.Detail;
import application.model.Food;
import application.model.Order;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public interface BuyerService {
    //login
    public String login(String bno,String pwd);
    //regist
    public boolean insertBuyer(Buyer buyer);
    public Buyer findBuyerByBno(String bno);
    public boolean resetUserPwd(String bno,String newPwd);
    //order
    public List<Food> findAllFood();
    public List<Food> findAllFoodByCategory(String category);
    public List<Order> findOwnOrderList(String bno);
    public List<Detail> findOrderDetailByOid(String oid);
    public String createOrder(List<CartFood> cartFoodList,String bno);
    public String finshOrder();
}
