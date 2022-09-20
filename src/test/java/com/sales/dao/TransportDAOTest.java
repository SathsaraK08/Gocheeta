
package com.sales.dao;

import com.cab.dao.TransportDAO;
import com.cab.models.Driver;
import com.cab.models.Vehicle;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransportDAOTest {
    TransportDAO instance;
    Vehicle vehicle;
    Driver driver;
    public TransportDAOTest() {
        instance = new TransportDAO();
        vehicle = new Vehicle(0, "KK-1212", "RTU34EW", 0, "Petrol", "Manual", 6, 0, 0, "2021-02-06 00:00:00");
        driver = new Driver(0, "Gewin Fernando", "Galle, No 12", "992312345v", "0778899111", 6,0);
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
     * Test of CreateVehicle method, of class TransportDAO.
     */
    @Test
    public void testCreateVehicle() {
        System.out.println("CreateVehicle");     
        boolean expResult = true;
        int result = instance.CreateVehicle(vehicle);
        vehicle.setId(result);
        assertEquals(expResult, result> 0);
    }

    

    /**
     * Test of EditVehicle method, of class TransportDAO.
     */
    @Test
    public void testEditVehicle() {
        System.out.println("EditVehicle");
        boolean expResult = true;
        boolean result = instance.EditVehicle(vehicle);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetAllVehiclesUnderBranch method, of class TransportDAO.
     */
    @Test
    public void testGetAllVehiclesUnderBranch() {
        System.out.println("GetAllVehiclesUnderBranch");
        int branchId = 6;
        boolean expResult = true;
        ArrayList<Vehicle> result = instance.GetAllVehiclesUnderBranch(branchId);
        assertEquals(expResult, result != null);
    }

    /**
     * Test of GetAllVehiclesUnderBranchFree method, of class TransportDAO.
     */
    @Test
    public void testGetAllVehiclesUnderBranchFree() {
        System.out.println("GetAllVehiclesUnderBranchFree");
        int branchId = 6;
        boolean expResult = true;
        ArrayList<Vehicle> result = instance.GetAllVehiclesUnderBranchFree(branchId);
        assertEquals(expResult, result!= null);
    }

    /**
     * Test of GetAllVehiclesUnderBranchHasNoDriver method, of class TransportDAO.
     */
    @Test
    public void testGetAllVehiclesUnderBranchHasNoDriver() {
        System.out.println("GetAllVehiclesUnderBranchHasNoDriver");
        int branchId = 6;
        boolean expResult = true;
        ArrayList<Vehicle> result = instance.GetAllVehiclesUnderBranchHasNoDriver(branchId);
        assertEquals(expResult, result!= null);
    }

    /**
     * Test of GetVehicleById method, of class TransportDAO.
     */
    @Test
    public void testGetVehicleById() {
        System.out.println("GetVehicleById");
        int vehicleId = vehicle.getId();
        boolean expResult = true;
        Vehicle result = instance.GetVehicleById(vehicleId);
        assertEquals(expResult, result != null);
    }

   

  

    /**
     * Test of CreateDriverProfile method, of class TransportDAO.
     */
    @Test
    public void testCreateDriverProfile() {
        System.out.println("CreateDriverProfile");
        boolean expResult = true;
        int result = instance.CreateDriverProfile(driver);
        driver.setId(result);
        assertEquals(expResult, result> 0);

    }

  

    /**
     * Test of EditDriver method, of class TransportDAO.
     */
    @Test
    public void testEditDriver() {
        System.out.println("EditDriver");
        boolean expResult = true;
        boolean result = instance.EditDriver(driver);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetAllDriversUnderBranch method, of class TransportDAO.
     */
    @Test
    public void testGetAllDriversUnderBranch() {
        System.out.println("GetAllDriversUnderBranch");
        int branchId = 6;
        boolean expResult = true;
        ArrayList<Driver> result = instance.GetAllDriversUnderBranch(branchId);
        assertEquals(expResult, result!= null);
    }

    /**
     * Test of GetAllDriversUnderBranchHasNoVehicle method, of class TransportDAO.
     */
    @Test
    public void testGetAllDriversUnderBranchHasNoVehicle() {
        System.out.println("GetAllDriversUnderBranchHasNoVehicle");
        int branchId = 6;
        boolean expResult = true;
        ArrayList<Driver> result = instance.GetAllDriversUnderBranchHasNoVehicle(branchId);
        assertEquals(expResult, result!= null);
    }

    
      /**
     * Test of AssignDriver method, of class TransportDAO.
     */
    @Test
    public void testAssignDriver() {
        System.out.println("AssignDriver");
        int branchId = 6;
        int vehicleId = vehicle.getId();
        int driverId = driver.getId();
        boolean expResult = true;
        int result = instance.AssignDriver(branchId, vehicleId, driverId);
        assertEquals(expResult, result > 0);
    }
    
}
