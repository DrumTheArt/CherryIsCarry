package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblOtherExpenseColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblExpenseColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblExpense() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblOtherExpenseColumnValidate();
        boolean IsValidate = ((TblOtherExpenseColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}