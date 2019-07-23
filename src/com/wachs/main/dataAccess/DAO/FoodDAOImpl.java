package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFood;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IdbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay.*;

public class FoodDAOImpl implements FoodDAO {

    private ArrayList<Food> allFoodByOneProject;
    private Food aFood;
    private QueryGeneratorFood query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IdbConnection connection;

    public FoodDAOImpl() {

        aFood = new Food();
        allFoodByOneProject = new ArrayList<>();
        query = new QueryGeneratorFood();
        connection = new DbConnection();

    }

    public FoodDAOImpl(Connection connectToTestDatabase) {

        aFood = new Food();
        allFoodByOneProject = new ArrayList<>();
        query = new QueryGeneratorFood();
        this.connection = new TestDBConnection();

    }

    @Override
    public Food fetchFoodByOneGuest(int IdGuest, int idProject) {

        try {

            String queryCommand = query.fetchQueryFoodOneGuest(IdGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            int FK_id = queryResult.getInt(1);
            int nights = queryResult.getInt(2);

            createFoodObject(IdGuest, idProject, FK_id, nights);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aFood;
    }

    @Override
    public ArrayList fetchAllFoodByOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllQueryFoodOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allFoodByOneProject.add(new Food(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allFoodByOneProject;
    }

    @Override
    public void updateFoodOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryFoodOneGuest(idGuest, idProject, newNights);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteFoodOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryFoodOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

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
    public void insertFoodOneGuest(int idGuest, int idProject, int nights) {

        try {

            String queryCommand = query.insertQueryFoodOneGuest(idGuest, idProject, nights);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

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

    private void createFoodObject(int IdGuest, int idProject, int FK_id, int nights) {
        aFood.setPK_id(FK_id);
        aFood.setNights(nights);
        aFood.setIdGuest(IdGuest);
        aFood.setIdProject(idProject);
    }


    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private void closingAllConnections() throws SQLException {

        queryStatement.close();
        queryResult.close();
        connection.closeConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }
}