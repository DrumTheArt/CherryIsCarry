package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.House;
import java.sql.SQLException;
import java.util.ArrayList;

public interface HouseDAO {

    House findOneData(String name) throws SQLException, ClassNotFoundException;

    ArrayList readAllData() throws SQLException, ClassNotFoundException;

    void insertData(String name, double price, double deposite) throws SQLException, ClassNotFoundException;

    void updateData(int oldId, String newName, double price, double deposite) throws SQLException, ClassNotFoundException;

    void deleteData(String name) throws SQLException, ClassNotFoundException;
}
