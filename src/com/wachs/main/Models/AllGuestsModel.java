package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.*;
import com.wachs.main.DataAccess.services.*;

import java.util.ArrayList;

public class AllGuestsModel {

    private Project selectedProject;
    private int selectedProjectID;
    private ArrayList<DrinksExpense> allDrinksToProject;
    private ArrayList<FoodExpense> allFoodToProject;
    private ArrayList<Prepaid> allPrepaidToProject;
    private ArrayList<OtherExpense> allOtherExpensesToProject;

    public AllGuestsModel(String nameProject) {

        createModel(nameProject);

    }

    private void createModel(String nameProject){

        selectedProject = new ProjectService().fetchOneProject(nameProject);
        selectedProjectID = selectedProject.getPrimaryKey();

        allDrinksToProject = new DrinksExpensesService().fetchAllDrinksExpensesOneProject(selectedProjectID);
        allFoodToProject = new FoodExpensesService().fetchAllFoodExpensesOneProject(selectedProjectID);
        allPrepaidToProject = new PrepaidService().fetchAllPrepaidOneProject(selectedProjectID);
        allOtherExpensesToProject = new OtherExpensesService().fetchAllOtherExpensesOneProject(selectedProjectID);

    }

    public double getAllOtherExpenses() {

        double sum = 0;

        for (OtherExpense e : allOtherExpensesToProject) {

            sum += e.getSpend();
        }

        return sum;
    }
    public double getRentProject() {

        return selectedProject.getPrice();
    }

    public double getDepositeProject() {

        return selectedProject.getDeposite();
    }

    public double getDrinksAllGuests(){

        double drinksAmount = 0;

        for (DrinksExpense drinks : allDrinksToProject) {

            drinksAmount += drinks.getSpend();
        }

        return drinksAmount;
    }

    public double getFoodAllGuests(){

        double foodAmountPrice = 0;

        for (FoodExpense food : allFoodToProject) {

            foodAmountPrice += food.getSpend();
        }

        return foodAmountPrice;
    }

    public double getAllPrepaid(){

        double prepaidAmountPrice = 0;

        for (Prepaid prepaid : allPrepaidToProject) {

            prepaidAmountPrice += prepaid.getPrepaid();
        }

        return prepaidAmountPrice;
    }

    public double getTotalCostsAll(){

        return (this.getFoodAllGuests() + this.getRentProject() + this.getDrinksAllGuests() + this.getAllOtherExpenses());
    }

    public double getOutstandingPayments(){

        return (this.getTotalCostsAll() - this.getAllPrepaid());
    }
}