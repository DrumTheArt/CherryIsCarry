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
    public ArrayList fineAllDataToOneGuest(int id_guest, int id_house) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

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
    public ArrayList readAllData() {

        QueryGeneratorExpense query = new QueryGeneratorExpense();
        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryReadAllData());

            //Log the query
            ApplicationLogger.loggingQueries(query.queryReadAllData());

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
    public void deleteData(int id_guest, int id_house, double price, String reason, String when) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryDeleteData(id_guest, id_house, price, reason, when));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house, price, reason, when));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateData(int id_guest, int id_house, double price, String reason, String when, double newPrice, String newReason, String newWhen) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryUpdateData(id_guest, id_house, price, reason, when, newPrice, newReason, newWhen));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdateData(id_guest, id_house, price, reason, when, newPrice, newReason, newWhen));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertData(int id_guest, int id_house, double price, String reason, String when) {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryInsertData(id_guest, id_house, price, reason, when));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryInsertData(id_guest, id_house, price, reason, when));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
