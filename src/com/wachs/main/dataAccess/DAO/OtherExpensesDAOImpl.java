package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Expense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorExpense;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorExpense.*;

public class OtherExpensesDAOImpl implements OtherExpensesDAO {

    private Statement statement;
    private ArrayList<Expense> AllExpensesAllGuests;
    private ArrayList<Expense> AllExpensesSearchedGuests;
    private Expense aExpense;

    public OtherExpensesDAOImpl() {

        aExpense = new Expense();
        AllExpensesAllGuests = new ArrayList<Expense>();
        AllExpensesSearchedGuests = new ArrayList<Expense>();
    }

    @Override
    public ArrayList findExpensesByOneGuest(int idGuest, int idProject) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindExpensesByOneGuest(idGuest, idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                AllExpensesSearchedGuests.add(new Expense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));
            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AllExpensesSearchedGuests;

    }

    @Override
    public ArrayList findAllExpensesByOneProject(int idProject) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();
        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindAllExpensesByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                AllExpensesAllGuests.add(new Expense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));
            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AllExpensesAllGuests;
    }

    @Override
    public void deleteExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryDeleteExpensesForOneGuest(idGuest, idProject, price, reason, when);
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
    public void updateExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryUpdateData(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
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
    public void insertExpensesForOneGuest(int idGuest, int IdProject, double price, String reason, String when) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryInsertData(idGuest, IdProject, price, reason, when);
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
