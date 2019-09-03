package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.OtherExpense;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.OtherExpensesService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class IOtherExpensesServiceTest {

    @Test
    public void fetchOtherExpensesByOneGuest_ShouldReturnCompleteList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(countAllOtherExpensesOneProjectOneGuest, otherExpensesToFind.size());
    }

    @Test
    public void fetchOtherExpensesByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = IOtherExpensesService.fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, otherExpensesToFind.get(0).getGuestId());

    }

    @Test
    public void fetchOtherExpensesByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = IOtherExpensesService.fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, otherExpensesToFind.get(0).getProjectId());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchOtherExpensesByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new OtherExpensesService(con, false).fetchOtherExpensesOneGuest(9999, 9999);

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectCountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(countAllDrinksExpensesOneProjectAllGuests, otherExpensesToFind.size());
    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectSpendAmountOfFirstInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupExpenses, otherExpensesToFind.get(0).getSpend(), 0.001);

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, otherExpensesToFind.get(0).getProjectId());

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, otherExpensesToFind.get(0).getGuestId());

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupTime, otherExpensesToFind.get(0).getWhen());

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectReasonOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNameReason, otherExpensesToFind.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllOtherExpensesByOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new OtherExpensesService(con, false).fetchAllOtherExpensesOneProject(99999);

    }

    @Test
    public void updateOtherExpensesOneGuest_ShouldReturnUpdatedReason() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newReason = "Newreason";
        IDBConnection con = new TestDBConnection();

        //Act
        IOtherExpensesService.updateOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, newReason, setupTime, setupExpenses, setupNameReason, setupTime);
        ArrayList<OtherExpense> otherExpensesAfterChanges = new OtherExpensesService(con, false).fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newReason, otherExpensesAfterChanges.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteOtherExpensesOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedOtherExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IOtherExpensesService.deleteOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        IOtherExpensesService.deleteOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Act
        new OtherExpensesService().fetchOtherExpensesOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertOtherExpensesOneGuest_ShouldReturnInsertedNewOtherExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject(newNameProject, projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, newNameProject);
        int newGuestID = IGuestService.fetchOneGuestOneProject(newNameProject, projectOneID).getPrimaryKey();

        //Act
        IOtherExpensesService.insertOtherExpensesOneGuest(newGuestID, projectOneID, 200, "", "");
        ArrayList<OtherExpense> newOtherExpenses = IOtherExpensesService.fetchOtherExpensesOneGuest(newGuestID, projectOneID);
        newOtherExpenses.stream().filter(x -> x.getSpend() == 200);

        //Assert
        Assert.assertEquals(200, newOtherExpenses.get(0).getSpend(), 0.01);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertOtherExpensesOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IOtherExpensesService.insertOtherExpensesOneGuest(newGuestIDWhichNotExist, projectOneID, 200, "", "");

        //Assert
    }
}
