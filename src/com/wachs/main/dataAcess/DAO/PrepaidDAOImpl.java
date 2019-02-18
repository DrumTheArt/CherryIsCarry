package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorPrepaid;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorPrepaid.*;

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
            ResultSet result = statement.executeQuery(query.queryFindPrepaidByOneGuest(idGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindPrepaidByOneGuest(idGuest, idProject));

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
            ResultSet result = statement.executeQuery(query.queryFindAllPrepaidByOneProject(idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindAllPrepaidByOneProject(idProject));

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
            statement.executeUpdate(query.queryInsertPrepaidForOneGuest(idGuest, idProject, prepaid));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryInsertPrepaidForOneGuest(idGuest, idProject, prepaid));

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
            statement.executeUpdate(query.queryUpdatePrepaidForOneGuest(idGuest, idProject, newPrepaid));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdatePrepaidForOneGuest(idGuest, idProject, newPrepaid));

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
            statement.executeUpdate(query.queryDeletePrepaidForOneGuest(idGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeletePrepaidForOneGuest(idGuest, idProject));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}