

package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.*;
import com.wachs.main.DataAccess.services.*;

import java.util.ArrayList;

public class GuestModel {

    private IGuestService IGuestService;
    private IProjectService IProjectService;
    private IStayService IStayService;
    private IFoodService IFoodService;
    private IDrinksService IDrinksService;
    private IDrinksExpensesService IDrinksExpensesService;
    private IFoodExpensesService foodExpensesDAO;
    private IOtherExpensesService IOtherExpensesService;
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

        IProjectService = new ProjectService();
        searchedProject = IProjectService.fetchOneProject(projectName);
        idProject = searchedProject.getPrimaryKey();

        IGuestService = new GuestService();
        searchedGuest = IGuestService.fetchOneGuestOneProject(guestName, idProject);
        idGuest = searchedGuest.getPrimaryKey();

        IStayService = new StayService();
        IDrinksService = new DrinksService();
        IDrinksExpensesService = new DrinksExpensesService();
        foodExpensesDAO = new FoodExpensesService();
        IFoodService = new FoodService();
        IOtherExpensesService = new OtherExpensesService();

        //get numbers of Guests
        countGuestSelectedProject = IGuestService.fetchAllGuestsOneProject(idProject).size();

        staySearchedGuest = new StayModel(idGuest, idProject);
        drinksSearchedGuest = new DrinksModel(idGuest, idProject);
        foodSearchedGuest = new FoodModel(idGuest, idProject);
        prepaidSearchedGuest = new PrepaidModel(idGuest, idProject);

        staySelectedProject = IStayService.fetchAllStayOneProject(idProject);
        drinksSelectedProject = IDrinksService.fetchAllDrinksOneProject(idProject);
        drinksExpensesSelectedProject = IDrinksExpensesService.fetchAllDrinksExpensesOneProject(idProject);
        foodExpensesSelectedProject = foodExpensesDAO.fetchAllFoodExpensesOneProject(idProject);
        otherExpensesSearchedGuest = IOtherExpensesService.fetchOtherExpensesOneGuest(idGuest, idProject);
        allOtherExpensesSelectedProject = IOtherExpensesService.fetchAllOtherExpensesOneProject(idProject);

        drinksExpensesSelectedProjectOneGuest = IDrinksExpensesService.fetchDrinksExpensesOneGuest(idGuest, idProject);
        foodExpensesSelectedProjectOneGuest = foodExpensesDAO.fetchFoodExpensesOneGuest(idGuest, idProject);
        foodSelectedProject = IFoodService.fetchAllFoodByOneProject(idProject);
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

        return (searchedProject.getPrice());
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

            allDrinksExpenses = allDrinksExpenses + drinksExpense.getSpend();

        }

        return allDrinksExpenses;
    }

    private double getAllFoodExpensesSelectedProjectEUR() {

        double allFoodExpenses = 0;

        for (FoodExpense foodExpense : foodExpensesSelectedProject) {

            allFoodExpenses = allFoodExpenses + foodExpense.getSpend();
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

            allFoodExpenses = allFoodExpenses + foodExpense.getSpend();
        }

        return allFoodExpenses;
    }

    public double getAllDrinksExpensesSelectedProjectSelectedGuestEUR() {

        double allDrinksExpenses = 0;

        for (DrinksExpense drinksExpense : drinksExpensesSelectedProjectOneGuest) {

            allDrinksExpenses = allDrinksExpenses + drinksExpense.getSpend();
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

        int projectId = IProjectService.fetchOneProject(projectName).getPrimaryKey();
        GuestService newDAO = new GuestService();

        newDAO.insertGuestOneProject(projectId, guestName);
    }

}