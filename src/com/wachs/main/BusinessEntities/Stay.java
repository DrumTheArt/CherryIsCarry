package com.wachs.main.BusinessEntities;

public class Stay  {

    private int primaryKey;
    private int nights;
    private int guestId;
    private int projectId;

    public Stay(){

    }

    public Stay(int FK_id, int nights, int guestId, int projectId){

        this.primaryKey = FK_id;
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

    public int getNights() {
        return this.nights;
    }

    public int getGuestId() {
        return this.guestId;
    }

    public int getProjectId() {
        return this.projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public void setGuestId(int guestId) { this.guestId = guestId; }

}