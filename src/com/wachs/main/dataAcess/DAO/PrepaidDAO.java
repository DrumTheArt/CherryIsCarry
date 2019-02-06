package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Prepaid;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PrepaidDAO {

    ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException;

    Prepaid findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;

    void insertData(int id_guest, int id_house, double prepaid) throws SQLException, ClassNotFoundException, IOException;

    void updateData(int id_guest, int id_house, double newPrepaid) throws SQLException, ClassNotFoundException, IOException;

    void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;
}
