package com.wachs.main.businessObjects;

public class Prepaid  {

    private int PK_id;
    private double prepaid;
    private int idGuest;
    private int idProject;

    public Prepaid(){

    }

    public Prepaid(int FK_id, double prepaid, int idGuest, int idProject){

        this.PK_id =FK_id;
        this.prepaid=prepaid;
        this.idGuest =idGuest;
        this.idProject =idProject;
    }

    public double getPrepaid() {
        return this.prepaid;
    }

    public void setPrepaid(double prepaid) {
        this.prepaid=prepaid;
    }

    public int getPK_id() {
        return this.PK_id;
    }

    public void setPK_id(int PK_id) {
        this.PK_id=PK_id;
    }

    public int getIdProject() {
        return this.idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public int getIdGuest() {
        return this.idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

}
