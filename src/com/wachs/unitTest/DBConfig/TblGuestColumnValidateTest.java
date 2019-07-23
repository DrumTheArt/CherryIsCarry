package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblGuestColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblGuestColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblGuest() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblGuestColumnValidate();
        boolean IsValidate = ((TblGuestColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}