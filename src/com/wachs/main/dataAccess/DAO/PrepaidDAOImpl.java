package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorPrepaid;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorPrepaid.*;

public class PrepaidDAOImpl implements PrepaidDAO {

    private ArrayList<Prepaid> allPrepaidByOneProject;
    private Prepaid aPrepaid;
    private QueryGeneratorPrepaid query;
    private Statement statement;
    private ResultSet result;

    public PrepaidDAOImpl() {

        aPrepaid = new Prepaid();
        allPrepaidByOneProject = new ArrayList<>();
        query = new QueryGeneratorPrepaid();

    }

    @Override
    public Prepaid findPrepaidByOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.queryFindPrepaidByOneGuest(idGuest, idProject);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            int FK_id = result.getInt(1);
            double prepaid = result.getDouble(2);

            aPrepaid.setPK_id(FK_id);
            aPrepaid.setPrepaid(prepaid);
            aPrepaid.setIdGuest(idGuest);
            aPrepaid.setIdProject(idProject);

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

        return aPrepaid;
    }

    public ArrayList findAllPrepaidByOneProject(int idProject) {

        try {

            String queryCommand = query.queryFindAllPrepaidByOneProject(idProject);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allPrepaidByOneProject.add(new Prepaid(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

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

        return allPrepaidByOneProject;
    }

    @Override
    public void insertPrepaidForOneGuest(int idGuest, int idProject, double prepaid) {

        try {

            String queryCommand = query.queryInsertPrepaidForOneGuest(idGuest, idProject, prepaid);
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
    public void updatePrepaidForOneGuest(int idGuest, int idProject, double newPrepaid) {

        try {

            String queryCommand = query.queryUpdatePrepaidForOneGuest(idGuest, idProject, newPrepaid);
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
    public void deletePrepaidForOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.queryDeletePrepaidForOneGuest(idGuest, idProject);
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