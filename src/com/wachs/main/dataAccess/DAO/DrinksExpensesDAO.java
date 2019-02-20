package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface DrinksExpensesDAO {

    ArrayList findDrinksExpensesByOneGuest(int idGuest, int idProject);

    ArrayList findAllDrinksExpensesByOneProject(int idProject);

    void deleteDrinksExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when);

    void updateDrinksExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen) ;

    void insertDrinksExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when);

}
