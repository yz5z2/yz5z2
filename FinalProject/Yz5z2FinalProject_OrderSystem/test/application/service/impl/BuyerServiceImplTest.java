/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.impl;

import application.dao.BuyerDAO;
import application.dao.FoodDAO;
import application.factory.DAOFactory;
import application.model.Buyer;
import application.model.CartFood;
import application.model.Food;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yz5z2
 */
public class BuyerServiceImplTest {
      private BuyerDAO buyerDao = DAOFactory.getBuyerDAOInstance();
    private FoodDAO foodDao = DAOFactory.getFoodDAOInstance();
    public BuyerServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class BuyerServiceImpl.
     */
//    @Test
    public void testLogin() {
        System.out.println("login");
        String bno = "";
        String pwd = "";
        BuyerServiceImpl instance = new BuyerServiceImpl();
        String expResult = "";
        String result = instance.login(bno, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertBuyer method, of class BuyerServiceImpl.
     */
//    @Test
    public void testInsertBuyer() {
        System.out.println("insertBuyer");
        Buyer buyer = null;
        BuyerServiceImpl instance = new BuyerServiceImpl();
        boolean expResult = false;
        boolean result = instance.insertBuyer(buyer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetUserPwd method, of class BuyerServiceImpl.
     */
//    @Test
    public void testResetUserPwd() {
        System.out.println("resetUserPwd");
        String bno = "";
        String newPwd = "";
        BuyerServiceImpl instance = new BuyerServiceImpl();
        boolean expResult = false;
        boolean result = instance.resetUserPwd(bno, newPwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllFood method, of class BuyerServiceImpl.
     */
//    @Test
    public void testFindAllFood() {
        System.out.println("findAllFood");
        BuyerServiceImpl instance = new BuyerServiceImpl();
        List<Food> expResult = null;
        List<Food> result = instance.findAllFood();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllFoodByCategory method, of class BuyerServiceImpl.
     */
//    @Test
    public void testFindAllFoodByCategory() {
        System.out.println("findAllFoodByCategory");
        String category = "";
        BuyerServiceImpl instance = new BuyerServiceImpl();
        List<Food> expResult = null;
        List<Food> result = instance.findAllFoodByCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrder method, of class BuyerServiceImpl.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        String bno = "123456";
        Buyer buyer = buyerDao.findBuyer(bno);
        List<Food> foodList = foodDao.queryAllFood();
        List<CartFood> cartFoodList = new ArrayList<>();
        for(Food food:foodList){
            CartFood cartFood = new CartFood(food.getFid(),food.getName(),food.getCategory(),food.getPrice(),7);
            cartFoodList.add(cartFood);
        }
        System.out.println(cartFoodList.size());
        BuyerServiceImpl instance = new BuyerServiceImpl();
      
        String result = instance.createOrder(cartFoodList, bno);
        
        System.out.println("OrderId  "+result);
    }

    /**
     * Test of finshOrder method, of class BuyerServiceImpl.
     */
//    @Test
    public void testFinshOrder() {
        System.out.println("finshOrder");
        BuyerServiceImpl instance = new BuyerServiceImpl();
        String expResult = "";
        String result = instance.finshOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
