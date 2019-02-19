package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

interface DrinksExpensesDAO {

    ArrayList findDrinksExpensesByOneGuest(int idGuest, int idProject);

    ArrayList findAllDrinksExpensesByOneProject(int idProject);

    void deleteDrinksExpensesForOneGuest(int idGuest, int idProject, double spend);

    void updateDrinksExpensesForOneGuest(int idGuest, int idProject, double oldSpendValue, double newSpendValue);

    void insertOtherExpensesForOneGuest(int idGuest, int IdProject, double spend);
}
