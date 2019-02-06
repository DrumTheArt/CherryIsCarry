package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.Food;
import com.wachs.main.dataAcess.DAO.FoodDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StubsFoodDAO implements FoodDAO {

    private Food alphaFood;
    private Food foodOne;
    private Food foodTwo;
    private ArrayList<Food> listOfFood;

    public StubsFoodDAO() {

        listOfFood = new ArrayList<Food>();
        alphaFood = new Food();
        foodOne = new Food();
        listOfFood.add(alphaFood);
        listOfFood.add(foodOne);
    }

    @Override
    public Food findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        return this.alphaFood;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        return listOfFood;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException {

        this.alphaFood.setId_guest(id_guest);
        this.alphaFood.setId_house(id_house);
        this.alphaFood.setNights(newNights);

    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        this.alphaFood.setId_guest(0);
        this.alphaFood.setId_house(0);
        this.alphaFood.setPK_id(0);
        this.alphaFood.setNights(0);
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException {

        foodTwo = new Food(1, nights, id_guest,id_house);
        listOfFood.add(foodTwo);
    }
}