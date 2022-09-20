/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cab.models;


public class VData {
    private String pick;
    private String dest;
    private String date;
    private String vtype;
    private String driver;
    private String dcontact;
    private String vehicle;
    private double charge;
    private int did;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public VData() {
    }

    public VData(String pick, String dest, String date, String vtype, String driver, String dcontact, String vehicle, double charge, int did) {
        this.pick = pick;
        this.dest = dest;
        this.date = date;
        this.vtype = vtype;
        this.driver = driver;
        this.dcontact = dcontact;
        this.vehicle = vehicle;
        this.charge = charge;
        this.did = did;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDcontact() {
        return dcontact;
    }

    public void setDcontact(String dcontact) {
        this.dcontact = dcontact;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
    
    
}
