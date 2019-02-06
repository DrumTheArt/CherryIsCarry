package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.DAO.HouseDAO;
import com.wachs.main.dataAcess.DAO.HouseDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class HouseModel {

    private HouseDAO newDAO;
    private House searchedHouse;

    HouseModel(String nameHouse) throws SQLException, IOException, ClassNotFoundException {

        createModel(nameHouse);
    }

    private House createModel(String projectName) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new HouseDAOImpl();
        searchedHouse = newDAO.findOneData(projectName);

        return searchedHouse;
    }

    public int getPK_id(){

        return searchedHouse.getPK_id();

    }

    public String getprojectTitle(){

        return searchedHouse.getTXT_name();

    }

    public double getPrice(){

        return searchedHouse.getREAL_price();

    }

    public double getDeposite(){

        return searchedHouse.getREAL_deposite();

    }
}
