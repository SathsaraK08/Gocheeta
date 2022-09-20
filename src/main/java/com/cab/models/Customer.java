
package com.cab.models;

import com.google.gson.Gson;


public class Customer  implements Prototype{
    private int id;
    private String name;
    private String address;
    private String nic;
    private String email;
    private String phone;

    public Customer(int id, String name, String address, String nic, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.email = email;
        this.phone = phone;
    }
    public Customer()
    {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
       return new Customer(id, name, address, nic, email, phone);    
    }
    
}
