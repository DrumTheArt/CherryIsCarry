package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Guest;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.GuestService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IGuestServiceTest {

    @Test
    public void fetchOneGuestOneProject_ShouldReturnCorrectGuestName() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Guest guestToFind = IGuestService.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

        //Arrange
        assertThat(guestToFind.getGuestName(), is(setupNameGuestOne));

    }

    @Test
    public void fetchOneGuestOneProject_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Guest guestToFind = IGuestService.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

        //Assert
        assertThat(guestToFind.getPrimaryKey(), is(guestOneID));

    }

    @Test
    public void fetchOneGuestOneProject_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Guest guestToFind = IGuestService.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

        //Assert
        assertThat(guestToFind.getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchOneGuestOneProject_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IGuestService.fetchOneGuestOneProject("GuestNotExist", 99999);

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectAmountOfPrepaidToOneProject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Guest> listGuestsToFind = new GuestService(con, false).fetchAllGuestsOneProject(projectOneID);
        List<Guest> newList = listGuestsToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.size(), is(CountAllGuestsProjectOne));

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Guest> listGuestsToFind = new GuestService(con, false).fetchAllGuestsOneProject(projectOneID);
        List<Guest> newList = listGuestsToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getPrimaryKey(), is(guestOneID));

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Guest> listGuestsToFind = new GuestService(con, false).fetchAllGuestsOneProject(projectOneID);
        List<Guest> newList = listGuestsToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllPrepaidOneProject_IfNotExistInDB_ShouldThrowException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new GuestService(con, false).fetchAllGuestsOneProject(9999);

    }

    @Test
    public void updatePrepaidOneGuest_ShouldReturnUpdatedPrepaid() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newName = "Newguestname";

        //Act
        IGuestService.updateGuestOneProject(guestOneID, newName, projectOneID);
        Guest guestToFind = IGuestService.fetchOneGuestOneProject(newName, projectOneID);

        //Assert
        Assert.assertEquals(newName, guestToFind.getGuestName());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deletePrepaidOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IGuestService.deleteGuestOneProject(setupNameGuestOne, projectOneID);
        IGuestService.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertGuestOneProject_IfProjectNotExistInDB_ShouldThrowException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newGuestWhichNotFitToAnyProject = "Hello";

        //Act
        IGuestService.insertGuestOneProject(projectOneID, newGuestWhichNotFitToAnyProject);

        //Assert

    }
}