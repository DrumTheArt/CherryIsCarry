package com.wachs.main.models;

import com.wachs.main.POJO.Drinks;
import com.wachs.main.dataAccess.services.IDrinksService;
import com.wachs.main.dataAccess.services.DrinksService;

public class DrinksModel {

    private IDrinksService newDAO;
    private Drinks staySearchedGuest;
    private int idGuest;
    private int idProject;


    DrinksModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new DrinksService();
        staySearchedGuest = newDAO.fetchDrinksOneGuest(idGuest, idProject);

        this.idGuest = staySearchedGuest.getGuestId();
        this.idProject = staySearchedGuest.getProjectId();
    }

    public int getDrinks() {

        return staySearchedGuest.getNights();

    }

    public void setNights(int nights) {

        staySearchedGuest.setNights(nights);

        if (staySearchedGuest == null) {

            newDAO.insertDrinksOneGuest(idGuest, idProject, nights);
        } else {

            newDAO.updateDrinksOneGuest(idGuest, idProject, nights);
        }
    }
}
