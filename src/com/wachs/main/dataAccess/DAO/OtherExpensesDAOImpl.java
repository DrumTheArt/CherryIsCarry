package com.wachs.main.dataAccess.DAO;

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

public class OtherExpensesDAOImpl implements OtherExpensesDAO {

    private ArrayList<OtherExpense> allExpensesAllGuests;
    private ArrayList<OtherExpense> allExpensesSearchedGuests;
    private QueryGeneratorOtherExpenses query;
    private ResultSet queryResult;
    private Statement queryStatement;
    private IDBConnection connection;

    public OtherExpensesDAOImpl() {

        allExpensesAllGuests = new ArrayList<>();
        allExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorOtherExpenses();
        connection = new DBConnection();

    }

    public OtherExpensesDAOImpl(IDBConnection connectToTestDatabase) {

        allExpensesAllGuests = new ArrayList<>();
        allExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorOtherExpenses();
        this.connection = connectToTestDatabase;

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
    public void deleteOtherExpensesOneGuest(int idGuest, int idProject, double price, String reason, String when) {

        try {

            String queryCommand = query.deleteQueryOtherExpensesOneGuest(idGuest, idProject, price, reason, when);
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
    public void updateOtherExpensesOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen) {

        try {

            String queryCommand = query.updateQueryOtherExpensesOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
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
    public void insertOtherExpensesOneGuest(int idGuest, int IdProject, double price, String reason, String when) {

        try {

            String queryCommand = query.insertQueryOtherExpensesOneGuest(idGuest, IdProject, price, reason, when);
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