package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Stay;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay.*;


public class StayDAOImpl implements StayDAO {

    private ArrayList<Stay> AllStayByOneProject;
    private Stay aStay;
    private QueryGeneratorStay query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private DbConnection connection;

    public StayDAOImpl() {

        aStay = new Stay();
        AllStayByOneProject = new ArrayList<>();
        query = new QueryGeneratorStay();
        connection = new DbConnection();
    }

    @Override
    public Stay fetchStayOneGuest(int idGuest, int idProject) {

        String queryCommand = query.fetchQueryStayOneGuest(idGuest, idProject);

        try {

            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            int FK_id = queryResult.getInt(1);
            int nights = queryResult.getInt(2);

            createStayObject(idGuest, idProject, FK_id, nights);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aStay;
    }

    @Override
    public ArrayList fetchAllStayOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllStayOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                AllStayByOneProject.add(new Stay(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return AllStayByOneProject;
    }

    @Override
    public void updateStayOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryStayOneGuest(idGuest, idProject, newNights);
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
    public void deleteStayOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryStayOneGuest(idGuest, idProject);
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
    public void insertStayOneGuest(int idGuest, int idProject, int nights) {

        try {

            String queryCommand = query.insertQueryStayOneGuest(idGuest, idProject, nights);
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


    private void createStayObject(int idGuest, int idProject, int FK_id, int nights) {
        aStay.setPK_id(FK_id);
        aStay.setNights(nights);
        aStay.setIdGuest(idGuest);
        aStay.setIdProject(idProject);
    }
}