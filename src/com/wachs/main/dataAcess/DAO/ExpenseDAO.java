package com.wachs.main.dataAcess.DAO;

import java.util.ArrayList;

public interface ExpenseDAO {

    ArrayList fineAllDataToOneGuest(int id_guest, int id_house);

    ArrayList readAllData();

    void deleteData(int id_guest, int id_house, double price, String reason, String when);

    void updateData(int id_guest, int id_house, double price, String reason, String when, double newPrice, String newReason, String newWhen);

    void insertData(int id_guest, int id_house, double price, String reason, String when);

}
