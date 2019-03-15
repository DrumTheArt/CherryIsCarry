package com.wachs.unittests;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAccess.DAO.DrinksDAOImpl;
import com.wachs.main.dataAccess.DAO.GuestDAOImpl;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinksDAOImplTest {



    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {


    }

    @Test
    public void findDrinksByOneGuest_Should_Return_DrinkObject_When_idGuestAndIdProjectExist() {

        //Arrange
        String newProjectName = "HausAmMeer";
        String newGuestName = "RobertAmMeer";
        double expectedDeposite = 200.00;
        double expectedPrice = 300.00;
        int expectedNight = 3;

        ProjectDAOImpl newDAOProject = new ProjectDAOImpl();
        newDAOProject.insertProject(newProjectName, expectedPrice, expectedDeposite);
        int idProject = newDAOProject.findOneProject(newProjectName).getPK_id();

        GuestDAOImpl newDAOGuest = new GuestDAOImpl();
        newDAOGuest.insertGuestForOneProject(idProject, newGuestName);
        int idGuest = newDAOGuest.findOneGuestByOneProject(newGuestName, idProject).getPK_id();

        DrinksDAOImpl newDrinksDAO = new DrinksDAOImpl();

        //Act
        newDrinksDAO.insertDrinksForOneGuest(idGuest, idProject, expectedNight);
        Drinks aDrink = newDrinksDAO.findDrinksByOneGuest(idGuest, idProject);

        //Assert
        Assert.assertNotNull(aDrink);
        Assert.assertEquals(expectedNight, aDrink.getNights());
        Assert.assertEquals(idGuest, aDrink.getIdGuest());
        Assert.assertEquals(idProject, aDrink.getIdProject());

    }

    @Test
    public void findDrinksByOneGuest_Should_Throw_Exception_When_idGuestDontExist() {
    }

    @Test
    public void findDrinksByOneGuest_Should_Throw_Exception_When_idProjectDontExist() {
    }

    @Test
    public void findAllDrinksByOneProject_Should_Return_ListOfDrinks_When_idGuestAndIdProjectExist() {
    }

    @Test
    public void findAllDrinksByOneProject_Should_Throw_Exception_When_idProjectDontExist() {
    }

    @Test
    public void updateDrinksForOneGuest_Should_Update_DrinkTableValue_When_idGuestAndIdProjectExist() {
    }

    @Test
    public void updateDrinksForOneGuest_Should_Throw_Exception_When_idGuestDontExist() {
    }

    @Test
    public void updateDrinksForOneGuest_Should_Throw_Exception_When_idProjectDontExist() {
    }

    @Test
    public void updateDrinksForOneGuest_newNightsValue_IsNegativeValue() {
    }

    @Test
    public void deleteDrinksForOneGuest_Should_Delete_DrinkTableValue_When_idGuestAndIdProjectExist() {
    }

    @Test
    public void deleteDrinksForOneGuest_Should_Throw_Exception_When_idGuestDontExist() {
    }

    @Test
    public void deleteDrinksForOneGuest_Should_Throw_Exception_When_idProjectDontExist() {
    }

    @Test
    public void insertDrinksForOneGuest_Should_Insert_NewDataTableValue_When_idProjectExist() {
    }

    @Test
    public void insertDrinksForOneGuest_Should_Throw_Exception_When_idProjectDontExist() {
    }

    @Test
    public void insertDrinksForOneGuest_Should_Throw_Exception_When_NewValueIsNegative() {
    }
}