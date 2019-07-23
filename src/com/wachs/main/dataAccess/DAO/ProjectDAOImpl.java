package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorProject;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.DbConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.dataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorProject.*;

public class ProjectDAOImpl implements ProjectDAO {

    private ArrayList<Project> allProjects;
    private Project aSingleProject;
    private ConverterStringForDataBase convertString;
    private QueryGeneratorProject query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private DbConnection connection;

    public ProjectDAOImpl() {

        aSingleProject = new Project();
        allProjects = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorProject();
        connection = new DbConnection();

    }

    @Override
    public Project fetchOneProject(String name) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);
        String queryCommand = query.fetchQueryOneProject(name);


        try {

            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            //Get db-attributes
            int pk_id = queryResult.getInt(1);
            String txt_name = queryResult.getString(2);
            double real_price = queryResult.getDouble(3);
            double reaL_deposite = queryResult.getDouble(4);

            //Set db-attributes into GuestObject
            createProjectObject(pk_id, txt_name, real_price, reaL_deposite);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aSingleProject;
    }

    @Override
    public ArrayList fetchAllProjects() {

        String queryCommand = query.fetchQueryAllProjects();

        try {

            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allProjects.add(new Project(queryResult.getInt(COLUMN1), queryResult.getString(COLUMN2), queryResult.getDouble(COLUMN3), queryResult.getDouble(COLUMN4)));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return allProjects;
    }

    @Override
    public void insertProject(String projectName, double projectPrice, double projectDeposite) {

        //Set firstLetter to upperCase and set last to lowerLetters
        projectName = convertString.convertString(projectName);
        String queryCommand = query.insertQueryOneProject(projectName, projectPrice, projectDeposite);

        try {

            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }
        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateProject(int oldId, String newProjectName, double projectPrice, double projectDeposite) {

        //Set firstLetter to upperCase and set last to lowerLetters
        newProjectName = convertString.convertString(newProjectName);
        String queryCommand = query.updateQueryOneProject(oldId, newProjectName, projectPrice, projectDeposite);

        try {

            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void deleteProject(String projectName) {

        //Because every names starts with a Capital, Rest lowerCases
        projectName = convertString.convertString(projectName);

        String queryCommand = query.deleteQueryOneProject(projectName);

        try {

            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            ApplicationLogger.loggingQueries(queryCommand);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            closingAllConnections();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private void closingAllConnections() throws SQLException {

        queryStatement.close();
        queryResult.close();
        connection.closeConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    private void createProjectObject(int pk_id, String txt_name, double real_price, double reaL_deposite) {

        aSingleProject.setPK_id(pk_id);
        aSingleProject.setProjectName(txt_name);
        aSingleProject.setProjectPrice(real_price);
        aSingleProject.setProjectDeposite(reaL_deposite);

    }
}