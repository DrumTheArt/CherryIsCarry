package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblFoodColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblFoodColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblFood() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblFoodColumnValidate();
        boolean IsValidate = ((TblFoodColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}