/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.impl;

import application.dao.DetailDAO;
import application.dao.FoodDAO;
import application.dao.OrderDAO;
import application.dao.SellerDAO;
import application.factory.DAOFactory;
import application.model.Detail;
import application.model.Food;
import application.model.Order;
import application.service.SellerService;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public class SellerServiceImpl implements SellerService{
    private SellerDAO sellerDao = DAOFactory.getSellerDAOInstance();
    private FoodDAO foodDao = DAOFactory.getFoodDAOInstance();
    private OrderDAO orderDao = DAOFactory.getOrderDAOInstance();
    private DetailDAO detailDao = DAOFactory.getDetailDAOInstance();
    @Override
    public String login(String sno, String pwd) {
        	try {
			return sellerDao.sellerLogin(sno, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public boolean insertFood(Food food) {
        	try {
			return foodDao.addFood(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

    @Override
    public boolean updateFood(Food food) {
    	try {
			return foodDao.updateFood(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
      @Override
    public Food findFoodByFid(String fid) {
    	try {
			return foodDao.findFoodByFid(fid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    @Override
    public List<Food> findAllFood() {
    	try {
			return foodDao.queryAllFood();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
   @Override
    public List<Order> findAllOrder() {
    try {
			return orderDao.findOrderStatistics();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
      @Override
    public List<Detail> findOrderDetailByOid(String oid) {
      try {
			return detailDao.findAllByOrderId(oid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    @Override
    public boolean changeFoodStatus(Integer status, String fid) {
    	try {
			return foodDao.changeFoodStatus(status, fid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

  

 
    
}
