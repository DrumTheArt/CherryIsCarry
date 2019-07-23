package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Drinks;

import java.util.ArrayList;

public interface DrinksDAO {

    Drinks findDrinksOneGuest(int idGuest, int idProject);

    ArrayList findAllDrinksOneProject(int idProject);

    void updateDrinksOneGuest(int idGuest, int idProject, int newNights);

    void deleteDrinksOneGuest(int idGuest, int idProject);

    void insertDrinksOneGuest(int idGuest, int idProject, int nights);

}
