package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAcess.DAO.DrinksDAO;
import com.wachs.main.dataAcess.DAO.DrinksDAOImpl;

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
        drinksSearchedGuest = newDAO.findDrinksByOneGuest(idGuest, idHouse);

        return drinksSearchedGuest;
    }

    public int getIdHouse(){

        return drinksSearchedGuest.getIdProject();

    }

    public int getIdGuest(){

        return drinksSearchedGuest.getIdGuest();

    }

    public int getNightCount(){

        return drinksSearchedGuest.getNights();

    }

}
