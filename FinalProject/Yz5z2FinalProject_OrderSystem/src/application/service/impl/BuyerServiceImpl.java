/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.impl;

import application.dao.BuyerDAO;
import application.dao.DetailDAO;
import application.dao.FoodDAO;
import application.dao.OrderDAO;
import application.exception.OrderException;
import application.factory.DAOFactory;
import application.model.Buyer;
import application.model.CartFood;
import application.model.Detail;
import application.model.Food;
import application.model.Order;
import application.service.BuyerService;
import application.utils.KeyUtil;
import java.util.List;

/**
 *
 * @author Yz5z2
 */
public class BuyerServiceImpl implements  BuyerService{
    
    private BuyerDAO buyerDao = DAOFactory.getBuyerDAOInstance();
    private FoodDAO foodDao = DAOFactory.getFoodDAOInstance();
    private DetailDAO detailDao = DAOFactory.getDetailDAOInstance();
    private OrderDAO orderDao = DAOFactory.getOrderDAOInstance();

    @Override
    public String login(String bno, String pwd) {
		try {
			return buyerDao.buyerLogin(bno, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public boolean insertBuyer(Buyer buyer) {
        try {
			return buyerDao.buyerRegister(buyer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }

    @Override
    public boolean resetUserPwd(String bno, String newPwd) {
        	try {
			return buyerDao.buyerUpdatePwd(bno, newPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


    @Override
    public List<Food> findAllFood() {
        	try {
			return foodDao.queryAllFoodOnSelling();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Food> findAllFoodByCategory(String category) {
        try {
			return foodDao.queryAllFoodByCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
      @Override
    public List<Order> findOwnOrderList(String bno) {
       try {
			return orderDao.findOwnOrderList(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
      @Override
    public Buyer findBuyerByBno(String bno) {
        try {
			return buyerDao.findBuyer(bno);
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
    /**
     *
     * No Transactional
     * @param cartFoodList
     * @param bno
     * @return
     */
    @Override
    public String createOrder(List<CartFood> cartFoodList,String bno) {
        try {
                String oid = KeyUtil.genUniqueKey();//Unique order number
                double orderAmount =0.00;
		//Save detail and calculate the total price
                for(CartFood cartFood : cartFoodList){                  
                    double price = cartFood.getPrice();
                    int amount = cartFood.getAmount();
                    String did = KeyUtil.genUniqueKey();
                    Detail detail = new Detail(did,oid,cartFood.getFid(),cartFood.getName(),price,amount);
//                    detail.setDid(did);
//                    detail.setOid(oid);
//                    detail.setFid(cartFood.getFid());
//                    detail.setName(cartFood.getName());
//                    detail.setPrice(price);
//                    detail.setQuantity(quantity);               
                    //calculate the total price
                    orderAmount += (price*amount);
                    //save detail
                    detailDao.insertDetail(detail, oid);             
                    
                }
                //Deduct inventory 
                for(CartFood cartFood:cartFoodList){
                    int foodAmount = foodDao.findFoodAmountByFid(cartFood.getFid());
                    int result =foodAmount- cartFood.getAmount();
                    if(result<0){
                         throw new OrderException();
                    }
                    foodDao.decreaseStock(result, cartFood.getFid());
                    
                }
                
                // save order (generate order)
                Buyer buyer = buyerDao.findBuyer(bno);
                Order order = new Order(oid,buyer.getBno(),buyer.getName(),buyer.getPhone(),buyer.getAddress(),orderAmount,1);
                
//                order.setOid(oid);
//                order.setBno(buyer.getBno());
//                order.setName(buyer.getName());
//                order.setPhone(buyer.getPhone());
//                order.setAddress(buyer.getAddress());
//                order.setOrderAmount(orderAmount);
//                order.setStatus(1);
                
                orderDao.createOrder(order);
                
                return oid;
                
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        
    }

    @Override
    public String finshOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

  

  
}
