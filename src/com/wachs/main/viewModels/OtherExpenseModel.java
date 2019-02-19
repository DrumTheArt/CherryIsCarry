package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.OtherExpense;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAO;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class OtherExpenseModel {

    private OtherExpensesDAO newDAO;
    private ArrayList<OtherExpense> expensesSearchedGuest;
    private ArrayList<String> expensesReasons;
    private ArrayList<String> expensesWhen;


    OtherExpenseModel(int idGuest, int id_house)  {

        createModel(idGuest, id_house);
    }

    private ArrayList<OtherExpense> createModel(int idGuest, int id_house) {

        newDAO = new OtherExpensesDAOImpl();
        expensesSearchedGuest = newDAO.findOtherExpensesByOneGuest(idGuest, id_house);

        return expensesSearchedGuest;
    }

}
