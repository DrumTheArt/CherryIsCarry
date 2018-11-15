package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.dataBaseLayer.DBConnection.DbConnection;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorExpense;
import com.wachs.main.businessLayer.Expense;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorExpense.*;

public class ExpenseDAOImpl implements ExpenseDAO {

    private Statement statement;
    private ArrayList<Expense> allDataList;
    private Expense aExpense;

    public ExpenseDAOImpl() {

        aExpense = new Expense();
        allDataList = new ArrayList<Expense>();
    }

    @Override
    public Expense findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        statement = DbConnection.getConnection().createStatement();
        QueryGeneratorExpense query = new QueryGeneratorExpense();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        double spend = result.getDouble(2);
        String TXT_name = result.getString(3);
        String when = result.getString(4);

        aExpense.setPK_id(FK_id);
        aExpense.setREAL_price(spend);
        aExpense.setTXT_name(TXT_name);
        aExpense.setWhen(when);
        aExpense.setId_guest(id_guest);
        aExpense.setId_house(id_house);

        result.close();
        statement.close();
        DbConnection.closeConnection();

        return aExpense;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense query = new QueryGeneratorExpense();
        statement = DbConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Expense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

        }

        statement.close();
        result.close();
        DbConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

        statement.close();
        DbConnection.closeConnection();

    }

    @Override
    public void updateData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbConnection.getConnection().createStatement();

        statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, price, reason, when));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException{

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, price, reason, when));

        statement.close();
        DbConnection.closeConnection();

    }

}
