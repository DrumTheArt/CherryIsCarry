package com.wachs.main.POJO;

public class FoodExpense {

    private int PK_id;
    private double spend;
    private String reason;
    private String when;
    private int idGuest;
    private int IdProject;

    public FoodExpense() {

    }

    public FoodExpense(int FK_id, double spend, String reason, String when, int idGuest, int idProject) {

        this.PK_id = FK_id;
        this.spend = spend;
        this.reason = reason;
        this.when = when;
        this.idGuest = idGuest;
        this.IdProject = idProject;
    }

    public int getPK_id() {
        return this.PK_id;
    }

    public void setPK_id(int PK_id) {
        this.PK_id = PK_id;
    }

    public int getIdProject() {
        return IdProject;
    }

    public void setIdProject(int idProject) {
        this.IdProject = idProject;
    }

    public void set_spend(double REAL_price) {
        this.spend = REAL_price;
    }

    public double get_spend() {
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

    public int getIdGuest() {
        return this.idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

}