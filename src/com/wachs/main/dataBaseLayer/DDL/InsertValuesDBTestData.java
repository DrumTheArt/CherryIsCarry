package com.wachs.main.dataBaseLayer.DDL;

import com.wachs.main.dataBaseLayer.DBConnection.DbConnection;

import javax.swing.*;
import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValuesDBTestData implements ITableDBScript {

    private Statement st;
    private StringBuffer queryInsertValueCommands;

    public InsertValuesDBTestData() throws SQLException, IOException, ClassNotFoundException {

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
        return absPath + "//DataBase/INSERT_INTO.sql";
    }

}

