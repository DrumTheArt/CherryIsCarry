package com.wachs.integrationsTest.DAO;

import com.wachs.main.POJO.Drinks;
import com.wachs.main.POJO.Guest;
import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.DAO.*;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DrinksDAOTest {

    IDBConnection testDatabase;
    Connection connection;
    ProjectDAO projectDAO;
    GuestDAO guestDAO;
    FoodDAO foodDAO;
    DrinksExpensesDAO drinksExpensesDAO;
    FoodExpensesDAO foodExpensesDAO;
    OtherExpensesDAO otherExpensesDAO;
    PrepaidDAO prepaidDAO;
    StayDAO stayDAO;
    DrinksDAO drinksDAO;

    String setupNameGuest = "Robert";
    String setupNameProject = "integrationstest";
    String setupNameReason = "Alcohol";
    String setupTime = "01.01.2019";
    double setupProjectPrice = 100.0;
    double setupProjectDeposite = 500.0;
    double setupExpenses = 300.0;
    double setupPrepaid = 150;
    int setupNights = 5;
    int projectID;
    int guestID;


    private void resetTestdata() {

        projectDAO.deleteProject(setupNameProject);

    }

    private void insertTestdataToDataBase(){

        //Delete inserted project from this method
        resetTestdata();

        //Insert a new project and get the primaryKey from database
        projectDAO.insertProject(setupNameProject, setupProjectPrice, setupProjectDeposite);
        Project project = projectDAO.fetchOneProject(setupNameProject);
        projectID = project.getPK_id();

        //Insert a new guest get the primaryKey from database
        guestDAO.insertGuestOneProject(projectID, setupNameGuest);
        Guest guest = guestDAO.fetchOneGuestOneProject(setupNameGuest, projectID);
        guestID = guest.getPK_id();

        //Insert duration of stay of the new guest
        stayDAO.insertStayOneGuest(guestID, projectID, setupNights);

        //Insert drinks (in days) of the new guest
        drinksDAO.insertDrinksOneGuest(guestID, projectID, setupNights);

        //Insert food (in days) of the new guest
        foodDAO.insertFoodOneGuest(guestID, projectID, setupNights);

        //Insert drinks expenses of the new guest
        drinksExpensesDAO.insertDrinksExpensesOneGuest(guestID, projectID, setupExpenses, setupNameReason, setupTime);

        //Insert food expenses of the new guest
        foodExpensesDAO.insertFoodExpensesOneGuest(guestID, projectID, setupExpenses, setupNameReason, setupTime);

        //Insert prepaid of the new guest
        prepaidDAO.insertPrepaidOneGuest(guestID, projectID, setupPrepaid);

    }

    private void createObjects(){

        testDatabase = new TestDBConnection();
        projectDAO = new ProjectDAOImpl(testDatabase);
        guestDAO = new GuestDAOImpl(testDatabase);
        foodDAO = new FoodDAOImpl(testDatabase);
        drinksExpensesDAO = new DrinksExpensesDAOImpl(testDatabase);
        foodExpensesDAO = new FoodExpensesDAOImpl(testDatabase);
        otherExpensesDAO = new OtherExpensesDAOImpl(testDatabase);
        prepaidDAO = new PrepaidDAOImpl(testDatabase);
        stayDAO = new StayDAOImpl(testDatabase);
        drinksDAO = new DrinksDAOImpl(testDatabase);

    }

    @Test
    public void findDrinksOneGuest_ShouldReturnCorrectDrinkObject() {

        createObjects();
        insertTestdataToDataBase();

        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestID,projectID);
        Assert.assertEquals(drinkToFind.getNights(), setupNights);

    }

    @Test
    public void findDrinksOneGuest_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void findDrinksOneGuest_ShouldThrowSQLException() {


    }

    @Test
    public void findAllDrinksOneProject_ShouldReturnCorrectDrinkObject() {


    }

    @Test
    public void findAllDrinksOneProject_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void findAllDrinksOneProject_ShouldThrowSQLException() {


    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnCorrectDrinkObject() {


    }

    @Test
    public void updateDrinksOneGuest_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void updateDrinksOneGuest_ShouldThrowSQLException() {


    }

    @Test
    public void deleteDrinksOneGuest_ShouldNotReturnAlreadyDeletedDrinkObject() {


    }

    @Test
    public void deleteDrinksOneGuest_ShouldThrowSQLException() {


    }

    @Test
    public void insertDrinksOneGuest_ShouldReturnInsertDrinkObject() {


    }

    @Test
    public void insertDrinksOneGuest_IfAlreadyExistInDB_ShouldReturnException() {


    }

    @Test
    public void insertDrinksOneGuest_ShouldThrowSQLException() {
    }

}