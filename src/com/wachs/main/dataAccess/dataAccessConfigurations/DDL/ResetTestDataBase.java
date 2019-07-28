package com.wachs.main.dataAccess.dataAccessConfigurations.DDL;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetTestDataBase {

    private Statement st;
    private StringBuffer queryCreateTableCommands;
    private IDBConnection connection;

    public ResetTestDataBase() {

        queryCreateTableCommands = new StringBuffer();
        connection = new TestDBConnection();
    }

    public void executeQuery() throws IOException, SQLException, ClassNotFoundException {

        File createScript = new File(getSQLScriptFilePath());

        BufferedReader reader = new BufferedReader(new FileReader(createScript));

        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
                queryCreateTableCommands.append(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally
        {
            reader.close();
        }

        st = connection.getConnection().createStatement();
        st.executeUpdate(String.valueOf(queryCreateTableCommands));
        st.close();
        connection.closeConnection();

        JOptionPane.showMessageDialog(null,"Die Test-Datenbank wurde gelöscht und neu aufgesetzt");
    }

    private String getSQLScriptFilePath() {
        String absPath = new File("").getAbsolutePath();
        return absPath + "//sources//testDatabase/CREATE_TABLE.sql";
    }
}