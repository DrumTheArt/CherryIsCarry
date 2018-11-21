package com.wachs.main.dataBaseLayer.DAO;

import com.wachs.main.businessLayer.Drinks;
import com.wachs.main.dataBaseLayer.DBConnection.DbConnection;
import com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorDrinks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataBaseLayer.DBQueries.QueryGeneratorStay.*;

public class DrinksDAOImpl implements DrinksDAO {


    private Statement statement;
    private ArrayList<Drinks> allDataList;
    private Drinks aDrink;

    public DrinksDAOImpl() {

        aDrink = new Drinks();
        allDataList = new ArrayList<Drinks>();
    }

    @Override
    public Drinks findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        statement = DbConnection.getConnection().createStatement();
        QueryGeneratorDrinks query = new QueryGeneratorDrinks();
        ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

        int FK_id = result.getInt(1);
        int nights = result.getInt(2);

        aDrink.setPK_id(FK_id);
        aDrink.setNights(nights);
        aDrink.setId_guest(id_guest);
        aDrink.setId_house(id_house);

        result.close();
        statement.close();
        DbConnection.closeConnection();

        return aDrink;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();
        statement = DbConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query.queryReadAllData());

        while (result.next()) {
            allDataList.add(new Drinks(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

        }

        statement.close();
        result.close();
        DbConnection.closeConnection();

        return allDataList;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) throws SQLException, ClassNotFoundException {

        QueryGeneratorDrinks newQuery = new QueryGeneratorDrinks();

        statement = DbConnection.getConnection().createStatement();

        statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, newNights));

        statement.close();
        DbConnection.closeConnection();

    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        QueryGeneratorDrinks newQuery = new QueryGeneratorDrinks();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

        statement.close();
        DbConnection.closeConnection();
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) throws SQLException, ClassNotFoundException {

        QueryGeneratorDrinks newQuery = new QueryGeneratorDrinks();

        statement = DbConnection.getConnection().createStatement();
        statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, nights));

        statement.close();
        DbConnection.closeConnection();
    }

}
