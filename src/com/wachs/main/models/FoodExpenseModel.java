package com.wachs.main.models;

import com.wachs.main.POJO.FoodExpense;
import com.wachs.main.dataAccess.DAO.FoodExpensesDAO;
import com.wachs.main.dataAccess.DAO.FoodExpensesDAOImpl;

import java.util.ArrayList;

public class FoodExpenseModel {

    private FoodExpensesDAO newDAO;
    private ArrayList<FoodExpense> foodExpensesSearchedGuest;
    private int idGuest;
    private int idProject;

    FoodExpenseModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }


    private void createModel(int idGuest, int idProject) {

        newDAO = new FoodExpensesDAOImpl();
        foodExpensesSearchedGuest = newDAO.fetchFoodExpensesOneGuest(idGuest, idProject);

        if (foodExpensesSearchedGuest != null) {

            this.idProject = foodExpensesSearchedGuest.get(0).getIdProject();
            this.idGuest = foodExpensesSearchedGuest.get(0).getIdGuest();

        }
    }

    public double getSumExpenses() {

        double sum = 0;

        for (FoodExpense foodExp : foodExpensesSearchedGuest) {

            sum += foodExp.get_spend();

        }
        return sum;
    }

    public ArrayList<FoodExpense> getFoodExpensesSearchedGuest() {

        return foodExpensesSearchedGuest;

    }

    public void setFoodExpenses(double price, String reason, String when) {

        int newFK = getFkId();

        foodExpensesSearchedGuest.add(new FoodExpense(newFK, price, reason, when, idGuest, idProject));

        newDAO.insertFoodExpensesOneGuest(idGuest, idProject, price, reason, when);

    }

    public void deleteOneFoodExpenses(double spend, String reason, String when) {

        for (FoodExpense e : foodExpensesSearchedGuest) {

            if (e.get_spend() == spend) {
                foodExpensesSearchedGuest.remove(e);
            }
        }

        newDAO.deleteFoodExpensesOneGuest(idGuest, idProject, spend, reason, when);

    }

    private int getFkId() {

        return foodExpensesSearchedGuest.size() + 1;

    }

}
