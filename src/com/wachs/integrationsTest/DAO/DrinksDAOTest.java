package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Drinks;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class DrinksDAOTest {

    @Test
    public void findDrinksOneGuest_ShouldReturnCorrectNights() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Arrange
        Assert.assertEquals(drinkToFind.getNights(), setupNights);
    }

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectGuestID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(drinkToFind.getIdGuest(), guestOneID);

    }

    @Test
    public void fetchDrinksOneGuest_ShouldReturnCorrectProjectID() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(drinkToFind.getIdProject(), projectOneID);

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchDrinksOneGuest_ShouldThrowNotInDataBaseExceptionIfGuestAndProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(99999, 99999);

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectAmountOfGuests() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<Drinks> listDrinksToFind = drinksDAO.fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(listDrinksToFind.size(), 3);
    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectGuestIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<Drinks> listDrinksToFind = drinksDAO.fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(listDrinksToFind.get(0).getIdGuest(), guestOneID);

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectNightOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<Drinks> listDrinksToFind = drinksDAO.fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(listDrinksToFind.get(0).getNights(), setupNights);

    }

    @Test
    public void fetchAllDrinksOneProject_ShouldReturnCorrectProjectIDOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<Drinks> listDrinksToFind = drinksDAO.fetchAllDrinksOneProject(projectOneID);

        //Assert
        Assert.assertEquals(listDrinksToFind.get(0).getIdProject(), projectOneID);

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllDrinksOneProject_IfNotExistInDB_ShouldReturnException() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        ArrayList<Drinks> listDrinksToFind = drinksDAO.fetchAllDrinksOneProject(99999);

    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnCorrectDrinkObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newNights = 100;

        //Act
        drinksDAO.updateDrinksOneGuest(guestOneID, projectOneID, newNights);
        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestOneID, projectOneID);

        //Assert
        Assert.assertEquals(drinkToFind.getNights(), 100);

    }

    @Test
    public void updateDrinksOneGuest_IfNotExistInDB_ShouldReturnException() {

    }

    @Test
    public void updateDrinksOneGuest_ShouldThrowSQLException() {

    }

    @Test
    public void deleteDrinksOneGuest_ShouldNotReturnAlreadyDeletedDrinkObject() {

    }

    @Test
    public void deleteDrinksOneGuest_ShouldThrowSQLException() {

    }

    @Test
    public void insertDrinksOneGuest_ShouldReturnInsertDrinkObject() {

    }

    @Test
    public void insertDrinksOneGuest_IfAlreadyExistInDB_ShouldReturnException() {

    }

    @Test
    public void insertDrinksOneGuest_ShouldThrowSQLException() {

    }

}