package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAcess.DAO.StayDAO;

import java.util.ArrayList;

public class StubsStayDAO implements StayDAO {

    private Stay alphaStay;
    private Stay stayOne;
    private Stay stayTwo;
    private ArrayList<Stay> listOfStays;

    public StubsStayDAO() {

        listOfStays = new ArrayList<Stay>();
        alphaStay = new Stay();
        stayOne = new Stay();
        listOfStays.add(alphaStay);
        listOfStays.add(stayOne);
    }

    @Override
    public ArrayList readAllData() {

        return listOfStays;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) {

        this.alphaStay.setNights(newNights);
    }

    @Override
    public Stay findOneData(int id_guest, int id_house) {

        return this.alphaStay;
    }

    @Override
    public void deleteData(int id_guest, int id_house) {

        this.alphaStay.setId_guest(0);
        this.alphaStay.setId_house(0);
        this.alphaStay.setNights(0);
        this.alphaStay.setPK_id(0);
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) {

        stayTwo = new Stay(1,nights,id_guest, id_house);
        listOfStays.add(stayTwo);
    }

}