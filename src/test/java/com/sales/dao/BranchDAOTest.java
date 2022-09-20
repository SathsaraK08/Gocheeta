
package com.sales.dao;

import com.cab.dao.BranchDAO;
import com.cab.dao.IBranchDAO;
import com.cab.models.Branch;
import com.cab.models.DualBranchLocation;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BranchDAOTest {
    
    private Branch Branchinstance;
    private Branch BranchUpdateinstance;
    private IBranchDAO BranchDAO;
    private int BranchObjId;
    
    public BranchDAOTest() {
        BranchDAO = new BranchDAO();
        Branchinstance = new Branch(0, "Test Sub Branch", "Colombo 10", "80.0006", "6.005", "No 47", "01143453434", "testbranch99@gmail.com", "Sub");
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
     * Test of CreateBranch method, of class BranchDAO.
     */
    @Test
    public void testCreateBranch() {
        System.out.println("CreateBranch");
        boolean expResult = true;
        boolean result = BranchDAO.CreateBranch(Branchinstance);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GetAllSubBranches method, of class BranchDAO.
     */
    @Test
    public void testGetAllSubBranches() {
        System.out.println("GetAllSubBranches");
        boolean expResult = true;
        ArrayList<Branch> result = BranchDAO.GetAllSubBranches();
        if(result != null && result.size()> 0)
        {
            BranchUpdateinstance = result.get(0);
        }
        assertEquals(expResult, result.size()>0 );
        
    }

    /**
     * Test of EditBranch method, of class BranchDAO.
     */
    @Test
    public void testEditBranch() {
        System.out.println("EditBranch");
        boolean expResult = true;
        boolean result = BranchDAO.EditBranch((Branch) BranchUpdateinstance.getCloneObject());
        assertEquals(expResult, result);
    }

   

    /**
     * Test of GetBranchById method, of class BranchDAO.
     */
    @Test
    public void testGetBranchById() {
        System.out.println("GetBranchById");
        Branch expResult = (Branch) BranchUpdateinstance.getCloneObject();
        Branch result = BranchDAO.GetBranchById(BranchUpdateinstance.getId());
        assertEquals(expResult, result);
    }

    /**
     * Test of GetAllBranchesExceptMe method, of class BranchDAO.
     */
    @Test
    public void testGetAllBranchesExceptMe() {
        System.out.println("GetAllBranchesExceptMe");
        int me = BranchUpdateinstance.getId();
        boolean expResult = true;
        ArrayList<Branch> result = BranchDAO.GetAllBranchesExceptMe(me);
        assertEquals(expResult, result.size()>0);
    }

   
    
     /**
     * Test of DeleteBranch method, of class BranchDAO.
     
    @Test
    public void testDeleteBranch() {
        System.out.println("DeleteBranch");
        int branchId = 0;
        boolean expResult = false;
        boolean result = BranchDAO.DeleteBranch(branchId);
        assertEquals(expResult, result);
    }
    */
}
