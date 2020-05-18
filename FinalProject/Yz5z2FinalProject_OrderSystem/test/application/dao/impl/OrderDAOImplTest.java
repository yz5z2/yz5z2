/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.dao.BuyerDAO;
import application.factory.DAOFactory;
import application.model.Buyer;
import application.model.Order;
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
public class OrderDAOImplTest {
    private  BuyerDAO buyDao = DAOFactory.getBuyerDAOInstance();
    public OrderDAOImplTest() {
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
     * Test of createOrder method, of class OrderDAOImpl.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        String bno = "123456";
        Buyer buyer = buyDao.findBuyer(bno);
        String oid = "1588670050122707061";
        double orderAmount = 5.2*20;
        
        Order order = new Order(oid,bno,buyer.getName(),buyer.getPhone(),buyer.getAddress(),orderAmount,1);
        OrderDAOImpl instance = new OrderDAOImpl();
        boolean expResult = true;
        boolean result = instance.createOrder(order);
        assertEquals(expResult, result);
    }
    
}
