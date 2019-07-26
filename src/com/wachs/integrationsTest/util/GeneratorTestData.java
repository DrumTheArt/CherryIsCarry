package com.wachs.integrationsTest.util;

import com.sun.tools.javah.Gen;
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

    public static String setupNameGuest = "Robert";
    public static String setupNameProject = "integrationstest";
    public static String setupNameReason = "Alcohol";
    public static String setupTime = "01.01.2019";
    public static double setupProjectPrice = 100.0;
    public static double setupProjectDeposite = 500.0;
    public static double setupExpenses = 300.0;
    public static double setupPrepaid = 150;
    public static int setupNights = 5;
    public static int projectID;
    public static int guestID;

    public static void createObjects(){

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

    public static void insertTestdataToDataBase(){

        GeneratorTestData.resetTestdata();
        GeneratorTestData.createObjects();

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

    private static void resetTestdata() {

        projectDAO.deleteProject(setupNameProject);

    }
}
