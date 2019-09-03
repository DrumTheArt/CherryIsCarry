package com.wachs.integrationsTest.util;

import com.wachs.main.POJO.Guest;
import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.*;

import java.sql.Connection;

public class GeneratorTestData {

    public static IDBConnection testDatabase;
    public static Connection connection;
    public static IProjectService IProjectService;
    public static IGuestService IGuestService;
    public static IFoodService IFoodService;
    public static IDrinksExpensesService IDrinksExpensesService;
    public static IFoodExpensesService foodExpensesDAO;
    public static IOtherExpensesService IOtherExpensesService;
    public static IPrepaidService IPrepaidService;
    public static IStayService IStayService;
    public static IDrinksService IDrinksService;

    public static String setupNameProjectOne = "Integrationstest1";
    public static int projectOneID;
    public static String setupNameGuestOne = "Robert";
    public static int countAllOtherExpensesOneProjectOneGuest;
    public static int countAllDrinksExpensesOneProjectOneGuest;
    public static int countAllFoodExpensesOneProjectOneGuest;
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

    public static String newNameProject = "Justforthistestproject";

    public static int countAllOtherExpensesOneProjectAllGuests;
    public static int countAllFoodExpensesOneProjectAllGuests;
    public static int countAllDrinksExpensesOneProjectAllGuests;


    public static void createObjects(){

        testDatabase = new TestDBConnection();
        IProjectService = new ProjectService(testDatabase, false);
        IGuestService = new GuestService(testDatabase, false);
        IFoodService = new FoodService(testDatabase, false);
        IDrinksExpensesService = new DrinksExpensesService(testDatabase, false);
        foodExpensesDAO = new FoodExpensesService(testDatabase, false);
        IOtherExpensesService = new OtherExpensesService(testDatabase, false);
        IPrepaidService = new PrepaidService(testDatabase, false);
        IStayService = new StayService(testDatabase, false);
        IDrinksService = new DrinksService(testDatabase, false);

    }

    public static void insertTestdataToDataBase(){

        GeneratorTestData.resetTestdata();
        GeneratorTestData.createObjects();

        //Insert a new project and get the primaryKey from database
        IProjectService.insertProject(setupNameProjectOne, setupProjectPrice, setupProjectDeposite);
        Project firstProject = IProjectService.fetchOneProject(setupNameProjectOne);
        projectOneID = firstProject.getPrimaryKey();

        //Insert a second project and get the primaryKey from database
        IProjectService.insertProject(setupNameProjectTwo, setupProjectPrice, setupProjectDeposite);
        Project secondProject = IProjectService.fetchOneProject(setupNameProjectTwo);
        projectTwoID = secondProject.getPrimaryKey();

        //Insert a new guest get the primaryKey from database
        IGuestService.insertGuestOneProject(projectOneID, setupNameGuestOne);
        Guest firstGuest = IGuestService.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);
        guestOneID = firstGuest.getPrimaryKey();

        //Insert a second guest get the primaryKey from database
        IGuestService.insertGuestOneProject(projectOneID, setupNameGuestTwo);
        Guest SecondGuest = IGuestService.fetchOneGuestOneProject(setupNameGuestTwo, projectOneID);
        guestTwoID = SecondGuest.getPrimaryKey();

        //Insert a third guest get the primaryKey from database
        IGuestService.insertGuestOneProject(projectOneID, setupNameGuestThree);
        Guest thirdGuest = IGuestService.fetchOneGuestOneProject(setupNameGuestThree, projectOneID);
        guestThreeID = thirdGuest.getPrimaryKey();

        //Insert duration of stay for each three guest to the same project
        IStayService.insertStayOneGuest(guestOneID, projectOneID, setupNights);
        IStayService.insertStayOneGuest(guestTwoID, projectOneID, setupNights);
        IStayService.insertStayOneGuest(guestThreeID, projectOneID, setupNights);

        //Insert drinks (in days) of the new guest
        IDrinksService.insertDrinksOneGuest(guestOneID, projectOneID, setupNights);
        IDrinksService.insertDrinksOneGuest(guestTwoID, projectOneID, setupNights);
        IDrinksService.insertDrinksOneGuest(guestThreeID, projectOneID, setupNights);

        //Insert food (in days) of the new guest
        IFoodService.insertFoodOneGuest(guestOneID, projectOneID, setupNights);
        IFoodService.insertFoodOneGuest(guestTwoID, projectOneID, setupNights);
        IFoodService.insertFoodOneGuest(guestThreeID, projectOneID, setupNights);

        //Insert drinks expenses of the new guest
        IDrinksExpensesService.insertDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IDrinksExpensesService.insertDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IDrinksExpensesService.insertDrinksExpensesOneGuest(guestTwoID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IDrinksExpensesService.insertDrinksExpensesOneGuest(guestThreeID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Insert food expenses of the new guest
        foodExpensesDAO.insertFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.insertFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.insertFoodExpensesOneGuest(guestTwoID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.insertFoodExpensesOneGuest(guestThreeID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Insert other expenses of the new guest
        IOtherExpensesService.insertOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IOtherExpensesService.insertOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IOtherExpensesService.insertOtherExpensesOneGuest(guestTwoID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IOtherExpensesService.insertOtherExpensesOneGuest(guestThreeID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Insert prepaid of the new guest
        IPrepaidService.insertPrepaidOneGuest(guestOneID, projectOneID, setupPrepaid);
        IPrepaidService.insertPrepaidOneGuest(guestTwoID, projectOneID, setupPrepaid);
        IPrepaidService.insertPrepaidOneGuest(guestThreeID, projectOneID, setupPrepaid);

        //Get number of guest in ProjectOne and number of projects in general
        countAllProjects = IProjectService.fetchAllProjects().size();
        CountAllGuestsProjectOne =  IGuestService.fetchAllGuestsOneProject(projectOneID).size();
        countAllOtherExpensesOneProjectOneGuest = IOtherExpensesService.fetchOtherExpensesOneGuest(guestOneID, projectOneID).size();
        countAllFoodExpensesOneProjectOneGuest = foodExpensesDAO.fetchFoodExpensesOneGuest(guestOneID, projectOneID).size();
        countAllDrinksExpensesOneProjectOneGuest = IDrinksExpensesService.fetchDrinksExpensesOneGuest(guestOneID, projectOneID).size();

        countAllOtherExpensesOneProjectAllGuests = IOtherExpensesService.fetchAllOtherExpensesOneProject(projectOneID).size();
        countAllFoodExpensesOneProjectAllGuests = foodExpensesDAO.fetchAllFoodExpensesOneProject(projectOneID).size();
        countAllDrinksExpensesOneProjectAllGuests = IDrinksExpensesService.fetchAllDrinksExpensesOneProject(projectOneID).size();

    }

    private static void resetTestdata() {

        IProjectService.deleteProject(setupNameProjectOne);
        IProjectService.deleteProject(setupNameProjectTwo);
        IProjectService = null;

    }
}