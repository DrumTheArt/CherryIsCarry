package com.wachs.main.POJO;

public class Food {

    private int PK_id;
    private int nights;
    private int idGuest;
    private int idProject;

    public Food(){

    }

    public Food(int FK_id, int nights, int idGuest, int idProject){

        this.PK_id = FK_id;
        this.nights = nights;
        this.idGuest = idGuest;
        this.idProject = idProject;
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

    public int getNights() {
        return this.nights;
    }

    public int getIdGuest() {
        return this.idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public void setNights(int nights) {
        this.nights=nights;
    }

}