package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Prepaid;

import java.util.ArrayList;

public interface PrepaidDAO {

    ArrayList readAllData();

    Prepaid findOneData(int id_guest, int id_house);

    void insertData(int id_guest, int id_house, double prepaid);

    void updateData(int id_guest, int id_house, double newPrepaid);

    void deleteData(int id_guest, int id_house);
}
