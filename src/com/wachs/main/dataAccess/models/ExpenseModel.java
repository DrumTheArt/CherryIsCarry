package com.wachs.main.dataAccess.models;

import com.wachs.main.businessObjects.Expense;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAO;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExpenseModel {

    private OtherExpensesDAO newDAO;
    private ArrayList<Expense> expensesSearchedGuest;
    private ArrayList<String> expensesReasons;
    private ArrayList<String> expensesWhen;


    ExpenseModel(int idGuest, int id_house) throws SQLException, IOException, ClassNotFoundException {

        createModel(idGuest, id_house);
    }

    private ArrayList<Expense> createModel(int idGuest, int id_house) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new OtherExpensesDAOImpl();
        expensesSearchedGuest = newDAO.findExpensesByOneGuest(idGuest, id_house);

        return expensesSearchedGuest;
    }

    public double getSpend(){

        return calculateSumSpend();

    }

    public ArrayList<String> getReasons(){

        for(Expense e:expensesSearchedGuest){

            expensesReasons.add(e.getReason());
        }
        return expensesReasons;

    }

    public ArrayList<String> getWhens(){

        for(Expense e:expensesSearchedGuest){
            expensesWhen.add(e.getWhen());
        }
        return expensesWhen;

    }

    private double calculateSumSpend(){

        double sum = 0;

        for(Expense e:expensesSearchedGuest){
            sum =+ e.getREAL_price();
        }
        return sum;
    }

}
