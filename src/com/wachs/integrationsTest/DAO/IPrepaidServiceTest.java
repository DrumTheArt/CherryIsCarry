package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Prepaid;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.PrepaidService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IPrepaidServiceTest {

    @Test
    public void fetchPrepaidOneGuest_ShouldReturnCorrectPrepaidPrice() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Prepaid prepaidToFind = IPrepaidService.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(setupPrepaid, prepaidToFind.getPrepaid(), 0.01);
    }

    @Test
    public void fetchPrepaidOneGuest_ShouldReturnCorrectGuestId() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Prepaid prepaidToFind = IPrepaidService.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(prepaidToFind.getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchPrepaidOneGuest_ShouldReturnCorrectProjectId() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Prepaid prepaidToFind = IPrepaidService.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Assert
        assertThat(prepaidToFind.getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchPrepaidOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IPrepaidService.fetchPrepaidOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectAmountOfPrepaidToOneProject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Prepaid> listPrepaidToFind = new PrepaidService(con, false).fetchAllPrepaidOneProject(projectOneID);

        //Assert
        assertThat(listPrepaidToFind.size(), is(CountAllGuestsProjectOne));
    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectGuestIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Prepaid> listPrepaidToFind = new PrepaidService(con, false).fetchAllPrepaidOneProject(projectOneID);
        List<Prepaid> newList = listPrepaidToFind.stream().filter(x -> x.getGuestId() == guestOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getGuestId(), is(guestOneID));

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectProjectIdOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Prepaid> listPrepaidToFind = new PrepaidService(con, false).fetchAllPrepaidOneProject(projectOneID);
        List<Prepaid> newList = listPrepaidToFind.stream().filter(x -> x.getProjectId() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getProjectId(), is(projectOneID));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllPrepaidOneProject_IfNotExistInDB_ShouldThrowException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IPrepaidService.fetchAllPrepaidOneProject(9999);

    }

    @Test
    public void updatePrepaidOneGuest_ShouldReturnUpdatedPrepaid() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        double newPrepaid = 100;

        //Act
        IPrepaidService.updatePrepaidOneGuest(guestOneID, projectOneID, newPrepaid);
        Prepaid prepaidToFind = IPrepaidService.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newPrepaid, prepaidToFind.getPrepaid(), 0.001);

    }

    @Test(expected = NotInDataBaseException.class)
    public void deletePrepaidOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IPrepaidService.deletePrepaidOneGuest(guestOneID, projectOneID);
        IPrepaidService.fetchPrepaidOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertPrepaidOneGuest_ShouldReturnInsertedNewPrepaidObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IGuestService.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        IGuestService.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = IGuestService.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPrimaryKey();

        //Act
        IPrepaidService.insertPrepaidOneGuest(newGuestID, projectOneID, 200);
        Prepaid newPrepaid = IPrepaidService.fetchPrepaidOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newPrepaid.getPrepaid(), 0.001);
    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertPrepaidOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        IPrepaidService.insertPrepaidOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }
}