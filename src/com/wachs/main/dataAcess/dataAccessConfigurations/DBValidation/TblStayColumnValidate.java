package com.wachs.main.dataAcess.dataAccessConfigurations.DBValidation;

import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;

public class TblStayColumnValidate implements IDbColumnValidator {

    private Statement statement;
    private boolean TblColumnTitleOrderValidate = false;

    public TblStayColumnValidate() throws SQLException {

        TblColumnTitleOrderValidate = isColumnOrderValidate();

    }

    private boolean isColumnOrderValidate() throws SQLException {
        String query = "SELECT * FROM " + TABLENAME;
        statement = DbConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query);

        ResultSetMetaData rsmd = result.getMetaData();

        String column1 = rsmd.getColumnName(1);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 1: " + column1 + " im QueryGenerator: " + COLUMN1);

        String column2 = rsmd.getColumnName(2);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 2: " + column2 + " im QueryGenerator: " + COLUMN2);

        String column3 = rsmd.getColumnName(3);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 3: " + column3 + " im QueryGenerator: " + COLUMN3);

        String column4 = rsmd.getColumnName(4);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 4: " + column4 + " im QueryGenerator: " + COLUMN4);

        return COLUMN1.equals(column1) && COLUMN2.equals(column2) && COLUMN3.equals(column3) && COLUMN4.equals(column4);

    }

    public boolean getIsColumnTitleOrderValidate() {

        return TblColumnTitleOrderValidate;
    }

    public int getCountRow() throws SQLException, ClassNotFoundException {
        String query = "SELECT Count(*) FROM " + TABLENAME;
        ResultSet result = statement.executeQuery(query);
        int count = result.getInt(1);
        return count;
    }
}