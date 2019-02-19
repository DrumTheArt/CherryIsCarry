package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorHouse;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorHouse.*;

public class ProjectDAOImpl implements ProjectDAO {

    private Statement statement;
    private ArrayList<Project> allDataList;
    private Project aProject;
    private ConverterStringForDataBase convertString;


    public ProjectDAOImpl() {
        aProject = new Project();
        allDataList = new ArrayList<Project>();
        convertString = new ConverterStringForDataBase();

    }

    @Override
    public Project fineOneProject(String name) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);
        QueryGeneratorHouse query = new QueryGeneratorHouse();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryFindOneData(name);
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            //Get db-attributes
            int pk_id = result.getInt(1);
            String txt_name = result.getString(2);
            double real_price = result.getDouble(3);
            double reaL_deposite = result.getDouble(4);

            //Set db-attributes into GuestObject
            aProject.setPK_id(pk_id);
            aProject.setProjectName(txt_name);
            aProject.setProjectPrice(real_price);
            aProject.setProjectDeposite(reaL_deposite);

            result.close();
            statement.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aProject;
    }

    //throws SQLException, ClassNotFoundException, IOException
    @Override
    public ArrayList findAllProjects() {

        QueryGeneratorHouse query = new QueryGeneratorHouse();
        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryReadAllData();
            ResultSet result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {
                allDataList.add(new Project(result.getInt(COLUMN1), result.getString(COLUMN2), result.getDouble(COLUMN3), result.getDouble(COLUMN4)));

            }

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDataList;
    }

    @Override
    public void insertProject(String projectName, double projectPrice, double projectDeposite) {

        //Set firstLetter to upperCase and set last to lowerLetters
        projectName = convertString.convertString(projectName);

        QueryGeneratorHouse query = new QueryGeneratorHouse();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryInsertData(projectName, projectPrice, projectDeposite);
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
    public void updateProject(int oldId, String newProjectName, double projectPrice, double projectDeposite) {


        //Set firstLetter to upperCase and set last to lowerLetters
        newProjectName = convertString.convertString(newProjectName);

        QueryGeneratorHouse query = new QueryGeneratorHouse();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryUpdateData(oldId, newProjectName, projectPrice, projectDeposite);
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
    public void deleteProject(String projectName) {


        //Because every names starts with a Capital, Rest lowerCases
        int countLettersName = projectName.length();
        String firstLetter = projectName.substring(0,1).toUpperCase();
        String lastLetters = projectName.substring(1,countLettersName).toLowerCase();

        projectName = firstLetter + lastLetters;

        QueryGeneratorHouse query = new QueryGeneratorHouse();

        try {
            statement = DbConnection.getConnection().createStatement();
            String queryCommand = query.queryDeleteData(projectName);
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
