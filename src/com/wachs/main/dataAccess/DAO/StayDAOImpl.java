package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Stay;
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

        String queryCommand = query.queryFindStayByOneGuest(idGuest, idProject);

        try {

            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aStay.setPK_id(FK_id);
            aStay.setNights(nights);
            aStay.setIdGuest(idGuest);
            aStay.setIdProject(idProject);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aStay;
    }

    @Override
    public ArrayList findAllStayByOneProject(int idProject) {

        try {

            String queryCommand = query.queryFindAllStayByOneProject(idProject);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                AllStayByOneProject.add(new Stay(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return AllStayByOneProject;
    }

    @Override
    public void updateStayForOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.queryUpdateStayForOneGuest(idGuest, idProject, newNights);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);


        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteStayForOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.queryDeleteStayForOneGuest(idGuest, idProject);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void insertStayForOneGuest(int idGuest, int idProject, int nights) {

        try {

            String queryCommand = query.queryInsertStayForOneGuest(idGuest, idProject, nights);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}