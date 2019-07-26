package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.FoodExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses.*;

public class FoodExpensesDAOImpl implements FoodExpensesDAO {

    private ArrayList<FoodExpense> allFoodExpensesAllGuests;
    private ArrayList<FoodExpense> allFoodExpensesSearchedGuests;
    private QueryGeneratorFoodExpenses query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;

    public FoodExpensesDAOImpl() {

        allFoodExpensesAllGuests = new ArrayList<>();
        allFoodExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorFoodExpenses();
        connection = new DBConnection();

    }

    public FoodExpensesDAOImpl(IDBConnection connectToTestDatabase) {

        allFoodExpensesAllGuests = new ArrayList<>();
        allFoodExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorFoodExpenses();
        this.connection = connectToTestDatabase;

    }

    @Override
    public ArrayList fetchFoodExpensesOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.fetchFoodExpensesOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allFoodExpensesSearchedGuests.add(new FoodExpense(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

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

        try {

            String queryCommand = query.fetchAllFoodExpensesOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allFoodExpensesAllGuests.add(new FoodExpense(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

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

            String queryCommand = query.deleteFoodExpensesOneGuest(idGuest, idProject, spend, reason, when);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

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
    public void updateFoodExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when, double newSpend, String newReason, String newWhen) {

        try {

            String queryCommand = query.updateQueryFoodExpensesOneGuest(idGuest, idProject, spend, reason, when, newSpend, newReason, newWhen);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

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
            ApplicationLogger.loggingQueries(queryCommand);

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
}