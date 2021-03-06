package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Stay;
import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorStay;
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

public class StayService implements IStayService {

    private ArrayList<Stay> AllStayByOneProject;
    private Stay aStay;
    private QueryGeneratorStay query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public StayService() {

        aStay = new Stay();
        AllStayByOneProject = new ArrayList<>();
        query = new QueryGeneratorStay();
        connection = new DBConnection();
        this.isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public StayService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        aStay = new Stay();
        AllStayByOneProject = new ArrayList<>();
        query = new QueryGeneratorStay();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public Stay fetchStayOneGuest(int idGuest, int idProject) {

        String queryCommand = query.fetchQueryStayOneGuest(idGuest, idProject);

        try {

            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


                int FK_id = queryResult.getInt(1);
                int nights = queryResult.getInt(2);

                createStayObject(idGuest, idProject, FK_id, nights);

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

        return aStay;
    }

    @Override
    public ArrayList fetchAllStayOneProject(int idProject) {

        AllStayByOneProject.clear();

        try {

            String queryCommand = query.fetchAllStayOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                AllStayByOneProject.add(new Stay(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

            if(AllStayByOneProject.isEmpty()){

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

        return AllStayByOneProject;
    }

    @Override
    public void insertStayOneGuest(int idGuest, int idProject, int nights) {

        try {

            String queryCommand = query.insertQueryStayOneGuest(idGuest, idProject, nights);
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
    public void updateStayOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryStayOneGuest(idGuest, idProject, newNights);
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
    public void deleteStayOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryStayOneGuest(idGuest, idProject);
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


    private void createStayObject(int idGuest, int idProject, int FK_id, int nights) {
        aStay.setPrimaryKey(FK_id);
        aStay.setNights(nights);
        aStay.setGuestId(idGuest);
        aStay.setProjectId(idProject);
    }
}