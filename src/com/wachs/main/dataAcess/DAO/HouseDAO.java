package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.House;

import java.util.ArrayList;

public interface HouseDAO {

    House findOneData(String name);

    ArrayList readAllData();

    void insertData(String name, double price, double deposite);

    void updateData(int oldId, String newName, double price, double deposite);

    void deleteData(String name);
}
