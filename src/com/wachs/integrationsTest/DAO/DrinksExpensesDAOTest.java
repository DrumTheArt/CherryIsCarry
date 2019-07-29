package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.DrinksExpense;
import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.DAO.DrinksExpensesDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class DrinksExpensesDAOTest {

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCompleteList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(countAllDrinksExpensesOneProjectOneGuest, drinksExpensesToFind.size());
    }

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = drinksExpensesDAO.fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, drinksExpensesToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = drinksExpensesDAO.fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, drinksExpensesToFind.get(0).getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchFoodByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new DrinksExpensesDAOImpl(con, false).fetchDrinksExpensesOneGuest(9999, 9999);

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectCountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(countAllDrinksExpensesOneProjectAllGuests, drinksExpensesToFind.size());
    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectSpendAmountOfFirstInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupExpenses, drinksExpensesToFind.get(0).get_spend(), 0.001);

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, drinksExpensesToFind.get(0).getIdProject());

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, drinksExpensesToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupTime, drinksExpensesToFind.get(0).getWhen());

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectReasonOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchAllDrinksExpensesOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNameReason, drinksExpensesToFind.get(0).getReason());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllFoodByOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        foodDAO.fetchAllFoodByOneProject(99999);

    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnUpdatedReason() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newReason = "Newreason";
        IDBConnection con = new TestDBConnection();

        //Diese Query funktioniert noch nicht ... der löscht die Objekte nicht raus
        // Das heißt --> wir müssen einen Constraint auf Datum und Reason machen
        // oder:
        // wir hauen in die where clause den FK_id rein .. aber nach welchem Kriterium sollte das vergeben werden?
        otherExpensesDAO.deleteOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        /**
         //Act
         otherExpensesDAO.updateOtherExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime, setupProjectPrice, newReason, setupTime);
         ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesDAOImpl(con, false).fetchDrinksExpensesOneGuest(guestOneID, projectOneID);

         Optional<DrinksExpense> result = drinksExpensesToFind.stream().filter(x -> x.getReason().equals(newReason)).findFirst();

         //Assert
         Assert.assertEquals(newReason, result.get().getReason());
         **/

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteFoodOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedFoodObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        foodDAO.deleteFoodOneGuest(guestOneID, projectOneID);
        foodDAO.fetchFoodByOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertFoodOneGuest_ShouldReturnInsertedNewFoodObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        guestDAO.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        guestDAO.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = guestDAO.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPK_id();

        //Act
        foodDAO.insertFoodOneGuest(newGuestID, projectOneID, 200);
        Food newFood = foodDAO.fetchFoodByOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newFood.getNights());
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertFoodOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        foodDAO.insertFoodOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }

}
