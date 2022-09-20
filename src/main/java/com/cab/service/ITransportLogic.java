
package com.cab.service;

import java.util.ArrayList;

import com.cab.models.Driver;
import com.cab.models.Vehicle;


public interface ITransportLogic {
    
    boolean RegisterVehicleInSystem(Vehicle vehicle);
    boolean RegisterDriverInSystem(Driver driver);
    boolean UpdateDriverProfile(Driver driver);
    boolean UpdateVehicleProfile(Vehicle driver);
    boolean DeleteVehicleFromSystem(int vehicle);
    boolean DeleteDriverFromSystem(int driver);
    Driver GetDriverById(int driver);
    Vehicle GetVehicleById(int vehicle);
    
    ArrayList<Vehicle> GetFreeVehiclesUnderBranch(int branchId);
    ArrayList<Vehicle> GetVehiclesUnderBranch(int branchId);
    ArrayList<Vehicle> GetAllVehiclesUnderBranchHasNoDriver(int branch);
    ArrayList<Driver> GetFreeDriverUnderBranch(int branchId);
    ArrayList<Driver> GetDriversUnderBranch(int branchId);
    
    
    int GetVehicleForDriver(int driver);
    int GetDriverForVehicle(int vehicle);
}
