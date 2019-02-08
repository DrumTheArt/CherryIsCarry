package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Guest;

import java.util.ArrayList;

public interface GuestDAO {

    Guest findOneData(String name, int id_house);

    ArrayList readAllData(int id_house);

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    void insertData(int id_house, String name);

    void updateData(int oldId, String name, int id_house);

    void deleteData(String name, int id_house);

    ArrayList findListDataWhereHouseID(int id_house);

}
