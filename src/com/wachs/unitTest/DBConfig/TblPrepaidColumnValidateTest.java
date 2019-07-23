package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblPrepaidColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblPrepaidColumnValidateTest {

    @Test
    public void TestIsColumnOrderValidate_TblPrepaid() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblPrepaidColumnValidate();
        boolean IsValidate = isValidate.getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}