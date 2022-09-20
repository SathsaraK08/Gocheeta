
package com.cab.models;

import com.google.gson.Gson;
import java.io.Serializable;

public class ProductType implements Serializable, Prototype{
    
    private int Id;
    private String Type;
    private String Description;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public ProductType(int Id, String Type, String Description) {
        this.Id = Id;
        this.Type = Type;
        this.Description = Description;
    }
    
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
        return new ProductType(Id, Type, Description);
    }
    
}
