package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Drinks;
import com.wachs.main.dataBaseLayer.DAO.DrinksDAO;
import com.wachs.main.dataBaseLayer.DAO.DrinksDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class DrinksModel {

    private DrinksDAO newDAO;
    private Drinks drinksSearchedGuest;

    DrinksModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

        createModel(idGuest, idHouse);
    }

    private Drinks createModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new DrinksDAOImpl();
        drinksSearchedGuest = newDAO.findOneData(idGuest, idHouse);

        return drinksSearchedGuest;
    }

    public int getIdHouse(){

        return drinksSearchedGuest.getId_house();

    }

    public int getIdGuest(){

        return drinksSearchedGuest.getId_guest();

    }

    public int getNightCount(){

        return drinksSearchedGuest.getNights();

    }

}
