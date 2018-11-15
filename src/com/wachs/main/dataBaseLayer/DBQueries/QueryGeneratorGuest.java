package com.wachs.main.dataBaseLayer.DBQueries;

public class QueryGeneratorGuest {

    public static final String TABLENAME = "TBL_GUEST";
    public static String COLUMN1 = "PK_id";
    public static String COLUMN2 = "ID_house";
    public static String COLUMN3 = "TXT_name";


    public String queryFindOneData(String name, int id_house) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + "'" + name + "'" + " AND " + COLUMN2 + " = " + id_house;

        return query;
    }

    public String queryReadAllData() {

        String query = "SELECT * FROM " + TABLENAME;


        return query;
    }

    public String queryInsertData(int id_house, String name) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + ") VALUES (? ," + id_house + "," + "'" + name + "'" + ")";

        return query;
    }

    public String queryUpdateData(int oldId, String newName, int id_house) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN3 + " = " + "'" + newName + "'" + " WHERE " + COLUMN1 + "=" + oldId + " AND " + COLUMN2 + " =" + id_house;

        return query;
    }

    public String queryDeleteData(String name, int id_house) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + "'" + name + "'" + " AND " + COLUMN2 + "=" + id_house;

        return query;
    }

    public String queryfindOneDataWhereHouseID(int id_house) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN2 + " =" + id_house;

        return query;

    }

}
