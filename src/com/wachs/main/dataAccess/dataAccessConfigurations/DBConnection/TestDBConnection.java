package com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection implements IdbConnection{

    public Connection getConnection() {

        return new ConnectionFactory().createTestDataBaseConnection();

    }

    public  void closeConnection() {

        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
