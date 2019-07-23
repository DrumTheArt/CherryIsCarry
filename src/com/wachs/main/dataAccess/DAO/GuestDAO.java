package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Guest;

import java.util.ArrayList;

public interface GuestDAO {

    Guest fetchOneGuestOneProject(String name, int idHouse);

    ArrayList fetchAllGuestsOneProject(int idHouse);

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    void insertGuestOneProject(int idHouse, String name);

    void updateGuestOneProject(int oldId, String name, int idProject);

    void deleteGuestOneProject(String name, int idProject);

}
