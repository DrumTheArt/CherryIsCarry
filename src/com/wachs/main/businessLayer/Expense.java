package com.wachs.main.businessLayer;

public class Expense  {

    private int PK_id;
    private double spend;
    private String TXT_name;
    private String when;
    private int id_guest;
    private int id_house;

    public Expense(){

    }

    public Expense(int FK_id, double spend, String TXT_name, String when, int id_guest, int id_house){

        this.PK_id =FK_id;
        this.spend = spend;
        this.TXT_name = TXT_name;
        this.when=when;
        this.id_guest=id_guest;
        this.id_house=id_house;
    }

    public int getPK_id() {
        return this.PK_id;
    }

    public void setPK_id(int PK_id) {
        this.PK_id=PK_id;
    }

    public int getId_house() {
        return id_house;
    }

    public void setId_house(int id_house) {
        this.id_house=id_house;
    }

    public String getTXT_name() {
        return this.TXT_name;
    }

    public void setTXT_name(String TXT_name) {
        this.TXT_name=TXT_name;
    }

    public void setREAL_price(double REAL_price) {
        this.spend=REAL_price;
    }

    public double getREAL_price() {
        return this.spend;
    }

    public int getId_guest() {
        return this.id_guest;
    }

    public void setId_guest(int id_guest) {
        this.id_guest=id_guest;
    }

    public void setWhen(String when){
        this.when=when;
    }

    public String getWhen(){
        return this.when;
    }

}
