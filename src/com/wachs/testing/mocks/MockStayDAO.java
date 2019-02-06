package com.wachs.testing.mocks;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAcess.DAO.StayDAO;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;

public class MockStayDAO implements StayDAO {
    private Statement statement;
    private ArrayList<Stay> allDataList;
    private Stay aStay;

    public MockStayDAO() {

        aStay = new Stay();
        allDataList = new ArrayList<Stay>();
    }

    @Override
    public Stay findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        statement = DbTestConnection.getConnection().createStatement();
        QueryGeneratorStay query = new QueryGeneratorStay();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        int nights = result.getInt(2);

        aStay.setPK_id(FK_id);
        aStay.setNights(nights);
        aStay.setId_guest(id_guest);
        aStay.setId_house(id_house);

        result.close();
        statement.close();
        DbTestConnection.closeConnection();

        return aStay;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        QueryGeneratorStay query = new QueryGeneratorStay();
        statement = DbTestConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Stay(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

        }

        statement.close();
        result.close();
        DbTestConnection.closeConnection();

        return allDataList;

    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException {
        QueryGeneratorStay newQuery = new QueryGeneratorStay();

        statement = DbTestConnection.getConnection().createStatement();

        statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, newNights));

        statement.close();
        DbTestConnection.closeConnection();
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {
        QueryGeneratorStay newQuery = new QueryGeneratorStay();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

        statement.close();
        DbTestConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException {

        QueryGeneratorStay newQuery = new QueryGeneratorStay();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, nights));

        statement.close();
        DbTestConnection.closeConnection();

    }

}
