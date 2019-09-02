package com.wachs.main.models;

import com.wachs.main.POJO.OtherExpense;
import com.wachs.main.dataAccess.services.IOtherExpensesService;
import com.wachs.main.dataAccess.services.OtherExpensesService;

import java.util.ArrayList;

public class OtherExpenseModel {

    private IOtherExpensesService newDAO;
    private ArrayList<OtherExpense> otherExpensesSearchedGuest;
    private ArrayList<OtherExpense> otherExpensesSearchedProject;
    private int idGuest;
    private int idProject;

    OtherExpenseModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }


    private void createModel(int idGuest, int idProject) {

        newDAO = new OtherExpensesService();
        otherExpensesSearchedGuest = newDAO.fetchOtherExpensesOneGuest(idGuest, idProject);
        otherExpensesSearchedProject = newDAO.fetchAllOtherExpensesOneProject(idProject);

        if (otherExpensesSearchedGuest != null) {

            this.idProject = otherExpensesSearchedGuest.get(0).getProjectId();
            this.idGuest = otherExpensesSearchedGuest.get(0).getGuestId();

        }
    }

    public double getSumOtherExpensesByOneProject() {

        double sum = 0;

        for (OtherExpense othExp : otherExpensesSearchedProject) {

            sum += othExp.getSpend();
        }

        return sum;
    }

    public double getSumOtherExpensesSearchedGuest() {

        double sum = 0;

        for (OtherExpense othExp : otherExpensesSearchedGuest) {

            sum += othExp.getSpend();

        }
        return sum;
    }

    public ArrayList<OtherExpense> getOtherExpensesSearchedGuestAsList() {

        return otherExpensesSearchedGuest;

    }

    public void setOtherExpenses(double price, String reason, String when) {

        int newFK = getFkId();

        otherExpensesSearchedGuest.add(new OtherExpense(newFK, price, reason, when, idGuest, idProject));

        newDAO.insertOtherExpensesOneGuest(idGuest, idProject, price, reason, when);

    }

    private int getFkId() {

        return otherExpensesSearchedGuest.size() + 1;

    }

    public void deleteOneOtherExpenses(double spend, String reason, String when) {

        for (OtherExpense e : otherExpensesSearchedGuest) {

            if (e.getSpend() == spend && e.getReason().equals(reason) && e.getWhen().equals(when)) {
                otherExpensesSearchedGuest.remove(e);
            }
        }

        newDAO.deleteOtherExpensesOneGuest(idGuest, idProject, spend, reason, when);

    }

}