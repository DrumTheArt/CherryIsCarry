package com.wachs.main.dataAccess.dataAccessConfigurations.DBValidation;

import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses.*;

public class TblFoodExpenseColumnValidate implements IDbColumnValidator {

    private Statement statement;
    private boolean TblColumnTitleOrderValidate = false;
    private DBConnection connection = new DBConnection();

    public TblFoodExpenseColumnValidate() throws SQLException {

        TblColumnTitleOrderValidate = isColumnOrderValidate();

    }

    private boolean isColumnOrderValidate() throws SQLException {

        String query = "SELECT * FROM " + TABLENAME;
        statement = connection.getConnection().createStatement();
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

        String column5 = rsmd.getColumnName(5);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 5: " + column5 + " im QueryGenerator: " + COLUMN5);

        String column6 = rsmd.getColumnName(6);
        System.out.println("In DB " + TABLENAME + " heißt Spalte 6: " + column6 + " im QueryGenerator: " + COLUMN6);

        return COLUMN1.equals(column1) && COLUMN2.equals(column2) && COLUMN3.equals(column3) && COLUMN4.equals(column4) && COLUMN5.equals(column5) && COLUMN6.equals(column6);

    }

    public boolean getIsColumnTitleOrderValidate() {

        return TblColumnTitleOrderValidate;
    }

    public int getCountRow() throws SQLException {
        String query = "SELECT Count(*) FROM " + TABLENAME;
        ResultSet result = statement.executeQuery(query);
        int count = result.getInt(1);
        return count;
    }
}
