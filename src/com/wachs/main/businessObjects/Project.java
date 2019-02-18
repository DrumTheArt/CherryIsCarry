package com.wachs.main.businessObjects;

public class Project {

    private int PK_id;
    private String projectName;
    private double projectPrice;
    private double projectDeposite;


    public Project(){

    }

    public Project(String projectName, double projectPrice, double projectDeposite){

        this.projectName = projectName;
        this.projectPrice = projectPrice;
        this.projectDeposite = projectDeposite;

    }

    public Project(int pk_id, String projectName, double projectPrice, double projectDeposite) {

        this.PK_id = pk_id;
        this.projectName = projectName;
        this.projectPrice = projectPrice;
        this.projectDeposite = projectDeposite;
    }

    public int getPK_id() {
        return PK_id;
    }

    public void setPK_id(int PK_id) {
        this.PK_id=PK_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public double getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(double projectPrice){
        this.projectPrice = projectPrice;
    }

    public double getProjectDeposite() {
        return projectDeposite;
    }

    public void setProjectDeposite(double projectDeposite){
        this.projectDeposite = projectDeposite;
    }

}