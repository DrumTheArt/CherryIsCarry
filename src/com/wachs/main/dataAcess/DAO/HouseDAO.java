package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.House;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface HouseDAO {

    House findOneData(String name) throws SQLException, ClassNotFoundException, IOException;

    ArrayList readAllData();

    void insertData(String name, double price, double deposite) throws SQLException, ClassNotFoundException, IOException;

    void updateData(int oldId, String newName, double price, double deposite) throws SQLException, ClassNotFoundException, IOException;

    void deleteData(String name) throws SQLException, ClassNotFoundException, IOException;
}
