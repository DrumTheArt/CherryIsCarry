package com.wachs.main.dataAcess.dBQueryGenerators;

public class QueryGeneratorPrepaid {

    public static final String TABLENAME = "TBL_PREPAID";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_prepaid";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_house";

    public String queryReadAllData() {

        String query = "SELECT * FROM " + TABLENAME;

        return query;
    }

    public String queryFindOneData(int id_guest, int id_house) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + id_guest + " AND " + COLUMN4 + " = " +id_house;

        return query;
    }

    public String queryInsertData(int id_guest, int id_house, int nights) {
        return null;
    }

    public String queryDeleteData(int id_guest, int id_house) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + id_guest + " AND " + COLUMN4 + " = " + id_house;

        return query;
    }

    public String queryInsertData(int id_guest, int id_house, double spend, String reason, String when) {
        return null;
    }

    public String queryUpdateData(int id_guest, int id_house, double spend, String reason, String when) {
        return null;
    }

    public String queryInsertData(int id_guest, int id_house, double prepaid) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ,"  + prepaid  + "," + id_guest + "," + id_house + ")";

        return query;
    }

    public String queryUpdateData(int id_guest, int id_house, double prepaid) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + prepaid + " WHERE " + COLUMN3 + " = "  + id_guest + " AND " + COLUMN4 + " = " + id_house;

        return query;

    }
}
