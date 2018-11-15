package com.wachs.test.unitTests.mocks;

import com.wachs.main.businessLayer.Stay;
import com.wachs.main.dataBaseLayer.DAO.StayDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MockStayDAO implements StayDAO {

    private Stay alphaStay;
    private Stay stayOne;
    private Stay stayTwo;
    private ArrayList<Stay> listOfStays;

    public MockStayDAO() {

        listOfStays = new ArrayList<Stay>();
        alphaStay = new Stay();
        stayOne = new Stay();
        listOfStays.add(alphaStay);
        listOfStays.add(stayOne);
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        return listOfStays;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException {

        this.alphaStay.setNights(newNights);
    }

    @Override
    public Stay findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        return this.alphaStay;
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        this.alphaStay.setId_guest(0);
        this.alphaStay.setId_house(0);
        this.alphaStay.setNights(0);
        this.alphaStay.setPK_id(0);
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException {

        stayTwo = new Stay(1,nights,id_guest, id_house);
        listOfStays.add(stayTwo);
    }

}