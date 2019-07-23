package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblDrinksExpensesColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblDrinksExpenseColumnValidationTest {

    @Test
    public void testIsColumnOrderValidate_TblDrinksExpenses() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblDrinksExpensesColumnValidate();
        boolean IsValidate = isValidate.getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}