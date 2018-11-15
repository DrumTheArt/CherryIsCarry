package com.wachs.testing.mocks;

import com.wachs.main.businessLayer.Food;
import com.wachs.main.dataBaseLayer.DAO.FoodDAO;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorFood;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorStay.*;

public class MockFoodDAO implements FoodDAO {

    private Statement statement;
    private ArrayList<Food> allDataList;
    private Food aFood;

    public MockFoodDAO() {

        aFood = new Food();
        allDataList = new ArrayList<Food>();
    }

    @Override
    public Food findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        statement = DbTestConnection.getConnection().createStatement();
        QueryGeneratorFood query = new QueryGeneratorFood();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        int nights = result.getInt(2);

        aFood.setPK_id(FK_id);
        aFood.setNights(nights);
        aFood.setId_guest(id_guest);
        aFood.setId_house(id_house);

        result.close();
        statement.close();
        DbTestConnection.closeConnection();

        return aFood;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        QueryGeneratorFood query = new QueryGeneratorFood();
        statement = DbTestConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Food(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

        }

        statement.close();
        result.close();
        DbTestConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException {

        QueryGeneratorFood newQuery = new QueryGeneratorFood();

        statement = DbTestConnection.getConnection().createStatement();

        statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, newNights));

        statement.close();
        DbTestConnection.closeConnection();

    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        QueryGeneratorFood newQuery = new QueryGeneratorFood();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

        statement.close();
        DbTestConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException {

        QueryGeneratorFood newQuery = new QueryGeneratorFood();

        statement = DbTestConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, nights));

        statement.close();
        DbTestConnection.closeConnection();

    }

}