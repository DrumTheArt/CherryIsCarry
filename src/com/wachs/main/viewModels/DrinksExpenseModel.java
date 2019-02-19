package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.DrinksExpense;
import com.wachs.main.dataAccess.DAO.*;
import java.util.ArrayList;

public class DrinksExpenseModel {

    private DrinksExpensesDAO newDAO;
    private ArrayList<DrinksExpense> drinksExpensesSearchedGuest;

    DrinksExpenseModel(int idGuest, int id_house)  {

        createModel(idGuest, id_house);
    }

    private ArrayList<DrinksExpense> createModel(int idGuest, int id_house) {

        newDAO = new DrinksExpensesDAOImpl();
        drinksExpensesSearchedGuest = newDAO.findDrinksExpensesByOneGuest(idGuest, id_house);

        return drinksExpensesSearchedGuest;
    }
}
