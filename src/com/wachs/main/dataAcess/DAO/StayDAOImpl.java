package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;


public class StayDAOImpl implements StayDAO {

    private Statement statement;
    private ArrayList<Stay> allDataList;
    private Stay aStay;

    public StayDAOImpl() {

        aStay = new Stay();
        allDataList = new ArrayList<Stay>();
    }

    @Override
    public Stay findStayByOneGuest(int idGuest, int idProject) {

        try {
            statement = DbConnection.getConnection().createStatement();
            QueryGeneratorStay query = new QueryGeneratorStay();
            ResultSet result = statement.executeQuery(query.queryFindStayByOneGuest(idGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindStayByOneGuest(idGuest, idProject));

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aStay.setPK_id(FK_id);
            aStay.setNights(nights);
            aStay.setIdGuest(idGuest);
            aStay.setIdProject(idProject);

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

        QueryGeneratorStay query = new QueryGeneratorStay();
        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindAllStayByOneProject(idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindAllStayByOneProject(idProject));

            while (result.next()) {
                allDataList.add(new Stay(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

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
    public void updateStayForOneGuest(int idGuest, int idProject, int newNights) {

        QueryGeneratorStay query = new QueryGeneratorStay();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryUpdateStayForOneGuest(idGuest, idProject, newNights));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdateStayForOneGuest(idGuest, idProject, newNights));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteStayForOneGuest(int idGuest, int idProject) {

        QueryGeneratorStay query = new QueryGeneratorStay();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryDeleteStayForOneGuest(idGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteStayForOneGuest(idGuest, idProject));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertStayForOneGuest(int idGuest, int idProject, int nights) {

        QueryGeneratorStay query = new QueryGeneratorStay();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryInsertStayForOneGuest(idGuest, idProject, nights));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryInsertStayForOneGuest(idGuest, idProject, nights));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
