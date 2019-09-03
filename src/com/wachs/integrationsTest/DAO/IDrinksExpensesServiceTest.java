package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.DrinksExpense;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.DrinksExpensesService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class IDrinksExpensesServiceTest {

    @Test
    public void fetchDrinksExpensesByOneGuest_ShouldReturnCompleteList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(countAllDrinksExpensesOneProjectOneGuest, drinksExpensesToFind.size());
    }

    @Test
    public void fetchDrinksExpensesByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = IDrinksExpensesService.fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, drinksExpensesToFind.get(0).getGuestId());

    }

    @Test
    public void fetchDrinksExpensesByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = IDrinksExpensesService.fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, drinksExpensesToFind.get(0).getProjectId());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchDrinksExpensesByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new DrinksExpensesService(con, false).fetchDrinksExpensesOneGuest(9999, 9999);

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectCountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(countAllDrinksExpensesOneProjectAllGuests, drinksExpensesToFind.size());
    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectSpendAmountOfFirstInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupExpenses, drinksExpensesToFind.get(0).getSpend(), 0.001);

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, drinksExpensesToFind.get(0).getProjectId());

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, drinksExpensesToFind.get(0).getGuestId());

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupTime, drinksExpensesToFind.get(0).getWhen());

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectReasonOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNameReason, drinksExpensesToFind.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllExpensesByOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IDrinksService.fetchAllDrinksOneProject(99999);

    }

    @Test
    public void updateDrinksExpensesOneGuest_ShouldReturnUpdatedReason() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newReason = "Newreason";
        IDBConnection con = new TestDBConnection();

        //Act
        IDrinksExpensesService.updateDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, newReason, setupTime, setupExpenses, setupNameReason, setupTime);
        ArrayList<DrinksExpense> drinkExpensesAfterChanges = new DrinksExpensesService(con, false).fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newReason, drinkExpensesAfterChanges.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteDrinksExpensesOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedDrinksExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDrinksExpensesService.deleteDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IDrinksExpensesService.deleteDrinksExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Act
        new DrinksExpensesService().fetchDrinksExpensesOneGuest(guestOneID, projectOneID);
    }

    @Test
    public void insertDrinksExpensesOneGuest_ShouldReturnInsertedNewDrinksExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject(newNameProject, projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, newNameProject);
        int newGuestID = IGuestService.fetchOneGuestOneProject(newNameProject, projectOneID).getPrimaryKey();

        //Act
        IDrinksExpensesService.insertDrinksExpensesOneGuest(newGuestID, projectOneID, 200, "", "");
        ArrayList<DrinksExpense> newDrinksExpenses = IDrinksExpensesService.fetchDrinksExpensesOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newDrinksExpenses.get(0).getSpend(), 0.01);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertDrinksExpensesOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IDrinksExpensesService.insertDrinksExpensesOneGuest(newGuestIDWhichNotExist, projectOneID, 200, "", "");

        //Assert
    }
}
