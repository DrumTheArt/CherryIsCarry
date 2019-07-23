package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Drinks;
import com.wachs.main.POJO.DrinksExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinks;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IdbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses.*;

public class DrinksExpensesDAOImpl implements DrinksExpensesDAO {

    private ArrayList<DrinksExpense> allDrinksExpensesAllGuests;
    private ArrayList<DrinksExpense> allDrinksExpensesSearchedGuests;
    private QueryGeneratorDrinksExpenses query;
    private Statement queryStatement;
    private ResultSet queryResult;
    IdbConnection connection;

    public DrinksExpensesDAOImpl() {

        allDrinksExpensesAllGuests = new ArrayList<>();
        allDrinksExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorDrinksExpenses();
        connection = new DbConnection();

    }

    public DrinksExpensesDAOImpl(Connection connectToTestDatabase) {

        allDrinksExpensesAllGuests = new ArrayList<>();
        allDrinksExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorDrinksExpenses();
        this.connection = new TestDBConnection();

    }

    @Override
    public ArrayList fetchDrinksExpensesOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.fetchDrinksExpensesOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allDrinksExpensesSearchedGuests.add(new DrinksExpense(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksExpensesSearchedGuests;

    }

    @Override
    public ArrayList fetchAllDrinksExpensesOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllQueryDrinksExpensesOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allDrinksExpensesAllGuests.add(new DrinksExpense(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getString(COLUMN3), queryResult.getString(COLUMN4), queryResult.getInt(COLUMN5), queryResult.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksExpensesAllGuests;
    }

    @Override
    public void deleteDrinksExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.deleteQueryDrinksExpensesOneGuest(idGuest, idProject, spend, reason, when);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateDrinksExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when, double newPrice, String newReason, String newWhen) {

        try {

            String queryCommand = query.updateQueryDrinksExpensesOneGuest(idGuest, idProject, spend, reason, when, newPrice, newReason, newWhen);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void insertDrinksExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.insertQueryDrinksExpensesOneGuest(idGuest, idProject, spend, reason, when);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private void closingAllConnections() throws SQLException {

        queryStatement.close();
        queryResult.close();
        connection.closeConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }
}