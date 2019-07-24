package com.wachs.main.dataAccess.dataAccessConfigurations.DDL;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class DropAndCreateTableDB {

    private Statement st;
    private StringBuffer queryCreateTableCommands;
    private DBConnection connection;

    public DropAndCreateTableDB() {

        queryCreateTableCommands = new StringBuffer();
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

        JOptionPane.showMessageDialog(null,"Die Datenbank wurde gelöscht und neu aufgesetzt");
    }

    private String getSQLScriptFilePath() {
        String absPath = new File("").getAbsolutePath();
        return absPath + "//sources//database/CREATE_TABLE.sql";
    }
}