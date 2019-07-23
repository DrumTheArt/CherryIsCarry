package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Stay;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay.*;


public class StayDAOImpl implements StayDAO {

    private ArrayList<Stay> AllStayByOneProject;
    private Stay aStay;
    private QueryGeneratorStay query;
    private Statement statement;
    private ResultSet result;

    public StayDAOImpl() {

        aStay = new Stay();
        AllStayByOneProject = new ArrayList<>();
        query = new QueryGeneratorStay();
    }

    @Override
    public Stay findStayByOneGuest(int idGuest, int idProject) {

        String queryCommand = query.fetchQueryStayOneGuest(idGuest, idProject);

        try {

            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

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
    public ArrayList findAllStayByOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllStayOneProject(idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                AllStayByOneProject.add(new Stay(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

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
    public void updateStayForOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryStayOneGuest(idGuest, idProject, newNights);
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
    public void deleteStayForOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryStayOneGuest(idGuest, idProject);
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
    public void insertStayForOneGuest(int idGuest, int idProject, int nights) {

        try {

            String queryCommand = query.insertQueryStayOneGuest(idGuest, idProject, nights);
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

    private void createStayObject(int idGuest, int idProject, int FK_id, int nights) {
        aStay.setPK_id(FK_id);
        aStay.setNights(nights);
        aStay.setIdGuest(idGuest);
        aStay.setIdProject(idProject);
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