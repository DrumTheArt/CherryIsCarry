package com.wachs.test.unitTests;

import com.wachs.main.businessLayer.Expense;
import com.wachs.main.dataBaseLayer.DAO.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ExpenseDAOTest {


    /**
    @Test
    public void testDataBaseCall_Should_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        ExpenseDAO aExpense = new ExpenseDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        double price_expected = aExpense.findOneData(idGuest, pkHouse).getREAL_price();
        double price_setted = 300.00;

        //Assert
        assertEquals(price_expected,price_setted);

    }



    @Test
    public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        ExpenseDAO aExpense = new ExpenseDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        String reasonDBValue = aExpense.findOneData(idGuest, pkHouse).getTXT_name();
        String reasonUnequalDBValue = "Einkaufen1";

        //Assert
        assertNotEquals(reasonDBValue,reasonUnequalDBValue);

    }



    @Test
    public void testDeletedDataBaseValue_Should_Throw_SQLException() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        ExpenseDAO aExpense = new ExpenseDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        aExpense.deleteData(idGuest,pkHouse);

        /**
        //Assert
        Assertions.assertThrows(SQLException.class, () -> {
            aExpense.findOneData(idGuest,pkHouse);
        });


    }


    @Test
    public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        ExpenseDAO aExpense = new ExpenseDAOImpl();
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


    /**
    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        ExpenseDAO aExpense = new ExpenseDAOImpl();


        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);

        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aExpense.insertData(idGuest, pkHouse, 300.00, "Einkaufen", "28/04/2013");
        aExpense.updateData(idGuest, pkHouse, 60.0,"newReason","03/04/2018");
        double newPrepaidAmount = 60.0;
        double oldPrepaidAmount = aExpense.findOneData(idGuest,pkHouse).getREAL_price();

        //Assert
        assertEquals(newPrepaidAmount, oldPrepaidAmount);


    }


**/
}