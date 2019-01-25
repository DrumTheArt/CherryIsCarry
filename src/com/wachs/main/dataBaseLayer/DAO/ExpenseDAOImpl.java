package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Expense;
import com.wachs.main.dataBaseLayer.DBConnection.DbConnection;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorExpense;
import com.wachs.main.dataBaseLayer.Util.ApplicationLogger;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorExpense.*;

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
    public ArrayList fineAllDataToOneGuest(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException {

        statement = DbConnection.getConnection().createStatement();
        QueryGeneratorExpense query = new QueryGeneratorExpense();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

        while (result.next()) {
            AllExpensesSearchedGuests.add(new Expense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));
        }

        statement.close();
        result.close();
        DbConnection.closeConnection();

        return AllExpensesSearchedGuests;

    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorExpense query = new QueryGeneratorExpense();
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

        return AllExpensesAllGuests;
    }

    @Override
    public void deleteData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryDeleteData(id_guest, id_house, price, reason, when));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house, price, reason, when));

        statement.close();
        DbConnection.closeConnection();

    }

    @Override
    public void updateData(int id_guest, int id_house, double price, String reason, String when, double newPrice, String newReason, String newWhen) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorExpense query = new QueryGeneratorExpense();

        statement = DbConnection.getConnection().createStatement();

        statement.executeUpdate(query.queryUpdateData(id_guest, id_house, price, reason, when, newPrice, newReason, newWhen));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryUpdateData(id_guest, id_house, price, reason, when, newPrice, newReason, newWhen));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorExpense query = new QueryGeneratorExpense();
        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryInsertData(id_guest, id_house, price, reason, when));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryInsertData(id_guest, id_house, price, reason, when));

        statement.close();
        DbConnection.closeConnection();

    }

}
