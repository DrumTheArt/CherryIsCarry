

package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.businessObjects.Guest;
import com.wachs.main.businessObjects.Project;
import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAccess.DAO.*;

import java.util.ArrayList;

public class GuestModel {

    private GuestDAO guestDAO;
    private ProjectDAO projectDAO;
    private StayDAO stayDAO;
    private DrinksDAO drinksDAO;
    private DrinksExpensesDAO drinksExpensesDAO;
    private FoodExpensesDAO foodExpensesDAO;
    private Guest searchedGuest;
    private StayModel staySearchedGuest;
    private DrinksModel drinksSearchedGuest;
    private FoodModel foodSearchedGuest;
    private PrepaidModel prepaidSearchedGuest;
    private FoodExpenseModel foodExpensesSearchedGuest;
    private DrinksExpenseModel drinksExpensesSearchedGuest;
    private Project searchedProject;
    private int idProject;
    private int idGuest;
    private int countGuestSelectedProject;

    GuestModel(String projectName, String guestName) {

        createModel(projectName, guestName);
    }

    private void createModel(String projectName, String guestName) {

        projectDAO = new ProjectDAOImpl();
        searchedProject = projectDAO.fineOneProject(projectName);
        idProject = searchedProject.getPK_id();

        guestDAO = new GuestDAOImpl();
        searchedGuest = guestDAO.findOneGuestByOneProject(guestName, idProject);
        idGuest = searchedGuest.getPK_id();

        stayDAO = new StayDAOImpl();
        drinksDAO = new DrinksDAOImpl();
        drinksExpensesDAO = new DrinksExpensesDAOImpl();
        foodExpensesDAO = new FoodExpensesDAOImpl();

        //get numbers of Guests
        countGuestSelectedProject = guestDAO.findAllGuestsByOneProject(idProject).size();

        staySearchedGuest = new StayModel(idGuest, idProject);
        drinksSearchedGuest = new DrinksModel(idGuest, idProject);
        foodSearchedGuest = new FoodModel(idGuest, idProject);
        prepaidSearchedGuest = new PrepaidModel(idGuest, idProject);
        foodExpensesSearchedGuest = new FoodExpenseModel(idGuest, idProject);
        drinksExpensesSearchedGuest = new DrinksExpenseModel(idGuest, idProject);


    }

    public int getSleeopover() {

        return staySearchedGuest.getNights();
    }

    public double getSleepOverEUR() {

        return (this.getRent() * (this.getSleeopover() / (this.getAllSleepOverOneProject())));
    }

    public int getDrinksCount() {

        return drinksSearchedGuest.getDrinks();
    }

    public double getDrinksEUR() {

        return this.getAllDrinksExpensesOneProject() * (this.getDrinksCount() / this.getAllDrinksOneProject());
    }

    public int getFoodCount() {

        return foodSearchedGuest.getFood();
    }

    public double getFoodEUR() {

        return 0;
    }

    public double getTotalCost() {

        return (this.getRent() + this.getFoodEUR() + this.getDrinksEUR());
    }

    public double getAlreadyPaid() {

        return prepaidSearchedGuest.getPrepaid();
    }

    public double getStillToPay() {

        return (this.getTotalCost() - this.getAlreadyPaid());
    }

    public double getRent() {

        return (searchedProject.getProjectPrice() / countGuestSelectedProject);

    }

    private int getAllSleepOverOneProject() {

        int allNightsCountSelectedProject = 0;
        ArrayList<Stay> staySelectedProject = stayDAO.findAllStayByOneProject(idProject);

        for (Stay stay : staySelectedProject) {

            allNightsCountSelectedProject = allNightsCountSelectedProject + stay.getNights();
        }

        return allNightsCountSelectedProject;

    }

    private int getAllDrinksOneProject() {

        int allDrinksCountSelectedProject = 0;
        ArrayList<Drinks> drinksSelectedProject = drinksDAO.findAllDrinksByOneProject(idProject);

        for (Drinks drinks : drinksSelectedProject) {

            allDrinksCountSelectedProject = allDrinksCountSelectedProject + drinks.getNights();
        }

        return allDrinksCountSelectedProject;
    }

    private double getAllDrinksExpensesOneProject() {

        double allDrinksExpenses = 0;


        return allDrinksExpenses;
    }
}