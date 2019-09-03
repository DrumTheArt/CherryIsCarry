package com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection;

import java.sql.Connection;

public interface IDBConnection {

    Connection connection = null;
    Connection getConnection();
    void closeConnection();

}
