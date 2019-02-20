package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface FoodExpensesDAO {

    ArrayList findFoodExpensesByOneGuest(int idGuest, int idProject);

    ArrayList findAllFoodExpensesByOneProject(int idProject);

    void deleteFoodExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when);

    void updateFoodExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen);

    void insertFoodExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when);

}
