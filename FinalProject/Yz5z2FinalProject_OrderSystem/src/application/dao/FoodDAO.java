/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao;

import application.model.Food;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public interface FoodDAO {
    //edit food crud
    //Create food
    public boolean addFood(Food food) throws Exception;
    //Read food
    public List<Food> queryAllFoodOnSelling() throws Exception;
    public List<Food> queryAllFood() throws Exception;
    public Food findFoodByFid(String fid) throws Exception;
    public Integer findFoodAmountByFid(String fid) throws Exception;
    public List<Food> queryAllFoodByCategory(String category) throws Exception;
    // Update food
    public boolean updateFood(Food food) throws Exception;
     public boolean decreaseStock(int result,String fid) throws Exception;
    //Add or remove food
    public boolean changeFoodStatus(Integer status,String fid) throws Exception;
    
}
