package com.wachs.main.businessLayer;

public class Guest  {

    private int PK_id;
    private int id_house;
    private String TXT_name;

    public Guest(){

    }

    public Guest(String TXT_name, int id_house) {

        this.id_house = id_house;
        this.TXT_name = TXT_name;

    }

    public Guest(int pk_id, int id_house, String TXT_name) {

        this.PK_id = pk_id;
        this.TXT_name = TXT_name;
        this.id_house = id_house;
    }

    public int getPK_id() {
        return this.PK_id;
    }

    public int getId_house() {
        return this.id_house;
    }

    public String getTXT_name() {
        return this.TXT_name;
    }

    public void setTXT_name(String TXT_name) {
        this.TXT_name = TXT_name;
    }

    public void setPK_id(int PK_id) {
        this.PK_id = PK_id;
    }

    public void setId_house(int id_house) {
        this.id_house = id_house;
    }

}
