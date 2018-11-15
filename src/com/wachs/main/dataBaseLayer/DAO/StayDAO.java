package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Stay;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StayDAO {

    Stay findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException;

    ArrayList readAllData() throws SQLException, ClassNotFoundException;

    void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException;

    void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException;

    void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException;
}
