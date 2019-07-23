package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.OtherExpense;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorOtherExpenses;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorOtherExpenses.*;

public class OtherExpensesDAOImpl implements OtherExpensesDAO {

    private ArrayList<OtherExpense> allExpensesAllGuests;
    private ArrayList<OtherExpense> allExpensesSearchedGuests;
    private QueryGeneratorOtherExpenses query;
    private ResultSet result;
    private Statement statement;

    public OtherExpensesDAOImpl() {

        allExpensesAllGuests = new ArrayList<>();
        allExpensesSearchedGuests = new ArrayList<>();
        query = new QueryGeneratorOtherExpenses();

    }

    @Override
    public ArrayList findOtherExpensesByOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.fetchQueryOtherExpensesOneGuest(idGuest, idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allExpensesSearchedGuests.add(new OtherExpense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allExpensesSearchedGuests;
    }

    @Override
    public ArrayList findAllOtherExpensesByOneProject(int idProject) {

        try {

            String queryCommand = query.fetchQueryAllOtherExpensesOneProject(idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allExpensesAllGuests.add(new OtherExpense(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3), result.getString(COLUMN4), result.getInt(COLUMN5), result.getInt(COLUMN6)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allExpensesAllGuests;
    }

    @Override
    public void deleteOtherExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when) {

        try {

            String queryCommand = query.deleteQueryOtherExpensesOneGuest(idGuest, idProject, price, reason, when);
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
    public void updateOtherExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen) {

        try {

            String queryCommand = query.updateQueryOtherExpensesOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
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
    public void insertOtherExpensesForOneGuest(int idGuest, int IdProject, double price, String reason, String when) {

        try {

            String queryCommand = query.insertQueryOtherExpensesOneGuest(idGuest, IdProject, price, reason, when);
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

    private Statement getSQLStatement() throws SQLException {
        return DbConnection.getConnection().createStatement();
    }

    private void closingAllConnections() throws SQLException {
        statement.close();
        result.close();
        DbConnection.closeConnection();
    }

}