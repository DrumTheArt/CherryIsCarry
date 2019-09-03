package com.wachs.main.BusinessEntities;

public class DrinksExpense {

    private int primarykey;
    private double spend;
    private String reason;
    private String when;
    private int guestId;
    private int projectId;

    public DrinksExpense() {

    }

    public DrinksExpense(int primaryKey, double spend, String reason, String when, int guestId, int projectId) {

        this.primarykey = primaryKey;
        this.spend = spend;
        this.when = when;
        this.reason = reason;
        this.guestId = guestId;
        this.projectId = projectId;

    }

    public int getPrimaryKey() {
        return this.primarykey;
    }

    public void setPrimaryKey(int PK_id) {
        this.primarykey = PK_id;
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

    public int getGuestId() {
        return this.guestId;
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

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

}