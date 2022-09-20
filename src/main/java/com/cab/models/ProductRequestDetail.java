
package com.cab.models;

import com.google.gson.Gson;
import java.util.ArrayList;


public class ProductRequestDetail implements Prototype{
    private int Id;
    private int RequestId;
    private int ProductId;
    private float Qty;
    private ArrayList<Product> ProductObj;

    public ProductRequestDetail(int Id, int RequestId, int ProductId, float Qty) {
        this.Id = Id;
        this.RequestId = RequestId;
        this.ProductId = ProductId;
        this.Qty = Qty;
    }

    public ProductRequestDetail(int Id, int RequestId, int ProductId, float Qty, ArrayList<Product> ProductObj) {
        this.Id = Id;
        this.RequestId = RequestId;
        this.ProductId = ProductId;
        this.Qty = Qty;
        this.ProductObj = ProductObj;
    }

    public ArrayList<Product> getProductObj() {
        return ProductObj;
    }

    public void setProductObj(ArrayList<Product> ProductObj) {
        this.ProductObj = ProductObj;
    }

   

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int RequestId) {
        this.RequestId = RequestId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);       
    }

    @Override
    public Prototype getCloneObject() {
        return new ProductRequestDetail(Id, RequestId, ProductId, Qty);
    }
}
