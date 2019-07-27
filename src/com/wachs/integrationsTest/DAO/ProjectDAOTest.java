package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Drinks;
import com.wachs.main.POJO.Project;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class ProjectDAOTest {

    @Before
    public void setUp(){

        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

    }

    @Test
    public void fetchOneProject_ShouldReturnCorrectDrinkObject() {

        //Act
        Project projectToFind = projectDAO.fetchOneProject(setupNameProject);

        //Assert
        Assert.assertEquals(projectToFind.getProjectName(), setupNights);

    }

    @Test
    public void fetchOneProject_IfNotExistInDB_ShouldReturnException() {


    }


    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectObject() {


    }

    @Test
    public void fetchAllProjects_ShouldThrowSQLException() {


    }

    @Test
    public void fetchAllProjects_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void updateProject_ShouldReturnCorrectProjectObject() {


    }

    @Test
    public void updateProject_IfNotExistInDB_ShouldReturnException() {


    }

    @Test
    public void updateProject_ShouldThrowSQLException() {


    }

    @Test
    public void deleteProject_ShouldNotReturnAlreadyDeletedProjectObject() {


    }

    @Test
    public void deleteProject_ShouldThrowSQLException() {


    }

    @Test
    public void insertProject_ShouldReturnInsertProjectObject() {


    }

    @Test
    public void insertProject_IfAlreadyExistInDB_ShouldReturnException() {


    }

    @Test
    public void insertProject_ShouldThrowSQLException() {


    }

}