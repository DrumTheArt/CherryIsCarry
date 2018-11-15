package com.wachs.testing.mocks;

import com.wachs.main.businessLayer.Prepaid;
import com.wachs.main.dataBaseLayer.DAO.PrepaidDAO;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorExpense;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorPrepaid;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorPrepaid.*;

public class MockPrepaidDAO implements PrepaidDAO {

    private Statement statement;
    private ArrayList<Prepaid> allDataList;
    private Prepaid aPrepaid;

    public MockPrepaidDAO() {

        aPrepaid = new Prepaid();
        allDataList = new ArrayList<Prepaid>();
    }

    @Override
    public Prepaid findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        statement = DbTestConnection.getConnection().createStatement();
        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        double prepaid = result.getDouble(2);

        aPrepaid.setPK_id(FK_id);
        aPrepaid.setPrepaid(prepaid);
        aPrepaid.setId_guest(id_guest);
        aPrepaid.setId_house(id_house);

        result.close();
        statement.close();
        DbTestConnection.closeConnection();

        return aPrepaid;
    }

    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        QueryGeneratorPrepaid query = new QueryGeneratorPrepaid();
        statement = DbTestConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Prepaid(result.getInt(COLUMN1), result.getDouble(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

        }

        statement.close();
        result.close();
        DbTestConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void insertData(int id_guest, int id_house, double prepaid) throws SQLException, ClassNotFoundException {

        QueryGeneratorPrepaid newQuery = new QueryGeneratorPrepaid();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, prepaid));

        statement.close();
        DbTestConnection.closeConnection();

    }

    @Override
    public void updateData(int id_guest, int id_house, double newPrepaid) throws SQLException, ClassNotFoundException {

        QueryGeneratorPrepaid newQuery = new QueryGeneratorPrepaid();

        statement = DbTestConnection.getConnection().createStatement();

        statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, newPrepaid));

        statement.close();
        DbTestConnection.closeConnection();

    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        QueryGeneratorExpense newQuery = new QueryGeneratorExpense();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

        statement.close();
        DbTestConnection.closeConnection();
    }
}
