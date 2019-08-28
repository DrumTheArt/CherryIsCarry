package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface FoodExpensesDAO {

    ArrayList fetchFoodExpensesOneGuest(int idGuest, int idProject);

    ArrayList fetchAllFoodExpensesOneProject(int idProject);

    void deleteFoodExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when);

    void updateFoodExpensesOneGuest(int idGuest, int idProject, double newPrice, String newReason, String newWhen, double oldPrice, String oldReason, String oldWhen);

    void insertFoodExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when);

}
