package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Stay;
import com.wachs.main.dataAccess.services.StayService;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class IStayServiceTest {

    @Test
    public void fetchStayOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(setupNights, stayToFind.getNights());
    }

    @Test
    public void fetchStayOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, stayToFind.getGuestId());

    }

    @Test
    public void fetchStayOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, stayToFind.getProjectId());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchStayOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IStayService.fetchStayOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectAmountOfAllStaysToOneProject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Stay> listStaysToFind = new StayService(con, false).fetchAllStayOneProject(projectOneID);

        //Assert
        Assert.assertEquals(CountAllGuestsProjectOne, listStaysToFind.size());
    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Stay> listStaysToFind = new StayService(con, false).fetchAllStayOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, listStaysToFind.get(0).getGuestId());

    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectStayDurationOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Stay> listStaysToFind = new StayService(con, false).fetchAllStayOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNights, listStaysToFind.get(0).getNights());

    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Stay> listStaysToFind = new StayService(con, false).fetchAllStayOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, listStaysToFind.get(0).getProjectId());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllStayOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IStayService.fetchAllStayOneProject(9999);

    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnUpdatedNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newNights = 100;

        //Act
        IStayService.updateStayOneGuest(guestOneID, projectOneID, newNights);
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newNights, stayToFind.getNights());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteStayOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IStayService.deleteStayOneGuest(guestOneID, projectOneID);
        IStayService.fetchStayOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertStayOneGuest_ShouldReturnInsertedNewDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = IGuestService.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPrimaryKey();

        //Act
        IStayService.insertStayOneGuest(newGuestID, projectOneID, 200);
        Stay newStay = IStayService.fetchStayOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newStay.getNights());
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertDrinksOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IStayService.insertStayOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }
}