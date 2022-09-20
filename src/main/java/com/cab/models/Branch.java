
package com.cab.models;

import com.cab.service.BranchLogic;
import com.cab.service.IBranchLogic;
import com.cab.service.ITransportLogic;
import com.cab.service.TransportLogic;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;


public class Branch implements Serializable, Prototype{
    
    private int Id;
    private String Name;
    private String City;
    private String Longtitude;
    private String Latitude;
    private String Address;
    private String Contact;
    private String Email;
    private String Type;
    private ArrayList<Vehicle> Vehicles; 

   

    public Branch() {
    }

    public Branch(int Id, String Name, String City, String Longtitude, String Latitude, String Address, String Contact, String Email, String Type) {
        this.Id = Id;
        this.Name = Name;
        this.City = City;
        this.Longtitude = Longtitude;
        this.Latitude = Latitude;
        this.Address = Address;
        this.Contact = Contact;
        this.Email = Email;
        this.Type = Type;
    }

    public Branch(int Id, String Name, String City, String Longtitude, String Latitude, String Address, String Contact, String Email, String Type, ArrayList<Vehicle> Vehicles) {
        this.Id = Id;
        this.Name = Name;
        this.City = City;
        this.Longtitude = Longtitude;
        this.Latitude = Latitude;
        this.Address = Address;
        this.Contact = Contact;
        this.Email = Email;
        this.Type = Type;
        this.Vehicles = Vehicles;
    }

    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getLongtitude() {
        return Longtitude;
    }

    public void setLongtitude(String Longtitude) {
        this.Longtitude = Longtitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        String classString = "Branch{" + "Id=" + Id + ", Name=" + Name + ", City=" + City + ", Longtitude=" + Longtitude + ", Latitude=" + Latitude + ", Address=" + Address + ", Contact=" + Contact + ", Email=" + Email + ", Type=" + Type + '}';
        //Gson gson = new Gson();
        //return gson.toJson(classString, Branch.class);
        return classString;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    public ArrayList<Vehicle> getVehicles() {
        return Vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> Vehicles) {
        this.Vehicles = Vehicles;
    }

    @Override
    public Prototype getCloneObject() {
        return new Branch(Id, Name, City, Longtitude, Latitude, Address, Contact, Email, Type);
    }
    
    
    
}
