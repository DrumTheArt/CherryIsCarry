package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAcess.DAO.DrinksDAO;

import java.util.ArrayList;

public class StubsDrinksDAO implements DrinksDAO {

    private Drinks alphaDrink;
    private Drinks drinkOne;
    private Drinks drinkTwo;
    private ArrayList<Drinks> listOfDrinks;

    public StubsDrinksDAO() {

        listOfDrinks = new ArrayList<Drinks>();
        alphaDrink = new Drinks();
        drinkOne = new Drinks();
        listOfDrinks.add(alphaDrink);
        listOfDrinks.add(drinkOne);
    }

    @Override
    public Drinks findOneData(int id_guest, int id_house) {

        return this.alphaDrink;
    }

    @Override
    public ArrayList readAllData() {

        return listOfDrinks;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) {

        this.alphaDrink.setNights(newNights);
    }

    @Override
    public void deleteData(int id_guest, int id_house) {

        this.alphaDrink.setId_guest(0);
        this.alphaDrink.setId_house(0);
        this.alphaDrink.setNights(0);
        this.alphaDrink.setPK_id(0);
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) {

        drinkTwo = new Drinks(1, id_guest,id_house, nights);
        listOfDrinks.add(drinkTwo);

    }
}
