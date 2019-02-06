package com.wachs.main.dataAcess.dataAccessConfigurations.DBValidation;

import java.sql.SQLException;

public interface IDbColumnValidator {

    boolean getIsColumnTitleOrderValidate() throws SQLException, ClassNotFoundException;

    int getCountRow() throws SQLException, ClassNotFoundException;

}


