package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.IDbColumnValidator;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation.TblProjectColumnValidate;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TblProjectColumnValidateTest {

    @Test
    public void testIsColumnOrderValidate_TblProject() throws ClassNotFoundException, SQLException {

        IDbColumnValidator isValidate = new TblProjectColumnValidate();
        boolean IsValidate = ((TblProjectColumnValidate) isValidate).getIsColumnTitleOrderValidate();

        assertTrue(IsValidate);
    }
}
