package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Food;
import com.wachs.main.dataBaseLayer.DBConnection.DbConnection;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorFood;
import com.wachs.main.dataBaseLayer.Util.ApplicationLogger;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorStay.*;

public class FoodDAOImpl implements FoodDAO {

    private Statement statement;
    private ArrayList<Food> allDataList;
    private Food aFood;

    public FoodDAOImpl() {

        aFood = new Food();
        allDataList = new ArrayList<Food>();
    }

    @Override
    public Food findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException {

        statement = DbConnection.getConnection().createStatement();
        QueryGeneratorFood query = new QueryGeneratorFood();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        int nights = result.getInt(2);

        aFood.setPK_id(FK_id);
        aFood.setNights(nights);
        aFood.setId_guest(id_guest);
        aFood.setId_house(id_house);

        result.close();
        statement.close();
        DbConnection.closeConnection();

        return aFood;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorFood query = new QueryGeneratorFood();
        statement = DbConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        //Log the query
        ApplicationLogger.loggingQueries(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Food(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
        }

        statement.close();
        result.close();
        DbConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorFood query = new QueryGeneratorFood();
        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryUpdateData(id_guest, id_house, newNights));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryUpdateData(id_guest, id_house, newNights));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorFood query = new QueryGeneratorFood();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryDeleteData(id_guest, id_house));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorFood query = new QueryGeneratorFood();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryInsertData(id_guest, id_house, nights));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryInsertData(id_guest, id_house, nights));

        statement.close();
        DbConnection.closeConnection();
    }

}
