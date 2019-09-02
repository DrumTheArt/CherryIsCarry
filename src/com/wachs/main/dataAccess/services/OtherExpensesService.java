package com.wachs.main.dataAccess.services;

import com.wachs.main.exceptions.NotInDataBaseException;
import com.wachs.main.POJO.OtherExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorOtherExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorOtherExpenses.*;

public class OtherExpensesService implements IOtherExpensesService {

    private ArrayList<OtherExpense> allExpensesAllGuests;
    private ArrayList<OtherExpense> allExpensesSearchedGuests;
    private QueryGeneratorOtherExpenses query;
    private ResultSet queryResult;
    private Statement queryStatement;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public OtherExpensesService() {

        allExpensesAllGuests = new ArrayList<>();
        allExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorOtherExpenses();
        connection = new DBConnection();
        isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public OtherExpensesService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        allExpensesAllGuests = new ArrayList<>();
        allExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorOtherExpenses();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public ArrayList fetchOtherExpensesOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.fetchQueryOtherExpensesOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allExpensesSearchedGuests.add(new OtherExpense(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

            }

            if(allExpensesSearchedGuests.isEmpty()){

                throw new NotInDataBaseException();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allExpensesSearchedGuests;
    }

    @Override
    public ArrayList fetchAllOtherExpensesOneProject(int idProject) {

        try {

            String queryCommand = query.fetchQueryAllOtherExpensesOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allExpensesAllGuests.add(new OtherExpense(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

            }

            if(allExpensesAllGuests.isEmpty()){

                throw new NotInDataBaseException();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allExpensesAllGuests;
    }

    @Override
    public void deleteOtherExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            int pk_id = getPrimaryKeyofASingleRowIfAllDataAreTheSame(idGuest, idProject, spend, reason, when);

            String queryCommand = query.deleteQueryOtherExpensesOneGuest(idGuest, idProject, pk_id);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateOtherExpensesOneGuest(int idGuest, int idProject, double newPrice, String newReason, String newWhen, double oldPrice, String oldReason, String oldWhen) {

        try {

            int pk_id = getPrimaryKeyofASingleRowIfAllDataAreTheSame(idGuest, idProject, oldPrice, oldReason, oldWhen);

            String queryCommand = query.updateQueryOtherExpensesOneGuest(idGuest, idProject, pk_id, newPrice, newReason, newWhen);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void insertOtherExpensesOneGuest(int idGuest, int IdProject, double price, String reason, String when) {

        try {

            String queryCommand = query.insertQueryOtherExpensesOneGuest(idGuest, IdProject, price, reason, when);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    /**
     * Problem here: The DBMS of SQLite returns a successfull set, if the primaryKey is not given, but all the other parameters match
     * So if the listOfDrinksExpenses contains a guest with two excactly rows (means same reason, same when, same price), then this method will
     * find the PK of the table drinksExpenses ... this is neccessary to update, delete it
     **/
    private int getPrimaryKeyofASingleRowIfAllDataAreTheSame(int idGuest, int idProject, double price, String reason, String when) {

        ArrayList<OtherExpense> otherExpenses = this.fetchOtherExpensesOneGuest(idGuest, idProject);
        ArrayList<Integer> listOfPrimaryKeys = new ArrayList<>();

        for (int i = 0; i < otherExpenses.size(); i++) {

            if ((otherExpenses.get(i).getSpend() == price) && (otherExpenses.get(i).getReason().equals(reason)) && (otherExpenses.get(i).getWhen().equals(when))) {

                listOfPrimaryKeys.add(otherExpenses.get(i).getPrimaryKey());

            }
        }

        return listOfPrimaryKeys.get(0);
    }

}