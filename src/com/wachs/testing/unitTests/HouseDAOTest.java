package com.wachs.testing.unitTests;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.DAO.GuestDAO;
import com.wachs.main.dataAcess.DAO.HouseDAO;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBValidation.TblGuestColumnValidate;
import com.wachs.testing.mocks.MockGuestDAO;
import com.wachs.testing.mocks.MockHouseDAO;
import org.junit.Test;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class HouseDAOTest {


    @Test
    public void testInsertData_Should_be_NotNull() throws SQLException, ClassNotFoundException, IOException {


        //Arrange
        HouseDAO toFindGuest = new MockHouseDAO();

        //Act
        toFindGuest.deleteData("NeuesHaus");
        toFindGuest.insertData("NeuesHaus", 300.0, 200.0);

        //Assert
        assertNotNull(toFindGuest);

    }


    @Test(expected = SQLException.class)
    public void testTwo_Equals_HouseObjects_Should_Not_Be_Allowed_toSave() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO toFindHouse = new MockHouseDAO();

        //Act

        toFindHouse.deleteData("NeuesHaus");
        toFindHouse.insertData("NeuesHaus", 300., 200.0);

        //Assert

        toFindHouse.insertData("NeuesHaus", 300.0, 200.0);
    }


    @Test
    public void testReadAllData_Should_BeNot_Same_Amount_when_Dropping_One_Element() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        GuestDAO daoObject = new MockGuestDAO();
        ArrayList<House> listHouse = daoObject.readAllData();

        //Act
        IDbColumnValidator countRows = new TblGuestColumnValidate();
        listHouse.remove(0);
        int countGuestListObjects = listHouse.size();
        int countGuestDataBase = countRows.getCountRow();

        //Assert
        assertNotEquals(countGuestListObjects, countGuestDataBase);

    }

    @Test
    public void testUpdateData() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO daoObject = new MockHouseDAO();
        daoObject.deleteData("NeuesHaus");
        daoObject.deleteData("NeuesHaus2");
        daoObject.insertData("NeuesHaus2", 300.0, 200.0);


        //Act
        String oldName = daoObject.findOneData("NeuesHaus2").getTXT_name();
        int oldPkId = daoObject.findOneData("NeuesHaus2").getPK_id();
        daoObject.updateData(oldPkId, "NeuesHaus", 200.00, 300.00);
        String newName = daoObject.findOneData("NeuesHaus").getTXT_name();
        int newPkId = daoObject.findOneData("NeuesHaus").getPK_id();

        //Assert
        assertEquals(oldPkId, newPkId);
        assertNotEquals(oldName, newName);

    }

    @Test(expected = SQLException.class)
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException, IOException {

        HouseDAO testing = new MockHouseDAO();

        House testDoNotConvertIfStringIsAllright = testing.findOneData("ThisStringWillBeNeverInTheDataBaseISwearForeverForever1233213123123123");
    }


    @Test(expected = SQLiteException.class)
    public void testInsertData_Name_And_idHouse_already_exists() throws SQLException, ClassNotFoundException, IOException {

        HouseDAO testing = new MockHouseDAO();
        testing.deleteData("NeuesHouse22222323");
        testing.insertData("NeuesHouse22222323", 300.0, 200.0);

        testing.insertData("NeuesHouse22222323", 300.0, 200.0);
    }


    @Test(expected = SQLException.class)
    public void testDeleteData_Should_be_Deleting_A_DatabaseObject() throws SQLException, ClassNotFoundException, IOException {

        HouseDAO testing = new MockHouseDAO();
        testing.deleteData("NeuesHaus");
        testing.insertData("NeuesHaus", 300.00, 200.00);
        House firstTry = testing.findOneData("NeuesHaus");

        assertNotNull(firstTry);
        testing.deleteData("NeuesHaus");
        testing.findOneData("NeuesHaus");
    }

}