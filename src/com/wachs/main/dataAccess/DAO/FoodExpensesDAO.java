package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface FoodExpensesDAO {

    ArrayList fetchFoodExpensesOneGuest(int idGuest, int idProject);

    ArrayList fetchAllFoodExpensesOneProject(int idProject);

    void deleteFoodExpensesOneGuest(int idGuest, int idProject, double price, String reason, String when);

    void updateFoodExpensesOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen);

    void insertFoodExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when);

}
