package com.wachs.main.POJO;

public class Project {

    private int primaryKey;
    private String name;
    private double price;
    private double deposite;


    public Project(){

    }

    public Project(String name, double price, double deposite){

        this.name = name;
        this.price = price;
        this.deposite = deposite;

    }

    public Project(int primaryKey, String name, double price, double deposite) {

        this.primaryKey = primaryKey;
        this.name = name;
        this.price = price;
        this.deposite = deposite;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getDeposite() {
        return deposite;
    }

    public void setDeposite(double deposite){
        this.deposite = deposite;
    }

}