package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Food;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorFood;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;

public class FoodDAOImpl implements FoodDAO {

    private Statement statement;
    private ArrayList<Food> allDataList;
    private Food aFood;

    public FoodDAOImpl() {

        aFood = new Food();
        allDataList = new ArrayList<Food>();
    }

    @Override
    public Food findFoodByOneGuest(int IdGuest, int idProject) {

        try {
            statement = DbConnection.getConnection().createStatement();
            QueryGeneratorFood query = new QueryGeneratorFood();
            ResultSet result = statement.executeQuery(query.queryFindFoodByOneGuest(IdGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindFoodByOneGuest(IdGuest, idProject));

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aFood.setPK_id(FK_id);
            aFood.setNights(nights);
            aFood.setIdGuest(IdGuest);
            aFood.setIdProject(idProject);

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aFood;
    }

    @Override
    public ArrayList findAllFoodByOneProject(int idProject) {

        QueryGeneratorFood query = new QueryGeneratorFood();

        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindAllFoodByOneProject(idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindAllFoodByOneProject(idProject));

            while (result.next()) {
                allDataList.add(new Food(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));
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
    public void updateFoodForOneGuest(int idGuest, int idProject, int newNights) {

        QueryGeneratorFood query = new QueryGeneratorFood();
        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryUpdateFoodForOneGuest(idGuest, idProject, newNights));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdateFoodForOneGuest(idGuest, idProject, newNights));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFoodForOneGuest(int idGuest, int idProject) {

        QueryGeneratorFood query = new QueryGeneratorFood();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryDeleteFoodForOneGuest(idGuest, idProject));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteFoodForOneGuest(idGuest, idProject));

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertFoodForOneGuest(int idGuest, int idProject, int nights) {

        QueryGeneratorFood query = new QueryGeneratorFood();

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
