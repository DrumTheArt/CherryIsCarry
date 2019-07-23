package com.wachs.main.models;

import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.DAO.FoodDAO;
import com.wachs.main.dataAccess.DAO.FoodDAOImpl;

public class FoodModel {

    private FoodDAO newDAO;
    private Food foodSearchedGuest;
    private int idGuest;
    private int idProject;


    FoodModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new FoodDAOImpl();
        foodSearchedGuest = newDAO.fetchFoodByOneGuest(idGuest, idProject);

        this.idGuest = foodSearchedGuest.getIdGuest();
        this.idProject = foodSearchedGuest.getIdProject();
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
