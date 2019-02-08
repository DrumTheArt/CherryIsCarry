package com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection;

import com.wachs.main.dataAcess.dataAccessConfigurations.DBConfig.DataBaseSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {


    private static Connection connection;

    public static Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DataBaseSource.getDataBaseLink());

            //Activate Foreign-Key Support on each call (not supported by SQLite ... if you change DBMS, you have to delete this)
            connection.createStatement().execute("PRAGMA foreign_keys = ON");

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        return connection;
    }

    public static void closeConnection() {

        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
