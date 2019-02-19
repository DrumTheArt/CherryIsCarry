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

    private Statement statement;
    private ArrayList<FoodExpense> allFoodExpensesAllGuests;
    private ArrayList<FoodExpense> allFoodExpensesSearchedGuests;

    public FoodExpensesDAOImpl() {

        allFoodExpensesAllGuests = new ArrayList<FoodExpense>();
        allFoodExpensesSearchedGuests = new ArrayList<FoodExpense>();
    }

    @Override
    public ArrayList findFoodExpensesByOneGuest(int idGuest, int idProject) {


        QueryGeneratorFoodExpenses query = new QueryGeneratorFoodExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindFoodExpensesByOneGuest(idGuest, idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allFoodExpensesSearchedGuests.add(new FoodExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allFoodExpensesSearchedGuests;


    }

    @Override
    public ArrayList findAllFoodExpensesByOneProject(int idProject) {

        QueryGeneratorFoodExpenses query = new QueryGeneratorFoodExpenses();
        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindAllFoodExpensesByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allFoodExpensesAllGuests.add(new FoodExpense(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allFoodExpensesAllGuests;
    }

    @Override
    public void deleteFoodExpensesForOneGuest(int idGuest, int idProject, double spend) {

        QueryGeneratorFoodExpenses query = new QueryGeneratorFoodExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryDeleteFoodExpensesForOneGuest(idGuest, idProject, spend);
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
    public void updateFoodExpensesForOneGuest(int idGuest, int idProject, double oldSpendValue, double newSpendValue) {

        QueryGeneratorFoodExpenses query = new QueryGeneratorFoodExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryUpdateFoodExpensesForOneGuest(idGuest, idProject, oldSpendValue, newSpendValue);
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
    public void insertFoodExpensesForOneGuest(int idGuest, int IdProject, double spend) {

        QueryGeneratorFoodExpenses query = new QueryGeneratorFoodExpenses();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryInsertFoodExpensesForOneGuest(idGuest, IdProject, spend);
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
