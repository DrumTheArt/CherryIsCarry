package com.wachs.testing.unitTests;

import com.wachs.main.businessLayer.Guest;
import com.wachs.main.dataBaseLayer.DAO.GuestDAO;
import com.wachs.main.dataBaseLayer.DAO.HouseDAO;
import com.wachs.main.dataBaseLayer.DBValidation.IDbColumnValidator;
import com.wachs.main.dataBaseLayer.DBValidation.TblGuestColumnValidate;
import com.wachs.testing.mocks.MockGuestDAO;
import com.wachs.testing.mocks.MockHouseDAO;
import org.junit.Test;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class GuestDAOTest {

    @Test
    public void testInsertData_Should_be_NotNull() throws SQLException, ClassNotFoundException, IOException {


        //Arrange
        GuestDAO toFindGuest = new MockGuestDAO();

        //Act
        toFindGuest.deleteData("NeuerGast2", 1);
        toFindGuest.insertData(1, "NeuerGast2");

        //Assert
        assertNotNull(toFindGuest);

    }

    @Test
    public void testTwo_insertData_Values_Should_be_Equal_On_TXT_name_And_Id_house() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        GuestDAO toFindGuest = new MockGuestDAO();

        //Act
        toFindGuest.deleteData("NeuerGast2", 1);
        toFindGuest.insertData(1, "NeuerGast2");
        Guest toCompareGuest = toFindGuest.findOneData("NeuerGast2", 1);
        Guest oldGuest = new Guest("Neuergast2", 1);


        //Assert
        assertEquals(oldGuest.getTXT_name(), toCompareGuest.getTXT_name());
        assertEquals(oldGuest.getId_house(), toCompareGuest.getId_house());
        assertNotEquals(oldGuest.getPK_id(), toCompareGuest.getPK_id());

    }

    @Test
    public void testTwo_insertData_Values_Should_be_Equal_ButNot_PKid() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        GuestDAO toFindGuest = new MockGuestDAO();

        //Act

        toFindGuest.deleteData("NeuerGast2", 1);
        toFindGuest.insertData(1, "NeuerGast2");
        Guest toCompareGuest = toFindGuest.findOneData("NeuerGast2", 1);
        Guest oldGuest = new Guest("NeuerGast2", 1);


        //Assert
        assertNotEquals(oldGuest.getPK_id(), toCompareGuest.getPK_id());

    }


    @Test
    public void testReadAllData_Should_BeNot_Same_Amount_when_Dropping_One_Element() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        GuestDAO daoObject = new MockGuestDAO();
        ArrayList<Guest> listGuests = daoObject.readAllData();

        //Act
        IDbColumnValidator countRows = new TblGuestColumnValidate();
        listGuests.remove(0);
        int countGuestListObjects = listGuests.size();
        int countGuestDataBase = countRows.getCountRow();

        //Assert
        assertNotEquals(countGuestListObjects, countGuestDataBase);

    }

    @Test
    public void testUpdateData() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        GuestDAO daoObject = new MockGuestDAO();
        daoObject.deleteData("Robert", 1);
        daoObject.deleteData("Elenaaasdasdasda", 1);
        daoObject.insertData(1, "Elenaaasdasdasda");


        //Act
        String oldName = daoObject.findOneData("Elenaaasdasdasda", 1).getTXT_name();
        int oldPkId = daoObject.findOneData("Elenaaasdasdasda", 1).getPK_id();
        daoObject.updateData(oldPkId, "Robert", 1);
        String newName = daoObject.findOneData("Robert", 1).getTXT_name();
        int newPkId = daoObject.findOneData("Robert", 1).getPK_id();

        //Assert
        assertEquals(oldPkId, newPkId);
        assertNotEquals(oldName, newName);

    }


    @Test(expected = SQLException.class)
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException, IOException {

        GuestDAO testing = new MockGuestDAO();

        testing.findOneData("ThisStringWillBeNeverInTheDataBaseISwearForeverForever1233213123123123", 1);

    }

    @Test(expected = SQLiteException.class)
    public void testInsertData_Name_And_idHouse_already_exists() throws SQLException, ClassNotFoundException, IOException {

        GuestDAO testing = new MockGuestDAO();
        testing.deleteData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);
        testing.insertData(1, "Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd");
        testing.insertData(1, "Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd");

    }

    @Test(expected = SQLException.class)
    public void testDeleteData_Should_be_Deleting_A_DatabaseObject() throws SQLException, ClassNotFoundException, IOException {

        GuestDAO testing = new MockGuestDAO();
        testing.deleteData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);
        testing.insertData(1, "Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd");
        Guest firstTry = testing.findOneData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);

        assertNotNull(firstTry);
        testing.deleteData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);
        testing.findOneData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);

    }

    @Test
    public void testFindAllDataWhereHouseID() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        aHouse.deleteData("Test2222");
        aHouse.insertData("Test2222", 800.00, 600.00);
        int id_house = aHouse.findOneData("Test2222").getPK_id();

        GuestDAO aGuest = new MockGuestDAO();
        aGuest.insertData(id_house, "1Person");
        aGuest.insertData(id_house, "2Person");
        aGuest.insertData(id_house, "3Person");
        aGuest.insertData(id_house, "4Person");

        //Act
        ArrayList<Guest> allRelevantGuests = new ArrayList<Guest>();
        allRelevantGuests = aGuest.findListDataWhereHouseID(id_house);
        int countRelevantGuests = allRelevantGuests.size();
        //Assert
        assertEquals(countRelevantGuests,4);

    }

}