package com.wachs.testing.dbTestConfig;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DDL.ITableDBScript;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValuesDBTestData implements ITableDBScript {

    private Statement st;
    private StringBuffer queryInsertValueCommands;

    public InsertValuesDBTestData() {

        queryInsertValueCommands = new StringBuffer();
    }


    public void executeQuery() throws IOException, SQLException, ClassNotFoundException {

        File createScript = new File(getSQLScriptFilePath());

        BufferedReader reader = new BufferedReader(new FileReader(createScript));

        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
                queryInsertValueCommands.append(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally
        {
            reader.close();
        }

        st = DbConnection.getConnection().createStatement();
        st.executeUpdate(String.valueOf(queryInsertValueCommands));
        st.close();
        DbConnection.closeConnection();

        JOptionPane.showMessageDialog(null,"Die Datenbank wurde mit Testdaten geladen");

    }

    private String getSQLScriptFilePath() {

        String absPath = new File("").getAbsolutePath();
        return absPath + "//sources//testdatabase/INSERT_INTO.sql";
    }

}

