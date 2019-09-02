package com.wachs.main.models;

import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.services.IFoodService;
import com.wachs.main.dataAccess.services.FoodService;

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
