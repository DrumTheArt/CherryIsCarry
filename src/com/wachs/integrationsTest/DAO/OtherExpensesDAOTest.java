package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.OtherExpense;
import com.wachs.main.dataAccess.DAO.OtherExpensesDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class OtherExpensesDAOTest {

    @Test
    public void fetchOtherExpensesByOneGuest_ShouldReturnCompleteList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(countAllOtherExpensesOneProjectOneGuest, otherExpensesToFind.size());
    }

    @Test
    public void fetchOtherExpensesByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = otherExpensesDAO.fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, otherExpensesToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchOtherExpensesByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = otherExpensesDAO.fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, otherExpensesToFind.get(0).getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchOtherExpensesByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new OtherExpensesDAOImpl(con, false).fetchOtherExpensesOneGuest(9999, 9999);

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectCountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(projectOneID);

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
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(projectOneID);

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
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, otherExpensesToFind.get(0).getIdProject());

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, otherExpensesToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchAllOtherExpensesByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(projectOneID);

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
        ArrayList<OtherExpense> otherExpensesToFind = new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(projectOneID);

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
        new OtherExpensesDAOImpl(con, false).fetchAllOtherExpensesOneProject(99999);

    }

    @Test
    public void updateOtherExpensesOneGuest_ShouldReturnUpdatedReason() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newReason = "Newreason";
        IDBConnection con = new TestDBConnection();

        //Act
        otherExpensesDAO.updateOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, newReason, setupTime, setupExpenses, setupNameReason, setupTime);
        ArrayList<OtherExpense> otherExpensesAfterChanges = new OtherExpensesDAOImpl(con, false).fetchOtherExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newReason, otherExpensesAfterChanges.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteOtherExpensesOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedOtherExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        otherExpensesDAO.deleteOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        otherExpensesDAO.deleteOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Act
        new OtherExpensesDAOImpl().fetchOtherExpensesOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertOtherExpensesOneGuest_ShouldReturnInsertedNewOtherExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        guestDAO.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        guestDAO.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = guestDAO.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPK_id();

        //Act
        otherExpensesDAO.insertOtherExpensesOneGuest(newGuestID, projectOneID, 200, "", "");
        ArrayList<OtherExpense> newOtherExpenses = otherExpensesDAO.fetchOtherExpensesOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newOtherExpenses.get(2).getSpend(), 0.01);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertOtherExpensesOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        otherExpensesDAO.insertOtherExpensesOneGuest(newGuestIDWhichNotExist, projectOneID, 200, "", "");

        //Assert
    }
}
