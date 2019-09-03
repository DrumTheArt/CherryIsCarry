package com.wachs.tests.unitTest.DBConfig;

import com.wachs.main.DataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBValidation.TblStayColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblDrinksColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblDrinks() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblStayColumnValidate();
        boolean IsValidate = ((TblStayColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}