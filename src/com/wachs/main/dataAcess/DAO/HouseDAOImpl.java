package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorHouse;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ConverterStringForDataBase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorHouse.*;

public class HouseDAOImpl implements HouseDAO {

    private Statement statement;
    private ArrayList<House> allDataList;
    private House aHouse;
    private ConverterStringForDataBase convertString;


    public HouseDAOImpl() {
        aHouse = new House();
        allDataList = new ArrayList<House>();
        convertString = new ConverterStringForDataBase();

    }

    @Override
    public House findOneData(String name) throws SQLException, ClassNotFoundException, IOException {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        statement = DbConnection.getConnection().createStatement();
        QueryGeneratorHouse query = new QueryGeneratorHouse();
        ResultSet result = statement.executeQuery(query.queryFindOneData(name));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryFindOneData(name));

        //Get db-attributes
        int pk_id = result.getInt(1);
        String txt_name = result.getString(2);
        double real_price = result.getDouble(3);
        double reaL_deposite = result.getDouble(4);

        //Set db-attributes into GuestObject
        aHouse.setPK_id(pk_id);
        aHouse.setTXT_name(txt_name);
        aHouse.setREAL_price(real_price);
        aHouse.setREAL_deposite(reaL_deposite);

        result.close();
        statement.close();
        DbConnection.closeConnection();

        return aHouse;
    }


    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException, IOException {

        QueryGeneratorHouse query = new QueryGeneratorHouse();
        statement = DbConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        //Log the query
        ApplicationLogger.loggingQueries(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new House(result.getInt(COLUMN1), result.getString(COLUMN2), result.getDouble(COLUMN3), result.getDouble(COLUMN4)));

        }

        result.close();
        statement.close();
        DbConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void insertData(String name, double price, double deposite) throws SQLException, ClassNotFoundException, IOException {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);

        QueryGeneratorHouse query = new QueryGeneratorHouse();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryInsertData(name, price, deposite));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryInsertData(name, price, deposite));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void updateData(int oldId, String newName, double newPrice, double newDeposite) throws SQLException, ClassNotFoundException, IOException {


        //Set firstLetter to upperCase and set last to lowerLetters
        newName = convertString.convertString(newName);

        QueryGeneratorHouse query = new QueryGeneratorHouse();

        statement = DbConnection.getConnection().createStatement();

        statement.executeUpdate(query.queryUpdateData(oldId, newName, newPrice, newDeposite));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryUpdateData(oldId, newName, newPrice, newDeposite));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void deleteData(String name) throws SQLException, ClassNotFoundException, IOException {


        //Because every names starts with a Capital, Rest lowerCases
        int countLettersName = name.length();
        String firstLetter = name.substring(0,1).toUpperCase();
        String lastLetters = name.substring(1,countLettersName).toLowerCase();

        name = firstLetter + lastLetters;

        QueryGeneratorHouse query = new QueryGeneratorHouse();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(query.queryDeleteData(name));

        //Log the query
        ApplicationLogger.loggingQueries(query.queryDeleteData(name));

        statement.close();
        DbConnection.closeConnection();
    }

}
