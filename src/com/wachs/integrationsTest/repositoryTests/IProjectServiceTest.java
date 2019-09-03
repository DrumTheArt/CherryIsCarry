package com.wachs.integrationsTest.repositoryTests;

import com.wachs.integrationsTest.util.GeneratorTestData;
import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.wachs.main.dataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.wachs.main.dataAccess.services.ProjectService;
import com.wachs.main.exceptions.NotInDataBaseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.wachs.integrationsTest.util.GeneratorTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IProjectServiceTest {

    @Test
    public void fetchOneProject_ShouldReturnCorrectProjectName() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        Project projectToFind = IProjectService.fetchOneProject(setupNameProjectOne);

        //Arrange
        assertThat(projectToFind.getName(), is(setupNameProjectOne));

    }

    @Test
    public void fetchOneProject_ShouldReturnCorrectProjectPrice() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        double priceProject = IProjectService.fetchOneProject(setupNameProjectOne).getPrice();

        //Arrange
        Assert.assertEquals(setupProjectPrice, priceProject,0.01);

    }

    @Test
    public void fetchOneProject_ShouldReturnCorrectProjectDeposite() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        double priceProject = IProjectService.fetchOneProject(setupNameProjectOne).getDeposite();

        //Arrange
        Assert.assertEquals(setupProjectDeposite, priceProject,0.01);

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchOneProject_ShouldThrowNotInDataBaseExceptionProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IProjectService.fetchOneProject("TheNoneExistingProject");

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectAmountOfProjects() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listProjectsToFind = new ProjectService(con, false).fetchAllProjects();

        //Assert
        assertThat(listProjectsToFind.size(), is(countAllProjects));

    }

    @Test(expected = NotInDataBaseException.class)
    public void fetchAllProjects_ShouldThrowNotInDataBaseExceptionProjectNotExist() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        IProjectService.deleteProject(setupNameProjectOne);
        IProjectService.deleteProject(setupNameProjectTwo);
        IProjectService.deleteProject(newNameProject);

        IProjectService.fetchAllProjects();

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectIdOfFirstElementInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listProjectToFind = new ProjectService(con, false).fetchAllProjects();
        List<Project> newList = listProjectToFind.stream().filter(x -> x.getPrimaryKey() == projectOneID).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getPrimaryKey(), is(projectOneID));

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectPriceOfFirstElementInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectService(con, false).fetchAllProjects();

        Optional<Project> result = listDrinksToFind.stream().filter(x -> x.getName().equals(setupNameProjectOne)).findFirst();

        //Assert
        Assert.assertEquals(setupProjectPrice, result.get().getPrice(), 0.01);

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectDepositeOfFirstElementInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectService(con, false).fetchAllProjects();

        //Assert
        Assert.assertEquals(listDrinksToFind.get(0).getDeposite(), setupProjectDeposite, 0.01);

    }

    @Test
    public void fetchAllProjects_ShouldReturnCorrectProjectNameOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectService(con, false).fetchAllProjects();

        Optional<Project> result = listDrinksToFind.stream().filter(x -> x.getName().equals(setupNameProjectOne)).findFirst();

        //Assert
        assertThat(result.get().getName(), is(setupNameProjectOne));

    }

    @Test
    public void fetchAllProjects_ShouldNotReturnIncorrectProjectNameOfFirstGuestInList() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IDBConnection con = new TestDBConnection();

        //Act
        ArrayList<Project> listDrinksToFind = new ProjectService(con, false).fetchAllProjects();
        List<Project> newList = listDrinksToFind.stream().filter(x -> x.getName().equals(setupNameProjectTwo)).collect(Collectors.toList());

        //Assert
        assertThat(newList.get(0).getName(), is(setupNameProjectTwo));

    }

    @Test
    public void updateProject_ShouldReturnUpdatedPrice() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newPrice = 100000;

        //Act
        IProjectService.updateProject(projectOneID, setupNameProjectOne, newPrice, setupProjectDeposite);
        Project projectToFind = IProjectService.fetchOneProject(setupNameProjectOne);

        //Assert
        Assert.assertEquals(newPrice, projectToFind.getPrice(), 0.01);

    }

    @Test
    public void updateProject_ShouldReturnUpdatedDeposite() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        int newDeposite = 20000;

        //Act
        IProjectService.updateProject(projectOneID, setupNameProjectOne, newDeposite, setupProjectDeposite);
        Project projectToFind = IProjectService.fetchOneProject(setupNameProjectOne);

        //Assert
        Assert.assertEquals(newDeposite, projectToFind.getPrice(), 0.01);

    }

    @Test
    public void updateProject_ShouldReturnUpdatedName() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IProjectService.deleteProject(newNameProject);

        //Act
        IProjectService.updateProject(projectOneID, newNameProject, setupProjectPrice, setupProjectDeposite);
        Project projectToFind = IProjectService.fetchOneProject(newNameProject);

        //Assert
        assertThat(projectToFind.getName(), is(newNameProject));

    }

    @Test(expected = NotInDataBaseException.class)
    public void deleteProject_ShouldThrowExceptionIfFetchingAlreadyDeletedProjectObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();

        //Act
        IProjectService.deleteProject(setupNameProjectOne);
        IProjectService.fetchOneProject(setupNameProjectOne);

    }

    @Test
    public void insertDrinksOneGuest_ShouldReturnInsertedNewProjectObject() {

        //Arrange
        GeneratorTestData.createObjects();
        GeneratorTestData.insertTestdataToDataBase();
        IProjectService.deleteProject(newNameProject);
        IProjectService.insertProject(newNameProject, setupProjectPrice, setupProjectDeposite);

        //Act
        Project newDrinks = IProjectService.fetchOneProject(newNameProject);

        //Assert
        assertThat(newDrinks.getName(), is(newNameProject));

    }
}