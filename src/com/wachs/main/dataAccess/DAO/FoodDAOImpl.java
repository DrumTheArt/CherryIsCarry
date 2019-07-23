package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Food;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorFood;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay.*;

public class FoodDAOImpl implements FoodDAO {

    private ArrayList<Food> allFoodByOneProject;
    private Food aFood;
    private QueryGeneratorFood query;
    private Statement statement;
    private ResultSet result;

    public FoodDAOImpl() {

        aFood = new Food();
        allFoodByOneProject = new ArrayList<>();
        query = new QueryGeneratorFood();

    }

    @Override
    public Food findFoodByOneGuest(int IdGuest, int idProject) {

        try {

            String queryCommand = query.fetchQueryFoodOneGuest(IdGuest, idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            createFoodObject(IdGuest, idProject, FK_id, nights);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aFood;
    }

    @Override
    public ArrayList findAllFoodByOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllQueryFoodOneProject(idProject);
            statement = getSQLStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allFoodByOneProject.add(new Food(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allFoodByOneProject;
    }

    @Override
    public void updateFoodForOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryFoodOneGuest(idGuest, idProject, newNights);
            statement = getSQLStatement();
            statement.executeUpdate(queryCommand);

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteFoodForOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryFoodOneGuest(idGuest, idProject);
            statement = getSQLStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void insertFoodForOneGuest(int idGuest, int idProject, int nights) {

        try {

            String queryCommand = query.insertQueryFoodOneGuest(idGuest, idProject, nights);
            statement = getSQLStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private void createFoodObject(int IdGuest, int idProject, int FK_id, int nights) {
        aFood.setPK_id(FK_id);
        aFood.setNights(nights);
        aFood.setIdGuest(IdGuest);
        aFood.setIdProject(idProject);
    }

    private Statement getSQLStatement() throws SQLException {
        return DbConnection.getConnection().createStatement();
    }

    private void closingAllConnections() throws SQLException {
        result.close();
        statement.close();
        DbConnection.closeConnection();
    }
}