package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Prepaid;
import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorPrepaid;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.Exceptions.NotInDataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorPrepaid.*;

public class PrepaidService implements IPrepaidService {

    private ArrayList<Prepaid> allPrepaidByOneProject;
    private Prepaid aPrepaid;
    private QueryGeneratorPrepaid query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public PrepaidService() {

        aPrepaid = new Prepaid();
        allPrepaidByOneProject = new ArrayList<>();
        query = new QueryGeneratorPrepaid();
        connection = new DBConnection();
        isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public PrepaidService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        aPrepaid = new Prepaid();
        allPrepaidByOneProject = new ArrayList<>();
        query = new QueryGeneratorPrepaid();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public Prepaid fetchPrepaidOneGuest(int idGuest, int idProject) {

        allPrepaidByOneProject.clear();

        try {

            String queryCommand = query.fetchQueryPrepaidOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


                int FK_id = queryResult.getInt(1);
                double prepaid = queryResult.getDouble(2);

                createPrepaidObject(idGuest, idProject, FK_id, prepaid);

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

        return aPrepaid;
    }

    @Override
    public ArrayList fetchAllPrepaidOneProject(int idProject) {

        try {

            String queryCommand = query.fetchQueryAllPrepaidOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allPrepaidByOneProject.add(new Prepaid(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

            if(allPrepaidByOneProject.isEmpty()){

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

        return allPrepaidByOneProject;
    }

    @Override
    public void insertPrepaidOneGuest(int idGuest, int idProject, double prepaid) {

        try {

            String queryCommand = query.insertQueryPrepaidOneGuest(idGuest, idProject, prepaid);
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
    public void updatePrepaidOneGuest(int idGuest, int idProject, double newPrepaid) {

        try {

            String queryCommand = query.updateQueryPrepaidOneGuest(idGuest, idProject, newPrepaid);
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
    public void deletePrepaidOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryPrepaidOneGuest(idGuest, idProject);
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

    private void createPrepaidObject(int idGuest, int idProject, int FK_id, double prepaid) {

        aPrepaid.setPrimaryKey(FK_id);
        aPrepaid.setPrepaid(prepaid);
        aPrepaid.setGuestId(idGuest);
        aPrepaid.setProjectId(idProject);

    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }
}