
package com.sales.dao;

import com.cab.dao.UserDAO;
import com.cab.models.SystemUser;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserDAOTest {
    UserDAO instance;
    SystemUser systemUser; 
    public UserDAOTest() {
        instance = new UserDAO();
        systemUser = new SystemUser(0, "Kevin Test", "Kevintest@gmail.com", "123", 6, "0113456454","1234567","Sales","912345656v","No 88"); 
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
     * Test of CreateUserDetails method, of class UserDAO.
     */
    @Test
    public void testCreateUserDetails() {
        System.out.println("CreateUserDetails");           
        boolean expResult = true;
        int result = instance.CreateUserDetails(systemUser);
        systemUser.setId(result);
        assertEquals(expResult, result> 0);
    }
    
   

    /**
     * Test of GetUserByEmailPassword method, of class UserDAO.
     */
    @Test
    public void testGetUserByEmailPassword() {
        System.out.println("GetUserByEmailPassword");
        String Email = "Kevintest@gmail.com";
        String Password = "123";
        boolean expResult = true;
        SystemUser result = instance.GetUserByEmailPassword(Email, Password);
        systemUser= result;
        assertEquals(expResult, result != null);
    }

    /**
     * Test of GetUsersUnderBranch method, of class UserDAO.
     */
    @Test
    public void testGetUsersUnderBranch() {
        System.out.println("GetUsersUnderBranch");
        int branchId = 6;
        boolean expResult = true;
        ArrayList<SystemUser> result = instance.GetUsersUnderBranch(branchId);
        assertEquals(expResult, result != null);
    }

    /**
     * Test of UpdateUserDetails method, of class UserDAO.
     */
    @Test
    public void testUpdateUserDetails() {
        System.out.println("UpdateUserDetails");
        boolean expResult = true;
        boolean result = instance.UpdateUserDetails(systemUser);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testDeleteUserDetails() {
        System.out.println("DeleteUserDetails");
        int userid = systemUser.getId();       
        boolean expResult = true;
        boolean result = instance.DeleteUserDetails(userid);
        assertEquals(expResult, result);
    }
    
}
