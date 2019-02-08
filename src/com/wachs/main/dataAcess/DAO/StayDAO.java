package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Stay;

import java.util.ArrayList;

public interface StayDAO {

    Stay findOneData(int id_guest, int id_house);

    ArrayList readAllData();

    void updateData(int id_guest, int id_house, int newNights);

    void deleteData(int id_guest, int id_house);

    void insertData(int id_guest, int id_house, int nights);
}
