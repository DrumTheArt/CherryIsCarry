package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Prepaid;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PrepaidDAO {

    ArrayList readAllData() throws SQLException, ClassNotFoundException;

    Prepaid findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException;

    void insertData(int id_guest, int id_house, double prepaid) throws SQLException, ClassNotFoundException;

    void updateData(int id_guest, int id_house, double newPrepaid) throws SQLException, ClassNotFoundException;

    void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException;
}
