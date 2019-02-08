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
    public Prepaid findOneData(int id_guest, int id_house) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

            int FK_id = result.getInt(1);
            double prepaid = result.getDouble(2);

            aPrepaid.setPK_id(FK_id);
            aPrepaid.setPrepaid(prepaid);
            aPrepaid.setId_guest(id_guest);
            aPrepaid.setId_house(id_house);

            result.close();
            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aPrepaid;
    }

    public ArrayList readAllData() {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();
        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryReadAllData());

            //Log the query
            ApplicationLogger.loggingQueries(query.queryReadAllData());

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
    public void insertData(int id_guest, int id_house, double prepaid) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryInsertData(id_guest, id_house, prepaid));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryInsertData(id_guest, id_house, prepaid));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateData(int id_guest, int id_house, double newPrepaid) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryUpdateData(id_guest, id_house, newPrepaid));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdateData(id_guest, id_house, newPrepaid));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id_guest, int id_house) {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryDeleteData(id_guest, id_house));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}