package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Drinks;
import com.wachs.main.dataAccess.DAO.DrinksDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class DrinksDAOTest {

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(setupNights, drinkToFind.getNights());
    }

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, drinkToFind.getIdGuest());

    }

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, drinkToFind.getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchDrinksOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        drinksDAO.fetchDrinksOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectAmountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksDAOImpl(con, false).fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(CountAllGuestsProjectOne, listDrinksToFind.size());
    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksDAOImpl(con, false).fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(guestOneID, listDrinksToFind.get(0).getIdGuest());

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectNightOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksDAOImpl(con, false).fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(setupNights, listDrinksToFind.get(0).getNights());

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Drinks> listDrinksToFind = new DrinksDAOImpl(con, false).fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(projectOneID, listDrinksToFind.get(0).getIdProject());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllDrinksOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        drinksDAO.fetchAllDrinksOneProject(99999);

    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnUpdatedNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newNights = 100;

        //Act
        drinksDAO.updateDrinksOneGuest(guestOneID, projectOneID, newNights);
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(newNights, drinkToFind.getNights());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteDrinksOneGuest_ShouldThrowExceptionIfFetchingAlreadyDeletedDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        drinksDAO.deleteDrinksOneGuest(guestOneID, projectOneID);
        drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

    }

    @Test
    public void insertDrinksOneGuest_ShouldReturnInsertedNewDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        guestDAO.deleteGuestOneProject("JustForThisTestGuest", projectOneID);
        guestDAO.insertGuestOneProject(projectOneID, "JustForThisTestGuest");
        int newGuestID = guestDAO.fetchOneGuestOneProject("JustForThisTestGuest", projectOneID).getPK_id();

        //Act
        drinksDAO.insertDrinksOneGuest(newGuestID, projectOneID, 200);
        Drinks newDrinks = drinksDAO.fetchDrinksOneGuest(newGuestID, projectOneID);

        //Assert
        Assert.assertEquals(200, newDrinks.getNights());
    }

    @Test(expected=org.sqlite.SQLiteException.class)
    public void insertDrinksOneGuest_IfGuestNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newGuestIDWhichNotExist = 9999999;

        //Act
        drinksDAO.insertDrinksOneGuest(newGuestIDWhichNotExist, projectOneID, 200);

        //Assert

    }
}