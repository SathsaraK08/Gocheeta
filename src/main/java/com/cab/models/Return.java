
package com.cab.models;

import com.google.gson.Gson;


public class Return implements Prototype{
    private int Id;
    private int Branch;
    private int Product;
    private int Qty;

    public Return(int Id, int Branch, int Product, int Qty) {
        this.Id = Id;
        this.Branch = Branch;
        this.Product = Product;
        this.Qty = Qty;
    }
    public Return(){}

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

    public int getProduct() {
        return Product;
    }

    public void setProduct(int Product) {
        this.Product = Product;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);    
    }

    @Override
    public Prototype getCloneObject() {
        return new Return(Id, Branch, Product, Qty);
    }
    
    
}
