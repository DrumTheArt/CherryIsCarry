package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Expense;
import com.wachs.main.dataBaseLayer.DAO.ExpenseDAO;
import com.wachs.main.dataBaseLayer.DAO.ExpenseDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExpenseViewModel {

    private ExpenseDAO newDAO;
    private ArrayList<Expense> expensesSearchedGuest;
    private ArrayList<String> expensesReasons;
    private ArrayList<String> expensesWhen;


    ExpenseViewModel(int idGuest, int id_house) throws SQLException, IOException, ClassNotFoundException {

        createModel(idGuest, id_house);
    }

    private ArrayList<Expense> createModel(int idGuest, int id_house) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new ExpenseDAOImpl();
        expensesSearchedGuest = newDAO.fineAllDataToOneGuest(idGuest, id_house);

        return expensesSearchedGuest;
    }

    public double getSpend(){

        return calculateSumSpend();

    }

    public ArrayList<String> getReasons(){

        for(Expense e:expensesSearchedGuest){

            expensesReasons.add(e.getTXT_reason());
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
