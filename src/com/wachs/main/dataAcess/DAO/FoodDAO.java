package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Food;

import java.util.ArrayList;

public interface FoodDAO {

    Food findFoodByOneGuest(int IdGuest, int idProject);

    ArrayList findAllFoodByOneProject(int idProject);

    void updateFoodForOneGuest(int idGuest, int idProject, int newNights);

    void deleteFoodForOneGuest(int idGuest, int idProject);

    void insertFoodForOneGuest(int idGuest, int idProject, int nights);
}
