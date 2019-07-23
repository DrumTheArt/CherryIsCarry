package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Food;

import java.util.ArrayList;

public interface FoodDAO {

    Food fetchFoodByOneGuest(int IdGuest, int idProject);

    ArrayList fetchAllFoodByOneProject(int idProject);

    void updateFoodOneGuest(int idGuest, int idProject, int newNights);

    void deleteFoodOneGuest(int idGuest, int idProject);

    void insertFoodOneGuest(int idGuest, int idProject, int nights);
}
