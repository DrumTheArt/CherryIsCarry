package com.wachs.unitTest.DBConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void getConnection_ShouldBeNotNull() {

        Connection dbConnection = DbConnection.getConnection();
        assertNotNull(dbConnection);
    }
}