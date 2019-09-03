package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.Food;
import com.wachs.main.DataAccess.services.FoodService;
import com.wachs.main.DataAccess.services.IFoodService;

public class FoodModel {

    private IFoodService newDAO;
    private Food foodSearchedGuest;
    private int idGuest;
    private int idProject;


    FoodModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new FoodService();
        foodSearchedGuest = newDAO.fetchFoodByOneGuest(idGuest, idProject);

        this.idGuest = foodSearchedGuest.getGuestId();
        this.idProject = foodSearchedGuest.getProjectId();
    }

    public int getFood() {

        return foodSearchedGuest.getNights();

    }

    public void setFoods(int nights) {

        foodSearchedGuest.setNights(nights);

        if (foodSearchedGuest == null) {

            newDAO.insertFoodOneGuest(idGuest, idProject, nights);
        } else {

            newDAO.insertFoodOneGuest(idGuest, idProject, nights);
        }
    }
}
