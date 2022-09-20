
package com.cab.models;

import com.google.gson.Gson;
import java.io.Serializable;


public class Product implements Serializable, Prototype {
    
    private int Id;    
    private int TypeId;
    private String ProductName;
    private String Description;
    private int SupplierId;
    private float UnitPrice;
    private int AvailbleUnits;
    private int branchId;
    private String Measure;
    private ProductType TypeObj;
    private String ProductTypeName;

    public Product(int Id, int TypeId, String ProductName, String Description, int SupplierId, float UnitPrice, int AvailbleUnits, int branchId, String Measure, String TypeName) {
        this.Id = Id;
        this.TypeId = TypeId;
        this.ProductName = ProductName;
        this.Description = Description;
        this.SupplierId = SupplierId;
        this.UnitPrice = UnitPrice;
        this.AvailbleUnits = AvailbleUnits;
        this.branchId = branchId;
        this.Measure = Measure;
        this.TypeObj = new ProductType(this.TypeId,TypeName,"");
    }

    public Product(int Id, int TypeId, String ProductName, String Description, float UnitPrice, String Measure, String TypeName) {
        this.Id = Id;
        this.TypeId = TypeId;
        this.ProductName = ProductName;
        this.Description = Description;
        this.UnitPrice = UnitPrice;
        this.Measure = Measure;
        this.TypeObj = new ProductType(this.TypeId,TypeName,"");
    }

    public Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getProductTypeName() {
        return TypeObj.getType();
    }

    public void setProductTypeName(String ProductTypeName) {
        this.ProductTypeName = ProductTypeName;
    }

    public ProductType getTypeObj() {
        return TypeObj;
    }

    public void setTypeObj(ProductType TypeObj) {
        this.TypeObj = TypeObj;
    }

    
    public String getMeasure() {
        return Measure;
    }

    public void setMeasure(String Measure) {
        this.Measure = Measure;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int TypeId) {
        this.TypeId = TypeId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int SupplierId) {
        this.SupplierId = SupplierId;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getAvailbleUnits() {
        return AvailbleUnits;
    }

    public void setAvailbleUnits(int AvailbleUnits) {
        this.AvailbleUnits = AvailbleUnits;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
      return new Product(Id, TypeId, ProductName, Description, SupplierId, UnitPrice, AvailbleUnits, branchId, Measure, ProductName);
    }
    
}
