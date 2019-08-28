

package com.wachs.main.models;

import com.wachs.main.POJO.*;
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
    private OtherExpensesDAO otherExpensesDAO;
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
    private ArrayList<OtherExpense> otherExpensesSearchedGuest;
    private ArrayList<OtherExpense> allOtherExpensesSelectedProject;

    public GuestModel(String projectName, String guestName) {

        createModel(projectName, guestName);
    }

    private void createModel(String projectName, String guestName) {

        projectDAO = new ProjectDAOImpl();
        searchedProject = projectDAO.fetchOneProject(projectName);
        idProject = searchedProject.getPK_id();

        guestDAO = new GuestDAOImpl();
        searchedGuest = guestDAO.fetchOneGuestOneProject(guestName, idProject);
        idGuest = searchedGuest.getPK_id();

        stayDAO = new StayDAOImpl();
        drinksDAO = new DrinksDAOImpl();
        drinksExpensesDAO = new DrinksExpensesDAOImpl();
        foodExpensesDAO = new FoodExpensesDAOImpl();
        foodDAO = new FoodDAOImpl();
        otherExpensesDAO = new OtherExpensesDAOImpl();

        //get numbers of Guests
        countGuestSelectedProject = guestDAO.fetchAllGuestsOneProject(idProject).size();

        staySearchedGuest = new StayModel(idGuest, idProject);
        drinksSearchedGuest = new DrinksModel(idGuest, idProject);
        foodSearchedGuest = new FoodModel(idGuest, idProject);
        prepaidSearchedGuest = new PrepaidModel(idGuest, idProject);

        staySelectedProject = stayDAO.fetchAllStayOneProject(idProject);
        drinksSelectedProject = drinksDAO.fetchAllDrinksOneProject(idProject);
        drinksExpensesSelectedProject = drinksExpensesDAO.fetchAllDrinksExpensesOneProject(idProject);
        foodExpensesSelectedProject = foodExpensesDAO.fetchAllFoodExpensesOneProject(idProject);
        otherExpensesSearchedGuest = otherExpensesDAO.fetchOtherExpensesOneGuest(idGuest, idProject);
        allOtherExpensesSelectedProject = otherExpensesDAO.fetchAllOtherExpensesOneProject(idProject);

        drinksExpensesSelectedProjectOneGuest = drinksExpensesDAO.fetchDrinksExpensesOneGuest(idGuest, idProject);
        foodExpensesSelectedProjectOneGuest = foodExpensesDAO.fetchFoodExpensesOneGuest(idGuest, idProject);
        foodSelectedProject = foodDAO.fetchAllFoodByOneProject(idProject);
    }

    public int getSleepOverSelectedGuest() {

        return staySearchedGuest.getNights();
    }

    public double getSleepOverSelectedGuestEUR() {

        if (this.getAllSleepOverSelectedProjectEUR() == 0) {

            return 0;
        }

        return (this.getRentSelectedProjectEUR() / this.getAllSleepOverSelectedProjectEUR()) * this.getSleepOverSelectedGuest();
    }

    public int getDrinksSelectedGuestCount() {

        return drinksSearchedGuest.getDrinks();
    }

    public double getDrinksSelectedGuestEUR() {

        if (this.getAllDrinksSelectedProjectEUR() == 0) {

            return 0;
        }
        return ((this.getAllDrinksExpensesSelectedProjectEUR() / this.getAllDrinksSelectedProjectEUR()) * (this.getDrinksSelectedGuestCount()));
    }

    public int getFoodSelectedGuestCount() {

        return foodSearchedGuest.getFood();
    }

    public double getFoodSelectedGuestEUR() {

        if (this.getAllFoodSelectedProjectCount() == 0) {

            return 0;
        }
        return ((this.getAllFoodExpensesSelectedProjectEUR() / this.getAllFoodSelectedProjectCount() * this.getFoodSelectedGuestCount()));
    }

    public double getTotalCostSelectedGuestEUR() {

        return (this.getSleepOverSelectedGuestEUR() + this.getFoodSelectedGuestEUR() + this.getDrinksSelectedGuestEUR() + this.getAllOtherExpensesSelectedProjectHaveToPayBySelectedGuestEUR());
    }

    public double getAlreadyPaidSelectedGuestEUR() {

        return (prepaidSearchedGuest.getPrepaid() + this.getAllFoodExpensesSelectedProjectSelectedGuestEUR() + this.getAllDrinksExpensesSelectedProjectSelectedGuestEUR() + this.getAllOtherExpensesSelectedProjectPayedBySelectedGuestEUR());
    }

    public double getPrepaidSelectedGuestEUR() {

        return prepaidSearchedGuest.getPrepaid();
    }

    public double getStillToPaySelectedGuestEUR() {

        return (this.getTotalCostSelectedGuestEUR() - this.getAlreadyPaidSelectedGuestEUR());
    }

    public double getRentSelectedProjectEUR() {

        return (searchedProject.getProjectPrice());
    }

    private int getAllSleepOverSelectedProjectEUR() {

        int allNightsCountSelectedProject = 0;

        for (Stay stay : staySelectedProject) {

            allNightsCountSelectedProject = allNightsCountSelectedProject + stay.getNights();
        }

        return allNightsCountSelectedProject;

    }

    private int getAllDrinksSelectedProjectEUR() {

        int allDrinksCountSelectedProject = 0;

        for (Drinks drinks : drinksSelectedProject) {

            allDrinksCountSelectedProject = allDrinksCountSelectedProject + drinks.getNights();
        }

        return allDrinksCountSelectedProject;
    }

    private double getAllDrinksExpensesSelectedProjectEUR() {

        double allDrinksExpenses = 0;

        for (DrinksExpense drinksExpense : drinksExpensesSelectedProject){

            allDrinksExpenses = allDrinksExpenses + drinksExpense.get_spend();

        }

        return allDrinksExpenses;
    }

    private double getAllFoodExpensesSelectedProjectEUR() {

        double allFoodExpenses = 0;

        for (FoodExpense foodExpense : foodExpensesSelectedProject) {

            allFoodExpenses = allFoodExpenses + foodExpense.get_spend();
        }

        return allFoodExpenses;
    }

    private double getAllFoodSelectedProjectCount() {

        int allFoodCountSelectedProject = 0;

        for (Food food : foodSelectedProject) {

            allFoodCountSelectedProject = allFoodCountSelectedProject + food.getNights();
        }

        return allFoodCountSelectedProject;
    }

    public double getAllFoodExpensesSelectedProjectSelectedGuestEUR() {

        double allFoodExpenses = 0;

        for (FoodExpense foodExpense : foodExpensesSelectedProjectOneGuest) {

            allFoodExpenses = allFoodExpenses + foodExpense.get_spend();
        }

        return allFoodExpenses;
    }

    public double getAllDrinksExpensesSelectedProjectSelectedGuestEUR() {

        double allDrinksExpenses = 0;

        for (DrinksExpense drinksExpense : drinksExpensesSelectedProjectOneGuest) {

            allDrinksExpenses = allDrinksExpenses + drinksExpense.get_spend();
        }

        return allDrinksExpenses;

    }

    public double getAllOtherExpensesSelectedProjectPayedBySelectedGuestEUR() {

        double sum = 0;

        for (OtherExpense othExp : otherExpensesSearchedGuest) {

            sum += othExp.getSpend();
        }

        return sum;
    }

    public double getAllOtherExpensesSelectedProjectHaveToPayBySelectedGuestEUR() {

        double sum = 0;

        for (OtherExpense othExp : allOtherExpensesSelectedProject) {

            sum += othExp.getSpend();
        }

        double result = sum / this.getAllSleepOverSelectedProjectEUR() * this.getSleepOverSelectedGuest();

        return result;
    }

    public void setNewGuest(String projectName, String guestName) {

        int projectId = projectDAO.fetchOneProject(projectName).getPK_id();
        GuestDAOImpl newDAO = new GuestDAOImpl();

        newDAO.insertGuestOneProject(projectId, guestName);
    }

}