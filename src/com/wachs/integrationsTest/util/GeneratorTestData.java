package com.wachs.integrationsTest.util;

import com.wachs.main.POJO.Guest;
import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.DAO.*;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;

import java.sql.Connection;

public class GeneratorTestData {

    public static IDBConnection testDatabase;
    public static Connection connection;
    public static ProjectDAO projectDAO;
    public static GuestDAO guestDAO;
    public static FoodDAO foodDAO;
    public static DrinksExpensesDAO drinksExpensesDAO;
    public static FoodExpensesDAO foodExpensesDAO;
    public static OtherExpensesDAO otherExpensesDAO;
    public static PrepaidDAO prepaidDAO;
    public static StayDAO stayDAO;
    public static DrinksDAO drinksDAO;

    public static String setupNameProjectOne = "Integrationstest1";
    public static int projectOneID;
    public static String setupNameGuestOne = "Robert";
    public static int CountAllOtherExpensesOneProjectOneGuest;
    public static int CountAllDrinksExpensesOneProjectOneGuest;
    public static int guestOneID;
    public static String setupNameGuestTwo = "Robert2";
    public static int guestTwoID;
    public static String setupNameGuestThree = "Robert3";
    public static int guestThreeID;

    public static int countAllProjects;
    public static int CountAllGuestsProjectOne;

    public static String setupNameProjectTwo = "Integrationstest2";
    public static int projectTwoID;

    public static String setupNameReason = "Alcohol";
    public static String setupTime = "01.01.2019";
    public static double setupProjectPrice = 100.0;
    public static double setupProjectDeposite = 500.0;
    public static double setupExpenses = 300.0;
    public static double setupPrepaid = 150;
    public static int setupNights = 5;

    public static void createObjects(){

        testDatabase = new TestDBConnection();
        projectDAO = new ProjectDAOImpl(testDatabase, false);
        guestDAO = new GuestDAOImpl(testDatabase, false);
        foodDAO = new FoodDAOImpl(testDatabase, false);
        drinksExpensesDAO = new DrinksExpensesDAOImpl(testDatabase, false);
        foodExpensesDAO = new FoodExpensesDAOImpl(testDatabase, false);
        otherExpensesDAO = new OtherExpensesDAOImpl(testDatabase, false);
        prepaidDAO = new PrepaidDAOImpl(testDatabase, false);
        stayDAO = new StayDAOImpl(testDatabase, false);
        drinksDAO = new DrinksDAOImpl(testDatabase, false);

    }

    public static void insertTestdataToDataBase(){

        GeneratorTestData.resetTestdata();
        GeneratorTestData.createObjects();

        //Insert a new project and get the primaryKey from database
        projectDAO.insertProject(setupNameProjectOne, setupProjectPrice, setupProjectDeposite);
        Project firstProject = projectDAO.fetchOneProject(setupNameProjectOne);
        projectOneID = firstProject.getPK_id();

        //Insert a second project and get the primaryKey from database
        projectDAO.insertProject(setupNameProjectTwo, setupProjectPrice, setupProjectDeposite);
        Project secondProject = projectDAO.fetchOneProject(setupNameProjectTwo);
        projectTwoID = secondProject.getPK_id();

        //Insert a new guest get the primaryKey from database
        guestDAO.insertGuestOneProject(projectOneID, setupNameGuestOne);
        Guest firstGuest = guestDAO.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);
        guestOneID = firstGuest.getPK_id();

        //Insert a second guest get the primaryKey from database
        guestDAO.insertGuestOneProject(projectOneID, setupNameGuestTwo);
        Guest SecondGuest = guestDAO.fetchOneGuestOneProject(setupNameGuestTwo, projectOneID);
        guestTwoID = SecondGuest.getPK_id();

        //Insert a third guest get the primaryKey from database
        guestDAO.insertGuestOneProject(projectOneID, setupNameGuestThree);
        Guest thirdGuest = guestDAO.fetchOneGuestOneProject(setupNameGuestThree, projectOneID);
        guestThreeID = thirdGuest.getPK_id();

        //Insert duration of stay for each three guest to the same project
        stayDAO.insertStayOneGuest(guestOneID, projectOneID, setupNights);
        stayDAO.insertStayOneGuest(guestTwoID, projectOneID, setupNights);
        stayDAO.insertStayOneGuest(guestThreeID, projectOneID, setupNights);

        //Insert drinks (in days) of the new guest
        drinksDAO.insertDrinksOneGuest(guestOneID, projectOneID, setupNights);
        drinksDAO.insertDrinksOneGuest(guestTwoID, projectOneID, setupNights);
        drinksDAO.insertDrinksOneGuest(guestThreeID, projectOneID, setupNights);

        //Insert food (in days) of the new guest
        foodDAO.insertFoodOneGuest(guestOneID, projectOneID, setupNights);
        foodDAO.insertFoodOneGuest(guestTwoID, projectOneID, setupNights);
        foodDAO.insertFoodOneGuest(guestThreeID, projectOneID, setupNights);

        //Insert drinks expenses of the new guest
        drinksExpensesDAO.insertDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        drinksExpensesDAO.insertDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        drinksExpensesDAO.insertDrinksExpensesOneGuest(guestTwoID, projectOneID, setupExpenses, setupNameReason, setupTime);
        drinksExpensesDAO.insertDrinksExpensesOneGuest(guestThreeID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Insert food expenses of the new guest
        foodExpensesDAO.insertFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.insertFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.insertFoodExpensesOneGuest(guestTwoID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.insertFoodExpensesOneGuest(guestThreeID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Insert other expenses of the new guest
        otherExpensesDAO.insertOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        otherExpensesDAO.insertOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        otherExpensesDAO.insertOtherExpensesOneGuest(guestTwoID, projectOneID, setupExpenses, setupNameReason, setupTime);
        otherExpensesDAO.insertOtherExpensesOneGuest(guestThreeID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Insert prepaid of the new guest
        prepaidDAO.insertPrepaidOneGuest(guestOneID, projectOneID, setupPrepaid);
        prepaidDAO.insertPrepaidOneGuest(guestTwoID, projectOneID, setupPrepaid);
        prepaidDAO.insertPrepaidOneGuest(guestThreeID, projectOneID, setupPrepaid);

        //Get number of guest in ProjectOne and number of projects in general
        countAllProjects = projectDAO.fetchAllProjects().size();
        CountAllGuestsProjectOne =  guestDAO.fetchAllGuestsOneProject(projectOneID).size();
        CountAllOtherExpensesOneProjectOneGuest = otherExpensesDAO.fetchOtherExpensesOneGuest(guestOneID, projectOneID).size();
        CountAllDrinksExpensesOneProjectOneGuest = foodExpensesDAO.fetchFoodExpensesOneGuest(guestOneID, projectOneID).size();

    }

    private static void resetTestdata() {

        projectDAO.deleteProject(setupNameProjectOne);
        projectDAO.deleteProject(setupNameProjectTwo);

    }
}