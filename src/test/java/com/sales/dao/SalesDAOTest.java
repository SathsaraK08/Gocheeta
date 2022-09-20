/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.dao;

import com.cab.dao.SalesDAO;
import com.cab.models.Customer;
import com.cab.models.ProductCompressed;
import com.cab.models.SalesDetail;
import com.cab.models.SalesObject;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SalesDAOTest {
    SalesDAO instance;
    Customer customer;
    SalesObject so;
    SalesDetail sdObj;
    public SalesDAOTest() {
        customer = new Customer(0,"Kevin H", "No 12", "894534234v", "kevin77@gmail.com", "0702312789");
        so = new SalesObject(0, new TestSupport().getBranch(),new TestSupport().getCustomer() , 100, "2021-02-06 00:00:00", "Cash");
        
        instance = new SalesDAO();
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

    
    @Test
    public void testRegisterCustomer() {
        System.out.println("RegisterCustomer");
        
        boolean expResult = true;
        int result = instance.RegisterCustomer(customer);
        assertEquals(expResult, result>0);       
    }
    
  
    @Test
    public void testUpdateCustomer() {
        System.out.println("UpdateCustomer");
        boolean expResult = true;
        customer.setId(new TestSupport().getCustomer());
        boolean result = instance.UpdateCustomer(customer);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetAllCustomers() {
        System.out.println("GetAllCustomers");
        SalesDAO instance = new SalesDAO();
        boolean expResult = true;
        ArrayList<Customer> result = instance.GetAllCustomers();
        assertEquals(expResult, result!= null);
        
    }

    @Test
    public void testLogSalesHeader() {
        System.out.println("LogSalesHeader");
        boolean expResult = true;
        int result = instance.LogSalesHeader(so);
        so.setId(result);
        assertEquals(expResult, result>0);
    }

   

  
    @Test
    public void testGetAllProductsUnderBranch() {
        System.out.println("GetAllProductsUnderBranch");
        int id = new TestSupport().getBranch();
        boolean expResult = true;
        ArrayList<ProductCompressed> result = instance.GetAllProductsUnderBranch(id);
        assertEquals(expResult, result!= null);
    }

    

   
    @Test
    public void testCreateStores() {
        System.out.println("CreateStores");
        int product = new TestSupport().getProduct();
        float amount = 500;
        int branch = new TestSupport().getBranch();
        
        boolean expResult = true;
        boolean result = instance.CreateStores(product, amount, branch);
        assertEquals(expResult, result);
        
    }

   
    @Test
    public void testUpdateStores() {
        System.out.println("UpdateStores");
        int product = new TestSupport().getProduct();
        float amount = 500;
        int branch = new TestSupport().getBranch();
        boolean expResult = true;
        boolean result = instance.UpdateStores(product, amount, branch);
        assertEquals(expResult, result);
    }
    
    
    
    @Test
    public void testLogSalesDetails() {
        System.out.println("LogSalesDetails");
        SalesDetail sd = new SalesDetail(0, so.getId(),new TestSupport().getProduct(), 1, 100);
        sdObj= sd;
        boolean expResult = true;
        boolean result = instance.LogSalesDetails(sd);
        assertEquals(expResult, result);
    }

}
