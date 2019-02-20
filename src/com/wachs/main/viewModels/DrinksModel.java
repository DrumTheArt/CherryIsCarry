package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAccess.DAO.DrinksDAO;
import com.wachs.main.dataAccess.DAO.DrinksDAOImpl;

public class DrinksModel {

    private DrinksDAO newDAO;
    private Drinks staySearchedGuest;
    private int idGuest;
    private int idProject;


    DrinksModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new DrinksDAOImpl();
        staySearchedGuest = newDAO.findDrinksByOneGuest(idGuest, idProject);

        this.idGuest = staySearchedGuest.getIdGuest();
        this.idProject = staySearchedGuest.getIdProject();
    }

    public int getDrinks() {

        return staySearchedGuest.getNights();

    }

    public void setNights(int nights) {

        staySearchedGuest.setNights(nights);

        if (staySearchedGuest == null) {

            newDAO.insertDrinksForOneGuest(idGuest, idProject, nights);
        } else {

            newDAO.updateDrinksForOneGuest(idGuest, idProject, nights);
        }
    }
}
