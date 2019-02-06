package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.DAO.HouseDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StubsHouseDAO implements HouseDAO {

    private House alphaHouse;
    private House houseOne;
    private House houseTwo;
    private ArrayList<House> listOfHouses;

    public StubsHouseDAO() {

        listOfHouses = new ArrayList<House>();
        alphaHouse = new House();
        houseOne = new House();
        listOfHouses.add(alphaHouse);
        listOfHouses.add(houseOne);
    }

    @Override
    public House findOneData(String name) throws SQLException, ClassNotFoundException {

        return this.alphaHouse;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        return listOfHouses;
    }

    @Override
    public void insertData(String name, double price, double deposite) throws SQLException, ClassNotFoundException {

        houseTwo = new House(name, price, deposite);
        listOfHouses.add(houseTwo);
    }

    @Override
    public void updateData(int oldId, String newName, double newPrice, double newDeposite) throws SQLException, ClassNotFoundException {

        this.alphaHouse.setTXT_name(newName);
        this.alphaHouse.setREAL_price(newPrice);
        this.alphaHouse.setREAL_deposite(newDeposite);
    }

    @Override
    public void deleteData(String name) throws SQLException, ClassNotFoundException {

        this.alphaHouse.setTXT_name("");
        this.alphaHouse.setREAL_deposite(0);
        this.alphaHouse.setREAL_price(0);
        this.alphaHouse.setPK_id(0);
    }

}
