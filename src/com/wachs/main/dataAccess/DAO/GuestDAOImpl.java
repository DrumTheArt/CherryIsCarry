package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Guest;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorGuest;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;
import java.sql.*;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorGuest.*;

public class GuestDAOImpl implements GuestDAO {

    private ArrayList<Guest> allGuestByOneProject;
    private Guest aGuest;
    private ConverterStringForDataBase convertString;
    private QueryGeneratorGuest query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;

    public GuestDAOImpl() {

        aGuest = new Guest();
        allGuestByOneProject = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorGuest();
        connection = new DBConnection();

    }

    public GuestDAOImpl(IDBConnection connectToTestDatabase) {

        aGuest = new Guest();
        allGuestByOneProject = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorGuest();
        this.connection = connectToTestDatabase;

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

        try {

            String queryCommand = query.fetchQueryAllGuestsOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allGuestByOneProject.add(new Guest(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getString(COLUMN3)));

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
            ApplicationLogger.loggingQueries(queryCommand);

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
            ApplicationLogger.loggingQueries(queryCommand);

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
            ApplicationLogger.loggingQueries(queryCommand);

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
        aGuest.setPK_id(PK_id);
        aGuest.setIdProject(idProject);
        aGuest.setGuestName(guestName);
    }
}