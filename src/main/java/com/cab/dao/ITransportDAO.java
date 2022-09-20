
package com.cab.dao;

import java.util.ArrayList;

import com.cab.models.Branch;
import com.cab.models.Driver;
import com.cab.models.Vehicle;

public interface ITransportDAO {
    
    int CreateVehicle(Vehicle vehicle);
    boolean DeleteVehicle(int branchId);
    boolean EditVehicle(Vehicle vehicle);
    ArrayList<Vehicle> GetAllVehiclesUnderBranch(int branchId);
    ArrayList<Vehicle> GetAllVehiclesUnderBranchFree(int branchId);
    ArrayList<Vehicle> GetAllVehiclesUnderBranchHasNoDriver(int branchId);
    Vehicle GetVehicleById(int branchId);
    int AssignDriver(int branchId,int vehicleId, int driverId);
    
    int CreateDriverProfile(Driver driver);
    boolean DeleteDriverProfile(int driverId);
    boolean EditDriver(Driver driver);
    ArrayList<Driver> GetAllDriversUnderBranch(int branchId);
    ArrayList<Driver> GetAllDriversUnderBranchHasNoVehicle(int branchId);
    Driver GetBranchById(int branchId);
    
    int GetVehicleForDriver(int driver);
    int GetDriverForVehicle(int vehicle);
}
