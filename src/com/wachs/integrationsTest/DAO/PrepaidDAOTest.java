package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Prepaid;
import com.wachs.main.dataAccess.DAO.PrepaidDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class PrepaidDAOTest {

    @Test
    public void fetchPrepaidOneGuest_ShouldReturnCorrectPrepaidPrice() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Prepaid prepaidToFind = prepaidDAO.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(setupPrepaid, prepaidToFind.getPrepaid(), 0.01);
    }

    @Test
    public void fetchPrepaidOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Prepaid prepaidToFind = prepaidDAO.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, prepaidToFind.getIdGuest());

    }

    @Test
    public void fetchPrepaidOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Prepaid prepaidToFind = prepaidDAO.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, prepaidToFind.getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchPrepaidOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        prepaidDAO.fetchPrepaidOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectAmountOfPrepaidToOneProject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Prepaid> listPrepaidToFind = new PrepaidDAOImpl(con, false).fetchAllPrepaidOneProject(projectOneID);

        //Assert
        Assert.assertEquals(CountAllGuestsProjectOne, listPrepaidToFind.size());
    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Prepaid> listPrepaidToFind = new PrepaidDAOImpl(con, false).fetchAllPrepaidOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, listPrepaidToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Prepaid> listPrepaidToFind = new PrepaidDAOImpl(con, false).fetchAllPrepaidOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, listPrepaidToFind.get(0).getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllPrepaidOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        prepaidDAO.fetchAllPrepaidOneProject(9999);

    }

    @Test
    public void updatePrepaidOneGuest_ShouldReturnUpdatedPrepaid() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        double newPrepaid = 100;

        //Act
        prepaidDAO.updatePrepaidOneGuest(guestOneID, projectOneID, newPrepaid);
        Prepaid prepaidToFind = prepaidDAO.fetchPrepaidOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newPrepaid, prepaidToFind.getPrepaid(), 0.001);

    }

    @Test(expected = NotInDataBaseException.class)
    public void deletePrepaidOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        prepaidDAO.deletePrepaidOneGuest(guestOneID, projectOneID);
        prepaidDAO.fetchPrepaidOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertPrepaidOneGuest_ShouldReturnInsertedNewPrepaidObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        guestDAO.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        guestDAO.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = guestDAO.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPK_id();

        //Act
        prepaidDAO.insertPrepaidOneGuest(newGuestID, projectOneID, 200);
        Prepaid newPrepaid = prepaidDAO.fetchPrepaidOneGuest(newGuestID, projectOneID);

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
        prepaidDAO.insertPrepaidOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }
}