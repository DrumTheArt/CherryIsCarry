package com.wachs.main.BusinessEntities;

public class FoodExpense {

    private int primaryKey;
    private double spend;
    private String reason;
    private String when;
    private int guestId;
    private int projectId;

    public FoodExpense() {

    }

    public FoodExpense(int primaryKey, double spend, String reason, String when, int guestId, int projectId) {

        this.primaryKey = primaryKey;
        this.spend = spend;
        this.reason = reason;
        this.when = when;
        this.guestId = guestId;
        this.projectId = projectId;
    }

    public int getPrimaryKey() {
        return this.primaryKey;
    }

    public void setPrimaryKey(int PK_id) {
        this.primaryKey = PK_id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setSpend(double REAL_price) {
        this.spend = REAL_price;
    }

    public double getSpend() {
        return this.spend;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public int getGuestId() {
        return this.guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

}