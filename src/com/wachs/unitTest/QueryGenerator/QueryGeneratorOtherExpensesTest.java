package com.wachs.unitTest.QueryGenerator;

import com.wachs.main.dataAccess.dBQueryGenerators.QueryGeneratorOtherExpenses;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorOtherExpensesTest {

    @Test
    public void fetchQueryOtherExpensesOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project from TBL_OTHEREXPENSE WHERE ID_guest = 1 AND ID_project = 1";
        QueryGeneratorOtherExpenses otherExpensesQuery = new QueryGeneratorOtherExpenses();

        //Act
        String result = otherExpensesQuery.fetchQueryOtherExpensesOneGuest(1, 1);

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_OTHEREXPENSE(FK_id,REAL_spend,TXT_reason,TXT_when,ID_guest,ID_project) VALUES (? ,200.0,'The reason','01.01.2019',1,1)";
        QueryGeneratorOtherExpenses otherExpensesQuery = new QueryGeneratorOtherExpenses();
        //Act
        String result = otherExpensesQuery.insertQueryOtherExpensesOneGuest(1, 1, 200.0, "The reason", "01.01.2019");

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_OTHEREXPENSE WHERE ID_guest=1 AND ID_project = 1 AND FK_id = 1";
        QueryGeneratorOtherExpenses otherExpensesQuery = new QueryGeneratorOtherExpenses();
        //Act
        String result = otherExpensesQuery.deleteQueryOtherExpensesOneGuest(1, 1, 1);

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_OTHEREXPENSE SET REAL_spend = 800.0 ,TXT_reason='The second new reason' ,TXT_when = '01.12.2019' WHERE ID_guest = 1 AND ID_project = 1 AND FK_id = 1";
        QueryGeneratorOtherExpenses otherExpensesQuery = new QueryGeneratorOtherExpenses();

        //Act
        String result = otherExpensesQuery.updateQueryOtherExpensesOneGuest(1, 1, 1, 800.0, "The second new reason", "01.12.2019");

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void fetchQueryAllGuestsOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_OTHEREXPENSE WHERE ID_project = 1";
        QueryGeneratorOtherExpenses otherExpensesQuery = new QueryGeneratorOtherExpenses();
        //Act
        String result = otherExpensesQuery.fetchQueryAllOtherExpensesOneProject(1);

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }
}