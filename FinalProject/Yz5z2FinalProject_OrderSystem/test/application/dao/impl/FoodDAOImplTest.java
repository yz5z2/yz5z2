/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.model.Food;
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
public class FoodDAOImplTest {
    
    public FoodDAOImplTest() {
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
     * Test of addFood method, of class FoodDAOImpl.
     */
//    @Test
    public void testAddFood() throws Exception {
        System.out.println("addFood");
        Food food = new Food("223344","apple","fruit",5.2,40,1);
        FoodDAOImpl instance = new FoodDAOImpl();
        boolean expResult = true;
        boolean result = instance.addFood(food);
        assertEquals(expResult, result);

    }

    /**
     * Test of queryFood method, of class FoodDAOImpl.
     */
    @Test
    public void testQueryAllFood() throws Exception {
        System.out.println("queryFood");
        FoodDAOImpl instance = new FoodDAOImpl();
        List<Food> result = instance.queryAllFood();
        System.out.println("on selling list size "+result.size());
        
    }

    /**
     * Test of updateFood method, of class FoodDAOImpl.
     */
//    @Test
    public void testUpdateFood() throws Exception {
        System.out.println("updateFood");
        Food food = new Food("223344","apple","fruit",5.5,50,1);
        FoodDAOImpl instance = new FoodDAOImpl();
        boolean expResult = true;
        boolean result = instance.updateFood(food);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteFood method, of class FoodDAOImpl.
     */
//    @Test
    public void testChangeFoodStatus() throws Exception {
        System.out.println("changeFoodStatus");
        String fid = "112233";
        FoodDAOImpl instance = new FoodDAOImpl();
        boolean expResult = true;
        boolean result = instance.changeFoodStatus(0,fid); //1 on, o off
        assertEquals(expResult, result);
   
    }
    
}
