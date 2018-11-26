package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Expense;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ExpenseDAO {

    Expense findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;

    ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException;

    void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;

    void updateData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException, IOException;

    void insertData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException, IOException;

}
