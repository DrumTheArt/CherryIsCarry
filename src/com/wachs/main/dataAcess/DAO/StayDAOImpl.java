package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;

import java.io.IOException;
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
    public Stay findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException {

        statement = DbConnection.getConnection().createStatement();
        QueryGeneratorStay query = new QueryGeneratorStay();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        int nights = result.getInt(2);

        aStay.setPK_id(FK_id);
        aStay.setNights(nights);
        aStay.setId_guest(id_guest);
        aStay.setId_house(id_house);

        result.close();
        statement.close();
        DbConnection.closeConnection();

        return aStay;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorStay query = new QueryGeneratorStay();
        statement = DbConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        //Log the query
        ApplicationLogger.loggingQueries(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Stay(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

        }

        statement.close();
        result.close();
        DbConnection.closeConnection();

        return allDataList;

    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorStay query = new QueryGeneratorStay();

        statement = DbConnection.getConnection().createStatement();

        statement.executeUpdate(query.queryUpdateData(id_guest, id_house, newNights));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryUpdateData(id_guest, id_house, newNights));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorStay query = new QueryGeneratorStay();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryDeleteData(id_guest, id_house));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorStay query = new QueryGeneratorStay();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryInsertData(id_guest, id_house, nights));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryInsertData(id_guest, id_house, nights));

        statement.close();
        DbConnection.closeConnection();

    }

}
