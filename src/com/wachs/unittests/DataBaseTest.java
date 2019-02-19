package com.wachs.unittests;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DataBaseTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testDatabaseConnection() {

        Connection dbConnection = DbConnection.getConnection();
        assertNotNull(dbConnection);
    }

    @Test
    public void testIsColumnOrderValidate_TblGuest() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblGuestColumnValidate();
        boolean IsValidate = ((TblGuestColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblExpense() throws ClassNotFoundException, SQLException{

        IDbColumnValidator isValidate = new TblOtherExpenseColumnValidate();
        boolean IsValidate = ((TblOtherExpenseColumnValidate) isValidate).getIsColumnTitleOrderValidate();

         assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblDrinks() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblStayColumnValidate();
        boolean IsValidate = ((TblStayColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblFood() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblFoodColumnValidate();
        boolean IsValidate = ((TblFoodColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblHouse() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblHouseColumnValidate();
        boolean IsValidate = ((TblHouseColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblStay() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblStayColumnValidate();
        boolean IsValidate = ((TblStayColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void TestIsColumnOrderValidate_TblPrepaid() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblPrepaidColumnValidate();
        boolean IsValidate = isValidate.getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblDrinksExpenses() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblDrinksExpensesColumnValidate();
        boolean IsValidate =  isValidate.getIsColumnTitleOrderValidate();

            assertTrue(IsValidate);
    }

    @Test
    public void testIsColumnOrderValidate_TblFoodExpenses() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblFoodExpensesColumnValidate();
        boolean IsValidate =  isValidate.getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }

}