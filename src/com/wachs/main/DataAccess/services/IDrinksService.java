package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Drinks;

import java.util.ArrayList;

public interface IDrinksService {

    Drinks fetchDrinksOneGuest(int idGuest, int idProject);

    ArrayList fetchAllDrinksOneProject(int idProject);

    void updateDrinksOneGuest(int idGuest, int idProject, int newNights);

    void deleteDrinksOneGuest(int idGuest, int idProject);

    void insertDrinksOneGuest(int idGuest, int idProject, int nights);

}