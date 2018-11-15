package com.wachs.test.unitTests;

import com.wachs.main.businessLayer.Guest;
import com.wachs.main.dataBaseLayer.DAO.*;
import com.wachs.main.dataBaseLayer.DBValidation.IDbColumnValidator;
import com.wachs.main.dataBaseLayer.DBValidation.TblGuestColumnValidate;
import org.junit.Test;
import org.sqlite.SQLiteException;

import java.sql.SQLException;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class GuestDAOTest {

/**
    @Test
    public void testInsertData_Should_be_NotNull() throws SQLException, ClassNotFoundException {


        //Arrange
        GuestDAO toFindGuest = new GuestDAOImpl();

        //Act
        toFindGuest.deleteData("NeuerGast2", 1);
        toFindGuest.insertData(1, "NeuerGast2");

        //Assert
        assertNotNull(toFindGuest);

    }

    @Test
    public void testTwo_insertData_Values_Should_be_Equal_On_TXT_name_And_Id_house() throws SQLException, ClassNotFoundException {

        //Arrange
        GuestDAO toFindGuest = new GuestDAOImpl();

        //Act
        toFindGuest.deleteData("NeuerGast2", 1);
        toFindGuest.insertData(1, "NeuerGast2");
        Guest toCompareGuest = (Guest) toFindGuest.findOneData("NeuerGast2", 1);
        Guest oldGuest = new Guest("Neuergast2", 1);


        //Assert
        assertEquals(oldGuest.getTXT_name(), toCompareGuest.getTXT_name());
        assertEquals(oldGuest.getId_house(), toCompareGuest.getId_house());
        assertNotEquals(oldGuest.getPK_id(), toCompareGuest.getPK_id());

    }

    @Test
    public void testTwo_insertData_Values_Should_be_Equal_ButNot_PKid() throws SQLException, ClassNotFoundException {

        //Arrange
        GuestDAO toFindGuest = new GuestDAOImpl();

        //Act

        toFindGuest.deleteData("NeuerGast2", 1);
        toFindGuest.insertData(1, "NeuerGast2");
        Guest toCompareGuest = (Guest) toFindGuest.findOneData("NeuerGast2", 1);
        Guest oldGuest = new Guest("NeuerGast2", 1);


        //Assert
        assertNotEquals(oldGuest.getPK_id(), toCompareGuest.getPK_id());

    }

    @Test
    public void testReadAllData_Should_Be_same_Amount_as_Guestlist() throws SQLException, ClassNotFoundException {

        //Arrange
        GuestDAO daoObject = new GuestDAOImpl();
        ArrayList<Guest> listGuests = daoObject.readAllData();

        //Act
        IDbColumnValidator countRows = new TblGuestColumnValidate();
        int countGuestListObjects = ((ArrayList) listGuests).size();
        System.out.println("Count objects: " + countGuestListObjects);
        int countGuestDataBase = countRows.getCountRow();
        System.out.println("Count DB-Tupel: " + countGuestDataBase);

        //Assert
        assertEquals(countGuestListObjects, countGuestDataBase);

    }

    @Test
    public void testReadAllData_Should_BeNot_Same_Amount_when_Dropping_One_Element() throws SQLException, ClassNotFoundException {

        //Arrange
        GuestDAO daoObject = new GuestDAOImpl();
        ArrayList<Guest> listGuests = daoObject.readAllData();

        //Act
        IDbColumnValidator countRows = new TblGuestColumnValidate();
        listGuests.remove(0);
        int countGuestListObjects = ((ArrayList) listGuests).size();
        int countGuestDataBase = countRows.getCountRow();

        //Assert
        assertNotEquals(countGuestListObjects, countGuestDataBase);

    }

    @Test
    public void testUpdateData() throws SQLException, ClassNotFoundException {

        //Arrange
        GuestDAO daoObject = new GuestDAOImpl();
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


    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException {

        GuestDAO test = new GuestDAOImpl();


        Assertions.assertThrows(SQLException.class, () -> {
            Guest test2 = (Guest) test.findOneData("ThisStringWillBeNeverInTheDataBaseISwearForeverForever1233213123123123", 1);
        });


    }

    @Test
    public void testInsertData_Name_And_idHouse_already_exists() throws SQLException, SQLiteException, ClassNotFoundException {

        GuestDAO test = new GuestDAOImpl();
        test.deleteData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);
        test.insertData(1, "Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd");

        Assertions.assertThrows(SQLiteException.class, () -> {
            test.insertData(1, "Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd");
        });

    }

    @Test
    public void testDeleteData_Should_be_Deleting_A_DatabaseObject() throws SQLException, SQLiteException, ClassNotFoundException {

        GuestDAO test = new GuestDAOImpl();
        test.deleteData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);
        test.insertData(1, "Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd");
        Guest firstTry = (Guest) test.findOneData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd", 1);

        assertNotNull(firstTry);

        test.deleteData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd",1);

        Assertions.assertThrows(SQLException.class, () -> {
            test.findOneData("Hannnnnnnnnnnnaaaaahhhhhhhhhdhdhd",1);
        });

    }

    @Test
    public void testFindAllDataWhereHouseID() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        aHouse.deleteData("Test2222");
        aHouse.insertData("Test2222", 800.00, 600.00);
        int id_house = aHouse.findOneData("Test2222").getPK_id();

        GuestDAO aGuest = new GuestDAOImpl();
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
 **/

}