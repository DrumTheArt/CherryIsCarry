package com.wachs.main.models;

import com.wachs.main.POJO.DrinksExpense;
import com.wachs.main.dataAccess.services.IDrinksExpensesService;
import com.wachs.main.dataAccess.services.DrinksExpensesService;

import java.util.ArrayList;

public class DrinksExpenseModel {

    private IDrinksExpensesService newDAO;
    private ArrayList<DrinksExpense> drinksExpensesSearchedGuest;
    private int idGuest;
    private int idProject;

    DrinksExpenseModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }


    private void createModel(int idGuest, int idProject) {

        newDAO = new DrinksExpensesService();
        drinksExpensesSearchedGuest = newDAO.fetchDrinksExpensesOneGuest(idGuest, idProject);

        if (drinksExpensesSearchedGuest != null) {

            this.idProject = drinksExpensesSearchedGuest.get(0).getProjectId();
            this.idGuest = drinksExpensesSearchedGuest.get(0).getGuestId();

        }
    }

    public double getSumDrinksExpenses() {

        double sum = 0;

        for (DrinksExpense drinksExp : drinksExpensesSearchedGuest) {

            sum += drinksExp.getSpend();

        }
        return sum;
    }

    public ArrayList<DrinksExpense> getDrinksExpensesSearchedGuest() {

        return drinksExpensesSearchedGuest;

    }

    public void setDrinksExpenses(double price, String reason, String when) {

        int newFK = getFkId();

        drinksExpensesSearchedGuest.add(new DrinksExpense(newFK, price, reason, when, idGuest, idProject));

        newDAO.insertDrinksExpensesOneGuest(idGuest, idProject, price, reason, when);

    }

    public void deleteOneDrinksExpenses(double spend, String reason, String when) {

        for (DrinksExpense e : drinksExpensesSearchedGuest) {

            if (e.getSpend() == spend) {
                drinksExpensesSearchedGuest.remove(e);
            }
        }

        //TODO hier Parameter fixen
        //newDAO.deleteDrinksExpensesOneGuest(idGuest, idProject, spend, reason, when);

    }

    private int getFkId() {

        return drinksExpensesSearchedGuest.size() + 1;

    }
}