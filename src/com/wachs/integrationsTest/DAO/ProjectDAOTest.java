package com.wachs.integrationsTest.DAO;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.Exceptions.NotInDataBaseException;
import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;

public class ProjectDAOTest {

    @Test
    public void fetchOneProject_ShouldReturnCorrectProjectName() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Project projectToFind = projectDAO.fetchOneProject(setupNameProjectOne);

        //Arrange
        Assert.assertEquals(setupNameProjectOne, projectToFind.getProjectName());

    }

    @Test
    public void fetchOneProject_ShouldReturnCorrectProjectPrice() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        double priceProject = projectDAO.fetchOneProject(setupNameProjectOne).getProjectPrice();

        //Arrange
        Assert.assertEquals(setupProjectPrice, priceProject,0.01);

    }

    @Test
    public void fetchOneProject_ShouldReturnCorrectProjectDeposite() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        double priceProject = projectDAO.fetchOneProject(setupNameProjectOne).getProjectDeposite();

        //Arrange
        Assert.assertEquals(setupProjectDeposite, priceProject,0.01);

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchOneProject_ShouldThrowNotInDataBaseExceptionProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        projectDAO.fetchOneProject("TheNoneExistingProject");

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectAmountOfProjects() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listProjectsToFind = new ProjectDAOImpl(con, false).fetchAllProjects();

        //Assert
        Assert.assertEquals(countAllProjects, listProjectsToFind.size());

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllProjects_ShouldThrowNotInDataBaseExceptionProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        projectDAO.fetchAllProjects();

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectIDOfFirstElementInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listProjectToFind = new ProjectDAOImpl(con, false).fetchAllProjects();

        //Assert
        Assert.assertEquals(projectOneID, listProjectToFind.get(0).getPK_id());

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectPriceOfFirstElementInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectDAOImpl(con, false).fetchAllProjects();

        Optional<Project> result = listDrinksToFind.stream().filter(x -> x.getProjectName().equals(setupNameProjectOne)).findFirst();

        //Assert
        Assert.assertEquals(setupProjectPrice, result.get().getProjectPrice(), 0.01);

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectDepositeOfFirstElementInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectDAOImpl(con, false).fetchAllProjects();

        //Assert
        Assert.assertEquals(listDrinksToFind.get(0).getProjectDeposite(), setupProjectDeposite, 0.01);

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectNameOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectDAOImpl(con, false).fetchAllProjects();

        Optional<Project> result = listDrinksToFind.stream().filter(x -> x.getProjectName().equals(setupNameProjectOne)).findFirst();
        
        //Assert
        Assert.assertEquals(setupNameProjectOne, result.get().getProjectName());

    }

    @Test
    public void fetchAllProjects_ShouldNotReturnIncorrectProjectNameOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectDAOImpl(con, false).fetchAllProjects();

        //Assert
        Assert.assertNotEquals(listDrinksToFind.get(0).getProjectName(), setupNameProjectTwo);

    }

    @Test
    public void updateProject_ShouldReturnUpdatedPrice() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newPrice = 100000;

        //Act
        projectDAO.updateProject(projectOneID, setupNameProjectOne, newPrice, setupProjectDeposite);
        Project projectToFind = projectDAO.fetchOneProject(setupNameProjectOne);

        //Assert
        Assert.assertEquals(newPrice, projectToFind.getProjectPrice(), 0.01);

    }

    @Test
    public void updateProject_ShouldReturnUpdatedDeposite() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newDeposite = 20000;

        //Act
        projectDAO.updateProject(projectOneID, setupNameProjectOne, newDeposite, setupProjectDeposite);
        Project projectToFind = projectDAO.fetchOneProject(setupNameProjectOne);

        //Assert
        Assert.assertEquals(newDeposite, projectToFind.getProjectPrice(), 0.01);

    }

    @Test
    public void updateProject_ShouldReturnUpdatedName() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        String newName = "Newprojectname2";
        projectDAO.deleteProject(newName);

        //Act
        projectDAO.updateProject(projectOneID, newName, setupProjectPrice, setupProjectDeposite);
        Project projectToFind = projectDAO.fetchOneProject(newName);

        //Assert
        Assert.assertEquals(newName, projectToFind.getProjectName());

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteProject_ShouldThrowExceptionIfFetchingAlreadyDeletedProjectObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        projectDAO.deleteProject(setupNameProjectOne);
        projectDAO.fetchOneProject(setupNameProjectOne);

    }

    @Test
    public void insertDrinksOneGuest_ShouldReturnInsertedNewProjectObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        projectDAO.deleteProject("Justforthistestproject");
        projectDAO.insertProject("Justforthistestproject", setupProjectPrice, setupProjectDeposite);

        //Act
        Project newDrinks = projectDAO.fetchOneProject("Justforthistestproject");

        //Assert
        Assert.assertEquals("Justforthistestproject", newDrinks.getProjectName());

    }
}