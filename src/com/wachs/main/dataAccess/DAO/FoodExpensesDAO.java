package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface FoodExpensesDAO {

    ArrayList findFoodExpensesByOneGuest(int idGuest, int idProject);

    ArrayList findAllFoodExpensesByOneProject(int idProject);

    void deleteFoodExpensesForOneGuest(int idGuest, int idProject, double spend);

    void updateFoodExpensesForOneGuest(int idGuest, int idProject, double oldSpendValue, double newSpendValue);

    void insertFoodExpensesForOneGuest(int idGuest, int IdProject, double spend);

}
