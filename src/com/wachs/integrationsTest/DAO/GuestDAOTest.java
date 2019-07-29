package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Guest;
import com.wachs.main.dataAccess.DAO.GuestDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class GuestDAOTest {

    @Test
    public void fetchOneGuestOneProject_ShouldReturnCorrectGuestName() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Guest guestToFind = guestDAO.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

        //Arrange
        Assert.assertEquals(setupNameGuestOne, guestToFind.getGuestName());

    }

    @Test
    public void fetchOneGuestOneProject_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Guest guestToFind = guestDAO.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, guestToFind.getPK_id());

    }

    @Test
    public void fetchOneGuestOneProject_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Guest guestToFind = guestDAO.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, guestToFind.getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchOneGuestOneProject_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        guestDAO.fetchOneGuestOneProject("GuestNotExist", 99999);

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectAmountOfPrepaidToOneProject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Guest> listGuestsToFind = new GuestDAOImpl(con, false).fetchAllGuestsOneProject(projectOneID);

        //Assert
        Assert.assertEquals(CountAllGuestsProjectOne, listGuestsToFind.size());
    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Guest> listGuestsToFind = new GuestDAOImpl(con, false).fetchAllGuestsOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, listGuestsToFind.get(0).getPK_id());

    }

    @Test
    public void fetchAllPrepaidOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Guest> listGuestsToFind = new GuestDAOImpl(con, false).fetchAllGuestsOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, listGuestsToFind.get(0).getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllPrepaidOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        new GuestDAOImpl(con, false).fetchAllGuestsOneProject(9999);

    }

    @Test
    public void updatePrepaidOneGuest_ShouldReturnUpdatedPrepaid() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newName = "Newguestname";

        //Act
        guestDAO.updateGuestOneProject(guestOneID, newName, projectOneID);
        Guest guestToFind = guestDAO.fetchOneGuestOneProject(newName, projectOneID);

        //Assert
        Assert.assertEquals(newName, guestToFind.getGuestName());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deletePrepaidOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        guestDAO.deleteGuestOneProject(setupNameGuestOne, projectOneID);
        guestDAO.fetchOneGuestOneProject(setupNameGuestOne, projectOneID);

    }

    @Test(expected = org.sqlite.SQLiteException.class)
    public void insertGuestOneProject_IfProjectNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newGuestWhichNotFitToAnyProject = "Hello";

        //Act
        guestDAO.insertGuestOneProject(projectOneID, newGuestWhichNotFitToAnyProject);

        //Assert

    }
}