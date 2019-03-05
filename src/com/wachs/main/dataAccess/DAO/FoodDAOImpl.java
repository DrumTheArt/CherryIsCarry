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

    public FoodDAOImpl() {

        aFood = new Food();
        allFoodByOneProject = new ArrayList<>();
        query = new QueryGeneratorFood();

    }

    @Override
    public Food findFoodByOneGuest(int IdGuest, int idProject) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryFindFoodByOneGuest(IdGuest, idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aFood.setPK_id(FK_id);
            aFood.setNights(nights);
            aFood.setIdGuest(IdGuest);
            aFood.setIdProject(idProject);

            result.close();
            //statement.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aFood;
    }

    @Override
    public ArrayList findAllFoodByOneProject(int idProject) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryFindAllFoodByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {

                allFoodByOneProject.add(new Food(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

            //statement.close();
            result.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allFoodByOneProject;
    }

    @Override
    public void updateFoodForOneGuest(int idGuest, int idProject, int newNights) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryUpdateFoodForOneGuest(idGuest, idProject, newNights);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            //statement.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteFoodForOneGuest(int idGuest, int idProject) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryDeleteFoodForOneGuest(idGuest, idProject);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            //statement.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void insertFoodForOneGuest(int idGuest, int idProject, int nights) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryInsertStayForOneGuest(idGuest, idProject, nights);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            //statement.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}