package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Drinks;
import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorDrinks;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.Exceptions.NotInDataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorStay.*;

public class DrinksService implements IDrinksService {

    private ArrayList<Drinks> allDrinksOneProject;
    private Drinks singleDrink;
    private QueryGeneratorDrinks query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public DrinksService() {

        this.singleDrink = new Drinks();
        query = new QueryGeneratorDrinks();
        this.allDrinksOneProject = new ArrayList<>();
        this.connection = new DBConnection();
        isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public DrinksService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        this.singleDrink = new Drinks();
        query = new QueryGeneratorDrinks();
        this.allDrinksOneProject = new ArrayList<>();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    public Drinks fetchDrinksOneGuest(int idGuest, int idProject) {

        try {

            queryStatement = createSQLStatement();
            String queryCommand = query.fetchQueryOneGuest(idGuest, idProject);
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


            int FK_id = queryResult.getInt(1);
            int nights = queryResult.getInt(2);

            createDrinkObject(idGuest, idProject, FK_id, nights);

            }

            else {

                throw new NotInDataBaseException();

            }

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return singleDrink;
    }

    public ArrayList fetchAllDrinksOneProject(int idProject) {

        allDrinksOneProject.clear();

        try {

            String queryCommand = query.fetchAllOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                    allDrinksOneProject.add(new Drinks(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));
            }

            if(allDrinksOneProject.isEmpty()){

                throw new NotInDataBaseException();
            }

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksOneProject;
    }

    public void updateDrinksOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryForOneGuest(idGuest, idProject, newNights);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            if (isLoggerActivated) {
                //Log the query
                ApplicationLogger.loggingQueries(queryCommand);
            }

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteDrinksOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void insertDrinksOneGuest(int idGuest, int idProject, int nights) {

        try (Statement statement = createSQLStatement()) {

            String queryCommand = query.insertQueryOneGuest(idGuest, idProject, nights);
            statement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    private void createDrinkObject(int idGuest, int idProject, int FK_id, int nights) {

            singleDrink.setPrimaryKey(FK_id);
            singleDrink.setNights(nights);
            singleDrink.setGuestId(idGuest);
            singleDrink.setProjectId(idProject);
        }
}