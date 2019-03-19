package com.wachs.main.models;

import com.wachs.main.businessObjects.OtherExpense;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAO;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAOImpl;

import java.util.ArrayList;

public class OtherExpenseModel {

    private OtherExpensesDAO newDAO;
    private ArrayList<OtherExpense> otherExpensesSearchedGuest;
    private ArrayList<OtherExpense> otherExpensesSearchedProject;
    private int idGuest;
    private int idProject;

    OtherExpenseModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }


    private void createModel(int idGuest, int idProject) {

        newDAO = new OtherExpensesDAOImpl();
        otherExpensesSearchedGuest = newDAO.findOtherExpensesByOneGuest(idGuest, idProject);
        otherExpensesSearchedProject = newDAO.findAllOtherExpensesByOneProject(idProject);

        if (otherExpensesSearchedGuest != null) {

            this.idProject = otherExpensesSearchedGuest.get(0).getIdProject();
            this.idGuest = otherExpensesSearchedGuest.get(0).getIdGuest();

        }
    }

    public double getSumOtherExpensesByOneProject() {

        double sum = 0;

        for (OtherExpense othExp : otherExpensesSearchedProject) {

            sum += othExp.getREAL_price();
        }

        return sum;
    }

    public double getSumOtherExpensesSearchedGuest() {

        double sum = 0;

        for (OtherExpense othExp : otherExpensesSearchedGuest) {

            sum += othExp.getREAL_price();

        }
        return sum;
    }

    public ArrayList<OtherExpense> getOtherExpensesSearchedGuestAsList() {

        return otherExpensesSearchedGuest;

    }

    public void setOtherExpenses(double price, String reason, String when) {

        int newFK = getFkId();

        otherExpensesSearchedGuest.add(new OtherExpense(newFK, price, reason, when, idGuest, idProject));

        newDAO.insertOtherExpensesForOneGuest(idGuest, idProject, price, reason, when);

    }

    private int getFkId() {

        return otherExpensesSearchedGuest.size() + 1;

    }

    public void deleteOneOtherExpenses(double spend, String reason, String when) {

        for (OtherExpense e : otherExpensesSearchedGuest) {

            if (e.getREAL_price() == spend && e.getReason().equals(reason) && e.getWhen().equals(when)) {
                otherExpensesSearchedGuest.remove(e);
            }
        }

        newDAO.deleteOtherExpensesForOneGuest(idGuest, idProject, spend, reason, when);

    }

}