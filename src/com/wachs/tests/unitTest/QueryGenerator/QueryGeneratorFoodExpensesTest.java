package com.wachs.tests.unitTest.QueryGenerator;

import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorFoodExpenses;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorFoodExpensesTest {

    @Test
    public void fetchFoodExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project from TBL_FOODEXPENSE WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorFoodExpenses foodExpensesQuery = new QueryGeneratorFoodExpenses();

        //Act
        String result = foodExpensesQuery.fetchFoodExpensesOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryFoodExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_FOODEXPENSE(FK_id,REAL_spend,TXT_reason,TXT_when,ID_guest,ID_project) VALUES (? ,200.0,'The reason','01.01.2019',1,1)";
        QueryGeneratorFoodExpenses foodExpensesQuery = new QueryGeneratorFoodExpenses();

        //Act
        String result = foodExpensesQuery.insertQueryFoodExpensesOneGuest(1, 1, 200.0, "The reason", "01.01.2019");

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteFoodExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_FOODEXPENSE WHERE ID_guest=1 AND ID_project = 1 AND FK_id = 1";
        QueryGeneratorFoodExpenses foodExpensesQuery = new QueryGeneratorFoodExpenses();

        //Act
        String result = foodExpensesQuery.deleteFoodExpensesOneGuest(1, 1, 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryFoodExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_FOODEXPENSE SET REAL_spend = 200.0 ,TXT_reason='The second new reason' ,TXT_when = '01.02.2019' WHERE ID_guest = 1 AND ID_project = 1 AND FK_id = 1";
        QueryGeneratorFoodExpenses foodExpensesQuery = new QueryGeneratorFoodExpenses();

        //Act
        String result = foodExpensesQuery.updateQueryFoodExpensesOneGuest(1, 1, 1, 200.0, "The second new reason", "01.02.2019");

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void fetchAllFoodExpensesOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_FOODEXPENSE WHERE ID_project = 1";
        QueryGeneratorFoodExpenses foodExpensesQuery = new QueryGeneratorFoodExpenses();

        //Act
        String result = foodExpensesQuery.fetchAllFoodExpensesOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }
}