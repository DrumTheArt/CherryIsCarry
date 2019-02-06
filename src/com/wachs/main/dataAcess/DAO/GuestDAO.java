package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Guest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface GuestDAO {

    Guest findOneData(String name, int id_house) throws SQLException, ClassNotFoundException, IOException;

    ArrayList readAllData(int id_house) throws SQLException, ClassNotFoundException, IOException;

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    void insertData(int id_house, String name) throws SQLException, ClassNotFoundException, IOException;

    void updateData(int oldId, String name, int id_house) throws SQLException, ClassNotFoundException, IOException;

    void deleteData(String name, int id_house) throws SQLException, ClassNotFoundException, IOException;

    ArrayList findListDataWhereHouseID(int id_house) throws SQLException, ClassNotFoundException, IOException;

}
