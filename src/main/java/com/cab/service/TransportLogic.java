
package com.cab.service;

import com.cab.dao.BranchDAO;
import com.cab.dao.IBranchDAO;
import com.cab.dao.ITransportDAO;
import com.cab.dao.TransportDAO;
import com.cab.models.Driver;
import com.cab.models.Vehicle;

import java.util.ArrayList;

public class TransportLogic implements ITransportLogic{

    @Override
    public boolean RegisterVehicleInSystem(Vehicle vehicle) {
       ITransportDAO trnsportDAO = new TransportDAO();
       int vahicleId = trnsportDAO.CreateVehicle(vehicle);
       if(vahicleId> 0 && vehicle.getDriver() > 0)
       {
           if(trnsportDAO.AssignDriver(vehicle.getBranch(),vahicleId , vehicle.getDriver()) > 0)  return true; 
           else {return false;} 
       }
       else if(vahicleId> 0)
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    @Override
    public boolean RegisterDriverInSystem(Driver driver) {
       ITransportDAO trnsportDAO = new TransportDAO();
       int driverId = trnsportDAO.CreateDriverProfile(driver);
       if(driverId> 0 && driver.getVehicle()> 0)
       {
           if(trnsportDAO.AssignDriver(driver.getBranchId(),driver.getVehicle() , driverId) > 0)  return true; 
           else {return false;} 
       }
        else if(driverId> 0)
       {
           return true;
       }
       else
       {
           return false;
       }
      
    }

    @Override
    public boolean UpdateDriverProfile(Driver driver) {
        ITransportDAO trnsportDAO = new TransportDAO();
       boolean response = trnsportDAO.EditDriver(driver);
       if(response && driver.getVehicle()> 0)
       {
           if(trnsportDAO.AssignDriver(driver.getBranchId(),driver.getVehicle() , driver.getId()) > 0)  return true; 
           else {return false;} 
       }
       else if(response)
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    @Override
    public boolean UpdateVehicleProfile(Vehicle vehicle) {
       ITransportDAO trnsportDAO = new TransportDAO();
       boolean response = trnsportDAO.EditVehicle(vehicle);
       if(response && vehicle.getDriver() > 0)
       {
           if(trnsportDAO.AssignDriver(vehicle.getBranch(),vehicle.getId() , vehicle.getDriver()) > 0)  return true; 
           else {return false;} 
       }
       else if(response)
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    @Override
    public boolean DeleteVehicleFromSystem(int vehicle) {
       ITransportDAO trnsportDAO = new TransportDAO();
       return trnsportDAO.DeleteVehicle(vehicle);
    }

    @Override
    public boolean DeleteDriverFromSystem(int driver) {
       ITransportDAO trnsportDAO = new TransportDAO();
       return trnsportDAO.DeleteDriverProfile(driver);
    }

    @Override
    public Driver GetDriverById(int driver) {
       return null;
    }

    @Override
    public Vehicle GetVehicleById(int vehicle) {
       ITransportDAO trnsportDAO = new TransportDAO();
       return trnsportDAO.GetVehicleById(vehicle);
    }

    @Override
    public ArrayList<Vehicle> GetFreeVehiclesUnderBranch(int branchId) {
        ITransportDAO trnsportDAO = new TransportDAO();
        return trnsportDAO.GetAllVehiclesUnderBranchFree(branchId);
    }

    @Override
    public ArrayList<Vehicle> GetVehiclesUnderBranch(int branchId) {
        ITransportDAO trnsportDAO = new TransportDAO();
        return trnsportDAO.GetAllVehiclesUnderBranch(branchId);
    }

    @Override
    public ArrayList<Driver> GetFreeDriverUnderBranch(int branchId) {
        ITransportDAO trnsportDAO = new TransportDAO();
        return trnsportDAO.GetAllDriversUnderBranchHasNoVehicle(branchId);
    }

    @Override
    public ArrayList<Driver> GetDriversUnderBranch(int branchId) {
        ITransportDAO trnsportDAO = new TransportDAO();
        return trnsportDAO.GetAllDriversUnderBranch(branchId);    
    }

    @Override
    public ArrayList<Vehicle> GetAllVehiclesUnderBranchHasNoDriver(int branchId) {
        ITransportDAO trnsportDAO = new TransportDAO();
        return trnsportDAO.GetAllVehiclesUnderBranchHasNoDriver(branchId);      
    }

    @Override
    public int GetVehicleForDriver(int id) {
        ITransportDAO trnsportDAO = new TransportDAO();
        return trnsportDAO.GetVehicleForDriver(id); 
    }

    @Override
    public int GetDriverForVehicle(int id) {
       ITransportDAO trnsportDAO = new TransportDAO();
       return trnsportDAO.GetDriverForVehicle(id);
    }
    
}
