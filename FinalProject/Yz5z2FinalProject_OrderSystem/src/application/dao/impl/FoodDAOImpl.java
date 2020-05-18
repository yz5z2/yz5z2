/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.dao.BaseDAO;
import static application.dao.BaseDAO.jutil;
import application.dao.FoodDAO;
import application.model.Food;
import application.utils.DateUtil;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FoodDAOImpl extends BaseDAO implements FoodDAO {

    @Override
    public boolean addFood(Food food) throws Exception {
		String sql = "INSERT INTO food(fid,name,category,price,amount,status,createdate,updatedate) VALUES(?,?,?,?,?,?,?,?)";
                System.out.println(food.getFid()+"    "+food.getName()+"  "+food.getCategory()+"  "+food.getPrice()+"  "+food.getAmount()+"  "+food.getStatus());
                   System.out.println( LocalDateTime.now());
		return jutil.executeUpdate(sql,food.getFid(),food.getName(),food.getCategory(),food.getPrice(),food.getAmount(),food.getStatus(),DateUtil.format(LocalDateTime.now()),DateUtil.format(LocalDateTime.now()) ) > 0;
    }

    @Override
    public Integer findFoodAmountByFid(String fid) throws Exception {
        int amount = 0;
	String sql = "SELECT amount FROM food where status = 1 and fid =?";
	ResultSet rs = jutil.executeQuery(sql,fid);
	while (rs.next()) {
            amount = rs.getInt(1);
	}
	return amount;
    }

 
    @Override
    public List<Food> queryAllFoodOnSelling() throws Exception {
        	List<Food> list = null;
		String sql = "SELECT fid,name,category,price,amount FROM food where status = 1";
		ResultSet rs = jutil.executeQuery(sql);
		while (rs.next()) {
			if (list == null)
				list = new ArrayList<>();
			list.add(new Food(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDouble(4),rs.getInt(5),1));
		}
		return list;
    }
     @Override
    public Food findFoodByFid(String fid) throws Exception {
        	Food food = null;
		String sql = "SELECT fid,name,category,price,amount,status FROM food where fid = ?";
		ResultSet rs = jutil.executeQuery(sql,fid);
		while (rs.next()) {
			food =new Food(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getInt(6));
		}
		return food;
    }
        @Override
    public List<Food> queryAllFood() throws Exception {
        	List<Food> list = null;
		String sql = "SELECT fid,name,category,price,amount,status FROM food";
		ResultSet rs = jutil.executeQuery(sql);
		while (rs.next()) {
			if (list == null)
				list = new ArrayList<>();
			list.add(new Food(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getInt(6)));
		}
		return list;
    }
  @Override
    public List<Food> queryAllFoodByCategory(String category) throws Exception {
	List<Food> list = null;
		String sql = "SELECT fid,name,price,amount FROM food where status = 1 AND category = ?";
		ResultSet rs = jutil.executeQuery(sql,category);
		while (rs.next()) {
			if (list == null)
				list = new ArrayList<>();
			list.add(new Food(rs.getString(1), rs.getString(2), category,rs.getDouble(3),rs.getInt(4),1));
		}
		return list;
    }
    
    @Override
    public boolean updateFood(Food food) throws Exception {
    String sql = "UPDATE food SET name=?,category=?,price=?,amount=?,status=? WHERE fid=?";
		return jutil.executeUpdate(sql, food.getName(),food.getCategory(), food.getPrice(), food.getAmount(),food.getStatus(), food.getFid()) > 0;
    }
    
    @Override
    public boolean decreaseStock(int result,String fid) throws Exception {
         String sql = "UPDATE food SET amount = ? WHERE fid=?";
		return jutil.executeUpdate(sql,result ,fid) > 0;
    }


    @Override
    public boolean changeFoodStatus(Integer status,String fid) throws Exception {
    String sql = "UPDATE food SET status = ? WHERE fid=?";
		return jutil.executeUpdate(sql,status,fid) > 0;
    }

   

  
    
}
