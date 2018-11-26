package com.wachs.testing.unitTests;

import com.wachs.main.businessLayer.Drinks;
import com.wachs.main.dataBaseLayer.DAO.DrinksDAO;
import com.wachs.main.dataBaseLayer.DAO.GuestDAO;
import com.wachs.main.dataBaseLayer.DAO.HouseDAO;
import com.wachs.main.dataBaseLayer.DDL.DropAndCreateTableDB;
import com.wachs.main.dataBaseLayer.DDL.ITableDBScript;
import com.wachs.testing.dbTestConfig.InsertValuesDBTestData;
import com.wachs.testing.mocks.MockDrinksDAO;
import com.wachs.testing.mocks.MockGuestDAO;
import com.wachs.testing.mocks.MockHouseDAO;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DrinksDAOTest {


    public void setUp() throws SQLException, IOException, ClassNotFoundException {

        ITableDBScript createTable = new DropAndCreateTableDB();
        createTable.executeQuery();

        ITableDBScript insertTestValuesForDb = new InsertValuesDBTestData();
        insertTestValuesForDb.executeQuery();

     }

    public void tearDown() throws SQLException, IOException, ClassNotFoundException {

        ITableDBScript createTable = new DropAndCreateTableDB();
        createTable.executeQuery();
     }

    @Test
    public void test_InsertStatement_Should_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException, IOException {

     //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        DrinksDAO aDrink = new MockDrinksDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses", 200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse, "Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, pkHouse, 50);
        int nights_expected = aDrink.findOneData(idGuest, pkHouse).getNights();
        int nights_setted = 50;

        //Assert
        assertEquals(nights_expected, nights_setted);

     }


    @Test
    public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException, IOException {

     //Arrange
         HouseDAO aHouse = new MockHouseDAO();
         GuestDAO aGuest = new MockGuestDAO();
         DrinksDAO aDrink = new MockDrinksDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses", 200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse, "NeuerName");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, pkHouse, 50);
        int nights_expected = aDrink.findOneData(idGuest, pkHouse).getNights();
        int nights_setted = 51;

        //Assert
        assertNotEquals(nights_expected, nights_setted);

     }

    @Test(expected = SQLException.class)
    public void testDeletedDataBaseValue_Should_Throw_SQLException() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        DrinksDAO aDrink = new MockDrinksDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses", 200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse, "Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, pkHouse, 50);
        aDrink.deleteData(idGuest, pkHouse);
        aDrink.findOneData(idGuest, pkHouse);

     }


    @Test(expected = SQLException.class)
    public void testConstraints_On_DataBase_ShouldWork_When_Same_IdGuest_AND_IdHouse() throws SQLException, ClassNotFoundException, IOException {

     //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        DrinksDAO aDrink = new MockDrinksDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses", 200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse, "Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, pkHouse, 50);
        aDrink.insertData(idGuest, pkHouse, 50);

     }

    @Test
    public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException, IOException {

     //Arrange
         HouseDAO aHouse = new MockHouseDAO();
         GuestDAO aGuest = new MockGuestDAO();
         DrinksDAO aDrink = new MockDrinksDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses", 200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse, "Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, pkHouse, 50);

        //Assert
        ArrayList<Drinks> listOfDrinks = new ArrayList<Drinks>();
        listOfDrinks = aDrink.readAllData();
        assertNotNull(listOfDrinks.get(0));

     }


    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException, IOException {

     //Arrange
         HouseDAO aHouse = new MockHouseDAO();
         GuestDAO aGuest = new MockGuestDAO();
         DrinksDAO aDrink = new MockDrinksDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses", 200.0, 300.0);
        int idHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(idHouse, "Neuername");
        int idGuest = aGuest.findOneData("Neuername", idHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, idHouse, 50);
        aDrink.updateData(idGuest, idHouse, 60);

        int newNightsCount = 60;
        int oldNightCount = aDrink.findOneData(idGuest, idHouse).getNights();

        //Assert
        assertEquals(newNightsCount, oldNightCount);

     }
}