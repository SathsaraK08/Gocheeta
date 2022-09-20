
package com.cab.models;

import com.google.gson.Gson;
import java.io.Serializable;


public class SystemUser implements Serializable, Prototype{
    private int Id;
    private String Username;
    private String Email;
    private String Password;
    private int BranchId;
    private String Contact;
    private String Salt;
    private String UserType;
    private String Address;
    private String NIC;

    public SystemUser(int Id, String Username, String Email, String Password, int BranchId, String Contact, String Salt, String UserType, String NIC, String Address) {
        this.Id = Id;
        this.Username = Username;
        this.Email = Email;
        this.Password = Password;
        this.BranchId = BranchId;
        this.Contact = Contact;
        this.Salt = Salt;
        this.UserType = UserType;
        this.Address = Address;
        this.NIC = NIC;
    }
    
   
    public SystemUser(int Id, String Username, String Email, String Password, int BranchId, String Contact) {
        this.Id = Id;
        this.Username = Username;
        this.Email = Email;
        this.Password = Password;
        this.BranchId = BranchId;
        this.Contact = Contact;
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

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    
    public String getSalt() {
        return Salt;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getBranchId() {
        return BranchId;
    }

    public void setBranchId(int BranchId) {
        this.BranchId = BranchId;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }   
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
      return new SystemUser(Id, Username, Email, Password, BranchId, Contact, Salt, UserType, NIC, Address);
    }
    
}
