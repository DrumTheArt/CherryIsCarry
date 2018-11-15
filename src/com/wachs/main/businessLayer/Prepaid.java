package com.wachs.main.businessLayer;

public class Prepaid  {

    private int PK_id;
    private double prepaid;
    private int id_guest;
    private int id_house;

    public Prepaid(){

    }

    public Prepaid(int FK_id, double prepaid, int id_guest, int id_house){

        this.PK_id =FK_id;
        this.prepaid=prepaid;
        this.id_guest=id_guest;
        this.id_house=id_house;
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

    public int getId_house() {
        return this.id_house;
    }

    public void setId_house(int id_house) {
        this.id_house=id_house;
    }

    public int getId_guest() {
        return this.id_guest;
    }

    public void setId_guest(int id_guest) {
        this.id_guest=id_guest;
    }

}
