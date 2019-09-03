package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Stay;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.StayService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IStayServiceTest {

    @Test
    public void fetchStayOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Arrange
        assertThat(stayToFind.getNights(), is(setupNights));
    }

    @Test
    public void fetchStayOneGuest_ShouldReturnCorrectGuestId() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(stayToFind.getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchStayOneGuest_ShouldReturnCorrectProjectId() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Stay stayToFind = IStayService.fetchStayOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(stayToFind.getProjectId(), is(projectOneID));

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
        assertThat(listStaysToFind.size(), is(CountAllGuestsProjectOne));

    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

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
        List<Stay> newList = listStaysToFind.stream().filter(x -> x.getNights() == setupNights).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getNights(), is(setupNights));

    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Stay> listStaysToFind = new StayService(con, false).fetchAllStayOneProject(projectOneID);
        List<Stay> newList = listStaysToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllStayOneProject_IfNotExistInDB_ShouldThrowException() {

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
        assertThat(stayToFind.getNights(), is(newNights));

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
        assertThat(newStay.getNights(), is(200));
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