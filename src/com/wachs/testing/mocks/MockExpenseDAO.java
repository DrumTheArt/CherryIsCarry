package com.wachs.testing.mocks;

import com.wachs.main.businessObjects.Expense;
import com.wachs.main.dataAcess.DAO.ExpenseDAO;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorExpense;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorExpense.*;

public class MockExpenseDAO implements ExpenseDAO {
    private Statement statement;
    private ArrayList<Expense> allDataList;
    private Expense aExpense;
    private ArrayList<Expense> AllExpensesSearchedGuests;

    public MockExpenseDAO() {

        aExpense = new Expense();
        allDataList = new ArrayList<Expense>();
        AllExpensesSearchedGuests = new ArrayList<Expense>();
    }

    @Override
    public ArrayList<Expense> fineAllDataToOneGuest(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException {

        statement = DbTestConnection.getConnection().createStatement();
        QueryGeneratorExpense query = new QueryGeneratorExpense();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

        while (result.next()) {
            AllExpensesSearchedGuests.add(new Expense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));
        }

        statement.close();
        result.close();
        DbTestConnection.closeConnection();

        return AllExpensesSearchedGuests;

    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense query = new QueryGeneratorExpense();
        statement = DbTestConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Expense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));
        }

        statement.close();
        result.close();
        DbTestConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void deleteData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house, price, reason, when));

        statement.close();
        DbTestConnection.closeConnection();

    }

    @Override
    public void updateData(int id_guest, int id_house, double price, String reason, String when, double newPrice, String newReason, String newWhen) throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbTestConnection.getConnection().createStatement();

        statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, price, reason, when, newPrice, newReason, newWhen));

        statement.close();
        DbTestConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, price, reason, when));

        statement.close();
        DbTestConnection.closeConnection();

    }

}
