
package com.cab.models;

import java.util.ArrayList;

public class SalesObject implements Prototype{
    
    private int Id;
    private int Branch;
    private int Customer;
    private float Amount;
    private String Datetime;
    private String PaymentMethod;
    private ArrayList<SalesDetail> ProductDetails; 

    
    public SalesObject(int Id, int Branch, int Customer, float Amount, String Datetime, String PaymentMethod) {
        this.Id = Id;
        this.Branch = Branch;
        this.Customer = Customer;
        this.Amount = Amount;
        this.Datetime = Datetime;
        this.PaymentMethod = PaymentMethod;
    }
    
    public SalesObject()
    {
        
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getBranch() {
        return Branch;
    }

    public void setBranch(int Branch) {
        this.Branch = Branch;
    }

    public int getCustomer() {
        return Customer;
    }

    public void setCustomer(int Customer) {
        this.Customer = Customer;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String Datetime) {
        this.Datetime = Datetime;
    }

    public ArrayList<SalesDetail> getProductDetails() {
        return ProductDetails;
    }

    public void setProductDetails(ArrayList<SalesDetail> ProductDetails) {
        this.ProductDetails = ProductDetails;
    }

    @Override
    public Prototype getCloneObject() {
        return new SalesObject(Id, Branch, Customer, Amount, Datetime, PaymentMethod);
    }

   
    
    
}


