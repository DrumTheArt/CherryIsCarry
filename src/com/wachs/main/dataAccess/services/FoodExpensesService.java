package com.wachs.main.dataAccess.services;

import com.wachs.main.POJO.FoodExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.exceptions.NotInDataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses.*;

public class FoodExpensesService implements IFoodExpensesService {

    private ArrayList<FoodExpense> allFoodExpensesAllGuests;
    private ArrayList<FoodExpense> allFoodExpensesSearchedGuests;
    private QueryGeneratorFoodExpenses query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public FoodExpensesService() {

        allFoodExpensesAllGuests = new ArrayList<>();
        allFoodExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorFoodExpenses();
        connection = new DBConnection();
        isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public FoodExpensesService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        allFoodExpensesAllGuests = new ArrayList<>();
        allFoodExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorFoodExpenses();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public ArrayList fetchFoodExpensesOneGuest(int idGuest, int idProject) {

        allFoodExpensesSearchedGuests.clear();
        try {

            String queryCommand = query.fetchFoodExpensesOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allFoodExpensesSearchedGuests.add(new FoodExpense(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

            }

            if(allFoodExpensesSearchedGuests.isEmpty()){

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

        return allFoodExpensesSearchedGuests;
    }

    @Override
    public ArrayList fetchAllFoodExpensesOneProject(int idProject) {

        allFoodExpensesAllGuests.clear();

        try {

            String queryCommand = query.fetchAllFoodExpensesOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allFoodExpensesAllGuests.add(new FoodExpense(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

            }

            if(allFoodExpensesAllGuests.isEmpty()){

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

        return allFoodExpensesAllGuests;
    }

    @Override
    public void deleteFoodExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            int pk_id = getPrimaryKeyofASingleRowIfAllDataAreTheSame(idGuest, idProject, spend, reason, when);

            String queryCommand = query.deleteFoodExpensesOneGuest(idGuest, idProject, pk_id);
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
    public void updateFoodExpensesOneGuest(int idGuest, int idProject, double newPrice, String newReason, String newWhen, double oldPrice, String oldReason, String oldWhen) {

        try {

            int pk_id = getPrimaryKeyofASingleRowIfAllDataAreTheSame(idGuest, idProject, oldPrice, oldReason, oldWhen);

            String queryCommand = query.updateQueryFoodExpensesOneGuest(idGuest, idProject, pk_id, newPrice, newReason, newWhen);
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
    public void insertFoodExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.insertQueryFoodExpensesOneGuest(idGuest, idProject, spend, reason, when);
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

        ArrayList<FoodExpense> foodExpenses = this.fetchFoodExpensesOneGuest(idGuest, idProject);
        ArrayList<Integer> listOfPrimaryKeys = new ArrayList<>();

        for (int i = 0; i < foodExpenses.size(); i++) {

            if ((foodExpenses.get(i).getSpend() == price) && (foodExpenses.get(i).getReason().equals(reason)) && (foodExpenses.get(i).getWhen().equals(when))) {

                listOfPrimaryKeys.add(foodExpenses.get(i).getPrimaryKey());

            }
        }

        return listOfPrimaryKeys.get(0);
    }
}