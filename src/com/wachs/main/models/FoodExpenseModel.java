package com.wachs.main.models;

import com.wachs.main.POJO.FoodExpense;
import com.wachs.main.dataAccess.services.FoodExpensesService;
import com.wachs.main.dataAccess.services.IFoodExpensesService;

import java.util.ArrayList;

public class FoodExpenseModel {

    private IFoodExpensesService newDAO;
    private ArrayList<FoodExpense> foodExpensesSearchedGuest;
    private int idGuest;
    private int idProject;

    FoodExpenseModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }


    private void createModel(int idGuest, int idProject) {

        newDAO = new FoodExpensesService();
        foodExpensesSearchedGuest = newDAO.fetchFoodExpensesOneGuest(idGuest, idProject);

        if (foodExpensesSearchedGuest != null) {

            this.idProject = foodExpensesSearchedGuest.get(0).getProjectId();
            this.idGuest = foodExpensesSearchedGuest.get(0).getGuestId();

        }
    }

    public double getSumExpenses() {

        double sum = 0;

        for (FoodExpense foodExp : foodExpensesSearchedGuest) {

            sum += foodExp.getSpend();

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

            if (e.getSpend() == spend) {
                foodExpensesSearchedGuest.remove(e);
            }
        }

        newDAO.deleteFoodExpensesOneGuest(idGuest, idProject, spend, reason, when);

    }

    private int getFkId() {

        return foodExpensesSearchedGuest.size() + 1;

    }

}
