package com.wachs.main.POJO;

public class OtherExpense {

    private int primaryKey;
    private double spend;
    private String reason;
    private String when;
    private int guestId;
    private int projectId;

    public OtherExpense() {

    }

    public OtherExpense(int primaryKey, double spend, String reason, String when, int guestId, int projectId) {

        this.primaryKey =primaryKey;
        this.spend = spend;
        this.reason = reason;
        this.when=when;
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
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String TXT_name) {
        this.reason = TXT_name;
    }

    public void setSpend(double REAL_price) {
        this.spend=REAL_price;
    }

    public double getSpend() {
        return this.spend;
    }

    public int getGuestId() {
        return this.guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setWhen(String when){
        this.when=when;
    }

    public String getWhen(){
        return this.when;
    }

}