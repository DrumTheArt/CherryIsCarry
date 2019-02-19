package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.FoodExpense;
import com.wachs.main.dataAccess.DAO.*;
import java.util.ArrayList;

public class FoodExpenseModel {

    private FoodExpensesDAO newDAO;
    private ArrayList<FoodExpense> foodExpensesSearchedGuest;

    FoodExpenseModel(int idGuest, int id_house)  {

        createModel(idGuest, id_house);
    }

    private ArrayList<FoodExpense> createModel(int idGuest, int id_house) {

        newDAO = new FoodExpensesDAOImpl();
        foodExpensesSearchedGuest = newDAO.findFoodExpensesByOneGuest(idGuest, id_house);

        return foodExpensesSearchedGuest;
    }
}
