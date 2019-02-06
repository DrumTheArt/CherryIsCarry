package com.wachs.main.dataAcess.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ExpenseDAO {

    ArrayList fineAllDataToOneGuest(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException;

    ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException;

    void deleteData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException, IOException;

    void updateData(int id_guest, int id_house, double price, String reason, String when, double newPrice, String newReason, String newWhen) throws SQLException, ClassNotFoundException, IOException;

    void insertData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException, IOException;

}
