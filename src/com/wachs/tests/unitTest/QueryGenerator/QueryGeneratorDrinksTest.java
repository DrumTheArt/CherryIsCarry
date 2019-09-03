package com.wachs.tests.unitTest.QueryGenerator;

import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorDrinks;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorDrinksTest {

    @Test
    public void fetchQueryOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, INT_nights, ID_guest, ID_project from TBL_DRINKS WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorDrinks drinksQuery = new QueryGeneratorDrinks();

        //Act
        String result = drinksQuery.fetchQueryOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void fetchAllOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllOneProject = "SELECT * FROM TBL_DRINKS where ID_project = 1";
        QueryGeneratorDrinks drinksQuery = new QueryGeneratorDrinks();

        //Act
        String result = drinksQuery.fetchAllOneProject(1);

        //Assert
        assertEquals(result, fetchAllOneProject);
    }

    @Test
    public void insertQueryOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_DRINKS(FK_id,INT_nights,ID_guest,ID_project) VALUES (? ,3,1,1)";
        QueryGeneratorDrinks drinksQuery = new QueryGeneratorDrinks();

        //Act
        String result = drinksQuery.insertQueryOneGuest(1, 1, 3);

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_DRINKS WHERE ID_guest=1 AND ID_project = 1";
        QueryGeneratorDrinks drinksQuery = new QueryGeneratorDrinks();

        //Act
        String result = drinksQuery.deleteQueryOneGuest(1, 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryForOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_DRINKS SET INT_nights = 3 WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorDrinks drinksQuery = new QueryGeneratorDrinks();

        //Act
        String result = drinksQuery.updateQueryForOneGuest(1, 1, 3);

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }
}