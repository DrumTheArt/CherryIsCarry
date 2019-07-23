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

    private ArrayList<Drinks> allDrinksOneProject;
    private Drinks singleDrink;
    private QueryGeneratorDrinks query;
    private Statement queryStatement;
    private ResultSet queryResult;

    public DrinksDAOImpl() {

        this.singleDrink = new Drinks();
        query = new QueryGeneratorDrinks();
        this.allDrinksOneProject = new ArrayList<>();

    }

    public Drinks findDrinksOneGuest(int idGuest, int idProject) {

        try {

            queryStatement = getSQLStatement();
            String queryCommand = query.fetchQueryOneGuest(idGuest, idProject);
            queryResult = queryStatement.executeQuery(queryCommand);

            int FK_id = queryResult.getInt(1);
            int nights = queryResult.getInt(2);

            createDrinkObject(idGuest, idProject, FK_id, nights);

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return singleDrink;
    }

    public ArrayList findAllDrinksOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllOneProject(idProject);
            queryStatement = getSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allDrinksOneProject.add(new Drinks(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

            queryStatement.close();
            queryResult.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksOneProject;
    }

    public void updateDrinksOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryForOneGuest(idGuest, idProject, newNights);
            queryStatement = getSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            queryStatement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteDrinksOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryOneGuest(idGuest, idProject);
            queryStatement = getSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            queryStatement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void insertDrinksOneGuest(int idGuest, int idProject, int nights) {

        try (Statement statement = getSQLStatement()) {

            String queryCommand = query.insertQueryOneGuest(idGuest, idProject, nights);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(query.deleteQueryOneGuest(idGuest, idProject));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Statement getSQLStatement() throws SQLException {
        return DbConnection.getConnection().createStatement();
    }

    private void createDrinkObject(int idGuest, int idProject, int FK_id, int nights) {
        singleDrink.setPK_id(FK_id);
        singleDrink.setNights(nights);
        singleDrink.setIdGuest(idGuest);
        singleDrink.setIdProject(idProject);
    }

    private void closingAllConnections() throws SQLException {
        queryResult.close();
        queryStatement.close();
        DbConnection.closeConnection();
    }
}