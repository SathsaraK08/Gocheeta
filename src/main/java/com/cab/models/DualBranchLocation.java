
package com.cab.models;

import java.io.Serializable;


public class DualBranchLocation implements Serializable , Prototype{
    private String SLong;
    private String SLati;
    private String DLong;
    private String DLati;

    public DualBranchLocation(String SLong, String SLati, String DLong, String DLati) {
        this.SLong = SLong;
        this.SLati = SLati;
        this.DLong = DLong;
        this.DLati = DLati;
    }

    public DualBranchLocation() {
        
    }
    public String getSLong() {
        return SLong;
    }

    public void setSLong(String SLong) {
        this.SLong = SLong;
    }

    public String getSLati() {
        return SLati;
    }

    public void setSLati(String SLati) {
        this.SLati = SLati;
    }

    public String getDLong() {
        return DLong;
    }

    public void setDLong(String DLong) {
        this.DLong = DLong;
    }

    public String getDLati() {
        return DLati;
    }

    public void setDLati(String DLati) {
        this.DLati = DLati;
    }

    @Override
    public Prototype getCloneObject() {
       return new DualBranchLocation(SLong, SLati, DLong, DLati);
    }
    
    
}
