
package com.cab.models;

import com.google.gson.Gson;
import java.util.ArrayList;

public class ProductRequest implements Prototype{
    
    private int Id;
    private int SourceBranch;
    private int DestinationBranch;
    private String DateCreated;
    private String Status;
    private int Vehicle;
    private int User;
    private ArrayList<ProductRequestDetail> Objs;
    private Vehicle VehicleObj;
    private Branch SourceBranchObj;

    public ProductRequest(int Id, int SourceBranch, int DestinationBranch, String DateCreated, String Status, int Vehicle, int User) {
        this.Id = Id;
        this.SourceBranch = SourceBranch;
        this.DestinationBranch = DestinationBranch;
        this.DateCreated = DateCreated;
        this.Status = Status;
        this.Vehicle = Vehicle;
        this.User = User;
    }

    public ProductRequest(int Id, int SourceBranch, int DestinationBranch, String DateCreated, String Status, int Vehicle, int User, ArrayList<ProductRequestDetail> Objs, Vehicle VehicleObj, Branch SourceBranchObj) {
        this.Id = Id;
        this.SourceBranch = SourceBranch;
        this.DestinationBranch = DestinationBranch;
        this.DateCreated = DateCreated;
        this.Status = Status;
        this.Vehicle = Vehicle;
        this.User = User;
        this.Objs = Objs;
        this.VehicleObj = VehicleObj;
        this.SourceBranchObj = SourceBranchObj;
    }
    
    public ProductRequest()
    {
        
    }

    public Vehicle getVehicleObj() {
        return VehicleObj;
    }

    public void setVehicleObj(Vehicle VehicleObj) {
        this.VehicleObj = VehicleObj;
    }

    public Branch getSourceBranchObj() {
        return SourceBranchObj;
    }

    public void setSourceBranchObj(Branch SourceBranchObj) {
        this.SourceBranchObj = SourceBranchObj;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSourceBranch() {
        return SourceBranch;
    }

    public void setSourceBranch(int SourceBranch) {
        this.SourceBranch = SourceBranch;
    }

    public int getDestinationBranch() {
        return DestinationBranch;
    }

    public void setDestinationBranch(int DestinationBranch) {
        this.DestinationBranch = DestinationBranch;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getVehicle() {
        return Vehicle;
    }

    public void setVehicle(int Vehicle) {
        this.Vehicle = Vehicle;
    }

    public int getUser() {
        return User;
    }

    public void setUser(int User) {
        this.User = User;
    }

    public ArrayList<ProductRequestDetail> getObjs() {
        return Objs;
    }

    public void setObjs(ArrayList<ProductRequestDetail> Objs) {
        this.Objs = Objs;
    }
    
    public String getJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }

    @Override
    public Prototype getCloneObject() {
       return new ProductRequest(Id, SourceBranch, DestinationBranch, DateCreated, Status, Vehicle, User);
    }
    
    
}
