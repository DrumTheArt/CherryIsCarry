package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.DrinksExpense;
import com.wachs.main.businessObjects.FoodExpense;
import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.DAO.DrinksExpensesDAOImpl;
import com.wachs.main.dataAccess.DAO.FoodExpensesDAOImpl;
import com.wachs.main.dataAccess.DAO.PrepaidDAOImpl;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;

import java.util.ArrayList;

public class AllGuestsModel {

    private Project selectedProject;
    private int selectedProjectID;
    private ArrayList<DrinksExpense> allDrinksToProject;
    private ArrayList<FoodExpense> allFoodToProject;
    private ArrayList<Prepaid> allPrepaidToProject;

    public AllGuestsModel(String nameProject) {

        createModel(nameProject);
    }

    private void createModel(String nameProject){

        selectedProject = new ProjectDAOImpl().fineOneProject(nameProject);
        selectedProjectID = selectedProject.getPK_id();
    }

    public double getRentProject() {

        return selectedProject.getProjectPrice();
    }

    public double getDepositeProject() {

        return selectedProject.getProjectDeposite();
    }

    public double getDrinksAllGuests(){

        allDrinksToProject = new DrinksExpensesDAOImpl().findAllDrinksExpensesByOneProject(selectedProjectID);

        double drinksAmount = 0;

        for (DrinksExpense drinks : allDrinksToProject) {

            drinksAmount += drinks.get_spend();
        }

        return drinksAmount;
    }

    public double getFoodAllGuests(){

        allFoodToProject = new FoodExpensesDAOImpl().findAllFoodExpensesByOneProject(selectedProjectID);

        double foodAmountPrice = 0;

        for (FoodExpense food : allFoodToProject) {

            foodAmountPrice += food.get_spend();
        }

        return foodAmountPrice;
    }

    public double getAllPrepaid(){

        allPrepaidToProject = new PrepaidDAOImpl().findAllPrepaidByOneProject(selectedProjectID);

        double prepaidAmountPrice = 0;

        for (Prepaid prepaid : allPrepaidToProject) {

            prepaidAmountPrice += prepaid.getPrepaid();
        }

        return prepaidAmountPrice;
    }

    public double getTotalCostsAll(){

        return (this.getFoodAllGuests() + this.getRentProject() + this.getDrinksAllGuests());
    }

    public double getOutstandingPayments(){

        return (this.getTotalCostsAll() - this.getAllPrepaid());
    }
}
