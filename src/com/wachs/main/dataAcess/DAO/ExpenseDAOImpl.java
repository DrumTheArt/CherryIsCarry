package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Expense;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorExpense;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorExpense.*;

public class ExpenseDAOImpl implements ExpenseDAO {

    private Statement statement;
    private ArrayList<Expense> AllExpensesAllGuests;
    private ArrayList<Expense> AllExpensesSearchedGuests;
    private Expense aExpense;

    public ExpenseDAOImpl() {

        aExpense = new Expense();
        AllExpensesAllGuests = new ArrayList<Expense>();
        AllExpensesSearchedGuests = new ArrayList<Expense>();
    }

    @Override
    public ArrayList findExpensesByOneGuest(int idGuest, int idProject) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindExpensesByOneGuest(idGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindExpensesByOneGuest(idGuest, idProject));

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
            ResultSet result = statement.executeQuery(query.queryFindAllExpensesByOneProject(idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindAllExpensesByOneProject(idProject));

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
            statement.executeUpdate(query.queryDeleteExpensesForOneGuest(idGuest, idProject, price, reason, when));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteExpensesForOneGuest(idGuest, idProject, price, reason, when));

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
            statement.executeUpdate(query.queryUpdateData(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdateData(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen));

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
            statement.executeUpdate(query.queryInsertData(idGuest, IdProject, price, reason, when));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryInsertData(idGuest, IdProject, price, reason, when));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}