package com.wachs.testing.unitTests;

import com.wachs.main.businessLayer.Expense;
import com.wachs.main.dataBaseLayer.DAO.ExpenseDAO;
import com.wachs.main.dataBaseLayer.DAO.GuestDAO;
import com.wachs.main.dataBaseLayer.DAO.HouseDAO;
import com.wachs.testing.mocks.MockExpenseDAO;
import com.wachs.testing.mocks.MockGuestDAO;
import com.wachs.testing.mocks.MockHouseDAO;
import org.junit.Test;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExpenseDAOTest {

    @Test
    public void testDataBaseCall_Should_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        ExpenseDAO aExpense = new MockExpenseDAO();

        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        double price_expected = 0;
        double price_setted = 300.00;
        ArrayList<Expense> listOfExepenses = aExpense.fineAllDataToOneGuest(idGuest, pkHouse);

        for (Expense e : listOfExepenses) {

            if (e.getTXT_reason().equals("Einkaufen")) {
                price_expected = e.getREAL_price();
            }
        }

        //Assert
        assertEquals(price_expected, price_setted, 0.0001);

    }

    @Test
    public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        ExpenseDAO aExpense = new MockExpenseDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        String reasonDBValue = null;

        ArrayList<Expense> listOfExepenses = aExpense.fineAllDataToOneGuest(idGuest, pkHouse);

        String reasonUnequalDBValue = "Einkaufen1";

        for (Expense e : listOfExepenses) {

            if (e.getTXT_reason().equals("Einkaufen")) {
                reasonDBValue = e.getTXT_reason();
            }
        }

        //Assert
        assertNotEquals(reasonDBValue,reasonUnequalDBValue);

    }

    @Test
    public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException, IOException {

        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        ExpenseDAO aExpense = new MockExpenseDAO();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");

        //Assert
        ArrayList<Expense> listOfDrinks = new ArrayList<Expense>();
        listOfDrinks = aExpense.readAllData();
        assertNotNull(listOfDrinks.get(0));

    }

    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException, IOException {


        //Arrange
        HouseDAO aHouse = new MockHouseDAO();
        GuestDAO aGuest = new MockGuestDAO();
        ExpenseDAO aExpense = new MockExpenseDAO();

        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);

        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        aExpense.updateData(idGuest, pkHouse, 300.0, "Einkaufen", "28/04/2013", 60.0, "newReason", "03/04/2018");
        double newPrepaidAmount = 60.0;
        double oldPrepaidAmount = 0;


        ArrayList<Expense> getRowFromDataBase = aExpense.fineAllDataToOneGuest(idGuest,pkHouse);


        for (Expense e : getRowFromDataBase) {

            if (e.getTXT_reason().equals("newReason")) {
                oldPrepaidAmount = e.getREAL_price();
            }
        }

        //Assert
        assertEquals(newPrepaidAmount, oldPrepaidAmount, 0.00001);


    }

}