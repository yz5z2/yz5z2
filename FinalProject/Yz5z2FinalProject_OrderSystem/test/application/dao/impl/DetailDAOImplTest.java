/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.impl;

import application.model.Detail;
import application.utils.KeyUtil;
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
public class DetailDAOImplTest {
    
    public DetailDAOImplTest() {
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
     * Test of insertDetail method, of class DetailDAOImpl.
     */
//    @Test
    public void testInsertDetail() throws Exception {
        System.out.println("insertDetail");
        String did = KeyUtil.genUniqueKey();
        String oid = KeyUtil.genUniqueKey();
        Detail detail = new Detail(did,oid,"223344","apple",5.2,20);
        DetailDAOImpl instance = new DetailDAOImpl();
        boolean expResult = true;
        boolean result = instance.insertDetail(detail, oid);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllByOrderId method, of class DetailDAOImpl.
     */
    @Test
    public void testFindAllByOrderId() throws Exception {
        System.out.println("findAllByOrderId");
        String oid = "1588670050122707061";
        DetailDAOImpl instance = new DetailDAOImpl();
        List<Detail> result = instance.findAllByOrderId(oid);
        System.out.println("order detail size "+result.size());
    }
    
}
