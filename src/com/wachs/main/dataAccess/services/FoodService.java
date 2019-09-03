package com.wachs.main.dataAccess.services;

import com.wachs.main.POJO.Food;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFood;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.exceptions.NotInDataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay.*;

public class FoodService implements IFoodService {

    private ArrayList<Food> allFoodByOneProject;
    private Food aFood;
    private QueryGeneratorFood query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public FoodService() {

        aFood = new Food();
        allFoodByOneProject = new ArrayList<>();
        query = new QueryGeneratorFood();
        connection = new DBConnection();
        isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public FoodService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        aFood = new Food();
        allFoodByOneProject = new ArrayList<>();
        query = new QueryGeneratorFood();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public Food fetchFoodByOneGuest(int IdGuest, int idProject) {

        try {

            String queryCommand = query.fetchQueryFoodOneGuest(IdGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {

            int FK_id = queryResult.getInt(1);
            int nights = queryResult.getInt(2);

            createFoodObject(IdGuest, idProject, FK_id, nights);

            } else {

                throw new NotInDataBaseException();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aFood;
    }

    @Override
    public ArrayList fetchAllFoodByOneProject(int idProject) {

        allFoodByOneProject.clear();
        
        try {

            String queryCommand = query.fetchAllQueryFoodOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allFoodByOneProject.add(new Food(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

            if(allFoodByOneProject.isEmpty()){

                throw new NotInDataBaseException();
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

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

            queryStatement.close();

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

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
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

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
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private void createFoodObject(int IdGuest, int idProject, int FK_id, int nights) {
        aFood.setPrimaryKey(FK_id);
        aFood.setNights(nights);
        aFood.setGuestId(IdGuest);
        aFood.setProjectId(idProject);
    }


    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }
}