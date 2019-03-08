package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinks;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorStay.*;

public class DrinksDAOImpl implements DrinksDAO {

    private ArrayList<Drinks> allDrinksByOneProject;
    private Drinks aDrink;
    private QueryGeneratorDrinks query;

    public DrinksDAOImpl() {

        aDrink = new Drinks();
        allDrinksByOneProject = new ArrayList<>();
        query = new QueryGeneratorDrinks();

    }

    public Drinks findDrinksByOneGuest(int idGuest, int idProject) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryFindDrinksByOneGuest(idGuest, idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aDrink.setPK_id(FK_id);
            aDrink.setNights(nights);
            aDrink.setIdGuest(idGuest);
            aDrink.setIdProject(idProject);

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aDrink;
    }

    public ArrayList findAllDrinksByOneProject(int idProject) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryFindAllDrinksByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {

                allDrinksByOneProject.add(new Drinks(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksByOneProject;
    }

    public void updateDrinksForOneGuest(int idGuest, int idProject, int newNights) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryUpdateDrinksForOneGuest(idGuest, idProject, newNights);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public void deleteDrinksForOneGuest(int idGuest, int idProject) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryDeleteDrinksForOneGuest(idGuest, idProject);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public void insertDrinksForOneGuest(int idGuest, int idProject, int nights) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryInsertDrinksForOneGuest(idGuest, idProject, nights);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteDrinksForOneGuest(idGuest, idProject));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}