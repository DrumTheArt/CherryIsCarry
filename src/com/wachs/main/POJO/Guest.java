package com.wachs.main.POJO;

public class Guest  {

    private int primaryKey;
    private int projectId;
    private String guestName;

    public Guest(){

    }

    public Guest(String guestName, int projectId) {

        this.projectId = projectId;
        this.guestName = guestName;

    }

    public Guest(int primaryKey, int projectId, String guestName) {

        this.primaryKey = primaryKey;
        this.guestName = guestName;
        this.projectId = projectId;
    }

    public int getPrimaryKey() {
        return this.primaryKey;
    }

    public int getProjectId() {
        return this.projectId;
    }

    public String getGuestName() {
        return this.guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

}