package com.wachs.main.dataAcess.dBQueryGenerators;

public class QueryGeneratorExpense {

    public static final String TABLENAME = "TBL_EXPENSE";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_spend";
    public static String COLUMN3 = "TXT_reason";
    public static String COLUMN4 = "TXT_when";
    public static String COLUMN5 = "ID_guest";
    public static String COLUMN6 = "ID_house";

    public String queryFindAllExpensesByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + "where " + COLUMN6 + " = " + idProject;

        return query;
    }

    public String queryFindExpensesByOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + ", " + COLUMN5 + ", " + COLUMN6 + " from " + TABLENAME + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " +idProject;

        return query;
    }

    public String queryDeleteExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN5 + "=" + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + price + " AND " + COLUMN3 + " = " + "'" + reason + "'" + " AND " + COLUMN4 + " = " + "'" + when + "'";

        return query;
    }

    public String queryInsertData(int idGuest, int idProject, double spend, String reason, String when) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + "," + COLUMN5 + "," + COLUMN6 + ") VALUES (? ," + spend + "," + "'" + reason + "'" + "," + "'" + when + "'" + "," + idGuest + "," + idProject + ")";

        return query;

    }

    public String queryUpdateData(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + newPrice + " ," + COLUMN3 + "=" + "'" + newReason + "'" + " ," + COLUMN4 + " = " + "'" + newWhen + "'" + " WHERE " + COLUMN5 + " = " + idGuest + " AND " + COLUMN6 + " = " + idProject + " AND " + COLUMN2 + " = " + price + " AND " + COLUMN3 + " = " + "'" + reason + "'" + " AND " + COLUMN4 + " = " + "'" + when + "'";

        return query;
    }

}