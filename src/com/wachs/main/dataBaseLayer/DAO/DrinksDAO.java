package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Drinks;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DrinksDAO extends IDAO{

    Drinks findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;

    ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException;

    void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException, IOException;

    void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;

    void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException, IOException;

}
