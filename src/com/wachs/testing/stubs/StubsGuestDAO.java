package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.dataAcess.DAO.GuestDAO;

import java.util.ArrayList;

public class StubsGuestDAO implements GuestDAO {

    private Guest alphaGuest;
    private Guest guestOne;
    private Guest guestTwo;
    private ArrayList<Guest> listOfGuests;

    public StubsGuestDAO() {

        listOfGuests = new ArrayList<Guest>();
        alphaGuest = new Guest();
        guestOne = new Guest();
        listOfGuests.add(alphaGuest);
        listOfGuests.add(guestOne);
    }

    @Override
    public Guest findOneData(String name, int id_house) {

        return this.alphaGuest;
    }

    @Override
    public ArrayList readAllData(int id_house) {

        return listOfGuests;
    }

    @Override
    public void insertData(int id_house, String name) {

        guestTwo = new Guest(name, id_house);
        listOfGuests.add(guestTwo);
    }

    @Override
    public void updateData(int oldId, String name, int id_house) {

        this.alphaGuest.setId_house(id_house);
        this.alphaGuest.setTXT_name(name);
    }

    @Override
    public void deleteData(String name, int id_house) {

        this.alphaGuest.setTXT_name("");
        this.alphaGuest.setId_house(0);
    }

    @Override
    public ArrayList findListDataWhereHouseID(int id_house) {
        return listOfGuests;
    }

}
