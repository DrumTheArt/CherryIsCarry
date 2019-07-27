package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Drinks;
import org.junit.Assert;
import org.junit.Test;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class DrinksDAOTest {


    @Test
    public void findDrinksOneGuest_ShouldReturnCorrectDrinkObject() {

        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        Drinks drinkToFind = drinksDAO.fetchDrinksOneGuest(guestID, projectID);
        Assert.assertEquals(drinkToFind.getNights(), setupNights);

    }

    @Test
    public void findDrinksOneGuest_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void findDrinksOneGuest_ShouldThrowSQLException() {


    }

    @Test
    public void findAllDrinksOneProject_ShouldReturnCorrectDrinkObject() {


    }

    @Test
    public void findAllDrinksOneProject_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void findAllDrinksOneProject_ShouldThrowSQLException() {


    }

    @Test
    public void updateDrinksOneGuest_ShouldReturnCorrectDrinkObject() {


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