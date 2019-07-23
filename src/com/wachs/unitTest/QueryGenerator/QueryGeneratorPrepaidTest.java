package com.wachs.unitTest.QueryGenerator;

import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorPrepaid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorPrepaidTest {

    @Test
    public void fetchQueryPrepaidOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, REAL_prepaid, ID_guest, ID_project from TBL_PREPAID WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorPrepaid prepaidQuery = new QueryGeneratorPrepaid();

        //Act
        String result = prepaidQuery.fetchQueryPrepaidOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryPrepaidOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_PREPAID(FK_id,REAL_prepaid,ID_guest,ID_project) VALUES (? ,200.0,1,1)";
        QueryGeneratorPrepaid prepaidQuery = new QueryGeneratorPrepaid();

        //Act
        String result = prepaidQuery.insertQueryPrepaidOneGuest(1, 1, 200.0);

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryPrepaidOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_PREPAID WHERE ID_guest=1 AND ID_project = 1";
        QueryGeneratorPrepaid prepaidQuery = new QueryGeneratorPrepaid();

        //Act
        String result = prepaidQuery.deleteQueryPrepaidOneGuest(1, 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryPrepaidOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_PREPAID SET REAL_prepaid = 800.0 WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorPrepaid prepaidQuery = new QueryGeneratorPrepaid();

        //Act
        String result = prepaidQuery.updateQueryPrepaidOneGuest(1, 1, 800.0);

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void FetchQueryAllPrepaidOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_PREPAID WHERE ID_project = 1";
        QueryGeneratorPrepaid prepaidQuery = new QueryGeneratorPrepaid();

        //Act
        String result = prepaidQuery.fetchQueryAllPrepaidOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }
}