package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Food;

import java.util.ArrayList;

public interface IFoodService {

    Food fetchFoodByOneGuest(int IdGuest, int idProject);

    ArrayList fetchAllFoodByOneProject(int idProject);

    void updateFoodOneGuest(int idGuest, int idProject, int newNights);

    void deleteFoodOneGuest(int idGuest, int idProject);

    void insertFoodOneGuest(int idGuest, int idProject, int nights);
}
