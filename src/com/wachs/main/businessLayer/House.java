package com.wachs.main.businessLayer;

public class House  {

    private int PK_id;
    private String TXT_name;
    private double REAL_price;
    private double REAL_deposite;


    public House(){

    }

    public House(String TXT_name, double REAL_price, double REAL_deposite){
        this.TXT_name = TXT_name;
        this.REAL_price = REAL_price;
        this.REAL_deposite = REAL_deposite;
    }

    public House(int pk_id, String TXT_name, double REAL_price, double REAL_deposite) {

        this.PK_id = pk_id;
        this.TXT_name = TXT_name;
        this.REAL_price = REAL_price;
        this.REAL_deposite = REAL_deposite;
    }

    public int getPK_id() {
        return PK_id;
    }

    public void setPK_id(int PK_id) {
        this.PK_id=PK_id;
    }

    public String getTXT_name() {
        return TXT_name;
    }

    public void setTXT_name(String TXT_name){
        this.TXT_name=TXT_name;
    }

    public double getREAL_price() {
        return REAL_price;
    }

    public void setREAL_price(double REAL_price){
        this.REAL_price=REAL_price;
    }

    public double getREAL_deposite() {
        return REAL_deposite;
    }

    public void setREAL_deposite(double REAL_deposite){
        this.REAL_deposite=REAL_deposite;
    }

}