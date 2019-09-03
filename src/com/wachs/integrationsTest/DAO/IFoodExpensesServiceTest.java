package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.FoodExpense;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.FoodExpensesService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class IFoodExpensesServiceTest {

    @Test
    public void fetchFoodExpensesByOneGuest_ShouldReturnCompleteList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchFoodExpensesOneGuest(guestOneID, projectOneID);

        //Arrange

        assertThat(foodExpensesToFind.size(), is(countAllFoodExpensesOneProjectOneGuest));
    }

    @Test
    public void fetchFoodExpensesByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = foodExpensesDAO.fetchFoodExpensesOneGuest(guestOneID, projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchFoodExpensesByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = foodExpensesDAO.fetchFoodExpensesOneGuest(guestOneID, projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));
    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchFoodExpensesByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new FoodExpensesService(con, false).fetchFoodExpensesOneGuest(9999, 9999);

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectCountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchAllFoodExpensesOneProject(projectOneID);

        //Assert
        assertThat(foodExpensesToFind.size(), is(countAllDrinksExpensesOneProjectAllGuests));
    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectSpendAmountOfFirstInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchAllFoodExpensesOneProject(projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.get_spend() == setupExpenses).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).get_spend(), is(setupExpenses));
    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchAllFoodExpensesOneProject(projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));
    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchAllFoodExpensesOneProject(projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());

        //Assert

    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchAllFoodExpensesOneProject(projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.getWhen().equals(setupTime)).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getWhen(), is(setupTime));
    }

    @Test
    public void fetchAllFoodExpensesByOneProject_ShouldReturnCorrectReasonOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<FoodExpense> foodExpensesToFind = new FoodExpensesService(con, false).fetchAllFoodExpensesOneProject(projectOneID);
        List<FoodExpense> newList = foodExpensesToFind.stream().filter(x -> x.getReason().equals(setupNameReason)).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getReason(), is(setupNameReason));
    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllFoodExpensesByOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IFoodService.fetchAllFoodByOneProject(99999);
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
        ArrayList<FoodExpense> foodExpensesAfterChanges = new FoodExpensesService(con, false).fetchFoodExpensesOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(foodExpensesAfterChanges.get(0).getReason(), is(newReason));

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteFoodExpensesOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedDrinksExpensesObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        foodExpensesDAO.deleteFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);
        foodExpensesDAO.deleteFoodExpensesOneGuest(guestOneID, projectOneID, setupExpenses, setupNameReason, setupTime);

        //Act
        new FoodExpensesService().fetchFoodExpensesOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertFoodExpensesOneGuest_ShouldReturnInsertedNewFoodExpensesObject() {

        //Arrange
        createObjects();
        insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = IGuestService.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPrimaryKey();

        //Act
        foodExpensesDAO.insertFoodExpensesOneGuest(newGuestID, projectOneID, 200, "", "");
        ArrayList<FoodExpense> newFoodExpenses = foodExpensesDAO.fetchFoodExpensesOneGuest(newGuestID, projectOneID);
        List<FoodExpense> newList = newFoodExpenses.stream().filter(x -> x.get_spend() == 200).collect(Collectors.toList());

        //Assert
        //Why no assertThat --> No interest to download hamcrest to use a matcher
        assertEquals(200, newList.get(0).get_spend(), 0.01);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertFoodExpensesOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        foodExpensesDAO.insertFoodExpensesOneGuest(newGuestIDWhichNotExist, projectOneID, 200, "", "");
    }
}
