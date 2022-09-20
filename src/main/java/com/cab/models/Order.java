
package com.cab.models;


public class Order implements Prototype{
    private int id;
    private String name;
    private String driver;
    private String contact;
    private String dcontact;
    private String date;
    private String pick;
    private String dest;
    private String vtype;
    private int did;
    private double charge;

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Order(int id, String name, String driver, String contact, String dcontact, String date, String pick, String dest, String vtype, int did, double charge) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.contact = contact;
        this.dcontact = dcontact;
        this.date = date;
        this.pick = pick;
        this.dest = dest;
        this.vtype = vtype;
        this.did = did;
        this.charge = charge;
    }
    
    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDcontact() {
        return dcontact;
    }

    public void setDcontact(String dcontact) {
        this.dcontact = dcontact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
    
    

    @Override
    public Prototype getCloneObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
