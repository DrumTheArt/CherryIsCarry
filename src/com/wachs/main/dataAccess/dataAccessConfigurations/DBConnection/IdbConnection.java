package com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection;

import java.sql.Connection;

public interface IdbConnection {

    Connection connection = null;
    Connection getConnection();
    void closeConnection();

}
