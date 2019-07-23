package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorOtherExpenses {

    public static final String TABLENAME = "TBL_OTHEREXPENSE";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_spend";
    public static String COLUMN3 = "TXT_reason";
    public static String COLUMN4 = "TXT_when";
    public static String COLUMN5 = "ID_guest";
    public static String COLUMN6 = "ID_project";

    public String fetchQueryAllOtherExpensesOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN6 + " = " + idProject;

        return query;
    }

    public String fetchQueryOtherExpensesOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + ", " + COLUMN5 + ", " + COLUMN6 + " from " + TABLENAME + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " +idProject;

        return query;
    }

    public String deleteQueryOtherExpensesOneGuest(int idGuest, int idProject, double otherExpensesPrice, String otherExpensesReason, String otherExpensesWhen) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN5 + "=" + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + otherExpensesPrice + " AND " + COLUMN3 + " = " + "'" + otherExpensesReason + "'" + " AND " + COLUMN4 + " = " + "'" + otherExpensesWhen + "'";

        return query;
    }

    public String insertQueryOtherExpensesOneGuest(int idGuest, int idProject, double otherExpensesSpend, String otherExpensesReason, String otherExpensesWhen) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + "," + COLUMN5 + "," + COLUMN6 + ") VALUES (? ," + otherExpensesSpend + "," + "'" + otherExpensesReason + "'" + "," + "'" + otherExpensesWhen + "'" + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String updateQueryOtherExpensesOneGuest(int idGuest, int idProject, double otherExpensesPrice, String otherExpensesReason, String otherExpensesWhen, double otherExpensesNewPrice, String otherExpensesNewReason, String otherExpensesNewWhen) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + otherExpensesNewPrice + " ," + COLUMN3 + "=" + "'" + otherExpensesNewReason + "'" + " ," + COLUMN4 + " = " + "'" + otherExpensesNewWhen + "'" + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + otherExpensesPrice + " AND " + COLUMN3 + " = " + "'" + otherExpensesReason + "'" + " AND " + COLUMN4 + " = " + "'" + otherExpensesWhen + "'";

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}