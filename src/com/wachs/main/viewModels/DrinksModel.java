package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAccess.DAO.DrinksDAO;
import com.wachs.main.dataAccess.DAO.DrinksDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class DrinksModel {

    private DrinksDAO newDAO;
    private Drinks drinksSearchedGuest;

    DrinksModel(int idGuest, int idHouse) {

        createModel(idGuest, idHouse);
    }

    private Drinks createModel(int idGuest, int idHouse) {

        newDAO = new DrinksDAOImpl();
        drinksSearchedGuest = newDAO.findDrinksByOneGuest(idGuest, idHouse);

        return drinksSearchedGuest;
    }

}
