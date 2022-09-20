
package com.cab.models;

import com.google.gson.Gson;


public class ProductCompressed implements Prototype{
    private int id;
    private String product_name;
    private float unit_price;
    private String unit;
    private int AvailableQty;

    public ProductCompressed(int id, String product_name, float unit_price, String unit, int AvailableQty) {
        this.id = id;
        this.product_name = product_name;
        this.unit_price = unit_price;
        this.unit = unit;
        this.AvailableQty = AvailableQty;
    }

    public int getAvailableQty() {
        return AvailableQty;
    }

    public void setAvailableQty(int AvailableQty) {
        this.AvailableQty = AvailableQty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
       return new ProductCompressed(id, product_name, unit_price, unit, AvailableQty);
    }
    
}
