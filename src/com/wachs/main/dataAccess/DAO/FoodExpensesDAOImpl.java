package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.FoodExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses.*;

public class FoodExpensesDAOImpl implements FoodExpensesDAO {

    private ArrayList<FoodExpense> allFoodExpensesAllGuests;
    private ArrayList<FoodExpense> allFoodExpensesSearchedGuests;
    private QueryGeneratorFoodExpenses query;
    private Statement statement;
    private ResultSet result;

    public FoodExpensesDAOImpl() {

        allFoodExpensesAllGuests = new ArrayList<>();
        allFoodExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorFoodExpenses();

    }

    @Override
    public ArrayList findFoodExpensesByOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.fetchFoodExpensesOneGuest(idGuest, idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allFoodExpensesSearchedGuests.add(new FoodExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allFoodExpensesSearchedGuests;
    }

    @Override
    public ArrayList findAllFoodExpensesByOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllFoodExpensesOneProject(idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allFoodExpensesAllGuests.add(new FoodExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allFoodExpensesAllGuests;
    }

    @Override
    public void deleteFoodExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.deleteFoodExpensesOneGuest(idGuest, idProject, spend, reason, when);
            statement = getSQLStatement();
            statement.executeUpdate(queryCommand);

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
    public void updateFoodExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when, double newSpend, String newReason, String newWhen) {

        try {

            String queryCommand = query.updateQueryFoodExpensesOneGuest(idGuest, idProject, spend, reason, when, newSpend, newReason, newWhen);
            statement = getSQLStatement();
            statement.executeUpdate(queryCommand);

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
    public void insertFoodExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.insertQueryFoodExpensesOneGuest(idGuest, idProject, spend, reason, when);
            statement = getSQLStatement();
            statement.executeUpdate(queryCommand);

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

    private void closingAllConnections() throws SQLException {
        statement.close();
        result.close();
        DbConnection.closeConnection();
    }

    private Statement getSQLStatement() throws SQLException {
        return DbConnection.getConnection().createStatement();
    }
}