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

    private Statement statement;
    private ArrayList<Prepaid> allDataList;
    private Prepaid aPrepaid;

    public PrepaidDAOImpl() {

        aPrepaid = new Prepaid();
        allDataList = new ArrayList<Prepaid>();
    }

    @Override
    public Prepaid findPrepaidByOneGuest(int idGuest, int idProject) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindPrepaidByOneGuest(idGuest, idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            int FK_id = result.getInt(1);
            double prepaid = result.getDouble(2);

            aPrepaid.setPK_id(FK_id);
            aPrepaid.setPrepaid(prepaid);
            aPrepaid.setIdGuest(idGuest);
            aPrepaid.setIdProject(idProject);

            result.close();
            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aPrepaid;
    }

    public ArrayList findAllPrepaidByOneProject(int idProject) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();
        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindAllPrepaidByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allDataList.add(new Prepaid(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
            }

            statement.close();
            result.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDataList;
    }

    @Override
    public void insertPrepaidForOneGuest(int idGuest, int idProject, double prepaid) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryInsertPrepaidForOneGuest(idGuest, idProject, prepaid);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePrepaidForOneGuest(int idGuest, int idProject, double newPrepaid) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryUpdatePrepaidForOneGuest(idGuest, idProject, newPrepaid);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePrepaidForOneGuest(int idGuest, int idProject) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryDeletePrepaidForOneGuest(idGuest, idProject);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}