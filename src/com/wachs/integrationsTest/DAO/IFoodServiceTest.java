package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.FoodService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IFoodServiceTest {

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Arrange
        assertThat(foodToFind.getNights(), is(setupNights));
    }

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(foodToFind.getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(foodToFind.getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchFoodByOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IFoodService.fetchFoodByOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectAmountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);

        //Assert
        assertThat(listFoodToFind.size(), is(CountAllGuestsProjectOne));
    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);
        List<Food> newList = listFoodToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());
        //Assert
        assertThat(newList.get(0).getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectNightOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);
        List<Food> newList = listFoodToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getNights(), is(setupNights));

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);
        List<Food> newList = listFoodToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllFoodByOneProject_IfNotExistInDB_ShouldThrowException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IFoodService.fetchAllFoodByOneProject(99999);

    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnUpdatedNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newNights = 100;

        //Act
        IFoodService.updateFoodOneGuest(guestOneID, projectOneID, newNights);
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(foodToFind.getNights(), is(newNights));

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteFoodOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedFoodObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IFoodService.deleteFoodOneGuest(guestOneID, projectOneID);
        IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertFoodOneGuest_ShouldReturnInsertedNewFoodObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = IGuestService.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPrimaryKey();

        //Act
        IFoodService.insertFoodOneGuest(newGuestID, projectOneID, 200);
        Food newFood = IFoodService.fetchFoodByOneGuest(newGuestID, projectOneID);

        //Assert
        assertThat(newFood.getNights(), is(200));

    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertFoodOneGuest_IfGuestNotExistInDB_ShouldThrowException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IFoodService.insertFoodOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

    }
}