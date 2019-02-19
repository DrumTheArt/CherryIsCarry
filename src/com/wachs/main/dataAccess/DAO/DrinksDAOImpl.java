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

    private Statement statement;
    private ArrayList<Drinks> allDataList;
    private Drinks aDrink;

    public DrinksDAOImpl() {

        aDrink = new Drinks();
        allDataList = new ArrayList<Drinks>();
    }

    public Drinks findDrinksByOneGuest(int idGuest, int idProject) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
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

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();
        try {

            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindAllDrinksByOneProject(idProject);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allDataList.add(new Drinks(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDataList;
    }

    public void updateDrinksForOneGuest(int idGuest, int idProject, int newNights) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
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

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
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

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
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
