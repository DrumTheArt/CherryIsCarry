package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Guest;
import java.sql.SQLException;
import java.util.ArrayList;

public interface GuestDAO {

    Guest findOneData(String name, int id_house) throws SQLException, ClassNotFoundException;

    ArrayList readAllData() throws SQLException, ClassNotFoundException;

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    void insertData(int id_house, String name) throws SQLException, ClassNotFoundException;

    void updateData(int oldId, String name, int id_house) throws SQLException, ClassNotFoundException;

    void deleteData(String name, int id_house) throws SQLException, ClassNotFoundException;

    ArrayList findListDataWhereHouseID(int id_house) throws SQLException, ClassNotFoundException;

}
