package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.services.FoodService;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class IFoodServiceTest {

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(setupNights, foodToFind.getNights());
    }

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, foodToFind.getGuestId());

    }

    @Test
    public void fetchFoodByOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Food foodToFind = IFoodService.fetchFoodByOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, foodToFind.getProjectId());

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
        Assert.assertEquals(CountAllGuestsProjectOne, listFoodToFind.size());
    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, listFoodToFind.get(0).getGuestId());

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectNightOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNights, listFoodToFind.get(0).getNights());

    }

    @Test
    public void fetchAllFoodByOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Food> listFoodToFind = new FoodService(con, false).fetchAllFoodByOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, listFoodToFind.get(0).getProjectId());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllFoodByOneProject_IfNotExistInDB_ShouldReturnException() {

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
        Assert.assertEquals(newNights, foodToFind.getNights());

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
        Assert.assertEquals(200, newFood.getNights());
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertFoodOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IFoodService.insertFoodOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }
}