package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorFoodExpenses {

    public static final String TABLENAME = "TBL_FOODEXPENSE";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_spend";
    public static String COLUMN3 = "TXT_reason";
    public static String COLUMN4 = "TXT_when";
    public static String COLUMN5 = "ID_guest";
    public static String COLUMN6 = "ID_project";

    public String fetchAllFoodExpensesOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN6 + " = " + idProject;

        return query;
    }

    public String fetchFoodExpensesOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + ", " + COLUMN5 + ", " + COLUMN6 + " from " + TABLENAME + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " +idProject;

        return query;
    }

    public String deleteFoodExpensesOneGuest(int idGuest, int idProject, double foodExpensesPrice, String foodExpensesReason, String foodExpensesWhen) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN5 + "=" + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + foodExpensesPrice + " AND " + COLUMN3 + " = " + "'" + foodExpensesReason + "'" + " AND " + COLUMN4 + " = " + "'" + foodExpensesWhen + "'";

        return query;
    }

    public String insertQueryFoodExpensesOneGuest(int idGuest, int idProject, double foodExpensesPrice, String foodExpensesReason, String foodExpensesWhen) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + "," + COLUMN5 + "," + COLUMN6 + ") VALUES (? ," + foodExpensesPrice + "," + "'" + foodExpensesReason + "'" + "," + "'" + foodExpensesWhen + "'" + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String updateQueryFoodExpensesOneGuest(int idGuest, int idProject, double foodExpensesPrice, String foodExpensesReason, String foodExpensesWhen, double foodExpensesNewPrice, String foodExpensesNewReason, String foodExpensesNewWhen) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + foodExpensesNewPrice + " ," + COLUMN3 + "=" + "'" + foodExpensesNewReason + "'" + " ," + COLUMN4 + " = " + "'" + foodExpensesNewWhen + "'" + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + foodExpensesPrice + " AND " + COLUMN3 + " = " + "'" + foodExpensesReason + "'" + " AND " + COLUMN4 + " = " + "'" + foodExpensesWhen + "'";

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}