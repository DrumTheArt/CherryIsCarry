package com.wachs.main.dataBaseLayer.DBQueries;

public class QueryGeneratorFood {

    public static final String TABLENAME = "TBL_FOOD";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "INT_nights";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_house";


    public String queryFindOneData(String name, int id_house) {return null;}

    public String queryFindOneData(int id_guest, int id_house) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + id_guest + " AND " + COLUMN4 + " = " +id_house;

        return query;
    }

    public String queryInsertData(int id_guest, int id_house, int nights) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + "'" + nights + "'" + "," + id_guest + "," + id_house + ")";

        return query;
    }

    public String queryDeleteData(int id_guest, int id_house) {
        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + id_guest + " AND " + COLUMN4 + " = " + id_house;

        return query;
    }

    public String queryUpdateData(int id_guest, int id_house, int newNights) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + newNights + " WHERE " + COLUMN3 + " = "  + id_guest + " AND " + COLUMN4 + " = " + id_house;

        return query;
    }

    public String queryReadAllData() {

        String query = "SELECT * FROM " + TABLENAME;

        return query;
    }

}
