package com.wachs.unitTest.QueryGenerator;

import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorGuest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorGuestTest {

    @Test
    public void fetchQueryOneGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT PK_id, ID_project, TXT_guestName from TBL_GUEST WHERE TXT_guestName = 'Robert' AND ID_project = 1";
        QueryGeneratorGuest guestQuery = new QueryGeneratorGuest();

        //Act
        String result = guestQuery.fetchQueryOneGuestOneProject("Robert", 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_GUEST(PK_id,ID_project,TXT_guestName) VALUES (? ,1,'Robert')";
        QueryGeneratorGuest guestQuery = new QueryGeneratorGuest();

        //Act
        String result = guestQuery.insertQueryGuestOneProject("Robert", 1);

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_GUEST WHERE TXT_guestName='Robert der Zweite' AND ID_project=1";
        QueryGeneratorGuest guestQuery = new QueryGeneratorGuest();

        //Act
        String result = guestQuery.deleteQueryGuestOneProject("Robert der Zweite", 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_GUEST SET TXT_guestName = 'Robert der Zweite' WHERE PK_id=1 AND ID_project =1";
        QueryGeneratorGuest guestQuery = new QueryGeneratorGuest();

        //Act
        String result = guestQuery.updateQueryGuestOneProject(1, "Robert der Zweite", 1);

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void fetchQueryAllGuestsOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_GUEST WHERE ID_project = 1";
        QueryGeneratorGuest guestQuery = new QueryGeneratorGuest();

        //Act
        String result = guestQuery.fetchQueryAllGuestsOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }
}