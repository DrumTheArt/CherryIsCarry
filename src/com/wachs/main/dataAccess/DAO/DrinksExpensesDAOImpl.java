package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.DrinksExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses.*;

public class DrinksExpensesDAOImpl implements DrinksExpensesDAO {

    private ArrayList<DrinksExpense> allDrinksExpensesAllGuests;
    private ArrayList<DrinksExpense> allDrinksExpensesSearchedGuests;
    private QueryGeneratorDrinksExpenses query;
    private Statement statement;
    private ResultSet result;

    public DrinksExpensesDAOImpl() {

        allDrinksExpensesAllGuests = new ArrayList<>();
        allDrinksExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorDrinksExpenses();

    }

    @Override
    public ArrayList findDrinksExpensesByOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.queryFindDrinksExpensesByOneGuest(idGuest, idProject);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allDrinksExpensesSearchedGuests.add(new DrinksExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksExpensesSearchedGuests;

    }

    @Override
    public ArrayList findAllDrinksExpensesByOneProject(int idProject) {

        try {

            String queryCommand = query.queryFindAllDrinksExpensesByOneProject(idProject);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allDrinksExpensesAllGuests.add(new DrinksExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksExpensesAllGuests;
    }

    @Override
    public void deleteDrinksExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.queryDeleteDrinksExpensesForOneGuest(idGuest, idProject, spend, reason, when);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateDrinksExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when, double newPrice, String newReason, String newWhen) {

        try {

            String queryCommand = query.queryUpdateDrinksExpensesForOneGuest(idGuest, idProject, spend, reason, when, newPrice, newReason, newWhen);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void insertDrinksExpensesForOneGuest(int idGuest, int idProject, double spend, String reason, String when) {

        try {

            String queryCommand = query.queryInsertDrinksExpensesForOneGuest(idGuest, idProject, spend, reason, when);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}