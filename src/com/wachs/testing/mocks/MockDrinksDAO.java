package com.wachs.testing.mocks;

import com.wachs.main.businessObjects.Drinks;
import com.wachs.main.dataAcess.DAO.DrinksDAO;
import com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorDrinks;
import com.wachs.testing.dbTestConfig.DbTestConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAcess.dBQueryGenerators.QueryGeneratorStay.*;

public class MockDrinksDAO implements DrinksDAO {

    private Statement statement;
    private ArrayList<Drinks> allDataList;
    private Drinks aDrink;

    public MockDrinksDAO() {

        aDrink = new Drinks();
        allDataList = new ArrayList<Drinks>();
    }

    @Override
    public Drinks findOneData(int id_guest, int id_house) {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();
        try {

            statement = DbTestConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryFindOneData(id_guest, id_house));

            int FK_id = result.getInt(1);
            int nights = result.getInt(2);

            aDrink.setPK_id(FK_id);
            aDrink.setNights(nights);
            aDrink.setId_guest(id_guest);
            aDrink.setId_house(id_house);

            result.close();
            statement.close();
            DbTestConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aDrink;
    }

    @Override
    public ArrayList readAllData() {

        QueryGeneratorDrinks query = new QueryGeneratorDrinks();
        try {

            statement = DbTestConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query.queryReadAllData());

            while (result.next()) {
                allDataList.add(new Drinks(result.getInt(COLUMN1), result.getInt(COLUMN2), result.getInt(COLUMN3), result.getInt(COLUMN4)));

            }

            statement.close();
            result.close();
            DbTestConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDataList;
    }

    @Override
    public void updateData(int id_guest, int id_house, int newNights) {

        QueryGeneratorDrinks newQuery = new QueryGeneratorDrinks();

        try {

            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryUpdateData(id_guest, id_house, newNights));

            statement.close();
            DbTestConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(int id_guest, int id_house) {

        QueryGeneratorDrinks newQuery = new QueryGeneratorDrinks();

        try {

            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryDeleteData(id_guest, id_house));

            statement.close();
            DbTestConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertData(int id_guest, int id_house, int nights) {

        QueryGeneratorDrinks newQuery = new QueryGeneratorDrinks();

        try {

            statement = DbTestConnection.getConnection().createStatement();
            statement.executeUpdate(newQuery.queryInsertData(id_guest, id_house, nights));

            statement.close();
            DbTestConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
