package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblStayColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblStayColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblStay() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblStayColumnValidate();
        boolean IsValidate = ((TblStayColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}