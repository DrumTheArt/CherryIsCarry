package com.wachs.tests.unitTest.QueryGenerator;

import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorFood;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorFoodDrinks {

    @Test
    public void fetchQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, INT_nights, ID_guest, ID_project from TBL_FOOD WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorFood foodQuery = new QueryGeneratorFood();

        //Act
        String result = foodQuery.fetchQueryFoodOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_FOOD(FK_id,INT_nights,ID_guest,ID_project) VALUES (? ,'3',1,1)";
        QueryGeneratorFood foodQuery = new QueryGeneratorFood();

        //Act
        String result = foodQuery.insertQueryFoodOneGuest(1, 1, 3);

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_FOOD WHERE ID_guest=1 AND ID_project = 1";
        QueryGeneratorFood foodQuery = new QueryGeneratorFood();

        //Act
        String result = foodQuery.deleteQueryFoodOneGuest(1, 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_FOOD SET INT_nights = 3 WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorFood foodQuery = new QueryGeneratorFood();

        //Act
        String result = foodQuery.updateQueryFoodOneGuest(1, 1, 3);

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void fetchAllQueryFoodOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_FOOD where ID_project = 1";
        QueryGeneratorFood foodQuery = new QueryGeneratorFood();

        //Act
        String result = foodQuery.fetchAllQueryFoodOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }
}