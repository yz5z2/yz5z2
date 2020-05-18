/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service;

import application.model.Detail;
import application.model.Food;
import application.model.Order;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public interface SellerService {
    //login
    public String login(String sno,String pwd);
    //edit food
    public boolean insertFood(Food food);
    public boolean updateFood(Food food);
    public Food findFoodByFid(String fid);
    public List<Food> findAllFood();
    public List<Order> findAllOrder();
    public boolean changeFoodStatus(Integer status,String fid);
    public List<Detail> findOrderDetailByOid(String oid);
    
}
