package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorProject;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorProject.*;

public class ProjectDAOImpl implements ProjectDAO {

    private ArrayList<Project> allProjects;
    private Project aProject;
    private ConverterStringForDataBase convertString;
    private QueryGeneratorProject query;
    private Statement statement;
    private ResultSet result;

    public ProjectDAOImpl() {

        aProject = new Project();
        allProjects = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorProject();

    }

    @Override
    public Project findOneProject(String name) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);
        String queryCommand = query.queryFindOneProject(name);


        try {

            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

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

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aProject;
    }

    @Override
    public ArrayList findAllProjects() {

        String queryCommand = query.queryFindAllProjects();

        try {

            statement = DbConnection.getConnection().createStatement();
            result = statement.executeQuery(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

            while (result.next()) {

                allProjects.add(new Project(result.getInt(COLUMN1), result.getString(COLUMN2), result.getDouble(COLUMN3), result.getDouble(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            result.close();
            statement.close();
            DbConnection.closeConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allProjects;
    }

    @Override
    public void insertProject(String projectName, double projectPrice, double projectDeposite) {

        //Set firstLetter to upperCase and set last to lowerLetters
        projectName = convertString.convertString(projectName);
        String queryCommand = query.queryInsertOneProject(projectName, projectPrice, projectDeposite);

        try {

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
    public void updateProject(int oldId, String newProjectName, double projectPrice, double projectDeposite) {

        //Set firstLetter to upperCase and set last to lowerLetters
        newProjectName = convertString.convertString(newProjectName);
        String queryCommand = query.queryUpdateOneProject(oldId, newProjectName, projectPrice, projectDeposite);

        try {

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
    public void deleteProject(String projectName) {

        //Because every names starts with a Capital, Rest lowerCases
        projectName = convertString.convertString(projectName);

        String queryCommand = query.queryDeleteOneProject(projectName);

        try {

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