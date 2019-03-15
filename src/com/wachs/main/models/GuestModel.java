

package com.wachs.main.models;

import com.wachs.main.businessObjects.*;
import com.wachs.main.dataAccess.DAO.*;

import java.util.ArrayList;

public class GuestModel {

    private GuestDAO guestDAO;
    private ProjectDAO projectDAO;
    private StayDAO stayDAO;
    private FoodDAO foodDAO;
    private DrinksDAO drinksDAO;
    private DrinksExpensesDAO drinksExpensesDAO;
    private FoodExpensesDAO foodExpensesDAO;
    private Guest searchedGuest;
    private StayModel staySearchedGuest;
    private DrinksModel drinksSearchedGuest;
    private FoodModel foodSearchedGuest;
    private PrepaidModel prepaidSearchedGuest;
    private Project searchedProject;
    private int idProject;
    private int idGuest;
    private int countGuestSelectedProject;
    private ArrayList<Stay> staySelectedProject;
    private ArrayList<Drinks> drinksSelectedProject;
    private ArrayList<DrinksExpense> drinksExpensesSelectedProject;
    private ArrayList<DrinksExpense> drinksExpensesSelectedProjectOneGuest;
    private ArrayList<FoodExpense> foodExpensesSelectedProjectOneGuest;
    private ArrayList<FoodExpense> foodExpensesSelectedProject;
    private ArrayList<Food> foodSelectedProject;

    public GuestModel(String projectName, String guestName) {

        createModel(projectName, guestName);
    }

    private void createModel(String projectName, String guestName) {

        projectDAO = new ProjectDAOImpl();
        searchedProject = projectDAO.findOneProject(projectName);
        idProject = searchedProject.getPK_id();

        guestDAO = new GuestDAOImpl();
        searchedGuest = guestDAO.findOneGuestByOneProject(guestName, idProject);
        idGuest = searchedGuest.getPK_id();

        stayDAO = new StayDAOImpl();
        drinksDAO = new DrinksDAOImpl();
        drinksExpensesDAO = new DrinksExpensesDAOImpl();
        foodExpensesDAO = new FoodExpensesDAOImpl();
        foodDAO = new FoodDAOImpl();

        //get numbers of Guests
        countGuestSelectedProject = guestDAO.findAllGuestsByOneProject(idProject).size();

        staySearchedGuest = new StayModel(idGuest, idProject);
        drinksSearchedGuest = new DrinksModel(idGuest, idProject);
        foodSearchedGuest = new FoodModel(idGuest, idProject);
        prepaidSearchedGuest = new PrepaidModel(idGuest, idProject);

        staySelectedProject = stayDAO.findAllStayByOneProject(idProject);
        drinksSelectedProject = drinksDAO.findAllDrinksByOneProject(idProject);
        drinksExpensesSelectedProject = drinksExpensesDAO.findAllDrinksExpensesByOneProject(idProject);
        foodExpensesSelectedProject = foodExpensesDAO.findAllFoodExpensesByOneProject(idProject);

        drinksExpensesSelectedProjectOneGuest = drinksExpensesDAO.findDrinksExpensesByOneGuest(idGuest, idProject);
        foodExpensesSelectedProjectOneGuest = foodExpensesDAO.findFoodExpensesByOneGuest(idGuest, idProject);
        foodSelectedProject = foodDAO.findAllFoodByOneProject(idProject);
    }

    public int getSleepOver() {

        return staySearchedGuest.getNights();
    }

    public double getSleepOverEUR() {

        if (this.getAllSleepOverOneProject() == 0) {

            return 0;
        }
        return (this.getRent() * (this.getSleepOver() / (this.getAllSleepOverOneProject())));
    }

    public int getDrinksCount() {

        return drinksSearchedGuest.getDrinks();
    }

    public double getDrinksEUR() {

        if (this.getAllDrinksOneProject() == 0) {

            return 0;
        }
        return (this.getAllDrinksExpensesOneProject() * (this.getDrinksCount() / this.getAllDrinksOneProject()));
    }

    public int getFoodCount() {

        return foodSearchedGuest.getFood();
    }

    public double getFoodEUR() {

        if (this.getAllFoodOneProject() == 0) {

            return 0;
        }
        return ((this. getAllFoodExpensesOneProject() * this.getFoodCount() / this.getAllFoodOneProject()));
    }

    public double getTotalCost() {

        return (this.getRent() + this.getFoodEUR() + this.getDrinksEUR());
    }

    public double getAlreadyPaid() {

        return (prepaidSearchedGuest.getPrepaid() + this.getAllFoodExpensesOneProjectOneGuest() + this.getAllDrinksExpensesOneProjectOneGuest());
    }

    public double getStillToPay() {

        return (this.getTotalCost() - this.getAlreadyPaid());
    }

    public double getRent() {

        return (searchedProject.getProjectPrice() / countGuestSelectedProject);

    }

    private int getAllSleepOverOneProject() {

        int allNightsCountSelectedProject = 0;

        for (Stay stay : staySelectedProject) {

            allNightsCountSelectedProject = allNightsCountSelectedProject + stay.getNights();
        }

        return allNightsCountSelectedProject;

    }

    private int getAllDrinksOneProject() {

        int allDrinksCountSelectedProject = 0;

        for (Drinks drinks : drinksSelectedProject) {

            allDrinksCountSelectedProject = allDrinksCountSelectedProject + drinks.getNights();
        }

        return allDrinksCountSelectedProject;
    }

    private double getAllDrinksExpensesOneProject() {

        double allDrinksExpenses = 0;

        for (DrinksExpense drinksExpense : drinksExpensesSelectedProject){

            allDrinksExpenses = allDrinksExpenses + drinksExpense.get_spend();

        }

        return allDrinksExpenses;
    }

    private double getAllFoodExpensesOneProject(){

        double allFoodExpenses = 0;

        for (FoodExpense foodExpense : foodExpensesSelectedProject) {

            allFoodExpenses = allFoodExpenses + foodExpense.get_spend();
        }

        return allFoodExpenses;
    }

    private double getAllFoodOneProject() {

        int allFoodCountSelectedProject = 0;

        for (Food food : foodSelectedProject) {

            allFoodCountSelectedProject = allFoodCountSelectedProject + food.getNights();
        }

        return allFoodCountSelectedProject;
    }

    private double getAllFoodExpensesOneProjectOneGuest(){

        double allFoodExpenses = 0;

        for (FoodExpense foodExpense : foodExpensesSelectedProjectOneGuest) {

            allFoodExpenses = allFoodExpenses + foodExpense.get_spend();
        }

        return allFoodExpenses;
    }

    private double getAllDrinksExpensesOneProjectOneGuest(){

        double allDrinksExpenses = 0;

        for (DrinksExpense drinksExpense : drinksExpensesSelectedProjectOneGuest) {

            allDrinksExpenses = allDrinksExpenses + drinksExpense.get_spend();
        }

        return allDrinksExpenses;

    }
}