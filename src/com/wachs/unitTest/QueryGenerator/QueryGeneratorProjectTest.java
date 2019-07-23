package com.wachs.unitTest.QueryGenerator;

import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorProject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorProjectTest {

    @Test
    public void fetchQueryOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneProject = "SELECT PK_id, TXT_title, REAL_projectPrice, REAL_projectDeposite from TBL_PROJECT WHERE TXT_title = 'The Project 2019'";
        QueryGeneratorProject projectQuery = new QueryGeneratorProject();

        //Act
        String result = projectQuery.fetchQueryOneProject("The Project 2019");

        //Assert
        assertEquals(result, fetchQueryOneProject);
    }

    @Test
    public void insertQueryOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneProject = "INSERT INTO TBL_PROJECT(PK_id,TXT_title,REAL_projectPrice,REAL_projectDeposite) VALUES (? ,'The Project 2019',5000.0,2000.0)";
        QueryGeneratorProject projectQuery = new QueryGeneratorProject();

        //Act
        String result = projectQuery.insertQueryOneProject("The Project 2019", 5000.0, 2000.0);

        //Assert
        assertEquals(result, insertQueryOneProject);
    }

    @Test
    public void deleteQueryOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneProject = "DELETE FROM TBL_PROJECT WHERE TXT_title='The new Project 2019'";
        QueryGeneratorProject projectQuery = new QueryGeneratorProject();

        //Act
        String result = projectQuery.deleteQueryOneProject("The new Project 2019");

        //Assert
        assertEquals(result, deleteQueryOneProject);
    }

    @Test
    public void updateQueryOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneProject = "UPDATE TBL_PROJECT SET TXT_title = 'The new Project 2019', REAL_projectPrice=5000.0,REAL_projectDeposite=2000.0 WHERE PK_id = 1";
        QueryGeneratorProject projectQuery = new QueryGeneratorProject();

        //Act
        String result = projectQuery.updateQueryOneProject(1, "The new Project 2019", 5000.0, 2000.0);

        //Assert
        assertEquals(result, updateQueryOneProject);
    }

    @Test
    public void fetchQueryAllProjects_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryAllProjects = "SELECT * FROM TBL_PROJECT";
        QueryGeneratorProject projectQuery = new QueryGeneratorProject();

        //Act
        String result = projectQuery.fetchQueryAllProjects();

        //Assert
        assertEquals(result, fetchAllQueryAllProjects);
    }
}