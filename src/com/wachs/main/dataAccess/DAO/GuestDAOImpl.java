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

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryFindOneGuestByOneProject(name, idHouse);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            //Get db-attributes
            int PK_id = result.getInt(1);
            int idProject = result.getInt(2);
            String guestName = result.getString(3);

            //Set db-attributes into GuestObject
            aGuest.setPK_id(PK_id);
            aGuest.setIdProject(idProject);
            aGuest.setGuestName(guestName);

            //statement.close();
            result.close();
            //DbConnection.closeConnection();
        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aGuest;
    }

    @Override
    public ArrayList findAllGuestsByOneProject(int idHouse) {

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryFindAllGuestsByOneProject(idHouse);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {

                allGuestByOneProject.add(new Guest(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3)));

            }

            //statement.close();
            result.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allGuestByOneProject;
    }

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    @Override
    public void insertGuestForOneProject(int idHouse, String name) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryInsertGuestForOneProject(idHouse, name);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            //DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateGuestForOneProject(int oldId, String name, int idProject) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryUpdateGuestForOneProject(oldId, name, idProject);
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
    public void deleteGuestForOneProject(String name, int idProject) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        try (Statement statement = DbConnection.getConnection().createStatement()) {

            String queryCommand = query.queryDeleteGuestForOneProject(name, idProject);
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