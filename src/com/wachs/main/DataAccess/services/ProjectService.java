package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Project;
import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorProject;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.DBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.DataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.wachs.main.DataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase;
import com.wachs.main.Exceptions.NotInDataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorProject.*;

public class ProjectService implements IProjectService {

    private ArrayList<Project> allProjects;
    private Project aSingleProject;
    private ConverterStringForDataBase convertString;
    private QueryGeneratorProject query;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public ProjectService() {

        aSingleProject = new Project();
        allProjects = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorProject();
        connection = new DBConnection();
        this.isLoggerActivated = true;

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public ProjectService(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        aSingleProject = new Project();
        allProjects = new ArrayList<>();
        convertString = new ConverterStringForDataBase();
        query = new QueryGeneratorProject();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }

    @Override
    public Project fetchOneProject(String name) {

        //Set firstLetter to upperCase and set last to lowerLetters
        name = convertString.convertString(name);
        String queryCommand = query.fetchQueryOneProject(name);

        try {

            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

                if (queryResult.next()) {

                    //Get db-attributes
                    int pk_id = queryResult.getInt(1);
                    String txt_name = queryResult.getString(2);
                    double real_price = queryResult.getDouble(3);
                    double reaL_deposite = queryResult.getDouble(4);

                    //Set db-attributes into GuestObject
                    createProjectObject(pk_id, txt_name, real_price, reaL_deposite);
                }

                else {

                    throw new NotInDataBaseException();

                }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryResult.close();
            queryStatement.close();


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return aSingleProject;
    }

    @Override
    public ArrayList fetchAllProjects() {

        String queryCommand = query.fetchQueryAllProjects();

        allProjects.clear();

        try {

            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                int i = 0;
                allProjects.add(new Project(queryResult.getInt(COLUMN1), queryResult.getString(COLUMN2), queryResult.getDouble(COLUMN3), queryResult.getDouble(COLUMN4)));

            }

            if(allProjects.isEmpty()){

                throw new NotInDataBaseException();
            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

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
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateProject(int oldId, String newProjectName, double newProjectPrice, double newProjectDeposite) {

        //Set firstLetter to upperCase and set last to lowerLetters
        newProjectName = convertString.convertString(newProjectName);
        String queryCommand = query.updateQueryOneProject(oldId, newProjectName, newProjectPrice, newProjectDeposite);

        try {

            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();


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
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    private void createProjectObject(int pk_id, String txt_name, double real_price, double reaL_deposite) {

        aSingleProject.setPrimaryKey(pk_id);
        aSingleProject.setName(txt_name);
        aSingleProject.setPrice(real_price);
        aSingleProject.setDeposite(reaL_deposite);

    }
}