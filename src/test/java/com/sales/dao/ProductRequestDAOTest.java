/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.dao;

import com.cab.dao.ProductRequestDAO;
import com.cab.models.ProductRequest;
import com.cab.models.ProductRequestDetail;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Commercepromote
 */
public class ProductRequestDAOTest {
    ProductRequestDAO instance;
    ProductRequest productRequest;
    public ProductRequestDAOTest() {
        instance = new ProductRequestDAO();
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
     * Test of CreateProductRequestHeader method, of class ProductRequestDAO.
     */
    @Test
    public void testCreateProductRequestHeader() {
        System.out.println("CreateProductRequestHeader");
        productRequest = new ProductRequest(0, 3, new TestSupport().getBranch(), "2021-02-06 00:00:00", "Pending", 0, new TestSupport().getUser());       
        boolean expResult = true;
        int result = instance.CreateProductRequestHeader(productRequest);
        productRequest.setId(result);
        assertEquals(expResult, result>0);
    }

    /**
     * Test of CreateProductRequestDetail method, of class ProductRequestDAO.
     */
    @Test
    public void testCreateProductRequestDetail() {
        System.out.println("CreateProductRequestDetail");
        ProductRequestDetail productRequestDetail = new ProductRequestDetail(0,productRequest.getId() , new TestSupport().getProduct(), 20);
        ProductRequestDAO instance = new ProductRequestDAO();
        boolean expResult = true;
        boolean result = instance.CreateProductRequestDetail(productRequestDetail);
        assertEquals(expResult, result);    
    }

    /**
     * Test of GetProductRequestsUnderBranch method, of class ProductRequestDAO.
     */
    @Test
    public void testGetProductRequestsUnderBranch() {
        System.out.println("GetProductRequestsUnderBranch");
        int branch = 6;
        ProductRequestDAO instance = new ProductRequestDAO();
        boolean expResult = true;
        ArrayList<ProductRequest> result = instance.GetProductRequestsUnderBranch(branch);
        assertEquals(expResult, result != null);

    }

    /**
     * Test of GetProductRequestsDetaisUnderRequest method, of class ProductRequestDAO.
     */
    @Test
    public void testGetProductRequestsDetaisUnderRequest() {
        System.out.println("GetProductRequestsDetaisUnderRequest");
        int request = productRequest.getId();
        boolean expResult = true;
        ArrayList<ProductRequestDetail> result = instance.GetProductRequestsDetaisUnderRequest(request);
        assertEquals(expResult, result != null);
    }

    /**
     * Test of GetProductRequestsUnderBranchReceived method, of class ProductRequestDAO.
     */
    @Test
    public void testGetProductRequestsUnderBranchReceived() {
        System.out.println("GetProductRequestsUnderBranchReceived");
        int branch = 6;
        ProductRequestDAO instance = new ProductRequestDAO();
        boolean expResult = true;
        ArrayList<ProductRequest> result = instance.GetProductRequestsUnderBranchReceived(branch);
        assertEquals(expResult, result != null);
    }

    /**
     * Test of UpdateProductRequestHeader method, of class ProductRequestDAO.
     */
    @Test
    public void testUpdateProductRequestHeader() {
        System.out.println("UpdateProductRequestHeader");
        String status = "Approved";
        int id = productRequest.getId();
        int vehicle = 0;
        boolean expResult = true;
        boolean result = instance.UpdateProductRequestHeader(status, id, vehicle);
        assertEquals(expResult, result);
    }
    
}
