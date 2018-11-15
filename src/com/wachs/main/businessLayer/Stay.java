package com.wachs.main.businessLayer;

public class Stay  {

    private int PK_id;
    private int nights;
    private int id_guest;
    private int id_house;

    public Stay(){

    }

    public Stay(int FK_id, int nights, int id_guest, int id_house){

        this.PK_id =FK_id;
        this.nights=nights;
        this.id_guest=id_guest;
        this.id_house=id_house;
    }

    public int getPK_id() {
        return this.PK_id;
    }

    public void setPK_id(int PK_id) {
        this.PK_id =PK_id;
    }

    public int getNights() {
        return this.nights;
    }

    public int getId_guest() {
        return this.id_guest;
    }

    public int getId_house() {
        return this.id_house;
    }

    public void setId_house(int id_house) {
        this.id_house=id_house;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public void setId_guest(int id_guest) {
        this.id_house= id_guest;
    }

}
