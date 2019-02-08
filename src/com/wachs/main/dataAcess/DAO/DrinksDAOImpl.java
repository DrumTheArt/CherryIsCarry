package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorDrinks;
import com.wachs.main.dataAcess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAcess.dataAccessConfigurations.Util.ApplicationLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;

public class DrinksDAOImpl implements DrinksDAO {

    private Statement statement;
    private ArrayList<Drinks> allDataList;
    private Drinks aDrink;

    public DrinksDAOImpl() {

        aDrink = new Drinks();
        allDataList = new ArrayList<Drinks>();
    }

    public Drinks findOneData(int id_guest, int id_house) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryFindOneData(id_guest, id_house));

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aDrink.setPK_id(FK_id);
            aDrink.setNights(nights);
            aDrink.setId_guest(id_guest);
            aDrink.setId_house(id_house);

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aDrink;
    }

    public ArrayList readAllData() {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();
        try {

            statement = DbConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryReadAllData());

            //Log the query
            ApplicationLogger.loggingQueries(query.queryReadAllData());

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

    public void updateData(int id_guest, int id_house, int newNights) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryUpdateData(id_guest, id_house, newNights));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryUpdateData(id_guest, id_house, newNights));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteData(int id_guest, int id_house) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryDeleteData(id_guest, id_house));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(int id_guest, int id_house, int nights) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();

        try {
            statement = DbConnection.getConnection().createStatement();
            statement.executeUpdate(query.queryInsertData(id_guest, id_house, nights));

            //Log the query
            ApplicationLogger.loggingQueries(query.queryDeleteData(id_guest, id_house));

            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
