package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface DrinksExpensesDAO {

    ArrayList fetchDrinksExpensesOneGuest(int idGuest, int idProject);

    ArrayList fetchAllDrinksExpensesOneProject(int idProject);

    void deleteDrinksExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when);

    void updateDrinksExpensesOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen) ;

    void insertDrinksExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when);

}
