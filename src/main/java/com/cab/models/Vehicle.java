
package com.cab.models;

import com.google.gson.Gson;
import java.io.Serializable;

public class Vehicle implements Serializable, Prototype{
    
    private int Id;
    private String Plate;
    private String ChassisNo;
    private float Mileage;
    private String Fuel;
    private String Transmission;
    private int Branch;
    private int Status;
    private int Driver;
    private String Adate;

    public int getDriver() {
        return Driver;
    }

    public void setDriver(int Driver) {
        this.Driver = Driver;
    }

    public Vehicle() {
    }

    public Vehicle(int Id, String Plate, String ChassisNo, float Mileage, String Fuel, String Transmission, int Branch,  int Status, int Driver, String Adate) {
        this.Id = Id;
        this.Plate = Plate;
        this.ChassisNo = ChassisNo;
        this.Mileage = Mileage;
        this.Fuel = Fuel;
        this.Transmission = Transmission;
        this.Branch = Branch;
        this.Status = Status;
        this.Driver = Driver;
        this.Adate = Adate;
    }

    public String getAdate() {
        return Adate;
    }

    public void setAdate(String Adate) {
        this.Adate = Adate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPlate() {
        return Plate;
    }

    public void setPlate(String Plate) {
        this.Plate = Plate;
    }

    public String getChassisNo() {
        return ChassisNo;
    }

    public void setChassisNo(String ChassisNo) {
        this.ChassisNo = ChassisNo;
    }

    public float getMileage() {
        return Mileage;
    }

    public void setMileage(float Mileage) {
        this.Mileage = Mileage;
    }

    public String getFuel() {
        return Fuel;
    }

    public void setFuel(String Fuel) {
        this.Fuel = Fuel;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String Transmission) {
        this.Transmission = Transmission;
    }

    public int getBranch() {
        return Branch;
    }

    public void setBranch(int Branch) {
        this.Branch = Branch;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
        return new Vehicle(Id, Plate, ChassisNo, Mileage, Fuel, Transmission, Branch, Status, Driver, Adate);
    }
    
}
