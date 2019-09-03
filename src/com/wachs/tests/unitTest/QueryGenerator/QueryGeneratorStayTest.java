package com.wachs.tests.unitTest.QueryGenerator;

import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorStay;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorStayTest {

    @Test
    public void fetchQueryStayOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, INT_nights, ID_guest, ID_project from TBL_STAY WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorStay stayQuery = new QueryGeneratorStay();

        //Act
        String result = stayQuery.fetchQueryStayOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryStayOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_STAY(FK_id,INT_nights,ID_guest,ID_project) VALUES (? ,'3',1,1)";
        QueryGeneratorStay stayQuery = new QueryGeneratorStay();

        //Act
        String result = stayQuery.insertQueryStayOneGuest(1, 1, 3);

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryStayOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_STAY WHERE ID_guest=1 AND ID_project = 1";
        QueryGeneratorStay stayQuery = new QueryGeneratorStay();

        //Act
        String result = stayQuery.deleteQueryStayOneGuest(1, 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryStayOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_STAY SET INT_nights = 3 WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorStay stayQuery = new QueryGeneratorStay();

        //Act
        String result = stayQuery.updateQueryStayOneGuest(1, 1, 3);

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void fetchAllStayOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProjects = "SELECT * FROM TBL_STAY WHERE ID_project = 1";
        QueryGeneratorStay stayQuery = new QueryGeneratorStay();

        //Act
        String result = stayQuery.fetchAllStayOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProjects);
    }
}