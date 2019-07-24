package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Prepaid;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorPrepaid;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorPrepaid.*;

public class PrepaidDAOImpl implements PrepaidDAO {

    private ArrayList<Prepaid> allPrepaidByOneProject;
    private Prepaid aPrepaid;
    private QueryGeneratorPrepaid query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;

    public PrepaidDAOImpl() {

        aPrepaid = new Prepaid();
        allPrepaidByOneProject = new ArrayList<>();
        query = new QueryGeneratorPrepaid();
        connection = new DBConnection();

    }

    public PrepaidDAOImpl(IDBConnection connectToTestDatabase) {

        aPrepaid = new Prepaid();
        allPrepaidByOneProject = new ArrayList<>();
        query = new QueryGeneratorPrepaid();
        this.connection = connectToTestDatabase;

    }

    @Override
    public Prepaid fetchPrepaidOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.fetchQueryPrepaidOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            int FK_id = queryResult.getInt(1);
            double prepaid = queryResult.getDouble(2);

            createPrepaidObject(idGuest, idProject, FK_id, prepaid);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aPrepaid;
    }

    public ArrayList fetchAllPrepaidOneProject(int idProject) {

        try {

            String queryCommand = query.fetchQueryAllPrepaidOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allPrepaidByOneProject.add(new Prepaid(queryResult.getInt(COLUMN1), queryResult.getDouble(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

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
    public void updatePrepaidOneGuest(int idGuest, int idProject, double newPrepaid) {

        try {

            String queryCommand = query.updateQueryPrepaidOneGuest(idGuest, idProject, newPrepaid);
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
    public void deletePrepaidOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryPrepaidOneGuest(idGuest, idProject);
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

    private void createPrepaidObject(int idGuest, int idProject, int FK_id, double prepaid) {

        aPrepaid.setPK_id(FK_id);
        aPrepaid.setPrepaid(prepaid);
        aPrepaid.setIdGuest(idGuest);
        aPrepaid.setIdProject(idProject);

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