package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Drinks;
import com.wachs.main.dataBaseLayer.DAO.DrinksDAO;
import com.wachs.main.dataBaseLayer.DAO.DrinksDAOImpl;

public class ViewModelDrinks {

    private DrinksDAO drinksDAO;
    private Drinks drinks;

    public ViewModelDrinks() {

        drinksDAO = new DrinksDAOImpl();
        drinks = new Drinks();


    }
}
