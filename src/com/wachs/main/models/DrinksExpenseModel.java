package com.wachs.main.models;

import com.wachs.main.POJO.DrinksExpense;
import com.wachs.main.dataAccess.DAO.DrinksExpensesDAO;
import com.wachs.main.dataAccess.DAO.DrinksExpensesDAOImpl;

import java.util.ArrayList;

public class DrinksExpenseModel {

    private DrinksExpensesDAO newDAO;
    private ArrayList<DrinksExpense> drinksExpensesSearchedGuest;
    private int idGuest;
    private int idProject;

    DrinksExpenseModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }


    private void createModel(int idGuest, int idProject) {

        newDAO = new DrinksExpensesDAOImpl();
        drinksExpensesSearchedGuest = newDAO.fetchDrinksExpensesOneGuest(idGuest, idProject);

        if (drinksExpensesSearchedGuest != null) {

            this.idProject = drinksExpensesSearchedGuest.get(0).getIdProject();
            this.idGuest = drinksExpensesSearchedGuest.get(0).getIdGuest();

        }
    }

    public double getSumDrinksExpenses() {

        double sum = 0;

        for (DrinksExpense drinksExp : drinksExpensesSearchedGuest) {

            sum += drinksExp.get_spend();

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

            if (e.get_spend() == spend) {
                drinksExpensesSearchedGuest.remove(e);
            }
        }

        newDAO.deleteDrinksExpensesOneGuest(idGuest, idProject, spend, reason, when);

    }

    private int getFkId() {

        return drinksExpensesSearchedGuest.size() + 1;

    }
}