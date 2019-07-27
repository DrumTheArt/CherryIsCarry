package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Drinks;
import com.wachs.main.POJO.Guest;
import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorDrinks;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.Connection;
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
    private IDBConnection connection;

    public DrinksDAOImpl() {

        this.singleDrink = new Drinks();
        query = new QueryGeneratorDrinks();
        this.allDrinksOneProject = new ArrayList<>();
        this.connection = new DBConnection();

    }

    public DrinksDAOImpl(IDBConnection connectToTestDatabase) {

        this.singleDrink = new Drinks();
        query = new QueryGeneratorDrinks();
        this.allDrinksOneProject = new ArrayList<>();
        this.connection = connectToTestDatabase;

    }

    public Drinks fetchDrinksOneGuest(int idGuest, int idProject) {

        try {

            queryStatement = createSQLStatement();
            String queryCommand = query.fetchQueryOneGuest(idGuest, idProject);
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


            int FK_id = queryResult.getInt(1);
            int nights = queryResult.getInt(2);

            createDrinkObject(idGuest, idProject, FK_id, nights);

            }

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return singleDrink;
    }

    public ArrayList fetchAllDrinksOneProject(int idProject) {

        try {

            String queryCommand = query.fetchAllOneProject(idProject);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allDrinksOneProject.add(new Drinks(queryResult.getInt(COLUMN1), queryResult.getInt(COLUMN2), queryResult.getInt(COLUMN3), queryResult.getInt(COLUMN4)));

            }

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allDrinksOneProject;
    }

    public void updateDrinksOneGuest(int idGuest, int idProject, int newNights) {

        try {

            String queryCommand = query.updateQueryForOneGuest(idGuest, idProject, newNights);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteDrinksOneGuest(int idGuest, int idProject) {

        try {

            String queryCommand = query.deleteQueryOneGuest(idGuest, idProject);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void insertDrinksOneGuest(int idGuest, int idProject, int nights) {

        try (Statement statement = createSQLStatement()) {

            String queryCommand = query.insertQueryOneGuest(idGuest, idProject, nights);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(query.deleteQueryOneGuest(idGuest, idProject));


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    private void createDrinkObject(int idGuest, int idProject, int FK_id, int nights) {
        singleDrink.setPK_id(FK_id);
        singleDrink.setNights(nights);
        singleDrink.setIdGuest(idGuest);
        singleDrink.setIdProject(idProject);
    }

}