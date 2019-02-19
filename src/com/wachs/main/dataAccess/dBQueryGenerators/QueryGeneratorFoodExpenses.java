package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorFoodExpenses {

    public static final String TABLENAME = "TBL_FOODEXPENSE";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_spend";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_project";

    public String queryFindAllFoodExpensesByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " where " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryFindFoodExpensesByOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryDeleteFoodExpensesForOneGuest(int idGuest, int idProject, double spend) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject + " AND " + COLUMN2 + " = " + spend;

        return query;
    }

    public String queryInsertFoodExpensesForOneGuest(int idGuest, int idProject, double spend) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + spend + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String queryUpdateFoodExpensesForOneGuest(int idGuest, int idProject, double oldSpendValue, double newSpendValue) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + newSpendValue + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " + idProject + " AND " + COLUMN2 + " = " + oldSpendValue;

        return query;
    }
}
