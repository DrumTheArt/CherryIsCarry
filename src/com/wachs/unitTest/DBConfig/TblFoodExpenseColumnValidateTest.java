package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblFoodExpenseColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblFoodExpenseColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblFoodExpense() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblFoodExpenseColumnValidate();
        boolean IsValidate = isValidate.getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}
