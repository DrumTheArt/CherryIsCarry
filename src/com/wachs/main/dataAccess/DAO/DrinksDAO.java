package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Drinks;

import java.util.ArrayList;

public interface DrinksDAO {

    Drinks findDrinksByOneGuest(int idGuest, int idProject);

    ArrayList findAllDrinksByOneProject(int idProject);

    void updateDrinksForOneGuest(int idGuest, int idProject, int newNights);

    void deleteDrinksForOneGuest(int idGuest, int idProject);

    void insertDrinksForOneGuest(int idGuest, int idProject, int nights);

}
