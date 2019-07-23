package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Drinks;

import java.util.ArrayList;

public interface DrinksDAO {

    Drinks fetchDrinksOneGuest(int idGuest, int idProject);

    ArrayList fetchAllDrinksOneProject(int idProject);

    void updateDrinksOneGuest(int idGuest, int idProject, int newNights);

    void deleteDrinksOneGuest(int idGuest, int idProject);

    void insertDrinksOneGuest(int idGuest, int idProject, int nights);

}