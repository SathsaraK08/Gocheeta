
package com.cab.models;

import com.google.gson.Gson;
import java.io.Serializable;


public class Driver implements Serializable, Prototype {
    
    private int Id;
    private String FullName;
    private String Address;
    private String NIC;
    private String Contact;
    private int BranchId;
    private int Vehicle;

    public Driver(int Id, String FullName, String Address, String NIC, String Contact, int BranchId) {
        this.Id = Id;
        this.FullName = FullName;
        this.Address = Address;
        this.NIC = NIC;
        this.Contact = Contact;
        this.BranchId = BranchId;
    }

    public Driver(int Id, String FullName, String Address, String NIC, String Contact, int BranchId, int Vehicle) {
        this.Id = Id;
        this.FullName = FullName;
        this.Address = Address;
        this.NIC = NIC;
        this.Contact = Contact;
        this.BranchId = BranchId;
        this.Vehicle = Vehicle;
    }

    public Driver() {
    }

    public int getVehicle() {
        return Vehicle;
    }

    public void setVehicle(int Vehicle) {
        this.Vehicle = Vehicle;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public int getBranchId() {
        return BranchId;
    }

    public void setBranchId(int BranchId) {
        this.BranchId = BranchId;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
        return new Driver(Id, FullName, Address, NIC, Contact, BranchId, Vehicle);
    }
    
}
