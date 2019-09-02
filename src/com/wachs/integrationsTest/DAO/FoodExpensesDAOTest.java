package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.FoodExpense;
import com.wachs.main.dataAccess.DAO.FoodExpensesDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class FoodExpensesDAOTest {

    @Test
    public void fetchFoodExpensesByOneGuest_ShouldReturnCompleteList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchFoodExpensesOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(countAllFoodExpensesOneProjectOneGuest, foodExpensesToFind.size());
    }

    @Test
    public void fetchFoodExpensesByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = foodExpensesDAO.fetchFoodExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, foodExpensesToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchFoodExpensesByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = foodExpensesDAO.fetchFoodExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, foodExpensesToFind.get(0).getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchFoodExpensesByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new FoodExpensesDAOImpl(con, false).fetchFoodExpensesOneGuest(9999, 9999);

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectCountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(countAllDrinksExpensesOneProjectAllGuests, foodExpensesToFind.size());
    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectSpendAmountOfFirstInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupExpenses, foodExpensesToFind.get(0).get_spend(), 0.001);

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, foodExpensesToFind.get(0).getIdProject());

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, foodExpensesToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupTime, foodExpensesToFind.get(0).getWhen());

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectReasonOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesDAOImpl(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNameReason, foodExpensesToFind.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllFoodExpensesByOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        foodDAO.fetchAllFoodByOneProject(99999);

    }

    @Test
    public void updateFoodExpensesOneGuest_ShouldReturnUpdatedReason() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newReason = "Newreason";
        IDBConnection con = new TestDBConnection();

        //Act
        foodExpensesDAO.updateFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, newReason, setupTime, setupExpenses, setupNameReason, setupTime);
        ArrayList<FoodExpense> foodExpensesAfterChanges = new FoodExpensesDAOImpl(con, false).fetchFoodExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newReason, foodExpensesAfterChanges.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteFoodExpensesOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedDrinksExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        foodExpensesDAO.deleteFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.deleteFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Act
        new FoodExpensesDAOImpl().fetchFoodExpensesOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertFoodExpensesOneGuest_ShouldReturnInsertedNewFoodExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        guestDAO.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        guestDAO.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = guestDAO.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPK_id();

        //Act
        foodExpensesDAO.insertFoodExpensesOneGuest(newGuestID, projectOneID, 200, "", "");
        ArrayList<FoodExpense> newFoodExpenses = foodExpensesDAO.fetchFoodExpensesOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newFoodExpenses.get(2).get_spend(), 0.01);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertFoodExpensesOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        foodExpensesDAO.insertFoodExpensesOneGuest(newGuestIDWhichNotExist, projectOneID, 200, "", "");

        //Assert
    }
}
