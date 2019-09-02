package com.wachs.main.POJO;

public class Drinks  {

    private int primaryKey;
    private int nights;
    private int guestId;
    private int projectId;

    public Drinks(){

    }

    public Drinks(int primaryKey, int nights, int guestId, int projectId){

        this.primaryKey = primaryKey;
        this.nights = nights;
        this.guestId = guestId;
        this.projectId = projectId;
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

    public int getNights() {
        return this.nights;
    }

    public int getGuestId() {
        return this.guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setNights(int nights) {
        this.nights=nights;
    }

}