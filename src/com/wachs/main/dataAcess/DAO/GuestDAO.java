package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Guest;

import java.util.ArrayList;

public interface GuestDAO {

    Guest findOneGuestByOneProject(String name, int idHouse);

    ArrayList findAllGuestsByOneProject(int idHouse);

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    void insertGuestForOneProject(int idHouse, String name);

    void updateGuestForOneProject(int oldId, String name, int idProject);

    void deleteGuestForOneProject(String name, int idProject);

}
