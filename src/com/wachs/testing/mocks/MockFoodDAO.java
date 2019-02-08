package com.wachs.testing.mocks;

import com.wachs.main.businessObjects.Food;
import com.wachs.main.dataAcess.DAO.FoodDAO;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorFood;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;

public class MockFoodDAO implements FoodDAO {

    private Statement statement;
    private ArrayList<Food> allDataList;
    private Food aFood;

    public MockFoodDAO() {

        aFood = new Food();
        allDataList = new ArrayList<Food>();
    }

    @Override
    public Food findOneData(int id_guest, int id_house) {

        QueryGeneratorFood query = new QueryGeneratorFood();

        try {
            statement = DbTestConnection.getConnection().createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aFood;
    }

    @Override
    public ArrayList readAllData() {

        QueryGeneratorFood query = new QueryGeneratorFood();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryReadAllData());

            while (result.next()) {
                allDataList.add(new Food(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

            statement.close();
            result.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDataList;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) {

        QueryGeneratorFood newQuery = new QueryGeneratorFood();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, newNights));

            statement.close();
            DbTestConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id_guest, int id_house) {

        QueryGeneratorFood newQuery = new QueryGeneratorFood();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

            statement.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) {

        QueryGeneratorFood newQuery = new QueryGeneratorFood();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, nights));

            statement.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}