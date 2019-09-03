package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Drinks;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.DrinksService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IDrinksServiceTest {

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = IDrinksService.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(setupNights, drinkToFind.getNights());
    }

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = IDrinksService.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(drinkToFind.getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = IDrinksService.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(drinkToFind.getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchDrinksOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IDrinksService.fetchDrinksOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectAmountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksService(con, false).fetchAllDrinksOneProject(projectOneID);

        //Assert
        assertThat(listDrinksToFind.size(), is(CountAllGuestsProjectOne));

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksService(con, false).fetchAllDrinksOneProject(projectOneID);
        List<Drinks> newList = listDrinksToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectNightOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksService(con, false).fetchAllDrinksOneProject(projectOneID);
        List<Drinks> newList = listDrinksToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getNights(), is(setupNights));

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksService(con, false).fetchAllDrinksOneProject(projectOneID);
        List<Drinks> newList = listDrinksToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));
    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllDrinksOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IDrinksService.fetchAllDrinksOneProject(99999);

    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnUpdatedNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newNights = 100;

        //Act
        IDrinksService.updateDrinksOneGuest(guestOneID, projectOneID, newNights);
        Drinks drinkToFind = IDrinksService.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(drinkToFind.getNights(), is(newNights));

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteDrinksOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IDrinksService.deleteDrinksOneGuest(guestOneID, projectOneID);
        IDrinksService.fetchDrinksOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertDrinksOneGuest_ShouldReturnInsertedNewDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject(newNameProject, projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, newNameProject);
        int newGuestID = IGuestService.fetchOneGuestOneProject(newNameProject, projectOneID).getPrimaryKey();

        //Act
        IDrinksService.insertDrinksOneGuest(newGuestID, projectOneID, 200);
        Drinks newDrinks = IDrinksService.fetchDrinksOneGuest(newGuestID, projectOneID);

        //Assert
        assertThat(newDrinks.getNights(), is(200));
    }

    @Test(expected=org.sqlite.SQLiteException.class)
    public void insertDrinksOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IDrinksService.insertDrinksOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }
}