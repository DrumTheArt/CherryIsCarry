package com.wachs.test.unitTests;

import com.wachs.main.businessLayer.Prepaid;
import com.wachs.main.dataBaseLayer.DAO.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PrepaidDAOTest {

    /**
    @Test
    public void testDataBaseCall_Should_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        PrepaidDAO aPrepaid = new PrepaidDAOImpl();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aPrepaid.insertData(idGuest, pkHouse,50.0);
        double prepaid_expected = aPrepaid.findOneData(idGuest, pkHouse).getPrepaid();
        double prepaid_setted = 50;

        //Assert
       // assertEquals(prepaid_expected,prepaid_setted);

    }


    @Test
    public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        PrepaidDAO aPrepaid = new PrepaidDAOImpl();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aPrepaid.insertData(idGuest, pkHouse,50.0);
        double prepaid_expected = aPrepaid.findOneData(idGuest, pkHouse).getPrepaid();
        double prepaid_setted = 51;

        //Assert
        assertNotEquals(prepaid_expected,prepaid_setted);

    }


    @Test
    public void testDeletedDataBaseValue_Should_Throw_SQLException() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        DrinksDAO aDrink = new DrinksDAOImpl();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, pkHouse,50);
        aDrink.deleteData(idGuest,pkHouse);

        /**
        //Assert
        Assertions.assertThrows(SQLException.class, () -> {
            aDrink.findOneData(idGuest,pkHouse);
        });

    }


    @Test
    public void testConstraints_On_DataBase_ShouldWork_When_Same_IdGuest_AND_IdHouse() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        PrepaidDAO aPrepaid = new PrepaidDAOImpl();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aPrepaid.insertData(idGuest, pkHouse,50.00);


        //Assert
        Assertions.assertThrows(SQLException.class, () -> {
            aPrepaid.insertData(idGuest, pkHouse,50.00);
        });

    }


    @Test
    public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        PrepaidDAO aPrepaid = new PrepaidDAOImpl();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aPrepaid.insertData(idGuest, pkHouse,50.00);


        //Assert
        ArrayList<Prepaid> listOfPrepaids = new ArrayList<Prepaid>();
        listOfPrepaids = aPrepaid.readAllData();
        assertNotNull(listOfPrepaids.get(0));

    }


    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        DrinksDAO aDrink = new DrinksDAOImpl();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int idHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(idHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", idHouse).getPK_id();

        //Act
        aDrink.insertData(idGuest, idHouse,50);
        aDrink.updateData(idGuest, idHouse, 60);

        int newNightsCount = 60;
        int oldNightCount = aDrink.findOneData(idGuest,idHouse).getNights();

        //Assert
        assertEquals(newNightsCount, oldNightCount);

    }
**/
}