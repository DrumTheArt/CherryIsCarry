package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorDrinksExpenses {

    public static final String TABLENAME = "TBL_DRINKEXPENSE";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_spend";
    public static String COLUMN3 = "TXT_reason";
    public static String COLUMN4 = "TXT_when";
    public static String COLUMN5 = "ID_guest";
    public static String COLUMN6 = "ID_project";

    public String fetchAllQueryDrinksExpensesOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN6 + " = " + idProject;

        return query;
    }

    public String fetchDrinksExpensesOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + ", " + COLUMN5 + ", " + COLUMN6 + " from " + TABLENAME + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " +idProject;

        return query;
    }

    public String deleteQueryDrinksExpensesOneGuest(int idGuest, int idProject, int pk_id) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN5 + "=" + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN1 + " = " + pk_id;

        return query;
    }

    public String insertQueryDrinksExpensesOneGuest(int idGuest, int idProject, double drinksExpensesPrice, String drinksExpensesReason, String drinksExpensesWhen) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + "," + COLUMN5 + "," + COLUMN6 + ") VALUES (? ," + drinksExpensesPrice + "," + "'" + drinksExpensesReason + "'" + "," + "'" + drinksExpensesWhen + "'" + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String updateQueryDrinksExpensesOneGuest(int idGuest, int idProject, int pk_id, double drinksExpensesNewPrice, String drinksExpensesNewReason, String drinksExpensesWhen) {

        //String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + drinksExpensesNewPrice + " ," + COLUMN3 + "=" + "'" + drinksExpensesNewReason + "'" + " ," + COLUMN4 + " = " + "'" + drinksExpensesNewWhen + "'" + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + drinksExpensesPrice + " AND " + COLUMN3 + " = " + "'" + drinksExpensesReason + "'" + " AND " + COLUMN4 + " = " + "'" + drinksExpensesWhen + "'";

//        return query;

        return null;
    }

    public String toString() {

        return this.getClass().getName();
    }
}