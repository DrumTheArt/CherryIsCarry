

package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.DAO.GuestDAO;
import com.wachs.main.dataAccess.DAO.GuestDAOImpl;
import com.wachs.main.dataAccess.DAO.ProjectDAO;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;

public class GuestModel {

    private GuestDAO guestDAO;
    private ProjectDAO projectDAO;
    private Guest searchedGuest;
    private StayModel staySearchedGuest;
    private DrinksModel drinksSearchedGuest;
    private FoodModel foodSearchedGuest;
    private PrepaidModel prepaidSearchedGuest;
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

        //get numbers of Guests
        countGuestSelectedProject = guestDAO.findAllGuestsByOneProject(idProject).size();

        staySearchedGuest = new StayModel(idGuest, idProject);
        drinksSearchedGuest = new DrinksModel(idGuest, idProject);
        foodSearchedGuest = new FoodModel(idGuest, idProject);
        prepaidSearchedGuest = new PrepaidModel(idGuest, idProject);


    }

    public int getSleeopover() {

        return staySearchedGuest.getNights();
    }

    public double getSleepOverEUR() {

        return 0;
    }

    public int getDrinksCount() {

        return drinksSearchedGuest.getDrinks();
    }

    public double getDrinksEUR() {

        return 0;
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
}