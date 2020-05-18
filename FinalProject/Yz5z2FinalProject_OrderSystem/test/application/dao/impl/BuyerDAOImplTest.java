/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.model.Buyer;
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
public class BuyerDAOImplTest {
    
    public BuyerDAOImplTest() {
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
     * Test of buyerRegister method, of class BuyerDAOImpl.
     */
    @Test
    public void testBuyerRegister() throws Exception {
        System.out.println("buyerRegister");
        Buyer buyer = new Buyer("123458","lyh","lyh326","17396236629","earth");
        
        BuyerDAOImpl instance = new BuyerDAOImpl();
        boolean expResult = true;
        boolean result = instance.buyerRegister(buyer);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of buyerLogin method, of class BuyerDAOImpl.
//     */
//    @Test
//    public void testBuyerLogin() throws Exception {
//        System.out.println("buyerLogin");
//        String uno = "";
//        String pwd = "";
//        BuyerDAOImpl instance = new BuyerDAOImpl();
//        String expResult = "";
//        String result = instance.buyerLogin(uno, pwd);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buyerUpdatePwd method, of class BuyerDAOImpl.
//     */
//    @Test
//    public void testBuyerUpdatePwd() throws Exception {
//        System.out.println("buyerUpdatePwd");
//        String uno = "";
//        String newPwd = "";
//        BuyerDAOImpl instance = new BuyerDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.buyerUpdatePwd(uno, newPwd);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
