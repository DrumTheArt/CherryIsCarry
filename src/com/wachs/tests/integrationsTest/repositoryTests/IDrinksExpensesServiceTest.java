package com.wachs.tests.integrationsTest.repositoryTests;

import com.wachs.main.BusinessEntities.DrinksExpense;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.DataAccess.services.DrinksExpensesService;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.tests.integrationsTest.util.GeneratorTestData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.tests.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        assertEquals(countAllDrinksExpensesOneProjectOneGuest, drinksExpensesToFind.size());
    }

    @Test
    public void fetchDrinksExpensesByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = IDrinksExpensesService.fetchDrinksExpensesOneGuest(guestOneID, projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchDrinksExpensesByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = IDrinksExpensesService.fetchDrinksExpensesOneGuest(guestOneID, projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));

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
        assertThat(drinksExpensesToFind.size(), is(countAllDrinksExpensesOneProjectAllGuests));
    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectSpendAmountOfFirstInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getSpend() == setupExpenses).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getSpend(), is(setupExpenses));

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectWhenOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getWhen().equals(setupTime)).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getWhen(), is(setupTime));

    }

    @Test
    public void fetchAllDrinksExpensesByOneProject_ShouldReturnCorrectReasonOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<DrinksExpense> drinksExpensesToFind = new DrinksExpensesService(con, false).fetchAllDrinksExpensesOneProject(projectOneID);
        List<DrinksExpense> newList = drinksExpensesToFind.stream().filter(x -> x.getReason().equals(setupNameReason)).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getReason(), is(setupNameReason));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllExpensesByOneProject_IfNotExistInDB_ShouldThrowException() {

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
        assertThat(drinkExpensesAfterChanges.get(0).getReason(), is(newReason));

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
        List<DrinksExpense> newList = newDrinksExpenses.stream().filter(x -> x.getSpend() == 200).collect(Collectors.toList());

        //Assert
        assertEquals(200, newDrinksExpenses.get(0).getSpend(), 0.01);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertDrinksExpensesOneGuest_IfGuestNotExistInDB_ShouldThrowException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IDrinksExpensesService.insertDrinksExpensesOneGuest(newGuestIDWhichNotExist, projectOneID, 200, "", "");
    }
}
