
package com.cab.models;

import com.google.gson.Gson;

public class SalesDetail implements Prototype{

    private int Id;
    private int SalesId;
    private int Product;
    private float Quantity;
    private float Amount;

    public SalesDetail(int Id, int SalesId, int Product, float Quantity, float Amount) {
        this.Id = Id;
        this.SalesId = SalesId;
        this.Product = Product;
        this.Quantity = Quantity;
        this.Amount = Amount;
    }
    public SalesDetail()
    {
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSalesId() {
        return SalesId;
    }

    public void setSalesId(int SalesId) {
        this.SalesId = SalesId;
    }

    public int getProduct() {
        return Product;
    }

    public void setProduct(int Product) {
        this.Product = Product;
    }

    public float getQuantity() {
        return Quantity;
    }

    public void setQuantity(float Quantity) {
        this.Quantity = Quantity;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }
    
      public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
        return new SalesDetail(Id, SalesId, Product, Quantity, Amount);
    }
}
