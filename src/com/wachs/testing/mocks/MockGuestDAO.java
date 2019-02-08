package com.wachs.testing.mocks;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.dataAcess.DAO.GuestDAO;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorGuest;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ConverterStringForDataBase;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorGuest.*;

public class MockGuestDAO implements GuestDAO {


    private Statement statement;
    private ArrayList<Guest> allDataList;
    private ArrayList<Guest> allDatalistWhere;
    private Guest aGuest;
    private ConverterStringForDataBase convertString;

    public MockGuestDAO() {

        aGuest = new Guest();
        allDataList = new ArrayList<Guest>();
        allDatalistWhere = new ArrayList<Guest>();
        convertString = new ConverterStringForDataBase();

    }

    @Override
    public Guest findOneData(String name, int id_house) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        try {
            statement = DbTestConnection.getConnection().createStatement();
            QueryGeneratorGuest query = new QueryGeneratorGuest();
            ResultSet result = statement.executeQuery(query.queryFindOneData(name, id_house));

            //Get db-attributes
            int PK_id = result.getInt(1);
            int ID_house = result.getInt(2);
            String Guestname = result.getString(3);

            //Set db-attributes into GuestObject
            aGuest.setPK_id(PK_id);
            aGuest.setId_house(ID_house);
            aGuest.setTXT_name(Guestname);

            statement.close();
            result.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aGuest;
    }

    @Override
    public ArrayList readAllData(int id_house) {

        QueryGeneratorGuest query = new QueryGeneratorGuest();
        try {
            statement = DbTestConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryReadAllData(id_house));

            while (result.next()) {
                allDataList.add(new Guest(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3)));

            }

            statement.close();
            result.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDataList;

    }

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    @Override
    public void insertData(int id_house, String name) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorGuest newQuery = new QueryGeneratorGuest();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryInsertData(id_house, name));

            statement.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateData(int oldId, String name, int id_house) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorGuest newQuery = new QueryGeneratorGuest();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryUpdateData(oldId, name, id_house));

            statement.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(String name, int id_house) {


        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorGuest newQuery = new QueryGeneratorGuest();

        try {
            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryDeleteData(name, id_house));

            statement.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList findListDataWhereHouseID(int id_house) {

        QueryGeneratorGuest query = new QueryGeneratorGuest();
        try {
            statement = DbTestConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryfindOneDataWhereHouseID(id_house));

            while (result.next()) {
                allDatalistWhere.add(new Guest(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getString(COLUMN3)));

            }

            statement.close();
            result.close();
            DbTestConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDatalistWhere;
    }

}