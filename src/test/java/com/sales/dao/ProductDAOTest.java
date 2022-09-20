/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.dao;

import com.cab.dao.ProductDAO;
import com.cab.models.Product;
import com.cab.models.ProductType;
import com.cab.models.Return;
import com.cab.models.ReturnsSummary;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductDAOTest {
    
     ProductType productType;
     ProductDAO instance;
     Product product;
     int ReturObjId =0;
    public ProductDAOTest() {
        instance = new ProductDAO();
        productType= new ProductType( 0,"Sweets", "Chocolates & Buiscuits");
        product = new Product(0, 0, "Chocolate Buiscuits", " Sweet Chocolate", 500, "Box", "");
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
    public void testCreateProductType() {
        System.out.println("CreateProductType");
        boolean expResult = true;
        boolean result = instance.CreateProductType(productType);
        assertEquals(expResult, result);
    }
    
    
      /**
     * Test of GetTypeById method, of class ProductDAO.
     */
    @Test
    public void testGetTypeById() {
        System.out.println("GetTypeById");
        int id = 6;
        boolean expResult = true;
        ProductType result = instance.GetTypeById(id);
        productType= result;
        assertEquals(expResult, result!= null);       
    }

    /**
     * Test of UpdateProductType method, of class ProductDAO.
     */
    @Test
    public void testUpdateProductType() {
        System.out.println("UpdateProductType");  
        boolean expResult = true;
        boolean result = instance.UpdateProductType((ProductType)productType.getCloneObject());
        assertEquals(expResult, result);       
    }

   

  

    /**
     * Test of GetAllTypes method, of class ProductDAO.
     */
    @Test
    public void testGetAllTypes() {
        System.out.println("GetAllTypes");      
        boolean expResult = true;
        ArrayList<ProductType> result = instance.GetAllTypes();
        assertEquals(expResult, result!= null);
    }

    /**
     * Test of CreateProduct method, of class ProductDAO.
     */
    @Test
    public void testCreateProduct() {
        System.out.println("CreateProduct");
        int expResult = 0;
        product.setId(expResult);
        int result = instance.CreateProduct(product);
        assertEquals(expResult>0, result > 0);
    }

    /**
     * Test of UpdateProductDetails method, of class ProductDAO.
     */
    @Test
    public void testUpdateProductDetails() {
        System.out.println("UpdateProductDetails");    
        boolean expResult = true;
        boolean result = instance.UpdateProductDetails(product);
        assertEquals(expResult, result);
    }

  

    /**
     * Test of GetProductById method, of class ProductDAO.
     */
    @Test
    public void testGetProductById() {
        System.out.println("GetProductById");
        int i = product.getId();
        boolean expResult = true;
        Product result = instance.GetProductById(i);
        assertEquals(expResult, result != null);
    }

    

    /**
     * Test of GetAllProducts method, of class ProductDAO.
     */
    @Test
    public void testGetAllProducts() {
        System.out.println("GetAllProducts");
        int branch = 6;
        boolean expResult = true;
        ArrayList<Product> result = instance.GetAllProducts(branch);
        assertEquals(expResult, result!=null);       
    }

    /**
     * Test of CreateUpdateReturn method, of class ProductDAO.
     */
    @Test
    public void testCreateUpdateReturn() {
        System.out.println("CreateUpdateReturn");
        Return ReturnObj = new Return(0, 6, product.getId(), 50);
        boolean expResult = true;
        int result = instance.CreateUpdateReturn(ReturnObj);
        ReturObjId=result;
        assertEquals(expResult, result>0);
    }

    /**
     * Test of GetReturnsByProducts method, of class ProductDAO.
     */
    @Test
    public void testGetReturnsByProducts() {
        System.out.println("GetReturnsByProducts");
        boolean expResult = true;
        ArrayList<ReturnsSummary> result = instance.GetReturnsByProducts();
        assertEquals(expResult, result != null);
    }
    
    
    //--- deletions
    
   
    
}
