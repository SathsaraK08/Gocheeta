
package com.cab.models;


public class ReturnsSummary implements Prototype{
    
    private int Product;
    private int Qty;
    private String ProductName;

    public ReturnsSummary(int Product, int Qty, String ProductName) {
        this.Product = Product;
        this.Qty = Qty;
        this.ProductName = ProductName;
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

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    @Override
    public Prototype getCloneObject() {
        return new ReturnsSummary(Product, Qty, ProductName);
    }
    
    
    
}
