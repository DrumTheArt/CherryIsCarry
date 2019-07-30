package com.wachs.main.dataAccess.DAO;

import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.DrinksExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
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
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public DrinksExpensesDAOImpl() {

        allDrinksExpensesAllGuests = new ArrayList<>();
        allDrinksExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorDrinksExpenses();
        connection = new DBConnection();
        isLoggerActivated = true;

    }

    public DrinksExpensesDAOImpl(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        allDrinksExpensesAllGuests = new ArrayList<>();
        allDrinksExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorDrinksExpenses();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

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

            if(allDrinksExpensesSearchedGuests.isEmpty()){

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

            if(allDrinksExpensesAllGuests.isEmpty()){

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

        return allDrinksExpensesAllGuests;
    }

    @Override
    public void deleteDrinksExpensesOneGuest(int idGuest, int idProject, int pk_id) {

        try {

            String queryCommand = query.deleteQueryDrinksExpensesOneGuest(idGuest, idProject, pk_id);
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

    public void updateDrinksExpensesOneGuest(int idGuest, int idProject, int pk_id, double newPrice, String newReason, String newWhen) {

        try {

            String queryCommand = query.updateQueryDrinksExpensesOneGuest(idGuest, idProject, pk_id, newPrice, newReason, newWhen);
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
    public void insertDrinksExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.insertQueryDrinksExpensesOneGuest(idGuest, idProject, spend, reason, when);
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
}