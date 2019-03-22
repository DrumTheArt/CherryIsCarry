package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorGuest;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorGuest.*;

public class GuestDAOImpl implements GuestDAO {

    private ArrayList<Guest> allGuestByOneProject;
    private Guest aGuest;
    private ConverterStringForDataBase convertString;
    private QueryGeneratorGuest query;
    private Statement statement;
    private ResultSet result;

    public GuestDAOImpl() {

        aGuest = new Guest();
        allGuestByOneProject = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorGuest();

    }

    @Override
    public Guest findOneGuestByOneProject(String name, int idHouse) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        try {

            String queryCommand = query.queryFindOneGuestByOneProject(name, idHouse);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            //Get db-attributes
            int PK_id = result.getInt(1);
            int idProject = result.getInt(2);
            String guestName = result.getString(3);

            //Set db-attributes into GuestObject
            aGuest.setPK_id(PK_id);
            aGuest.setIdProject(idProject);
            aGuest.setGuestName(guestName);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aGuest;
    }

    @Override
    public ArrayList findAllGuestsByOneProject(int idProject) {

        try {

            String queryCommand = query.queryFindAllGuestsByOneProject(idProject);
            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            while (result.next()) {

                allGuestByOneProject.add(new Guest(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            result.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return allGuestByOneProject;
    }

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    @Override
    public void insertGuestForOneProject(int idProject, String guestName) {

        //Set firstLetter to upperCase and set last to lowerLetters
        guestName = convertString.convertString(guestName);

        try {

            String queryCommand = query.queryInsertGuestForOneProject(guestName, idProject);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateGuestForOneProject(int oldId, String guestName, int idProject) {

        //Set firstLetter to upperCase and set last to lowerLetters
        guestName = convertString.convertString(guestName);

        try {

            String queryCommand = query.queryUpdateGuestForOneProject(oldId, guestName, idProject);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuestForOneProject(String guestName, int idProject) {


        //Set firstLetter to upperCase and set last to lowerLetters
        guestName = convertString.convertString(guestName);

        try {

            String queryCommand = query.queryDeleteGuestForOneProject(guestName, idProject);
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}