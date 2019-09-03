package com.wachs.main.BusinessEntities;

public class Prepaid  {

    private int primaryKey;
    private double prepaid;
    private int guestId;
    private int projectId;

    public Prepaid(){

    }

    public Prepaid(int primaryKey, double prepaid, int guestId, int projectId){

        this.primaryKey = primaryKey;
        this.prepaid = prepaid;
        this.guestId = guestId;
        this.projectId = projectId;
    }

    public double getPrepaid() {
        return this.prepaid;
    }

    public void setPrepaid(double prepaid) {
        this.prepaid=prepaid;
    }

    public int getPrimaryKey() {
        return this.primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getProjectId() {
        return this.projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getGuestId() {
        return this.guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

}