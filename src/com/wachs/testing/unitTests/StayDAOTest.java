package com.wachs.testing.unitTests;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAcess.DAO.GuestDAO;
import com.wachs.main.dataAcess.DAO.HouseDAO;
import com.wachs.main.dataAcess.DAO.StayDAO;
import com.wachs.testing.mocks.MockGuestDAO;
import com.wachs.testing.mocks.MockHouseDAO;
import com.wachs.testing.mocks.MockStayDAO;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StayDAOTest {


    @Test
    public void testDataBaseCall_Should_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        StayDAO aStay = new MockStayDAO();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aStay.insertData(idGuest, pkHouse,50);
        int nights_expected = aStay.findOneData(idGuest, pkHouse).getNights();
        int nights_setted = 50;

        //Assert
        assertEquals(nights_expected,nights_setted);

    }


    @Test
    public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        StayDAO aStay = new MockStayDAO();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aStay.insertData(idGuest, pkHouse,50);
        int nights_expected = aStay.findOneData(idGuest, pkHouse).getNights();
        int nights_setted = 51;

        //Assert
        assertNotEquals(nights_expected,nights_setted);

    }


    @Test(expected = SQLException.class)
    public void testDeletedDataBaseValue_Should_Throw_SQLException() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        StayDAO aStay = new MockStayDAO();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aStay.insertData(idGuest, pkHouse,50);
        aStay.deleteData(idGuest,pkHouse);

        //Assert
        aStay.findOneData(idGuest, pkHouse);

    }


    @Test(expected = SQLException.class)
    public void testConstraints_On_DataBase_ShouldWork_When_Same_IdGuest_AND_IdHouse() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        StayDAO aStay = new MockStayDAO();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aStay.insertData(idGuest, pkHouse,50);

        //Assert
        aStay.insertData(idGuest, pkHouse, 50);

    }


    @Test
    public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        StayDAO aStay = new MockStayDAO();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aStay.insertData(idGuest, pkHouse,50);



        //Assert
        ArrayList<Stay> listOfStay = new ArrayList<Stay>();
        listOfStay = aStay.readAllData();
        assertNotNull(listOfStay.get(0));

    }


    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        StayDAO aStay = new MockStayDAO();
        aHouse.deleteData("NameDesHauses");
        aHouse.insertData("NameDesHauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("NameDesHauses").getPK_id();
        aGuest.insertData(pkHouse,"NeuerName");
        int idGuest = aGuest.findOneData("NeuerName", pkHouse).getPK_id();

        //Act
        aStay.insertData(idGuest, pkHouse,50);
        aStay.updateData(idGuest, pkHouse, 60);

        int newNightsCount = 60;
        int oldNightCount = aStay.findOneData(idGuest,pkHouse).getNights();

        //Assert
        assertEquals(newNightsCount, oldNightCount);

    }

}