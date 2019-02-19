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

public class DrinksExpensesDAOImpl implements FoodExpensesDAO {

    private Statement statement;
    private ArrayList<DrinksExpense> allDrinksExpensesAllGuests;
    private ArrayList<DrinksExpense> allDrinksExpensesSearchedGuests;

    public DrinksExpensesDAOImpl() {

        allDrinksExpensesAllGuests = new ArrayList<DrinksExpense>();
        allDrinksExpensesSearchedGuests = new ArrayList<DrinksExpense>();
    }

    @Override
    public ArrayList findDrinksExpensesByOneGuest(int idGuest, int idProject) {


        QueryGeneratorDrinksExpenses query = new QueryGeneratorDrinksExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindDrinksExpensesByOneGuest(idGuest, idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allDrinksExpensesSearchedGuests.add(new DrinksExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
            }

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

        QueryGeneratorDrinksExpenses query = new QueryGeneratorDrinksExpenses();
        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindAllDrinksExpensesByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allDrinksExpensesAllGuests.add(new DrinksExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDrinksExpensesAllGuests;
    }

    @Override
    public void deleteDrinksExpensesForOneGuest(int idGuest, int idProject, double spend) {

        QueryGeneratorDrinksExpenses query = new QueryGeneratorDrinksExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryDeleteDrinksExpensesForOneGuest(idGuest, idProject, spend);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDrinksExpensesForOneGuest(int idGuest, int idProject, double oldSpendValue, double newSpendValue) {

        QueryGeneratorDrinksExpenses query = new QueryGeneratorDrinksExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryUpdateDrinksExpensesForOneGuest(idGuest, idProject, oldSpendValue, newSpendValue);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertDrinksExpensesForOneGuest(int idGuest, int IdProject, double spend) {

        QueryGeneratorDrinksExpenses query = new QueryGeneratorDrinksExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryInsertDrinksExpensesForOneGuest(idGuest, IdProject, spend);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
