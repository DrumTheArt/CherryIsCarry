package com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection;

import java.sql.Connection;

public class TestDBConnection implements IdbConnection{

    @Override
    public Connection getConnection() {

        return null;
    }

    @Override
    public void closeConnection() {

    }
}
