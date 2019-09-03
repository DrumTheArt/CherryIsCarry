package com.wachs.tests.unitTest.QueryGenerator;

import com.wachs.main.DataAccess.dBQueryGenerators.QueryGeneratorDrinksExpenses;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorDrinksExpensesTest {

    @Test
    public void fetchAllQueryDrinksExpensesOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_DRINKEXPENSE WHERE ID_project = 1";
        QueryGeneratorDrinksExpenses drinksQuery = new QueryGeneratorDrinksExpenses();

        //Act
        String result = drinksQuery.fetchAllQueryDrinksExpensesOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }

    @Test
    public void fetchDrinksExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project from TBL_DRINKEXPENSE WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorDrinksExpenses drinksQuery = new QueryGeneratorDrinksExpenses();

        //Act
        String result = drinksQuery.fetchDrinksExpensesOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    /**
    @Test
    public void deleteQueryDrinksExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_DRINKEXPENSE WHERE ID_guest=1 AND ID_project = 1 AND REAL_spend = 800.0 AND TXT_reason = 'The second new reason' AND TXT_when = '01.12.2019'";
        QueryGeneratorDrinksExpenses drinksQuery = new QueryGeneratorDrinksExpenses();

        //Act
        String result = drinksQuery.deleteQueryDrinksExpensesOneGuest(1, 1, 800.0, "The second new reason", "01.12.2019");

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }
     **/
    @Test
    public void insertQueryDrinksExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_DRINKEXPENSE(FK_id,REAL_spend,TXT_reason,TXT_when,ID_guest,ID_project) VALUES (? ,200.0,'The reason','01.01.2019',1,1)";
        QueryGeneratorDrinksExpenses drinksQuery = new QueryGeneratorDrinksExpenses();

        //Act
        String result = drinksQuery.insertQueryDrinksExpensesOneGuest(1, 1, 200.0, "The reason", "01.01.2019");

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }
    /**
    @Test
    public void updateQueryDrinksExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_DRINKEXPENSE SET REAL_spend = 200.0 ,TXT_reason='The second new reason' ,TXT_when = '01.12.2019' WHERE ID_guest = 1 AND ID_project = 1 AND REAL_spend = 800.0 AND TXT_reason = 'The reason' AND TXT_when = '01.01.2019'";
        QueryGeneratorDrinksExpenses drinksQuery = new QueryGeneratorDrinksExpenses();

        //Act
        String result = drinksQuery.updateQueryDrinksExpensesOneGuest(1, 1, 800.0, "The reason", "01.01.2019", 200.0, "The second new reason", "01.12.2019");

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }
     **/
}