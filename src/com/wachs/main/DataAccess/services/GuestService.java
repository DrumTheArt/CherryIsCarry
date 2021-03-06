package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Guest;
import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorGuest;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.DataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;
import com.wachs.main.Exceptions.NotInDataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorGuest.*;

public class GuestService implements IGuestService {

    private ArrayList<Guest> allGuestByOneProject;
    private Guest aGuest;
    private ConverterStringForDataBase convertString;
    private QueryGeneratorGuest query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public GuestService() {

        aGuest = new Guest();
        allGuestByOneProject = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorGuest();
        connection = new DBConnection();
        isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public GuestService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        aGuest = new Guest();
        allGuestByOneProject = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorGuest();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public Guest fetchOneGuestOneProject(String name, int idHouse) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        try {

            String queryCommand = query.fetchQueryOneGuestOneProject(name, idHouse);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


                //Get db-attributes
                int PK_id = queryResult.getInt(1);
                int idProject = queryResult.getInt(2);
                String guestName = queryResult.getString(3);

                //Set db-attributes into GuestObject
                createGuestObject(PK_id, idProject, guestName);

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

        return aGuest;
    }

    @Override
    public ArrayList fetchAllGuestsOneProject(int idProject) {

        allGuestByOneProject.clear();

        try {

            String queryCommand = query.fetchQueryAllGuestsOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allGuestByOneProject.add(new Guest(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getString(COLUMN3)));

            }

            if(allGuestByOneProject.isEmpty()){

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

        return allGuestByOneProject;
    }

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    @Override
    public void insertGuestOneProject(int idProject, String guestName) {

        //Set firstLetter to upperCase and set last to lowerLetters
        guestName = convertString.convertString(guestName);

        try {

            String queryCommand = query.insertQueryGuestOneProject(guestName, idProject);
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
    public void updateGuestOneProject(int oldId, String guestName, int idProject) {

        //Set firstLetter to upperCase and set last to lowerLetters
        guestName = convertString.convertString(guestName);

        try {

            String queryCommand = query.updateQueryGuestOneProject(oldId, guestName, idProject);
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
    public void deleteGuestOneProject(String guestName, int idProject) {


        //Set firstLetter to upperCase and set last to lowerLetters
        guestName = convertString.convertString(guestName);

        try {

            String queryCommand = query.deleteQueryGuestOneProject(guestName, idProject);
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

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    private void createGuestObject(int PK_id, int idProject, String guestName) {
        aGuest.setPrimaryKey(PK_id);
        aGuest.setProjectId(idProject);
        aGuest.setGuestName(guestName);
    }
}