package com.wachs.main.dataBaseLayer.DBQueries;

public class QueryGeneratorExpense {

    public static final String TABLENAME = "TBL_EXPENSE";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_spend";
    public static String COLUMN3 = "TXT_reason";
    public static String COLUMN4 = "TXT_when";
    public static String COLUMN5 = "ID_guest";
    public static String COLUMN6 = "ID_house";

    public String queryReadAllData() {

        String query = "SELECT * FROM " + TABLENAME;

        return query;
    }

    public String queryFindOneData(int id_guest, int id_house) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + ", " + COLUMN5 + ", " + COLUMN6 + " from " + TABLENAME + " WHERE " + COLUMN5 + " = " + id_guest + " AND " + COLUMN6 + " = " +id_house;

        return query;
    }

    public String queryDeleteData(int id_guest, int id_house) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN5 + "=" + id_guest + " AND " + COLUMN6 + " = " + id_house;

        return query;
    }

    public String queryInsertData(int id_guest, int id_house, double spend, String reason, String when) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + "," + COLUMN5 + "," + COLUMN6 + ") VALUES (? ," + spend +  "," + "'" + reason + "'" + "," + when + "," + id_guest + "," + id_house + ")";

        return query;
    }

    public String queryUpdateData(int id_guest, int id_house, double spend, String reason, String when) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + spend + " ," +  COLUMN3  + "=" + "'" + reason + "'" + " ,"  + COLUMN4  + " = " + "'" + when + "'" + " WHERE " + COLUMN5 + " = "  + id_guest + " AND " + COLUMN6 + " = " + id_house;

        return query;
    }

}
