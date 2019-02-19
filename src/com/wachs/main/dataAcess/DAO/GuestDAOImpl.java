package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorGuest;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ConverterStringForDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorGuest.*;

public class GuestDAOImpl implements GuestDAO {


    private Statement statement;
    private ArrayList<Guest> allDataList;
    private ArrayList<Guest> allDatalistWhere;
    private Guest aGuest;
    private ConverterStringForDataBase convertString;

    public GuestDAOImpl() {

        aGuest = new Guest();
        allDataList = new ArrayList<Guest>();
        allDatalistWhere = new ArrayList<Guest>();
        convertString = new ConverterStringForDataBase();

    }

    @Override
    public Guest findOneGuestByOneProject(String name, int idHouse) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);
        QueryGeneratorGuest query = new QueryGeneratorGuest();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindOneGuestByOneProject(name, idHouse);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            //Get db-attributes
            int PK_id = result.getInt(1);
            int ID_house = result.getInt(2);
            String guestName = result.getString(3);

            //Set db-attributes into GuestObject
            aGuest.setPK_id(PK_id);
            aGuest.setIdProject(ID_house);
            aGuest.setGuestName(guestName);

            statement.close();
            result.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aGuest;
    }

    @Override
    public ArrayList findAllGuestsByOneProject(int idHouse) {

        QueryGeneratorGuest query = new QueryGeneratorGuest();
        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindAllGuestsByOneProject(idHouse);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allDataList.add(new Guest(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3)));

            }

            statement.close();
            result.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDataList;
    }

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    @Override
    public void insertGuestForOneProject(int idHouse, String name) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorGuest query = new QueryGeneratorGuest();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryInsertGuestForOneProject(idHouse, name);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGuestForOneProject(int oldId, String name, int idProject) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorGuest query = new QueryGeneratorGuest();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryUpdateGuestForOneProject(oldId, name, idProject);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuestForOneProject(String name, int idProject) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorGuest query = new QueryGeneratorGuest();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryDeleteGuestForOneProject(name, idProject);
            statement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}