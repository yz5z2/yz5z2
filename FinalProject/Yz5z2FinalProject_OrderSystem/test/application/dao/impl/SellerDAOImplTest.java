/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

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
public class SellerDAOImplTest {
    
    public SellerDAOImplTest() {
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
     * Test of sellerLogin method, of class SellerDAOImpl.
     */
    @Test
    public void testSellerLogin() throws Exception {
        System.out.println("sellerLogin");
        String sno = "1111";
        String pwd = "admin";
        SellerDAOImpl instance = new SellerDAOImpl();
        String expResult = "admin";
        String result = instance.sellerLogin(sno, pwd);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
