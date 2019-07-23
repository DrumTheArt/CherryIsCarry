package com.wachs.main.POJO;

public class Guest  {

    private int PK_id;
    private int idProject;
    private String guestName;

    public Guest(){

    }

    public Guest(String guestName, int idProject) {

        this.idProject = idProject;
        this.guestName = guestName;

    }

    public Guest(int pk_id, int idProject, String guestName) {

        this.PK_id = pk_id;
        this.guestName = guestName;
        this.idProject = idProject;
    }

    public int getPK_id() {
        return this.PK_id;
    }

    public int getIdProject() {
        return this.idProject;
    }

    public String getGuestName() {
        return this.guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setPK_id(int PK_id) {
        this.PK_id = PK_id;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

}