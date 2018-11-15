package com.wachs.test.unitTests.mocks;

import com.wachs.main.businessLayer.Drinks;
import com.wachs.main.dataBaseLayer.DAO.DrinksDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class MockDrinksDAO implements DrinksDAO {

    private Drinks alphaDrink;
    private Drinks drinkOne;
    private Drinks drinkTwo;
    private ArrayList<Drinks> listOfDrinks;

    public MockDrinksDAO() {

        listOfDrinks = new ArrayList<Drinks>();
        alphaDrink = new Drinks();
        drinkOne = new Drinks();
        listOfDrinks.add(alphaDrink);
        listOfDrinks.add(drinkOne);
    }

    @Override
    public Drinks findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        return this.alphaDrink;

    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        return listOfDrinks;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException {

        this.alphaDrink.setNights(newNights);
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        this.alphaDrink.setId_guest(0);
        this.alphaDrink.setId_house(0);
        this.alphaDrink.setNights(0);
        this.alphaDrink.setPK_id(0);
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException {

        drinkTwo = new Drinks(1, id_guest,id_house, nights);
        listOfDrinks.add(drinkTwo);

    }
}
